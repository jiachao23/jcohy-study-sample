package com.jcohy.study.juc;

/**
 * Created by jiac on 2018/10/18.
 * ClassName  : com.jcohy.study.juc
 * Description  :
 */
public class VolatileTest {

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        while (true){
            if(td.isFlag()){
                System.out.println("-----------------");
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable{
    //        private boolean flag = false;
    private volatile boolean flag = false;
    @Override
    public void run() {
        try {
            Thread.sleep(200);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = "+flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}