package com.jcohy.study.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 15:44 2019/4/18
 * Email: jia_chao23@126.com
 * ClassName: SemaphoreDemo
 * Description:
 **/
public class SemaphoreDemo {

    public static void main(String[] args) {
        //模拟3个停车位
        Semaphore semaphore = new Semaphore(3);
        //6个车
        for (int i = 1; i <= 6 ; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t 停车3秒钟离开车位");


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
