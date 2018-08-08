
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 建造者模式
> * [概述](#gaishu)
> * [建造者的实现](#shixian)
>   *  [建造者模式的角色](#role)
>   *  [建造者实现](#impl)
> * [Q&A](#qa)
> * [Java语言中建造者模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##概述

建造者模式：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

<p id="shixian">

##建造者模式的实现

<p id="role">

####  建造者模式的参与者
![结构图](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-studydesign-pattern/src/main/resources/static/images/builder.png)
>  *  Builder:规定产生对象实例的接口
>  *  ConcreteBuilder;实现Builder的接口
>  *  Director:利用Builder的接口产生对象实例
>  *  Client:客户端

<p id="impl">

####  建造者模式的实现
>  *  创建Builder

            public abstract class Builder {
                /**
                 * 用建造模式建立“文件”的程序。文件构造如下：
                 * 1.含有一个标题
                 * 2.含有一些字符串
                 * 3.含有一些有项目符号的项目
                 * Builer类规定了组成文件的方法。而Director类利用这些方法才能产生1个具体的文件
                 * @param title
                 */
                public abstract void makeTitle(String title);
                public abstract void makeString(String str);
                public abstract void makeItems(String[] items);
                public abstract Object getResult();
            }
>  *  创建Director

            public class Director {
                private Builder builder;
            
                public Director(Builder builder){
                    this.builder=builder;
                }
                //建立文件
                public Object construct(){
                    builder.makeTitle("Hello World！");
                    builder.makeString("EveryDay!");
                    builder.makeItems(new String[]{"hello morning","hello www"});
                    builder.makeString("www.jcohy.com");
                    builder.makeItems(new String[]{"welcome","to","my","wensite"});
                    return builder.getResult();
                }
            }
>  *  创建Builder的实现类TextBuilder

             // 是Builder的子类，以一般文本格式建立文件，以String返回字符串。
            public class TextBuilder extends Builder{
                private StringBuffer buffer = new StringBuffer();
                @Override
                public void makeTitle(String title) {
                    buffer.append("====================\n");
                    buffer.append("["+title+"]\n");
                    buffer.append("\n");
                }
            
                @Override
                public void makeString(String str) {
                    buffer.append("*"+str+"\n");//带*的字符串
                    buffer.append("\n");
                }
            
                @Override
                public void makeItems(String[] items) {
                    //带.的项目
                    for(int i=0;i<items.length;i++){
                        buffer.append("."+items[i]+"\n");
                    }
                    buffer.append("\n");
                }
            
                @Override
                public Object getResult() {
                    buffer.append("====================\n");
                    return buffer.toString();
                }
            }
>  *  创建Builder的实现类HtmlBuilder

            public class HtmlBuilder extends Builder{
                /**
                 * 将文本建立成HTML格式
                 */
                private String fileName;
                private PrintWriter printWriter;
            
                @Override
                public void makeTitle(String title) {
                    fileName = "title"+".html";
                    try {
                        printWriter = new PrintWriter(new FileWriter(fileName));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    printWriter.write("<html><header><title>"+title+"</title></head><body>");
                    printWriter.write("<h1>"+title+"</h1>");
                }
            
                @Override
                public void makeString(String str) {
                    printWriter.write("<p>"+str+"</p>");
                }
            
                @Override
                public void makeItems(String[] items) {
                    printWriter.write("<ul>");
                    for (int i=0;i<items.length;i++){
                        printWriter.write("<li>"+items[i]+"</li>");
                    }
                    printWriter.write("</ul>");
                }
            
                @Override
                public Object getResult() {
                    printWriter.write("</body></html>");
                    printWriter.close();
                    return fileName;//返回文件名
                }
            }
>  *  创建客户端程序

        public class Test {
            public static void main(String[] args){
                if(args.length<1){
                    usage();
                    System.exit(0);
                }
                if(args[0].equals("plain")){
                    Director director = new Director(new TextBuilder());
                    String result= (String) director.construct();
                    System.out.println(result);
                }else if(args[0].equals("html")){
                    Director director = new Director(new HtmlBuilder());
                    String fileName= (String) director.construct();
                    System.out.println("以产生"+fileName);
                }else{
                    usage();
                    System.exit(0);
                }

            }
            public static void usage(){
                System.out.println("Usage java Main Plain 产生一般文件格式的文件");
                System.out.println("Usage java Main Plain 产生一般HTML文件格式的文件");
            }
        }

<p id ="qa" />

##  Q&A

> *  例子一</br>
>   &nbsp;&nbsp; Q:在textBuilder类中，为什么使用StringBuffer类，而非String类。</br>
>   &nbsp;&nbsp; A:像这样经常修改或者新增字符串的程序，利用StringBuffer的执行速度比String更快。因为String类每次修改或者新增都会产生
>  一个新的对象实例。

<p id ="java" />

## Java语言中原型模式
>  *  java.lang.StringBuilder#append()
>  *  java.lang.StringBuffer#append()
>  *  java.nio.ByteBuffer#put() (CharBuffer, ShortBuffer, IntBuffer,LongBuffer,FloatBuffer 和 DoubleBuffer 与之类似)
>  *  javax.swing.GroupLayout.Group#addComponent()
>  *  java.sql.PreparedStatement
>  *  java.lang.Appendable 的所有实现类

<p id ="kuozhan" />

##  扩展
>  *  将程序中的Builder类修改成接口。配合修改其他类
>  *  修改示例程序，让确定在调出makeString，makeItems和getResult方法之前一定会先调用makeTitle方法