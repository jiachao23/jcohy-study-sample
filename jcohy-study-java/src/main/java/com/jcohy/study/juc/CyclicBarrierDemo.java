package com.jcohy.study.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 15:37 2019/4/18
 * Email: jia_chao23@126.com
 * ClassName: CyclicBarrierDemo
 * Description:
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> System.out.println("召唤神龙"));

        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 收集到第"+tempInt+"个龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {

                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
