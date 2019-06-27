package com.jcohy.study.java8.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by jiac on 2018/9/5.
 * ClassName  : com.jcohy.study.java8.forkjoin
 * Description  :
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

    private long start;

    private long end;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }
    private static final long THRESHOLD = 10000L; //临界值
    @Override
    protected Long compute() {
        long length = end - start;

       if(length<THRESHOLD){
           long sum = 0;
           for (long i = start; i <= end; i++) {
               sum += i;
           }
           return sum;
       }else{
           //chaifen
           long middle = (start + end) / 2;
           ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
           left.fork(); //拆分，并将该子任务压入线程队列

           ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
           right.fork(); //拆分，并将该子任务压入线程队列

           return left.join()+right.join();
       }
    }
}
