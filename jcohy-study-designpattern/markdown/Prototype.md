
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 原型模式
> * [概述](#gaishu)
> * [原型模式的实现](#method)
>   *  [原型模式的使用场景](#sight)
>   *  [原型模式的参与者](#role)
>   *  [原型模式的实现](#impl)
> * [Q&A](#qa)
> * [Java语言中原型模式](#java)
> * [扩展](#kuozhan)

<p id ="gaishu" />

## 概述
>  讲一个对象作为原型，对其进行克隆，复制。产生一个与原对象类似的新对象。在Java中，复制对象是通过clone()实现的。
>  这里涉及到对象的深复制和浅复制。什么是深复制，浅复制？</br>
>  浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，还是原对象所指向的。</br>
>  深复制：将一个对象复制后，不论是基本数据类型还是引用类型都会重新创建。</br>

<p id ="gaishu" />

## 原型模式的实现

<p id ="sight" />

####  原型模式的使用场景
>  以new建立对象实例时，都必须指定类名称，但有时候不靠指定类名称的方式就能产生对象的实例，此时，不是利用类建立对象实例，而是复制对象实例另建一个新的对象实例
>  通常这个需求发生在一下几个情况。
>  *  种类过多无法整合成类时:意思是如果处理的对象种类太多，如果要一个个设成不同的类，须产生大量的源程序文件。</br>
>  *  不容易利用类产生实例时：该对象实例产生的过程太过复杂，很难利用类来建立。</br>
>  *  希望把框架和所产生的对象实例分开时。</br>

<p id ="role" />

####  原型模式的参与者

>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-designpattern/src/main/resources/static/images/prototype.png)
>  *  Prototype(原型):Prototype规定复制对象实例建立新对象实例的方法。</br>
>  *  ConcretePrototype:实际上实现先复制对象实例再建立新对象实例的方法。</br>
>  *  Client:利用复制对象的方法以产生另一个新对象实例</br>

<p id ="impl" />

####  实现
        1.声明一个克隆自身的接口（Prototype）
                public class Prototype implements Cloneable{
                    private String name;
                
                    public String getName() {
                        return name;
                    }
                
                    public void setName(String name) {
                        this.name = name;
                    }
                    public Object clone(){
                        try {
                            return super.clone();
                        } catch (CloneNotSupportedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            return null;
                        }
                    }
                }
                
        2.ConcretePrototype
                public class ConcretePrototype extends Prototype {
                	
                	public ConcretePrototype(String name){
                		setName(name);
                	}
                }
                
        3.Client
                public static void main(String[] args) {
                		Prototype pro = new ConcretePrototype("大骗子");
                		Prototype pro1=(Prototype) pro.clone();
                		System.out.println(pro.getName());
                		System.out.println(pro1.getName());
                	}
java中clone()方法做的是浅复制。要实现深复制，需要采用流的形式读入当前对象的二进制输入，再写出二进制数据对应的对象。

<p id ="qa" />

##  Q&A
> *  例子一</br>
>   &nbsp;&nbsp; Q:java.lang.Object类有clone方法，那么，java,lang.Object实现了java.lang.Cloneable接口吗？。</br>
>   &nbsp;&nbsp; A:没有，java.lang.Object并没有实现java.lang.Cloneable接口。如果实现了java.lang.Cloneable接口，无论那个类的对象实例调用clone()方法都不会抛出
CloneNotSupportedException异常

<p id ="java" />

## Java语言中原型模式
>  *  java.lang.Object#clone() (支持浅克隆的类必须实现java.lang.Cloneable 接口)

<p id ="kuozhan" />