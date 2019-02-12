
#  Java
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## javaWeb面试
> * [XML文档定义有几种形式？它们之间有何本质区别？解析XML文档有哪几种方式？](#javaweb-1)
> * [你在项目中哪些地方用到了XML？](#javaweb-2)
> * [阐述JDBC操作数据库的步骤。](#javaweb-3)
> * [Statement和PreparedStatement有什么区别？哪个性能更好？](#javaweb-4)
> * [在进行数据库编程时，连接池有什么作用？](#javaweb-5)
> * [什么是DAO模式？](#javaweb-6)
> * [事务的ACID是指什么？](#javaweb-7)
> * [JDBC中如何进行事务处理？](#javaweb-8)
> * [JDBC能否处理Blob和Clob？](#javaweb-9)
> * [阐述Servlet和CGI的区别?](#javaweb-10)
> * [Servlet接口中有哪些方法？](#javaweb-11)
> * [JSP有哪些内置对象？作用分别是什么？](#javaweb-12)
> * [get和post请求的区别？](#javaweb-13)
> * [常用的Web服务器有哪些？](#javaweb-14)
> * [JSP和Servlet是什么关系？](#javaweb-15)
> * [讲解JSP中的四种作用域。](#javaweb-16)
> * [如何实现JSP或Servlet的单线程模式？](#javaweb-17)
> * [实现会话跟踪的技术有哪些？](#javaweb-18)
> * [过滤器有哪些作用和用法？](#javaweb-19)
> * [监听器有哪些作用和用法？](#javaweb-20)
> * [web.xml文件中可以配置哪些内容？](#javaweb-21)
> * [你的项目中使用过哪些JSTL标签？](#javaweb-22)
> * [使用标签库有什么好处？如何自定义JSP标签？](#javaweb-23)
> * [说一下表达式语言（EL）的隐式对象及其作用](#javaweb-24)
> * [表达式语言（EL）支持哪些运算符？](#javaweb-25)
> * [Java Web开发的Model 1和Model 2分别指的是什么？](#javaweb-26)
> * [Servlet 3中的异步处理指的是什么？](#javaweb-27)
> * [如何在基于Java的Web项目中实现文件上传和下载？](#javaweb-28)
> * [服务器收到用户提交的表单数据，到底是调用Servlet的doGet()还是doPost()方法？](#javaweb-29)
> * [JSP中的静态包含和动态包含有什么区别？](#javaweb-30)
> * [Servlet中如何获取用户提交的查询参数或表单数据？](#javaweb-31)
> * [Servlet中如何获取用户配置的初始化参数以及服务器上下文参数？](#javaweb-32)
> * [如何设置请求的编码以及响应内容的类型？](#javaweb-33)
> * [解释一下网络应用的模式及其特点。](#javaweb-34)
> * [什么是Web Service（Web服务）？](#javaweb-35)
> * [概念解释：SOAP、WSDL、UDDI。](#javaweb-36)
> * [Java规范中和Web Service相关的规范有哪些？](#javaweb-37)
> * [介绍一下你了解的Java领域的Web Service框架。](#javaweb-38)
> * [转发与重定向的区别](#javaweb-39)
> * [session和cookie的区别](#javaweb-40)
> * [如何防止表单重复提交](#javaweb-41)

<p id="javaweb-1">

#### XML文档定义有几种形式？它们之间有何本质区别？解析XML文档有哪几种方式？
XML文档定义分为DTD和Schema两种形式，二者都是对XML语法的约束，其本质区别在于Schema本身也是一个XML文件，可以被XML解析器解析，而且可以为XML承载的数据定义类型，约束能力较之DTD更强大。对XML的解析主要有DOM（文档对象模型，Document Object Model）、SAX（Simple API for XML）和StAX（Java 6中引入的新的解析XML的方式，Streaming API for XML），其中DOM处理大型文件时其性能下降的非常厉害，这个问题是由DOM树结构占用的内存较多造成的，而且DOM解析方式必须在解析文件之前把整个文档装入内存，适合对XML的随机访问（典型的用空间换取时间的策略）；SAX是事件驱动型的XML解析方式，它顺序读取XML文件，不需要一次全部装载整个文件。当遇到像文件开头，文档结束，或者标签开头与标签结束时，它会触发一个事件，用户通过事件回调代码来处理XML文件，适合对XML的顺序访问；顾名思义，StAX把重点放在流上，实际上StAX与其他解析方式的本质区别就在于应用程序能够把XML作为一个事件流来处理。将XML作为一组事件来处理的想法并不新颖（SAX就是这样做的），但不同之处在于StAX允许应用程序代码把这些事件逐个拉出来，而不用提供在解析器方便时从解析器中接收事件的处理程序。


<p id="javaweb-2">
#### 你在项目中哪些地方用到了XML？

XML的主要作用有两个方面：数据交换和信息配置。在做数据交换时，XML将数据用标签组装成起来，然后压缩打包加密后通过网络传送给接收者，接收解密与解压缩后再从XML文件中还原相关信息进行处理。
XML曾经是异构系统间交换数据的事实标准，但此项功能几乎已经被JSON（JavaScript Object Notation）取而代之。当然，目前很多软件仍然使用XML来存储配置信息，我们在很多项目中通常也会将作为配置信息的硬代码写在XML文件中，Java的很多框架也是这么做的，而且这些框架都选择了dom4j作为处理XML的工具，因为Sun公司的官方API实在不怎么好用。
补充：现在有很多时髦的软件（如Sublime）已经开始将配置文件书写成JSON格式，我们已经强烈的感受到XML的另一项功能也将逐渐被业界抛弃。

<p id="javaweb-3">
#### 阐述JDBC操作数据库的步骤。

下面的代码以连接本机的Oracle数据库为例，演示JDBC操作数据库的步骤。

```java
//1.加载驱动。
Class.forName("oracle.jdbc.driver.OracleDriver");

//2.创建连接。
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

//3.创建语句。
PreparedStatement ps = con.prepareStatement("select * from emp where sal between ? and ?");
ps.setInt(1, 1000);
ps.setInt(2, 3000);

//4. 执行语句。
ResultSet rs = ps.executeQuery();

//5.处理结果。
while(rs.next()) {
    System.out.println(rs.getInt("empno") + " - " + rs.getString("ename"));
}

//6 关闭资源。
finally {
    if(con != null) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

```

提示：关闭外部资源的顺序应该和打开的顺序相反，也就是说先关闭ResultSet、再关闭Statement、在关闭Connection。上面的代码只关闭了Connection（连接），虽然通常情况下在关闭连接时，连接上创建的语句和打开的游标也会关闭，但不能保证总是如此，因此应该按照刚才说的顺序分别关闭。此外，第一步加载驱动在JDBC 4.0中是可以省略的（自动从类路径中加载驱动），但是我们建议保留。

<p id="javaweb-4">
#### Statement和PreparedStatement有什么区别？哪个性能更好？

与Statement相比，①PreparedStatement接口代表预编译的语句，它主要的优势在于可以减少SQL的编译错误并增加SQL的安全性（减少SQL注射攻击的可能性）；②PreparedStatement中的SQL语句是可以带参数的，避免了用字符串连接拼接SQL语句的麻烦和不安全；③当批量处理SQL或频繁执行相同的查询时，PreparedStatement有明显的性能上的优势，由于数据库可以将编译优化后的SQL语句缓存起来，下次执行相同结构的语句时就会很快（不用再次编译和生成执行计划）。
补充：为了提供对存储过程的调用，JDBC API中还提供了CallableStatement接口。存储过程（Stored Procedure）是数据库中一组为了完成特定功能的SQL语句的集合，经编译后存储在数据库中，用户通过指定存储过程的名字并给出参数（如果该存储过程带有参数）来执行它。虽然调用存储过程会在网络开销、安全性、性能上获得很多好处，但是存在如果底层数据库发生迁移时就会有很多麻烦，因为每种数据库的存储过程在书写上存在不少的差别。

<p id="javaweb-5">
#### 在进行数据库编程时，连接池有什么作用？

由于创建连接和释放连接都有很大的开销（尤其是数据库服务器不在本地时，每次建立连接都需要进行TCP的三次握手，释放连接需要进行TCP四次握手，造成的开销是不可忽视的），为了提升系统访问数据库的性能，可以事先创建若干连接置于连接池中，需要时直接从连接池获取，使用结束时归还连接池而不必关闭连接，从而避免频繁创建和释放连接所造成的开销，这是典型的用空间换取时间的策略（浪费了空间存储连接，但节省了创建和释放连接的时间）。池化技术在Java开发中是很常见的，在使用线程时创建线程池的道理与此相同。基于Java的开源数据库连接池主要有：C3P0、Proxool、DBCP、BoneCP、Druid等。
补充：在计算机系统中时间和空间是不可调和的矛盾，理解这一点对设计满足性能要求的算法是至关重要的。大型网站性能优化的一个关键就是使用缓存，而缓存跟上面讲的连接池道理非常类似，也是使用空间换时间的策略。可以将热点数据置于缓存中，当用户查询这些数据时可以直接从缓存中得到，这无论如何也快过去数据库中查询。当然，缓存的置换策略等也会对系统性能产生重要影响，对于这个问题的讨论已经超出了这里要阐述的范围。

<p id="javaweb-6">
#### 什么是DAO模式？

DAO（Data Access Object）顾名思义是一个为数据库或其他持久化机制提供了抽象接口的对象，在不暴露底层持久化方案实现细节的前提下提供了各种数据访问操作。在实际的开发中，应该将所有对数据源的访问操作进行抽象化后封装在一个公共API中。用程序设计语言来说，就是建立一个接口，接口中定义了此应用程序中将会用到的所有事务方法。在这个应用程序中，当需要和数据源进行交互的时候则使用这个接口，并且编写一个单独的类来实现这个接口，在逻辑上该类对应一个特定的数据存储。DAO模式实际上包含了两个模式，一是Data Accessor（数据访问器），二是Data Object（数据对象），前者要解决如何访问数据的问题，而后者要解决的是如何用对象封装数据。

<p id="javaweb-7">
#### 事务的ACID是指什么？

- 原子性(Atomic)：事务中各项操作，要么全做要么全不做，任何一项操作的失败都会导致整个事务的失败

- 一致性(Consistent)：事务结束后系统状态是一致的；

- 隔离性(Isolated)：并发执行的事务彼此无法看到对方的中间状态；

- 持久性(Durable)：事务完成后所做的改动都会被持久化，即使发生灾难性的失败。通过日志和同步备份可以在故障发生后重建数据。
  
补充：关于事务，在面试中被问到的概率是很高的，可以问的问题也是很多的。首先需要知道的是，只有存在并发数据访问时才需要事务。当多个事务访问同一数据时，可能会存在5类问题，包括3类数据读取问题（脏读、不可重复读和幻读）和2类数据更新问题（第1类丢失更新和第2类丢失更新）。

- 脏读（Dirty Read）：A事务读取B事务尚未提交的数据并在此基础上操作，而B事务执行回滚，那么A读取到的数据就是脏数据。

  | 时间 | 转账事务A                   | 取款事务B                |
  | ---- | --------------------------- | ------------------------ |
  | T1   |                             | 开始事务                 |
  | T2   | 开始事务                    |                          |
  | T3   |                             | 查询账户余额为1000元     |
  | T4   |                             | 取出500元余额修改为500元 |
  | T5   | 查询账户余额为500元（脏读） |                          |
  | T6   |                            | 撤销事务余额恢复为1000元 |
  | T7   | 汇入100元把余额修改为600元 |                          |
  | T8   | 提交事务                   |                          |
  
- 不可重复读（Unrepeatable Read）：事务A重新读取前面读取过的数据，发现该数据已经被另一个已提交的事务B修改过了。


| 时间 | 转账事务A                   | 取款事务B                |
| ---- | --------------------------- | ------------------------ |
| T1   |                             | 开始事务                 |
| T2   | 开始事务                    |                          |
| T3   |                             | 查询账户余额为1000元     |
| T4   |       查询账户余额为1000元                      |  |
| T5   |  |        取出100元修改余额为900元                  |
| T6   |  |        提交事务                  |
| T7   | 查询账户余额为900元（不可重复读） |                          |

- 幻读（Phantom Read）：事务A重新执行一个查询，返回一系列符合查询条件的行，发现其中插入了被事务B提交的行。


| 时间 | 统计金额事务A                   | 转账事务B                |
| ---- | --------------------------- | ------------------------ |
| T1   |                             | 开始事务                 |
| T2   | 开始事务                    |                          |
| T3   |  统计总存款为10000元                           |     |
| T4   |                         | 新增一个存款账户存入100元 |
| T5   |  |        提交事务          |
| T6   |  |       再次统计总存款为10100元（幻读）                  |

- 第1类丢失更新：事务A撤销时，把已经提交的事务B的更新数据覆盖了。


| 时间 | 取款事务A              | 转账事务B                |
| ---- | --------------------------- | ------------------------ |
| T1   |  开始事务                           |                  |
| T2   |                     |    开始事务                      |
| T3   |  查询账户余额为1000元                           |     |
| T4   |                         | 查询账户余额为1000元 |
| T5   |  |        汇入100元修改余额为1100元          |
| T6   |  |       提交事务                 |
| T7   |  取出100元将余额修改为900元|                        |
| T8   |  撤销事务|                        |
| T9   |  余额恢复为1000元（丢失更新）|                        |

- 第2类丢失更新：事务A覆盖事务B已经提交的数据，造成事务B所做的操作丢失。


| 时间 | 转账事务A              | 取款事务B                |
| ---- | --------------------------- | ------------------------ |
| T1   |                             |     开始事务             |
| T2   |       开始事务              |                          |
| T3   |                             | 查询账户余额为1000元    |
| T4   |         查询账户余额为1000元                |  |
| T5   |  |        取出100元将余额修改为900元          |
| T6   |  |       提交事务                 |
| T7   |  汇入100元将余额修改为1100元|                        |
| T8   |  提交事务|                        |
| T9   |  查询账户余额为1100元（丢失更新）|                        |

数据并发访问所产生的问题，在有些场景下可能是允许的，但是有些场景下可能就是致命的，数据库通常会通过锁机制来解决数据并发访问问题，按锁定对象不同可以分为表级锁和行级锁；按并发事务锁定关系可以分为共享锁和独占锁，具体的内容大家可以自行查阅资料进行了解。直接使用锁是非常麻烦的，为此数据库为用户提供了自动锁机制，只要用户指定会话的事务隔离级别，数据库就会通过分析SQL语句然后为事务访问的资源加上合适的锁，此外，数据库还会维护这些锁通过各种手段提高系统的性能，这些对用户来说都是透明的（就是说你不用理解，事实上我确实也不知道）。ANSI/ISO SQL 92标准定义了4个等级的事务隔离级别，如下表所示：

| 隔离级别        | 脏读   | 不可重复读 | 幻读   | 第一类丢失更新 | 第二类丢失更新 |
| --------------- | ------ | ---------- | ------ | -------------- | -------------- |
| READ UNCOMMITED | 允许   | 允许       | 允许   | 不允许         | 允许           |
| READ COMMITTED  | 不允许 | 允许       | 允许   | 不允许         | 允许           |
| REPEATABLE READ | 不允许 | 不允许     | 允许   | 不允许         | 不允许         |
| SERIALIZABLE    | 不允许 | 不允许     | 不允许 |                | 不允许         |

需要说明的是，事务隔离级别和数据访问的并发性是对立的，事务隔离级别越高并发性就越差。所以要根据具体的应用来确定合适的事务隔离级别，这个地方没有万能的原则。

<p id="javaweb-8">
#### JDBC中如何进行事务处理？

Connection提供了事务处理的方法，通过调用setAutoCommit(false)可以设置手动提交事务；当事务完成后用commit()显式提交事务；如果在事务处理过程中发生异常则通过rollback()进行事务回滚。除此之外，从JDBC 3.0中还引入了Savepoint（保存点）的概念，允许通过代码设置保存点并让事务回滚到指定的保存点。
  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/2.jpg)

<p id="javaweb-9">
#### JDBC能否处理Blob和Clob？

Blob是指二进制大对象（Binary Large Object），而Clob是指大字符对象（Character Large Objec），因此其中Blob是为存储大的二进制数据而设计的，而Clob是为存储大的文本数据而设计的。JDBC的PreparedStatement和ResultSet都提供了相应的方法来支持Blob和Clob操作。下面的代码展示了如何使用JDBC操作LOB： 

下面以MySQL数据库为例，创建一个张有三个字段的用户表，包括编号（id）、姓名（name）和照片（photo），建表语句如下：

```sql
create table tb_user
(
id int primary key auto_increment,
name varchar(20) unique not null,
photo longblob
);
```

下面的Java代码向数据库中插入一条记录：

```java
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
class JdbcLobTest {
    public static void main(String[] args) {
        Connection con = null;
        try {
            // 1. 加载驱动（Java6以上版本可以省略）
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 建立连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
            // 3. 创建语句对象
            PreparedStatement ps = con.prepareStatement("insert into tb_user values (default, ?, ?)");
            ps.setString(1, "骆昊"); // 将SQL语句中第一个占位符换成字符串
            try (InputStream in = new FileInputStream("test.jpg")) { // Java 7的TWR
                ps.setBinaryStream(2, in); // 将SQL语句中第二个占位符换成二进制流
                // 4. 发出SQL语句获得受影响行数
                System.out.println(ps.executeUpdate() == 1 ? "插入成功" : "插入失败");
            } catch(IOException e) {
                System.out.println("读取照片失败!");
            }
        } catch (ClassNotFoundException | SQLException e) { // Java 7的多异常捕获
            e.printStackTrace();
        } finally { // 释放外部资源的代码都应当放在finally中保证其能够得到执行
            try {
                if(con != null && !con.isClosed()) {
                    con.close(); // 5. 释放数据库连接
                    con = null; // 指示垃圾回收器可以回收该对象
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
```

<p id="javaweb-10">

#### 阐述Servlet和CGI的区别?

Servlet与CGI的区别在于Servlet处于服务器进程中，它通过多线程方式运行其service()方法，一个实例可以服务于多个请求，并且其实例一般不会销毁，而CGI对每个请求都产生新的进程，服务完成后就销毁，所以效率上低于Servlet。
补充：Sun Microsystems公司在1996年发布Servlet技术就是为了和CGI进行竞争，Servlet是一个特殊的Java程序，一个基于Java的Web应用通常包含一个或多个Servlet类。Servlet不能够自行创建并执行，它是在Servlet容器中运行的，容器将用户的请求传递给Servlet程序，并将Servlet的响应回传给用户。通常一个Servlet会关联一个或多个JSP页面。以前CGI经常因为性能开销上的问题被诟病，然而Fast CGI早就已经解决了CGI效率上的问题，所以面试的时候大可不必信口开河的诟病CGI，事实上有很多你熟悉的网站都使用了CGI技术。

<p id="javaweb-11">

#### Servlet接口中有哪些方法？

Servlet接口定义了5个方法，其中前三个方法与Servlet生命周期相关： 

- void init(ServletConfig config) throws ServletException 

- void service(ServletRequest req, ServletResponse resp) throws ServletException, java.io.IOException

- void destory() - java.lang.String getServletInfo() - ServletConfig getServletConfig()

Web容器加载Servlet并将其实例化后，Servlet生命周期开始，容器运行其init()方法进行Servlet的初始化；请求到达时调用Servlet的service()方法，service()方法会根据需要调用与请求对应的doGet或doPost等方法；当服务器关闭或项目被卸载时服务器会将Servlet实例销毁，此时会调用Servlet的destroy()方法。

<p id="javaweb-12">

#### JSP有哪些内置对象？作用分别是什么？
JSP有9个内置对象：
- request：封装客户端的请求，其中包含来自GET或POST请求的参数；
- response：封装服务器对客户端的响应；
- pageContext：通过该对象可以获取其他对象；
- session：封装用户会话的对象；
- application：封装服务器运行环境的对象；
- out：输出服务器响应的输出流对象；
- config：Web应用的配置对象；
- page：JSP页面本身（相当于Java程序中的this）；
- exception：封装页面抛出异常的对象。
  补充：如果用Servlet来生成网页中的动态内容无疑是非常繁琐的工作，另一方面，所有的文本和HTML标签都是硬编码，即使做出微小的修改，都需要进行重新编译。JSP解决了Servlet的这些问题，它是Servlet很好的补充，可以专门用作为用户呈现视图（View），而Servlet作为控制器（Controller）专门负责处理用户请求并转发或重定向到某个页面。基于Java的Web开发很多都同时使用了Servlet和JSP。JSP页面其实是一个Servlet，能够运行Servlet的服务器（Servlet容器）通常也是JSP容器，可以提供JSP页面的运行环境，Tomcat就是一个Servlet/JSP容器。第一次请求一个JSP页面时，Servlet/JSP容器首先将JSP页面转换成一个JSP页面的实现类，这是一个实现了JspPage接口或其子接口HttpJspPage的Java类。JspPage接口是Servlet的子接口，因此每个JSP页面都是一个Servlet。转换成功后，容器会编译Servlet类，之后容器加载和实例化Java字节码，并执行它通常对Servlet所做的生命周期操作。对同一个JSP页面的后续请求，容器会查看这个JSP页面是否被修改过，如果修改过就会重新转换并重新编译并执行。如果没有则执行内存中已经存在的Servlet实例。我们可以看一段JSP代码对应的Java程序就知道一切了，而且9个内置对象的神秘面纱也会被揭开。
  JSP页面：
```jsp
<%@ page pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>首页</title>
        <style type="text/css">
            * { font-family: "Arial"; }
        </style>
    </head>
    <body>
        <h1>Hello, World!</h1>
        <hr/>
        <h2>Current time is: <%= new java.util.Date().toString() %></h2>
    </body>
</html>
```


对应的Java代码：
```java
/*
* Generated by the Jasper component of Apache Tomcat
* Version: Apache Tomcat/7.0.52
* Generated at: 2014-10-13 13:28:38 UTC
* Note: The last modified time of this file was set to
* the last modified time of the source file after
* generation to assist with modification tracking.
*/
package org.apache.jsp;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
implements org.apache.jasper.runtime.JspSourceDependent {
private static final javax.servlet.jsp.JspFactory _jspxFactory =javax.servlet.jsp.JspFactory.getDefaultFactory();
private static java.util.Map<java.lang.String, java.lang.Long> _jspx_dependants;
private javax.el.ExpressionFactory _el_expressionfactory;
private org.apache.tomcat.InstanceManager _jsp_instancemanager;
public java.util.Map<java.lang.String, java.lang.Long> getDependants() {
return _jspx_dependants;
}
public void _jspInit() {
_el_expressionfactory = _jspxFactory.getJspApplicationContext(
getServletConfig().getServletContext()).getExpressionFactory();
_jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory
.getInstanceManager(getServletConfig());
}
public void _jspDestroy() {
}
public void _jspService(
final javax.servlet.http.HttpServletRequest request,
final javax.servlet.http.HttpServletResponse response)
throws java.io.IOException, javax.servlet.ServletException {
// 内置对象就是在这里定义的
final javax.servlet.jsp.PageContext pageContext;
javax.servlet.http.HttpSession session = null;
final javax.servlet.ServletContext application;
final javax.servlet.ServletConfig config;
javax.servlet.jsp.JspWriter out = null;
final java.lang.Object page = this;
javax.servlet.jsp.JspWriter _jspx_out = null;
javax.servlet.jsp.PageContext _jspx_page_context = null;
try {
response.setContentType("text/html;charset=UTF-8");
pageContext = _jspxFactory.getPageContext(this, request, response,
null, true, 8192, true);
_jspx_page_context = pageContext;
application = pageContext.getServletContext();
config = pageContext.getServletConfig();
session = pageContext.getSession();
out = pageContext.getOut();
_jspx_out = out;
out.write('\r');
out.write('\n');
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
// 以下代码通过输出流将HTML标签输出到浏览器中
out.write("\r\n");
out.write("\r\n");
out.write("<!DOCTYPE html>\r\n");
out.write("<html>\r\n");
out.write(" <head>\r\n");
out.write(" <base href=\"");
out.print(basePath);
out.write("\">\r\n");
out.write(" <title>首页</title>\r\n");
out.write(" <style type=\"text/css\">\r\n");
out.write(" \t* { font-family: \"Arial\"; }\r\n");
out.write(" </style>\r\n");
out.write(" </head>\r\n");
out.write(" \r\n");
out.write(" <body>\r\n");
out.write(" <h1>Hello, World!</h1>\r\n");
out.write(" <hr/>\r\n");
out.write(" <h2>Current time is: ");
out.print(new java.util.Date().toString());
out.write("</h2>\r\n");
out.write(" </body>\r\n");
out.write("</html>\r\n");
} catch (java.lang.Throwable t) {
if (!(t instanceof javax.servlet.jsp.SkipPageException)) {
out = _jspx_out;
if (out != null && out.getBufferSize() != 0)
try {
out.clearBuffer();
} catch (java.io.IOException e) {
}
if (_jspx_page_context != null)
_jspx_page_context.handlePageException(t);
else
throw new ServletException(t);
}
} finally {
_jspxFactory.releasePageContext(_jspx_page_context);
}
}
}
```

<p id="javaweb-13">

#### get和post请求的区别？

- get请求用来从服务器上获得资源，而post是用来向服务器提交数据； 

- get将表单中数据按照name=value的形式，添加到action 所指向的URL 后面，并且两者使用"?"连接，而各个变量之间使用"&"连接；post是将表单中的数据放在HTTP协议的请求头或消息体中，传递到action所指向URL； 
- get传输的数据要受到URL长度限制（1024字节）；而post可以传输大量的数据，上传文件通常要使用post方式； 
- 使用get时参数会显示在地址栏上，如果这些数据不是敏感数据，那么可以使用get；对于敏感数据还是应用使用post； 
- get使用MIME类型application/x-www-form-urlencoded的URL编码（也叫百分号编码）文本的格式传递参数，保证被传送的参数由遵循规范的文本组成，例如一个空格的编码是"%20"。

<p id="javaweb-14">

#### 常用的Web服务器有哪些？

Unix和Linux平台下使用最广泛的免费HTTP服务器是Apache服务器，而Windows平台的服务器通常使用IIS作为Web服务器。选择Web服务器应考虑的因素有：性能、安全性、日志和统计、虚拟主机、代理服务器、缓冲服务和集成应用程序等。下面是对常见服务器的简介：

- IIS：Microsoft的Web服务器产品，全称是Internet Information Services。IIS是允许在公共Intranet或Internet上发布信息的Web服务器。IIS是目前最流行的Web服务器产品之一，很多著名的网站都是建立在IIS的平台上。IIS提供了一个图形界面的管理工具，称为Internet服务管理器，可用于监视配置和控制Internet服务。IIS是一种Web服务组件，其中包括Web服务器、FTP服务器、NNTP服务器和SMTP服务器，分别用于网页浏览、文件传输、新闻服务和邮件发送等方面，它使得在网络（包括互联网和局域网）上发布信息成了一件很容易的事。它提供ISAPI(Intranet Server API）作为扩展Web服务器功能的编程接口；同时，它还提供一个Internet数据库连接器，可以实现对数据库的查询和更新。
- Kangle：Kangle Web服务器是一款跨平台、功能强大、安全稳定、易操作的高性能Web服务器和反向代理服务器软件。此外，Kangle也是一款专为做虚拟主机研发的Web服务器。实现虚拟主机独立进程、独立身份运行。用户之间安全隔离，一个用户出问题不影响其他用户。支持PHP、ASP、ASP.NET、Java、Ruby等多种动态开发语言。- WebSphere：WebSphere Application Server是功能完善、开放的Web应用程序服务器，是IBM电子商务计划的核心部分，它是基于Java的应用环境，用于建立、部署和管理Internet和Intranet Web应用程序，适应各种Web应用程序服务器的需要。
- WebLogic：WebLogic Server是一款多功能、基于标准的Web应用服务器，为企业构建企业应用提供了坚实的基础。针对各种应用开发、关键性任务的部署，各种系统和数据库的集成、跨Internet协作等Weblogic都提供了相应的支持。由于它具有全面的功能、对开放标准的遵从性、多层架构、支持基于组件的开发等优势，很多公司的企业级应用都选择它来作为开发和部署的环境。WebLogic Server在使应用服务器成为企业应用架构的基础方面一直处于领先地位，为构建集成化的企业级应用提供了稳固的基础。
- Apache：目前Apache仍然是世界上用得最多的Web服务器，其市场占有率很长时间都保持在60%以上（目前的市场份额约40%左右）。世界上很多著名的网站都是Apache的产物，它的成功之处主要在于它的源代码开放、有一支强大的开发团队、支持跨平台的应用（可以运行在几乎所有的Unix、Windows、Linux系统平台上）以及它的可移植性等方面。
- Tomcat：Tomcat是一个开放源代码、运行Servlet和JSP的容器。Tomcat实现了Servlet和JSP规范。此外，Tomcat还实现了Apache-Jakarta规范而且比绝大多数商业应用软件服务器要好，因此目前也有不少的Web服务器都选择了Tomcat。
- Nginx：读作"engine x"，是一个高性能的HTTP和反向代理服务器，也是一个IMAP/POP3/SMTP代理服务器。Nginx是由Igor Sysoev为俄罗斯访问量第二的Rambler站点开发的，第一个公开版本0.1.0发布于2004年10月4日。其将源代码以类BSD许可证的形式发布，因它的稳定性、丰富的功能集、示例配置文件和低系统资源的消耗而闻名。在2014年下半年，Nginx的市场份额达到了14%。

<p id="javaweb-15">

#### JSP和Servlet是什么关系？

其实这个问题在上面已经阐述过了，Servlet是一个特殊的Java程序，它运行于服务器的JVM中，能够依靠服务器的支持向浏览器提供显示内容。JSP本质上是Servlet的一种简易形式，JSP会被服务器处理成一个类似于Servlet的Java程序，可以简化页面内容的生成。Servlet和JSP最主要的不同点在于，Servlet的应用逻辑是在Java文件中，并且完全从表示层中的HTML分离开来。而JSP的情况是Java和HTML可以组合成一个扩展名为.jsp的文件。有人说，Servlet就是在Java中写HTML，而JSP就是在HTML中写Java代码，当然这个说法是很片面且不够准确的。JSP侧重于视图，Servlet更侧重于控制逻辑，在MVC架构模式中，JSP适合充当视图（view）而Servlet适合充当控制器（controller）。

<p id="javaweb-16">

#### 讲解JSP中的四种作用域。

JSP中的四种作用域包括page、request、session和application，具体来说：

- page代表与一个页面相关的对象和属性。

- request代表与Web客户机发出的一个请求相关的对象和属性。一个请求可能跨越多个页面，涉及多个Web组件；需要在页面显示的临时数据可以置于此作用域。

- session代表与某个用户与服务器建立的一次会话相关的对象和属性。跟某个用户相关的数据应该放在用户自己的session中。

- application代表与整个Web应用程序相关的对象和属性，它实质上是跨越整个Web应用程序，包括多个页面、请求和会话的一个全局作用域。

<p id="javaweb-17">

#### 如何实现JSP或Servlet的单线程模式？

对于JSP页面，可以通过page指令进行设置。
```jsp
<%@page isThreadSafe=”false”%>
```

对于Servlet，可以让自定义的Servlet实现SingleThreadModel标识接口。
说明：如果将JSP或Servlet设置成单线程工作模式，会导致每个请求创建一个Servlet实例，这种实践将导致严重的性能问题（服务器的内存压力很大，还会导致频繁的垃圾回收），所以通常情况下并不会这么做。

<p id="javaweb-18">

#### 实现会话跟踪的技术有哪些？

由于HTTP协议本身是无状态的，服务器为了区分不同的用户，就需要对用户会话进行跟踪，简单的说就是为用户进行登记，为用户分配唯一的ID，下一次用户在请求中包含此ID，服务器据此判断到底是哪一个用户。

- URL 重写：在URL中添加用户会话的信息作为请求的参数，或者将唯一的会话ID添加到URL结尾以标识一个会话。

- 设置表单隐藏域：将和会话跟踪相关的字段添加到隐式表单域中，这些信息不会在浏览器中显示但是提交表单时会提交给服务器。这两种方式很难处理跨越多个页面的信息传递，因为如果每次都要修改URL或在页面中添加隐式表单域来存储用户会话相关信息，事情将变得非常麻烦。

- cookie：cookie有两种，一种是基于窗口的，浏览器窗口关闭后，cookie就没有了；另一种是将信息存储在一个临时文件中，并设置存在的时间。当用户通过浏览器和服务器建立一次会话后，会话ID就会随响应信息返回存储在基于窗口的cookie中，那就意味着只要浏览器没有关闭，会话没有超时，下一次请求时这个会话ID又会提交给服务器让服务器识别用户身份。会话中可以为用户保存信息。会话对象是在服务器内存中的，而基于窗口的cookie是在客户端内存中的。如果浏览器禁用了cookie，那么就需要通过下面两种方式进行会话跟踪。当然，在使用cookie时要注意几点：首先不要在cookie中存放敏感信息；其次cookie存储的数据量有限（4k），不能将过多的内容存储cookie中；再者浏览器通常只允许一个站点最多存放20个cookie。当然，和用户会话相关的其他信息（除了会话ID）也可以存在cookie方便进行会话跟踪。

- HttpSession：在所有会话跟踪技术中，HttpSession对象是最强大也是功能最多的。当一个用户第一次访问某个网站时会自动创建HttpSession，每个用户可以访问他自己的HttpSession。可以通过HttpServletRequest对象的getSession方法获得HttpSession，通过HttpSession的setAttribute方法可以将一个值放在HttpSession中，通过调用HttpSession对象的getAttribute方法，同时传入属性名就可以获取保存在HttpSession中的对象。与上面三种方式不同的是，HttpSession放在服务器的内存中，因此不要将过大的对象放在里面，即使目前的Servlet容器可以在内存将满时将HttpSession中的对象移到其他存储设备中，但是这样势必影响性能。添加到HttpSession中的值可以是任意Java对象，这个对象最好实现了Serializable接口，这样Servlet容器在必要的时候可以将其序列化到文件中，否则在序列化时就会出现异常。

  **补充：**HTML5中可以使用Web Storage技术通过JavaScript来保存数据，例如可以使用localStorage和sessionStorage来保存用户会话的信息，也能够实现会话跟踪

<p id="javaweb-19">

#### 过滤器有哪些作用和用法？

Java Web开发中的过滤器（filter）是从Servlet 2.3规范开始增加的功能，并在Servlet 2.4规范中得到增强。对Web应用来说，过滤器是一个驻留在服务器端的Web组件，它可以截取客户端和服务器之间的请求与响应信息，并对这些信息进行过滤。当Web容器接受到一个对资源的请求时，它将判断是否有过滤器与这个资源相关联。如果有，那么容器将把请求交给过滤器进行处理。在过滤器中，你可以改变请求的内容，或者重新设置请求的报头信息，然后再将请求发送给目标资源。当目标资源对请求作出响应时候，容器同样会将响应先转发给过滤器，在过滤器中你可以对响应的内容进行转换，然后再将响应发送到客户端。
常见的过滤器用途主要包括：对用户请求进行统一认证、对用户的访问请求进行记录和审核、对用户发送的数据进行过滤或替换、转换图象格式、对响应内容进行压缩以减少传输量、对请求或响应进行加解密处理、触发资源访问事件、对XML的输出应用XSLT等。
和过滤器相关的接口主要有：Filter、FilterConfig和FilterChain。
编码过滤器的例子：
```java
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
@WebFilter(urlPatterns = { "*" },
           initParams = {@WebInitParam(name="encoding", value="utf-8")})
public class CodingFilter implements Filter {
    private String defaultEncoding = "utf-8";
    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding(defaultEncoding);
        resp.setCharacterEncoding(defaultEncoding);
        chain.doFilter(req, resp);
    }
    @Override
    public void init(FilterConfig config) throws ServletException {
        String encoding = config.getInitParameter("encoding");
        if (encoding != null) {
            defaultEncoding = encoding;
        }
    }
}
```

下载计数过滤器的例子：
```java
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter(urlPatterns = {"/*"})
public class DownloadCounterFilter implements Filter {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Properties downloadLog;
    private File logFile;
    @Override
    public void destroy() {
        executorService.shutdown();
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        final String uri = request.getRequestURI();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String value = downloadLog.getProperty(uri);
                if(value == null) {
                    downloadLog.setProperty(uri, "1");
                }
                else {
                    int count = Integer.parseInt(value);
                    downloadLog.setProperty(uri, String.valueOf(++count));
                }
                try {
                    downloadLog.store(new FileWriter(logFile), "");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        chain.doFilter(req, resp);
    }
    @Override
    public void init(FilterConfig config) throws ServletException {
        String appPath = config.getServletContext().getRealPath("/");
        logFile = new File(appPath, "downloadLog.txt");
        if(!logFile.exists()) {
            try {
                logFile.createNewFile();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        downloadLog = new Properties();
        try {
            downloadLog.load(new FileReader(logFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

说明：这里使用了Servlet 3规范中的注解来部署过滤器，当然也可以在web.xml中使用<filter>和<filter-mapping>标签部署过滤器。

<p id="javaweb-20">

#### 监听器有哪些作用和用法？

Java Web开发中的监听器（listener）就是application、session、request三个对象创建、销毁或者往其中添加修改删除属性时自动执行代码的功能组件，如下所示：

1. ServletContextListener：对Servlet上下文的创建和销毁进行监听。

2. ServletContextAttributeListener：监听Servlet上下文属性的添加、删除和替换。

3. HttpSessionListener：对Session的创建和销毁进行监听。
  补充：session的销毁有两种情况：

    -  session超时（可以在web.xml中通过<session-config>/<session-timeout>标签配置超时时间）；

    -  通过调用session对象的invalidate()方法使session失效。

4. HttpSessionAttributeListener：对Session对象中属性的添加、删除和替换进行监听。

5. ServletRequestListener：对请求对象的初始化和销毁进行监听。

6. ServletRequestAttributeListener：对请求对象属性的添加、删除和替换进行监听。

   下面是一个统计网站最多在线人数监听器的例子：

```java
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/** 上下文监听器，在服务器启动时初始化onLineCount和maxOnLineCount两个变量并将其置于服务器上下文（ServletContext）中，其初始值都是0
*/
@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent evt) {
    }
    @Override
    public void contextInitialized(ServletContextEvent evt) {
        evt.getServletContext().setAttribute("onLineCount", 0);
        evt.getServletContext().setAttribute("maxOnLineCount", 0);
    }
}
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
会话监听器，在用户会话创建和销毁的时候根据情况修改onLineCount和maxOnLineCount的值
*/
@WebListener
public class MaxCountListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        ServletContext ctx = event.getSession().getServletContext();
        int count = Integer.parseInt(ctx.getAttribute("onLineCount").toString());
        count++;
        ctx.setAttribute("onLineCount", count);
        int maxOnLineCount = Integer.parseInt(ctx.getAttribute("maxOnLineCount").toString());
        if (count > maxOnLineCount) {
            ctx.setAttribute("maxOnLineCount", count);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ctx.setAttribute("date", df.format(new Date()));
        }
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        ServletContext app = event.getSession().getServletContext();
        int count = Integer.parseInt(app.getAttribute("onLineCount").toString());
        count--;
        app.setAttribute("onLineCount", count);
    }
}
```

说明：这里使用了Servlet 3规范中的@WebListener注解配置监听器，当然你可以在web.xml文件中用<listener>标签配置监听器。

<p id="javaweb-21">

#### web.xml文件中可以配置哪些内容？

web.xml用于配置Web应用的相关信息，如：监听器（listener）、过滤器（filter）、Servlet、相关参数、会话超时时间、安全验证方式、错误页面等，下面是一些开发中常见的配置：

```xml
<--配置Spring上下文加载监听器加载Spring配置文件并创建IoC容器：-->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
<listener>
    <listener-class>
        org.springframework.web.context.ContextLoaderListener
    </listener-class>
</listener>
    
<--配置Spring的OpenSessionInView过滤器来解决延迟加载和Hibernate会话关闭的矛盾：-->
<filter>
    <filter-name>openSessionInView</filter-name>
    <filter-class>
        org.springframework.orm.hibernate3.support.OpenSessionInViewFilter
    </filter-class>
</filter>
<filter-mapping>
    <filter-name>openSessionInView</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
    
<--配置会话超时时间为10分钟：-->
<session-config>
    <session-timeout>10</session-timeout>
</session-config>
    
<--配置404和Exception的错误页面：-->
<error-page>
    <error-code>404</error-code>
    <location>/error.jsp</location>
</error-page>
<error-page>
    <exception-type>java.lang.Exception</exception-type>
    <location>/error.jsp</location>
</error-page>
    
<--配置安全认证方式：-->
<security-constraint>
    <web-resource-collection>
        <web-resource-name>ProtectedArea</web-resource-name>
        <url-pattern>/admin/*</url-pattern>
        <http-method>GET</http-method>
        <http-method>POST</http-method>
    </web-resource-collection>
    <auth-constraint>
        <role-name>admin</role-name>
    </auth-constraint>
</security-constraint>
<login-config>
    <auth-method>BASIC</auth-method>
</login-config>
<security-role>
    <role-name>admin</role-name>
</security-role>
```

说明：对Servlet（小服务）、Listener（监听器）和Filter（过滤器）等Web组件的配置，Servlet 3规范提供了基于注解的配置方式，可以分别使用@WebServlet、@WebListener、@WebFilter注解进行配置。补充：如果Web提供了有价值的商业信息或者是敏感数据，那么站点的安全性就是必须考虑的问题。安全认证是实现安全性的重要手段，认证就是要解决“Are you who you say you are?”的问题。认证的方式非常多，简单说来可以分为三类：

 A. What you know? ? 口令 

B. What you have? ? 数字证书（U盾、密保卡）

C. Who you are? ?指纹识别、虹膜识别 在Tomcat中可以通过建立安全套接字层（Secure Socket Layer, SSL）以及通过基本验证或表单验证来实现对安全性的支持。

<p id="javaweb-22">

#### 你的项目中使用过哪些JSTL标签？

项目中主要使用了JSTL的核心标签库，包括<c:if>、<c:choose>、<c: when>、<c: otherwise>、<c:forEach>等，主要用于构造循环和分支结构以控制显示逻辑。
说明：虽然JSTL标签库提供了core、sql、fmt、xml等标签库，但是实际开发中建议只使用核心标签库（core），而且最好只使用分支和循环标签并辅以表达式语言（EL），这样才能真正做到数据显示和业务逻辑的分离，这才是最佳实践。

<p id="javaweb-23">

#### 使用标签库有什么好处？如何自定义JSP标签？

- 分离JSP页面的内容和逻辑，简化了Web开发；

- 开发者可以创建自定义标签来封装业务逻辑和显示逻辑；

- 标签具有很好的可移植性、可维护性和可重用性； 

- 避免了对Scriptlet（小脚本）的使用（很多公司的项目开发都不允许在JSP中书写小脚本）

自定义JSP标签包括以下几个步骤：

1. 编写一个Java类实现实现Tag/BodyTag/IterationTag接口（开发中通常不直接实现这些接口而是继承TagSupport/BodyTagSupport/SimpleTagSupport类，这是对缺省适配模式的应用）

2. 重写doStartTag()、doEndTag()等方法，定义标签要完成的功能

3. 编写扩展名为tld的标签描述文件对自定义标签进行部署，tld文件通常放在WEB-INF文件夹下或其子目录中- 在JSP页面中使用taglib指令引用该标签库。


下面是一个自定义标签库的例子。
步骤1 - 标签类源代码TimeTag.java：

```java
package com.jackfrued.tags;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
public class TimeTag extends TagSupport {
    private static final long serialVersionUID = 1L;
    private String format = "yyyy-MM-dd hh:mm:ss";
    private String foreColor = "black";
    private String backColor = "white";
    public int doStartTag() throws JspException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        JspWriter writer = pageContext.getOut();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<span style='color:%s;background-color:%s'>%s</span>",
                                foreColor, backColor, sdf.format(new Date())));
        try {
            writer.print(sb.toString());
        } catch(IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public void setForeColor(String foreColor) {
        this.foreColor = foreColor;
    }
    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }
}
```
步骤2 - 编写标签库描述文件my.tld：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<taglib xmlns="http://java.sun.com/xml/ns/j2ee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
                            http://java.sun.com/xml/ns/j2ee/web-jsptaglibrary_2_0.xsd"
        version="2.0">
    <description>定义标签库</description>
    <tlib-version>1.0</tlib-version>
    <short-name>MyTag</short-name>
    <tag>
        <name>time</name>
        <tag-class>com.jackfrued.tags.TimeTag</tag-class>
        <body-content>empty</body-content>
        <attribute>
            <name>format</name>
            <required>false</required>
        </attribute>
        <attribute>
            <name>foreColor</name>
        </attribute>
        <attribute>
            <name>backColor</name>
        </attribute>
    </tag>
</taglib>
```
步骤3 - 在JSP页面中使用自定义标签：
```jsp
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="my" uri="/WEB-INF/tld/my.tld" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>首页</title>
        <style type="text/css">
            * { font-family: "Arial"; font-size:72px; }
        </style>
    </head>
    <body>
        <my:time format="yyyy-MM-dd" backColor="blue" foreColor="yellow"/>
    </body>
</html>
```

提示：如果要将自定义的标签库发布成JAR文件，需要将标签库描述文件（tld文件）放在JAR文件的META-INF目录下，可以JDK中的jar工具完成JAR文件的生成。

<p id="javaweb-24">

#### 说一下表达式语言（EL）的隐式对象及其作用

EL的隐式对象包括：pageContext、initParam（访问上下文参数）、param（访问请求参数）、paramValues、header（访问请求头）、headerValues、cookie（访问cookie）、applicationScope（访问application作用域）、sessionScope（访问session作用域）、requestScope（访问request作用域）、pageScope（访问page作用域）。
用法如下所示：
${pageContext.request.method}
${pageContext["request"]["method"]}
${pageContext.request["method"]}
${pageContext["request"].method}
${initParam.defaultEncoding}
${header["accept-language"]}
${headerValues["accept-language"][0]}
${cookie.jsessionid.value}
${sessionScope.loginUser.username}
补充：表达式语言的.和[]运算作用是一致的，唯一的差别在于如果访问的属性名不符合Java标识符命名规则，例如上面的accept-language就不是一个有效的Java标识符，那么这时候就只能用[]运算符而不能使用.运算符获取它的值

<p id="javaweb-25">

#### 表达式语言（EL）支持哪些运算符？

除了.和[]运算符，EL还提供了：

- 算术运算符：+、-、*、/或div、%或mod

- 关系运算符：==或eq、!=或ne、>或gt、>=或ge、<或lt、<=或le 

- 逻辑运算符：&&或and、||或or、!或not

- 条件运算符：${statement? A : B}（跟Java的条件运算符类似）

- empty运算符：检查一个值是否为null或者空（数组长度为0或集合中没有元素也返回true）

<p id="javaweb-26">

#### Java Web开发的Model 1和Model 2分别指的是什么？

Model 1是以页面为中心的Java Web开发，使用JSP+JavaBean技术将页面显示逻辑和业务逻辑处理分开，JSP实现页面显示，JavaBean对象用来保存数据和实现业务逻辑。Model 2是基于MVC（模型-视图-控制器，Model-View-Controller）架构模式的开发模型，实现了模型和视图的彻底分离，利于团队开发和代码复用，如下图所示。

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/3.jpg)

<p id="javaweb-27">

#### Servlet 3中的异步处理指的是什么？

在Servlet 3中引入了一项新的技术可以让Servlet异步处理请求。有人可能会质疑，既然都有多线程了，还需要异步处理请求吗？答案是肯定的，因为如果一个任务处理时间相当长，那么Servlet或Filter会一直占用着请求处理线程直到任务结束，随着并发用户的增加，容器将会遭遇线程超出的风险，这这种情况下很多的请求将会被堆积起来而后续的请求可能会遭遇拒绝服务，直到有资源可以处理请求为止。异步特性可以帮助应用节省容器中的线程，特别适合执行时间长而且用户需要得到结果的任务，如果用户不需要得到结果则直接将一个Runnable对象交给Executor并立即返回即可。
补充：多线程在Java诞生初期无疑是一个亮点，而Servlet单实例多线程的工作方式也曾为其赢得美名，然而技术的发展往往会颠覆我们很多的认知，就如同当年爱因斯坦的相对论颠覆了牛顿的经典力学一般。事实上，异步处理绝不是Serlvet 3首创，如果你了解Node.js的话，对Servlet 3的这个重要改进就不以为奇了。
下面是一个支持异步处理请求的Servlet的例子。

```java
import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/async"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        // 开启Tomcat异步Servlet支持
        req.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        final AsyncContext ctx = req.startAsync(); // 启动异步处理的上下文
        // ctx.setTimeout(30000);
        ctx.start(new Runnable() {
            @Override
            public void run() {
                // 在此处添加异步处理的代码
                ctx.complete();
            }
        });
    }
}
```

<p id="javaweb-28">

#### 如何在基于Java的Web项目中实现文件上传和下载？

在Sevlet 3 以前，Servlet API中没有支持上传功能的API，因此要实现上传功能需要引入第三方工具从POST请求中获得上传的附件或者通过自行处理输入流来获得上传的文件，我们推荐使用Apache的commons-fileupload。从Servlet 3开始，文件上传变得无比简单，相信看看下面的例子一切都清楚了。
上传页面index.jsp：

```jsp
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Photo Upload</title>
    </head>
    <body>
        <h1>Select your photo and upload</h1>
        <hr/>
        <div style="color:red;font-size:14px;">${hint}</div>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            Photo file: <input type="file" name="photo" />
            <input type="submit" value="Upload" />
        </form>
    </body>
</html>
```
支持上传的Servlet：
```java
package com.jackfrued.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // 可以用request.getPart()方法获得名为photo的上传附件
        // 也可以用request.getParts()获得所有上传附件（多文件上传）
        // 然后通过循环分别处理每一个上传的文件
        Part part = request.getPart("photo");
        if (part != null && part.getSubmittedFileName().length() > 0) {
            // 用ServletContext对象的getRealPath()方法获得上传文件夹的绝对路径
            String savePath = request.getServletContext().getRealPath("/upload");
            // Servlet 3.1规范中可以用Part对象的getSubmittedFileName()方法获得上传的文件名
            // 更好的做法是为上传的文件进行重命名（避免同名文件的相互覆盖）
            part.write(savePath + "/" + part.getSubmittedFileName());
            request.setAttribute("hint", "Upload Successfully!");
        } else {
            request.setAttribute("hint", "Upload failed!");
        }
        // 跳转回到上传页面
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
```

<p id="javaweb-29">

#### 服务器收到用户提交的表单数据，到底是调用Servlet的doGet()还是doPost()方法？
HTML的<form>元素有一个method属性，用来指定提交表单的方式，其值可以是get或post。我们自定义的Servlet一般情况下会重写doGet()或doPost()两个方法之一或全部，如果是GET请求就调用doGet()方法，如果是POST请求就调用doPost()方法，那为什么为什么这样呢？我们自定义的Servlet通常继承自HttpServlet，HttpServlet继承自GenericServlet并重写了其中的service()方法，这个方法是Servlet接口中定义的。HttpServlet重写的service()方法会先获取用户请求的方法，然后根据请求方法调用doGet()、doPost()、doPut()、doDelete()等方法，如果在自定义Servlet中重写了这些方法，那么显然会调用重写过的（自定义的）方法，这显然是对模板方法模式的应用（如果不理解，请参考阎宏博士的《Java与模式》一书的第37章）。当然，自定义Servlet中也可以直接重写service()方法，那么不管是哪种方式的请求，都可以通过自己的代码进行处理，这对于不区分请求方法的场景比较合适。

<p id="javaweb-30">

#### JSP中的静态包含和动态包含有什么区别？

静态包含是通过JSP的include指令包含页面，动态包含是通过JSP标准动作<jsp:forward>包含页面。静态包含是编译时包含，如果包含的页面不存在则会产生编译错误，而且两个页面的"contentType"属性应保持一致，因为两个页面会合二为一，只产生一个class文件，因此被包含页面发生的变动再包含它的页面更新前不会得到更新。动态包含是运行时包含，可以向被包含的页面传递参数，包含页面和被包含页面是独立的，会编译出两个class文件，如果被包含的页面不存在，不会产生编译错误，也不影响页面其他部分的执行。代码如下所示：

```jsp
<%-- 静态包含--%>
<%@ include file="..." %>
<%-- 动态包含--%>
<jsp:include page="...">
    <jsp:param name="..." value="..." />
</jsp:include>
```

<p id="javaweb-31">

#### Servlet中如何获取用户提交的查询参数或表单数据？
可以通过请求对象（HttpServletRequest）的getParameter()方法通过参数名获得参数值。如果有包含多个值的参数（例如复选框），可以通过请求对象的getParameterValues()方法获得。当然也可以通过请求对象的getParameterMap()获得一个参数名和参数值的映射（Map）。

<p id="javaweb-32">

#### Servlet中如何获取用户配置的初始化参数以及服务器上下文参数？

可以通过重写Servlet接口的init(ServletConfig)方法并通过ServletConfig对象的getInitParameter()方法来获取Servlet的初始化参数。可以通过ServletConfig对象的getServletContext()方法获取ServletContext对象，并通过该对象的getInitParameter()方法来获取服务器上下文参数。当然，ServletContext对象也在处理用户请求的方法（如doGet()方法）中通过请求对象的getServletContext()方法来获得。

<p id="javaweb-33">

#### 如何设置请求的编码以及响应内容的类型？

通过请求对象（ServletRequest）的setCharacterEncoding(String)方法可以设置请求的编码，其实要彻底解决乱码问题就应该让页面、服务器、请求和响应、Java程序都使用统一的编码，最好的选择当然是UTF-8；通过响应对象（ServletResponse）的setContentType(String)方法可以设置响应内容的类型，当然也可以通过HttpServletResponsed对象的setHeader(String, String)方法来设置。
说明：现在如果还有公司在面试的时候问JSP的声明标记、表达式标记、小脚本标记这些内容的话，这样的公司也不用去了，其实JSP内置对象、JSP指令这些东西基本上都可以忘却了，关于Java Web开发的相关知识，可以看一下《Servlet&JSP思维导图》，上面有完整的知识点的罗列。想了解如何实现自定义MVC框架的，可以看一下《Java Web自定义MVC框架详解》。

<p id="javaweb-34">

#### 解释一下网络应用的模式及其特点。

典型的网络应用模式大致有三类：B/S、C/S、P2P。其中B代表浏览器（Browser）、C代表客户端（Client）、S代表服务器（Server），P2P是对等模式，不区分客户端和服务器。B/S应用模式中可以视为特殊的C/S应用模式，只是将C/S应用模式中的特殊的客户端换成了浏览器，因为几乎所有的系统上都有浏览器，那么只要打开浏览器就可以使用应用，没有安装、配置、升级客户端所带来的各种开销。P2P应用模式中，成千上万台彼此连接的计算机都处于对等的地位，整个网络一般来说不依赖专用的集中服务器。网络中的每一台计算机既能充当网络服务的请求者，又对其它计算机的请求作出响应，提供资源和服务。通常这些资源和服务包括：信息的共享和交换、计算资源（如CPU的共享）、存储共享（如缓存和磁盘空间的使用）等，这种应用模式最大的阻力安全性、版本等问题，目前有很多应用都混合使用了多种应用模型，最常见的网络视频应用，它几乎把三种模式都用上了。
补充：此题要跟"电子商务模式"区分开，因为有很多人被问到这个问题的时候马上想到的是B2B（如阿里巴巴）、B2C（如当当、亚马逊、京东）、C2C（如淘宝、拍拍）、C2B（如威客）、O2O（如美团、饿了么）。对于这类问题，可以去百度上面科普一下。

<p id="javaweb-35">

#### 什么是Web Service（Web服务）？

从表面上看，Web Service就是一个应用程序，它向外界暴露出一个能够通过Web进行调用的API。这就是说，你能够用编程的方法透明的调用这个应用程序，不需要了解它的任何细节，跟你使用的编程语言也没有关系。例如可以创建一个提供天气预报的Web Service，那么无论你用哪种编程语言开发的应用都可以通过调用它的API并传入城市信息来获得该城市的天气预报。之所以称之为Web Service，是因为它基于HTTP协议传输数据，这使得运行在不同机器上的不同应用无须借助附加的、专门的第三方软件或硬件，就可相互交换数据或集成。
补充：这里必须要提及的一个概念是SOA（Service-Oriented Architecture，面向服务的架构），SOA是一种思想，它将应用程序的不同功能单元通过中立的契约联系起来，独立于硬件平台、操作系统和编程语言，使得各种形式的功能单元能够更好的集成。显然，Web Service是SOA的一种较好的解决方案，它更多的是一种标准，而不是一种具体的技术。

<p id="javaweb-36">

#### 概念解释：SOAP、WSDL、UDDI。

- SOAP：简单对象访问协议（Simple Object Access Protocol），是Web Service中交换数据的一种协议规范。
- WSDL：Web服务描述语言（Web Service Description Language），它描述了Web服务的公共接口。这是一个基于XML的关于如何与Web服务通讯和使用的服务描述；也就是描述与目录中列出的Web服务进行交互时需要绑定的协议和信息格式。通常采用抽象语言描述该服务支持的操作和信息，使用的时候再将实际的网络协议和信息格式绑定给该服务。
- UDDI：统一描述、发现和集成（Universal Description, Discovery and Integration），它是一个基于XML的跨平台的描述规范，可以使世界范围内的企业在互联网上发布自己所提供的服务。简单的说，UDDI是访问各种WSDL的一个门面（可以参考设计模式中的门面模式）。
  提示：关于Web Service的相关概念和知识可以在W3CSchool上找到相关的资料。

<p id="javaweb-37">

#### Java规范中和Web Service相关的规范有哪些？

Java规范中和Web Service相关的有三个：

- JAX-WS(JSR 224)：这个规范是早期的基于SOAP的Web Service规范JAX-RPC的替代版本，它并不提供向下兼容性，因为RPC样式的WSDL以及相关的API已经在Java EE5中被移除了。WS-MetaData是JAX-WS的依赖规范，提供了基于注解配置Web Service和SOAP消息的相关API。

- JAXM(JSR 67)：定义了发送和接收消息所需的API,相当于Web Service的服务器端。

- JAX-RS(JSR 311 & JSR 339 & JSR 370)：是Java针对REST（Representation State Transfer）架构风格制定的一套Web Service规范。

  REST是一种软件架构模式，是一种风格，它不像SOAP那样本身承载着一种消息协议， (两种风格的Web Service均采用了HTTP做传输协议，因为HTTP协议能穿越防火墙，Java的远程方法调用（RMI）等是重量级协议，通常不能穿越防火墙），因此可以将REST视为基于HTTP协议的软件架构。REST中最重要的两个概念是资源定位和资源操作，而HTTP协议恰好完整的提供了这两个点。HTTP协议中的URI可以完成资源定位，而GET、POST、OPTION、DELETE方法可以完成资源操作。因此REST完全依赖HTTP协议就可以完成Web Service，而不像SOAP协议那样只利用了HTTP的传输特性，定位和操作都是由SOAP协议自身完成的，也正是由于SOAP消息的存在使得基于SOAP的Web Service显得笨重而逐渐被淘汰。

<p id="javaweb-38">

#### 介绍一下你了解的Java领域的Web Service框架。

Java领域的Web Service框架很多，包括Axis2（Axis的升级版本）、Jersey（RESTful的Web Service框架）、CXF（XFire的延续版本）、Hessian、Turmeric、JBoss SOA等，其中绝大多数都是开源框架。
提示：面试被问到这类问题的时候一定选择自己用过的最熟悉的作答，如果之前没有了解过就应该在面试前花一些时间了解其中的两个，并比较其优缺点，这样才能在面试时给出一个漂亮的答案。

<p id="javaweb-39">

#### 转发与重定向的区别

转发：Servlet收到请求以后不去处理请求而是去调用服务器内部的其他资源处理请求
重定向：Servlet发送给浏览器一个特殊的响应，这个响应告诉浏览器再次向另一个地址发送请求。

|                | 转发   | 重定向 |
| -------------- | ------ | ------ |
| 请求的次数     | 1      | 2      |
| 发起的位置     | 服务器 | 浏览器 |
| 地址栏的改变   | 不改变 | 改变   |
| 浏览器是否感知 | 否     | 是     |

从数据共享上（区别）：forword是一个请求的延续，可以共享request作用域的数据。redirect开启一个新的请求，不可以共享request作用域的数据，但可以通过URL方式进行数据发送。
从性能上（区别）：forword性能要高于redirect。（因为性能上有区别，在本系统中请求跳转建议使用forword，如果是跨域访问，建议使用redirect。）

<p id="javaweb-40">

#### session和cookie的区别

1. session是存储在服务器端，cookie是存储在客户端的，所以从安全来讲session的安全性要比cookie高。

2. 单个cookie保存的数据不能超过4K，很多浏览器都限制一个站点最多保存20个cookie，而session是存放在服务器的内存中，所以session里的东西不断增加会造成服务器的负担，所以一般把很重要的信息才存储在session中，而把一些次要东西存储在客户端的cookie里(例如将登陆信息等重要信息存放为session，其他信息如果需要保留，可以放在cookie)

- cookie分为两大类分为会话cookie和持久化cookie，会话cookie，存放在客户端浏览器的内存中,他的生命周期和浏览器是一致的，浏览器关了会话cookie也就消失了，而持久化cookie是存放在客户端硬盘中，而持久化cookie的生命周期就是我们在设置cookie时候设置的那个保存时间


- 当浏览器关闭时session会不会丢失，session的信息是通过会话cookie的sessionid获取的，当浏览器关闭的时候会话cookie消失，所以我们的sessionid也就消失了，但是session的信息还存在服务器端，这时我们只是查不到所谓的session但它并不是不存在。


- session在什么情况下丢失，就是在服务器关闭的时候（也可以说说session的活化和钝化），或者是session过期(默认时间是30分钟)，再或者调用了invalidate()的或者是我们想要session中的某一条数据消失调用session.removeAttribute()方法


- session在什么时候被创建呢，确切的说是通过调用getsession()来创建。访问HTML页面是不会创建session，但是访问index.JSP时会创建session(JSP实际上是一个Servlet，Servlet中有getSession方法)。


<p id="javaweb-41">

#### 如何防止表单重复提交

针对于重复提交的整体解决方案：

1. 用redirect（重定向）来解决重复提交的问题
2. 点击一次之后，按钮失效
3. 通过loading(Loading原理是在点击提交时，生成Loading样式，在提交完成之后隐藏该样式)
4. 自定义重复提交过滤器