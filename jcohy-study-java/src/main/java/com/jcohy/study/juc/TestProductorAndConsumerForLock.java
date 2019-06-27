package com.jcohy.study.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 生产者消费者案例：
 */
public class TestProductorAndConsumerForLock {

    public static void main(String[] args) {
        Clerk2 clerk = new Clerk2();

        Productor2 pro = new Productor2(clerk);
        Consumer2 con = new Consumer2(clerk);

        new Thread(pro, "生产者 A").start();
        new Thread(con, "消费者 B").start();

//		 new Thread(pro, "生产者 C").start();
//		 new Thread(con, "消费者 D").start();
    }

}

class Clerk2 {
    private int product = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // 进货
    public void get() {
        lock.lock();
        try {
            if (product >= 1) { // 为了避免虚假唤醒，应该总是使用在循环中。
                System.out.println("产品已满！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : "
                    + ++product);

            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    // 卖货
    public void sale() {
        lock.lock();

        try {
            if (product <= 0) {
                System.out.println("缺货！");

                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }

            System.out.println(Thread.currentThread().getName() + " : "
                    + --product);

            condition.signalAll();

        } finally {
            lock.unlock();
        }
    }
}

// 生产者
class Productor2 implements Runnable {

    private Clerk2 clerk;

    public Productor2(Clerk2 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者线程启动");
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}

// 消费者
class Consumer2 implements Runnable {

    private Clerk2 clerk;

    public Consumer2(Clerk2 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者线程启动");
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }

}