package com.jcohy.study;

import java.util.Random;

/**
 * @author jiachao
 *java为我们提供了ThreadLocal,用来实现线程内的数据共享
 */
public class ThreadScpoeShareDate {

	//private static Map<Thread,Integer> threadData=new HashMap<Thread,Integer>();
	private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>();
	public static void main(String[] args) {

		for(int i=1;i<=5;i++){
			new Thread(
					new Runnable(){
						@Override
						public void run() {
							int data=new Random().nextInt();
							System.out.println(Thread.currentThread().getName()+"   data is   "+data);
							//threadData.put(Thread.currentThread(), data);
							threadLocal.set(data);
							new A().get();
							new B().get();
						}

					}).start();
		}
	}
	static class A{
		public void get(){
			//int data=threadData.get(Thread.currentThread());
			int data=threadLocal.get();
			System.out.println("A from "+Thread.currentThread().getName()+" data is "+data);
		}
	}
	static class B{
		public void get(){
			//int data=threadData.get(Thread.currentThread());
			int data=threadLocal.get();
			System.out.println("B from "+Thread.currentThread().getName()+" data is "+data);
		}
	}
}
