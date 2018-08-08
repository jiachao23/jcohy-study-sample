package com.jcohy.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jiachao
 *	
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
		//固定线程的线程池
		//ExecutorService executorService = Executors.newFixedThreadPool(3);
		//创建缓冲的线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		//单个线程，线程死了会马上给他自动创建一个线程
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();
		for(int i=1;i<=10;i++){
			final int task=i;
			executorService.execute(new Runnable(){
				@Override
				public void run() {
					for(int j=1;j<=10;j++){
						System.out.println(Thread.currentThread().getName()+" loop of "+j+" task of "+task);
					}
				}
			});
		}
		System.out.println("all of 10 task is commited");
		//executorService.shutdown();
		Executors.newScheduledThreadPool(3).scheduleWithFixedDelay((new Runnable(){

			@Override
			public void run() {
				System.out.println("booming!!!!!!!!!你丫要上天,二货");
			}
		}), 6, 2,TimeUnit.SECONDS);
	}
}
