
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 组合模式
> * [概述](#gaishu)
> * [组合模式的角色](#role)
> * [组合模式的应用场景](#sign)
> * [组合模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中组合模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  将对象组合成树形结构以表示‘部分-整体’的层次结构，组合模式使得用户对单个对象和组合对象的使用的一致性。


<p id="role">

##  组合模式的角色
>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/tree/master/jcohy-studydesign-pattern/src/main/resources/static/images/composite.png)

>  *  Component

>   组合中的对象声明接口，在适当情况下，实现所有类公共接口的默认行为，声明一个接口用于访问和管理的子部件。
>  *  Leaf

>   在组合中表示叶节点对象，叶节点没有子节点。
>  *  Composite

>   定义有枝节点行为，用来存储子部件，在Component接口中实现与子部件相关的操作。
>  *  Client

<p id="sign">

##  组合模式的应用场景



<p id="shixian">

##  组合模式的实现

     //以文件和目录的结构为例。在程序中，File表示文件，Directory表示目录。
     //两者合并起来就是父类Entry类，表示目录进入点的类。对File和Directory一视同仁的类。   
                1.Entry
                public abstract class Entry {
                	public abstract String getName();
                	public abstract int getSize();
                	public Entry add(Entry entry) throws FileTreatmentException {
                		throw new FileTreatmentException();
                	}
                	
                	public void printList() {
                		printList("");
                	}
                	protected abstract void printList(String prefix);
                	@Override
                	public String toString() {
                		return getName() + "(" + getSize() + ")";
                	}
                	
                	
                }
                
                2.File
                
                public class File extends Entry {
                	private String name;
                	private int size;
                	
                	
                	public File(String name, int size) {
                		this.name = name;
                		this.size = size;
                	}
                
                	@Override
                	public String getName() {
                		return this.name;
                	}
                
                	@Override
                	public int getSize() {
                		return this.size;
                	}
                
                	@Override
                	protected void printList(String prefix) {
                		System.out.println(prefix+"/"+this);
                	}
                
                }
                
                3.Directory
                
                public class Directory extends Entry {
                	
                	private String name;
                	private Vector<Entry> directory = new Vector<Entry>();
                	
                	public Directory(String name) {
                		this.name = name;
                	}
                	@Override
                	public String getName() {
                		return name;
                	}
                
                	@Override
                	public int getSize() {
                		int size = 0;
                		Iterator<Entry> it = directory.iterator();
                		while(it.hasNext()) {
                			Entry entry  = (Entry)it.next();
                			size+=entry.getSize();
                		}
                		return size;
                	}
                
                	@Override
                	protected void printList(String prefix) {
                		System.out.println(prefix+"/"+this);
                		Iterator<Entry> it = directory.iterator();
                		while(it.hasNext()) {
                			Entry entry  = (Entry)it.next();
                			entry.printList(prefix+"/"+name);
                		}
                	}
                	public Entry add(Entry entry) {
                		directory.add(entry);
                		return this;
                	}
                	
                }
                
                4.Client
                public class Client {
                  	public static void main(String[] args) {
                  		
                  		System.out.println("Root directory");
                  		Directory rootDirectory = new Directory("root");
                  		Directory binDirectory = new Directory("bin");
                  		Directory tmpDirectory = new Directory("tmp");
                  		Directory usrDirectory = new Directory("usr");
                  		
                  		rootDirectory.add(binDirectory);
                  		rootDirectory.add(tmpDirectory);
                  		rootDirectory.add(usrDirectory);
                  		
                  		binDirectory.add(new File("vi.txt",100));
                  		binDirectory.add(new File("late.txt",100));
                  		
                  		rootDirectory.printList();
                  		
                  	}
                 }

                5.result
                
                Root directory
                /root(200)
                /root/bin(200)
                /root/bin/vi.txt(100)
                /root/bin/late.txt(100)
                /root/tmp(0)
                /root/usr(0)
<p id="qa">

##  Q&A

       
<p id="java">
        
##  Java语言中组合模式

>  *  javax.swing.JComponent#add(Component)
>  *  java.awt.Container#add(Component)
>  *  java.util.Map#putAll(Map)
>  *  java.util.List#addAll(Collection)
>  *  java.util.Set#addAll(Collection)


<p id="kuozhan">

##  扩展
    
    
    