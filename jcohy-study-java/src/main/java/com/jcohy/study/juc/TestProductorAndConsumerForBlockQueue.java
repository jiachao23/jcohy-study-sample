package com.jcohy.study.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 19:15 2019/4/18
 * Email: jia_chao23@126.com
 * ClassName: TestProductorAndConsumerForBlockQueue
 * Description:
 **/
class Clerk3 {
    private volatile boolean FLAG = true;
    private BlockingQueue<String> blockingQueue;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public Clerk3(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    //进货,生产
    public void get() throws InterruptedException {
        String data = null;
        boolean returnValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            returnValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (returnValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停了，表示FLAG=false。生产动作结束");
    }

    //卖货
    public void sale() throws InterruptedException {
        String returnValue;
        while (FLAG) {
            returnValue = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == returnValue || returnValue.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过两秒没有获取到货物，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列 消费" + returnValue + "成功");
        }
    }

    //停止
    public void stop(){
        this.FLAG =false;
    }
}

class Productor3 implements Runnable {
    private Clerk3 clerk;

    public Productor3(Clerk3 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        try {
            System.out.println("生产线程启动！");
            clerk.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer3 implements Runnable {
    private Clerk3 clerk;

    public Consumer3(Clerk3 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        try {
            System.out.println("消费线程启动！");

            clerk.sale();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TestProductorAndConsumerForBlockQueue {

    public static void main(String[] 陈妍) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);

        Clerk3 clerk3 = new Clerk3(blockingQueue);
        Productor3 productor3 = new Productor3(clerk3);
        Consumer3 consumer3 = new Consumer3(clerk3);

        new Thread(productor3, "生产者A").start();

        new Thread(consumer3, "消费者B").start();

        try { TimeUnit.SECONDS.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }

        clerk3.stop();
    }

}
