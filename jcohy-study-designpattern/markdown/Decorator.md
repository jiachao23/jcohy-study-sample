
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 装饰器模式
> * [概述](#gaishu)
> * [装饰器模式的角色](#role)
> * [装饰器模式的应用场景](#sign)
> * [装饰器模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中装饰器模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  装饰器模式:动态的给一个对象添加一些额外的职责，就增加功能来说，装饰器模式比生产子类更加灵活。</br>

<p id="role">

## 装饰器模式的角色

>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/jcohy-study-designpattern/master/jcohy-studydesign-pattern/images/decorator.png)
>  * Component </br>
>   &nbsp;&nbsp;Component定义了一个对象接口，可以动态的给这些对象添加职责。</br>
>  * ConcreteComponent </br>
>  &nbsp;&nbsp;ConcreteComponent定义了一个具体的对象，也可以给这个对象添加一些职责。</br>
>  * Decorator </br>
>  &nbsp;&nbsp;Decorator，装饰的抽象类。继承了Component，从外类来扩展Component的功能，但对于Component来说，是无需知道Decorator的存在的。 </br>
>  * ConcreteDecorator </br>
>  &nbsp;&nbsp;ConcreteDecorator具体的装饰对象，给Component添加职责的功能。</br>

<p id="sign">

##  装饰器模式的应用场景

>  * 需要扩展一个类的功能。
>  * 动态的为一个对象增加功能，而且还能动态撤销。

<p id="shixian">

## 装饰器模式的实现

>  ### 本例演示一个在字符串周围装饰上外框在打印出来的程序。装饰外框是以+，-，|等字符组成的框线。
>  +-----------------+  </br>
>  |&nbsp;&nbsp;&nbsp;hello world&nbsp;&nbsp;&nbsp;|  </br>
>  +-----------------+  </br>

        
        1.定义一个Display类，是打印多行字符串的抽象类
        
                public abstract class Display {
                    
                    public abstract int getColumns();//取得横向的字数
                    public abstract int getRows();//取得纵向的行数
                    public abstract String getRowText(int row);//取得第Row个字符串
                    public final void show() {//打印所有内容
                        for(int i=0;i<getRows();i++) {
                            System.out.println(getRowText(i));
                        }
                    }
                }

        2.StringDisplay:打印整行字符串的实现类。
        
                public  class StringDisplay extends Display {
                    
                    private String string;//打印的字符串
                    
                    public StringDisplay(String string ) {
                            this.string=string;
                    }
                    @Override
                    public int getColumns() {
                        return string.getBytes().length;
                    }
                
                    @Override
                    public int getRows() {
                        return 1;
                    }
                    @Override
                    public String getRowText(int row) {
                        if(row ==0) {
                            return string;
                        }else {
                            return null;
                        }
                    }
                
                }
                
        3.Border：Border类表示装饰外框的抽象类。虽然定义为装饰外框的的类，但仍定义为打印字符串Display的子类。
        
  
                public abstract class Border extends Display {
                
                    protected Display display;//指装饰外框里面的内容
                    
                    public  Border(Display display) {
                        this.display=display;
                    }
                }

        4.SideBorder：是一种具体的外框，也是Border类的子类。
        
                package com.jcohy;
                
                public class SideBorder extends Border {
                	
                	private char borderChar;//装饰的字符
                	public SideBorder(Display display,char borderChar) {
                		super(display);
                		this.borderChar=borderChar;
                	}
                	@Override
                	public int getColumns() {//字数要再加上内容，两边的装饰字符
                		return 1+display.getColumns()+1;
                	}
                
                	@Override
                	public int getRows() {
                		// TODO Auto-generated method stub
                		return display.getRows();
                	}
                
                	@Override
                	public String getRowText(int row) {//指定行的两边加上装饰字符
                		// TODO Auto-generated method stub
                		return borderChar+display.getRowText(row)+borderChar;
                	}
                
                }

        5.FullBorder：和SideBorder类一样。
                
                
                package com.jcohy;
                
                public class FullBorder extends Border {
                	
                	public FullBorder(Display display) {
                		super(display);
                	}
                	@Override
                	public int getColumns() {
                
                		return 1+display.getColumns()+1;
                	}
                
                	@Override
                	public int getRows() {//行数==内容行数加上下装饰字符
                		return 1+display.getRows()+1;
                	}
                
                	@Override
                	public String getRowText(int row) {
                		if(row==0) {
                			return "+"+makeLine("-",display.getColumns())+"+";
                		}else if(row==display.getRows()+1){
                			return "+"+makeLine("-",display.getColumns())+"+";
                		}else {
                			return "|"+display.getRowText(row-1)+"|";
                		}
                	}
                	private String makeLine(String string, int columns) {
                		StringBuffer sb = new StringBuffer();
                		for(int i=0;i<columns;i++) {
                			sb.append(string);
                		}
                		return sb.toString();
                	}
                
                }


       6.main
       
                package com.jcohy;
                
                public class Test {
                	public static void main(String[] args) {
                		Display d1 = new StringDisplay("Hello World");
                		Display d2 = new SideBorder(d1, '#');
                		Display d3 = new FullBorder(d2);
                		System.out.println("d1:");
                		d1.show();
                		System.out.println("d2:");
                		d2.show();
                		System.out.println("d3:");
                		d3.show();
                		Display d4 = new SideBorder(
                				new FullBorder(
                						new FullBorder(
                								new SideBorder(
                										new FullBorder(
                												new StringDisplay("您好！")),
                										'#')
                								)
                						),
                				'/');
                		System.out.println("d4:");
                		d4.show();
                		
                	}
                }

       7.result
       
                d1:
                Hello World
                d2:
                #Hello World#
                d3:
                +-------------+
                |#Hello World#|
                +-------------+
                d4:
                /+------------+/
                /|+----------+|/
                /||#+------+#||/
                /||#|您好！|#||/
                /||#+------+#||/
                /|+----------+|/
                /+------------+/

       
<p id="qa">

##  Q&A

       
<p id="java">
        
##  Java语言中装饰器模式

>  * java.io.BufferedInputStream(InputStream)
>  * java.io.DataInputStream(InputStream)
>  * java.io.BufferedOutputStream(OutputStream)
>  * java.util.zip.ZipOutputStream(OutputStream)
>  * java.util.Collections#checked[List|Map|Set|SortedSet|SortedMap]


<p id="kuozhan">

##  扩展
