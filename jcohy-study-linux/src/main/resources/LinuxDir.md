#### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	
> #### PS:待开发中。。。。

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

> #### PS:我的学习笔记,点击可以跳转到相应分类

##  Linux目录结构
>  * [Linux目录结构](#mulu)
>  * [Linux常用操作](#changyong)

<p id="mulu">

## Linux目录

  ![Linux目录结构](https://github.com/jiachao23/StudyNote/blob/master/src/img/linuxdir.png)

>  *  bin  (binaries)存放二进制可执行文件
>  *  sbin  (super user binaries)存放二进制可执行文件，只有root才能访问
>  *  etc (etcetera)存放系统配置文件
>  *  usr  (unix shared resources)用于存放共享的系统资源
>  *  home 存放用户文件的根目录
>  *  root  超级用户目录
>  *  dev (devices)用于存放设备文件
>  *  lib  (library)存放跟文件系统中的程序运行所需要的共享库及内核模块
>  *  mnt  (mount)系统管理员安装临时文件系统的安装点
>  *  boot 存放用于系统引导时使用的各种文件
>  *  tmp  (temporary)用于存放各种临时文件
>  *  var  (variable)用于存放运行时需要改变数据的文件

<p id="changyong">

##  Linux常用操作

>  *  修改主机名

            vi /etc/sysconfig/network
                    NETWORKING=yes
                    HOSTNAME=username
>  *  修改ip地址

            vi /etc/sysconfig/network-scripts/ifcfg-eth0
                    DEVICE=eth0
                    TYPE=Ethernet
                    ONBOOT=yes
                    BOOTPROTO=static
                    IPADDR=192.168.0.101
                    NETMASK=255.255.255.0
            service network restart
>  *  修改ip地址和主机名的映射关系

            vi /etc/hosts
                127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4
                ::1         localhost localhost.localdomain localhost6 localhost6.localdomain6
                192.168.0.101 username


>  *  关闭iptables并设置其开机启动/不启动

            service iptables stop
            chkconfig iptables on
            chkconfig iptables off

>  *  安装JDK

        1.上传jdk-7u45-linux-x64.tar.gz到Linux上
        2.解压jdk到/usr/local目录
                tar -zxvf jdk-7u45-linux-x64.tar.gz -C /usr/local/
        3.设置环境变量，在/etc/profile文件最后追加相关内容
                vi /etc/profile
                export JAVA_HOME=/usr/local/jdk1.7.0_45
                export PATH=$PATH:$JAVA_HOME/bin
        4.刷新环境变量
                source /etc/profile
        5.测试java命令是否可用
                java -version
>  *  安装Tomcat

        1.上传apache-tomcat-7.0.68.tar.gz到Linux上
        2.解压tomcat
                tar -zxvf apache-tomcat-7.0.68.tar.gz -C /usr/local/
        3.启动tomcat
                /usr/local/apache-tomcat-7.0.68/bin/startup.sh
        4.查看tomcat进程是否启动
                jps
                2465  Bootstrap
        5.查看tomcat进程端口
                netstat -anpt | grep 2465
        6.通过浏览器访问tomcat
                http://192.168.0.101:8080/
>  *  安装Mysql

        1.上传MySQL-server-5.5.48-1.linux2.6.x86_64.rpm、MySQL-client-5.5.48-1.linux2.6.x86_64.rpm到Linux上
        2.使用rpm命令安装MySQL-server-5.5.48-1.linux2.6.x86_64.rpm，缺少perl依赖
                 rpm -ivh MySQL-server-5.5.48-1.linux2.6.x86_64.rpm 
        3.安装perl依赖，上传6个perl相关的rpm包
         
                 rpm -ivh perl-*
        4.再安装MySQL-server，rpm包冲突
                 rpm -ivh MySQL-server-5.5.48-1.linux2.6.x86_64.rpm
         
        5.卸载冲突的rpm包
                 rpm -e mysql-libs-5.1.73-5.el6_6.x86_64 --nodeps
        6.再安装MySQL-client和MySQL-server
                 rpm -ivh MySQL-client-5.5.48-1.linux2.6.x86_64.rpm
                 rpm -ivh MySQL-server-5.5.48-1.linux2.6.x86_64.rpm
        7.启动MySQL服务，然后初始化MySQL
                 service mysql start
                 /usr/bin/mysql_secure_installation
        8.测试MySQL
                 mysql -u root -p

