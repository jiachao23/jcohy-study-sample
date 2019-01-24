
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 策略模式
> * [概述](#gaishu)
> * [策略模式的角色](#role)
> * [策略模式的应用场景](#sign)
> * [策略模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中策略模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  它定义了算法家族，分别封装起来，让他们之间可以相互替换。此模式让算法的变化，不会影响到使用算法的客户。

<p id="role">

## 策略模式的角色

>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-designpattern/images/strategy.png)
>  *  Context

>  Context上下文，用一个ConcreteStrategy来配置，维护一个对Strategy对象的引用。
>  *  Strategy

>   策略类，定义所有支持的算法的公共接口
>  *  ConcreteStrategy(A,B,C,....)

>   具体策略类，封装了具体的算法和行为。继承Strategy。

<p id="sign">

##  策略模式的应用场景



<p id="shixian">

## 策略模式的实现

                  1.定义接口
                  public abstract class  Strategy {
                  
                    public abstract void method();
                  }
                   
                  2.Context
                  
                  public class Context {
                  	Strategy sta;
                  	public Context(Strategy sta) {
                  		this.sta=sta;
                  	}
                  	public void deMethod(){
                  		sta.method();
                  	}
                  }
                    
                  3.StrategyImpl
                  
                  public class StrategyImplA extends Strategy{
                  
                  	@Override
                  	public void method() {
                  		System.out.println("这是A的算法实现");
                  	}
                  
                  }
                  
                  public class StrategyImplB extends Strategy{
                  
                  	@Override
                  	public void method() {
                  		System.out.println("这是B的算法实现");
                  	}
                  
                  }
                
                  public class StrategyImplC extends Strategy {
                  
                  	@Override
                  	public void method() {
                  		System.out.println("这是C的算法实现");
                  	}
                  
                  }
                  
                  
                  4.Client
                  
                  public static void main(String[] args) {
                  		Context ctx1 = new Context(new StrategyImplA());
                  		Context ctx2 = new Context(new StrategyImplB());
                  		Context ctx3 = new Context(new StrategyImplC());
                  		ctx1.deMethod();
                  		ctx2.deMethod();
                  		ctx3.deMethod();
                  }
                  
                  5.result
                  
                    这是A的算法实现
                    这是B的算法实现
                    这是C的算法实现
         
<p id="qa">

##  Q&A

       
<p id="java">
        
##  Java语言中策略模式

>  *  java.util.Comparator#compare()
>  *  javax.servlet.http.HttpServlet
>  *  javax.servlet.Filter#doFilter()


<p id="kuozhan">

##  扩展
    