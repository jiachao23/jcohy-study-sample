
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 迭代器模式
> * [概述](#gaishu)
> * [迭代器模式的角色](#role)
> * [迭代器模式的应用场景](#sign)
> * [迭代器模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中迭代器](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  迭代子模式：提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露该对象的内部表示。




<p id="role">

## 迭代器模式的角色

>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-designpattern/images/iterator.png)
>  *  Aggregate

>  聚集抽象类

>  *  ConcreteAggregate

>  具体聚集类，继承Aggregate

>  *  Iterator

>  迭代抽象类，用于定义得到的开始对象，得到下一个对象，判断是否到结尾，当前对象等抽象方法，统一接口。

>  *  ConcreteIterator

>  具体迭代类，继承Iterator，实现其中的方法。

>  *  Client

<p id="sign">

##  迭代器模式的应用场景



<p id="shixian">

## 迭代器模式的实现

                    实现一个把书籍放到书架上，并依次输出书名。
                    
                    1.定义Book实体类
                    
                    public class Book {
                        private String name="";
                        public Book(String name) {
                            this.name = name;
                        }
                        public String getName() {
                            return name;
                        }
                    
                        public void setName(String name) {
                            this.name = name;
                        }
                        @Override
                        public String toString() {
                            return "Book [name=" + name + "]";
                        }
                        
                    }
                    
                    
                    2.定义接口
                    /**
                     * 一个执行递增的“聚合”，实现此接口的类就变成类似数组的“多个数字或者变量的聚合”
                     * @author jiachao
                     */
                    public interface Aggregate {
                        public abstract Iterator iterator();
                    }
                    
                    3.
                    
                    public class BookShelf implements Aggregate {
                        
                        
                        private Book[] books;
                        private int last =0;
                        
                        public BookShelf(int maxsize) {
                            books = new Book[maxsize];
                        }
                        
                        
                        public Book getBookAt(int index) {
                            return books[index];
                        }
                        
                        public void appendBook(Book book) {
                            this.books[last] = book;
                            last++;
                        }
                        public int getLength() {
                            return last;
                        }
                        @Override
                        public Iterator iterator() {
                            return new BookShelfIterator(this);
                        }
                    
                    }
                    
                    4.
                    /**
                       * 执行递增，遍历的接口
                       * @author jiachao
                       */
                      public interface Iterator {
                        public abstract boolean hashNext();
                        public abstract Object next();
                      }
                      
                    5。
                    public class BookShelfIterator implements Iterator {
                        public BookShelf bookShelf;
                        public int index;
                        
                        public BookShelfIterator(BookShelf bookShelf) {
                            this.bookShelf = bookShelf;
                            this.index = 0;
                        }
                        @Override
                        public boolean hashNext() {
                            if(index <bookShelf.getLength() ) {
                                return true;
                            }else {
                                return false;
                            }
                        }
                    
                        @Override
                        public Object next() {
                            Book book = bookShelf.getBookAt(index);
                            index++;
                            return book;
                        }
                    
                    }
                    
                    6.Client
                    
                    
                    public class Client {
                        public static void main(String[] args) {
                            BookShelf bookShelf = new BookShelf(4);
                            bookShelf.appendBook(new Book("Effective Java"));
                            bookShelf.appendBook(new Book("Effective Python"));
                            bookShelf.appendBook(new Book("Effective C++"));
                            bookShelf.appendBook(new Book("Effective PHP"));
                            Iterator it = bookShelf.iterator();
                            while(it.hashNext()) {
                                System.out.println(it.next());
                                
                            }
                        }
                    }
                    
                    7.result
                    
                    Book [name=Effective Java]
                    Book [name=Effective Python]
                    Book [name=Effective C++]
                    Book [name=Effective PHP]

        
        

         
<p id="qa">

##  Q&A

       
<p id="java">
        
##  Java语言中迭代器模式

>  *  java.util.Iterator
>  *  java.util.Enumeration


<p id="kuozhan">

##  扩展
    