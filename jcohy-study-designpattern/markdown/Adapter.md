
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 适配器模式
> * [概述](#gaishu)
> * [适配器模式的角色](#role)
> * [适配器模式的分类](#sort)
>   *  [类的适配器模式](#lei)
>   *  [对象的适配器模式](#duixiang)
>   *  [接口的适配器模式](#jiekou)
> * [适配器模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中适配器模式](#java)
> * [扩展](#kuozhan)

<p id ="gaishu" />

##  概述
>  适配器模式：将一个类的接口转化成客户希望的另一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作
>  适配器模式是结构型设计模式的起源。我们来看下面这张图
>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/tree/master/jcohy-studydesign-pattern/src/main/resources/static/images/adapter.png)
##  适配器模式的角色
>  *  Target:对象参与者，决定现在需要什么方法的参与者。即客户端所期待的接口。目标可以是具体的或抽象的类，也可以是接口。
>  *  Adaptee:需要适配的类
>  *  Adapter:通过在内部包装一个Adaptee对象，把源接口转换成目标接口。
>  *  Client:客户端

## 适配器模式的分类
>  *  类的适配器模式：当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式。创建一个新类，继承原有的类，实现新的接口即可。</br>
>  *  对象的适配器模式(委托)：当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个 Wrapper 类，持有原类的一个实例，在 Wrapper 类的方法中，调用实例的方法就行。</br>
>  *  接口的适配器模式：当不希望实现一个接口中所有的方法时，可以创建一个抽象类 Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可</br>

##  适配器模式的实现
>  *  Adaptee

        // 已存在的、具有特殊功能、但不符合我们既有的标准接口的类
        class Adaptee {
            public void specificRequest() {
                System.out.println("被适配类具有 特殊功能...");
            }
        }

>  *  Target目标接口

        public  interface Target {
            public void request();
        }

>  *  ConcreteTarget

        // 具体目标类，只提供普通功能
        public class ConcreteTarget implements Target {
            public void request() {
                System.out.println("普通类 具有 普通功能...");
            }
        }

>  *  Adapter

        class Adapter extends Adaptee implements Target{
            public void request() {
                super.specificRequest();
            }
        } 
>  *  Client

                Target concreteTarget = new ConcreteTarget();
        		concreteTarget.request();
        		
        		// 使用特殊功能类，即适配类
        		Target adapter = new Adapter();
        		adapter.request(); 
       		     
<p id ="qa" />

##  Q&A

<p id ="java" />

## Java语言中原型模式
>  *  java.util.Arrays#asList()
>  *  javax.swing.JTable(TableModel)
>  *  java.io.InputStreamReader(InputStream)
>  *  java.io.OutputStreamWriter(OutputStream)
>  *  javax.xml.bind.annotation.adapters.XmlAdapter#marshal()
>  *  javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal()

<p id ="kuozhan" />
