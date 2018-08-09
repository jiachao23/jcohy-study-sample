#### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	
> #### PS:待开发中。。。。

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

> #### PS:我的学习笔记,点击可以跳转到相应分类

##  Linux常用命令

>  *  [Linux常用命令](#changyong)
>  *  [Linux系统命令](#xitong)
>  *  [用户和组](#user)
>  *  [权限](#quanxian)
>  *  [文件夹属性](#wenjianjia)
>  *  [vim](#vim)
>  *  [安装软件](#ruanjian)
>  *  [查找](#chazhao)
>  *  [查找打包与压缩](#dabao)
>  *  [正则表达式](#zhengze)
>  *  [输入输出重定向和管道](#shuru)
>  *  [进程控制](#jincheng)
<p id="changyong">

##  Linux文件相关命令

>  *  快捷键：
        ctrl + c：停止进程
        
        ctrl + l：清屏
        
        ctrl + r：搜索历史命令
        
        ctrl + q：退出
>  *  进入到用户根目录

        cd ~ 或者 cd 

>  *  回到原来路径

        cd -
>  *  查看当前所在目录
       
        pwd
>  *  返回到上一级目录

        cd ..
>  *  查看itcast用户根目录下的所有文件

        ls -la
>  *  查看文件详情

        stat a.txt
>  *  移动
    
        mv a.txt /ect/
            
        改名
        mv b.txt a.txt
        
        移动并改名
        mv a.txt ../b.txt

        拷贝并改名
        cp a.txt /etc/b.txt

>  *  vi撤销修改
        
        ctrl + u (undo)
        恢复
        ctrl + r (redo)
>  *  向README文件追加写入"please read me first"
  
        echo "please read me first" >> README
>  *  名令设置别名(重启后无效)

        alias ll="ls -l"
        取消
        unalias ll
>  *  如果想让别名重启后仍然有效需要修改

        vi ~/.bashrc
>  *  添加用户

        useradd hadoop
        passwd hadoop

>  *  创建多个文件

        touch a.txt b.txt
        touch /home/{a.txt,b.txt}
>  *  将一个文件的内容复制到里另一个文件中

        cat a.txt > b.txt
        追加内容
        cat a.txt >> b.txt 
>  *  将a.txt 与b.txt设为其拥有者和其所属同一个组者可写入，但其他以外的人则不可写入:

        chmod ug+w,o-w a.txt b.txt
        chmod a=wx c.txt

>  *  将当前目录下的所有文件与子目录皆设为任何人可读取:

        chmod -R a+r *
>  *  将a.txt的用户拥有者设为users,组的拥有者设为jessie:

        chown users:jessie a.txt

>  *  将当前目录下的所有文件与子目录的用户的使用者为lamport,组拥有者皆设为users，
        
        chown -R lamport:users *

>  *  将所有的java语言程式拷贝至finished子目录中:

        cp *.java finished

>  *  将目前目录及其子目录下所有扩展名是java的文件列出来。

        find -name "*.java"
        查找当前目录下扩展名是java 的文件
        find -name *.java

>  *  删除当前目录下扩展名是java的文件

        rm -f *.java
<p id="xitong">

## 系统命令

>  *  查看主机名

        hostname
>  *  修改主机名(重启后无效)

        hostname hadoop
>  *  修改主机名(重启后永久生效)

        vi /ect/sysconfig/network
>  *  修改IP(重启后无效)

        ifconfig eth0 192.168.12.22
>  *  修改IP(重启后永久生效)

        vi /etc/sysconfig/network-scripts/ifcfg-eth0
>  *  查看系统信息

        uname -a
        uname -r
>  *  查看ID命令
    
        id -u
        id -g

>  *  日期

        date
        date +%Y-%m-%d
        date +%T
        date +%Y-%m-%d" "%T
>  *  日历

        cal 2012
>  *  查看文件信息

        file filename
>  *  挂载硬盘

        mount
        umount
        加载windows共享
        mount -t cifs //192.168.1.100/tools /mnt
>  *  查看文件大小

        du -h
        du -ah
>  *  查看分区

        df -h
>  *  ssh

        ssh hadoop@192.168.1.1
>  *  关机

        shutdown -h now /init 0
        shutdown -r now /reboot
 <p id="user">
        
##  用户和组

>  *  添加一个tom用户，设置它属于users组，并添加注释信息
        
        分步完成：useradd tom
                usermod -g users tom
	            usermod -c "hr tom" tom
        一步完成：useradd -g users -c "hr tom" tom

>  *  设置tom用户的密码

        passwd tom

        修改tom用户的登陆名为tomcat
        usermod -l tomcat tom
>  *  将tomcat添加到sys和root组中

        usermod -G sys,root tomcat

        查看tomcat的组信息
        groups tomcat
>  *  添加一个jerry用户并设置密码

        useradd jerry
        passwd jerry

>  *  添加一个交america的组

        groupadd america
>  *  将jerry添加到america组中
      
        usermod -g america jerry
>  *  将tomcat用户从root组和sys组删除

        gpasswd -d tomcat root
        gpasswd -d tomcat sys

>  *  将america组名修改为am

        groupmod -n am america
<p id="quanxian">

##  权限

>  *  创建a.txt和b.txt文件，将他们设为其拥有者和所在组可写入，但其他以外的人则不可写入:

        chmod ug+w,o-w a.txt b.txt
>  *  创建c.txt文件所有人都可以写和执行

        chmod a=wx c.txt 或chmod 666 c.txt
>  *  将/itcast目录下的所有文件与子目录皆设为任何人可读取

        chmod -R a+r /itcast

>  *  将/itcast目录下的所有文件与子目录的拥有者设为root，用户拥有组为users

        chown -R root:users /itcast
>  *  将当前目录下的所有文件与子目录的用户皆设为itcast，组设为users

        chown -R itcast:users *
<p id="wenjianjia">

##  文件夹属性

>  *  查看文件夹属性

        ls -ld test

>  *  文件夹的rwx

        --x:可以cd进去
        r-x:可以cd进去并ls
        -wx:可以cd进去并touch，rm自己的文件，并且可以vi其他用户的文件
        -wt:可以cd进去并touch，rm自己的文件

>  *  ls -ld /tmp

        drwxrwxrwt的权限值是1777(sticky)
<p id="vim">

## Vim

        i
        a/A
        o/O
        r + ?替换
        
        0:文件当前行的开头
        $:文件当前行的末尾
        G:文件的最后一行开头
        1 + G到第一行 
        9 + G到第九行 = :9
        
        dd:删除一行
        3dd：删除3行
        yy:复制一行
        3yy:复制3行
        p:粘贴
        u:undo
        ctrl + r:redo
        
        "a剪切板a
        "b剪切板b
        
        "ap粘贴剪切板a的内容
        
        每次进入vi就有行号
        vi ~/.vimrc
        set nu
        
        :w a.txt另存为
        :w >> a.txt内容追加到a.txt
        
        :e!恢复到最初状态
        
        :1,$s/hadoop/root/g 将第一行到追后一行的hadoop替换为root
        :1,$s/hadoop/root/c 将第一行到追后一行的hadoop替换为root(有提示)
<p id="ruanjian">

##  安装软件

<p id="chazhao">

##  查找
>  *  查找可执行的命令：

        which ls
>  *  查找可执行的命令和帮助的位置：
    
        whereis ls
>  *  查找文件(需要更新库:updatedb)

        locate hadoop.txt

>  *  从某个文件夹开始查找

        find / -name "hadooop*"
        find / -name "hadooop*" -ls

>  *  查找并删除

        find / -name "hadooop*" -ok rm {} \;
        find / -name "hadooop*" -exec rm {} \;

>  *  查找用户为hadoop的文件

        find /usr -user hadoop -ls

>  *  查找用户为hadoop并且(-a)拥有组为root的文件

        find /usr -user hadoop -a -group root -ls

>  *  查找用户为hadoop或者(-o)拥有组为root并且是文件夹类型的文件

        find /usr -user hadoop -o -group root -a -type d

>  *  查找权限为777的文件

        find / -perm -777 -type d -ls

>  *  显示命令历史

        history

>  *  grep

        grep hadoop /etc/password
<p id="dabao">

##  打包与压缩

>  *  gzip压缩
    
        gzip a.txt
>  *  解压

        gunzip a.txt.gz
        gzip -d a.txt.gz
>  *  bzip2压缩

        bzip2 a
>  *  解压
       
        bunzip2 a.bz2
        bzip2 -d a.bz2
>  *  将当前目录的文件打包

        tar -cvf bak.tar .
        将/etc/password追加文件到bak.tar中(r)
        tar -rvf bak.tar /etc/password
>  *  解压

        tar -xvf bak.tar
>  *  打包并压缩gzip

        tar -zcvf a.tar.gz
>  *  解压缩

        tar -zxvf a.tar.gz
        解压到/usr/下
        tar -zxvf a.tar.gz -C /usr
>  *  查看压缩包内容

        tar -ztvf a.tar.gz

        zip/unzip
>  *  打包并压缩成bz2

        tar -jcvf a.tar.bz2

>  *  解压bz2

        tar -jxvf a.tar.bz2
<p id="zhengze">
 
##  正则表达式

>  *  cut截取以:分割保留第七段

        grep hadoop /etc/passwd | cut -d: -f7
>  *  排序

        du | sort -n 
>  *  查询不包含hadoop的

        grep -v hadoop /etc/passwd
>  *  正则表达包含hadoop

        grep 'hadoop' /etc/passwd
>  *  正则表达(点代表任意一个字符)

        grep 'h.*p' /etc/passwd
>  *  正则表达以hadoop开头

        grep '^hadoop' /etc/passwd
>  *  正则表达以hadoop结尾
        
        grep 'hadoop$' /etc/passwd
        
        规则：
        .  : 任意一个字符
        a* : 任意多个a(零个或多个a)
        a? : 零个或一个a
        a+ : 一个或多个a
        .* : 任意多个任意字符
        \. : 转义.
        \<h.*p\> ：以h开头，p结尾的一个单词
        o\{2\} : o重复两次
        
        grep '^i.\{18\}n$' /usr/share/dict/words
        
        查找不是以#开头的行
        grep -v '^#' a.txt | grep -v '^$' 
        
        以h或r开头的
        grep '^[hr]' /etc/passwd
        
        不是以h和r开头的
        grep '^[^hr]' /etc/passwd
        
        不是以h到r开头的
        grep '^[^h-r]' /etc/passwd
<p id="shuru">

##  输入输出以及管道
>  *  新建一个文件

        touch a.txt
         b.txt
>  *  错误重定向:2>

        find /etc -name zhaoxing.txt 2> error.txt
>  *  将正确或错误的信息都输入到log.txt中

        find /etc -name passwd > /tmp/log.txt 2>&1 
        find /etc -name passwd &> /tmp/log.txt
>  *  追加>>

>  *  将小写转为大写（输入重定向）

        tr "a-z" "A-Z" < /etc/passwd
>  *  自动创建文件

        cat > log.txt << EXIT
        > ccc
        > ddd
        > EXI
>  *  查看/etc下的文件有多少个？

        ls -l /etc/ | grep '^d' | wc -l
>  *  查看/etc下的文件有多少个，并将文件详情输入到result.txt中

        ls -l /etc/ | grep '^d' | tee result.txt | wc -l
 <p id="jincheng">
 
##  进程控制

>  *  查看用户最近登录情况

        last
        lastlog
>  *  查看硬盘使用情况
        
        df
>  *  查看文件大小
        
        du
>  *  查看内存使用情况
        
        free
>  *  查看文件系统
        
        /proc
>  *  查看日志
        
        ls /var/log/
>  *  查看系统报错日志
        
        tail /var/log/messages
>  *  查看进程
        
        top
>  *  结束进程

        kill 1234
        kill -9 4333