package com.jcohy.study;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jiachao
 *
 */
public class ReadWriteLockTest {
	public static void main(String[] args) {
		final Queue3 q3 = new Queue3();
		for(int i=0;i<3;i++)
		{
			new Thread(){
				public void run() {
					while(true){
						q3.get();
					}
				};
			}.start();
			new Thread(){
				public void run() {
					while(true){
						q3.put(new Random().nextInt(10000));
					}
				};
			}.start();
		}

	}
}

class Queue3{

	private Object data=null;	
	ReadWriteLock rwl= new ReentrantReadWriteLock();
	public void get(){
		rwl.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+" ready to read data!!");
			Thread.sleep((long)(Math.random()*5000));
			System.out.println(Thread.currentThread().getName()+" has read data " +data);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rwl.readLock().unlock();
		}
	}
	public void put(Object data){
		rwl.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+" ready to write data!!");
			this.data=data;
			Thread.sleep((long)(Math.random()*5000));
			System.out.println(Thread.currentThread().getName()+" has write data " +data);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rwl.writeLock().unlock();
		}
	}

}

