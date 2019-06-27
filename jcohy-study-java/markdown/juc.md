#  Java JUC
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## Java JUC
> * [Java NIO简介](#gaishu)
> * [volatile关键字](#volatile)
> * [CAS算法](#CAS)
> * [ConcurrentHashMap 锁分段机制](#ConcurrentHashMap)
> * [CountDownLatch 闭锁)](#CountDownLatch)
> * [CyclicBarrier](#CyclicBarrier)
> * [Semaphore](#Semaphore)
> * [实现Callable 接口](#Callable)
> * [Lock 同步锁](#Lock)
> * [Condition 控制线程通信](#Condition)
> * [线程按序交替](#jiaoti)
> * [ReadWriteLock 读写锁](#ReadWriteLock)
> * [线程八锁](#enight)
> * [线程池](#ExecutorPool)
> * [线程调度](#ExecutorService)
> * [ForkJoinPool 分支/合并框架工作窃取](#ForkJoinPool)
> * [死锁编码及定位分析](#sisuo)

<p id="gaishu"></p>

#### Java JUC简介
在Java 5.0 提供了java.util.concurrent（简称JUC ）包，在此包中增加了在并发编程中很常用的实用工具类，用于定义类似于线程的自定义子系统，包括线程池、异步IO 和轻量级任务框架。提供可调的、灵活的线程池。还提供了设计用于多线程上下文中的Collection 实现等。

<p id="volatile"></p>

#### volatile关键字

在了解volatile关键之前，我们先了解几个概念：

> 内存可见性（Memory Visibility）：是指当某个线程正在使用对象状态而另一个线程在同时修改该状态，需要确保当一个线程修改了对象状态后，其他线程能够看到发生的状态变化。

> 可见性错误：是指当读操作与写操作在不同的线程中执行时，我们无法确保执行读操作的线程能适时地看到其他线程写入的值，有时甚至是根本不可能的事情。

> 内存屏障：又称内存栅栏，是一个CPU指令，主要有两个作用：1.保证特定操作的执行顺序。2，保证某些变量的内存可见性。

由于编译器和处理器都能执行指令重排优化。如果在指令间插入一天Memory Barrier则会告诉编译器和CPU，不管什么指令都不能和Memory Barrier指令重排序，也就是说通过插入内存屏障禁止在内存屏障前后的指令执行重排序优化。
内存屏障的另外一个作用是强制刷出各种CPU缓存数据，因此任何CPU上的线程都能读取到这些数据的最新版本。

 ![JMM](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-java/images/volatile读写.jpg)


##### volatile的定义
java语言规范第三版中对volatile的定义：Java编程语言允许线程访问共享变量，为了确保共享变量能被准确和一致地更新，线程应该确保通过排他锁单独获得这个变量。java语言提供了volatile，在某些情况下比锁更加方便，而且他不会引起线程 上下文的切换和调度。
如果一个字段被声明成volatile,java内存模型确保所有线程看到这个变量的值是一致的。

volatile 看做一个轻量级的锁，但是又与锁有些不同：

> * 对于多线程，不是一种互斥关系
> * 不能保证变量状态的“原子性操作”，例如count++

#### volatile简介

Java 语言提供了一种稍弱的同步机制,即`volatile`变量.用来确保将变量的更新操作通知到其他线程,保证了新值能立即同步到主内存,以及每次使用前立即从主内存刷新。 当把变量声明为volatile类型后,编译器与运行时都会注意到这个变量是共享的。`volatile`修饰变量,每次被线程访问时强迫其从主内存重读该值,修改后再写回。保证读取的可见性,对其他线程立即可见。`volatile`的另一个语义是禁止指令重排序优化。但是`volatile`并不保证原子性,也就不能保证线程安全。

##### volatile语义

第一是保证volatile修饰的变量对所有线程的可见性

第二条语义是禁止指令重排序优化

关于第一点：根据JMM，所有的变量存储在主内存，而每个线程还有自己的工作内存，线程的工作内存保存该线程使用到的变量的主内存副本拷贝，线程对变量的操作在工作内存中进行，不能直接读写主内存的变量。在volatile可见性这一点上，普通变量做不到的原因正因如此。比如，线程A修改了一个普通变量的值，然后向主内存进行回写，线程B在线程A回写完成后再从主内存读取，新变量才能对线程B可见。其实，按照虚拟机规范，volatile变量依然有工作内存的拷贝，要借助主内存来实现可见性。但由于volatile的特殊规则保证了新值能立即同步回主内存，以及每次使用从主内存刷新，以此保证了多线程操作volatile变量的可见性。

关于第二点：先说指令重排序，指令重排序是指CPU采用了允许将多条指令不按规定顺序分开发送给相应的处理单元处理，但并不是说任意重排，CPU需要正确处理指令依赖情况确保最终的正确结果，指令重排序是机器级的优化操作。那么为什么volatile要禁止指令重排序呢，又是如何去做的。举例，DCL（双重检查加锁）的单例模式。volatile修饰后，代码中将会插入许多内存屏障指令保证处理器不发生乱序执行。同时由于Happens-before规则的保证，在刚才的例子中写操作会发生在后续的读操作之前。

除了以上2点，volatile还保证对于64位long和double的读取是原子性的。因为在JMM中允许虚拟机对未被volatile修饰的64位的long和double读写操作分为2次32位的操作来执行，这也就是所谓的long和double的非原子性协定。

基于以上几点，我们知道volatile虽然有这些语义和特性在并发的情况下仍然不能保证线程安全。大部分情况下仍然需要加锁。

除非是以下2种情况，1.运算结果不依赖变量的当前值，或者能够确保只有单一线程修改变量的值；2.变量不需要与其他的状态变量共同参与不变约束。


##### volatile的性能

volatile变量的读操作性能消耗和普通变量差不多，但是写操作可能相对慢一些，因为它需要在本地代码中插入许多内存屏障指令以确保处理器不发生乱序执行。大多数情况下，volatile总开销比锁低，但我们要注意volatile的语义能否满足使用场景。

##### volatile使用

- 单例模式DCL(双重检测加锁)
> [单例模式(Singleton)](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-designpattern/markdown/Singleton.md)


<p id="CAS"></p>

#### CAS算法

- CAS (Compare-And-Swap) 是一种硬件对并发的支持，它是一条CPU并发原语。针对多处理器操作而设计的处理器中的一种特殊指令，用于管理对共享数据的并发访问。
- CAS 是一种无锁的非阻塞算法的实现。
- CAS 包含了3 个操作数：
  - 需要读写的内存值V
  - 进行比较的值A
  - 拟写入的新值B

- 当且仅当V 的值等于A 时，CAS 通过原子方式用新值B 来更新V 的值，否则不会执行任何操作。

<p id="volatilevar"></p>

#####  原子变量
原子变量保证了该变量的所有操作都是原子的，不会因为多线程的同时访问而导致脏数据的读取问题。
java.util.concurrent.atomic 包下提供了一些原子操作的常用类:

| 类 | 说明 |
| ----------------------- | ---- |
| AtomicBoolean           | 基于Boolean类型 |
| AtomicInteger           | 基于Integer类型 |
| AtomicLong              | 基于Long类型 |
| AtomicReference         | 基于引用类型 |
| AtomicIntegerArray      | 基于Integer数组类型 |
| AtomicLongArray         | 基于Long数组类型 |
| AtomicMarkableReference | 基于引用类型 |
| AtomicReferenceArray | 基于引用数组类型 |
| AtomicStampedReference | 基于引用类型 |

以**AtomicInteger为例**看一看其内部实现原理：

首先使用volatile关键字声明了 value变量，即不存在内存可见性的问题。

```java
    private static final long serialVersionUID = 6214790243416807050L;

    // setup to use Unsafe.compareAndSwapInt for updates
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                (AtomicInteger.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    private volatile int value;
    ...
    ...
    ...
    
    /**
     * Atomically increments by one the current value.
     *  @Param this:当前对象
     * @Param valueOffset 内存偏移量（内存地址）
     * @return the previous value
     */
    public final int getAndIncrement() {
        return unsafe.getAndAddInt(this, valueOffset, 1);
    }
```

```java

    /**
     *  var1：AtomicInteger对象本身
     *  var2：该对象值的引用地址
     *  var4：需要变动的数量
     *  var5：是通过var，var2找出的主内存中的真实的值
     *  用对象当前的值与var5比较
     *  如果相同，更新var5+var4并返回true
     *  如果不相同，继续取值然后再比较，直到更新完成
     */
   public final int getAndAddInt(Object var1, long var2, int var4) {
        int var5;
        do {
            var5 = this.getIntVolatile(var1, var2);
        } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

        return var5;
    }
```
其底层调用了UnSafe类，什么是UnSafe类？
- UnSafe类
UnSafe类是CAS的核心类，由于Java方法无法直接访问底层系统，需要通过本地（native）方法来访问，UnSafe相当于一个后门，基于该类可以直接操作特定内存的数据，UnSafe类存在于sun.misc包中，
其内部方法的操作可以像C的指针一样直接操作内存，因为Java中的CAS操作的执行依赖于UnSafe类的方法。
注意UnSafe类的所有方法都是native修饰的，也就是说UnSafe类中的方法都直接调用操作系统底层资源执行相应任务。

- 变量valueOffset，表该变量值在内存中的偏移地址，因为UnSafe就是根据内存偏移地址获取数据的。
- Value是用volatile修饰的，保证类多线程之间的内存可见性。

compareAndSet方法又被称为CAS，unsafe.compareAndSwapInt这个方法是native，我们看不到源码，但是我们需要知道该方法完成的一个目标：比较当前原子变量的值是否等于expect，如果是则将其修改为update并返回true，否则直接返回false。当然，这个操作本身就是原子的，较为底层的实现。

```java
/*
 * 一、i++ 的原子性问题：i++ 的操作实际上分为三个步骤“读-改-写”
 *          int i = 10;
 *          i = i++; //10
 * 
 *          int temp = i;
 *          i = i + 1;
 *          i = temp;
 * 
 * 二、原子变量：在 java.util.concurrent.atomic 包下提供了一些原子变量。
 *        1. volatile 保证内存可见性
 *        2. CAS（Compare-And-Swap） 算法保证数据变量的原子性
 *           CAS 算法是硬件对于并发操作的支持
 *           CAS 包含了三个操作数：
 *           ①内存值  V
 *           ②预估值  A
 *           ③更新值  B
 *           当且仅当 V == A 时， V = B; 否则，不会执行任何操作。
 */
public class TestAtomicDemo {

   public static void main(String[] args) {
      AtomicDemo ad = new AtomicDemo();
      
      for (int i = 0; i < 10; i++) {
         new Thread(ad).start();
      }
   }
   
}

class AtomicDemo implements Runnable{
   
// private volatile int serialNumber = 0;
   
   private AtomicInteger serialNumber = new AtomicInteger(0);

   @Override
   public void run() {
      
      try {
         Thread.sleep(200);
      } catch (InterruptedException e) {
      }
      
      System.out.println(getSerialNumber());
   }
   
   public int getSerialNumber(){
      return serialNumber.getAndIncrement();
   }
   
   
}
```
##### CAS缺点

- 循环时间长开销很大、如果CAS失败，会一直进行尝试，如果长时间一直不成功，可能会给CPU带来很大的开销
- 只能对一个共享变量的原子操作
- 引出来ABA问题

##### ABA问题

什么是ABA问题？

假如一个线程想要对变量count进行修改，实际操作之前获取count的值为A，此时来了一个线程将count值修改为B，又来一个线程获取count的值为B并将count修改为A，此时第一个线程全然不知道count的值已经被修改两次了，虽然值还是A，但是实际上数据已经是脏的。

一个解决办法是，对count的每次操作都记录下当前的一个时间戳，这样当我们原子操作count之前，不仅查看count的最新数值，还记录下该count的时间戳，在实际操作的时候，只有在count的数值和时间戳都没有被更改的情况之下才完成修改操作。
JUC提供了一个类实现带版本号的原子引用。AtomicStampedReference

<p id="ConcurrentHashMap"></p>

#### ConcurrentHashMap 锁分段机制

- Java 5.0 在java.util.concurrent 包中提供了多种并发容器类来改进同步容器的性能。
- ConcurrentHashMap 同步容器类是Java 5 增加的一个线程安全的哈希表。对与多线程的操作，介于HashMap 与Hashtable 之间。内部采用“锁分段”机制替代Hashtable 的独占锁。进而提高性能。
- 此包还提供了设计用于多线程上下文中的Collection 实现：ConcurrentHashMap、ConcurrentSkipListMap、ConcurrentSkipListSet、CopyOnWriteArrayList 和CopyOnWriteArraySet。当期望许多线程访问一个给定collection 时，ConcurrentHashMap 通常优于同步的HashMap，ConcurrentSkipListMap 通常优于同步的TreeMap。当期望的读数和遍历远远大于列表的更新数时，CopyOnWriteArrayList 优于同步的ArrayList。

<p id="CountDownLatch"></p>

#### CountDownLatch 闭锁

- Java 5.0 在java.util.concurrent 包中提供了多种并发容器类来改进同步容器的性能。
- CountDownLatch 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
- 闭锁可以延迟线程的进度直到其到达终止状态，闭锁可以用来确保某些活动直到其他活动都完成才继续执行：
  - 确保某个计算在其需要的所有资源都被初始化之后才继续执行;
  - 确保某个服务在其依赖的所有其他服务都已经启动之后才启动;
  - 等待直到某个操作所有参与者都准备就绪再继续执行。

<p id="CyclicBarrier"></p>

#### CyclicBarrier

CyclicBarrier的字面意思是可循环使用的屏障。他要做的事情是，让一组线程到达一个屏障时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活，线程进入屏障通过CyclicBarrier的await()方法。

代码示例：参考github

<p id="Semaphore"></p>

#### Semaphore

Semaphore主要用于两个目的，一个用于多个共享资源的互斥使用，另外一个用于并发线程数的控制。

代码示例：参考github

<p id="Callable"></p>

#### 实现Callable 接口

- Java 5.0 在java.util.concurrent 提供了一个新的创建执行线程的方式：Callable 接口
- Callable 接口类似于Runnable，两者都是为那些其实例可能被另一个线程执行的类设计的。但是Runnable 不会返回结果，并且无法抛出经过检查的异常。
- Callable 需要依赖FutureTask ，FutureTask 也可以用作闭锁。

<p id="Lock"></p>

#### Lock 同步锁

- 在Java 5.0 之前，协调共享对象的访问时可以使用的机制只有synchronized 和volatile 。Java 5.0 后增加了一些新的机制，但并不是一种替代内置锁的方法，而是当内置锁不适用时，作为一种可选择的高级功能。
- ReentrantLock 实现了Lock 接口，并提供了与synchronized 相同的互斥性和内存可见性。但相较于synchronized 提供了更高的处理锁的灵活性。

<p id="Condition"></p>

#### Condition 控制线程通信

- Condition 接口描述了可能会与锁有关联的条件变量。这些变量在用法上与使用Object.wait 访问的隐式监视器类似，但提供了更强大的功能。需要特别指出的是，单个Lock 可能与多个Condition 对象关联。为了避免兼容性问题，Condition 方法的名称与对应的Object 版本中的不同。
- 在Condition 对象中，与wait、notify 和notifyAll 方法对应的分别是await、signal 和signalAll。
- Condition 实例实质上被绑定到一个锁上。要为特定Lock 实例获得Condition 实例，请使用其newCondition() 方法。

<p id="jiaoti"></p>

#### 线程按序交替

编写一个程序，开启3 个线程，这三个线程的ID 分别为A、B、C，每个线程将自己的ID 在屏幕上打印10 遍，要求输出的结果必须按顺序显示。
如：ABCABCABC…… 依次递归

<p id="ReadWriteLock"></p>

#### ReadWriteLock 读写锁

- ReadWriteLock 维护了一对相关的锁，一个用于只读操作，另一个用于写入操作。只要没有writer，读取锁可以由多个reader 线程同时保持。写入锁是独占的。。
- ReadWriteLock 读取操作通常不会改变共享资源，但执行写入操作时，必须独占方式来获取锁。对于读取操作占多数的数据结构。ReadWriteLock 能提供比独占锁更高的并发性。而对于只读的数据结构，其中包含的不变性可以完全不需要考虑加锁操作。

<p id="enight"></p>

#### 线程八锁

- 一个对象里面如果有多个synchronized方法，某一个时刻内，只要一个线程去调用其中的一个synchronized方法了，其它的线程都只能等待，换句话说，某一个时刻内，只能有唯一一个线程去访问这些synchronized方法
- 锁的是当前对象this，被锁定后，其它的线程都不能进入到当前对象的其它的synchronized方法
- 加个普通方法后发现和同步锁无关
- 换成两个对象后，不是同一把锁了，情况立刻变化。
- 都换成静态同步方法后，情况又变化
- 所有的非静态同步方法用的都是同一把锁——实例对象本身，也就是说如果一个实例对象的非静态同步方法获取锁后，该实例对象的其他非静态同步方法必须等待获取锁的方法释放锁后才能获取锁，可是别的实例对象的非静态同步方法因为跟该实例对象的非静态同步方法用的是不同的锁，所以毋须等待该实例对象已获取锁的非静态同步方法释放锁就可以获取他们自己的锁。
- 所有的静态同步方法用的也是同一把锁——类对象本身，这两把锁是两个不同的对象，所以静态同步方法与非静态同步方法之间是不会有竞态条件的。但是一旦一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取锁，而不管是同一个实例对象的静态同步方法之间，还是不同的实例对象的静态同步方法之间，只要它们同一个类的实例对象！

<p id="ExecutorsPool"></p>

#### 线程池

第四种获取线程的方法：线程池，一个ExecutorService，它使用可能的几个池线程之一执行每个提交的任务，通常使用Executors 工厂方法配置。

线程池可以解决两个不同问题：由于减少了每个任务调用的开销，它们通常可以在执行大量异步任务时提供增强的性能，并且还可以提供绑定和管理资源（包括执行任务集时使用的线程）的方法。每个ThreadPoolExecutor 还维护着一些基本的统计数据，如完成的任务数。

为了便于跨大量上下文使用，此类提供了很多可调整的参数和扩展钩子(hook)。但是，强烈建议程序员使用较为方便的Executors 工厂方法：

- Executors.newCachedThreadPool()（无界线程池，可以进行自动线程回收）
- Executors.newFixedThreadPool(int)（固定大小线程池）
- Executors.newSingleThreadExecutor()（单个后台线程）
- Executors.newScheduledThreadPool()
- Executors.newWorkStealingPool(int)（java8新增，使用目前机器上可用的处理器作为它的并行级别）
  它们均为大多数使用场景预定义了设置。

##### 线程池7大参数简介
ThreadPoolExecutor

```java
public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
    return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                  60L, TimeUnit.SECONDS,
                                  new SynchronousQueue<Runnable>(),
                                  threadFactory);
}

public static ExecutorService newSingleThreadExecutor() {
    return new FinalizableDelegatedExecutorService
        (new ThreadPoolExecutor(1, 1,
                                0L, TimeUnit.MILLISECONDS,
                                new LinkedBlockingQueue<Runnable>()));
}
public static ExecutorService newFixedThreadPool(int nThreads) {
    return new ThreadPoolExecutor(nThreads, nThreads,
                                  0L, TimeUnit.MILLISECONDS,
                                  new LinkedBlockingQueue<Runnable>());
}
```
```java
public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue,
                          RejectedExecutionHandler handler) {
    this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
         Executors.defaultThreadFactory(), handler);
}

public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue,
                          ThreadFactory threadFactory,
                          RejectedExecutionHandler handler) {
    if (corePoolSize < 0 ||
        maximumPoolSize <= 0 ||
        maximumPoolSize < corePoolSize ||
        keepAliveTime < 0)
        throw new IllegalArgumentException();
    if (workQueue == null || threadFactory == null || handler == null)
        throw new NullPointerException();
    this.corePoolSize = corePoolSize;
    this.maximumPoolSize = maximumPoolSize;
    this.workQueue = workQueue;
    this.keepAliveTime = unit.toNanos(keepAliveTime);
    this.threadFactory = threadFactory;
    this.handler = handler;
}
```

- corePoolSize:线程池中的常驻核心线程数。

- maximumPoolSize:线程池能够容纳同时执行的最大线程数，此值必须大于等于1。

- keepAliveTime:多余的空闲线程的存活时间。当前线程池数量超过corePoolSize时，当空闲时间达到keepAliveTime值时，多余空闲线程会被销毁直到只剩下corePoolSize个线程为止。

- unit:keepAliveTime的单位。

- BlockingQueue:任务队列，被提交但尚未被执行的任务。

- ThreadFactory:表示生成线程池中工作线程的线程工厂，用于创建线程一般用默认即可。

- RejectedExecutionHandler:拒绝策略，表示当队列满了并且工作线程大于等于线程池的最大线程(maximumPoolSize)时如何来拒绝请求执行的runnable的策略。

##### 线程池底层工作原理

![线程池工作原理](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-java/images/线程池工作原理.jpg)



##### 线程池的拒绝策略

等待队列满了且线程池中的max线程也达到了，这时候就需要拒绝策略机制来处理这个问题。

- AbortPolicy：直接抛出RejectedExecutionException异常阻止系统正常运行。
- CallerRunsPolicy：“调用者运行 ”一种调节机制，该策略既不会抛弃任务，也不会抛弃异常，而是将某些任务回退给调用者，从未降低新任务的流量。
- DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加入队列中尝试再次提交当前任务。
- DiscardPolicy：直接丢弃任务，不予任何处理也不抛异常。如果允许任务丢失，这是最好的一种方法。

##### 手写线程池

线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。 说明：Executors各个方法的弊端：
1）newFixedThreadPool和newSingleThreadExecutor:
  主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
2）newCachedThreadPool和newScheduledThreadPool:
  主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。

```java
//Positive example 1：
//org.apache.commons.lang3.concurrent.BasicThreadFactory
ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                                                                           new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());



//Positive example 2：
ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
    .setNameFormat("demo-pool-%d").build();

//Common Thread Pool
ExecutorService pool = new ThreadPoolExecutor(5, 200,
                                              0L, TimeUnit.MILLISECONDS,
                                              new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

pool.execute(()-> System.out.println(Thread.currentThread().getName()));
pool.shutdown();//gracefully shutdown


//Positive example 3：
<bean id="userThreadPool"
    class="org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor">
       <property name="corePoolSize" value="10" />
        <property name="maxPoolSize" value="100" />
        <property name="queueCapacity" value="2000" />


        <property name="threadFactory" value= threadFactory />
        <property name="rejectedExecutionHandler">
        <ref local="rejectedExecutionHandler" />
        </property>
</bean>
//in code
userThreadPool.execute(thread); 
```

##### 如何合理的配置线程池

- CPU密集型：任务配置尽可能少的线程数量。一般公式：CPU核数+1个线程的线程池
- IO密集型：1、CPU核数*2.。2、CPU核数/（1-阻塞系数）。这个阻塞系数一般在0.8~0.9之间。

#### 线程调度

一个ExecutorService，可安排在给定的延迟后运行或定期执行的命令。

<p id="ForkJoinPool"></p>

#### ForkJoinPool 分支/合并框架工作窃取

Fork/Join 框架：就是在必要的情况下，将一个大任务，进行拆分(fork)成若干个小任务（拆到不可再拆时），再将一个个的小任务运算的结果进行join 汇总。

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/91bd78d2d059f56b2090ea52e53e61b194788628/jcohy-study-java/src/main/resources/static/images/13.jpg)

- 采用“工作窃取”模式（work-stealing）：

  当执行新的任务时它可以将其拆分分成更小的任务执行，并将小任务加到线程队列中，然后再从一个随机线程的队列中偷一个并把它放在自己的队列中。

- 相对于一般的线程池实现，fork/join框架的优势体现在对其中包含的任务的处理方式上.在一般的线程池中，如果一个线程正在执行的任务由于某些原因无法继续运行，那么该线程会处于等待状态。而在fork/join框架实现中，如果某个子问题由于等待另外一个子问题的完成而无法继续运行。那么处理该子问题的线程会主动寻找其他尚未运行的子问题来执行.这种方式减少了线程的等待时间，提高了性能。

<p id="sisuo"></p>

#### 死锁编码及定位分析

死锁是指两个或者两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力干涉那它们将无法推进下去，如果系统资源充足，进程的资源请求都能够满足，死锁出现的可能性就很低。否则就会因争夺有限的资源而陷入死锁。

##### 编码

```java
class HoldLoadThread implements Runnable{
    private String lockA;
    private String lockB;

    public HoldLoadThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockA+"\t 尝试获得："+lockB);
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockB+"\t 尝试获得："+lockA);

            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLoadThread(lockA,lockB),"ThreadAAA").start();
        new Thread(new HoldLoadThread(lockB,lockA),"ThreadBBB").start();

    }
}
```

##### 定位分析

JPS命令定位进程号

```shell
E:\workspace\IdeaProjects\jcohy-study-sample-master>jps
10784 RemoteMavenServer
11696 Launcher
9488
9876 DeadLockDemo
1240 Jps
```

jstack找到死锁查看

```shell
E:\workspace\IdeaProjects\jcohy-study-sample-master>jstack 9876
2019-04-19 13:30:43
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.91-b14 mixed mode):

"DestroyJavaVM" #13 prio=5 os_prio=0 tid=0x000000000275e000 nid=0x3304 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"ThreadBBB" #12 prio=5 os_prio=0 tid=0x0000000018f3d000 nid=0x940 waiting for monitor entry [0x0000000019bff000]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at com.jcohy.study.juc.HoldLoadThread.run(DeadLockDemo.java:28)
        - waiting to lock <0x00000000d5b04308> (a java.lang.String)
        - locked <0x00000000d5b04340> (a java.lang.String)
        at java.lang.Thread.run(Thread.java:745)

"ThreadAAA" #11 prio=5 os_prio=0 tid=0x0000000018f39000 nid=0x2b44 waiting for monitor entry [0x0000000019aff000]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at com.jcohy.study.juc.HoldLoadThread.run(DeadLockDemo.java:28)
        - waiting to lock <0x00000000d5b04340> (a java.lang.String)
        - locked <0x00000000d5b04308> (a java.lang.String)
        at java.lang.Thread.run(Thread.java:745)

"Service Thread" #10 daemon prio=9 os_prio=0 tid=0x0000000018efb800 nid=0x23e4 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C1 CompilerThread2" #9 daemon prio=9 os_prio=2 tid=0x0000000018ece000 nid=0x1a64 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread1" #8 daemon prio=9 os_prio=2 tid=0x0000000018e6d000 nid=0x31bc waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread0" #7 daemon prio=9 os_prio=2 tid=0x0000000018e67000 nid=0x1c8c waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Monitor Ctrl-Break" #6 daemon prio=5 os_prio=0 tid=0x0000000018e44800 nid=0x21dc runnable [0x00000000194fe000]
   java.lang.Thread.State: RUNNABLE
        at java.net.SocketInputStream.socketRead0(Native Method)
        at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
        at java.net.SocketInputStream.read(SocketInputStream.java:170)
        at java.net.SocketInputStream.read(SocketInputStream.java:141)
        at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
        at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
        at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
        - locked <0x00000000d5a8ca60> (a java.io.InputStreamReader)
        at java.io.InputStreamReader.read(InputStreamReader.java:184)
        at java.io.BufferedReader.fill(BufferedReader.java:161)
        at java.io.BufferedReader.readLine(BufferedReader.java:324)
        - locked <0x00000000d5a8ca60> (a java.io.InputStreamReader)
        at java.io.BufferedReader.readLine(BufferedReader.java:389)
        at com.intellij.rt.execution.application.AppMainV2$1.run(AppMainV2.java:64)

"Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x0000000017a8e000 nid=0x294c waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x0000000018e08800 nid=0x2b78 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Finalizer" #3 daemon prio=8 os_prio=1 tid=0x0000000017a6a800 nid=0xe54 in Object.wait() [0x0000000018dff000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000000d5908ee0> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
        - locked <0x00000000d5908ee0> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
        at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)

"Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x0000000002eb2000 nid=0x1d98 in Object.wait() [0x0000000018cff000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000000d5906b50> (a java.lang.ref.Reference$Lock)
        at java.lang.Object.wait(Object.java:502)
        at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
        - locked <0x00000000d5906b50> (a java.lang.ref.Reference$Lock)
        at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

"VM Thread" os_prio=2 tid=0x0000000017a47000 nid=0x9ac runnable

"GC task thread#0 (ParallelGC)" os_prio=0 tid=0x0000000002dd6800 nid=0x1efc runnable

"GC task thread#1 (ParallelGC)" os_prio=0 tid=0x0000000002dd9000 nid=0x2c64 runnable

"GC task thread#2 (ParallelGC)" os_prio=0 tid=0x0000000002ddb000 nid=0x2af0 runnable

"GC task thread#3 (ParallelGC)" os_prio=0 tid=0x0000000002ddc800 nid=0x15a0 runnable

"VM Periodic Task Thread" os_prio=2 tid=0x0000000018f24000 nid=0x1ab8 waiting on condition

JNI global references: 33

# Found one Java-level deadlock:

"ThreadBBB":
  waiting to lock monitor 0x0000000002ebc928 (object 0x00000000d5b04308, a java.lang.String),
  which is held by "ThreadAAA"
"ThreadAAA":
  waiting to lock monitor 0x0000000002eba098 (object 0x00000000d5b04340, a java.lang.String),
  which is held by "ThreadBBB"

# Java stack information for the threads listed above:

"ThreadBBB":
        at com.jcohy.study.juc.HoldLoadThread.run(DeadLockDemo.java:28)
        - waiting to lock <0x00000000d5b04308> (a java.lang.String)
        - locked <0x00000000d5b04340> (a java.lang.String)
        at java.lang.Thread.run(Thread.java:745)
"ThreadAAA":
        at com.jcohy.study.juc.HoldLoadThread.run(DeadLockDemo.java:28)
        - waiting to lock <0x00000000d5b04340> (a java.lang.String)
        - locked <0x00000000d5b04308> (a java.lang.String)
        at java.lang.Thread.run(Thread.java:745)

Found 1 deadlock.
```

