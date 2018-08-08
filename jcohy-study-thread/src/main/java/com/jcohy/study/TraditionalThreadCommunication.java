package com.jcohy.study;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 子线程循环10次，接着主线程循环100次，
 * 接着又回到子线程循环10次，接着又再回到主线程循环100次。
 * 如此循环50次，写出代码。
 * 要用到同步数据（包括共同锁）的若干个方法应写在一个类中，这种设计体现了高类聚程序的健壮性
 *while要优先于if。这个是官方的说明
 *A thread can also wake up without being notified, interrupted, or timing out, a so-called spurious wakeup. While this will rarely occur in practice, applications must guard against it by testing for the condition that should have caused the thread to be awakened, and continuing to wait if the condition is not satisfied. In other words, waits should always occur in loops, like this one: 

     synchronized (obj) {
         while (<condition does not hold>)
             obj.wait(timeout);
         ... // Perform action appropriate to condition
     }
	除了用到wait和notify。还可以用Condition的方式实现线程中的通信
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