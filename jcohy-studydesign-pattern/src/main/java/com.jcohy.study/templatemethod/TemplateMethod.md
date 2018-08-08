
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 模板方法模式
> * [概述](#gaishu)
> * [模板方法模式的角色](#role)
> * [模板方法模式的应用场景](#sign)
> * [模板方法模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中模板方法模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

模板方法模式:定义一个操作中的算法的骨架，而将一些步骤延迟到子类中，模板方法使得子类可以不改变算法的结构即可重定义算法的某些特定步骤。


<p id="role">

## 模板方法模式的角色

>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-studydesign-pattern/src/main/resources/static/images/templatemethod.png)
>  *  AbstractClass:

>  声明模板方法所使用的抽象方法，这个抽象方法由子类ConcreteClass实现。
>  *  ConcreteClass:

>  实现AbstractClass以完成算法中与特定子类相关的步骤。
>  *  Client
<p id="sign">

##  模板方法模式的应用场景



<p id="shixian">

## 模板方法模式的实现

>  本例反复输出5次同一字符串或者字符
       
                           1.定义抽象类，AbstractDisplay，声明三个抽象方法，使用了抽象方法的display方法就是模板方法。
                           public abstract class AbstractDisplay {
                           	public abstract void open();
                           	public abstract void close();
                           	public abstract void print();
                           	public void dispay() {
                           		open();
                           		for(int i=0;i<5;i++) {
                           			print();
                           		}
                           		close();
                           	}
                           }
                           
                           2。实现
                           
                           
                           public class CharDisplay extends AbstractDisplay {
                           	private char ch;
                           	public CharDisplay(char ch) {
                           		this.ch = ch;
                           	}
                           	@Override
                           	public void open() {
                           		System.out.print("<<");
                           	}
                           
                           	@Override
                           	public void close() {
                           		System.out.println(">>");
                           	}
                           
                           	@Override
                           	public void print() {
                           		System.out.print(ch);
                           	}
                           
                           }
                           
                           public class StringDisplay extends AbstractDisplay {
                           	
                           	private String str;
                           	private int width;
                           	public StringDisplay(String str) {
                           		this.str = str;
                           		this.width = str.getBytes().length;
                           	}
                           	@Override
                           	public void open() {
                           		printLine();
                           	}
                           
                           	private void printLine() {
                           		System.out.print("+");
                           		for(int i=0;i<width;i++) {
                           			System.out.print("-");
                           		}
                           		System.out.println("+");
                           	}
                           	@Override
                           	public void close() {
                           		printLine();
                           	}
                           
                           	@Override
                           	public void print() {
                           		System.out.println("|"+str+"|");
                           	}
                           
                           }
       
                           3.Client
                           
                           
                           public class Client {
                           	public static void main(String[] args) {
                           		AbstractDisplay a = new CharDisplay('a');
                           		AbstractDisplay b =new StringDisplay("Hello world");
                           		a.dispay();
                           		b.dispay();
                           	}
                           }
                           
                           
                           4.result
                           
                           <<aaaaa>>
                           +-----------+
                           |Hello world|
                           |Hello world|
                           |Hello world|
                           |Hello world|
                           |Hello world|
                           +-----------+
                


         
<p id="qa">

##  Q&A

       
<p id="java">
        
##  Java语言中模板方法模式

>  *  java.io.InputStream, java.io.OutputStream, java.io.Reader 和java.io.Writer 的所有非抽象方法
>  *  java.util.AbstractList, java.util.AbstractSet 和 java.util.AbstractMap 的所有非抽象方法
>  *  javax.servlet.http.HttpServlet#doXXX()

<p id="kuozhan">

##  扩展
    
    
    