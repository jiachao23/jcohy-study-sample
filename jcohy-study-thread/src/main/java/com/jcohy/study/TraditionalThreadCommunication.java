package com.jcohy.study;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ���߳�ѭ��10�Σ��������߳�ѭ��100�Σ�
 * �����ֻص����߳�ѭ��10�Σ��������ٻص����߳�ѭ��100�Ρ�
 * ���ѭ��50�Σ�д�����롣
 * Ҫ�õ�ͬ�����ݣ�������ͬ���������ɸ�����Ӧд��һ�����У�������������˸���۳���Ľ�׳��
 *whileҪ������if������ǹٷ���˵��
 *A thread can also wake up without being notified, interrupted, or timing out, a so-called spurious wakeup. While this will rarely occur in practice, applications must guard against it by testing for the condition that should have caused the thread to be awakened, and continuing to wait if the condition is not satisfied. In other words, waits should always occur in loops, like this one: 

     synchronized (obj) {
         while (<condition does not hold>)
             obj.wait(timeout);
         ... // Perform action appropriate to condition
     }
	�����õ�wait��notify����������Condition�ķ�ʽʵ���߳��е�ͨ��
 */
public class TraditionalThreadCommunication {

	public static void main(String[] args) {
		final Business business=new Business();
		new Thread(
				new Runnable() {
					
					@Override
					public void run() {
						for(int i=1;i<=50;i++)
							business.sub(i);
					}
				}).start();
		for(int i=1;i<=50;i++)
			business.main(i);
	}
}

class Business {
	boolean bShouldSub=true;
	Lock lock= new ReentrantLock();
	Condition condition=lock.newCondition();
	public /*synchronized*/ void sub(int n){
		 lock.lock();
		  try{
			  while(!bShouldSub){
				  try {
					condition.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
				for(int j=1;j<=10;j++){
					System.out.println("sub thread sequence of " + j + ",loop of " + n);
				}
			  bShouldSub = false;
			  condition.signal();
		  }finally{
			  lock.unlock();
		  }
	}
	public /*synchronized*/ void main(int n){
		lock.lock();
		  try{
			 while(bShouldSub){
			  		try {
						condition.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			  	}
				for(int j=1;j<=100;j++){
					System.out.println("main thread sequence of " + j + ",loop of " + n);
				}
				bShouldSub = true;
				condition.signal();
	  }finally{
		  lock.unlock();
	  }
}
}