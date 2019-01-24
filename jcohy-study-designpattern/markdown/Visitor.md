

#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 访问者模式
> * [概述](#gaishu)
> * [访问者模式的角色](#role)
> * [访问者模式的应用场景](#sign)
> * [访问者模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中访问者模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  访问者模式：表示一个作用于某对象结构中的各元素的操作。它可以使你在不改变各元素的类的前提下定义作用与这些元素的新操作。

<p id="role">

## 访问者模式的角色

>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-designpattern/images/visitor.png)

<p id="sign">

##  访问者模式的应用场景



<p id="shixian">

## 访问者模式的实现

>  *  Visitor:为该对象结构中的ConcreteElement的每一个类声明一个Visit操作。 
>  *  ConcreteVisit（1、2、3...）:具体访问者，实现每个由Visitor声明的操作，每个操作实现算法的一部分，而该算法的片段乃是对应于结构中对象的类。
>  *  Element:定义一个Accept操作，他以一个访问者为参数。
>  *  ConcreteElement(1、2、3...):具体元素，实现Accept操作。
>  *  ObjectStructure:能枚举他的元素，可以提供一个高层的接口以访问者访问他的元素。
>  *  Client:


<p id="qa">

##  Q&A


<p id="java">

##  Java语言中访问者模式

>  *  javax.lang.model.element.AnnotationValue 和 AnnotationValueVisitor
>  *  javax.lang.model.element.Element 和 ElementVisitor
>  *  javax.lang.model.type.TypeMirror 和 TypeVisitor

<p id="kuozhan">

##  扩展

