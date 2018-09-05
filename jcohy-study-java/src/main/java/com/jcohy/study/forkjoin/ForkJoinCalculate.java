package com.jcohy.study.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by jiac on 2018/9/5.
 * ClassName  : com.jcohy.study.forkjoin
 * Description  :
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

    private long start;

    private long end;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }
    private static final long THRESHOLD = 10000L; //�ٽ�ֵ
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
           left.fork(); //��֣�������������ѹ���̶߳���

           ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
           right.fork(); //��֣�������������ѹ���̶߳���

           return left.join()+right.join();
       }
    }
}
