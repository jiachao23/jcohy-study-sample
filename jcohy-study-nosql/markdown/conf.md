#  Redis
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。
>  Ps:在学习Redis之前，先简单介绍一些关于NoSql相关的知识。
## Redis配置文件(redis.conf)
> * [Units单位](#units)
> * [include](#include)
> * [General](#general)
> * [SNAPSHOTTING](#snapshotting)
> * [REPLICATION](#replication)
> * [SECURITY](#security)
> * [LIMITS](#limits)
> * [APPEND ONLY MODE](#appendonlymode)





<p id = "units">

##  units单位

>  配置大小单位，开头定义了一些基本的度量文件，只支持bytes，不支持bit
>  对大小写不敏感

<p id="include">

##  include

>  包含其他的配置文件。redis.conf相当与一个总闸。

<p id ="general">

##  General

>  *  daemonize no      守护进程，默认关闭
>  *  pidfile /var/run/redis.pid        进程管道id文件
>  *  port 6379     端口号
>  *  tcp-backlog 511
>  设置tcp的backlog，backlog是一个连接队列，backlog队列总和=未完成三次握手连接队列+已完成三次握手连接队列。在高并发环境下需要设置一个高backlog值来避免慢客户端连接问题。
>  Linux内核会将这个值减小到/proc/sys/net/core/somaxconn的值，所以需要增大somaxconn和tcp_max_syn_backlog的值来达到效果。
>  *  timeout 0     
>  *  tcp-keepalive 0   单位为秒，如果设置为0，则不会进行Keepalive检测，建议设置成60 
>  *  loglevel notice
>  *  logfile ""
>  *  syslog-enabled: 是否把日志输出到syslog中
>  *  syslog-ident:指定syslog里的日志标志
>  *  syslog-facility:指定syslog设备，值可以是USER或LOCAL0-LOCAL7
>  *  databases 16  默认数据库有16个

<p id ="snapshotting">

##  SNAPSHOTTING

>  *  save 900 1
      save 300 10
      save 60 10000      
>  RDB是整个内存的压缩过的Snapshot，RDB的数据结构，可以配置复合的快照触发条件，默认
   是1分钟内改了1万次，</br>
   或5分钟内改了10次，</br>
   或15分钟内改了1次。</br>
   >  如果想禁用RDB持久化的策略，只要不设置任何save指令，或者给save传入一个空字符串参数也可以
   
>  *  stop-writes-on-bgsave-error yes
>  如果配置成no，表示你不在乎数据不一致或者有其他的手段发现和控制

>  *  rdbcompression yes
>  rdbcompression：对于存储到磁盘中的快照，可以设置是否进行压缩存储。如果是的话，redis会采用
   LZF算法进行压缩。如果你不想消耗CPU来进行压缩的话，可以设置为关闭此功能。
   
>  *  rdbchecksum yes
>  rdbchecksum：在存储快照后，还可以让redis使用CRC64算法来进行数据校验，但是这样做会增加大约
   10%的性能消耗，如果希望获取到最大的性能提升，可以关闭此功能。
   
>  *  dbfilename dump.rdb
>  *  dir ./  :  当前路径

<p id ="replication">

##  REPLICATION

>  *  slave-serve-stale-data yes
>  *  slave-read-only yes
>  *  repl-diskless-sync no
>  *  repl-diskless-sync-delay 5
>  *  repl-disable-tcp-nodelay no
>  *  slave-priority 100


<p id ="security">

##  SECURITY

>  *  访问密码的查看、设置和取消

>  在客户端输入  config set requirepass "password"</br>
>  设置后，在操作前输入 auth password

<p id ="limits">

##  LIMITS

>  * maxclients 
>  设置redis同时可以与多少个客户端进行连接。默认情况下为10000个客户端。当你
   无法设置进程文件句柄限制时，redis会设置为当前的文件句柄限制值减去32，因为redis会为自
   身内部处理逻辑留一些句柄出来。如果达到了此限制，redis则会拒绝新的连接请求，并且向这
   些连接请求方发出“max number of clients reached”以作回应。
   
>  *  maxmemory
>  设置redis可以使用的内存量。一旦到达内存使用上限，redis将会试图移除内部数据，移除规则可以通过maxmemory-policy来指定。如果redis无法根据移除规则来移除内存中的数据，或者设置了“不允许移除”，
那么redis则会针对那些需要申请内存的指令返回错误信息，比如SET、LPUSH等。</br>
但是对于无内存申请的指令，仍然会正常响应，比如GET等。如果你的redis是主redis（说明你的redis有从redis），那么在设置内存使用上限时，需要在系统中留出一些内存空间给同步队列缓存，只有在你设置的是“不移除”的情况下，才不用考虑这个因素。

>  *  maxmemory-policy
>    *  volatile-lru -> 使用LRU算法移除key，只对设置了过期时间的键
>    *  allkeys-lru -> 使用LRU算法移除key
>    *  volatile-random -> 在过期集合中移除随机的key，只对设置了过期时间的键
>    *  allkeys-random -> 移除随机的key
>    *  volatile-ttl -> 移除那些TTL值最小的key，即那些最近要过期的key
>    *  noeviction -> 不进行移除。针对写操作，只是返回错误信息

>  *  maxmemory-samples
>  设置样本数量，LRU算法和最小TTL算法都并非是精确的算法，而是估算值，所以你可以设置样本的大小，
     redis默认会检查这么多个key并选择其中LRU的那个。
     
<p id ="appendonlymode">     

##  APPEND ONLY MODE

>  *  appendonly no

>  
>  *  appendfilename "appendonly.aof"
>  *  appendfsync everysec

>    *  always：同步持久化 每次发生数据变更会被立即记录到磁盘  性能较差但数据完整性比较好
>    *  everysec：出厂默认推荐，异步操作，每秒记录   如果一秒内宕机，有数据丢失
>    *  no
>  *  no-appendfsync-on-rewrite no
>  重写时是否可以运用Appendfsync，用默认no即可，保证数据安全性。

>  *  auto-aof-rewrite-percentage 100
      auto-aof-rewrite-min-size 64mb
>  设置重写的基准值      
      
>  *  aof-load-truncated yes


<p id ="snapshotting">

##  常见参数说明


redis.conf 配置项说明如下：
>  1.  Redis默认不是以守护进程的方式运行，可以通过该配置项修改，使用yes启用守护进程</br>

>  daemonize no</br>
>  2.  当Redis以守护进程方式运行时，Redis默认会把pid写入/var/run/redis.pid文件，可以通过pidfile指定</br>

>  pidfile /var/run/redis.pid</br>
>  3. 指定Redis监听端口，默认端口为6379，作者在自己的一篇博文中解释了为什么选用6379作为默认端口，因为6379在手机按键上MERZ对应的号码，而MERZ取自意大利歌女Alessia Merz的名字</br>

>  port 6379</br>
>  4.  绑定的主机地址</br>

>  bind 127.0.0.1</br>
>  5.  当 客户端闲置多长时间后关闭连接，如果指定为0，表示关闭该功能</br>

>  timeout 300</br>
>  6.  指定日志记录级别，Redis总共支持四个级别：debug、verbose、notice、warning，默认为verbose</br>

>  loglevel verbose</br>
>  7.  日志记录方式，默认为标准输出，如果配置Redis为守护进程方式运行，而这里又配置为日志记录方式为标准输出，则日志将会发送给/dev/null</br>

>  logfile stdout</br>
>  8.  设置数据库的数量，默认数据库为0，可以使用SELECT <dbid>命令在连接上指定数据库id</br>

>  databases 16</br>
>  9.  指定在多长时间内，有多少次更新操作，就将数据同步到数据文件，可以多个条件配合</br>

>  save <seconds> <changes></br>
>  Redis默认配置文件中提供了三个条件：</br>
>  save 900 1</br>
>  save 300 10</br>
>  save 60 10000</br>
  分别表示900秒（15分钟）内有1个更改，300秒（5分钟）内有10个更改以及60秒内有10000个更改。</br>
 
>  10.  指定存储至本地数据库时是否压缩数据，默认为yes，Redis采用LZF压缩，如果为了节省CPU时间，可以关闭该选项，但会导致数据库文件变的巨大</br>

>  rdbcompression yes</br>
>  11.  指定本地数据库文件名，默认值为dump.rdb</br>

>  dbfilename dump.rdb</br>
>  12.  指定本地数据库存放目录</br>

>  dir ./</br>
>  13.  设置当本机为slav服务时，设置master服务的IP地址及端口，在Redis启动时，它会自动从master进行数据同步</br>

>  slaveof <masterip> <masterport></br>
>  14.  当master服务设置了密码保护时，slav服务连接master的密码</br>

>  masterauth <master-password></br>
>  15.  设置Redis连接密码，如果配置了连接密码，客户端在连接Redis时需要通过AUTH <password>命令提供密码，默认关闭</br>

>  requirepass foobared</br>
>  16.  设置同一时间最大客户端连接数，默认无限制，Redis可以同时打开的客户端连接数为Redis进程可以打开的最大文件描述符数，如果设置 maxclients 0，表示不作限制。当客户端连接数到达限制时，Redis会关闭新的连接并向客户端返回max number of clients reached错误信息</br>

>  maxclients 128</br>
>  17.  指定Redis最大内存限制，Redis在启动时会把数据加载到内存中，达到最大内存后，Redis会先尝试清除已到期或即将到期的Key，当此方法处理 后，仍然到达最大内存设置，将无法再进行写入操作，但仍然可以进行读取操作。Redis新的vm机制，会把Key存放内存，Value会存放在swap区</br>

>  maxmemory <bytes></br>
>  18.  指定是否在每次更新操作后进行日志记录，Redis在默认情况下是异步的把数据写入磁盘，如果不开启，可能会在断电时导致一段时间内的数据丢失。因为 redis本身同步数据文件是按上面save条件来同步的，所以有的数据会在一段时间内只存在于内存中。默认为no</br>

>  appendonly no</br>
>  19.  指定更新日志文件名，默认为appendonly.aof</br>

>   appendfilename appendonly.aof</br>
>  20.  指定更新日志条件，共有3个可选值： </br>

>  no：表示等操作系统进行数据缓存同步到磁盘（快） </br>
>  always：表示每次更新操作后手动调用fsync()将数据写到磁盘（慢，安全） </br>
>  everysec：表示每秒同步一次（折衷，默认值）</br>
>  appendfsync everysec</br>
 
>  21.  指定是否启用虚拟内存机制，默认值为no，简单的介绍一下，VM机制将数据分页存放，由Redis将访问量较少的页即冷数据swap到磁盘上，访问多的页面由磁盘自动换出到内存中（在后面的文章我会仔细分析Redis的VM机制）</br>

>   vm-enabled no</br>
>  22.  虚拟内存文件路径，默认值为/tmp/redis.swap，不可多个Redis实例共享</br>

>   vm-swap-file /tmp/redis.swap</br>
>  23.  将所有大于vm-max-memory的数据存入虚拟内存,无论vm-max-memory设置多小,所有索引数据都是内存存储的(Redis的索引数据 就是keys),也就是说,当vm-max-memory设置为0的时候,其实是所有value都存在于磁盘。默认值为0</br>

>   vm-max-memory 0</br>
>  24.  Redis swap文件分成了很多的page，一个对象可以保存在多个page上面，但一个page上不能被多个对象共享，vm-page-size是要根据存储的 数据大小来设定的，作者建议如果存储很多小对象，page大小最好设置为32或者64bytes；如果存储很大大对象，则可以使用更大的page，如果不 确定，就使用默认值</br>

>   vm-page-size 32</br>
>  25.  设置swap文件中的page数量，由于页表（一种表示页面空闲或使用的bitmap）是在放在内存中的，，在磁盘上每8个pages将消耗1byte的内存。</br>

>   vm-pages 134217728</br>
>  26.  设置访问swap文件的线程数,最好不要超过机器的核数,如果设置为0,那么所有对swap文件的操作都是串行的，可能会造成比较长时间的延迟。默认值为4</br>

>   vm-max-threads 4</br>
>  27.  设置在向客户端应答时，是否把较小的包合并为一个包发送，默认为开启</br>

>  glueoutputbuf yes</br>
>  28.  指定在超过一定的数量或者最大的元素超过某一临界值时，采用一种特殊的哈希算法</br>

>  hash-max-zipmap-entries 64</br>
>  hash-max-zipmap-value 512</br>
>  29.  指定是否激活重置哈希，默认为开启（后面在介绍Redis的哈希算法时具体介绍）</br>

>  activerehashing yes</br>
>  30.  指定包含其它的配置文件，可以在同一主机上多个Redis实例之间使用同一份配置文件，而同时各个实例又拥有自己的特定配置文件</br>

>  include /path/to/local.conf</br>