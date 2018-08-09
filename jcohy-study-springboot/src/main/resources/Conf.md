#### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	
> #### PS:待开发中。。。。

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

> #### PS:我的学习笔记,点击可以跳转到相应分类

## SpringBoot的常用配置
  * [flyway](#flyway)
  * [liquibase](#liquibase)
  * [multipart](#multipart)
  * [security](#security)
  * [server](#server)
  * [activemq](#activemq)
  * [aop](#aop)
  * [application](#application)
  * [artemis](#artemis)
  * [batch](#batch)
  * [cache](#cache)
  * [elasticsearch](#elasticsearch)
  * [mongodb](#mongodb)
  * [rest](#rest)
  * [solr](#solr)      
  * [datasource](#datasource)   
  * [freemarker](#freemarker) 
  * [groovy](#groovy) 
  * [h2](#h2) 
  * [hornetq](#hornetq) 
  * [http](#http) 
  * [jackson](#jackson) 
  * [jersey](#jersey) 
  * [jms](#jms) 
  * [jmx](#jmx) 
  * [jpa](#jpa) 
  * [jta](#jta) 
  * [mail](#mail) 
  * [messages](#messages) 
  * [mobile](#mobile) 
  * [mongodb](#mongodb) 
  * [mustache](#mustache) 
  * [mvc](#mvc) 
  * [rabbitmq](#rabbitmq) 
  * [redis](#redis) 
  * [resources](#resources) 
  * [sendgrid](#sendgrid) 
  * [social](#social) 
  * [thymeleaf](#thymeleaf) 
  * [velocity](#velocity) 
  * [view](#view) 

  
 <p id= "flyway">
                
> *  flyway
>    *  flyway.baseline-description </br>
>     执行基线时标记已有Schema的描述。
>    *  flyway.baseline-on-migrate</br>
>     在没有元数据表的情况下，针对非空Schema执行迁移时是否自动调用基线。（默认值：false 。）
>    *  flyway.baseline-version</br>
>     执行基线时用来标记已有Schema的版本。（默认值： 1 。）
>    *  flyway.check-location</br>
>     检查迁移脚本所在的位置是否存在。（默认值： false 。）
>    *  flyway.clean-on-validation-error</br>
>     在验证错误时，是否自动执行清理。（默认值： false 。）
>    *  flyway.enabled</br>
>     开启Flyway。（默认值： true 。）
>    *  flyway.encoding</br>
>     设置SQL迁移文件的编码。（默认值： UTF-8 。）
>    *  flyway.ignore-failed-future-migration</br>
>     在读元数据表时，是否忽略失败的后续迁移。（默认值： false 。）
>    *  flyway.init-sqls</br>
>     获取连接后立即执行初始化的SQL语句。
>    *  flyway.locations</br>
>     迁移脚本的位置。（默认值： db/migration 。）
>    *  flyway.out-of-order</br>
>     是否允许乱序（out of order）迁移。（默认值： false 。）
>    *  flyway.password</br>
>     待迁移数据库的登录密码。
>    *  flyway.placeholder-prefix</br>
>     设置每个占位符的前缀。（默认值： ${ 。）
>    *  flyway.placeholder-replacement</br>
>     是否要替换占位符。（默认值： true 。）
>    *  flyway.placeholder-suffix</br>
>     设置占位符的后缀。（默认值： } 。）
>    *  flyway.placeholders.[placeholder name]</br>
>     设置占位符的值。
>    *  flyway.schemas</br>
>     Flyway管理的Schema列表，区分大小写。默认连接对应的默认Schema。 
>    *  flyway.sql-migration-prefix</br>
>     SQL迁移的文件名前缀。（默认值： V 。） 
>    *  flyway.sql-migration-separator</br>
>     SQL迁移的文件名分隔符。（默认值： __ 。）
>    *  flyway.sql-migration-suffix</br>
>     SQL迁移的文件名后缀。（默认值： .sql 。）
>    *  flyway.table</br>
>     Flyway使用的Schema元数据表名称。（默认值： schema_version 。）
>    *  flyway.target</br>
>     Flyway要迁移到的目标版本号。（默认最新版本。）
>    *  flyway.url</br>
>     待迁移的数据库的JDBC URL。如果没有设置，就使用配置的主数据源。
>    *  flyway.user</br>
>     待迁移数据库的登录用户。
>    *  flyway.validate-on-migrate</br>
>     在运行迁移时是否要自动验证。（默认值： true 。）


 <p id= "liquibase">
               
> *  liquibase
>    *  liquibase.change-log</br>
>     变更日志配置路径。（默认值： classpath:/db/changelog/db.changelog-master.yaml 。）
>    *  liquibase.check-change-log-location</br>
>     检查变更日志位置是否存在。（默认值： true 。）
>    *  liquibase.contexts</br>
>     要使用的运行时上下文列表，用逗号分隔。
>    *  liquibase.default-schema</br>
>     默认的数据库Schema。
>    *  liquibase.drop-first</br>
>     先删除数据库Schema。（默认值： false 。
>    *    liquibase.enabled</br>
>     开启Liquibase支持。（默认值： true 。）
>    *  liquibase.password</br>
>     待迁移数据库的登录密码。
>    *  liquibase.url</br>
>     待迁移数据库的JDBC URL。如果没有设置，就使用配置的主数据源。
>    *  liquibase.user</br>
>     待迁移数据库的登录用户。

 <p id= "multipart"> 
                
> *  multipart
>    *  multipart.enabled</br>
>     开启分段（multi-part）上传支持。（默认值： true 。）
>    *  multipart.file-size-threshold</br>
>     大于该阈值的文件会写到磁盘上。这里的值可以使用 MB 或 KB 后缀来表明是兆字节还是千字节。（默认值： 0 。）
>    *  multipart.location</br>
>     上传文件的中间存放位置。
>    *  multipart.max-file-size</br>
>     最大文件大小。这里的值可以使用 MB 或 KB 后缀来表明是兆字节还是千字节。（默认值：1MB 。）
>    *  multipart.max-request-size</br>
>     最大请求大小。这里的值可以使用 MB 或 KB 后缀来表明是兆字节还是千字节。（默认值：10MB 。）
 
 <p id= "security">
                
> *  security
>    *  security.basic.authorize-mode</br>
 要运用的安全授权模式。
>    *  security.basic.enabled</br>
>     开启基本身份验证。（默认值： true 。）
>    *  security.basic.path</br>
>     要保护的路径，用逗号分隔。（默认值： [>    *  ）
>    *  security.basic.realm</br>
>     HTTP基本领域（realm）用户名。（默认值： Spring 。）
>    *  security.enable-csrf</br>
>     开启跨站请求伪造（cross-site request forgery）支持。（默认值： false 。）
>    *  security.filter-order</br>
>     安全过滤器链顺序。（默认值： 0 。）
>    *  security.headers.cache</br>
>     开启缓存控制HTTP头。（默认值： false 。）
>    *  security.headers.content-type</br>
>     开启 X-Content-Type-Options 头。（默认值： false 。）
>    *  security.headers.frame</br>
>     开启 X-Frame-Options 头。（默认值： false 。）
>    *  security.headers.hsts</br>
>     HTTP Strict Transport Security（HSTS）模式（可设置为 none 、 domain 、 all ）。
>    *  security.headers.xss</br>
>     开启跨站脚本（cross-site scripting）保护。（默认值： false 。）
>    *  security.ignored</br>
>     要从默认保护路径中排除掉的路径列表，用逗号分隔。
>    *  security.oauth2.client.access-token-uri</br>
>     用于获取访问令牌的URI。
>    *  security.oauth2.client.access-token-validity-seconds</br>
>     在令牌过期前多长时间验证一次。
>    *  security.oauth2.client.additional-information. [key]</br>
>     设置额外的信息，令牌授予者会将其添加到令牌里。
>    *  security.oauth2.client.authentication-scheme</br>
>     传送持有人令牌（bearer token）的方法，包括 form 、 header 、 none 、 query ，可选其一。（默认值： header 。）
>    *  security.oauth2.client.authorities</br>
>     要赋予经授权客户端的权限。
>    *  security.oauth2.client.authorized-grant-types</br>
>     客户端可用的授予类型。
>    *  security.oauth2.client.auto-approve-scopes</br>
>     客户端自动通过的范围。
>    *  security.oauth2.client.client-authentication-scheme</br>
>     在客户端身份认证时用于传输身份认证信息的方法，包括 form 、 header 、 none 、 query ，可选其一。（默认值： header 。）
>    *  security.oauth2.client.client-id</br>
>     OAuth2客户端ID。
>    *  security.oauth2.client.client-secret</br>
>     OAuth2客户端密钥。默认随机生成。
>    *  security.oauth2.client.grant-type</br>
>     获得资源访问令牌的授予类型。
>    *  security.oauth2.client.id</br>
>     应用程序的客户端ID。
>    *  security.oauth2.client.pre-established-redirect-uri</br>
>     与服务器预先建立好的重定向URI。如果设置了该属性，用户授权请求中的重定向URI会被忽略，因为服务器不需要它。
>    *  security.oauth2.client.refresh-token-validity-seconds</br>
>     刷新令牌在过期前的有效时间。
>    *  security.oauth2.client.registered-redirect-uri</br>
>     客户端里注册的重定向URI，用逗号分隔。
>    *  security.oauth2.client.resource-ids</br>
>     与客户端关联的资源ID，用逗号分隔。
>    *  security.oauth2.client.scope</br>
>     客户端分配的域。
>    *  security.oauth2.client.token-name</br>
>     令牌名称。
>    *  security.oauth2.client.use-current-uri</br>
>     请求里的当前URI （如果设置了的话）是否优先于预建立的重定向URI。（默认值： true 。）
>    *  security.oauth2.client.user-authorization-uri</br>
>     用户要重定向以便授访问令牌的URI。
>    *  security.oauth2.resource.id</br>
>     资源的标识符。
>    *  security.oauth2.resource.jwt.key-uri</br>
>     JWT令牌的URI。如果没有配置 key-value ，使用的又是公钥，那么可以对这个属性进行设置。
>    *  security.oauth2.resource.jwt.key-value</br>
>     JWT令牌的验证密钥，可以是对称密钥，也可以是PEM编码的RSA公钥。如果没有配置这个属性，那么可以用 key-uri 代替。
>    *  security.oauth2.resource.prefer-token-info</br>
>     使用令牌的信息，设置为 false 则使用用户信息。（默认值： true 。）
>    *  security.oauth2.resource.service-id</br>
>     服务ID。（默认值： resource 。）
>    *  security.oauth2.resource.token-info-uri</br>
>     令牌解码端点URI。
>    *  security.oauth2.resource.token-type</br>
>     在使用 userInfoUri 时发送的令牌类型。
>    *  security.oauth2.resource.user-info-uri</br>
>     用户端点的URI。
>    *  security.oauth2.sso.filter-order</br>
>     在没有显式提供 WebSecurityConfigurerAdapter 时应用的过滤器顺序，在 Web-SecurityConfigurerAdapter 里也可以指定顺序。
>    *  security.oauth2.sso.login-path</br>
>     登录页的路径——登录页是触发重定向到OAuth2授权服务器的页面。（默认值：/login 。）
>    *  security.require-ssl</br>
>     对所有请求开启安全通道。（默认值： false 。）
>    *  security.sessions</br>
>     创建会话使用的策略。（可选值包括： always 、 never 、 if_required 、 stateless 。）
>    *  security.user.name</br>
>     默认的用户名。（默认值： user 。）
>    *  security.user.password</br>
>     默认用户的密码。
>    *  security.user.role</br>
>     赋予默认用户的角色。
 
 <p id= "server">
                
> *  server
>    *  server.address</br>
>     服务器绑定的网络地址。
>    *  server.compression.enabled</br>
>     是否要开启压缩。（默认值： false 。）
>    *  server.compression.excluded-user-agents</br>
>     用逗号分割的列表，标明哪些用户代理不该开启压缩。（可选值包括： text/html 、text/xml 、 text/plain 、 text/css ）
>    *  server.compression.mime-types</br>
>     要开启压缩的MIME类型列表，用逗号分割。
>    *  server.compression.min-response-size</br>
>     要执行压缩的最小响应大小（单位为字节）。（默认值： 2048 。）
>    *  server.context-parameters.[param name]</br>
>     设置一个Servlet上下文参数。
>    *  server.context-path</br>
>     应用程序的上下文路径。
>    *  server.display-name</br>
>     应用程序的显示名称。（默认值： application 。）
>    *  server.jsp-servlet.class-name</br>
>     针对JSP使用的Servlet类名。（默认值： org.apache.jasper.servlet.JspServlet 。）
>    *  server.jsp-servlet.init-parameters.[param name]</br>
>     设置JSP Servlet初始化参数。
>    *  server.jsp-servlet.registered</br>
>     JSP Servlet是否要注册到内嵌的Servlet容器里。（默认值： true 。）
>    *   server.port</br>
>     服务器的HTTP端口。
>    *  server.servlet-path</br>
>     主分发器Servlet的路径。（默认值： / 。）
>    *  server.session.cookie.comment</br>
>     会话Cookie的注释。
>    *  server.session.cookie.domain</br>
>     会话Cookie的域。
>    *  server.session.cookie.http-only</br>
>     会话Cookie的 HttpOnly 标记。
>    *  server.session.cookie.max-age</br>
>     会话Cookie的最大保存时间，单位为秒。
>    *  server.session.cookie.name</br>
>     会话Cookie名称。
>    *  server.session.cookie.path</br>
>     会话Cookie的路径。
>    *  server.session.cookie.secure</br>
>     会话Cookie的 Secure 标记。
>    *  server.session.persistent</br>
>     是否在两次重启间持久化会话数据。（默认值： false 。）
>    *  server.session.timeout</br>
>     会话超时时间，单位为秒。
>    *  server.session.tracking-modes</br>
>     会话跟踪模式（包括： cookie 、 url 和 ssl ，可选其一或若干）。
>    *  server.ssl.ciphers</br>
>     支持的SSL加密算法。
>    *  server.ssl.client-auth</br>
>     客户端授权是主动想（ want ）还是被动需要（ need ）。要有一个TrustStore。
>    *  server.ssl.enabled</br>
>     是否开启SSL。（默认值： true 。）
>    *  server.ssl.key-alias</br>
>     在KeyStore里标识密钥的别名。
>    *  server.ssl.key-password</br>
>     在KeyStore里用于访问密钥的密码。
>    *  server.ssl.key-store</br>
>     持有SSL证书的KeyStore的路径（通常指向一个.jks文件）。
>    *  server.ssl.key-store-password</br>
>     访问KeyStore时使用的密钥。
>    *  server.ssl.key-store-provider</br>
>     KeyStore的提供者。
>    *  server.ssl.key-store-type</br>
>     KeyStore的类型。
>    *  server.ssl.protocol</br>
>     要使用的SSL协议。（默认值： TLS 。）
>    *  server.ssl.trust-store</br>
>     持有SSL证书的TrustStore。
>    *  server.ssl.trust-store-password</br>
>     用于访问TrustStore的密码。
>    *  server.ssl.trust-store-provider</br>
>     TrustStore的提供者。
>    *  server.ssl.trust-store-type</br>
>     TrustStore的类型。
>    *  server.tomcat.access-log-enabled</br>
>     是否开启访问日志。（默认值： false 。）
>    *  server.tomcat.access-log-pattern</br>
>     访问日志的格式。（默认值： common 。）
>    *  server.tomcat.accesslog.directory</br>
>     创建日志文件的目录。可以相对于Tomcat基础目录，也可以是绝对路径。（默认值： logs 。）
>    *  server.tomcat.accesslog.enabled</br>
>     开启访问日志。（默认值： false 。）
>    *  server.tomcat.accesslog.pattern</br>
>     访问日志的格式。（默认值： common 。）
>    *  server.tomcat.accesslog.prefix</br>
>     日志文件名的前缀。（默认值： access_log 。）
>    *  server.tomcat.accesslog.suffix</br>
>     日志文件名的后缀。（默认值： .log 。）
>    *  server.tomcat.background-processor-delay</br>
>     两次调用 backgroundProcess 方法之间的延迟时间，单位为秒。（默认值： 30 。）
>    *  server.tomcat.basedir</br>
>     Tomcat的基础目录。如果没有指定则使用一个临时目录。
>    *  server.tomcat.internal-proxies</br>
>     匹配可信任代理服务器的正则表达式。默认值：“10\.\d{1,3}\.\d{1,3}\. \d{1,3}|192\.168\.\d
 {1,3}\.\d{1,3}| 169\.254\.\d{1,3}\.\d{1,3}| 127\.\d{1,3}\.\d{1,3}\.\d{1,3}|172\.1[6-9]{1}\.\d{1,3}
 \.\d{1,3}| 172\.2[0-9]{1}\.\d{1,3}\.\d{1,3}|172\.3[0-1]{1}\.\d{1,3}\.\d{1,3}”。
>    *  server.tomcat.max-http-header-size</br>
>     HTTP消息头的最大字节数。（默认值： 0 。）
>    *  server.tomcat.max-threads</br>
>     最大工作线程数。（默认值： 0 。）
>    *  server.tomcat.port-header</br>
>     用来覆盖原始端口值的HTTP头的名字。
>    *  server.tomcat.protocol-header</br>
>     持有流入协议的HTTP头，通常的名字是 X-Forwarded-Proto 。仅当设置了 remoteIp-Header 的时候，它会被配置为 RemoteIpValve 。
>    *  server.tomcat.protocol-header-https-value</br>
>     协议头的值，表明流入请求使用了SSL。（默认值： https 。）
>    *  server.tomcat.remote-ip-header</br>
>     表明从哪个HTTP头里可以提取到远端IP。仅当设置了 remoteIpHeader 的时候，它会被配置为 RemoteIpValve 。
>    *  server.tomcat.uri-encoding</br>
>     用来解码URI的字符编码。
>    *  server.undertow.access-log-dir</br>
>     Undertow的访问日志目录。（默认值： logs 。）
>    *  server.undertow.access-log-enabled</br>
>     是否开启访问日志。（默认值： false 。）
>    *  server.undertow.access-log-pattern</br>
>     访问日志的格式。（默认值： common 。）
>    *  server.undertow.accesslog.dir</br>
>     Undertow访问日志目录。
>    *  server.undertow.accesslog.enabled</br>
>     开启访问日志。（默认值： false 。）
>    *  server.undertow.accesslog.pattern</br>
>     访问日志的格式。（默认值： common 。）
>    *  server.undertow.buffer-size</br>
>     每个缓冲的字节数。
>    *  server.undertow.buffers-per-region</br>
>     每个区（region）的缓冲数。
>    *  server.undertow.direct-buffers</br>
>     在Java堆外分配缓冲。
>    *  server.undertow.io-threads</br>
>     要为工作线程创建的I/O线程数。
>    *  server.undertow.worker-threads</br>
>     工作线程数。
 
 <p id= "activemq">
                
> *  activemq
>    *  spring.activemq.broker-url</br>
>     ActiveMQ代理的URL。默认自动生成。
>    *  spring.activemq.in-memory</br>
>     标明默认代理URL是否应该在内存里。如果指定了一个显式的代理则忽略该属性。（默认值： true 。）
>    *  spring.activemq.password</br>
>     代理的登录密码。
>    *  spring.activemq.pooled</br>
>     标明是否要创建一个 PooledConnectionFactory 来代替普通的 ConnectionFactory 。（默认值： false 。）
>    *  spring.activemq.user</br>
>     代理的登录用户名。

 <p id= "aop">
                
> *  aop
>    *  spring.aop.auto</br>
>     添加 @EnableAspectJAutoProxy 。（默认值： true 。）
>    *  spring.aop.proxy-target-class</br>
>     是否要创建基于子类（即Code Generation Library，CGLIB）的代理来代替基于Java接口的代理，前者为 true ，后者为 false 。（默认值： false 。）

  <p id= "application">
                
> *  application
>    *  spring.application.admin.enabled</br>
>     开启应用程序的管理功能。（默认值： false 。）
>    *  spring.application.admin.jmx-name</br>
>     应用程序管理MBean的JMX名称。（默认值： org.springframework.boot:type=Admin,name=SpringApplication 。）
 <p id= "artemis">
              
> *  artemis
>    *  spring.artemis.embedded.cluster-password</br>
>     集群密码。默认在启动时随机生成。
>    *  spring.artemis.embedded.data-directory</br>
>     Journal文件目录。如果关闭了持久化则不需要该属性。
>    *  spring.artemis.embedded.enabled</br>
>     如果有Artemis服务器API则开启嵌入模式。（默认值： true 。）
>    *  spring.artemis.embedded.persistent</br>
>     开启持久化存储。（默认值： false 。）
>    *  spring.artemis.embedded.queues</br>
>     要在启动时创建的队列列表，用逗号分隔。（默认值： [] 。）
>    *  spring.artemis.embedded.server-id</br>
>     服务器ID。默认情况下，使用一个自动递增的计数器。（默认值： 0 。）
>    *  spring.artemis.embedded.topics</br>
>     在启动时要创建的主题列表，用逗号分隔。（默认值： [] 。）
>    *  spring.artemis.host</br>
>     Artemis代理主机。（默认值： localhost 。）
>    *  spring.artemis.mode</br>
>     Artemis部署模式，默认自动检测。可以显式地设置为 native 或 embedded 。
>    *  spring.artemis.port</br>
>     Artemis代理端口。（默认值： 61616 。）

 <p id= "batch">
                
> *  batch
>    *  spring.batch.initializer.enabled</br>
>     如果有必要的话，在启动时创建需要的批处理表。（默认值： true 。）
>    *  spring.batch.job.enabled</br>
>     在启动时执行上下文里的所有Spring Batch任务。（默认值： true 。）
>    *  spring.batch.job.names</br>
>     启动时要执行的任务名列表，用逗号分隔。默认在上下文里找到的所有任务都会执行。
>    *  spring.batch.schema</br>
>     指 向 初 始 化 数 据 库 Schema 用 的 SQL 文 件 的 路 径 。（ 默 认 值 ： classpath:org/springframework/batch/core/schema-@@platform@@.sql 。）
>    *  spring.batch.table-prefix</br>
>     所有批处理元数据表的表前缀。

 <p id= "cache">
                
> *  cache 
>    *  spring.cache.cache-names</br>
>     如果底层缓存管理器支持缓存名的话，可以在这里指定要创建的缓存名列表，用逗号分隔。通常这会禁用运行时创建其他额外缓存的能力。
>    *  spring.cache.ehcache.config</br>
>     用来初始化EhCache的配置文件的位置。
>    *  spring.cache.guava.spec</br>
>     用来创建缓存的Spec。要获得有关Spec格式的详细情况，可以查看 CacheBuilderSpec 。
>    *  spring.cache.hazelcast.config</br>
>     用来初始化Hazelcast的配置文件的位置。
>    *  spring.cache.infinispan.config</br>
>     用来初始化Infinispan的配置文件的位置。
>    *  spring.cache.jcache.config</br>
>     用来初始化缓存管理器的配置文件的位置。配置文件依赖于底层的缓存实现。
>    *  spring.cache.jcache.provider</br>
>     CachingProvider 实现的全限定类名，用来获取JSR-107兼容的缓存管理器，仅在Classpath里有不只一个JSR-107实现时才需要这个属性。
>    *  spring.cache.type</br>
>     缓存类型，默认根据环境自动检测。

 <p id= "elasticsearch">
                
> *  elasticsearch
>    *  spring.data.elasticsearch.cluster-name</br>
>     Elasticsearch集群名。（默认值： elasticsearch ）
>    *  spring.data.elasticsearch.cluster-nodes</br>
>     集群节点地址列表，用逗号分隔。如果没有指定，就启动一个客户端节点。
>    *  spring.data.elasticsearch.properties</br>
>     用来配置客户端的额外属性。
>    *  spring.data.elasticsearch.repositories.enabled</br>
>     开启Elasticsearch仓库。（默认值： true 。）

 <p id= "mongodb">
                
> *  mongodb 
>    *  spring.data.mongodb.authentication-database</br>
>     身份认证数据库名。
>    *  spring.data.mongodb.database</br>
>     数据库名。
>    *  spring.data.mongodb.field-naming-strategy</br>
>     要使用的 FieldNamingStrategy 的全限定名
>    *  spring.data.mongodb.grid-fs-database</br>
>     GridFS数据库名称。
>    *  spring.data.mongodb.host</br>
>     Mongo服务器主机地址。
>    *  spring.data.mongodb.password</br>
>     Mongo服务器的登录密码。
>    *  spring.data.mongodb.port</br>
>     Mongo服务器端口号。
>    *  spring.data.mongodb.repositories.enabled</br>
>     开启Mongo仓库。（默认值： true 。）
>    *  spring.data.mongodb.uri</br>
>     Mongo数据库URI。设置了该属性后就主机和端口号会被忽略。（默认值： mongodb://localhost/test 。）
>    *  spring.data.mongodb.username</br>
>     Mongo服务器的登录用户名。
 
 <p id= "rest">
                
> *  rest 
>    *  spring.data.rest.base-path</br>
>     用于发布仓库资源的基本路径。
>    *  spring.data.rest.default-page-size</br>
>     分页数据的默认页大小。（默认值： 20 。）
>    *  spring.data.rest.limit-param-name</br>
>     用于标识一次返回多少记录的URL查询字符串参数名。（默认值： size 。）
>    *  spring.data.rest.max-page-size</br>
>     最大分页大小。（默认值： 1000 。）
>    *  spring.data.rest.page-param-name</br>
>     URL查询字符串参数的名称，用来标识返回哪一页。（默认值： page 。）
>    *  spring.data.rest.return-body-on-create</br>
>     在创建实体后是否返回一个响应体。（默认值： false 。）
>    *  spring.data.rest.return-body-on-update</br>
>     在更新实体后是否返回一个响应体。（默认值： false 。）
>    *  spring.data.rest.sort-param-name</br>
>     URL查询字符串参数的名称，用来标识结果排序的方向。（默认值： sort 。）

 <p id= "solr">
                
> *  solr
>    *  spring.data.solr.host</br>
>     Solr的主机地址。如果设置了 zk-host 则忽略该属性。（默认值： http://127.0.0.1:8983/solr 。）
>    *  spring.data.solr.repositories.enabled</br>
>     开启Solr仓库。（默认值： true 。）
>    *  spring.data.solr.zk-host</br>
>     ZooKeeper主机地址，格式为“主机:端口”。
 <p id= "datasource">
                
> *  datasource 
>    *  spring.datasource.abandon-when-percentage-full</br>
>     一个百分比形式的阈值，超过该阈值则关闭并报告被弃用（超时）的连接。
>    *  spring.datasource.allow-pool-suspension</br>
>     是否允许池暂停（pool suspension）。在开启池暂停后会有性能会受到一定影响，除非你真的需要这个功能（例如在冗余的系统下），否则不要开启它。该属性只在使用Hikari数据库连接池时有用。（默认值： false 。）
>    *  spring.datasource.alternate-username-allowed</br>
>     是否允许使用其他用户名。
>    *  spring.datasource.auto-commit</br>
>     更新操作是否自动提交。
>    *  spring.datasource.catalog</br>
>     默认的Catalog名称。
>    *  spring.datasource.commit-on-return</br>
>     在连接归还时，连接池是否要提交挂起的事务。
>    *  spring.datasource.connection-init-sql</br>
>     在所有新连接创建时都会执行的SQL语句，该语句会在连接加入连接池前执行。
>    *  spring.datasource.connection-init-sqls</br>
>     在物理连接第一次创建时执行的SQL语句列表。（用于DBCP连接池。）
>    *  spring.datasource.connection-properties.[key]</br>
>     设置创建连接时使用的属性。（用于DBCP连接池。）
>    *  spring.datasource.connection-test-query</br>
>     用于测试连接有效性的SQL查询。
>    *  spring.datasource.connection-timeout</br>
>     连接超时（单位为毫秒）。
>    *  spring.datasource.continue-on-error</br>
>     初始化数据库时发生错误不要终止。（默认值： false 。）
>    *  spring.datasource.data</br>
>     指向数据（数据库操纵语言，Data Manipulation Language，DML）脚本资源的引用。
>    *  spring.datasource.data-source-class-name</br>
>     用于获取连接的数据源的全限定类名。
>    *  spring.datasource.data-source-jndi</br>
>     用于获取连接的数据源的JNDI位置。
>    *  spring.datasource.data-source-properties.[key]</br>
>     设置创建数据源时使用的属性。（用于Hikari连接池。）
>    *  spring.datasource.db-properties</br>
>     设置创建数据源时使用的属性。（用于Tomcat连接池。）
>    *  spring.datasource.default-auto-commit</br>
>     连接上的操作是否自动提交。
>    *  spring.datasource.default-catalog</br>
>     连接的默认Catalog。
>    *  spring.datasource.default-read-only</br>
>     连接的默认只读状态。
>    *  spring.datasource.default-transaction-isolation</br>
>     连接的默认事务隔离级别。
>    *  spring.datasource.driver-class-name</br>
>     JDBC驱动的全限定类名。默认根据URL自动检测。
>    *  spring.datasource.fair-queue</br>
>     是否以FIFO方式返回连接。
>    *  spring.datasource.health-check-properties.[key]</br>
>     设置要纳入健康检查的属性。（用于Hikari连接池。）
>    *  spring.datasource.idle-timeout</br>
>     连接池中的连接能保持闲置状态的最长时间，单位为毫秒。（默认值： 10 。）
>    *  spring.datasource.ignore-exception-on-pre-load</br>
>     初始化数据库连接池时是否要忽略连接。
>    *  spring.datasource.init-sql</br>
>     在连接第一次创建时运行的自定义查询。
>    *  spring.datasource.initial-size</br>
>     在连接池启动时要建立的连接数。
>    *  spring.datasource.initialization-fail-fast</br>
>     在连接池创建时，如果达不到最小连接数是否要抛出异常。（默认值： true 。）
>    *  spring.datasource.initialize</br>
>     使用data.sql初始化数据库。（默认值： true 。）
>    *  spring.datasource.isolate-internal-queries</br>
>     是否要隔离内部请求。（默认值： false 。）
>    *  spring.datasource.jdbc-interceptors</br>
>     一个分号分隔的类名列表，这些类都扩展了 JdbcInterceptor 类。这些拦截器会插入java.sql.Connection 对象的操作链里。（用于Tomcat连接池。）
>    *  spring.datasource.jdbc-url</br>
>     用来创建连接的JDBC URL。
>    *  spring.datasource.jmx-enabled</br>
>     开启JMX支持（如果底层连接池提供该功能的话）。（默认值： false 。）
>    *  spring. datasource.jndi-name</br>
>     数据源的JNDI位置。设置了该属性则忽略类、URL、用户名和密码属性。
>    *  spring.datasource.leak-detection-threshold</br>
>     用来检测Hikari连接池连接泄露的阈值，单位为毫秒。
>    *  spring.datasource.log-abandoned</br>
>     是否针对弃用语句或连接的应用程序代码记录下跟踪栈。用于DBCP连接池。（默认值： false 。）
>    *  spring.datasource.log-validation-errors</br>
>     在使用Tomcat连接池时是否要记录验证错误。
>    *  spring.datasource.login-timeout</br>
>     连接数据库的超时时间（单位为秒）。
>    *  spring.datasource.max-active</br>
>     连接池中的最大活跃连接数。
>    *  spring.datasource.max-age</br>
>     连接池中连接的最长寿命。
>    *  spring.datasource.max-idle</br>
>     连接池中的最大空闲连接数。
>    *  spring.datasource.max-lifetime</br>
>     连接池中连接的最长寿命（单位为毫秒）。
>    *  spring.datasource.max-open-prepared-statements</br>
>     开启状态的 PreparedStatement 的数量上限。
>    *  spring.datasource.max-wait</br>
>     连接池在等待返回连接时，最长等待多少毫秒再抛出异常。
>    *  spring.datasource.maximum-pool-size</br>
>     连接池能达到的最大规模，包含空闲连接的数量和使用中的连接数量。
>    *  spring.datasource.min-evictable-idle-time-millis</br>
>     一个空闲连接被空闲连接释放器（如果存在的话）优雅地释放前，最短会在连接池里停留多少时间。
>    *  spring.datasource.min-idle</br>
>     连接池里始终应该保持的最小连接数。（用于DBCP和Tomcat连接池。）
>    *  spring.datasource.minimum-idle:</br>
>     HikariCP试图在连接池里维持的最小空闲连接数。
>    *  spring.datasource.name</br>
>     数据源的名称。
>    *  spring.datasource.num-tests-per-eviction-run</br>
>     空闲对象释放器线程（如果存在的话）每次运行时要检查的对象数。
>    *   spring.datasource.password</br>
>     数据库的登录密码。
>    *  spring.datasource.platform</br>
>     在Schema资源（schema-${platform}.sql）里要使用的平台。（默认值： all 。）
>    *  spring.datasource.pool-name</br>
>     连接池名称。
>    *  spring.datasource.pool-prepared-statements</br>
>     是否要将 Statement 放在池里。
>    *  spring.datasource.propagate-interrupt-state</br>
>     对于等待连接的中断线程，是否要传播中断状态。
>    *  spring.datasource.read-only</br>
>     在使用Hikari连接池时将数据源设置为只读。
>    *  spring.datasource.register-mbeans</br>
>     Hikari连接池是否要注册JMX MBean。
>    *  spring.datasource.remove-abandoned</br>
>     被弃用的连接在到达弃用超时后是否应该被移除。
>    *  spring.datasource.remove-abandoned-timeout</br>
>     连接在多少秒后应该考虑弃用。
>    *  spring.datasource.rollback-on-return</br>
>     在连接归还连接池时，是否要回滚挂起的事务。
>    *  spring.datasource.schema</br>
>     Schema（数据定义语言，Data Definition Language，DDL）脚本资源的引用。
>    *  spring.datasource.separator</br>
>     SQL初始化脚本里的语句分割符。（默认值： ; 。）
>    *  spring.datasource.sql-script-encoding</br>
>     SQL脚本的编码。
>    *  spring.datasource.suspect-timeout</br>
>     在记录一个疑似弃用连接前要等待多少秒。
>    *  spring.datasource.test-on-borrow</br>
>     从连接池中借用连接时是否要进行测试。
>    *  spring.datasource.test-on-connect</br>
>     在建立连接时是否要进行测试。
>    *  spring.datasource.test-on-return</br>
>     在将连接归还到连接池时是否要进行测试。
>    *  spring.datasource.test-while-idle</br>
>     在连接空闲时是否要进行测试。
>    *  spring.datasource.time-between-eviction-runs-millis</br>
>     在两次空闲连接验证、弃用连接清理和空闲池大小调整之间睡眠的毫秒数。
>    *  spring.datasource.transaction-isolation</br>
>     在使用Hikari连接池时设置默认事务隔离级别。
>    *  spring.datasource.url</br>
>     数据库的JDBC URL。
>    *  spring.datasource.use-disposable-connection-facade</br>
>     连接是否要用一个门面（facade）封装起来，在调用了 Connection.close() 后就不能再使用这个连接了。
>    *  spring.datasource.use-equals</br>
>     在比较方法名时是否使用 String.equals() 来代替 == 。
>    *  spring.datasource.use-lock</br>
>     在操作连接对象时是否要加锁。
>    *  spring.datasource.username</br>
>     数据库的登录用户名。
>    *  spring.datasource.validation-interval</br>
>     执行连接验证的间隔时间，单位为毫秒。
>    *  spring.datasource.validation-query</br>
>     在连接池里的连接返回给调用者或连接池时，要执行的验证SQL查询。
>    *  spring.datasource.validation-query-timeout</br>
>     在连接验证查询执行失败前等待的超时时间，单位为秒。
>    *  spring.datasource.validation-timeout</br>
>     在连接验证失败前等待的超时时间，单位为秒。（用于Hikari连接池。）
>    *  spring.datasource.validator-class-name</br>
>     可选验证器类的全限定类名，用于执行测试查询。
>    *  spring.datasource.xa.data-source-class-name</br>
>     XA数据源的全限定类名。
>    *  spring.datasource.xa.properties</br>
>     要传递给XA数据源的属性。

 <p id= "freemarker">
                
> *  freemarker
>    *  spring.freemarker.allow-request-override</br>
>     HttpServletRequest 的属性是否允许覆盖（隐藏）控制器生成的同名模型属性。
>    *  spring.freemarker.allow-session-override</br>
>     HttpSession 的属性是否允许覆盖（隐藏）控制器生成的同名模型属性。
>    *  spring.freemarker.cache</br>
>     开启模板缓存。
>    *  spring.freemarker.charset</br>
>     模板编码。
>    *  spring.freemarker.check-template-location</br>
>     检查模板位置是否存在。
>    *  spring.freemarker.content-type</br>
>     Content-Type 的值。
>    *  spring.freemarker.enabled</br>
>     开启FreeMarker的MVC视图解析。
>    *  spring.freemarker.expose-request-attributes</br>
>     在模型合并到模板前，是否要把所有的请求属性添加到模型里。
>    *  spring.freemarker.expose-session-attributes</br>
>     在模型合并到模板前，是否要把所有的 HttpSession 属性添加到模型里。
>    *  spring.freemarker.expose-spring-macro-helpers</br>
>     是否发布供Spring宏程序库使用的 RequestContext ，并将命其名为 springMacro-RequestContext 
>    *    spring.freemarker.prefer-file-system-access</br>
>     加载模板时优先通过文件系统访问。文件系统访问能够实时检测到模板变更。（默认值：true 。）
>    *  spring.freemarker.prefix</br>
>     在构建URL时添加到视图名称前的前缀。
>    *  spring.freemarker.request-context-attribute</br>
>     在所有视图里使用的 RequestContext 属性的名称。
>    *  spring.freemarker.settings</br>
>     要传递给FreeMarker配置的各种键。
>    *  spring.freemarker.suffix</br>
>     在构建URL时添加到视图名称后的后缀。
>    *  spring.freemarker.template-loader-path</br>
>     模板路径列表，用逗号分隔。（默认值： ["classpath:/templates/"] 。）
>    *  spring.freemarker.view-names</br>
>     可解析的视图名称的白名单。

 <p id= "groovy">
               
> *  groovy
>    *  spring.groovy.template.allow-request-override</br>
>     HttpServletRequest 的属性是否允许覆盖（隐藏）控制器生成的同名模型属性。
>    *  spring.groovy.template.allow-session-override</br>
>     HttpSession 的属性是否允许覆盖（隐藏）控制器生成的同名模型属性。
>    *  spring.groovy.template.cache</br>
>     开启模板缓存。
>    *  spring.groovy.template.charset</br>
>     模板编码。
>    *  spring.groovy.template.check-template-location</br>
>     检查模板位置是否存在。
>    *  spring.groovy.template.configuration.auto-escape</br>
>     模型变量在模板里呈现时是否要做转义。（默认值： false 。）
>    *  spring.groovy.template.configuration.auto-indent</br>
>     模板是否要自动呈现缩进。（默认值： false 。）
>    *  spring.groovy.template.configuration.auto-indent-string</br>
>     开启自动缩进时用于缩进的字符串，可以是 SPACES ，也可以是 TAB 。（默认值： SPACES 。）
>    *  spring.groovy.template.configuration.auto-new-line</br>
>     模板里是否要呈现新的空行。（默认值： false 。
>    *    spring.groovy.template.configuration.base-template-class</br>
>     模板基类。
>    *  spring.groovy.template.configuration.cache-templates</br>
>     模板是否应该缓存。（默认值： true 。）
>    *  spring.groovy.template.configuration.declaration-encoding</br>
>     用来写声明头的编码。
>    *  spring.groovy.template.configuration.expand-empty-elements</br>
>     没有正文的元素该用短形式（例如， "<br/>" ）还是扩展形式（例如， "<br></br>" ）来书写。（默认值： false 。）
>    *  spring.groovy.template.configuration.locale</br>
>     设置模板地域
>    *    spring.groovy.template.configuration.new-line-string</br>
>     在自动空行开启后用来呈现空行的字符串。（默认为系统的 line.separator 属性值。）
>    *  spring.groovy.template.configuration.resource-loader-path</br>
>     Groovy模板的路径。（默认值： classpath:/templates/ 。）
>    *  spring.groovy.template.configuration.use-double-quotes</br>
>     属性是该用双引号还是单引号。（默认值： false 。）
>    *  spring.groovy.template.content-type</br>
>     Content-Type 的值。
>    *  spring.groovy.template.enabled</br>
>     开启Groovy模板的MVC视图解析
>    *  spring.groovy.template.expose-request-attributes</br>
>     在模型合并到模板前，是否要把所有的请求属性添加到模型里。
>    *  spring.groovy.template.expose-session-attributes</br>
>     在模型合并到模板前，是否要把所有的 HttpSession 属性添加到模型里。
>    *  spring.groovy.template.expose-spring-macro-helpers</br>
>     是否发布供Spring宏程序库使用的 RequestContext ，并将其命名为 springMacro-RequestContext 。
>    *  spring.groovy.template.prefix</br>
>     在构建URL时，添加到视图名称前的前缀。
>    *  spring.groovy.template.request-context-attribute</br>
>     所有视图里使用的 RequestContext 属性的名称。
>    *  spring.groovy.template.resource-loader-path</br>
>     模板路径（默认值： classpath:/ templates/ 。）
>    *  spring.groovy.template.suffix</br>
>     在构建URL时，添加到视图名称后的后缀。
>    *  spring.groovy.template.view-names</br>
>     可解析的视图名称白名单。

 <p id= "h2">
                
> *  h2 
>    *  spring.h2.console.enabled</br>
>     开启控制台。（默认值： false 。）
>    *  spring.h2.console.path</br>
>     可以找到控制台的路径。（默认值： /h2-console 。）
>    *  spring.hateoas.apply-to-primary-object-mapper</br>
>     指定主 ObjectMapper 是否要应用HATEOAS支持。（默认值： true 。）

 <p id= "hornetq">
              
> *  hornetq
>    *  spring.hornetq.embedded.cluster-password</br>
>     集群密码。默认在启动时随机生成。
>    *  spring.hornetq.embedded.data-directory</br>
>     日志文件目录。如果关闭了持久化功能则不需要该属性
>    *    spring.hornetq.embedded.enabled</br>
>     如果有HornetQ服务器API，则开启嵌入模式。（默认值： true 。）
>    *  spring.hornetq.embedded.persistent</br>
>     开启持久化存储。（默认值： false 。）
>    *  spring.hornetq.embedded.queues</br>
>     启动时要创建的队列列表，用逗号分隔。（默认值： [] 。）
>    *  spring.hornetq.embedded.server-id</br>
>     服务器ID。默认使用自增长计数器。（默认值： 0 。）
>    *  spring.hornetq.embedded.topics</br>
>     启动时要创建的主题列表，用逗号分隔。（默认值： [] 。）
>    *  spring.hornetq.host</br>
>     HornetQ的主机。（默认值： localhost 。）
>    *  spring.hornetq.mode</br>
>     HornetQ的部署模式，默认为自动检测。可以显式地设置为 native 或 embedded 。
>    *  spring.hornetq.port</br>
>     HornetQ的端口。（默认值： 5445 。)


 <p id= "http">
                
> *  http 
>    *  spring.http.converters.preferred-json-mapper</br>
>     HTTP消息转换时优先使用JSON映射器。
>    *  spring.http.encoding.charset</br>
>     HTTP请求和响应的字符集。如果没有显式地指定 Content-Type 头，则将该属性值作为这个头的值。（默认值： UTF-8 。）
>    *  spring.http.encoding.enabled</br>
>     开启HTTP编码支持。（默认值： true 。）
>    *  spring.http.encoding.force</br>
>     强制将HTTP请求和响应编码为所配置的字符集。（默认值： true 。）

 <p id= "jackson">
                
> *  jackson
>    *  spring.jackson.date-format</br>
>     日期格式字符串（yyyy-MM-dd HH:mm:ss）或日期格式类的全限定类名。
>    *  spring.jackson.deserialization</br>
>     影响Java对象反序列化的Jackson on/off特性。
>    *  spring.jackson.generator</br>
>     用于生成器的Jackson on/off特性。
>    *  spring.jackson.joda-date-time-format</br>
>     Joda日期时间格式字符串（yyyy-MM-dd HH:mm:ss）。如果没有配置，而 date-format又配置了一个格式字符串的话，会将它作为降级配置。
>    *  spring.jackson.locale</br>
>     用于格式化的地域值。
>    *  spring.jackson.mapper</br>
>     Jackson的通用on/off特性。
>    *  spring.jackson.parser</br>
>     用于解析器的Jackson on/off特性。
>    *  spring.jackson.property-naming-strategy</br>
>     Jackson的 PropertyNamingStrategy 中的一个常量（ CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES ）。也可以设置 PropertyNamingStrategy 的子类的全限定类名。
>    *  spring.jackson.serialization</br>
>     影响Java对象序列化的Jackson on/off特性。
>    *  spring.jackson.serialization-inclusion</br>
>     控制序列化时要包含哪些属性。可选择Jackson的 JsonInclude.Include 枚举里的某个值。
>    *  spring.jackson.time-zone</br>
>     格式化日期时使用的时区。可以配置各种可识别的时区标识符，比如 America/Los_Angeles 或者 GMT+10 。

 <p id= "jersey">
                
> *  jersey
>    *  spring.jersey.filter.order</br>
>     Jersey过滤器链的顺序。（默认值： 0 。）
>    *  spring.jersey.init</br>
>     通过Servlet或过滤器传递给Jersey的初始化参数。
>    *  spring.jersey.type</br>
>     Jersey集成类型。可以是 servlet 或者 filter 。

 <p id= "jms">
                
> *  jms
>    *  spring.jms.jndi-name</br>
>     连接工厂的JNDI名字。设置了该属性，则优先于其他自动配置的连接工厂。
>    *  spring.jms.listener.acknowledge-mode</br>
>     容器的应答模式（acknowledgment mode）。默认情况下，监听器使用自动应答。
>    *  spring.jms.listener.auto-startup</br>
>     启动时自动启动容器。（默认值： true 。）
>    *  spring.jms.listener.concurrency</br>
>     并发消费者的数量下限。
>    *  spring.jms.listener.max-concurrency</br>
>     并发消费者的数量上限。
>    *  spring.jms.pub-sub-domain</br>
>     如果是主题而非队列，指明默认的目的地类型是否支持Pub/Sub。（默认值： false 。）

 <p id= "jmx">
                
> *  jmx
>    *  spring.jmx.default-domain</br>
>     JMX域名。
>    *  spring.jmx.enabled</br>
>     将管理Bean发布到JMX域里。（默认值： true 。）
>    *  spring.jmx.server</br>
>     MBeanServer 的Bean名称。（默认值： mbeanServer 。）

 <p id= "jpa">
                
> *  jpa
>    *    spring.data.jpa.repositories.enabled</br>
>     开启JPA仓库。（默认值： true 。）
>    *  spring.jpa.database</br>
>     要操作的目标数据库，默认自动检测。也可以通过 databasePlatform 属性进行设置。
>    *  spring.jpa.database-platform</br>
>     要操作的目标数据库，默认自动检测。也可以通过 Database 枚举来设置。
>    *  spring.jpa.generate-ddl</br>
>     启动时要初始化Schema。（默认值： false 。）
>    *  spring.jpa.hibernate.ddl-auto</br>
>     DDL模式（ none 、 validate 、 update 、 create 和 create-drop ）。这是 hibernate.hbm2ddl.auto 属性的一个快捷方式。在使用嵌入式数据库时，默认为 create-drop ；其他情况下默认为 none 。
>    *  spring.jpa.hibernate.naming-strategy</br>
>     Hibernate命名策略的全限定类名。
>    *  spring.jpa.open-in-view</br>
>     注册 OpenEntityManagerInViewInterceptor ，在请求的整个处理过程中，将一个JPAEntityManager 绑定到线程上。（默认值： true 。）
>    *  spring.jpa.properties</br>
>     JPA提供方要设置的额外原生属性。
>    *  spring.jpa.show-sql</br>
>     在使用Bitronix Transaction Manager时打开SQL语句日志。（默认值： false 。）

 <p id= "jta">
                
> *  jta
>    *    spring.jta.allow-multiple-lrc</br>
>     在使用Bitronix Transaction Manager时，事务管理器是否应该允许一个事务涉及多个LRC资源。（默认值： false 。）
>    *  spring.jta.asynchronous2-pc</br>
>     在使用Bitronix Transaction Manager时，是否异步执行两阶段提交。（默认值： false 。）
>    *  spring.jta.background-recovery-interval</br>
>     在使用Bitronix Transaction Manager时，多久运行一次恢复过程，单位为分钟。（默认值：1 。）
>    *  spring.jta.background-recovery-interval-seconds</br>
>     在使用Bitronix Transaction Manager时，多久运行一次恢复过程，单位为秒。（默认值： 60 。）
>    *  spring.jta.current-node-only-recovery</br>
>     在使用Bitronix Transaction Manager时，恢复是否要滤除不包含本JVM唯一ID的XID。（默认值： true 。）
>    *  spring.jta.debug-zero-resource-transaction</br>
>     在使用Bitronix Transaction Manager时，对于没有涉及任何资源的事务，是否要跟踪并记录它们的创建和提交调用栈。（默认值： false 。）
>    *  spring.jta.default-transaction-timeout</br>
>     在使用Bitronix Transaction Manager时，默认的事务超时时间，单位为秒。（默认值： 60 。）
>    *  spring.jta.disable-jmx</br>
>     在使用Bitronix Transaction Manager时，是否要禁止注册JMX MBean。（默认值： false 。）
>    *  spring.jta.enabled</br>
>     开启JTA支持。（默认值： true 。）
>    *  spring.jta.exception-analyzer</br>
>     在使用Bitronix Transaction Manager时用到的异常分析器。设置为 null 时使用默认异常分析器，也可以设置自定义异常分析器的全限定类名。
>    *  spring.jta.filter-log-status</br>
>     在使用Bitronix Transaction Manager时，是否只记录必要的日志。开启该参数时能减少分段（fragment）空间用量，但调试更复杂了。（默认值： false 。）
>    *  spring.jta.force-batching-enabled</br>
>     在使用Bitronix Transaction Manager时，是否批量输出至磁盘。禁用批处理会严重降低事务管理器的吞吐量。（默认值： true 。）
>    *  spring.jta.forced-write-enabled</br>
>     在使用Bitronix Transaction Manager时，日志是否强制写到磁盘上。在生产环境里不要设置为 false ，因为不强制写到磁盘上无法保证完整性。（默认值： true 。）
>    *  spring.jta.graceful-shutdown-interval</br>
>     在使用Bitronix Transaction Manager时，要关闭的话，事务管理器在放弃事务前最多等它多少秒。（默认值： 60 。）
>    *  spring.jta.jndi-transaction-synchronization-registry-name</br>
>     在使用Bitronix Transaction Manager时，事务同步注册表应该绑定到哪个JNDI下。（默认值： java:comp/TransactionSynchronizationRegistry 。）
>    *  spring.jta.jndi-user-transaction-name</br>
>     在使用Bitronix Transaction Manager时，用户事务应该绑定到哪个JNDI下。（默认值：java:comp/UserTransaction 。）
>    *  spring.jta.journal</br>
>     在使用Bitronix Transaction Manager时，要用的日志名。可以是 disk 、 null 或者全限定类名。（默认值： disk 。）
>    *  spring.jta.log-dir</br>
>     事务日志目录。
>    *  spring.jta.log-part1-filename</br>
>     日志分段文件1的名称。（默认值： btm1.tlog 。）
>    *  spring.jta.log-part2-filename</br>
>     日志分段文件2的名称。（默认值： btm2.tlog 。）
>    *  spring.jta.max-log-size-in-mb</br>
>     在使用Bitronix Transaction Manager时，日志分段文件的最大兆数。日志越大，事务就被允许在未终结状态停留越长时间。但是，如果文件大小限制得太小，事务管理器在分段满了的时候就会暂停更长时间。（默认值： 2 。）
>    *  spring.jta.resource-configuration-filename</br>
>     Bitronix Transaction Manager的配置文件名。
>    *  spring.jta.server-id</br>
>     唯一标识Bitronix Transaction Manager实例的ID。
>    *  spring.jta.skip-corrupted-logs</br>
>     是否跳过损坏的日志文件。（默认值： false 。）
>    *  spring.jta.transaction-manager-id</br>
>     事务管理器的唯一标识符
>    *    spring.jta.warn-about-zero-resource-transaction</br>
>     在使用Bitronix Transaction Manager时，是否要对执行时没有涉及任何资源的事务作出告警。（默认值： true 。）

 <p id= "mail">
                
> *  mail
>    *  spring.mail.default-encoding</br>
>     默认的 MimeMessage 编码。（默认值： UTF-8 。）
>    *  spring.mail.host</br>
>     SMTP服务器主机地址。
>    *  spring.mail.jndi-name</br>
>     会话的JNDI名称。设置之后，该属性的优先级要高于其他邮件设置。
>    *  spring.mail.password</br>
>     SMTP服务器的登录密码。
>    *  spring.mail.port</br>
>     SMTP服务器的端口号。
>    *  spring.mail.properties</br>
>     附加的JavaMail会话属性。
>    *  spring.mail.protocol</br>
>     SMTP服务器用到的协议。（默认值： smtp 。
>    *    spring.mail.test-connection</br>
>     在启动时测试邮件服务器是否可用。（默认值： false 。）
>    *  spring.mail.username</br>
>     SMTP服务器的登录用户名。
 
 <p id= "messages">
                
> *  messages
>    *  spring.messages.basename</br>
>     逗号分隔的基本名称列表，都遵循 ResourceBundle 的惯例。本质上这就是一个全限定的Classpath位置，如果不包含包限定符（比如 org.mypackage ），就会从Classpath的根部开始解析。（默认值： messages 。）
>    *  spring.messages.cache-seconds</br>
>     加载的资源包文件的缓存失效时间，单位为秒。在设置为 -1 时，包会永远缓存。（默认值： -1 。）
>    *  spring.messages.encoding</br>
>     消息包的编码。（默认值： UTF-8 。）

 <p id= "mobile">
                
> *  mobile
>    *  spring.mobile.devicedelegatingviewresolver.enable-fallback</br>
>     开启降级解析支持。（默认值： false 。）
>    *  spring.mobile.devicedelegatingviewresolver.enabled</br>
>     开启设备视图解析器。（默认值： false 。）
>    *  spring.mobile.devicedelegatingviewresolver.mobile-prefix</br>
>     添加到移动设备视图名前的前缀。（默认值： mobile/ 。）
>    *  spring.mobile.devicedelegatingviewresolver.mobile-suffix</br>
>     添加到移动设备视图名后的后缀。
>    *  spring.mobile.devicedelegatingviewresolver.normal-prefix</br>
>     添加到普通设备视图名前的前缀。
>    *  spring.mobile.devicedelegatingviewresolver.normal-suffix</br>
>     添加到普通设备视图名后的后缀
>    *    spring.mobile.devicedelegatingviewresolver.tablet-prefix</br>
>     添加到平板设备视图名前的前缀。（默认值： tablet/ 。）
>    *  spring.mobile.devicedelegatingviewresolver.tablet-suffix</br>
>     添加到平板设备视图名后的后缀。
>    *  spring.mobile.sitepreference.enabled</br>
>     开启 SitePreferenceHandler 。（默认值： true 。）

 <p id= "mongodb">
                
> *  mongodb
>    *  spring.mongodb.embedded.features</br>
>     要开启的特性列表，用逗号分隔。
>    *  spring.mongodb.embedded.version</br>
>     要使用的Mongo版本。（默认值： 2.6.10 。）
 
 <p id= "mustache">
                
> *  mustache 
>    *  spring.mustache.cache</br>
>     开启模板缓存。
>    *  spring.mustache.charset</br>
>     模板编码。
>    *  spring.mustache.check-template-location</br>
>     检查模板位置是否存在。
>    *  spring.mustache.content-type</br>
>     Content-Type 的值。
>    *  spring.mustache.enabled</br>
>     开启Mustache的MVC视图解析。
>    *  spring.mustache.prefix</br>
>     添加到模板名前的前缀。（默认值： classpath:/ templates/ 。）
>    *  spring.mustache.suffix</br>
>     添加到模板名后的后缀。（默认值： .html 。）
>    *  spring.mustache.view-names</br>
>     可解析的视图名称的白名单。
 
 <p id= "mvc">
 
> *  mvc
>    *  spring.mvc.async.request-timeout</br>
>     异步请求处理超时前的等待时间（单位为毫秒）。如果没有设置该属性，则使用底层实现的默认超时时间，比如，Tomcat上使用Servlet 3时超时时间为10秒
>    *    spring.mvc.date-format</br>
>     要使用的日期格式（比如 dd/MM/yyyy ）。
>    *  spring.mvc.favicon.enabled</br>
>     开启favicon.ico的解析。（默认值： true 。）
>    *  spring.mvc.ignore-default-model-on-redirect</br>
>     在重定向的场景下，是否要忽略“默认”模型对象的内容。（默认值： true 。
>    *    spring.mvc.locale</br>
>     要使用的地域配置。
>    *  spring.mvc.message-codes-resolver-format</br>
>     消息代码格式（ PREFIX_ERROR_CODE 、 POSTFIX_ERROR_CODE ）。
>    *  spring.mvc.view.prefix</br>
>      Spring MVC视图前缀。
>    *  spring.mvc.view.suffix</br>
>     Spring MVC视图后缀。

 <p id= "rabbitmq">
                
> *  rabbitmq
>    *  spring.rabbitmq.addresses</br>
>     客户端应该连接的地址列表，用逗号分隔。
>    *  spring.rabbitmq.dynamic</br>
>     创建一个 AmqpAdmin Bean。（默认值： true 。）
>    *  spring.rabbitmq.host</br>
>     RabbitMQ主机地址。（默认值： localhost 。）
>    *  spring.rabbitmq.listener.acknowledge-mode</br>
>     容器的应答模式。
>    *  spring.rabbitmq.listener.auto-startup</br>
>     启动时自动开启容器。（默认值： true 。）
>    *  spring.rabbitmq.listener.concurrency</br>
>     消费者的数量下限。
>    *  spring.rabbitmq.listener.max-concurrency</br>
>     消费者的数量上限。
>    *  spring.rabbitmq.listener.prefetch</br>
>     单个请求里要处理的消息数。该数值不应小于事务数（如果用到的话）。
>    *  spring.rabbitmq.listener.transaction-size</br>
>     一个事务里要处理的消息数。为了保证效果，应该不大于预先获取的数量。
>    *  spring.rabbitmq.password</br>
>     进行身份验证的密码。
>    *  spring.rabbitmq.port</br>
>     RabbitMQ端口。（默认值： 5672 。）
>    *  spring.rabbitmq.requested-heartbeat</br>
>     请求心跳超时，单位为秒； 0 表示不启用心跳。
>    *  spring.rabbitmq.ssl.enabled</br>
>     开启SSL支持。（默认值： false 。）
>    *  spring.rabbitmq.ssl.key-store</br>
>     持有SSL证书的KeyStore路径。
>    *  spring.rabbitmq.ssl.key-store-password</br>
>     访问KeyStore的密码。
>    *  spring.rabbitmq.ssl.trust-store</br>
>     持有SSL证书的TrustStore。
>    *  spring.rabbitmq.ssl.trust-store-password</br>
>     访问TrustStore的密码。
>    *  spring.rabbitmq.username</br>
>     进行身份验证的用户名。
>    *  spring.rabbitmq.virtual-host</br>
>     在连接RabbitMQ时的虚拟主机。 

 <p id= "redis">
                
> *  redis 
>    *  spring.redis.database</br>
>     连接工厂使用的数据库索引。（默认值： 0 。）
>    *  spring.redis.host</br>
>     Redis服务器主机地址。（默认值： localhost 。）
>    *  spring.redis.password</br>
>     Redis服务器的登录密码>    *    spring.redis.pool.max-active</br>
>     连接池在指定时间里能分配的最大连接数。负数表示无限制。（默认值： 8 。）
>    *  spring.redis.pool.max-idle</br>
>     连接池里的最大空闲连接数。负数表示空闲连接数可以是无限大。（默认值： 8 。）
>    *  spring.redis.pool.max-wait</br>
>     当连接池被耗尽时，分配连接的请求应该在抛出异常前被阻塞多长时间（单位为秒）。负数表示一直阻塞。（默认值： -1 。）
>    *  spring.redis.pool.min-idle</br>
>     连接池里要维持的最小空闲连接数。该属性只有在设置为正数时才有效。（默认值： 0 。）
>    *  spring.redis.port</br>
>     Redis服务器端口。（默认值： 6379 。）
>    *  spring.redis.sentinel.master</br>
>     Redis服务器的名字。
>    *  spring.redis.sentinel.nodes</br>
>     形如“主机:端口”配对的列表，用逗号分隔。
>    *  spring.redis.timeout</br>
>     连接超时时间，单位为秒。（默认值： 0 。）

 <p id= "resources">
                
> *  resources
>    *  spring.resources.add-mappings</br>
>     开启默认资源处理。（默认值： true 。）
>    *  spring.resources.cache-period</br>
>     资源处理器对资源的缓存周期，单位为秒。
>    *  spring.resources.chain.cache</br>
>     对资源链开启缓存。（默认值： true 。）
>    *  spring.resources.chain.enabled</br>
>     开启Spring资源处理链。（默认关闭的，除非至少开启了一个策略。）
>    *  spring.resources.chain.html-application-cache</br>
>     开启HTML5应用程序缓存证明重写。（默认值： false 。）
>    *  spring.resources.chain.strategy.content.enabled</br>
>     开启内容版本策略。（默认值： false 。）
>    *  spring.resources.chain.strategy.content.paths</br>
>     要运用于版本策略的模式列表，用逗号分隔。（默认值： [/**] 。）
>    *  spring.resources.chain.strategy.fixed.enabled</br>
>     开启固定版本策略。（默认值： false 。）
>    *  spring.resources.chain.strategy.fixed.paths</br>
>     要运用于固定版本策略的模式列表，用逗号分隔。
>    *  spring.resources.chain.strategy.fixed.version</br>
>     用于固定版本策略的版本字符串。
>    *  spring.resources.static-locations</br>
>     静态资源位置。默认为 classpath: [/META-INF/resources/, /resources/, /static/,/public/] 加上context:/（Servlet上下文的根目录）。
  
 <p id= "sendgrid">
                
> *  sendgrid 
>    *  spring.sendgrid.password</br>
>     SendGrid密码。
>    *  spring.sendgrid.proxy.host</br>
>     SendGrid代理主机地址。
>    *  spring.sendgrid.proxy.port</br>
>     SendGrid代理端口。
>    *  spring.sendgrid.username</br>
>     SendGrid用户名。

 <p id= "social">
                
> *  social
>    *  spring.social.auto-connection-views</br>
>     针对所支持的提供方开启连接状态视图。（默认值： false 。）
>    *  spring.social.facebook.app-id</br>
>     应用程序ID。
>    *  spring.social.facebook.app-secret</br>
>     应用程序的密钥。
>    *  spring.social.linkedin.app-id</br>
>     应用程序ID。
>    *  spring.social.linkedin.app-secret</br>
>     应用程序的密钥。
>    *  spring.social.twitter.app-id</br>
>     应用程序ID。
>    *  spring.social.twitter.app-secret</br>
>     应用程序的密钥。

 <p id= "thymeleaf">
                
> *  thymeleaf
>    *  spring.thymeleaf.cache</br>
>     开启模板缓存。（默认值： true 。）
>    *  spring.thymeleaf.check-template-location</br>
>     检查模板位置是否存在。（默认值： true 。）
>    *  spring.thymeleaf.content-type</br>
>     Content-Type 的值。（默认值： text/html 。）
>    *  spring.thymeleaf.enabled</br>
>     开启MVC Thymeleaf视图解析。（默认值： true 。）
>    *  spring.thymeleaf.encoding</br>
>     模板编码。（默认值： UTF-8 。）
>    *  spring.thymeleaf.excluded-view-names</br>
>     要被排除在解析之外的视图名称列表，用逗号分隔。
>    *  spring.thymeleaf.mode</br>
>     要运用于模板之上的模板模式。另见 StandardTemplate- ModeHandlers 。（默认值：HTML5 。）
>    *  spring.thymeleaf.prefix</br>
>     在构建URL时添加到视图名称前的前缀。（默认值： classpath:/templates/ 。）
>    *  spring.thymeleaf.suffix</br>
>     在构建URL时添加到视图名称后的后缀。（默认值： .html 。）
>    *  spring.thymeleaf.template-resolver-order</br>
>     Thymeleaf模板解析器在解析器链中的顺序。默认情况下，它排在第一位。顺序从1开始，只有在定义了额外的 TemplateResolver Bean时才需要设置这个属性。
>    *  spring.thymeleaf.view-names</br>
>     可解析的视图名称列表，用逗号分隔。

  <p id= "velocity">
                 
> *  velocity  
>    *  spring.velocity.allow-request-override</br>
>     HttpServletRequest 的属性是否允许覆盖（隐藏）控制器生成的同名模型属性。
>    *  spring.velocity.allow-session-override</br>
>     HttpSession 的属性是否允许覆盖（隐藏）控制器生成的同名模型属性。
>    *  spring.velocity.cache</br>
>     开启模板缓存。
>    *  spring.velocity.charset</br>
>     模板编码。
>    *  spring.velocity.check-template-location</br>
>     检查模板位置是否存在。
>    *  spring.velocity.content-type</br>
>     Content-Type 的值。
>    *  spring.velocity.date-tool-attribute</br>
>     DateTool 辅助对象在视图的Velocity上下文里呈现的名字。
>    *  spring.velocity.enabled</br>
>     开启Velocity的MVC视图解析。
>    *  spring.velocity.expose-request-attributes</br>
>     在模型合并到模板前，是否要把所有的请求属性添加到模型里。
>    *  spring.velocity.expose-session-attributes</br>
>     在模型合并到模板前，是否要把所有的 HttpSession 属性添加到模型里。
>    *  spring.velocity.expose-spring-macro-helpers</br>
>     是否发布供Spring宏程序库使用的 RequestContext ，并将其名命为 springMacro-RequestContext 。
>    *  spring.velocity.number-tool-attribute</br>
>     NumberTool 辅助对象在视图的Velocity上下文里呈现的名字。
>    *  spring.velocity.prefer-file-system-access</br>
>     加载模板时优先通过文件系统访问。文件系统访问能够实时检测到模板变更。（默认值：true 。）
>    *  spring.velocity.prefix</br>
>     在构建URL时添加到视图名称前的前缀。
>    *  spring.velocity.properties</br>
>     额外的Velocity属性。
>    *  spring.velocity.request-context-attribute</br>
>     所有视图里使用的 Request- Context 属性的名称。
>    *  spring.velocity.resource-loader-path</br>
>     模板路径。（默认值： classpath:/ templates/ 。）
>    *  spring.velocity.suffix</br>
>     在构建URL时添加到视图名称后的后缀。
>    *  spring.velocity.toolbox-config-location</br>
>     Velocity Toolbox的配置位置，比如/WEB-INF/toolbox.xml。自动加载Velocity Tools工具定义文件，将所定义的全部工具发布到指定的作用域内。
>    *  spring.velocity.view-names</br>
>     可解析的视图名称白名单。

  <p id= "view">
                 
> *  view
>    *  spring.view.prefix</br>
>     Spring MVC视图前缀。
>    *  spring.view.suffix</br>
>     Spring MVC视图后缀。 
>    *  spring.autoconfigure.exclude</br>
>       要排除的自动配置类。
>    *  spring.dao.exceptiontranslation.enabled</br>
>       打开 PersistenceExceptionTranslationPostProcessor 。（默认值： true 。）
>    *  spring.jooq.sql-dialect</br>
>       在与配置的数据源通信时，JOOQ使用的 SQLDialect ，比如 POSTGRES 。
