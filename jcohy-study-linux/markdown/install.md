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

<p id ="jdk">

## JDK安装

1、官网下载linux版本的jdk，我这里使用的是jdk-7u45-linux-x64.tar.gzjdk-7u45-linux-x64.tar.gz。

2、用FileZilla或其他工具将下载好的安装包上传至Linux服务器。

3、解压jdk到/usr/local目录

```shell
tar -zxvf jdk-7u45-linux-x64.tar.gz -C /usr/local/
```

4、设置环境变量，在/etc/profile文件最后追加相关内容

```shell
vi /etc/profile

export JAVA_HOME=/usr/local/jdk1.7.0_45
export PATH=$PATH:$JAVA_HOME/bin
```

5、刷新环境变量

```shell
source /etc/profile
```

6、测试java命令是否可用

```shell
java -version
```

<p id ="tomcat">

## Tomcat安装

1、上传apache-tomcat-7.0.68.tar.gz到Linux上(安装包自行在官网下载)

2、解压tomcat

```shell
tar -zxvf apache-tomcat-7.0.68.tar.gz -C /usr/local/
```

3、启动tomcat

```shell
/usr/local/apache-tomcat-7.0.68/bin/startup.sh
```


4、查看tomcat进程是否启动

```shell
jps
```

5、查看tomcat进程端口

```shell
netstat -anpt | grep 2465
```

6、通过浏览器访问tomcat

   http://192.168.0.101:8080/

<p id ="mysql">

## Mysql安装

 1. 安装Mysql

```shell
yum install mysql-community-server
```

  2. 启动mysql

```shell
systemctl start mysqld
```


 3.  检查mysql状态

```shell
systemctl status mysqld
```
4. 设置开机启动

```shell
systemctl enable mysqld
```

  5.修改root本地登录密码

```shell

#mysql安装完成之后，在/var/log/mysqld.log文件中给root生成了一个默认密码。通过下面的方式找到root默认密码，然后登录mysql进行修改：
grep 'temporary password' /var/log/mysqld.log

mysql -uroot -p

#登录上去后，使用下列语句更新密码
ALTER USER 'root'@'localhost' IDENTIFIED BY 'MyNewPass4!';
#或者
set password for 'root'@'localhost'=password('MyNewPass4!')；
```

mysql5.7默认安装了密码安全检查插件（validate_password），默认密码检查策略要求密码必须包含：大小写字母、数字和特殊符号，并且长度不能少于8位。否则会提示ERROR 1819 (HY000): Your
password does not satisfy the current policy requirements错误，如下图所示：

6.修改密码策略

```shell
#查看密码策略的相关信息
show variables like '%password%';
```

![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-linux/images/1.jpg)

validate_password_policy：密码策略，默认为MEDIUM策略
validate_password_dictionary_file：密码策略文件，策略为STRONG才需要
validate_password_length：密码最少长度
validate_password_mixed_case_count：大小写字符长度，至少1个
validate_password_number_count ：数字至少1个
validate_password_special_char_count：特殊字符至少1个
*上述参数是默认策略**MEDIUM**的密码检查规则*

```shell
set global validate_password_policy=0;
select @@validate_password_length;
set global validate_password_length=1;
```

7.添加远程登录用户

```shell
GRANT ALL PRIVILEGES ON *.* TO 'jiac'@'%' IDENTIFIED BY 'jiac0917!' WITH GRANT OPTION;
```

8.配置默认编码为utf8

```shell
#修改/etc/my.cnf配置文件，在[mysqld]下添加编码配置，如下所示：
[mysqld]
character_set_server=utf8
init_connect='SET NAMES utf8'
```

<p id ="redis">

## Redis安装

1、[到官网](https://github.com/MSOpenTech/redis/releases)下载redis安装包

```shell
$ wget http://download.redis.io/releases/redis-2.8.17.tar.gz
$ tar xzf redis-2.8.17.tar.gz
$ cd redis-2.8.17
$ make
```

2、make完后 redis-2.8.17目录下会出现编译后的redis服务程序redis-server,还有用于测试的客户端程序redis-cli,两个程序位于安装目录 src 目录下：

下面启动redis服务.

```shell
$ cd src
$ ./redis-server
```

3、注意这种方式启动redis 使用的是默认配置。也可以通过启动参数告诉redis使用指定配置文件使用下面命令启动。

```shell
$ cd src
$ ./redis-server ../redis.conf
```

4、**redis.conf** 是一个默认的配置文件。我们可以根据需要使用自己的配置文件。

启动redis服务进程后，就可以使用测试客户端程序redis-cli和redis服务交互了。 比如：

```shell
$ cd src
$ ./redis-cli
redis> set foo bar
OK
redis> get foo
"bar"
```

5、使用docker安装[redis](http://www.runoob.com/docker/docker-install-redis.html)

<p id ="nginx">

## nginx安装

1、安装编译工具及库文件

```shell
yum -y install make zlib zlib-devel gcc-c++ libtool  openssl openssl-devel
```

2、首先要安装 PCRE

- 1、下载 PCRE 安装包，下载地址： <http://downloads.sourceforge.net/project/pcre/pcre/8.35/pcre-8.35.tar.gz>

```shell
[root@bogon src]# cd /usr/local/src/
[root@bogon src]# wget http://downloads.sourceforge.net/project/pcre/pcre/8.35/pcre-8.35.tar.gz
```

- 解压安装包:

```shell
[root@bogon src]# tar zxvf pcre-8.35.tar.gz
```

- 进入安装包目录

```shell
[root@bogon src]# cd pcre-8.35
```

- 编译安装

```shell
[root@bogon pcre-8.35]# ./configure
[root@bogon pcre-8.35]# make && make install
```

- 查看pcre版本

```shell
[root@bogon pcre-8.35]# pcre-config --version
```

3、安装 Nginx

- 下载 Nginx，下载地址：<http://nginx.org/download/nginx-1.6.2.tar.gz>

```shell
[root@bogon src]# cd /usr/local/src/
[root@bogon src]# wget http://nginx.org/download/nginx-1.6.2.tar.gz
```

- 安装包

```shell
[root@bogon src]# tar zxvf nginx-1.6.2.tar.gz
```

- 进入安装包目录

```shell
[root@bogon src]# cd nginx-1.6.2
```

- 编译安装

```shell
[root@bogon nginx-1.6.2]# ./configure --prefix=/usr/local/webserver/nginx --with-http_stub_status_module --with-http_ssl_module --with-pcre=/usr/local/src/pcre-8.35
[root@bogon nginx-1.6.2]# make
[root@bogon nginx-1.6.2]# make install
```

- 查看nginx版本

```shell
[root@bogon nginx-1.6.2]# /usr/local/webserver/nginx/sbin/nginx -v
```

4、启动nginx

```shell
[root@bogon conf]# /usr/local/webserver/nginx/sbin/nginx
```

5、Nginx 其他命令

```shell
/usr/local/webserver/nginx/sbin/nginx -s reload            # 重新载入配置文件
/usr/local/webserver/nginx/sbin/nginx -s reopen            # 重启 Nginx
/usr/local/webserver/nginx/sbin/nginx -s stop              # 停止 Nginx
```

6、使用docker安装[nginx](http://www.runoob.com/docker/docker-install-nginx.html)

