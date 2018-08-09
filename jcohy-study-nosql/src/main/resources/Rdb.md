#  Redis
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。
>  Ps:在学习Redis之前，先简单介绍一些关于NoSql相关的知识。
## Redis的持久化
> * [RDB](#rdb)
>    *  [概述](#rdbgaishu)
>    *  [文件](#wenjian)
>    *  [配置](#peizhi)
>    *  [如何触发RDB快照](#kuaizhao)
>    *  [恢复数据](#huifu)
>    *  [优势](#youshi)
>    *  [劣势](#lieshi)
>    *  [停止](#stop)
>    *  [概述](#rdbgaishu)
> * [AOF](#aof)


##  RDB

<p id="rdbgaishu">

####  概述

>  在指定的时间间隔内将内存中的数据集快照写入磁盘，
>  也就是行话讲的Snapshot快照，它恢复时是将快照文件直接读到内存里</br>
>  Redis会单独创建（fork）一个子进程来进行持久化，会先将数据写入到
>  一个临时文件中，待持久化过程都结束了，再用这个临时文件替换上次持久化好的文件。
>  整个过程中，主进程是不进行任何IO操作的，这就确保了极高的性能。</br>
>  如果需要进行大规模数据的恢复，且对于数据恢复的完整性不是非常敏感，那RDB方
>  式要比AOF方式更加的高效。RDB的缺点是最后一次持久化后的数据可能丢失。</br>

>  fork的作用是复制一个与当前进程一样的进程。新进程的所有数据（变量、环境变量、程序计数器等）
 数值都和原进程一致，但是是一个全新的进程，并作为原进程的子进程。

<p id="wenjian">

####  文件

>  rdb 保存的是dump.rdb文件

<p id="peizhi">

####  配置

>  redis的配置文件中的SNAPSHOTTING快照配置。详情参照[SNAPSHOTTING配置](https://github.com/jiachao23/StudyNote/blob/master/src/NoSql/conf.md#snapshotting)

<p id="kuaizhao">

####  如何触发RDB快照

>  *  redis的配置文件中的SNAPSHOTTING快照配置。详情参照[SNAPSHOTTING配置](https://github.com/jiachao23/StudyNote/blob/master/src/NoSql/conf.md#snapshotting)

>  冷拷贝后重新使用
>  *  命令save或者是bgsave

>  Save：save时只管保存，其它不管，全部阻塞。</br>
>  BGSAVE：Redis会在后台异步进行快照操作，快照同时还可以响应客户端请求。可以通过lastsave。命令获取最后一次成功执行快照的时间。
>  *  执行flushall命令，也会产生dump.rdb文件，但里面是空的，无意义。

<p id="huifu">

####  恢复数据

>  将备份文件 (dump.rdb) 移动到 redis 安装目录并启动服务即可。CONFIG GET dir获取目录。

<p id="youshi">

####  优势

>  *  适合大规模的数据恢复。
>  *  对数据完整性和一致性要求不高。

<p id="lieshi">

####  劣势

>  *  在一定间隔时间做一次备份，所以如果redis意外down掉的话，就会丢失最后一次快照后的所有修改。
>  *  fork的时候，内存中的数据被克隆了一份，大致2倍的膨胀性需要考虑。

<p id="stop">

####  停止

>  动态所有停止RDB保存规则的方法：redis-cli config set save ""