#  Redis
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## NoSql入门和概述2
> * [NoSql的模型简介](#model)
> * [NoSql数据库的四大分类](#sort)
> * [CAP+BASE](#yuanli)

<p id="model">

##  NoSql的模型简介
>  *  聚合模型
>    *  KV键值
>    *  BSON:BSON（）是一种类json的一种二进制形式的存储格式，简称Binary JSON，它和JSON一样，支持内嵌的文档对象和数组对象
>    *  列族:是按列存储数据的。最大的特点是方便存储结构化和半结构化数据，方便做数据压缩，对针对某一列或者某几列的查询有非常大的IO优势
>    *  图形:一种网状的图形模型

<p id="sort">

##  NoSql数据库的四大分类
>  *  KV键值
>  *  文档型数据库(bson较多)

        典型代表：MongoDB
        MongoDB 是一个基于分布式文件存储的数据库。由 C++ 语言编写。旨在为 WEB 应用提供可扩展的高性能数据存储解决方案。
        MongoDB 是一个介于关系数据库和非关系数据库之间的产品，是非关系数据库当中功能最丰富，最像关系数据库的。
>  *  列存储数据库

        Cassandra,HBase
>  *  图关系数据库

        Neo4J,InfoGrid

 <table>
         <tr>
             <th>分类</th>
             <th>举例</th>
             <th>应用场景</th>
             <th>数据模型</th>
             <th>优点</th>
             <th>缺点</th>
         </tr>
         <tr>
             <th>键值(key-value)</th>
             <th>Tokyo,Redis,oracle DBD</th>
             <th>内容缓存，主要用于大数据高访问负载，日志等</th>
             <th>key指向value的键值对，通常用hashtable实现</th>
             <th>查找速度快</th>
             <th>数据无结构化，通常只被当作字符串或者二进制数据</th>
         </tr>
         <tr>
             <th>列存储数据库</th>
             <th>Cassandra，HBase，Riak</th>
             <th>分布式的文件系统</th>
             <th>以列簇式存储，将同一列数据存在一起</th>
             <th>查找速度快，可扩展性性强，更容易进行分布式扩展</th>
             <th>功能相对局限</th>
         </tr>
         <tr>
             <th>文档型数据库</th>
             <th>CouchDB，MongoDb</th>
             <th>Web应用</th>
             <th>key-Value对应的键值对，Value为结构化数据</th>
             <th>数据结构要求不严格，表结构可变</th>
             <th>查询性能不高，而且缺乏统一的查询语句</th>
         </tr>
          <tr>
              <th>图形</th>
              <th>Neo4J，InfoGrid</th>
              <th>社交网络，推荐系统等专注构建关系图谱</th>
              <th>图结构</th>
              <th>利用图结构相关算法，最短路径寻址，N度关系</th>
              <th>有时候要对整个图计算才能得出结果</th>
          </tr>
     </table
 
<p id="yuanli">

##  CAP+BASE
####  传统的关系型数据库遵循ACID规则
>  * A (Atomicity) 原子性</br>
>  原子性很容易理解，也就是说事务里的所有操作要么全部做完，要么都不做，事务成功的条件是事务里的所有操作都成功，只要有一个操作失败，整个事务就失败，需要回滚。比如银行转账，从A账户转100元至B账户，分为两个步骤：1）从A账户取100元；2）存入100元至B账户。这两步要么一起完成，要么一起不完成，如果只完成第一步，第二步失败，钱会莫名其妙少了100元。 </br>   
>  * C (Consistency) 一致性</br>
>  一致性也比较容易理解，也就是说数据库要一直处于一致的状态，事务的运行不会改变数据库原本的一致性约束。   </br> 
>  * I (Isolation) 独立性</br>
>  所谓的独立性是指并发的事务之间不会互相影响，如果一个事务要访问的数据正在被另外一个事务修改，只要另外一个事务未提交，它所访问的数据就不受未提交事务的影响。比如现有有个交易是从A账户转100元至B账户，在这个交易还未完成的情况下，如果此时B查询自己的账户，是看不到新增加的100元的</br>
>  * D (Durability) 持久性</br>
>  持久性是指一旦事务提交后，它所做的修改将会永久的保存在数据库上，即使出现宕机也不会丢失。</br>

####  CAP
这个理论是由美国著名科学家，同时也是著名互联网企业Inktomi的创始人Eric Brewer在2000年PODC(Symposium on Principles of Distributed Computing)大会上提出的，后来Seth Gilbert 和 Nancy lynch两人也证明了CAP理论的正确性，
虽然在后来近十年的时间很多人对CAP理论提出了很多异议，但是在NoSQL的世界中，它还是非常有参考价值的。
它的意思是，一个分布式系统不能同时满足一致性，可用性和分区容错性这三个需求，最多只能同时满足两个。


>  * C (Consistency) 强一致性</br>
>  任何一个读操作总是能读取到之前完成的写操作结果，也就是在分布式环境中，多点的数据是一致的。</br>   
>  * A (Availability) 可用性</br>
>  每一个操作总是能够在确定的时间内返回，也就是系统随时都是可用的。</br> 
>  * P (Partition tolerance) 分区容错性</br>
>   在出现网络分区(比如断网)的情况下，分离的系统也能正常运行。</br>

####  CAP的三选二
由于一个分布式系统不能同时满足一致性，可用性和分区容错性这三个需求，最多只能同时满足两个。所以将NoSql数据库分成了满足CA原则，CP原则，AP原则三大类。

>  *  CA原则---单点集群，满足一致性，可用性的系统。通常在可扩展不够强大。（RDBMS。。。）
>  *  CP原则---满足一致性，分区容错行的系统。通常性能不是特别高。（MongoDB，Redis，HBase。。。）
>  *  AP原则---满足可用性，分区容错性。通常对一致性要求低一点。（CouchDb，Riak，Cassandra。。。）

在分布式系统中，分区容错性是必须实现的。</br>
一致性和可用性之间取一个平衡。多余大多数web应用，其实并不需要强一致性。</br>
因此牺牲C换取P，这是目前分布式数据库产品的方向。</br>

####  一致性与可用性的决择

>  对于web2.0网站来说，关系数据库的很多主要特性却往往无用武之地。</br>
>  *  数据库事务一致性需求 </br>
>     很多web实时系统并不要求严格的数据库事务，对读一致性的要求很低， 有些场合对写一致性要求并不高。允许实现最终一致性。</br>
>  *  数据库的写实时性和读实时性需求</br>
>     对关系数据库来说，插入一条数据之后立刻查询，是肯定可以读出来这条数据的，但是对于很多web应用来说，并不要求这么高的实时性，比方说发一条消息之 后，过几秒乃至十几秒之后，我的订阅者才看到这条动态是完全可以接受的。</br>
>  *  对复杂的SQL查询，特别是多表关联查询的需求 </br>
>  　 任何大数据量的web系统，都非常忌讳多个大表的关联查询，以及复杂的数据分析类型的报表查询，特别是SNS类型的网站，从需求以及产品设计角 度，就避免了这种情况的产生。往往更多的只是单表的主键查询，以及单表的简单条件分页查询，SQL的功能被极大的弱化了。</br>

####  BASE

>  BASE就是为了解决关系数据库强一致性引起的问题而引起的可用性降低而提出的解决方案。</br>
   BASE其实是下面三个术语的缩写：</br>
   
>  *  基本可用（Basically Available）</br>
>  *  软状态（Soft state）</br>
>  *  最终一致（Eventually consistent）</br>

>  它的思想是通过让系统放松对某一时刻数据一致性的要求来换取系统整体伸缩性和性能上改观。为什么这么说呢，缘由就在于大型系统往往由于地域分布和极高性能的要求，不可能采用分布式事务来完成这些指标，要想获得这些指标，我们必须采用另外一种方式来完成，这里BASE就是解决这个问题的办法。

####  分布式+集群

>  1分布式：不同的多台服务器上面部署不同的服务模块（工程），他们之间通过Rpc/Rmi之间通信和调用，对外提供服务和组内协作。</br>    
>  2集群：不同的多台服务器上面部署相同的服务模块，通过分布式调度软件进行统一的调度，对外提供服务和访问。
    