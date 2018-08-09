#  Redis
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。
>  Ps:在学习Redis之前，先简单介绍一些关于NoSql相关的知识。
## Redis的五大数据类型
> * [Redis的五大数据类型](#why)
>   * [String](#string)
>   * [hash](#hash)
>   * [list](#list)
>   * [set](#set)
>   * [zset](#zset)

<p id="why">

##  String

>  *  string是redis最基本的类型，你可以理解成与Memcached一模一样的类型，一个key对应一个value。
>  *  string类型是二进制安全的。意思是redis的string可以包含任何数据。比如jpg图片或者序列化的对象 。
>  *  string类型是Redis最基本的数据类型，一个redis中字符串value最多可以是512M


##  hash

>  *  Redis hash 是一个键值对集合。
>  *  Redis hash是一个string类型的field和value的映射表，hash特别适合用于存储对象。
>  *  类似Java里面的Map<String,Object>

##  list 

>  *  Redis 列表是简单的字符串列表，按照插入顺序排序。你可以添加一个元素导列表的头部（左边）或者尾部（右边）。
>  *  它的底层实际是个链表.

##  set

>  *  Redis的Set是string类型的无序集合。它是通过HashTable实现实现的，

##  zset(sorted set：有序集合)

>  *  Redis zset 和 set 一样也是string类型元素的集合,且不允许重复的成员。不同的是每个元素都会关联一个double类型的分数。
>  *  Redis正是通过分数来为集合中的成员进行从小到大的排序。zset的成员是唯一的,但分数(score)却可以重复。