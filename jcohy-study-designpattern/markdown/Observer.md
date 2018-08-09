
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 观察者模式
> * [概述](#gaishu)
> * [观察者模式的角色](#role)
> * [观察者模式的应用场景](#sign)
> * [观察者模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中观察者模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  观察者模式：定义了一种一对多的依赖关系，让多个观察者对象监听某一主题对象，这个主题对象在状态发生变化时，会通知所有观察者对象，使他们能够自动更新自己。


<p id="role">

## 观察者模式的角色

>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-studydesign-pattern/src/main/resources/static/images/observer.png)
>  *  Subject:

>  他把所有观察者对象的引用保存在一个聚类中，每个主题都可以有任务数量的观察者，抽象主题提供一个接口，可以增加和删除观察者对象。
>  *  Observer:

>  抽象观察者，为所有的具体观察者定义一个接口，在得到主题的通知时更新自己。
>  *  ConcretetSubject：

>  具体主题，将有关状态存入具体观察者对象，在具体主题的内部状态改变时，给所有登记过的观察者发出通知。
>  *  ConcreteObserver:

>  具体观察者，实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态相协调。

<p id="sign">

##  观察者模式的应用场景



<p id="shixian">

## 观察者模式的实现

                    
                    
                                1。
                                    /**
                                     * 观察者接口
                                     * @author jiachao
                                     */
                                    public interface Observer {
                                        void update(NumberGenerator numberGenerator);
                                    }
                                
                                2.
                                
                                    /**
                                     * 产生数值的抽象类，notifyObservers告诉所有的Observers内容改变。
                                     * @author jiachao
                                     */
                                    public abstract class NumberGenerator {
                                        private Vector<Observer> observers = new Vector<Observer>();
                                        
                                        public void addObserver(Observer observer) {
                                            observers.add(observer);
                                        }
                                        
                                        public void deleteObserver(Observer observer) {
                                            observers.remove(observer);
                                        }
                                        
                                        public void notifyObservers() {
                                            Iterator<Observer> it = observers.iterator();
                                            while(it.hasNext()) {
                                                Observer o = (Observer)it.next();
                                                o.update(this);
                                            }
                                        }
                                        
                                        public abstract int getNum() ;
                                        public abstract void excuteNum();
                                    }
            
                                3.
                                
                                    /**
                                     * 产生随机数
                                     * @author jiachao
                                     */
                                    public class RandomNumberGenerator extends NumberGenerator {
                                        Random rd = new Random();
                                        private int number = 0;
                                        @Override
                                        public int getNum() {
                                            return number;
                                        }
                                        @Override
                                        public void excuteNum() {
                                            for(int i=0;i<10;i++) {
                                                number = rd.nextInt(50);
                                                // TODO Auto-generated method stub
                                                notifyObservers();
                                            }
                                        }
                                    
                                    }
                                
                                4.
                                
                                    /**
                                     * 实现Observer接口,以“*”来表示观察到的数值
                                     * @author jiachao
                                     */
                                    public class GraphObserver implements Observer {
                                    
                                        @Override
                                        public void update(NumberGenerator numberGenerator) {
                                            System.out.println("GraphObserver:");
                                            int count = numberGenerator.getNum();
                                            for(int i=0;i<count;i++) {
                                                System.out.print("*");
                                            }
                                            System.out.println();
                                            try {
                                                Thread.sleep(100);
                                            } catch (InterruptedException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                            }
                                        }
                                    
                                    }
                                    
                                
                                    /**
                                     * 实现Observer接口,以“数字”来表示观察到的数值
                                     * @author jiachao
                                     */
                                    public class DigitObserver implements Observer{
                                    
                                        @Override
                                        public void update(NumberGenerator numberGenerator) {
                                            System.out.println("DigitObserver:"+numberGenerator.getNum());	
                                            try {
                                                Thread.sleep(100);
                                            } catch (InterruptedException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                            }
                                        }
                                    
                                    }
                                
                                5.Client
                                
                                    public class Client {
                                        public static void main(String[] args) {
                                            NumberGenerator generator = new RandomNumberGenerator();
                                            Observer o1 = new DigitObserver();
                                            Observer o2 = new GraphObserver();
                                            generator.addObserver(o1);
                                            generator.addObserver(o2);
                                            generator.excuteNum();
                                        }
                                    }
                                
                                6.result
                                
                                
                                    DigitObserver:0
                                    GraphObserver:
                                    
                                    DigitObserver:7
                                    GraphObserver:
                                    *******
                                    DigitObserver:6
                                    GraphObserver:
                                    ******
                                    DigitObserver:48
                                    GraphObserver:
                                    ************************************************
                                    DigitObserver:10
                                    GraphObserver:
                                    **********
                                    DigitObserver:7
                                    GraphObserver:
                                    *******
                                    DigitObserver:5
                                    GraphObserver:
                                    *****
                                    DigitObserver:8
                                    GraphObserver:
                                    ********
                                    DigitObserver:5
                                    GraphObserver:
                                    *****
                                    DigitObserver:11
                                    GraphObserver:
                                    ***********


         
<p id="qa">

##  Q&A

       
<p id="java">
        
##  Java语言中观察者模式

>  *  java.util.Observer/java.util.Observable
>  *  java.util.EventListener (所有子类)
>  *  javax.servlet.http.HttpSessionBindingListener
>  *  javax.servlet.http.HttpSessionAttributeListener
>  *  javax.faces.event.PhaseListener


<p id="kuozhan">

##  扩展
    
    
    