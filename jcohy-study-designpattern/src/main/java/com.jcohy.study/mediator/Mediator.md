


#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 中介者模式
> * [概述](#gaishu)
> * [中介者模式的角色](#role)
> * [中介者模式的应用场景](#sign)
> * [中介者模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中中介者模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  中介者模式:用一个中介对象来封装一系列的对象交互，中介者使个对象不需要显式的相互引用，从而使其耦合松散，而且可以独立的改变他们之间的交互。


<p id="role">

## 中介者模式的角色

>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-studydesign-pattern/src/main/resources/static/images/mediator.png)
>  *  Mediator :抽象中介者，定义了同事对象到中介者对象之间的接口。
>  *  Colleague：同事对象。
>  *  ConcreteMediator：具体中介者对象，实现抽象类的方法，他需要知道所有具体的同事类，并从具体同事接受消息，向具体同事对象发送命令。
>  *  ConcreteColleague: 具体同事类，每个具体同事只知道自己的行为，而不知道其他同事类的行为，但他们都认识中介者对象。

<p id="sign">

##  中介者模式的应用场景



<p id="shixian">

## 中介者模式的实现



<p id="qa">

##  Q&A


<p id="java">

##  Java语言中中介者模式

>  *  java.util.Timer (所有 scheduleXXX()方法)
>  *  java.util.concurrent.Executor#execute()
>  *  java.util.concurrent.ExecutorService (invokeXXX()和 submit()方法)
>  *  java.util.concurrent.ScheduledExecutorService (所有 scheduleXXX()方法)
>  *  java.lang.reflect.Method#invoke()


<p id="kuozhan">

##  扩展

