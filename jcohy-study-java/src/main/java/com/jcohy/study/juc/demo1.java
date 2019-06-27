package com.jcohy.study.juc;

/**
 * Created by jiac on 2019/3/13.
 * ClassName  : com.jcohy.study.juc
 * Description  :
 */
public class demo1 {

    public static volatile boolean stop = false;
    public static void main(String[] args) throws InterruptedException {

        new Thread(() ->{
            int i=0;
            while (!stop){
                i++;
            }
            System.out.println("i = "+i);
        }).start();
        Thread.sleep(1000);
        stop=true;

    }
}
