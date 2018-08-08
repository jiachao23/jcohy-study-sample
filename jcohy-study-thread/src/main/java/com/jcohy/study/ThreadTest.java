package com.jcohy.study;

/**
 * @author jiachaogbuj����������ȥ
 * �ۿ�Ϊɶ�Ĳ��ɻ�����
 * ����������
 * ���������
 * ���ү
 * 
 *����ĸ��̣߳����������߳�ÿ�ζ�j����1�����������߳�j����1.д������
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

