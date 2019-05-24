package com.jcohy.study.singleton;

/**
 * 下面前四种方法都有以下缺点：
 *1. 需要额外的工作来实现序列化，否则每次反序列化一个序列化的对象时都会创建一个新的实例。
 *2.可以使用反射强行调用私有构造器（如果要避免这种情况，可以修改构造器，让它在创建第二个实例的时候抛异常）。
 *而枚举类很好的解决了这两个问题，使用枚举除了线程安全和防止反射调用构造器之外，还提供了自动序列化机制，防止反序列化的时候创建新的对象。
 * 双重校验锁和静态内部类的方式可以解决大部分问题，平时工作中使用的最多的也是这两种方式。
 * 
 * @author jiachao
 *
 */
public class Singleton {

	/**
	 * 
	 * 第一种：饿汉模式
	 * 饿汉模式在类加载的时候就对实例进行创建，实例在整个程序周期都存在。
	 * 它的好处是只在类加载的时候创建一次实例，不会存在多个线程创建多个实例的情况，避免了多线程同步的问题。
	 * 它的缺点也很明显，即使这个单例没有用到也会被创建，而且在类加载之后就被创建，内存就被浪费了。
	 */
	// 持有私有静态实例，防止被引用，此处赋值为 null，目的是实现延迟加载 
	private static Singleton instance = new Singleton();  
	//私有划静态方法
	private Singleton(){
	}
	public static Singleton newInstance(){  
		return instance;  
	}  


	/**
	 * 第二种：懒汉模式：
	 * 懒汉模式中单例是在需要的时候才去创建的，如果单例已经创建，再次调用获取接口将不会重新创建新的对象
	 * 而是直接返回之前创建的对象。
	 * 如果某个单例使用的次数少，并且创建单例消耗的资源较多，那么就需要实现单例的按需创建，
	 * 这个时候使用懒汉模式就是一个不错的选择。
	 * 
	 */
	// 持有私有静态实例，防止被引用，此处赋值为 null，目的是实现延迟加载
	//	private static Singleton instance = null;  
	//    private Singleton(){}  
	//    public static Singleton newInstance(){  
	//        if(null == instance){  
	//            instance = new Singleton();  
	//        }  
	//        return instance;  
	//    } 
	/**
	 * 但是这里的懒汉模式并没有考虑线程安全问题，
	 * 在多个线程可能会并发调用它的getInstance()方法，导致创建多个实例。
	 * 因此需要加锁解决线程同步问题
	 */
	//	private static Singleton instance = null;  
	//    private Singleton(){}  
	//    public static synchronized Singleton newInstance(){  
	//        if(null == instance){  
	//            instance = new Singleton();  
	//        }  
	//        return instance;  
	//    } 
	/**
	 * 第三种：双重校验锁
	 * 加锁的懒汉模式看起来即解决了线程并发问题，又实现了延迟加载
	 * 然而它存在着性能问题，依然不够完美。
	 * synchronized修饰的同步方法比一般方法要慢很多，如果多次调用getInstance()
	 * 累积的性能损耗就比较大了。因此就有了双重校验锁
	 */
	//	private static Singleton instance = null;  
	//    private Singleton(){}  
	//    public static Singleton getInstance() {  
	//        if (instance == null) {  
	//            synchronized (Singleton.class) {  
	//                if (instance == null) {//2  
	//                    instance = new Singleton();  
	//                }  
	//            }  
	//        }  
	//        return instance;  
	//    }
	/**
	 * 由于指令重排优化的存在，导致初始化Singleton和将对象地址赋给instance字段的顺序是不确定的。
	 * 在某个线程创建单例对象时，在构造方法被调用之前，就为该对象分配了内存空间并将对象的字段设置为默认值。
	 * 此时就可以将分配的内存地址赋值给instance字段了，然而该对象可能还没有初始化。
	 * 若紧接着另外一个线程来调用getInstance，取到的就是状态不正确的对象，程序就会出错。
	 * volatile的一个语义是禁止指令重排序优化，
	 * 也就保证了instance变量被赋值的时候对象已经是初始化过的，
	 * 从而避免了上面说到的问题。
	 */
	//	private static volatile Singleton instance = null;  
	//    private Singleton(){}  
	//    public static Singleton getInstance() {  
	//        if (instance == null) {  
	//            synchronized (Singleton.class) {  
	//                if (instance == null) {  
	//                    instance = new Singleton();  
	//                }  
	//            }  
	//        }  
	//        return instance;  
	//    }  
	/**
	 * 第四种：内部类
	 */
	//	private static class SingletonHolder{  
	//        public static Singleton instance = new Singleton();  
	//    }  
	//    private Singleton(){}  
	//    public static Singleton newInstance(){  
	//        return SingletonHolder.instance;  
	//    }  
	/**
	 * 第五种：枚举
	 * 
	 */
	//	instance;  
	//    public void whateverMethod(){}    
}
