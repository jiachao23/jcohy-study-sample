
#  Java
> #### PS:�������С�������
> #### ������ҳ��[www.jcohy.com](http://www.jcohy.com)  	

>  �ҵ�ѧϰ�ʼǣ���¼ѧϰ�����еıʼ��Լ�����������,�Լ��ҵ�һЩ�����ܽᡣ�����������ʧЧ,������֪����������ݵ���������ύ Issues �������޸�������ݡ�

## Java�߳����
> * [Thread���sleep()�����Ͷ����wait()�������������߳���ִͣ�У�������ʲô����?](#thread-1)
> * [�̵߳�sleep()������yield()������ʲô����](#thread-2)
> * [��һ���߳̽���һ�������synchronized����A֮�������߳��Ƿ�ɽ���˶����synchronized����B��](#thread-3)
> * [��˵�����߳�ͬ���Լ��̵߳�����صķ�����](#thread-4)
> * [��д���̳߳����м���ʵ�ַ�ʽ��](#thread-5)
> * [synchronized�ؼ��ֵ��÷���](#thread-6)
> * [����˵��ͬ�����첽��](#thread-7)
> * [����һ���߳��ǵ���run()����start()������](#thread-8)
> * [ʲô���̳߳أ�thread pool����](#thread-9)
> * [�̵߳Ļ���״̬�Լ�״̬֮��Ĺ�ϵ��](#thread-10)
> * [����synchronized ��java.util.concurrent.locks.Lock����ͬ��](#thread-11)

<p id="thread-1">

#### Thread���sleep()�����Ͷ����wait()�������������߳���ִͣ�У�������ʲô����?

sleep()���������ߣ����߳��ࣨThread���ľ�̬���������ô˷������õ�ǰ�߳���ִͣ��ָ����ʱ�䣬��ִ�л��ᣨCPU���ø������̣߳����Ƕ��������Ȼ���֣��������ʱ���������Զ��ָ����̻߳ص�����״̬����ο�[�̵߳Ļ���״̬�Լ�״̬֮��Ĺ�ϵ��](#9)�߳�״̬ת��ͼ����wait()��Object��ķ��������ö����wait()�������µ�ǰ�̷߳�������������߳���ִͣ�У����������ĵȴ��أ�wait pool����ֻ�е��ö����notify()��������notifyAll()������ʱ���ܻ��ѵȴ����е��߳̽�������أ�lock pool��������߳����»�ö�������Ϳ��Խ������״̬��
���䣺���ܲ����˶�ʲô�ǽ��̣�ʲô���̻߳��Ƚ�ģ��������Ϊʲô��Ҫ���̱߳��Ҳ�����ر���⡣�򵥵�˵�������Ǿ���һ���������ܵĳ������ĳ�����ݼ����ϵ�һ�����л���ǲ���ϵͳ������Դ����͵��ȵ�һ��������λ���߳��ǽ��̵�һ��ʵ�壬��CPU���Ⱥͷ��ɵĻ�����λ���ǱȽ��̸�С���ܶ������еĻ�����λ���̵߳Ļ��ֳ߶�С�ڽ��̣���ʹ�ö��̳߳���Ĳ����Ըߣ�������ִ��ʱͨ��ӵ�ж������ڴ浥Ԫ�����߳�֮����Թ����ڴ档ʹ�ö��̵߳ı��ͨ���ܹ��������õ����ܺ��û����飬���Ƕ��̵߳ĳ���������������ǲ��Ѻõģ���Ϊ������ռ���˸����CPU��Դ����Ȼ��Ҳ�����߳�Խ�࣬��������ܾ�Խ�ã���Ϊ�߳�֮��ĵ��Ⱥ��л�Ҳ���˷�CPUʱ�䡣ʱ�º�ʱ�ֵ�Node.js�Ͳ����˵��߳��첽I/O�Ĺ���ģʽ��

<p id="thread-2">

#### �̵߳�sleep()������yield()������ʲô����

1. sleep()�����������߳����л���ʱ�������̵߳����ȼ�����˻�������ȼ����߳������еĻ��᣻yield()����ֻ�����ͬ���ȼ���������ȼ����߳������еĻ��᣻ 

2. �߳�ִ��sleep()������ת��������blocked��״̬����ִ��yield()������ת�������ready��״̬��

3.  sleep()���������׳�InterruptedException����yield()����û�������κ��쳣�� 

4. sleep()������yield()������������ϵͳCPU������أ����и��õĿ���ֲ�ԡ�

<p id="thread-3">

#### ��һ���߳̽���һ�������synchronized����A֮�������߳��Ƿ�ɽ���˶����synchronized����B��

���ܡ������߳�ֻ�ܷ��ʸö���ķ�ͬ��������ͬ���������ܽ��롣��Ϊ�Ǿ�̬�����ϵ�synchronized���η�Ҫ��ִ�з���ʱҪ��ö������������Ѿ�����A����˵���������Ѿ���ȡ�ߣ���ô��ͼ����B�������߳̾�ֻ���ڵ����أ�ע�ⲻ�ǵȴ���Ŷ���еȴ����������

<p id="thread-4">

#### ��˵�����߳�ͬ���Լ��̵߳�����صķ�����

- wait()��ʹһ���̴߳��ڵȴ���������״̬�������ͷ������еĶ��������
- sleep()��ʹһ���������е��̴߳���˯��״̬����һ����̬���������ô˷���Ҫ����InterruptedException�쳣��
- notify()������һ�����ڵȴ�״̬���̣߳���Ȼ�ڵ��ô˷�����ʱ�򣬲�����ȷ�еĻ���ĳһ���ȴ�״̬���̣߳�������JVMȷ�������ĸ��̣߳����������ȼ��޹ء�
- notityAll()���������д��ڵȴ�״̬���̣߳��÷��������ǽ���������������̣߳����������Ǿ�����ֻ�л�������̲߳��ܽ������״̬��
  ���䣺Java 5ͨ��Lock�ӿ��ṩ����ʽ�������ƣ�explicit lock������ǿ��������Լ����̵߳�Э����Lock�ӿ��ж����˼�����lock()���ͽ�����unlock()���ķ�����ͬʱ���ṩ��newCondition()���������������߳�֮��ͨ�ŵ�Condition���󣻴��⣬Java 5���ṩ���ź������ƣ�semaphore�����ź��������������ƶ�ĳ��������Դ���з��ʵ��̵߳��������ڶ���Դ���з���֮ǰ���̱߳���õ��ź�������ɣ�����Semaphore�����acquire()������������ɶ���Դ�ķ��ʺ��̱߳������ź����黹��ɣ�����Semaphore�����release()��������
�����������ʾ��100���߳�ͬʱ��һ�������˻��д���1ԪǮ����û��ʹ��ͬ�����ƺ�ʹ��ͬ����������µ�ִ�������
  �����˻��ࣺ

```java
/**
* �����˻�
* @author ���
*
*/
public class Account {
    private double balance; // �˻����
    /**
     * ���
     * @param money ������
     */
    public void deposit(double money) {
        double newBalance = balance + money;
        try {
            Thread.sleep(10); // ģ���ҵ����Ҫһ�δ���ʱ��
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        balance = newBalance;
    }
    /**
	 * ����˻����
	 */
    public double getBalance() {
        return balance;
    }
}

```
��Ǯ�߳��ࣺ
```java
/**
* ��Ǯ�߳�
* @author ���
*
*/
public class AddMoneyThread implements Runnable {
    private Account account; // �����˻�
    private double money; // ������
    public AddMoneyThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }
    @Override
    public void run() {
        account.deposit(money);
    }
}
```

�����ࣺ

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Test01 {
    public static void main(String[] args) {
        Account account = new Account();
        ExecutorService service = Executors.newFixedThreadPool(100);
        for(int i = 1; i <= 100; i++) {
            service.execute(new AddMoneyThread(account, 1));
        }
        service.shutdown();
        while(!service.isTerminated()) {}
        System.out.println("�˻����: " + account.getBalance());
    }
}
```
��û��ͬ��������£�ִ�н��ͨ������ʾ�˻������10Ԫ���£���������״����ԭ���ǣ���һ���߳�A��ͼ����1Ԫ��ʱ������һ���߳�BҲ�ܹ�������ķ����У��߳�B��ȡ�����˻������Ȼ���߳�A����1ԪǮ֮ǰ���˻������Ҳ����ԭ�������0�������˼�1Ԫ�Ĳ�����ͬ���߳�CҲ�������Ƶ����飬�������100���߳�ִ�н���ʱ�����������˻����Ϊ100Ԫ����ʵ�ʵõ���ͨ����10Ԫ���£��ܿ�����1ԪŶ��������������İ취����ͬ������һ���̶߳������˻���Ǯʱ����Ҫ�����˻����������������ɺ�������������߳̽��в��������������¼��ֵ���������
�������˻��Ĵ�deposit��������ͬ����synchronized���ؼ���

```java
/**
* �����˻�
* @author ���
*
*/
public class Account {
    private double balance; // �˻����
    /**
    * ���
    * @param money ������
    */
    public synchronized void deposit(double money) {
        double newBalance = balance + money;
        try {
            Thread.sleep(10); // ģ���ҵ����Ҫһ�δ���ʱ��
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        balance = newBalance;
    }
    /**
	* ����˻����
	*/
    public double getBalance() {
        return balance;
    }
}
```
���̵߳��ô���ʱ�������˻�����ͬ��
```java
/**
* ��Ǯ�߳�
* @author ���
*
*/
public class AddMoneyThread implements Runnable {
    private Account account; // �����˻�
    private double money; // ������
    public AddMoneyThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }
    @Override
    public void run() {
        synchronized (account) {
            account.deposit(money);
        }
    }
}
```
ͨ��Java 5��ʾ�������ƣ�Ϊÿ�������˻�����һ���������ڴ��������м����ͽ����Ĳ���
```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
* �����˻�
*
* @author ���
*
*/
public class Account {
    private Lock accountLock = new ReentrantLock();
    private double balance; // �˻����
    /**
* ���
*
* @param money
* ������
*/
    public void deposit(double money) {
        accountLock.lock();
        try {
            double newBalance = balance + money;
            try {
                Thread.sleep(10); // ģ���ҵ����Ҫһ�δ���ʱ��
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            balance = newBalance;
        }
        finally {
            accountLock.unlock();
        }
    }
    /**
* ����˻����
*/
    public double getBalance() {
        return balance;
    }
}
```

�����������ַ�ʽ�Դ�������޸ĺ���дִ�в��Դ���Test01�����������յ��˻����Ϊ100Ԫ����ȻҲ����ʹ��Semaphore��CountdownLatch��ʵ��ͬ����

<p id="thread-5">

#### ��д���̳߳����м���ʵ�ַ�ʽ��

Java 5��ǰʵ�ֶ��߳�������ʵ�ַ�����һ���Ǽ̳�Thread�ࣻ��һ����ʵ��Runnable�ӿڡ����ַ�ʽ��Ҫͨ����дrun()�����������̵߳���Ϊ���Ƽ�ʹ�ú��ߣ���ΪJava�еļ̳��ǵ��̳У�һ������һ�����࣬����̳���Thread����޷��ټ̳��������ˣ���Ȼʹ��Runnable�ӿڸ�Ϊ��
���䣺Java 5�Ժ󴴽��̻߳��е����ַ�ʽ��ʵ��Callable�ӿڣ��ýӿ��е�call�����������߳�ִ�н���ʱ����һ������ֵ������������ʾ��

```java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
class MyTask implements Callable<Integer> {
    private int upperBounds;
    public MyTask(int upperBounds) {
        this.upperBounds = upperBounds;
    }
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 1; i <= upperBounds; i++) {
            sum += i;
        }
        return sum;
    }
}
class Test {
    public static void main(String[] args) throws Exception {
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++) {
            list.add(service.submit(new MyTask((int) (Math.random() * 100))));
        }
        int sum = 0;
        for(Future<Integer> future : list) {
            // while(!future.isDone()) ;
            sum += future.get();
        }
        System.out.println(sum);
    }
}
```

<p id="thread-6">
#### synchronized�ؼ��ֵ��÷���

synchronized�ؼ��ֿ��Խ�������߷������Ϊͬ������ʵ�ֶԶ���ͷ����Ļ�����ʣ�������synchronized(����) { �� }����ͬ������飬��������������ʱ��synchronized��Ϊ���������η�����������������Ѿ�չʾ��synchronized�ؼ��ֵ��÷���

<p id="thread-7">
#### ����˵��ͬ�����첽��

���ϵͳ�д����ٽ���Դ����Դ�������ھ�����Դ���߳���������Դ������������д�������Ժ���ܱ���һ���̶߳������������ڶ������ݿ����Ѿ�����һ���߳�д���ˣ���ô��Щ���ݾͱ������ͬ����ȡ�����ݿ�����е�������������õ����ӣ�����Ӧ�ó����ڶ����ϵ�����һ����Ҫ���Ѻܳ�ʱ����ִ�еķ��������Ҳ�ϣ���ó���ȴ������ķ���ʱ����Ӧ��ʹ���첽��̣��ںܶ�����²����첽;����������Ч�ʡ���ʵ�ϣ���ν��ͬ������ָ����ʽ���������첽���Ƿ�����ʽ������

<p id="thread-8">
#### ����һ���߳��ǵ���run()����start()������

����һ���߳��ǵ���start()������ʹ�߳�����������⴦������ڿ�����״̬������ζ����������JVM ���Ȳ�ִ�У��Ⲣ����ζ���߳̾ͻ��������С�run()�������߳�������Ҫ���лص���callback���ķ�����

<p id="thread-9">
#### ʲô���̳߳أ�thread pool����

������������У����������ٶ����Ǻܷ�ʱ��ģ���Ϊ����һ������Ҫ��ȡ�ڴ���Դ��������������Դ����Java�и�����ˣ����������ͼ����ÿһ�������Ա��ܹ��ڶ������ٺ�����������ա�������߷������Ч�ʵ�һ���ֶξ��Ǿ����ܼ��ٴ��������ٶ���Ĵ������ر���һЩ�ܺ���Դ�Ķ��󴴽������٣�����ǡ��ػ���Դ������������ԭ���̳߳ع���˼��������ȴ������ɸ���ִ�е��̷߳���һ���أ��������У���Ҫ��ʱ��ӳ��л�ȡ�̲߳������д�����ʹ����ϲ���Ҫ�����̶߳��ǷŻس��У��Ӷ����ٴ����������̶߳���Ŀ�����Java 5+�е�Executor�ӿڶ���һ��ִ���̵߳Ĺ��ߡ����������ͼ��̳߳ؽӿ���ExecutorService��Ҫ����һ���̳߳��ǱȽϸ��ӵģ������Ƕ����̳߳ص�ԭ���Ǻ����������£�����ڹ�����Executors���ṩ��һЩ��̬��������������һЩ���õ��̳߳أ�������ʾ�� 

- newSingleThreadExecutor������һ�����̵߳��̳߳ء�����̳߳�ֻ��һ���߳��ڹ�����Ҳ�����൱�ڵ��̴߳���ִ����������������Ψһ���߳���Ϊ�쳣��������ô����һ���µ��߳�������������̳߳ر�֤���������ִ��˳����������ύ˳��ִ�С�
- newFixedThreadPool�������̶���С���̳߳ء�ÿ���ύһ������ʹ���һ���̣߳�ֱ���̴߳ﵽ�̳߳ص�����С���̳߳صĴ�Сһ���ﵽ���ֵ�ͻᱣ�ֲ��䣬���ĳ���߳���Ϊִ���쳣����������ô�̳߳ػᲹ��һ�����̡߳�

- newCachedThreadPool������һ���ɻ�����̳߳ء�����̳߳صĴ�С�����˴�����������Ҫ���̣߳���ô�ͻ���ղ��ֿ��У�60�벻ִ�����񣩵��̣߳�������������ʱ�����̳߳��ֿ������ܵ�������߳����������񡣴��̳߳ز�����̳߳ش�С�����ƣ��̳߳ش�С��ȫ�����ڲ���ϵͳ������˵JVM���ܹ�����������̴߳�С��
- newScheduledThreadPool������һ����С���޵��̳߳ء����̳߳�֧�ֶ�ʱ�Լ�������ִ�����������
- newSingleThreadExecutor������һ�����̵߳��̳߳ء����̳߳�֧�ֶ�ʱ�Լ�������ִ�����������

<p id="thread-10">
#### �̵߳Ļ���״̬�Լ�״̬֮��Ĺ�ϵ��

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/1.jpg)

˵��������Running��ʾ����״̬��Runnable��ʾ����״̬�����¾㱸��ֻǷCPU����Blocked��ʾ����״̬������״̬���ж����������������Ϊ����wait()��������ȴ��أ�Ҳ������ִ��ͬ��������ͬ��������������أ������ǵ�����sleep()������join()�����ȴ����߻������߳̽�����������Ϊ������I/O�жϡ�

<p id="thread-11">
#### ����synchronized ��java.util.concurrent.locks.Lock����ͬ��

Lock��Java 5�Ժ�������µ�API���͹ؼ���synchronized�����Ҫ��ͬ�㣺Lock �����synchronized��ʵ�ֵ����й��ܣ���Ҫ��ͬ�㣺Lock�б�synchronized����ȷ���߳�����͸��õ����ܣ����Ҳ�ǿ���Ե�Ҫ��һ��Ҫ�������synchronized���Զ��ͷ�������Lockһ��Ҫ�����Ա�ֹ��ͷţ����������finally �����ͷţ������ͷ��ⲿ��Դ����õĵط�����
