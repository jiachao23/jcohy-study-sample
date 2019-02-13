#  Java JUC
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## Java JUC
> * [Java NIO简介](#gaishu)
> *  [volatile关键字](#volatile)
> *  [CAS算法](#CAS)
> *  [ConcurrentHashMap 锁分段机制](#ConcurrentHashMap)
> *  [CountDownLatch 闭锁)](#CountDownLatch)
> *  [实现Callable 接口](#Callable)
> *  [Lock 同步锁](#Lock)
> *  [Condition 控制线程通信](#Condition)
> *  [线程按序交替](#jiaoti)
> *  [ReadWriteLock 读写锁](#ReadWriteLock)
> *  [线程八锁](#enight)
> *  [线程池](#ExecutorPool)
> *  [线程调度](#ExecutorService)
> *  [ForkJoinPool 分支/合并框架工作窃取](#ForkJoinPool)

<p id="gaishu"></p>

#### Java NIO简介
在Java 5.0 提供了java.util.concurrent（简称JUC ）包，在此包中增加了在并发编程中很常用的实用工具类，用于定义类似于线程的自定义子系统，包括线程池、异步IO 和轻量级任务框架。提供可调的、灵活的线程池。还提供了设计用于多线程上下文中的Collection 实现等。

<p id="volatile"></p>

#### volatile关键字

在了解volatile关键之前，我们先了解几个概念：

> 内存可见性（Memory Visibility）：是指当某个线程正在使用对象状态而另一个线程在同时修改该状态，需要确保当一个线程修改了对象状态后，其他线程能够看到发生的状态变化。

> 可见性错误：是指当读操作与写操作在不同的线程中执行时，我们无法确保执行读操作的线程能适时地看到其他线程写入的值，有时甚至是根本不可能的事情。


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


#### volatile的性能

volatile变量的读操作性能消耗和普通变量差不多，但是写操作可能相对慢一些，因为它需要在本地代码中插入许多内存屏障指令以确保处理器不发生乱序执行。大多数情况下，volatile总开销比锁低，但我们要注意volatile的语义能否满足使用场景。

<p id="CAS"></p>

#### CAS算法

- CAS (Compare-And-Swap) 是一种硬件对并发的支持，针对多处理器操作而设计的处理器中的一种特殊指令，用于管理对共享数据的并发访问。
- CAS 是一种无锁的非阻塞算法的实现。
- CAS 包含了3 个操作数：
  - 需要读写的内存值V
  - 进行比较的值A
  - 拟写入的新值B

- 当且仅当V 的值等于A 时，CAS 通过原子方式用新值B 来更新V 的值，否则不会执行任何操作。

<p id="volatilevar"></p>

####  原子变量
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

`private volatile int value;`

首先使用volatile关键字声明了 value变量，即不存在内存可见性的问题。

```java
     /**
     * Atomically sets the value to the given updated value
     * if the current value {@code ==} the expected value.
     *
     * @param expect the expected value
     * @param update the new value
     * @return {@code true} if successful. False return indicates that
     * the actual value was not equal to the expected value.
     */
    public final boolean compareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

```

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

##### ABA问题

什么是ABA问题？

假如一个线程想要对变量count进行修改，实际操作之前获取count的值为A，此时来了一个线程将count值修改为B，又来一个线程获取count的值为B并将count修改为A，此时第一个线程全然不知道count的值已经被修改两次了，虽然值还是A，但是实际上数据已经是脏的。

一个解决办法是，对count的每次操作都记录下当前的一个时间戳，这样当我们原子操作count之前，不仅查看count的最新数值，还记录下该count的时间戳，在实际操作的时候，只有在count的数值和时间戳都没有被更改的情况之下才完成修改操作。

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

- 第四种获取线程的方法：线程池，一个ExecutorService，它使用可能的几个池线程之一执行每个提交的任务，通常使用Executors 工厂方法配置。
- 线程池可以解决两个不同问题：由于减少了每个任务调用的开销，它们通常可以在执行大量异步任务时提供增强的性能，并且还可以提供绑定和管理资源（包括执行任务集时使用的线程）的方法。每个ThreadPoolExecutor 还维护着一些基本的统计数据，如完成的任务数。
- 为了便于跨大量上下文使用，此类提供了很多可调整的参数和扩展钩子(hook)。但是，强烈建议程序员使用较为方便的Executors 工厂方法：
- Executors.newCachedThreadPool()（无界线程池，可以进行自动线程回收）
- Executors.newFixedThreadPool(int)（固定大小线程池）
- Executors.newSingleThreadExecutor()（单个后台线程）
- 它们均为大多数使用场景预定义了设置。

<p id="ExecutorService"></p>

#### 线程调度

一个ExecutorService，可安排在给定的延迟后运行或定期执行的命令。

<p id="ForkJoinPool"></p>

#### ForkJoinPool 分支/合并框架工作窃取

Fork/Join 框架：就是在必要的情况下，将一个大任务，进行拆分(fork)成若干个小任务（拆到不可再拆时），再将一个个的小任务运算的结果进行join 汇总。

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/91bd78d2d059f56b2090ea52e53e61b194788628/jcohy-study-java/src/main/resources/static/images/13.jpg)

- 采用“工作窃取”模式（work-stealing）：

  当执行新的任务时它可以将其拆分分成更小的任务执行，并将小任务加到线程队列中，然后再从一个随机线程的队列中偷一个并把它放在自己的队列中。

- 相对于一般的线程池实现，fork/join框架的优势体现在对其中包含的任务的处理方式上.在一般的线程池中，如果一个线程正在执行的任务由于某些原因无法继续运行，那么该线程会处于等待状态。而在fork/join框架实现中，如果某个子问题由于等待另外一个子问题的完成而无法继续运行。那么处理该子问题的线程会主动寻找其他尚未运行的子问题来执行.这种方式减少了线程的等待时间，提高了性能。








#### 



