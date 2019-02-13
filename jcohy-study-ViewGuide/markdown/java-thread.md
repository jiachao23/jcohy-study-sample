
#  Java
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## Java线程相关
> * [Thread类的sleep()方法和对象的wait()方法都可以让线程暂停执行，它们有什么区别?](#thread-1)
> * [线程的sleep()方法和yield()方法有什么区别？](#thread-2)
> * [当一个线程进入一个对象的synchronized方法A之后，其它线程是否可进入此对象的synchronized方法B？](#thread-3)
> * [请说出与线程同步以及线程调度相关的方法。](#thread-4)
> * [编写多线程程序有几种实现方式？](#thread-5)
> * [synchronized关键字的用法？](#thread-6)
> * [举例说明同步和异步。](#thread-7)
> * [启动一个线程是调用run()还是start()方法？](#thread-8)
> * [什么是线程池（thread pool）？](#thread-9)
> * [线程的基本状态以及状态之间的关系？](#thread-10)
> * [简述synchronized 和java.util.concurrent.locks.Lock的异同？](#thread-11)
> * [volatile关键字？](#thread-12)
> * [10 个线程和 2 个线程的同步代码，哪个更容易写？](#thread-13)
> * [你是如何调用 wait（）方法的？使用 if 块还是循环？为什么？](#thread-14)
> * [什么是多线程环境下的伪共享（false sharing）？](#thread-15)
> * [ThreadLocal简介](#thread-16)
> * [线程局部变量原理](#thread-17)
> * [JDK提供的用于并发编程的同步器](#thread-18)
> * [什么是 Busy spin？我们为什么要使用它？](#thread-19)
> * [Java 中怎么获取一份线程 dump 文件？](#thread-20)
> * [Swing 是线程安全的？](#thread-21)
> * [用 wait-notify 写一段代码来解决生产者-消费者问题？](#thread-22)
> * [用 Java 写一个线程安全的单例模式（Singleton）？](#thread-23)
> * [Java 中，编写多线程程序的时候你会遵循哪些最佳实践？](#thread-24)
> * [说出至少 5 点在 Java 中使用线程的最佳实践](#thread-25)
> * [在多线程环境下，SimpleDateFormat 是线程安全的吗？](#thread-26)
> * [Happens-Before规则](#thread-27)
> * [Java 中 Runnable 和 Callable 有什么不同？](#thread-28)
> * [Java 中 CyclicBarrier 和 CountDownLatch 有什么不同？](#thread-29)
> * [Java 内存模型是什么？](#thread-30)
> * [什么是线程安全？Vector 是一个线程安全类吗？](#thread-31)
> * [Java 中什么是竞态条件？ 举个例子说明。](#thread-32)
> * [Java 中如何停止一个线程？](#thread-33)
> * [一个线程运行时发生异常会怎样？](#thread-34)
> * [如何在两个线程间共享数据？](#thread-35)
> * [Java 中 notify 和 notifyAll 有什么区别？](#thread-36)
> * [为什么 wait, notify 和 notifyAll 这些方法不在 thread 类里面？](#thread-37)
> * [什么是 FutureTask？](#thread-38)
> * [Java 中 interrupted 和 isInterruptedd 方法的区别？](#thread-39)
> * [为什么 wait 和 notify 方法要在同步块中调用？](#thread-40)
> * [为什么你应该在循环中检查等待条件？](#thread-41)
> * [Java 中的同步集合与并发集合有什么区别？](#thread-42)
> * [有三个线程 T1，T2，T3，怎么确保它们按顺序执行？](#thread-43)
> * [如何写代码来解决生产者消费者问题？](#thread-44)
> * [如何避免死锁？？](#thread-45)
> * [Java 中活锁和死锁有什么区别？](#thread-46)
> * [怎么检测一个线程是否拥有锁？](#thread-47)
> * [你如何在 Java 中获取线程堆栈？](#thread-48)
> * [Java 中 synchronized 和 ReentrantLock 有什么不同？](#thread-49)
> * [Java 中 Semaphore是什么？](#thread-50)
> * [如果你提交任务时，线程池队列已满。会发会生什么？](#thread-51)
> * [Java 线程池中 submit () 和 execute ()方法有什么区别？](#thread-52)
> * [什么是阻塞式方法？](#thread-53)
> * [Java 中 invokeAndWait 和 invokeLater 有什么区别？](#thread-54)
> * [Swing API 中那些方法是线程安全的？](#thread-55)
> * [如何在 Java 中创建 Immutable 对象？](#thread-56)
> * [Java 中的 ReadWriteLock 是什么？](#thread-57)
> * [多线程中的忙循环是什么？](#thread-58)
> * [volatile 变量和 atomic 变量有什么不同？](#thread-59)
> * [如果同步块内的线程抛出异常会发生什么？](#thread-60)
> * [如何强制启动一个线程？](#thread-61)
> * [Java 中的 fork join 框架是什么？](#thread-62)
> * [可重入锁](#thread-63)
> * [同步方法和同步代码块](#thread-64)


<p id="thread-1">

#### Thread类的sleep()方法和对象的wait()方法都可以让线程暂停执行，它们有什么区别?

sleep()方法（休眠）是线程类（Thread）的静态方法，调用此方法会让当前线程暂停执行指定的时间，将执行机会（CPU）让给其他线程，但是对象的锁依然保持，因此休眠时间结束后会自动恢复（线程回到就绪状态，请参考[线程的基本状态以及状态之间的关系？](#9)线程状态转换图）。wait()是Object类的方法，调用对象的wait()方法导致当前线程放弃对象的锁（线程暂停执行），进入对象的等待池（wait pool），只有调用对象的notify()方法（或notifyAll()方法）时才能唤醒等待池中的线程进入等锁池（lock pool），如果线程重新获得对象的锁就可以进入就绪状态。
补充：可能不少人对什么是进程，什么是线程还比较模糊，对于为什么需要多线程编程也不是特别理解。简单的说：进程是具有一定独立功能的程序关于某个数据集合上的一次运行活动，是操作系统进行资源分配和调度的一个独立单位；线程是进程的一个实体，是CPU调度和分派的基本单位，是比进程更小的能独立运行的基本单位。线程的划分尺度小于进程，这使得多线程程序的并发性高；进程在执行时通常拥有独立的内存单元，而线程之间可以共享内存。使用多线程的编程通常能够带来更好的性能和用户体验，但是多线程的程序对于其他程序是不友好的，因为它可能占用了更多的CPU资源。当然，也不是线程越多，程序的性能就越好，因为线程之间的调度和切换也会浪费CPU时间。时下很时髦的Node.js就采用了单线程异步I/O的工作模式。

<p id="thread-2">

#### 线程的sleep()方法和yield()方法有什么区别？

1. sleep()方法给其他线程运行机会时不考虑线程的优先级，因此会给低优先级的线程以运行的机会；yield()方法只会给相同优先级或更高优先级的线程以运行的机会； 

2. 线程执行sleep()方法后转入阻塞（blocked）状态，而执行yield()方法后转入就绪（ready）状态；

3.  sleep()方法声明抛出InterruptedException，而yield()方法没有声明任何异常； 

4. sleep()方法比yield()方法（跟操作系统CPU调度相关）具有更好的可移植性。

<p id="thread-3">

#### 当一个线程进入一个对象的synchronized方法A之后，其它线程是否可进入此对象的synchronized方法B？

不能。其它线程只能访问该对象的非同步方法，同步方法则不能进入。因为非静态方法上的synchronized修饰符要求执行方法时要获得对象的锁，如果已经进入A方法说明对象锁已经被取走，那么试图进入B方法的线程就只能在等锁池（注意不是等待池哦）中等待对象的锁。

<p id="thread-4">

#### 请说出与线程同步以及线程调度相关的方法。

- wait()：使一个线程处于等待（阻塞）状态，并且释放所持有的对象的锁。
- sleep()：使一个正在运行的线程处于睡眠状态，是一个静态方法，调用此方法要处理InterruptedException异常。
- notify()：唤醒一个处于等待状态的线程，当然在调用此方法的时候，并不能确切的唤醒某一个等待状态的线程，而是由JVM确定唤醒哪个线程，而且与优先级无关。
- notityAll()：唤醒所有处于等待状态的线程，该方法并不是将对象的锁给所有线程，而是让它们竞争，只有获得锁的线程才能进入就绪状态。
  补充：Java 5通过Lock接口提供了显式的锁机制（explicit lock），增强了灵活性以及对线程的协调。Lock接口中定义了加锁（lock()）和解锁（unlock()）的方法，同时还提供了newCondition()方法来产生用于线程之间通信的Condition对象；此外，Java 5还提供了信号量机制（semaphore），信号量可以用来限制对某个共享资源进行访问的线程的数量。在对资源进行访问之前，线程必须得到信号量的许可（调用Semaphore对象的acquire()方法）；在完成对资源的访问后，线程必须向信号量归还许可（调用Semaphore对象的release()方法）。
下面的例子演示了100个线程同时向一个银行账户中存入1元钱，在没有使用同步机制和使用同步机制情况下的执行情况。
  银行账户类：

```java
/**
* 银行账户
* @author 骆昊
*
*/
public class Account {
    private double balance; // 账户余额
    /**
     * 存款
     * @param money 存入金额
     */
    public void deposit(double money) {
        double newBalance = balance + money;
        try {
            Thread.sleep(10); // 模拟此业务需要一段处理时间
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        balance = newBalance;
    }
    /**
	 * 获得账户余额
	 */
    public double getBalance() {
        return balance;
    }
}

```
存钱线程类：
```java
/**
* 存钱线程
* @author 骆昊
*
*/
public class AddMoneyThread implements Runnable {
    private Account account; // 存入账户
    private double money; // 存入金额
    public AddMoneyThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }
    @Override
    public void run() {
        account.deposit(money);
    }
}
```

测试类：

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Test01 {
    public static void main(String[] args) {
        Account account = new Account();
        ExecutorService service = Executors.newFixedThreadPool(100);
        for(int i = 1; i <= 100; i++) {
            service.execute(new AddMoneyThread(account, 1));
        }
        service.shutdown();
        while(!service.isTerminated()) {}
        System.out.println("账户余额: " + account.getBalance());
    }
}
```
在没有同步的情况下，执行结果通常是显示账户余额在10元以下，出现这种状况的原因是，当一个线程A试图存入1元的时候，另外一个线程B也能够进入存款的方法中，线程B读取到的账户余额仍然是线程A存入1元钱之前的账户余额，因此也是在原来的余额0上面做了加1元的操作，同理线程C也会做类似的事情，所以最后100个线程执行结束时，本来期望账户余额为100元，但实际得到的通常在10元以下（很可能是1元哦）。解决这个问题的办法就是同步，当一个线程对银行账户存钱时，需要将此账户锁定，待其操作完成后才允许其他的线程进行操作，代码有如下几种调整方案：
在银行账户的存款（deposit）方法上同步（synchronized）关键字

```java
/**
* 银行账户
* @author 骆昊
*
*/
public class Account {
    private double balance; // 账户余额
    /**
    * 存款
    * @param money 存入金额
    */
    public synchronized void deposit(double money) {
        double newBalance = balance + money;
        try {
            Thread.sleep(10); // 模拟此业务需要一段处理时间
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        balance = newBalance;
    }
    /**
	* 获得账户余额
	*/
    public double getBalance() {
        return balance;
    }
}
```
在线程调用存款方法时对银行账户进行同步
```java
/**
* 存钱线程
* @author 骆昊
*
*/
public class AddMoneyThread implements Runnable {
    private Account account; // 存入账户
    private double money; // 存入金额
    public AddMoneyThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }
    @Override
    public void run() {
        synchronized (account) {
            account.deposit(money);
        }
    }
}
```
通过Java 5显示的锁机制，为每个银行账户创建一个锁对象，在存款操作进行加锁和解锁的操作
```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
* 银行账户
*
* @author 骆昊
*
*/
public class Account {
    private Lock accountLock = new ReentrantLock();
    private double balance; // 账户余额
    /**
* 存款
*
* @param money
* 存入金额
*/
    public void deposit(double money) {
        accountLock.lock();
        try {
            double newBalance = balance + money;
            try {
                Thread.sleep(10); // 模拟此业务需要一段处理时间
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            balance = newBalance;
        }
        finally {
            accountLock.unlock();
        }
    }
    /**
* 获得账户余额
*/
    public double getBalance() {
        return balance;
    }
}
```

按照上述三种方式对代码进行修改后，重写执行测试代码Test01，将看到最终的账户余额为100元。当然也可以使用Semaphore或CountdownLatch来实现同步。

<p id="thread-5">

#### 编写多线程程序有几种实现方式？

Java 5以前实现多线程有两种实现方法：一种是继承Thread类；另一种是实现Runnable接口。两种方式都要通过重写run()方法来定义线程的行为，推荐使用后者，因为Java中的继承是单继承，一个类有一个父类，如果继承了Thread类就无法再继承其他类了，显然使用Runnable接口更为灵活。
补充：Java 5以后创建线程还有第三种方式：实现Callable接口，该接口中的call方法可以在线程执行结束时产生一个返回值，代码如下所示：

```java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
class MyTask implements Callable<Integer> {
    private int upperBounds;
    public MyTask(int upperBounds) {
        this.upperBounds = upperBounds;
    }
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 1; i <= upperBounds; i++) {
            sum += i;
        }
        return sum;
    }
}
class Test {
    public static void main(String[] args) throws Exception {
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++) {
            list.add(service.submit(new MyTask((int) (Math.random() * 100))));
        }
        int sum = 0;
        for(Future<Integer> future : list) {
            // while(!future.isDone()) ;
            sum += future.get();
        }
        System.out.println(sum);
    }
}
```

<p id="thread-6">

#### synchronized关键字的用法？

synchronized关键字可以将对象或者方法标记为同步，以实现对对象和方法的互斥访问，可以用synchronized(对象) { … }定义同步代码块，或者在声明方法时将synchronized作为方法的修饰符。在上面的例子中已经展示了synchronized关键字的用法。

<p id="thread-7">

#### 举例说明同步和异步。

如果系统中存在临界资源（资源数量少于竞争资源的线程数量的资源），例如正在写的数据以后可能被另一个线程读到，或者正在读的数据可能已经被另一个线程写过了，那么这些数据就必须进行同步存取（数据库操作中的排他锁就是最好的例子）。当应用程序在对象上调用了一个需要花费很长时间来执行的方法，并且不希望让程序等待方法的返回时，就应该使用异步编程，在很多情况下采用异步途径往往更有效率。事实上，所谓的同步就是指阻塞式操作，而异步就是非阻塞式操作。

<p id="thread-8">

#### 启动一个线程是调用run()还是start()方法？

启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM 调度并执行，这并不意味着线程就会立即运行。run()方法是线程启动后要进行回调（callback）的方法。

<p id="thread-9">

#### 什么是线程池（thread pool）？

在面向对象编程中，创建和销毁对象是很费时间的，因为创建一个对象要获取内存资源或者其它更多资源。在Java中更是如此，虚拟机将试图跟踪每一个对象，以便能够在对象销毁后进行垃圾回收。所以提高服务程序效率的一个手段就是尽可能减少创建和销毁对象的次数，特别是一些很耗资源的对象创建和销毁，这就是”池化资源”技术产生的原因。线程池顾名思义就是事先创建若干个可执行的线程放入一个池（容器）中，需要的时候从池中获取线程不用自行创建，使用完毕不需要销毁线程而是放回池中，从而减少创建和销毁线程对象的开销。Java 5+中的Executor接口定义一个执行线程的工具。它的子类型即线程池接口是ExecutorService。要配置一个线程池是比较复杂的，尤其是对于线程池的原理不是很清楚的情况下，因此在工具类Executors面提供了一些静态工厂方法，生成一些常用的线程池，如下所示： 

- newSingleThreadExecutor：创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
- newFixedThreadPool：创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。

- newCachedThreadPool：创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
- newScheduledThreadPool：创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
- newSingleThreadExecutor：创建一个单线程的线程池。此线程池支持定时以及周期性执行任务的需求。

<p id="thread-10">

#### 线程的基本状态以及状态之间的关系？

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/1.jpg)

说明：其中Running表示运行状态，Runnable表示就绪状态（万事俱备，只欠CPU），Blocked表示阻塞状态，阻塞状态又有多种情况，可能是因为调用wait()方法进入等待池，也可能是执行同步方法或同步代码块进入等锁池，或者是调用了sleep()方法或join()方法等待休眠或其他线程结束，或是因为发生了I/O中断。

<p id="thread-11">

#### 简述synchronized 和java.util.concurrent.locks.Lock的异同？

Lock是Java 5以后引入的新的API，和关键字synchronized相比主要相同点：Lock 能完成synchronized所实现的所有功能；主要不同点：Lock有比synchronized更精确的线程语义和更好的性能，而且不强制性的要求一定要获得锁。synchronized会自动释放锁，而Lock一定要求程序员手工释放，并且最好在finally 块中释放（这是释放外部资源的最好的地方）。

<p id="thread-12">

#### volatile关键字？

[详情参考](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-java/markdown/juc.md#volatile)


<p id="thread-13">

#### 10 个线程和 2 个线程的同步代码，哪个更容易写？

从写代码的角度来说，两者的复杂度是相同的，因为同步代码与线程数量是相互独立的。但是同步策略的选择依赖于线程的数量，因为越多的线程意味着更大的竞争，所以你需要利用同步技术，如锁分离，这要求更复杂的代码和专业知识。

<p id="thread-14">

#### 你是如何调用 wait（）方法的？使用 if 块还是循环？为什么？

wait() 方法应该在循环调用，因为当线程获取到 CPU 开始执行的时候，其他条件可能还没有满足，所以在处理前，循环检测条件是否满足会更好。下面是一段标准的使用 wait 和 notify 方法的代码：

```java

// The standard idiom for using the wait method
synchronized (obj) {
    while (condition does not hold)
        obj.wait(); // (Releases lock, and reacquires on wakeup)
    ... // Perform action appropriate to condition
}

```

参见 Effective Java 第 69 条，获取更多关于为什么应该在循环中来调用 wait 方法的内容。

<p id="thread-15">

#### 什么是多线程环境下的伪共享（false sharing）？

伪共享是多线程系统（每个处理器有自己的局部缓存）中一个众所周知的性能问题。伪共享发生在不同处理器的上的线程对变量的修改依赖于相同的缓存行，如下图所示：

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/9.gif)


伪共享问题很难被发现，因为线程可能访问完全不同的全局变量，内存中却碰巧在很相近的位置上。如其他诸多的并发问题，避免伪共享的最基本方式是仔细审查代码，根据缓存行来调整你的数据结构。

<p id="thread-16">

#### ThreadLocal简介

1. ThreadLocal解决了变量并发访问的冲突问题


当使用ThreadLocal维护变量时,ThreadLocal为每个使用该变量的线程提供独立的变量副本,每个线程都可以独立地改变自己的副本,而不会影响其它线程所对应的副本,是线程隔离的。线程隔离的秘密在于ThreadLocalMap类(ThreadLocal的静态内部类)

2. 与synchronized同步机制的比较

首先,它们都是为了解决多线程中相同变量访问冲突问题。不过,在同步机制中,要通过对象的锁机制保证同一时间只有一个线程访问该变量。该变量是线程共享的, 使用同步机制要求程序缜密地分析什么时候对该变量读写, 什么时候需要锁定某个对象, 什么时候释放对象锁等复杂的问题,程序设计编写难度较大, 是一种“以时间换空间”的方式。

而ThreadLocal采用了以“以空间换时间”的方式。

<p id="thread-17">

#### 线程局部变量原理

当使用ThreadLocal维护变量时,ThreadLocal为每个使用该变量的线程提供独立的变量副本,每个线程都可以独立地改变自己的副本,而不会影响其它线程所对应的副本,是线程隔离的。线程隔离的秘密在于ThreadLocalMap类(ThreadLocal的静态内部类)

线程局部变量是局限于线程内部的变量，属于线程自身所有，不在多个线程间共享。Java 提供 ThreadLocal 类来支持线程局部变量，是一种实现线程安全的方式。但是在管理环境下（如 web 服务器）使用线程局部变量的时候要特别小心，在这种情况下，工作线程的生命周期比任何应用变量的生命周期都要长。任何线程局部变量一旦在工作完成后没有释放，Java 应用就存在内存泄露的风险。

ThreadLocal的方法：void set(T value)、T get()以及T initialValue()。

ThreadLocal是如何为每个线程创建变量的副本的：

首先，在每个线程Thread内部有一个ThreadLocal.ThreadLocalMap类型的成员变量threadLocals，这个threadLocals就是用来存储实际的变量副本的，键值为当前ThreadLocal变量，value为变量副本（即T类型的变量）。初始时，在Thread里面，threadLocals为空，当通过ThreadLocal变量调用get()方法或者set()方法，就会对Thread类中的threadLocals进行初始化，并且以当前ThreadLocal变量为键值，以ThreadLocal要保存的副本变量为value，存到threadLocals。然后在当前线程里面，如果要使用副本变量，就可以通过get方法在threadLocals里面查找。

总结：

1. 实际的通过ThreadLocal创建的副本是存储在每个线程自己的threadLocals中的

2. 为何threadLocals的类型ThreadLocalMap的键值为ThreadLocal对象，因为每个线程中可有多个threadLocal变量，就像上面代码中的longLocal和stringLocal；

3. 在进行get之前，必须先set，否则会报空指针异常；如果想在get之前不需要调用set就能正常访问的话，必须重写initialValue()方法

<p id="thread-18">

#### JDK提供的用于并发编程的同步器

1. `Semaphore` Java并发库的Semaphore可以很轻松完成信号量控制，Semaphore可以控制某个资源可被同时访问的个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
2. `CyclicBarrier` 主要的方法就是一个：await()。await()方法每被调用一次，计数便会减少1，并阻塞住当前线程。当计数减至0时，阻塞解除，所有在此CyclicBarrier上面阻塞的线程开始运行。
3. `CountDownLatch` 直译过来就是倒计数(CountDown)门闩(Latch)。倒计数不用说，门闩的意思顾名思义就是阻止前进。在这里就是指 CountDownLatch.await() 方法在倒计数为0之前会阻塞当前线程。

<p id="thread-19">

#### 什么是 Busy spin？我们为什么要使用它？

Busy spin 是一种在不释放 CPU 的基础上等待事件的技术。它经常用于避免丢失 CPU 缓存中的数据（如果线程先暂停，之后在其他CPU上运行就会丢失）。所以，如果你的工作要求低延迟，并且你的线程目前没有任何顺序，这样你就可以通过循环检测队列中的新消息来代替调用 sleep() 或 wait() 方法。它唯一的好处就是你只需等待很短的时间，如几微秒或几纳秒。LMAX 分布式框架是一个高性能线程间通信的库，该库有一个 BusySpinWaitStrategy 类就是基于这个概念实现的，使用 busy spin 循环 EventProcessors 等待屏障。

<p id="thread-20">

####  Java 中怎么获取一份线程 dump 文件？

在 Linux 下，你可以通过命令 kill -3 PID （Java 进程的进程 ID）来获取 Java 应用的 dump 文件。在 Windows 下，你可以按下 Ctrl + Break 来获取。这样 JVM 就会将线程的 dump 文件打印到标准输出或错误文件中，它可能打印在控制台或者日志文件中，具体位置依赖应用的配置。



<p id="thread-21">

#### Swing 是线程安全的？

不是，Swing 不是线程安全的。你不能通过任何线程来更新 Swing 组件，如 JTable、JList 或 JPanel，事实上，它们只能通过 GUI 或 AWT 线程来更新。这就是为什么 Swing 提供 invokeAndWait() 和 invokeLater() 方法来获取其他线程的 GUI 更新请求。这些方法将更新请求放入 AWT 的线程队列中，可以一直等待，也可以通过异步更新直接返回结果。

<p id="thread-22">

#### 用 wait-notify 写一段代码来解决生产者-消费者问题？

记住在同步块中调用 wait() 和 notify()方法，如果阻塞，通过循环来测试等待条件。

<p id="thread-23">

####  用 Java 写一个线程安全的单例模式（Singleton）？

当我们说线程安全时，意思是即使初始化是在多线程环境中，仍然能保证单个实例。Java 中，使用枚举作为单例类是最简单的方式来创建线程安全单例模式的方式。

<p id="thread-24">

#### Java 中，编写多线程程序的时候你会遵循哪些最佳实践？

这是我在写Java 并发程序的时候遵循的一些最佳实践：

a）给线程命名，这样可以帮助调试。

b）最小化同步的范围，而不是将整个方法同步，只对关键部分做同步。

c）如果可以，更偏向于使用 volatile 而不是 synchronized。

d）使用更高层次的并发工具，而不是使用 wait() 和 notify() 来实现线程间通信，如 BlockingQueue，CountDownLatch 及 Semeaphore。

e）优先使用并发集合，而不是对集合进行同步。并发集合提供更好的可扩展性。

<p id="thread-25">

####  说出至少 5 点在 Java 中使用线程的最佳实践。

这个问题与之前的问题类似，你可以使用上面的答案。对线程来说，你应该：

a）对线程命名

b）将线程和任务分离，使用线程池执行器来执行 Runnable 或 Callable。

c）使用线程池

<p id="thread-26">

#### 在多线程环境下，SimpleDateFormat 是线程安全的吗？

不是，非常不幸，DateFormat 的所有实现，包括 SimpleDateFormat 都不是线程安全的，因此你不应该在多线程序中使用，除非是在对外线程安全的环境中使用，如将 SimpleDateFormat 限制在 ThreadLocal 中。如果你不这么做，在解析或者格式化日期的时候，可能会获取到一个不正确的结果。因此，从日期、时间处理的所有实践来说，我强力推荐 joda-time 库。

<p id="thread-27">

#### Happens-Before规则

- 程序次序规则：按控制流顺序先后发生

- 管程锁定规则：一个unlock操作先行发生于后面对同一个锁的lock操作

- volatile变量规则：对一个volatile变量的写操作先行发生于后面对这个变量的读操作

- 线程启动规则：start方法先行发生于线程的每一个动作

- 线程中断规则：对线程的interrupt方法调用先行发生于被中断线程的代码检测到中断时间的发生

- 线程终止规则：线程内的所有操作都先行发生于对此线程的终止检测

- 对象终结规则：一个对象的初始化完成先行发生于它的finalize方法的开始

- 传递性 ：如果A先行发生于操作B，B先行发生于操作C，则A先行发生于操作C

<p id="thread-28">

####  Java 中 Runnable 和 Callable 有什么不同

Runnable和 Callable 都代表那些要在不同的线程中执行的任务。Runnable 从 JDK1.0 开始就有了，Callable 是在 JDK1.5 增加的。它们的主要区别是 Callable 的 call () 方法可以返回值和抛出异常，而 Runnable 的 run ()方法没有这些功能。

<p id="thread-29">

#### Java 中 CyclicBarrier 和 CountDownLatch 有什么不同

它们都是JUC下的类，CyclicBarrier 和 CountDownLatch 都可以用来让一组线程等待其它线程。区别在于CountdownLatch计数无法被重置。如果需要重置计数，请考虑使用 CyclicBarrier。 

<p id="thread-30">

####  Java 内存模型是什么

Java 内存模型规定和指引Java 程序在不同的内存架构、CPU 和操作系统间有确定性地行为。它在多线程的情况下尤其重要。Java内存模型对一个线程所做的变动能被其它线程可见提供了保证，它们之间是先行发生关系。这个关系定义了一些规则让程序员在并发编程时思路更清晰。

线程内的代码能够按先后顺序执行，这被称为程序次序规则。

对于同一个锁，一个解锁操作一定要发生在时间上后发生的另一个锁定操作之前，也叫做管程锁定规则。

前一个对volatile的写操作在后一个volatile的读操作之前，也叫volatile变量规则。

一个线程内的任何操作必需在这个线程的 start ()调用之后，也叫作线程启动规则。

一个线程的所有操作都会在线程终止之前，线程终止规则。

一个对象的终结操作必需在这个对象构造完成之后，也叫对象终结规则。

a先行于b，b先行于c，传递性

<p id="thread-31">

#### 什么是线程安全？Vector 是一个线程安全类吗

如果你的代码所在的进程中有多个线程在同时运行，而这些线程可能会同时运行这段代码。如果每次运行结果和单线程运行的结果是一样的，而且其他的变量的值也和预期的是一样的，就是线程安全的。一个线程安全的计数器类的同一个实例对象在被多个线程使用的情况下也不会出现计算失误。很显然你可以将集合类分成两组，线程安全和非线程安全的。Vector 是用同步方法来实现线程安全的，而和它相似的 ArrayList 不是线程安全的。

<p id="thread-32">

#### Java 中什么是竞态条件？ 举个例子说明。

竞态条件会导致程序在并发情况下出现一些 bugs。多线程对一些资源的竞争的时候就会产生竞态条件，如果首先要执行的程序竞争失败排到后面执行了，那么整个程序就会出现一些不确定的 bugs。这种 bugs 很难发现而且会重复出现，因为线程间的随机竞争。几类竞态条件check-and-act、读取-修改-写入、put-if-absent。

<p id="thread-33">

####  Java 中如何停止一个线程

当 run () 或者 call () 方法执行完的时候线程会自动结束，如果要手动结束一个线程，你可以用 volatile 布尔变量来退出 run ()方法的循环或者是取消任务来中断线程。其他情形：异常 - 停止执行 休眠 - 停止执行 阻塞 - 停止执行

<p id="thread-34">

####  一个线程运行时发生异常会怎样

简单的说，如果异常没有被捕获该线程将会停止执行。Thread.UncaughtExceptionHandler 是用于处理未捕获异常造成线程突然中断情况的一个内嵌接口。当一个未捕获异常将造成线程中断的时候 JVM 会使用 Thread.getUncaughtExceptionHandler ()来查询线程的 UncaughtExceptionHandler 并将线程和异常作为参数传递给 handler 的 uncaughtException ()方法进行处理。

<p id="thread-35">

#### 如何在两个线程间共享数据？

通过共享对象来实现这个目的，或者是使用像阻塞队列这样并发的数据结构

<p id="thread-36">

####  Java 中 notify 和 notifyAll 有什么区别

notify ()方法不能唤醒某个具体的线程，所以只有一个线程在等待的时候它才有用武之地。而 notifyAll ()唤醒所有线程并允许他们争夺锁确保了至少有一个线程能继续运行。

<p id="thread-37">

#### 为什么 wait, notify 和 notifyAll 这些方法不在 thread 类里面

一个很明显的原因是 JAVA 提供的锁是对象级的而不是线程级的。如果线程需要等待某些锁那么调用对象中的 wait ()方法就有意义了。如果 wait ()方法定义在 Thread 类中，线程正在等待的是哪个锁就不明显了。简单的说，由于 wait，notify 和 notifyAll 都是锁级别的操作，所以把他们定义在 Object 类中因为锁属于对象。

<p id="thread-38">

#### 什么是 FutureTask？

在 Java 并发程序中 FutureTask 表示一个可以取消的异步运算。它有启动和取消运算、查询运算是否完成和取回运算结果等方法。只有当运算完成的时候结果才能取回，如果运算尚未完成 get 方法将会阻塞。一个 FutureTask 对象可以对调用了 Callable 和 Runnable 的对象进行包装，由于 FutureTask 也是调用了 Runnable 接口所以它可以提交给 Executor 来执行。

<p id="thread-39">

#### Java 中 interrupted 和 isInterruptedd 方法的区别

interrupted是静态方法，isInterruptedd是一个普通方法

如果当前线程被中断（没有抛出中断异常，否则中断状态就会被清除），你调用interrupted方法，第一次会返回true。然后，当前线程的中断状态被方法内部清除了。第二次调用时就会返回false。如果你刚开始一直调用isInterrupted，则会一直返回true，除非中间线程的中断状态被其他操作清除了。也就是说isInterrupted 只是简单的查询中断状态，不会对状态进行修改。

<p id="thread-40">

#### 为什么 wait 和 notify 方法要在同步块中调用

如果不这么做，代码会抛出 IllegalMonitorStateException异常。还有一个原因是为了避免 wait 和 notify 之间产生竞态条件。

<p id="thread-41">

####  为什么你应该在循环中检查等待条件？

处于等待状态的线程可能会收到错误警报和伪唤醒，如果不在循环中检查等待条件，程序就会在没有满足结束条件的情况下退出。因此，当一个等待线程醒来时，不能认为它原来的等待状态仍然是有效的，在 notify 方法调用之后和等待线程醒来之前这段时间它可能会改变。这就是在循环中使用 wait 方法效果更好的原因。

<p id="thread-42">

#### Java 中的同步集合与并发集合有什么区别

同步集合与并发集合都为多线程和并发提供了合适的线程安全的集合，不过并发集合的可扩展性更高。在 Java1.5 之前程序员们只有同步集合来用且在多线程并发的时候会导致争用，阻碍了系统的扩展性。Java1.5加入了并发集合像 ConcurrentHashMap，不仅提供线程安全还用锁分离和内部分区等现代技术提高了可扩展性。它们大部分位于JUC包下。

<p id="thread-43">

#### 有三个线程 T1，T2，T3，怎么确保它们按顺序执行？

可以用线程类的 join ()方法。具体操作是在T3的run方法中调用t2.join()，让t2执行完再执行t3；T2的run方法中调用t1.join()，让t1执行完再执行t2。这样就按T1，T2，T3的顺序执行了

<p id="thread-44">

####  如何写代码来解决生产者消费者问题？

在现实中你解决的许多线程问题都属于生产者消费者模型，就是一个线程生产任务供其它线程进行消费，你必须知道怎么进行线程间通信来解决这个问题。比较低级的办法是用 wait 和 notify 来解决这个问题，比较赞的办法是用 Semaphore 或者 BlockingQueue 来实现生产者消费者模型。

<p id="thread-45">

#### 如何避免死锁？

死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力作用，它们都将无法推进下去。这是一个严重的问题，因为死锁会让你的程序挂起无法完成任务，死锁的发生必须满足以下四个条件：

互斥条件：一个资源每次只能被一个进程使用。

请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。

不剥夺条件：进程已获得的资源，在末使用完之前，不能强行剥夺。

循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。

避免死锁最简单的方法就是阻止循环等待条件，将系统中所有的资源设置标志位、排序，规定所有的进程申请资源必须以一定的顺序（升序或降序）做操作来避免死锁。

<p id="thread-46">

####  Java 中活锁和死锁有什么区别？

活锁和死锁类似，不同之处在于处于活锁的线程或进程的状态是不断改变的，活锁可以认为是一种特殊的饥饿。一个现实的活锁例子是两个人在狭小的走廊碰到，两个人都试着避让对方好让彼此通过，但是因为避让的方向都一样导致最后谁都不能通过走廊。简单的说就是，活锁和死锁的主要区别是前者进程的状态可以改变但是却不能继续执行。

<p id="thread-47">

####  怎么检测一个线程是否拥有锁

在 java.lang.Thread 中有一个方法叫 holdsLock，当且仅当当前线程拥有某个具体对象的锁时它返回true。

<p id="thread-48">

####  你如何在 Java 中获取线程堆栈

在 Linux 下，你可以通过命令 kill -3 PID （Java 进程的进程 ID）来获取 Java 应用的 dump 文件。在 Windows 下，你可以按下 Ctrl + Break 来获取。这样 JVM 就会将线程的 dump 文件打印到标准输出或错误文件中，它可能打印在控制台或者日志文件中，具体位置依赖应用的配置。

<p id="thread-49">

#### Java 中 synchronized 和 ReentrantLock 有什么不同

Java 在过去很长一段时间只能通过 synchronized 关键字来实现互斥，它有一些缺点。比如你不能扩展锁之外的方法或者块边界，尝试获取锁时不能中途取消等。Java 5 通过 Lock 接口提供了更复杂的控制来解决这些问题。 ReentrantLock 类实现了 Lock，它拥有与 synchronized 相同的并发性和内存语义且它还具有可扩展性。

<p id="thread-50">

#### Java 中 Semaphore是什么

JUC下的一种新的同步类，它是一个计数信号。从概念上讲，Semaphore信号量维护了一个许可集合。如有必要，在许可可用前会阻塞每一个 acquire，然后再获取该许可。每个 release添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。信号量常常用于多线程的代码中，比如数据库连接池。

<p id="thread-51">

#### 如果你提交任务时，线程池队列已满。会发会生什么？

这个问题问得很狡猾，许多程序员会认为该任务会阻塞直到线程池队列有空位。事实上如果一个任务不能被调度执行那么 ThreadPoolExecutor’s submit ()方法将会抛出一个 RejectedExecutionException 异常。

<p id="thread-52">

#### Java 线程池中 submit () 和 execute ()方法有什么区别

两个方法都可以向线程池提交任务，execute ()方法的返回类型是 void，它定义在 Executor 接口中， 而 submit ()方法可以返回持有计算结果的 Future 对象，它定义在 ExecutorService 接口中，它扩展了 Executor 接口，其它线程池类像 ThreadPoolExecutor 和 ScheduledThreadPoolExecutor 都有这些方法。

<p id="thread-53">

#### 什么是阻塞式方法？

阻塞式方法是指程序会一直等待该方法完成期间不做其他事情，ServerSocket 的 accept ()方法就是一直等待客户端连接。这里的阻塞是指调用结果返回之前，当前线程会被挂起，直到得到结果之后才会返回。此外，还有异步和非阻塞式方法在任务完成前就返回。

<p id="thread-54">

#### Java 中 invokeAndWait 和 invokeLater 有什么区别

这两个方法是 Swing API 提供给 Java 开发者用来从当前线程而不是事件派发线程更新 GUI 组件用的。InvokeAndWait ()同步更新 GUI 组件，比如一个进度条，一旦进度更新了，进度条也要做出相应改变。如果进度被多个线程跟踪，那么就调用 invokeAndWait ()方法请求事件派发线程对组件进行相应更新。而 invokeLater ()方法是异步调用更新组件的。

<p id="thread-55">

#### Swing API 中那些方法是线程安全的？

虽然Swing不是线程安全的但是有一些方法是可以被多线程安全调用的。如repaint ()， revalidate ()。 JTextComponent 的 setText ()方法和 JTextArea 的 insert () 和 append () 方法也是线程安全的。

<p id="thread-56">

#### 如何在 Java 中创建 Immutable 对象

Immutable 对象可以在没有同步的情况下共享，降低了对该对象进行并发访问时的同步化开销。可是 Java 没有@Immutable 这个注解符，要创建不可变类，要实现下面几个步骤：通过构造方法初始化所有成员、对变量不要提供 setter 方法、将所有的成员声明为私有的，这样就不允许直接访问这些成员、在 getter 方法中，不要直接返回对象本身，而是克隆对象，并返回对象的拷贝。

<p id="thread-57">

#### Java 中的 ReadWriteLock 是什么？

一般而言，读写锁是用来提升并发程序性能的锁分离技术的成果。Java 中的 ReadWriteLock 是 Java 5 中新增的一个接口，一个 ReadWriteLock 维护一对关联的锁，一个用于只读操作一个用于写。在没有写线程的情况下一个读锁可能会同时被多个读线程持有。写锁是独占的，你可以使用 JDK 中的 ReentrantReadWriteLock 来实现这个规则，它最多支持 65535 个写锁和 65535 个读锁。

<p id="thread-58">

#### 多线程中的忙循环是什么?

忙循环就是程序员用循环让一个线程等待，不像传统方法 wait ()， sleep () 或 yield () 它们都放弃了 CPU 控制，而忙循环不会放弃 CPU，它就是在运行一个空循环。这么做的目的是为了保留 CPU 缓存，在多核系统中，一个等待线程醒来的时候可能会在另一个内核运行，这样会重建缓存。为了避免重建缓存和减少等待重建的时间就可以使用它了。

<p id="thread-59">

#### volatile 变量和 atomic 变量有什么不同

volatile 变量和 atomic 变量看起来很像，但功能却不一样。volatile 变量可以确保先行关系，即写操作会发生在后续的读操作之前， 但它并不能保证原子性。例如用 volatile 修饰 count 变量那么 count++ 操作并不是原子性的。而 AtomicInteger 类提供的 atomic 方法可以让这种操作具有原子性如 getAndIncrement ()方法会原子性的进行增量操作把当前值加一，其它数据类型和引用变量也可以进行相似操作。

<p id="thread-60">

#### 如果同步块内的线程抛出异常会发生什么？

无论你的同步块是正常还是异常退出的，里面的线程都会释放锁，所以对比锁接口我更喜欢同步块，因为它不用我花费精力去释放锁，该功能可以在 finally block 里释放锁实现。

<p id="thread-61">

#### 如何强制启动一个线程？

这个问题就像是如何强制进行 Java 垃圾回收，目前还没有觉得方法，虽然你可以使用 System.gc ()来进行垃圾回收，但是不保证能成功。在 Java 里面没有办法强制启动一个线程，它是被线程调度器控制着且 Java 没有公布相关的 API。

<p id="thread-62">

#### Java 中的 fork join 框架是什么？

fork join 框架是 JDK7 中出现的一款高效的工具，Java 开发人员可以通过它充分利用现代服务器上的多处理器。它是专门为了那些可以递归划分成许多子模块设计的，目的是将所有可用的处理能力用来提升程序的性能。fork join 框架一个巨大的优势是它使用了工作窃取算法，可以完成更多任务的工作线程可以从其它线程中窃取任务来执行。

<p id="thread-63">

#### 可重入锁


可重入锁：如果当前线程已经获得了某个监视器对象所持有的锁，那么该线程在该方法中调用另外一个同步方法也同样持有该锁。

```java
public synchrnozied void test() {
    xxxxxx;
    test2();
}

public synchronized void test2() {
    yyyyy;
}
```

在上面代码段中，执行 test 方法需要获得当前对象作为监视器的对象锁，但方法中又调用了 test2 的同步方法。

如果锁是具有可重入性的话，那么该线程在调用 test2 时并不需要再次获得当前对象的锁，可以直接进入 test2 方法进行操作。

如果锁是不具有可重入性的话，那么该线程在调用test2前会等待当前对象锁的释放，实际上该对象锁已被当前线程所持有，不可能再次获得。

如果锁是不具有可重入性特点的话，那么线程在调用同步方法、含有锁的方法时就会产生死锁。

<p id="thread-64">

#### 同步方法和同步代码块

同步方法默认用this或者当前类class对象作为锁；
同步代码块可以选择以什么来加锁，比同步方法要更细颗粒度，我们可以选择只同步会发生同步问题的部分代码而不是整个方法。