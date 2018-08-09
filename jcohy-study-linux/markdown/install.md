#  Linux
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## Linux下常用软件安装
> * [JDK](#jdk)
> * [Tomcat](#tomcat)
> * [Mysql](#mysql)
> * [Redis](#redis)
> * [Nginx](#nginx)
> * [Lvs](#lvs)

<p id ="jdk">

## JDK安装

>  1.  官网下载linux版本的jdk，我这里使用的是jdk-7u45-linux-x64.tar.gzjdk-7u45-linux-x64.tar.gz。
>  2.  用FileZilla或其他工具将下载好的安装包上传至Linux服务器。
>  3.  解压jdk到/usr/local目录       

>   tar -zxvf jdk-7u45-linux-x64.tar.gz -C /usr/local/
>  4.  设置环境变量，在/etc/profile文件最后追加相关内容

>    vi /etc/profile</br>
>    export JAVA_HOME=/usr/local/jdk1.7.0_45</br>
>    export PATH=$PATH:$JAVA_HOME/bin</br>
>  5.  刷新环境变量

>    source /etc/profile</br>
>  6.  测试java命令是否可用

>    java -version</br>

<p id ="tomcat">

## Tomcat安装

>  1.  上传apache-tomcat-7.0.68.tar.gz到Linux上(安装包自行在官网下载)
>  2.  解压tomcat

>  tar -zxvf apache-tomcat-7.0.68.tar.gz -C /usr/local/
>  3.  启动tomcat

>  /usr/local/apache-tomcat-7.0.68/bin/startup.sh
>  4.  查看tomcat进程是否启动

>  jps
>  5.  查看tomcat进程端口

>    netstat -anpt | grep 2465
>  6.  通过浏览器访问tomcat

>   http://192.168.0.101:8080/

