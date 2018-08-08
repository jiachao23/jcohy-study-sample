package com.jcohy.study;

/**
 * @author jiachaogbuj听不见了我去
 * 扣扣为啥聊不成还可以
 * 脑子有问题
 * 你才有问题
 * 你大爷
 * 
 *设计四个线程，其中两个线程每次对j增加1，另外两个线程j减少1.写出程序
 */
public class ThreadTest {
	private int j;
	public static void main(String[] args) {
		ThreadTest threadTest=new ThreadTest();
		Inc inc= threadTest.new Inc();
		Dec dec=threadTest.new Dec();
		for(int i=0;i<2;i++){
			Thread thread=new Thread(inc);
			thread.start();
			Thread thread2= new Thread(dec);
			thread2.start();
		}
	}
		private synchronized void inc(){
			j++;
			System.out.println(Thread.currentThread().getName()+" inc: "+j);
		}
		private synchronized void dec(){
			j--;
			System.out.println(Thread.currentThread().getName()+" dec:"+j);
		}
		class Inc implements Runnable{
			
			@Override
			public void run() {
				for(int i=0;i<100;i++)
					inc();
			}
		}
		class Dec implements Runnable{
			
			@Override
			public void run() {
				for(int i=0;i<100;i++)
					dec();
			}
		}
	}

