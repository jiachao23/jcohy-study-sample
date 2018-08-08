
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 代理模式
> * [概述](#gaishu)
> * [代理模式的角色](#role)
> * [代理模式的分类](#sign)
> * [代理模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中代理模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  代理模式：为其他对象提供一种代理以控制对这个对象的访问。


<p id="role">

## 代理模式的角色

>  *  Subject:定义了RealSubject和Proxy的公共接口，这样就可以在任何使用RealSubject的地方可以使用Proxy
>  *  RealSubject:定义Proxy代表的真实实体。
>  *  Proxy：保存一个引用使得代理可以访问实体，并提供一个与Subject接口相同的接口，这样代理就可以用来代替实体。
>  *  Client:

<p id="sign">

##  代理模式的分类

>  *  远程代理
>  为一个对象在不同的地址空间，提供局部代表。这样可以隐藏一个对象存在于不同地址空间的事实.例如，WebService在.Net中的应用。</br>
>  *  虚拟代理
>  根据需要创建开销很大的对象，通过他来存放实例化需要很长时间的对象。例如，你打开了一个网页，里面有很多文字和图片。此时，你所看到的是所有文字，图片只有
>  在下载后才能看到。那些未打开的图片框，就是通过虚拟代理代替了真实的图片，存储了真是图片的路径和尺寸。</br>
>  *  安全代理
>  用来控制真是对象的访问权限。一般用于对象拥有不同的访问权限。
>  *  智能代理
>  是指当调用真是对象的时候，代理处理另外一些事。

<p id="shixian">

## 代理模式的实现

        
        1.定义接口
        
                public interface Subject {
                    void method();
                }
        
        2.RealSubject
        
                public class RealSubject implements Subject {
                    @Override
                    public void method() {
                        System.out.println("afternoon");
                    }
                
                }

        3.Proxy
        
               public class Proxy implements Subject {
               	private RealSubject realSubject;
               
               	public Proxy() {
               		realSubject = new RealSubject();
               	}
               
               	public void after() {
               		System.out.println("Good Night!");
               	}
               
               	@Override
               	public void method() {
               		before();
               		realSubject.method();
               		after();
               	}
               
               	public void before() {
               		System.out.println("Hello Moring");
               	}
               }
                
                
         4.Client
         
                 public class Client {
                    public static void main(String[] args) {
                        Subject su = new Proxy();
                        su.method();
                    }
                 }
          
         5.result
                
                Hello Moring
                afternoon
                Good Night!

         
<p id="qa">

##  Q&A

       
<p id="java">
        
##  Java语言中代理模式
 
>  *  java.lang.reflect.Proxy
>  *  java.rmi.*



<p id="kuozhan">

##  扩展
    
    
    
最后附上代码的地址[Proxy](https://github.com/jiachao23/IdeaStudy/tree/master/src/com/study/designpattern/Proxy)    