package com.jcohy.study;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author jiachao
 *
 */
public class CallableAndFuture {

	public static void main(String[] args) {
		ExecutorService thread1=Executors.newSingleThreadExecutor();
		Future<String> future=thread1.submit(new Callable<String>(){
			
			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "hello";
			}
		});
		try {
			System.out.println("等待结果。。。。");
			//
			//System.out.println("拿到结果："+future.get(1,TimeUnit.SECONDS));
			System.out.println("拿到结果："+future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread1.shutdown();
		
		ExecutorService thread2=Executors.newFixedThreadPool(3);
		CompletionService<Integer> completionService= new ExecutorCompletionService<>(thread2);
		for(int i=1;i<=10;i++){
			final int req=i;
			completionService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));
					return req;
					
				}
			});
		}
		
		for(int i=1;i<=10;i++){
			try {
				System.out.println(completionService.take().get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		thread2.shutdown();
	}

}
