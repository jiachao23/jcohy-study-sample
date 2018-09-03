#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 单例模式

> * [概述](#gaishu)
> * [设计单例模式的四种常用方法](#method)
>  *  [饿汉式](#ehan)
>  *  [懒汉式](#lanhan)
>  *  [内部类](#neibu)
>  *  [枚举](#enum)
> * [Q&A](#qa)
> * [Java语言中单例模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu" />

### 概述

####  单例模式：保证一个类仅有一个实例，并提供一个访问他的全局访问点。单例模式（Singleton）是一种常用的设计模式。在Java应用中，单例对象能保证在一个JVM中，该对象只有一个实例存在。而且自行实例化并向整个系统提供这个实例，这样的模式有几个好处：
>  * 某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销
>  * 省去了new操作符，降低了系统内存的使用频率，减轻GC压力。 
>  * 有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。（比如一个军队出现了多个司令员同时指挥，肯定会乱成一团），所以只有使用单例模式，才能保证核心交易服务器独立控制整个流程。
>    单例模式的结构如图“”

>  * ![Singleton](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-designpattern/src/main/resources/static/images/Singleton.png)

<p id="method" />

### 设计单例模式的四种常用方法

<p id="ehan" />

> * 饿汉式单例
>   *   饿汉模式在类加载的时候就对实例进行创建，实例在整个程序周期都存在。
>   *   它的好处是只在类加载的时候创建一次实例，不会存在多个线程创建多个实例的情况，避免了多线程同步的问题。
>   *   它的缺点也很明显，即使这个单例没有用到也会被创建，而且在类加载之后就被创建，内存就被浪费了。
>      ## 代码实现：
			private static Singleton instance = new Singleton();  
				//私有划静态方法
				private Singleton(){
				}
				public static Singleton newInstance(){  
					return instance;  
			}  

<p id="lanhan" />

> * 懒汉式单例
>   *   懒汉模式中单例是在需要的时候才去创建的，如果单例已经创建，再次调用获取接口将不会重新创建新的对象，而是直接返回之前创建的对象。。
>
>   *   如果某个单例使用的次数少，并且创建单例消耗的资源较多，那么就需要实现单例的按需创建，这个时候使用懒汉模式就是一个不错的选择。
>
>   *   饿汉式是线程安全的,在类创建的同时就已经创建好一个静态的对象供系统使用,以后不在改变。懒汉式如果在创建实例对象时不加上synchronized则会导致对对象的访问不是线程安全的。从实现方式来讲他们最大的区别就是懒汉式是延时加载,他是在需要的时候才创建对象,而饿汉式在虚拟机启动的时候就会创建，饿汉式无需关注多线程问题、写法简单明了、能用则用。但是它是加载类时创建实例。有时候可能将不用的一些实例也加载进来。
>
>      ## 代码实现：
			private static Singleton instance = null; 
				private Singleton(){} 
				public static Singleton newInstance(){ 
	 				if(null == instance){ 
	  					instance = new Singleton(); 
	  				} 
	  				return instance; 
				} 

>  Ps:​ 但是这里的懒汉模式并没有考虑线程安全问题， 在多个线程可能会并发调用它的getInstance()方法，导致创建多个实例。 因此需要加锁解决线程同步问题
			
			private static Singleton instance = null;  
	   		    private Singleton(){}  
	    		public static synchronized Singleton newInstance(){  
	        		if(null == instance){  
	            		instance = new Singleton();  
	        		}  
	        		return instance;  
	    		} 

​     &nbsp;&nbsp;   由于指令重排优化的存在，导致初始化Singleton和将对象地址赋给instance字段的顺序是不确定的。 在某个线程创建单例对象时，在构造方法被调用之前，就为该对象分配了内存空间并将对象的字段设置为默认值。此时就可以将分配的内存地址赋值给instance字段了，然而该对象可能还没有初始化。若紧接着另外一个线程来调用getInstance，取到的就是状态不正确的对象，程序就会出错。  
#### volatile的一个语义是禁止指令重排序优化， 也就保证了instance变量被赋值的时候对象已经是初始化过的，从而避免了上面说到的问题。

			private static volatile Singleton instance = null;  
	    		private Singleton(){}  
	    		public static Singleton getInstance() {  
	        		if (instance == null) {  
	            		synchronized (Singleton.class) {  
	                		if (instance == null) {  
	                    		instance = new Singleton();  
	                		}  
	            		}  
	        		}  
	        		return instance;  
	   		}

<p id="neibu" />

> * 内部类单例
>    * 用的很少。不建议使用
>      ## 代码实现：
			private static class SingletonHolder{  
	      		public static Singleton instance = new Singleton();  
	    		}  
	   		 	private Singleton(){}  
	    		public static Singleton newInstance(){  
	        		return SingletonHolder.instance;  
	    		}  

<p id="enum" />

> * 枚举单例
>   * 从java1.5起，java支持枚举单例了。
>
>   * 代码简单
>
>   * 自由序列化
>
>      ## 代码实现：
			public enum SomeThing {
					INSTANCE;
				private Resource instance;
					SomeThing() {
				instance = new Resource();
	            }
				public Resource getInstance() {
	    			return instance;
				}
			} 

<p id="qa" />

## Q&A

​ &nbsp;&nbsp;使用单例模式有一个必要条件：在一个系统要求一个类只有一个实例时才应当使用单例模式。反过来说，如果一个类可以有几个实例共存。那么就没有必要使用单例类。下面举几个例子来说明
> *  ​例子一
>  &nbsp;&nbsp;<p> Q:一个系统需要一些“全程”变量，能否使用单例类盛放所有的全程变量。</p>
>  &nbsp;&nbsp;<p> A:这样做是违反单例模式的用意的，单例模式只应当在有真正的“单一实例”的需求时才可使用。一个设计得当的系统不应当有所谓的“全程”变量。这些变量应当放到它们所描述的是实体所对应的类中去。将这些变量从它们所描述的实体类中抽出来，放到一个不相干的单例类中去，使这些变量产生错误的依赖关系和耦合关系。</p>
>
> *  例子二
>   &nbsp;&nbsp;<p> Q:一个系统需要管理与数据库的链接。能不能使用一个单例类包装一个Connection对象，并在   finalize()方法中关闭这个Connection对象。这样的话，在这个实例没有被人引用时，这个finalize()对象就会被调用，因此Connection对象就会被释放。</p>
>   &nbsp;&nbsp;<p>A:这样做是不恰当的。除非有单一实例的需求，否则不要使用单例。在这里Connection对象可以同时有几个实例同存，不必是单一实例。</p>


<p id="java" />

### Java语言中单例模式
这里不做详细说明，大家下去可以自己研究。比较著名有以下几个
>  * java.lang.Runtime类
>  * Introspector类
>  * java.awt.Toolkit类
>  * java.awt.Desktop类

<p id="kuozhan" />

### 关于单例模式的其他问题

​       单例类比较灵活，毕竟从实现上只是一个普通的Java类，只要满足单例的基本需求，你可以在里面随心所欲的实现一些其它功能。单例类比较容易理解，但是不好实现。

​	关于单例模式还有其他的问题，比如单例模式中对象的序列化和反序列化，我们在用枚举类型的时候创建单例的过程等等。这些大家都可以自己下来研究研究。

