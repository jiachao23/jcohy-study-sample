
#  zookeeper
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## zookeeper
> * [概述](#gaishu)
> * [安装](#install)

<p id="gaishu">

##  概述

####  Zookeeper是一个分布式协调服务；就是为用户的分布式应用程序提供协调服务


>  *  zookeeper是为别的分布式程序服务的
>  *  Zookeeper本身就是一个分布式程序（只要有半数以上节点存活，zk就能正常服务）
>  *  Zookeeper所提供的服务涵盖：主从协调、服务器节点动态上下线、统一配置管理、分布式共享锁、统一名称服务……
>  *  虽然说可以提供各种服务，但是zookeeper在底层其实只提供了两个功能：管理(存储，读取)用户程序提交的数据； 并为用户程序提供数据节点监听服务；
 
 Zookeeper常用应用场景：
 《见图》
 
 Zookeeper集群的角色：  Leader 和  follower  （Observer）
 只要集群中有半数以上节点存活，集群就能提供服务

<p id="install">

##  安装

### 2.1    机器部署
安装到台虚拟机上,安装好JDK
> ##### 2.1.1    上传
上传用工具。
> ##### 2.1.2.    解压

    su – hadoop（切换到hadoop用户）
    tar -zxvf zookeeper-3.4.5.tar.gz（解压）

> ##### 2.1.3.    重命名

    mv zookeeper-3.4.5 zookeeper（重命名文件夹zookeeper-3.4.5为zookeeper）

> ##### 2.1.4.    修改环境变量

>  1.(切换用户到root)

    su – root
>  2.配置环境变量文件
    
    vi /etc/profile(修改文件)
 
    export ZOOKEEPER_HOME=/home/hadoop/zookeeper
    export PATH=$PATH:$ZOOKEEPER_HOME/bin

    source /etc/profile

>  3.台zookeeper都需要修改

>  4.修改完成后切换回hadoop用户：

    su - hadoop

### 2.2    修改配置文件
> ##### 2.2.1、用hadoop用户操作

    cd zookeeper/conf
    cp zoo_sample.cfg zoo.cfg

> ##### 2.2.2、添加内容：
    
    vi zoo.cfg
    dataDir=/home/hadoop/zookeeper/data
    dataLogDir=/home/hadoop/zookeeper/log
    server.1=slave1:2888:3888 (主机名, 心跳端口、数据端口)
    server.2=slave2:2888:3888
    server.3=slave3:2888:3888

> ##### 2.2.3、创建文件夹：

    cd /home/hadoop/zookeeper/
    mkdir -m 755 data
    mkdir -m 755 log

> ##### 2.2.4、在data文件夹下新建myid文件，myid的文件内容为：

    cd data
    vi myid
    添加内容：
    1

### 2.3    将集群下发到其他机器上
    scp -r /home/hadoop/zookeeper hadoop@slave2:/home/hadoop/
    scp -r /home/hadoop/zookeeper hadoop@slave3:/home/hadoop/

> ##### 2.3.1    修改其他机器的配置文件

    到slave2上：修改myid为：2
    到slave3上：修改myid为：3
> ##### 2.3.2    启动（每台机器）
    
    zkServer.sh start

> ##### 2.3.3    查看集群状态
    1、    jps（查看进程）
    2、    zkServer.sh status（查看集群状态，主从信息）    