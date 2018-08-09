#  Java
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## lambda
> * [概述](#gaishu)
> * [lambda表达式语法](#语法)

<p id="gaishu">

### lambda概述

>  Lambda表达式是Java SE 8中一个重要的新特性。lambda表达式允许你通过表达式来代替功能接口。 lambda表达式就和方法一样,它提供了一个正常的参数列表和一个使用这些参数的主体(body,可以是一个表达式或一个代码块)。</br>
>  Lambda表达式还增强了集合库。 Java SE 8添加了2个对集合数据进行批量操作的包: java.util.function 包以及java.util.stream 包。 流(stream)就如同迭代器(iterator),但附加了许多额外的功能。</br> 
>  总的来说,lambda表达式和 stream 是自Java语言添加泛型(Generics)和注解(annotation)以来最大的变化。


### lambda表达式语法
>  *  基本语法
>    * (parameters) -> expression
>    * (parameters) ->{ statements; }


            // 1. 不需要参数,返回值为 5  
            () -> 5  
              
            // 2. 接收一个参数(数字类型),返回其2倍的值  
            x -> 2 * x  
              
            // 3. 接受2个参数(数字),并返回他们的差值  
            (x, y) -> x – y  
              
            // 4. 接收2个int型整数,返回他们的和  
            (int x, int y) -> x + y  
              
            // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)  
            (String s) -> System.out.print(s)
            
