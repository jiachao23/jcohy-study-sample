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
		//�̶��̵߳��̳߳�
		//ExecutorService executorService = Executors.newFixedThreadPool(3);
		//����������̳߳�
		ExecutorService executorService = Executors.newCachedThreadPool();
		//�����̣߳��߳����˻����ϸ����Զ�����һ���߳�
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
				System.out.println("booming!!!!!!!!!��ѾҪ����,����");
			}
		}), 6, 2,TimeUnit.SECONDS);
	}
}
