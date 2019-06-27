
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 责任链模式
> * [概述](#gaishu)
> * [责任链模式的角色](#role)
> * [责任链模式的应用场景](#sign)
> * [责任链模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中责任链模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  责任链模式:使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合程度，将这个对象连成一个链，并沿着这条链处理请求，直到有一个对象能处理他为止。


<p id="role">

## 责任链模式的角色
![结构图](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-designpattern/images/chainofresponsibility.png)
>  *  Handler

>  定义一个处理请求的接口

>  *  ConcreteHandler（1，2。。。）

>  具体处理者类，处理他所负责的请求，可访问他的后继者，如果可以处理此请求，就处理，反之，将他转发给他的后继者。

>  *  Client

<p id="sign">

##  责任链模式的应用场景



<p id="shixian">

## 责任链模式的实现

     
                             1.定义一个问题
                             
                             /**
                              * 表示发生问题的类，内有问题编号
                              * @author jiachao
                              */
                             public class Trouble {
                                 private int number;//
                             
                                 public Trouble(int number) {
                                     this.number = number;
                                 }
                             
                                 public int getNumber() {
                                     return number;
                                 }
                             
                                 public void setNumber(int number) {
                                     this.number = number;
                                 }
                             
                                 @Override
                                 public String toString() {
                                     return "Trouble [number=" + number + "]";
                                 }
                             
                             }
                             
                             2.解决问题的接口   
                                
                                
                                public abstract class Support {
                                    // 问题解决者的名称
                                    private String name;
                                    // 转向位置
                                    private Support next;
                                
                                    // 产生问题的解决者
                                    public Support(String name) {
                                        this.name = name;
                                    }
                                
                                    public Support setNext(Support next) {
                                        this.next = next;
                                        return next;
                                    }
                                
                                    public final void support(Trouble trouble) {
                                        if (resolve(trouble)) {
                                            done(trouble);
                                        } else if (next != null) {
                                            next.support(trouble);
                                        } else {
                                            fail(trouble);
                                        }
                                    }
                                    //尚未解决的
                                    protected  void fail(Trouble trouble) {
                                        System.out.println(trouble+"cannot be resolved !");
                                    }
                                    //已解决
                                    protected  void done(Trouble trouble) {
                                        System.out.println(trouble+"is resolved by"+ this);
                                    }
                                    //解决的方法
                                    protected abstract boolean resolve(Trouble trouble);
                                
                                    @Override
                                    public String toString() {
                                        return "Support [name=" + name + "]";
                                    }
                                
                                }
                                
                                
                                3.具体解决者
                                
                                
                                /**
                                 * 解决问题具体类（永远不处理）
                                 */
                                public class NoSupport extends Support {
                                
                                    public NoSupport(String name) {
                                        super(name);
                                    }
                                    //解决的方法，自己不做处理
                                    @Override
                                    protected boolean resolve(Trouble trouble) {
                                        return false;
                                    }
                                
                                }
                                
                                /**
                                 * 解决问题具体类（解决小余指定号码的类）
                                 */
                                public class LimitSupport extends Support {
                                    private int limit;//若小余次号码可解决
                                    public LimitSupport(String name, int limit) {
                                        super(name);
                                        this.limit = limit;
                                    }
                                
                                    @Override
                                    protected boolean resolve(Trouble trouble) {
                                        if(trouble.getNumber()<limit) {
                                            return true;
                                        }
                                        return false;
                                    }
                                
                                }
                        
                        
                                /**
                                 * 解决问题具体类（解决奇数号码的问题）
                                 */
                                public class OddSupport extends Support {
                                
                                    public OddSupport(String name) {
                                        super(name);
                                    }
                                
                                    @Override
                                    protected boolean resolve(Trouble trouble) {
                                        if(trouble.getNumber()%2 ==1) {
                                            return true;
                                        }
                                        return false;
                                    }
                                
                                }
                                
                                
                                
                                /**
                                 * 解决问题具体类（解决特殊号码的问题）
                                 */
                                public class SpecialSupport extends Support {
                                
                                    private int number;//只能解决此号码的问题
                                    public SpecialSupport(String name,int number) {
                                        super(name);
                                        this.number = number;
                                    }
                                
                                    @Override
                                    protected boolean resolve(Trouble trouble) {
                                        if(trouble.getNumber()==number) {
                                            return true;
                                        }
                                        return false;
                                    }
                                
                                }
                                
                                
                                4.
                                
                                public class Client {
                                    public static void main(String[] args) {
                                        Support alice = new NoSupport("alice");
                                        Support bob = new LimitSupport("Bob", 100);
                                        Support charlie = new SpecialSupport("charlie", 429);
                                        Support diana = new LimitSupport("diana", 200);
                                        Support elmo = new OddSupport("elmo");
                                        Support fred = new LimitSupport("fred", 300);
                                
                                        //形成链
                                        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
                                        for(int i=0;i<500;i+=33) {
                                            alice.support(new Trouble(i));
                                        }
                                
                                    }
                                }
                                
                                
                                5.result
                                
                                Trouble [number=0]is resolved bySupport [name=Bob]
                                Trouble [number=33]is resolved bySupport [name=Bob]
                                Trouble [number=66]is resolved bySupport [name=Bob]
                                Trouble [number=99]is resolved bySupport [name=Bob]
                                Trouble [number=132]is resolved bySupport [name=diana]
                                Trouble [number=165]is resolved bySupport [name=diana]
                                Trouble [number=198]is resolved bySupport [name=diana]
                                Trouble [number=231]is resolved bySupport [name=elmo]
                                Trouble [number=264]is resolved bySupport [name=fred]
                                Trouble [number=297]is resolved bySupport [name=elmo]
                                Trouble [number=330]cannot be resolved !
                                Trouble [number=363]is resolved bySupport [name=elmo]
                                Trouble [number=396]cannot be resolved !
                                Trouble [number=429]is resolved bySupport [name=charlie]
                                Trouble [number=462]cannot be resolved !
                                Trouble [number=495]is resolved bySupport [name=elmo]

         
<p id="qa">

##  Q&A

       
<p id="java">
        
##  Java语言中责任链模式


>  *  java.util.logging.Logger#log()
>  *  javax.servlet.Filter#doFilter()

<p id="kuozhan">

##  扩展
    
    
    