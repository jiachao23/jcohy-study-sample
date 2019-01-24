#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 备忘录模式
> * [概述](#gaishu)
> * [备忘录模式的角色](#role)
> * [备忘录模式的应用场景](#sign)
> * [备忘录模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中备忘录模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  备忘录模式：在不破坏封装性的前提下，捕获一个对象的内部状态，并在这个对象之外保存这个状态，这样以后就可将该对象恢复到原先保存的状态。


<p id="role">

## 备忘录模式的角色

>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-designpattern/images/memento.png)
>  *  Originator:负责创建一个备忘录Memento,用来记录当前时刻他的内部状态，并可使用备忘录恢复他的内部状态。
>  *  Memento：负责存储Originator对象的内部状态，并可防止Originator以外的其他对象访问备忘录Memento。
>  *  Caretaker: 负责保存好备忘录Memento

<p id="sign">

##  备忘录模式的应用场景



<p id="shixian">

## 备忘录模式的实现

                        1.
                        public class Original {  
                              
                            private String value;  
                              
                            public String getValue() {  
                                return value;  
                            }  
                          
                            public void setValue(String value) {  
                                this.value = value;  
                            }  
                          
                            public Original(String value) {  
                                this.value = value;  
                            }  
                          
                            public Memento createMemento(){  
                                return new Memento(value);  
                            }  
                              
                            public void restoreMemento(Memento memento){  
                                this.value = memento.getValue();  
                            }  
                        }  
                        
                        2.
                        public class Memento {  
                                
                              private String value;  
                            
                              public Memento(String value) {  
                                  this.value = value;  
                              }  
                            
                              public String getValue() {  
                                  return value;  
                              }  
                            
                              public void setValue(String value) {  
                                  this.value = value;  
                              }  
                          }  
                          
                        3.
                        public class Storage {  
                            
                              private Memento memento;  
                                
                              public Storage(Memento memento) {  
                                  this.memento = memento;  
                              }  
                            
                              public Memento getMemento() {  
                                  return memento;  
                              }  
                            
                              public void setMemento(Memento memento) {  
                                  this.memento = memento;  
                              }  
                        }  
                        4.
                        public class Test {  
                           
                             public static void main(String[] args) {  
                                   
                                 // 创建原始类  
                                 Original origi = new Original("egg");  
                           
                                 // 创建备忘录  
                                 Storage storage = new Storage(origi.createMemento());  
                           
                                 // 修改原始类的状态  
                                 System.out.println("初始化状态为：" + origi.getValue());  
                                 origi.setValue("niu");  
                                 System.out.println("修改后的状态为：" + origi.getValue());  
                           
                                 // 回复原始类的状态  
                                 origi.restoreMemento(storage.getMemento());  
                                 System.out.println("恢复后的状态为：" + origi.getValue());  
                             }  
                        }  
                         
                        5.result
                         初始化状态为：egg
                         修改后的状态为：niu
                         恢复后的状态为：egg

         
<p id="qa">

##  Q&A

       
<p id="java">
        
##  Java语言中备忘录模式

>  *  java.util.Date
>  *  java.io.Serializable
>  *  javax.faces.component.StateHolder

<p id="kuozhan">

##  扩展
    
    
    