package com.jcohy.study;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * ��Ϊһ��ʾ�����ٶ���һ���󶨵Ļ���������֧�� put �� take ������
 * �����ͼ�ڿյĻ�������ִ�� take ����������ĳһ�����ÿ���֮ǰ��
 * �߳̽�һֱ�����������ͼ�����Ļ�������ִ�� put �����������пռ��ÿ���֮ǰ���߳̽�һֱ������
 * ����ϲ���ڵ����ĵȴ� set �б��� put �̺߳� take �̣߳������Ϳ����ڻ������е����ռ��ÿ���
 * ʱ������ѹ滮��һ��ֻ֪ͨһ���̡߳�����ʹ������ Condition ʵ����������һ��
 */
class BoundedBuffer {
   final Lock lock = new ReentrantLock();
   final Condition notFull  = lock.newCondition(); 
   final Condition notEmpty = lock.newCondition(); 

   final Object[] items = new Object[100];
   int putptr, takeptr, count;

   public void put(Object x) throws InterruptedException {
     lock.lock();
     try {
       while (count == items.length) 
         notFull.await();
       items[putptr] = x; 
       if (++putptr == items.length) putptr = 0;
       ++count;
       notEmpty.signal();
     } finally {
       lock.unlock();
     }
   }

   public Object take() throws InterruptedException {
     lock.lock();
     try {
       while (count == 0) 
         notEmpty.await();
       Object x = items[takeptr]; 
       if (++takeptr == items.length) takeptr = 0;
       --count;
       notFull.signal();
       return x;
     } finally {
       lock.unlock();
     }
   } 
 }
