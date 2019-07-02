#  Linux下常用软件安装
> #### PS:待开发中。。。。
> #### 作者网页：jiac


> * [JDK](#jdk)
> * [Tomcat](#tomcat)
> * [Mysql](#mysql)
> * [Redis](#redis)
> * [Nginx](#nginx)
> * [git](#git)
> * [gitlab](#gitlab)
> * [node](#node)
> * [yapi](#yapi)
> * [mongodb](#mongodb)
> * [docker](#docker)
> * [Jenkins](#jenkins)

<p id ="jdk">

## JDK

1、用FileZilla或其他工具将下载好的安装包上传至Linux服务器。放置在 **/opt/software/** 目录下。这里使用的是 **jdk-8u144-linux-x64.tar.gz**

3、解压jdk到/usr/local目录

```shell
tar -zxvf jdk-8u144-linux-x64.tar.gz -C /usr/local/
```

4、设置环境变量，在/etc/profile文件最后追加相关内容

```shell
vi /etc/profile

export JAVA_HOME=/usr/local/jdk1.8.0_144
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

## Tomcat

1、用FileZilla或其他工具将下载好的安装包上传至Linux服务器。放置在 **/opt/software/** 目录下。这里使用的是 **apache-tomcat-7.0.94.tar.gz**

2、解压tomcat

```shell
tar -zxvf apache-tomcat-7.0.94.tar.gz -C /usr/local/
```

3、启动tomcat

```shell
/usr/local/apache-tomcat-7.0.94/bin/startup.sh
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

 <http://192.168.11.231:8080/>

<p id ="mysql">

## Mysql

1. 用FileZilla或其他工具将下载好的安装包上传至Linux服务器。放置在 **/opt/software/** 目录下。这里使用的是 **mysql-8.0.16-2.el7.x86_64.rpm-bundle.tar**

2. 解压mysql

```shell
	mkdir -p /usr/local/mysql
	tar -xvf mysql-8.0.16-2.el7.x86_64.rpm-bundle.tar -C /usr/local/mysql
```


3.  centos7默认集成了MariaDB，而安装mysql的话会和mariadb的文件冲突，所以需要先卸载掉mariadb

```shell
	yum remove mariadb
```

4. 安装相关依赖

```shell
yum search libaio  # 检索相关信息
yum install -y libaio # 安装依赖包

yum search net-tools
yum install -y net-tools

yum search perl
yum install -y perl 
```

5. mysql rpm 安装顺序

```xml
rpm -ivh mysql-community-common-8.0.16-2.el7.x86_64.rpm   
rpm -ivh mysql-community-libs-8.0.16-2.el7.x86_64.rpm   
rpm -ivh mysql-community-client-8.0.16-2.el7.x86_64.rpm  
rpm -ivh mysql-community-server-8.0.16-2.el7.x86_64.rpm 
```

6.设置开机启动

```shell
systemctl enable mysqld
```

7.启动mysql

```shell
systemctl start mysqld
```

8、mysql安装完成之后，在/var/log/mysqld.log文件中给root生成了一个默认密码。通过下面的方式找到root默认密码，然后登录mysql进行修改：

```shell
grep 'temporary password' /var/log/mysqld.log

mysql -uroot -p
```

9、登录上去后，使用下列语句更新密码

```shell
 ALTER USER 'root'@'localhost' IDENTIFIED BY 'Xuanwuai@123';
```

 mysql 5.8 修改密码加密方式，改成mysql_native_password,然后修改密码
```shell
 
 ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Xuanwuai@123';
 SET PASSWORD FOR 'root'@'localhost' = PASSWORD('Xuanwuai@123');  
 flush privileges;

```

10、修改密码策略

mysql5.8默认安装了密码安全检查插件（validate_password），默认密码检查策略要求密码必须包含：大小写字母、数字和特殊符号，并且长度不能少于8位。否则会提示ERROR 1819 (HY000): Your
password does not satisfy the current policy requirements错误，如下图所示：

![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-linux/images/1.jpg)

```shell
#查看密码策略的相关信息
show variables like '%password%';
```

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

11.添加远程登录用户

```shell
GRANT ALL PRIVILEGES ON *.* TO 'jiac'@'%' IDENTIFIED BY 'jiac0917!' WITH GRANT OPTION;
```

12.配置默认编码为utf8

```shell
#修改/etc/my.cnf配置文件，在[mysqld]下添加编码配置，如下所示：
[mysqld]
character_set_server=utf8
init_connect='SET NAMES utf8'
```
13.开启端口访问

```shell
firewall-cmd --permanent --zone=public --add-port=3306/tcp
firewall-cmd --permanent --zone=public --add-port=3306/udp
```
14.开启远程登录

```shell
CREATE USER 'root'@'%' IDENTIFIED BY 'Xuanwuai@123';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
```

<p id ="redis">

## Redis

1、[到官网](https://github.com/MSOpenTech/redis/releases)下载redis安装包

```shell
$ wget http://download.redis.io/releases/redis-5.0.5.tar.gz
$ tar xzf redis-5.0.5.tar.gz
$ cd redis-5.0.5
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

```shell
docker run --restart=always -p 6379:6379 -v ~/data/redis/data:/data -v ~/conf/redis/redis.conf:/etc/redis/redis.conf --name myredis -d redis redis-server --appendonly yes

```



<p id ="nginx">

## nginx

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

<p id ="rabbit">

## RabbitMq

1、由于RabbitMQ依赖Erlang， 所以需要先安装Erlang

```shell
  wget https://packages.erlang-solutions.com/erlang-solutions-1.0-1.noarch.rpm
  rpm -Uvh erlang-solutions-1.0-1.noarch.rpm
  yum install erlang
```

2、安装

```shell
  wget http://www.rabbitmq.com/releases/rabbitmq-server/v3.6.6/rabbitmq-server-3.6.6-1.el7.noarch.rpm
  yum install rabbitmq-server-3.6.6-1.el7.noarch.rpm
```

3、启动

```shell
  rabbitmq-server start
```

4、开启web管理接口

```shell
rabbitmq-plugins enable rabbitmq_management
```

5、通过浏览器访问

```shell
  http://localhost:15672
```

  6、其他命令

  ```shell
sudo chkconfig rabbitmq-server on  # 添加开机启动RabbitMQ服务
/sbin/service rabbitmq-server start # 启动服务
/sbin/service rabbitmq-server status  # 查看服务状态
/sbin/service rabbitmq-server stop   # 停止服务

# 查看当前所有用户
rabbitmqctl list_users

# 查看默认guest用户的权限
rabbitmqctl list_user_permissions guest

# 由于RabbitMQ默认的账号用户名和密码都是guest。为了安全起见, 先删掉默认用户
rabbitmqctl delete_user guest

# 添加新用户
rabbitmqctl add_user username password

# 设置用户tag
rabbitmqctl set_user_tags username administrator

# 赋予用户默认vhost的全部操作权限
rabbitmqctl set_permissions -p / username ".*" ".*" ".*"

# 查看用户的权限
rabbitmqctl list_user_permissions username

  ```
  7、使用docker构建
 * 在docker官网查找docker镜像，https://hub.docker.com/

* 拉取镜像,我们选择带有“mangement”的版本（包含web管理页面）
```shell
  docker pull rabbitmq:3.7.12-management

  docker run --restart=always -d -p 5672:5672 -p 15672:15672 --name myrabbitmq df80af9ca0c9
```

<p id ="git">

## git

```shell
yum -y install git-core

git --version
```

<p id ="gitlab">

## gitlab

1、安装依赖

```shell
sudo yum install -y curl policycoreutils-python openssh-server
sudo systemctl enable sshd
sudo systemctl start sshd
sudo firewall-cmd --permanent --add-service=http
sudo systemctl reload firewalld


sudo yum install postfix
sudo systemctl enable postfix
sudo systemctl start postfix
```

2、下载源码并安装

```shell
curl https://packages.gitlab.com/install/repositories/gitlab/gitlab-ee/script.rpm.sh | sudo bash

sudo EXTERNAL_URL="http://192.168.11.231:9090" yum install -y gitlab-ee
```

3、修改gitlab配置文件指定服务器ip和自定义端口

```
vi  /etc/gitlab/gitlab.rb

external_url -> 服务器http://IP:端口
```

4、执行配置

```
gitlab-ctl reconfigure
```

5、启动：gitlab-ctl start 出现如下说明成功

```
ok: run: alertmanager: (pid 7324) 0s 
ok: run: gitaly: (pid 7334) 0s 
ok: run: gitlab-monitor: (pid 7355) 1s 
ok: run: gitlab-workhorse: (pid 7360) 0s 
ok: run: logrotate: (pid 7373) 1s 
ok: run: nginx: (pid 7416) 0s 
ok: run: node-exporter: (pid 7461) 0s 
ok: run: postgres-exporter: (pid 7467) 1s 
ok: run: postgresql: (pid 7473) 0s 
ok: run: prometheus: (pid 7481) 1s 
ok: run: redis: (pid 7492) 0s 
ok: run: redis-exporter: (pid 7496) 1s 
ok: run: sidekiq: (pid 7502) 0s 
ok: run: unicorn: (pid 7517) 0s
```

6、修改储存位置

```
sudo vi /etc/gitlab/gitlab.rb 
git_data_dirs -> 修改成目标位置 
sudo gitlab-ctl reconfigure 配置执行 
重新启动
```
<p id ="node">

## node

#### 1、编译安装

1、下载并解压

```shell
// 下载
wget http://nodejs.org/dist/v10.16.0/node-v10.16.0.tar.gz   
//解压
tar -zxvf node-v10.16.0.tar.gz -C /usr/local/   
```

   2、编译

```shell
./configure --prefix=/usr/local/node/v10.16.0 
```

报错 C++ compiler too old, need g++ 4.9.4 or clang++ 3.4.2 (CXX=g++)

```shell
//1、装bzip2解压工具
yum -y install bzip2
//2、下载gcc包
wget https://ftp.gnu.org/gnu/gcc/gcc-7.3.0/gcc-7.3.0.tar.gz
//3、安装依赖，自动下载可能会慢。建议手动下载，然后复制到安装目录下。需要下载以下四个包。下载地址：ftp://gcc.gnu.org/pub/gcc/infrastructure/
gmp-6.1.0.tar.bz2: 
mpfr-3.1.4.tar.bz2: 
mpc-1.0.3.tar.gz: 
isl-0.16.1.tar.bz2: 

./contrib/download_prerequisites

//3、建立编译输出目录

mkdir gcc-build-7.3.0
//4、进入下面目录，执行命令，生成Makefile文件

../gcc-7.3.0/configure --enable-checking=release --enable-languages=c,c++ --disable-multilib
//5、执行命令进行编译，此处利用4个job，需编译时约40分钟，此值不宜设置过高

make -j4

//6 编译完成之后，需要把原来的GCC卸载，换成7.3.0版本的
rpm -q gcc 
rpm -q gcc-c++

删除已经安装低版本 
rpm -e [包名] 
包名为上一步中显示的包，形如： 
gcc-4.8.5-16.el7_4.2.x86_64 
gcc-c++-4.8.5-16.el7_4.2.x86_64

那就删除吧 
rpm -e gcc-4.8.5-16.el7_4.2.x86_64 
rpm -e gcc-c++-4.8.5-16.el7_4.2.x86_64


//7、安装 
make install

//8、验证版本
which gcc 
/usr/local/bin/gcc -v

//9、添加环境变量
//1、直接用export命令： 
export PATH=$PATH:/usr/local/bin 
查看是否已经设好，可用命令export查看，或者直接echo $PATH

//2、这个应该更靠谱一点，要不然有时候sudo的时候会提示找不到gcc命令 
sudo ln -s /usr/local/bin/gcc /usr/bin/gcc 
(建立/usr/bin/gcc到编译安装gcc的软链接)
```

报错：

```
node: /usr/lib64/libstdc++.so.6: version `GLIBCXX_3.4.21' not found (required by node)
node: /usr/lib64/libstdc++.so.6: version `GLIBCXX_3.4.15' not found (required by node)
node: /usr/lib64/libstdc++.so.6: version `GLIBCXX_3.4.20' not found (required by node)
```

`gcc`的动态库还是旧版本的。说明出现这些问题，是因为升级`gcc`时，生成的动态库没有替换老版本`gcc`的动态库。

```shell
//1、执行以下命令，查找编译gcc时生成的最新动态库：
find / -name "libstdc++.so*"
...
/opt/software/gcc-build-7.3.0/prev-x86_64-pc-linux-gnu/libstdc++-v3/src/.libs/libstdc++.so.6.0.24
/opt/software/gcc-build-7.3.0/prev-x86_64-pc-linux-gnu/libstdc++-v3/src/.libs/libstdc++.so.6
/opt/software/gcc-build-7.3.0/prev-x86_64-pc-linux-gnu/libstdc++-v3/src/.libs/libstdc++.so
/opt/software/gcc-build-7.3.0/x86_64-pc-linux-gnu/libstdc++-v3/src/.libs/libstdc++.so.6.0.24
...

//2、将上面的最新动态库libstdc++.so.6.0.21复制到/usr/lib64目录下：

cp /opt/software/gcc-build-7.3.0/x86_64-pc-linux-gnu/libstdc++-v3/src/.libs/libstdc++.so.6.0.24 /usr/lib64

//3、复制后，修改系统默认动态库的指向，即：重建默认库的软连接。
cd /usr/lib64
rm -rf libstdc++.so.6
ln -s libstdc++.so.6.0.21 libstdc++.so.6
```

#### 2、淘宝镜像安装

```shell
.cd  /usr/loacl/node/  

wget https://npm.taobao.org/mirrors/node/v0.10.16/node-v0.10.16-linux-x64.tar.gz

tar -zxvf node-v0.10.16-linux-x64.tar.gz


ln -s /usr/local/node/node-v0.10.16-linux-x64/bin/npm /usr/local/bin/npm


ln -s /usr/local/node/node-v0.10.16-linux-x64/bin/node /usr/local/bin/node


npm -v
```

<p id ="yapi">

## yapi

1. 确保 node 版本=> 7.6,请运行 node -v 查看版本号
2. 确保 mongodb 版本 => 2.6，请运行 mongo --version 查看版本号
3. 确保安装了 npm, 运行 npm -v 查看版本号
4. 确保安装了 git,运行 git --version 查看版本号
5. 确保安装了 node-gyp 环境，[配置方法](https://github.com/nodejs/node-gyp#on-unix)

```shell
npm install -g yapi-cli --registry https://registry.npm.taobao.org
yapi server 
```

<p id ="mongodb">

## mongodb



```
wget https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-3.0.6.tgz


```

<p id ="docker">

## docker

<p id ="jenkins">

## Jenkins
![Jenkins](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/markdown/Jenkins.md)
