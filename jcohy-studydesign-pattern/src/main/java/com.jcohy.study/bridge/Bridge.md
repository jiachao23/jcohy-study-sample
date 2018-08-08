
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 桥接模式
> * [概述](#gaishu)
> * [桥接模式的角色](#role)
> * [桥接模式的应用场景](#sign)
> * [桥接模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中桥接模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  将抽象部分和他的实现部分分离，使他们都可以独立的变化。也就是说，实现系统可能有很多角度分类，每一种分类都有可能变化，那么就把这种多角度分离出来，
>  让他们独立变化，减少他们之间的耦合


<p id="role">

## 桥接模式的角色

>  *  Abstraction()

>   抽象话给出一个定义，并保存一个对实现化的引用。
>  *  RefinedAbstration

>  被提炼的抽象，扩展抽象化角色，改正和修正父类对抽象化的定义。
>  *  Implementor

>   实现化角色，但不给出具体实现。
>  *  ConcreteImplementor(A,B,C.....)

>  具体化实现角色，这个角色给出实现化角色的具体实现。
<p id="sign">

##  桥接模式的应用场景

>  *  如果一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性，避免在两个层次之间建立静态的关系
>  *  设计要求实现化角色的任何变化不应当影响客户端，实现化角色的改变对客户端是透明的。
>  *  一个构件有多余一个的抽象化角色和实现化角色。系统需要他们之间进行动态耦合。
>  *  虽然系统中使用继承是没有问题的，但是由于抽象化角色和具体化角色需要独立的变化，设计要求需要独立管理这两者。

<p id="shixian">

## 桥接模式的实现
        模拟JDBC
                        1.定义一个接口。Dirver
                        public interface Dirver {
                          void connection();
                        }
                        
                        2.接口实现
                        public class MysqlDirver implements Dirver {
                        
                            @Override
                            public void connection() {
                                
                                System.out.println("implement mysql connection");
                            }
                        
                        }
                        
                        public class OracleDirver implements Dirver {
                        
                            @Override
                            public void connection() {
                                System.out.println("implement oracle connection");
                        
                            }
                        
                        }
                        
                        
                        public class SqlSerDirver implements Dirver {
                        
                            @Override
                            public void connection() {
                                System.out.println("implement sqlserver connection");
                                
                            }
                        
                        }
                        
                        3.Briage
                        
                        public abstract class JDBC {
                            private Dirver dirver;
                        
                            public void connection() {
                                dirver.connection();
                            }
                        
                            public Dirver getDirver() {
                                return dirver;
                            }
                        
                            public void setDirver(Dirver dirver) {
                                this.dirver = dirver;
                            }
                        }
                
                            
                        4.具体实现
                        
                        public class MyBriage extends JDBC{
                        
                            public void connection() {
                                getDirver().connection();
                            }
                        }
                        
                        5.Client
                        
                        public class Client {
                            public static void main(String[] args) {
                               	JDBC jdbc = new DirverManange();
                                Dirver mysql = new MysqlDirver();
                                jdbc.setDirver(mysql);
                                jdbc.connection();
                           
                                Dirver oracle = new OracleDirver();
                                jdbc.setDirver(oracle);
                                jdbc.connection();
                           
                                Dirver sqlserver = new SqlSerDirver();
                                jdbc.setDirver(sqlserver);
                                jdbc.connection();
                            }
                        }
                
                        6.result
                        
                        implement mysql connection
                        implement oracle connection
                        implement sqlserver connection

        
        


         
<p id="qa">

##  Q&A


       
<p id="java">
        
##  Java语言中桥接模式

>  *  AWT (提供了抽象层映射于实际的操作系统)
>  *  JDBC


<p id="kuozhan">

##  扩展
    
    
    
最后附上代码的地址[Briage](https://github.com/jiachao23/IdeaStudy/tree/master/src/com/study/designpattern/Briage)    