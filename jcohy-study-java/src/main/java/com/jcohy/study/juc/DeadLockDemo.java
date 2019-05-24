package com.jcohy.study.juc;

import java.util.concurrent.TimeUnit;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 13:16 2019/4/19
 * Email: jia_chao23@126.com
 * ClassName: DeadLockDemo
 * Description:
 **/

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
