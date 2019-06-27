#  Nginx
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。
## nginx服务器基础配置
>   * [nginx.conf文件结构](#what)
>   * [全局块](#global)
>   * [events块](#events)
>   * [http全局块](#http)
>   * [server块](#server)
>   * [location块](#location)
>   * [实例](#example)

<p id="what">

#### nginx.conf文件结构

>  * 1.nginx.conf文件一共由三部分组成，分别为全局块，events块，http块。http块中又包含http全局块，多个server块。server块中，又包含server全局块和多个location块。在同一配置块中嵌套的配置快，各个之间不存在次序关系。
>  * 2.全局块是默认配置文件从开始到events块之间的一部分内容。主要设置一些影响nginx服务器整体运行的配置指令。全局生效。
>  * 3.events块涉及的指令主要影响Nginx服务器与用户的网络连接。对服务器性能影响比较大。
>  * 4.http块：代理，缓存和日志定义，第三方模块
>  * 5.server块：和虚拟主机有密切联系，可以包含多了location块
>  * 6.location块，location块其实是server块的一个指令。

<p id="global">

#### 全局块
>  * 配置运行nginx服务器的用户（组）
    
    语法：user  用户名;  （全局块）
>  * 允许生成的work process数。worker_processes是Nginx服务器实现并发处理服务的关键。

    语法：worker_processes number|auto;    （全局块）
>  * 配置全局的日志存放路径

    语法：error_log  file|stderr [debug|info|notice|warn|error|crit|alert|emery];（全局块，http块，server块，location块）
>  * nginx进程PID存放路径

    语法：pid file；（全局块）
>  * 完成其他nginx配置或者第三方模块的配置引入

     语法：include file;（任何地方）
     
<p id="events">

#### events块
>  * 设置网络连接的序列化
  
    语法：accept_mutex on|off;（events块）
>  * 设置是否允许同事接收多个网络连接
  
    语法：multi_accept on|off;（events块）
>  * 事件驱动模型的选择

    语法：use [select|poll|kqueue|epoll|rtsig|/dev/poll|eventport];（events块）
>  * 设置最大连接数，不能大于操作系统支持打开的最大文件句柄数量

    语法：worker_connections  number; （events块）

<p id="http">

#### http全局块
    
>  * 引入mime.types文件，里面定义了一个type结构，包含了浏览器能够识别的MIME类型及文件名后缀。

    语法：include       mime.types;
>  * 定义了处理前端请求的MIME类型。默认为text/plain。

    语法：default_type  application/octet-stream;（http块，server块，location块）
>  * 服务日志的配置，只能在http块配置

    语法：access_log path[format[buffer=size]]; （http块）
    path:存放路径。format：可选项，自定义服务日志的格式字符串，联合log_format使用; 
    log_format配置：
    语法：log_format name string...;
            ## $remote_addr：用户机Ip
            ## $remote_user：用户名
            ## $time_local：获取到本地时间
            ## $request：获取到请求
            ## $status：获取到请求状态
            ## $body_bytes_sent：获取到请求体的大小
            ## $http_referer：未获取到任何内容
            ## $http_user_agent：用户浏览器代理
            ## $http_x_forwarded_for：请求头
>  * 配置允许sendfile方式传输文件

    语法：sendfile on|off;（http块，server块，location块）
>  * 配置每次传输的数据量最大值

    语法：sendfile_max_chunk size;（http块，server块，location块）
>  * 超时时间

    语法：keepalive_timeout timeout[header_timeout];（http块，server块，location块）
          header_timeout可选，在应答报文头部的Keep-Alive域设置超时时间。
          keepalive_timeout  120s 100s;服务端保持120s，发给用户端的应答报文头部Keep-Alive域超时时间100s
>  * 配置单连接请求数上限
    
    语法：keepalive_requests number;（http块，server块，location块）

<p id="server">

#### server块   
>  * 配置网络监听
    
    1.配置监听ip
    语法：listen address[:port] [default_server] [setfid=number] [backlog=number] [rcvbuf=size] [sndbuf=size] [deferred] [accept_filter=filter] [bind] [ssl];
    
    2.配置监听端口
    语法：listen port [default_server] [setfid=number] [backlog=number] [rcvbuf=size] [sndbuf=size] [accept_filter=filter]  [deferred] [bind] [ipv6only=on|off] [ssl] ;
    
    3.配置UNIX Domain Socket
    语法：listen unix:path [default_server] [backlog=number] [rcvbuf=size] [sndbuf=size] [accept_filter=filter] [deferred] [bind] [ssl];
        
    address:ip地址，如果是ipv6地址，需要用中括号括起来
    port:端口号，默认80
    path:socket文件路径
    default_server:标识符，将此虚拟主机设置为address:port的默认主机
    setfid=number:监听socket关联路由表，目前只对FreeBSD起作用，不常用
    backlog=number:设置监听函数listen()最多允许多少网络连接同时处于挂起状态，FreeBSD默认-1，其他511
    rcvbuf=size:设置监听socket接受缓存区大小
    sndbuf=size:设置监听socket发生缓存区大小
    deferred:标识符，将accept()设置为Deferred模式
    accept_filter=filter:设置监听端口对请求过滤，被过滤的内容不能被接受和处理。
    bind:标识符，使用独立的bind()处理此address:port
    ssl:标识符，设置会话连接使用sll模式进行
    listen *:80|*:8000;监听所有的80和8000端口
    listen 192.168.1.10:8000;监听具体的ip和具体的端口上的连接
    listen 192.168.1.10;监听具体ip的所有端口的连接
    listen 8000;监听具体端口上的所有ip连接
    listen 192.168.1.10 default_server back_log=1024;设置192.168.1.10的连接请求默认由此虚拟主机处理，并且允许最多1024网络连接处于挂起状态。
    
    
>  * 基于名称的虚拟主机配置
    
    语法：server_name name...;
            name可以设置多个，以第一个为主，可以使用通配符，但只能用在三段字符串组成的首部或者尾部，可以使用正则表达式
>  * 基于ip的虚拟主机配置
 
    语法：server_name ip;
    
<p id="location">

#### location块

>  * 前缀
    
    语法：location [ = | ~ | ~* |^~] uri{...}
            =:用于标准uri之前，要求严格匹配
            ~：用户表示uri包含表达式，并且区分大小写
            ~*：用户表示uri包含表达式，并且不区分大小写
            ^~：用于表示uri和请求字符串匹配度最高的location后，立即使用此location处理请求
>  * 根目录

    语法：root path;
>  * 更改location的URI

    语法：alias path;
>  * 设置网站默认首页

    语法：index file...;
>  * 设置网站错误页面

    语法：error_page code ... [=[response]] uri;
>  * 基于IP配置nginx的访问权限

    这两个指令可以在http块，server块或者location块中使用
    语法：allow address | CIDR |all 
    
    语法：deny address | CIDR | all
>  * 基于密码配置nginx的访问权限

    语法：auth_basic string | off
    string:开启该认证功能，并配置验证时的指示信息
    语法：auth_basic_user_file file
    file为密码文件的绝对路径
    
    加密密码可以使用crypt()函数进行密码加密的格式，在linux下可以使用htpasswd命令生成
    
        htpasswd -c -d /uer/local/nginx/conf/pass_file
        
        auth_basic ***
        auth_basic_user_file /uer/local/nginx/conf/pass_file

<p id="example">

#### 实例

    ############### 全局块开始 ###############
    
    
    ## 配置允许运行nginx的服务器的用户和用户组
    user  nobody nobody;  
    
    ## 配置运行nginx进程生成的worker_processes数
    worker_processes  1;
    
    ## 配置nginx服务器运行对错误日志存放路径
    error_log  logs/error.log;
    
    ## 配置nginx服务器运行时的PID文件存放路径
    pid        logs/nginx.pid;
    
    
    ############### 全局块结束 ###############
    
    
    ############### events块开始 ###############
    
    events {
        # 配置事件驱动模型
        use epoll
        
        # 配置最大连接数
        worker_connections  1024; 
    }
    
    ############### events块结束 ###############
    
    ############### http块开始 ###############
    
    http {
    
        ## 定义MIME-Type
        include       mime.types;
        default_type  application/octet-stream;
        
        ## 配置请求处理日志格式
        log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                          '$status $body_bytes_sent "$http_referer" '
                          '"$http_user_agent" "$http_x_forwarded_for"';
    
        access_log  logs/access.log  main;
        
        ## 配置允许使用sendfile方式传输
        sendfile        on;
        #tcp_nopush     on;
        
        ## 配置连接超时时间
        keepalive_timeout  65;
        
        #gzip  on;
        
        ############### server块开始 ###############
        
        ## 配置虚拟主机myserver1
        server {
            ## 配置监听端口和主机名称（基于名称）
            listen       8081;
            server_name  myserver1;
            ## 配置请求处理日志存放路径
            access_log  logs/myweb/server1.log;;
            ## 配置网站错误页面
            error_page  404              /404.html;
            
            ## 配置处理server1/location1请求的location
            location /server1/location1 {
                root   /myweb;
                index  index-svr1-loc1.html index-svr1-loc1.htm;
            }
            
            ## 配置处理server2/location2请求的location
         
            location /server2/location2 {
                    root   /myweb;
                    index  index-svr1-loc2.html index-svr1-loc2.htm;
            }
        }    
         
         ## 配置虚拟主机myserver2
         server {
             ## 配置监听端口和主机名称（基于名称）
             listen       8082;
             server_name  192.168.1.3;
             
             ## 配置请求处理日志存放路径
             access_log  logs/myweb/server2.log;
             
             ## 配置网站错误页面,对错误页面进行重定向。见下面配置
             error_page  404              /404.html;
             
             ## 配置处理server2/location1请求的location
             location /server1/location1 {
                 root   /myweb;
                 index  index-svr2-loc1.html index-svr2-loc1.htm;
             }
             
             ## 配置处理server2/location2请求的location
             location /svr2/loc2 {
                     ## 对location的URI进行更改
                     alias  /myweb/server2/location2/;
                     index  index-svr2-loc2.html index-svr2-loc2.htm;
             }
             
              location = /404.html {
                      ## 对location的URI进行更改
                      root  /myweb/;
                      index  404.html;
              }                
         }  
        ############### server块结束 ###############
    }
    ############### http块开始 ###############
    
> 在该实例中，配置了两个虚拟主机myserver1和myserver2，前者基于名称的，后者基于ip的。在每个虚拟
> 主机里，又使用了不同的location块对不同的请求处理。主机myserver2除了对一般的请求进行处理外
> 还对错误页面404.html做了定向配置。