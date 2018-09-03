
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 亨元模式
> * [概述](#gaishu)
> * [亨元模式的角色](#role)
> * [亨元模式的应用场景](#sign)
> * [亨元模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中亨元模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  利用共享技术有效的支持大量细粒度的对象。

<p id="role">

## 亨元模式的角色

>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/tree/master/jcohy-studydesign-pattern/src/main/resources/static/images/flyweight.png)
>  *  FlyweightFactory

>   一个亨元工厂，用来创建并管理Flyweight对象，他主要是用来确保合理的共享Flyweight，当一个用户请求Flyweight时，FlyweightFactory对象提供一个已经创建好的实例或创建一个（当没有时）
>  *  Flyweight

>   所有具体亨元类的超类或者接口，通过这个接口，Flyweight可以接受并作用于外部状态。
>  *  ConcreteFlyweight

>   继承或者实现Flyweight，并未内部状态增加存储空间。
>  *  UnsharedConcreteFlyweight

>   指那些不需要共享的Flyweight子类，因为Flyweight接口共享成为可能，但他不强制要求共享 。
>  *  Client

>


<p id="sign">

##  亨元模式的应用场景

>  *  如果一个应用程序使用了大量的对象，而这些对象造成了很大的存储开销。

<p id="shixian">

## 亨元模式的实现

              


         
<p id="qa">

##  Q&A



<p id="java">
        
##  Java语言中亨元模式

>  *  java.lang.Integer#valueOf(int)
>  *  java.lang.Boolean#valueOf(boolean)
>  *   java.lang.Byte#valueOf(byte)
>  *  java.lang.Character#valueOf(char)


<p id="kuozhan">

##  扩展
    
    
    


