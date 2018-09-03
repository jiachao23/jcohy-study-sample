

#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 状态模式
> * [概述](#gaishu)
> * [状态模式的角色](#role)
> * [状态模式的应用场景](#sign)
> * [状态模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中状态模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  状态模式: 当一个对象的内部状态改变时，允许改变其行为，这个对象像是看起来改变了其类。

<p id="role">

## 状态模式的角色

>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-designpattern/src/main/resources/static/images/state.png)
>  *  state:抽象状态类，定义一个接口以封装 与COntext的一个特定状态相关的行为。
>  *  Context: 维护一个ConcreteState子类的实例，这个实例定义当前的状态。
>  *  ConcreteState(A,B,C....)：具体状态，每一个子类实现一个与Context相关的状态的行为。

<p id="sign">

##  状态模式的应用场景

>  当一个对象的行为取决与他的状态时，并且他必须在运行时刻根据状态改变他的行为时，就可以考虑使用状态模式。

<p id="shixian">

## 状态模式的实现

>  见代码[State](https://github.com/jiachao23/IdeaStudy/tree/master/src/com/study/designpattern/State)

javax.faces.lifecycle.LifeCycle#execute()

<p id="qa">

##  Q&A


<p id="java">

##  Java语言中状态模式

>  *  java.util.Iterator
>  *  javax.faces.lifecycle.LifeCycle#execute()


<p id="kuozhan">

##  扩展

