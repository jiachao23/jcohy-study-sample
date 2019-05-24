package com.study.viewguide;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 12:34 2019/4/17
 * Email: jia_chao23@126.com
 * ClassName: VolatileDemo
 * Description: 验证volatile的特性
 **/

class MyData{
    volatile int number = 0;

    AtomicInteger atomicInteger =new AtomicInteger();
    public void addTo60(){
        this.number = 60;
    }
    //注意，此时number前面加了volatile关键字的，不保证原子性
    public  void addPlusPlus(){
        number++;
    }

    public  void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1、验证Volatile的可见性
 *  1.1 假如 int number = 0;number变量之前根本没有添加volatile关键字修饰,打印结果如下：
 *      AAA	 come in
        AAA	 update number value:60
        因为AAA线程修改变量的值后，写会主内存。而main线程并不知道变量的值已经改变，没有人去通知他，所以会一直等待
 *  1.2 修改变量的值为volatile，可以解决可见性问题
 * 2、验证volatile不保证原子性问题
 *  2.1 原子性？
 *      不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者分割，需要整体完整要么同时成功，要么同时失败。
 *   2.2 volatile不保证原子性。创建20个线程，每个线程对number加1000次。正常情况下，打印结果应该为20000
 *   2.3 why:因为number++ 是非原子性操作，其底层进行了三次操作。假设A和B线程同时拿到主内存的值后在自己的工作内存对其进行累加，当A线程准备写回主存时，线程B来不及更新，也继续写回，会出现写覆盖的情况。
 *   2.4 如何解决
 *      ① 加 synchronized 关键字（此做法有点小题大用）
 *      ② 使用Java自带的Atomic系列包装类
 *
 */
public class VolatileDemo {

    public static void main(String[] args) {
//        seeOkByVolatile();
        MyData myData = new MyData();
        for(int i = 1;i <= 20;i++){
            new Thread(() -> {
                for (int j = 1; j <=1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
                },String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t int type,finally number value :"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger type,finally number value :"+myData.atomicInteger);
    }

    //volatile保证可见性问题，及时通知其他线程，住内存的值已经被修改
    private static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t update number value:"+myData.number);
        },"AAA").start();

        //第二个线程就是我们的主线程
        while (myData.number == 0){
        //main线程就一直在这里循环，直到number的值不为0
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over:"+myData.number);
    }
}