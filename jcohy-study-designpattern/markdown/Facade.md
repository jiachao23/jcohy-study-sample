
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 外观模式
> * [概述](#gaishu)
> * [外观模式的角色](#role)
> * [外观模式的应用场景](#sign)
> * [外观模式模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中外观模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  为子系统中的一组接口提供一个一致的界面， 此模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。


<p id="role">

## 外观模式的角色

>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/jcohy-study-designpattern/master/jcohy-studydesign-pattern/src/main/resources/static/images/facade.png)
>  * Facade
>  外观类，知道那些子系统类负责处理请求。将客户的请求代理给适当的子系统对象。
>  *  SubSystem（One，Two，Three，。。。。）
>  子系统类集合，实现子系统功能，处理Facade对象指派的任务，注意子类没有Facade对象的任何信息，即没有对Facade对象的引用。
>  *  Client
<p id="sign">

##  外观模式的应用场景



<p id="shixian">

## 外观模式的实现

####  以启动一个计算机启动过程为例。

                1.Facade(computer) 
                    public class Computer {
                        private Cpu cpu;
                        private Memory memory;
                        private Disk disk;
                        
                        public Computer() {
                            cpu = new Cpu();
                            memory = new Memory();
                            disk = new Disk();
                        }
                        
                        public void startup() {
                            System.out.println("computer startup");
                            cpu.startup();
                            memory.startup();
                            disk.startup();
                            System.out.println("computer startup finished");
                            
                        }
                        
                        public void shutdown() {
                            System.out.println("computer shutdown");
                            cpu.shutdown();
                            memory.shutdown();
                            disk.shutdown();
                            System.out.println("computer shutdown finished");
                        }
                    }       
                2.System(cpu,memory,disk)
                
                    public class Cpu {
                    	public void startup() {
                    		System.out.println("cpu startup");
                    	}
                    
                    	public void shutdown() {
                    		System.out.println("cpu shutdown");
                    	}
                    
                    }
                    
                    
                    public class Memory {
                    	public void startup() {
                    		System.out.println("memory startup");
                    	}
                    
                    	public void shutdown() {
                    		System.out.println("memory shutdown");
                    	}
                    }
                    
                    public class Disk {
                    	public void startup() {
                    		System.out.println("disk startup");
                    	}
                    
                    	public void shutdown() {
                    		System.out.println("disk shutdown");
                    	}
                    }
                    
                3.client
                    
                    public class Client {
                    	public static void main(String[] args) {
                    		Computer computer = new Computer();
                    		computer.startup();
                    		computer.shutdown();
                    	}
                    }
                    
                4.result
                
                    computer startup
                    cpu startup
                    memory startup
                    disk startup
                    computer startup finished
                    computer shutdown
                    cpu shutdown
                    memory shutdown
                    disk shutdown
                    computer shutdown finished


         
<p id="qa">

##  Q&A

       
<p id="java">
        
##  Java语言中外观模式

>  *  java.lang.Class
>  *  javax.faces.webapp.FacesServlet


<p id="kuozhan">

##  扩展
    
    
    