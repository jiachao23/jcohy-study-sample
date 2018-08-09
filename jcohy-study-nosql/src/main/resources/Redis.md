#  Redis
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。
>  Ps:在学习Redis之前，先简单介绍一些关于NoSql相关的知识。
## Redis入门和概述
> * [Redis概述](#gaishu)
> * [Redis的应用场景](#sign)
> * [Redis的使用](#use)
> * [Redis常用命令](#command)
<p id="gaishu">

##  概述
>  Redis:REmote DIctionary Server(远程字典服务器).它是是完全开源免费的，用C语言编写的，遵守BSD协议，
>  是一个高性能的(key/value)分布式内存数据库，基于内存运行
>  并支持持久化的NoSQL数据库，是当前最热门的NoSql数据库之一,
>  也被人们称为数据结构服务器,具有如下特点：
>  * Redis支持数据的持久化，可以将内存中的数据保持在磁盘中，重启的时候可以再次加载进行使用
>  * Redis不仅仅支持简单的key-value类型的数据，同时还提供list，set，zset，hash等数据结构的存储
>  * Redis支持数据的备份，即master-slave模式的数据备份

<p id="sign">

##  Redis的应用场景

>  *  内存存储和持久化：redis支持异步将内存中的数据写到硬盘上，同时不影响继续服务
>  *  取最新N个数据的操作，如：可以将最新的10条评论的ID放在Redis的List集合里面
>  *  模拟类似于HttpSession这种需要设定过期时间的功能
>  *  发布、订阅消息系统
>  *  定时器、计数器

<p id="use">

##  Redis的使用

>  ####  1.首先在http://redis.io/  下载redis的安装包。将它放入我们的Linux目录/opt
>  ####  2.解压命令:tar -zxvf redis-3.0.4.tar.gz
>  ####  3.解压完成后出现文件夹：redis-3.0.4。进入目录:cd redis-3.0.4
>  ####  4.在redis-3.0.4目录下执行make命令.
            运行make命令时故意出现的错误解析：下载gcc。yum install gcc-c++.安装后。运行make distclean之后再make
>  ####  5.如果make完成后继续执行make install
>  ####  6.redism默认安装路径在 /use/local/bin 。下
>  ####  7.redis-server 启动服务.resdle-cli -p 6379
>  ####  8.输入ping  如果成功。会打印pong。
>  ####  9.查看 ps -ef|grep redis
>  ####  9.停止redis。SHUTDOWN ，然后输入exit

<p id="command">

##  Redis常用命令

>  *  redis-benchmark  redis性能测试
>  *  redis默认安装了16个库,角标是[0-15],默认数据库为0。。select命令切换数据库
>  *  dbsize:查看当前数据库的key的数量
>  *  keys *:显示当前库的所有key
>  *  set key value:设置键值对
>  *  get key:获取key的值
>  *  FLUSHALL,FLUSHDB:删除所有库，删除当前库。

>  *  [Redis常用命令](http://redisdoc.com/)