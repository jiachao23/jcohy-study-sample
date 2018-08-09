#### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	
> #### PS:待开发中。。。。

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

> #### PS:我的学习笔记,点击可以跳转到相应分类

## SpringBoot的自定义配置


### 覆盖Springboot的自动配置

>  * 添加Security起步依赖
        
        Gradle:
        compile("org.springframework.boot:spring-boot-starter-security")
        Maven
        <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
>  * 编写一个SecurityConfig类，继承WebSecurityConfigurerAdapter类，并实现他的两个Configure()方法。

        
        @Configuration
        public class SecurityConfig extends WebSecurityConfigurerAdapter {
        
          @Autowired
          private ReaderRepository readerRepository;
          
          @Override
          protected void configure(HttpSecurity http) throws Exception {
            http
              .authorizeRequests()
                .antMatchers("/").access("hasRole('READER')")
                .antMatchers("/**").permitAll()
              .and()
              .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true");
          }
          
          @Override
          protected void configure(
                      AuthenticationManagerBuilder auth) throws Exception {
            auth
              .userDetailsService(new UserDetailsService() {
                @Override
                public UserDetails loadUserByUsername(String username)
                    throws UsernameNotFoundException {
                  UserDetails userDetails = readerRepository.findOne(username);
                  if (userDetails != null) {
                    return userDetails;
                  }
                  throw new UsernameNotFoundException("User '" + username + "' not found.");
                }
              });
          }
        
        }
>           在 SecurityConfig 里，第一个 configure() 方法指明，“/”（ ReadingListController
>     的方法映射到了该路径）的请求只有经过身份认证且拥有READER角色的用户才能访问。其他的
>     所有请求路径向所有用户开放了访问权限。这里还将登录页和登录失败页（带有一个 error 属性）
>     指定到了/login。

>           Spring Security为身份认证提供了众多选项，后端可以是JDBC（Java Database Connectivity）、
>      LDAP和内存用户存储。在这个应用程序中，我们会通过JPA用数据库来存储用户信息。第二个
>      configure() 方法设置了一个自定义的 UserDetailsService ，这个服务可以是任意实现了
>      UserDetailsService 的类，用于查找指定用户名的用户。下面的类提供了一个匿名内部类
>      实现，简单地调用了注入 ReaderRepository （这是一个Spring Data JPA仓库接口）的 findOne()
>      方法。

            
                import org.springframework.data.jpa.repository.JpaRepository;
                
                
                public interface ReaderRepository   extends JpaRepository<Reader, String> {
                   }
 >  *  Springboot自定义配置的原理（ @ConditionalOnMissingBean 注解是覆盖自动配置的关键。）
 
>  关于Spring Security，自动配置会考虑几个配置类。在这里讨论每个配置类的细节是不切实际的，但覆盖Spring Boot自动配置的安全配置时，最重要的一个类是 SpringBootWebSecurity-
Configuration 。以下是其中的一个代码片段：

                @Configuration
                @EnableConfigurationProperties
                @ConditionalOnClass({ EnableWebSecurity.class })
                @ConditionalOnMissingBean(WebSecurityConfiguration.class)
                @ConditionalOnWebApplication
                public class SpringBootWebSecurityConfiguration {
                ...
                }
                
>   SpringBootWebSecurityConfiguration 上加了好几个注解。看到 @Condi-tionalOnClass 注解后，你就应该知道Classpath里必须要有 @EnableWebSecurity 注解。
@ConditionalOnWebApplication 说明这必须是个Web应用程序 。 @ConditionalOn-MissingBean 注解才是我们的安全配置类代替 SpringBootWebSecurityConfiguration 的关
键所在。</br>
>  @ConditionalOnMissingBean 注解要求当下没有 WebSecurityConfiguration 类型的Bean。虽然表面上我们并没有这么一个Bean，但通过在 SecurityConfig 上添加 @EnableWeb-Security 注解，我们实际上间接创建了一个 WebSecurityConfiguration Bean。所以在自动
配置时，这个Bean就已经存在了，  @ConditionalOnMissingBean 条件不成立， SpringBoot-WebSecurityConfiguration 提供的配置就被跳过了。
 
 ### 通过属性文件配置。
 
>  Spring Boot应用程序有多种设置途径。Spring Boot能从多种属性源获得属性，包括如下几处。
>  *  (1) 命令行参数
>  *  (2)  java:comp/env 里的JNDI属性
>  *  (3) JVM系统属性
>  *  (4) 操作系统环境变量
>  *  (5) 随机生成的带 random.* 前缀的属性（在设置其他属性时，可以引用它们，比如 ${random.long} ）
>  *  (6) 应用程序以外的application.properties或者appliaction.yml文件
>  *  (7) 打包在应用程序内的application.properties或者appliaction.yml文件
>  *  (8) 通过 @PropertySource 标注的属性源
>  *  (9) 默认属性
>  *  这个列表按照优先级排序，也就是说，任何在高优先级属性源里设置的属性都会覆盖低优先 级的相同属性。例如，命令行参数会覆盖其他属性源里的属性。application.properties和application.yml文件能放在以下四个位置。
>    *  (1) 外置，在相对于应用程序运行目录的/config子目录里。
>    *  (2) 外置，在应用程序运行的目录里。
>    *  (3) 内置，在config包内。
>    *  (4) 内置，在Classpath根目录。
>  *  同样，这个列表按照优先级排序。也就是说，/config子目录里的application.properties会覆盖
>  *  应用程序Classpath里的application.properties中的相同属性。
>  *  此外，如果你在同一优先级位置同时有application.properties和application.yml，那么application. yml里的属性会覆盖application.properties里的属性。
>  *  禁用ascii-art Banner只是使用属性的一个小例子。让我们再看几个例子，看看如何通过常用途径微调自动配置的Bean。