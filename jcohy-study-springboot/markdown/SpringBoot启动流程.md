### 构造SpringApplication对象，调用initialize()方法

当Springboot启动后，首先调用run方法。构造一个SpringApplication对象，使用默认设置和用户提供的参数加载配置。如下：

```java
/**
 * Static helper that can be used to run a {@link SpringApplication} from the
 * specified sources using default settings and user supplied arguments.
 * @param sources the sources to load
 * @param args the application arguments (usually passed from a Java main method)
 * @return the running {@link ApplicationContext}
 */
public static ConfigurableApplicationContext run(Object[] sources, String[] args) {
   return new SpringApplication(sources).run(args);
}
```

```java
public SpringApplication(Object... sources) {
   initialize(sources);
}
```

### 一：我们主要看分析**initialize()**方法都做了那些事？

```java
private void initialize(Object[] sources) {
    //初始化source（此为我们传进去的参数）
   if (sources != null && sources.length > 0) {
      this.sources.addAll(Arrays.asList(sources));
   }
    /**
	 * 判断是否为web环境。
	 * 是通过在classpath中查看是否存在WEB_ENVIRONMENT_CLASSES这个数组中所包含的类，如果存在那么当前程序即是一个Web应用程序，反之则不然。
	 * 	private static final String[] WEB_ENVIRONMENT_CLASSES = { "javax.servlet.Servlet",
			"org.springframework.web.context.ConfigurableWebApplicationContext" };
	 */
   this.webEnvironment = deduceWebEnvironment();
    //为成员变量initializers赋值，//加载工厂实现的完全限定类名，从META-INF/spring.factories文件中加载key为org.springframework.context.ApplicationContextInitializer的工厂类名，并创建实例
   setInitializers((Collection) getSpringFactoriesInstances(
         ApplicationContextInitializer.class));
    ////为成员变量listeners赋值，加载工厂实现的完全限定类名，从META-INF/spring.factories文件中加载key为org.springframework.context.ApplicationListener的工厂类名，并创建实例
   setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
   this.mainApplicationClass = deduceMainApplicationClass();
}
```

#### 1、配置source。

#### 2、判断是否是web环境。

```java

private static final String[] WEB_ENVIRONMENT_CLASSES = { "javax.servlet.Servlet",
			"org.springframework.web.context.ConfigurableWebApplicationContext" };
private boolean deduceWebEnvironment() {
   for (String className : WEB_ENVIRONMENT_CLASSES) {
      if (!ClassUtils.isPresent(className, null)) {
         return false;
      }
   }
   return true;
}
```

#### 3、查找并加载所有可用的 ApplicationContextInitializer

initializers成员变量，是一个ApplicationContextInitializer类型对象的集合。 顾名思义，ApplicationContextInitializer是一个可以用来初始化ApplicationContext的接口。`getSpringFactoriesInstances` 请留意此方法，下面多出会使用到此方法。

```java
private <T> Collection<? extends T> getSpringFactoriesInstances(Class<T> type,
      Class<?>[] parameterTypes, Object... args) {
   ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
   // 防止名称重复
   Set<String> names = new LinkedHashSet<String>(
       	//加载工厂实现的完全限定类名，从META-INF/spring.factories文件中加载key为org.springframework.context.ApplicationContextInitializer的工厂类名
         SpringFactoriesLoader.loadFactoryNames(type, classLoader));
    	//创建工厂实例
   List<T> instances = createSpringFactoriesInstances(type, parameterTypes,
         classLoader, args, names);
   AnnotationAwareOrderComparator.sort(instances);
   return instances;
}
```

我们看看 `SpringFactoriesLoader.loadFactoryNames(type, classLoader));` 中的代码：

```java
public static final String FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories";

public static List<String> loadFactoryNames(Class<?> factoryClass, ClassLoader classLoader) {
    //factoryClassName = org.springframework.context.ApplicationContextInitializer
   String factoryClassName = factoryClass.getName();
   try {
      //FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories"
      Enumeration<URL> urls = (classLoader != null ? classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
            ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));
      List<String> result = new ArrayList<String>();
      while (urls.hasMoreElements()) {
         URL url = urls.nextElement();
         Properties properties = PropertiesLoaderUtils.loadProperties(new UrlResource(url));
         String factoryClassNames = properties.getProperty(factoryClassName);
         result.addAll(Arrays.asList(StringUtils.commaDelimitedListToStringArray(factoryClassNames)));
      }
      return result;
   }
   catch (IOException ex) {
      throw new IllegalArgumentException("Unable to load [" + factoryClass.getName() +
            "] factories from location [" + FACTORIES_RESOURCE_LOCATION + "]", ex);
   }
}
```

#### 4、查找并加载所有可用的 ApplicationListener
同理此类的全限定类名为 `org.springframework.context.ApplicationListener`。从`META-INF/spring.factories`文件中加载key为`org.springframework.context.ApplicationContextInitializer`的工厂类名：

```java
setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
```

#### 5、推断并设置main方法的定义类。

```java
private Class<?> deduceMainApplicationClass() {
   try {
      StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
      for (StackTraceElement stackTraceElement : stackTrace) {
         if ("main".equals(stackTraceElement.getMethodName())) {
            return Class.forName(stackTraceElement.getClassName());
         }
      }
   }
   catch (ClassNotFoundException ex) {
      // Swallow and continue
   }
   return null;
}
```

### 二、初始化完成后，开始执行run方法

```java
public ConfigurableApplicationContext run(String... args) {
    //简单的秒表，允许多个任务的计时，公开每个命名任务的总运行时间和运行时间。
   StopWatch stopWatch = new StopWatch();
   stopWatch.start();
   ConfigurableApplicationContext context = null;
   FailureAnalyzers analyzers = null;
   //1、开启打印
   configureHeadlessProperty();
    //2、加载，创建SpringApplicationRunListener实例
   SpringApplicationRunListeners listeners = getRunListeners(args);
    //首次启动run方法时立即调用.
   listeners.starting();
   try {
       //3、封装命令行参数
      ApplicationArguments applicationArguments = new DefaultApplicationArguments(
            args);
       //4、环境准备，封装环境变量信息。如果为web环境，则创建StandardServletEnvironment。否则创建StandardEnvironment
      ConfigurableEnvironment environment = prepareEnvironment(listeners,
            applicationArguments);
       //5、打印banner
      Banner printedBanner = printBanner(environment);
       //6、创建上下文，org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext
      context = createApplicationContext();
       //7、创建故障分析器FailureAnalyzers，处理在Spring-boot启动的时候出现的异常
      analyzers = new FailureAnalyzers(context);
       //8.准备上下文
      prepareContext(context, environment, listeners, applicationArguments,
            printedBanner);
       //9、刷新上下文
      refreshContext(context);
       // 10、执行刷新后操作
      afterRefresh(context, applicationArguments);
       // 11、通知容器完成事件
      listeners.finished(context, null);
      stopWatch.stop();
      if (this.logStartupInfo) {
         new StartupInfoLogger(this.mainApplicationClass)
               .logStarted(getApplicationLog(), stopWatch);
      }
      return context;
   }
   catch (Throwable ex) {
      handleRunFailure(context, listeners, analyzers, ex);
      throw new IllegalStateException(ex);
   }
}
```

#### 1、开启屏幕打印。

```java
private static final String SYSTEM_PROPERTY_JAVA_AWT_HEADLESS = "java.awt.headless";
private void configureHeadlessProperty() {
   System.setProperty(SYSTEM_PROPERTY_JAVA_AWT_HEADLESS, System.getProperty(
         SYSTEM_PROPERTY_JAVA_AWT_HEADLESS, Boolean.toString(this.headless)));
}
```
#### 2、获取启动时的监听器

当触发启动事件，相应的监听器会被调用。其加载机制原理和加载 ApplicationContextInitializer与ApplicationListener 原理一样。只不过它是从classpath下面查找名为 `org.springframework.boot.SpringApplicationRunListener`  的类加载并实例化。

```java
private SpringApplicationRunListeners getRunListeners(String[] args) {
   Class<?>[] types = new Class<?>[] { SpringApplication.class, String[].class };
   return new SpringApplicationRunListeners(logger, getSpringFactoriesInstances(
         SpringApplicationRunListener.class, types, this, args));
}
```

这里简单说明一下，在 `META-INF/spring.factories` 文件中，只有一个此类的实现为：

```xml
org.springframework.boot.SpringApplicationRunListener=\
org.springframework.boot.context.event.EventPublishingRunListener
```

说的再简单点，getRunListeners就是准备好了运行时监听器`EventPublishingRunListener`。

当执行 `listeners#starting()` 时，我们看看发生了什么。

```java
public void starting() {
   this.initialMulticaster
         .multicastEvent(new ApplicationStartedEvent(this.application, this.args));
}
```

其构建了一个ApplicationStartingEvent事件，并将其发布出去。

```java
@Override
public void multicastEvent(final ApplicationEvent event, ResolvableType eventType) {
   ResolvableType type = (eventType != null ? eventType : resolveDefaultEventType(event));
    //getApplicationListeners(event, type)：根据其注释可知，该方法作用：返回与给定事件类型匹配的ApplicationListeners集合，非匹配的侦听器会被提前排除；允许根据缓存的匹配结果来返回。
   for (final ApplicationListener<?> listener : getApplicationListeners(event, type)) {
      Executor executor = getTaskExecutor();
      if (executor != null) {
         executor.execute(new Runnable() {
            @Override
            public void run() {
               invokeListener(listener, event);
            }
         });
      }
      else {
         invokeListener(listener, event);
      }
   }
}
```

`getApplicationListeners`方法过滤出的监听器都会被调用，过滤出来的监听器包括`LoggingApplicationListener、BackgroundPreinitializer、DelegatingApplicationListener、LiquibaseServiceLocatorApplicationListener、EnableEncryptablePropertiesBeanFactoryPostProcessor`五种类型的对象。当执行`invokeListener`方法时，这五个对象的onApplicationEvent都会被调用。

#### 3、封装命令行参数

```java
ApplicationArguments applicationArguments = new DefaultApplicationArguments(
      args);
```

#### 4、环境准备

如果为web环境，则创建StandardServletEnvironment。否则创建StandardEnvironment

```java
private ConfigurableEnvironment prepareEnvironment(
      SpringApplicationRunListeners listeners,
      ApplicationArguments applicationArguments) {
   // 创建并配置环境
   ConfigurableEnvironment environment = getOrCreateEnvironment();
   configureEnvironment(environment, applicationArguments.getSourceArgs());
   listeners.environmentPrepared(environment);
   if (!this.webEnvironment) {
      environment = new EnvironmentConverter(getClassLoader())
            .convertToStandardEnvironmentIfNecessary(environment);
   }
   return environment;
}
```

```java
private ConfigurableEnvironment getOrCreateEnvironment() {
   if (this.environment != null) {
      return this.environment;
   }
   if (this.webEnvironment) {
      return new StandardServletEnvironment();
   }
   return new StandardEnvironment();
}
```

#### 5、打印banner

到此为止，控制台上终于有输出了、就是打印SpringBoot默认的banner。默认从classpath：下加载名为 banner.txt 的文件。如果不存在。则打印默认banner。此实现在 `SpringBootBanner` 类中。下面贴出相关代码：

```java
//默认为Banner.Mode.CONSOLE;
private Banner.Mode bannerMode = Banner.Mode.CONSOLE;

private Banner printBanner(ConfigurableEnvironment environment) {
   if (this.bannerMode == Banner.Mode.OFF) {
      return null;
   }
    //如果不存在资源文件加载器，则创建默认加载器。
   ResourceLoader resourceLoader = this.resourceLoader != null ? this.resourceLoader
         : new DefaultResourceLoader(getClassLoader());
    //创建SpringApplicationBannerPrinter对象，此对象有一个Banner接口的引用
   SpringApplicationBannerPrinter bannerPrinter = new SpringApplicationBannerPrinter(
         resourceLoader, this.banner);
   if (this.bannerMode == Mode.LOG) {
      return bannerPrinter.print(environment, this.mainApplicationClass, logger);
   }
   return bannerPrinter.print(environment, this.mainApplicationClass, System.out);
}
```
SpringApplicationBannerPrinter.print

```java
public Banner print(Environment environment, Class<?> sourceClass, PrintStream out) {
    Banner banner = getBanner(environment, this.fallbackBanner);
    //此方法会调用banner具体实现类的printBanner方法输出banner。
    banner.printBanner(environment, sourceClass, out);
    return new PrintedBanner(banner, sourceClass);
}
```


```java

static final String BANNER_LOCATION_PROPERTY = "banner.location";

static final String BANNER_IMAGE_LOCATION_PROPERTY = "banner.image.location";

static final String DEFAULT_BANNER_LOCATION = "banner.txt";

static final String[] IMAGE_EXTENSION = { "gif", "jpg", "png" };

private static final Banner DEFAULT_BANNER = new SpringBootBanner();

private Banner getBanner(Environment environment, Banner definedBanner) {
    Banners banners = new Banners();
    //获取图片banner
    banners.addIfNotNull(getImageBanner(environment));
    //获取文字banner
    banners.addIfNotNull(getTextBanner(environment));
    if (banners.hasAtLeastOneBanner()) {
        return banners;
    }
    if (this.fallbackBanner != null) {
        return this.fallbackBanner;
    }
    return DEFAULT_BANNER;
}


private Banner getImageBanner(Environment environment) {
    
    String location = environment.getProperty(BANNER_IMAGE_LOCATION_PROPERTY);
    if (StringUtils.hasLength(location)) {
        Resource resource = this.resourceLoader.getResource(location);
        return (resource.exists() ? new ImageBanner(resource) : null);
    }
    for (String ext : IMAGE_EXTENSION) {
        Resource resource = this.resourceLoader.getResource("banner." + ext);
        if (resource.exists()) {
            return new ImageBanner(resource);
        }
    }
    return null;
}
private Banner getTextBanner(Environment environment) {
    String location = environment.getProperty(BANNER_LOCATION_PROPERTY,
                                              DEFAULT_BANNER_LOCATION);
    Resource resource = this.resourceLoader.getResource(location);
    if (resource.exists()) {
        return new ResourceBanner(resource);
    }
    return null;
}
```




```java
class SpringBootBanner implements Banner {

   private static final String[] BANNER = { "",
         "  .   ____          _            __ _ _",
         " /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\",
         "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\",
         " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )",
         "  '  |____| .__|_| |_|_| |_\\__, | / / / /",
         " =========|_|==============|___/=/_/_/_/" };

   private static final String SPRING_BOOT = " :: Spring Boot :: ";

   private static final int STRAP_LINE_SIZE = 42;

   @Override
   public void printBanner(Environment environment, Class<?> sourceClass,
         PrintStream printStream) {
      for (String line : BANNER) {
         printStream.println(line);
      }
      String version = SpringBootVersion.getVersion();
      version = (version == null ? "" : " (v" + version + ")");
      String padding = "";
      while (padding.length() < STRAP_LINE_SIZE
            - (version.length() + SPRING_BOOT.length())) {
         padding += " ";
      }

      printStream.println(AnsiOutput.toString(AnsiColor.GREEN, SPRING_BOOT,
            AnsiColor.DEFAULT, padding, AnsiStyle.FAINT, version));
      printStream.println();
   }

}
```

#### 6、创建上下文

根据当前的环境是否是web环境，决定 `AnnotationConfigEmbeddedWebApplicationContext` 还是`AnnotationConfigApplicationContext` 容器。
```java
//创建上下文创建
public static final String DEFAULT_WEB_CONTEXT_CLASS = "org.springframework."
    + "boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext";

public static final String DEFAULT_CONTEXT_CLASS = "org.springframework.context."
    + "annotation.AnnotationConfigApplicationContext";
protected ConfigurableApplicationContext createApplicationContext() {
    Class<?> contextClass = this.applicationContextClass;
    if (contextClass == null) {
        try {
            contextClass = Class.forName(this.webEnvironment
                                         ? DEFAULT_WEB_CONTEXT_CLASS : DEFAULT_CONTEXT_CLASS);
        }
        catch (ClassNotFoundException ex) {
            throw new IllegalStateException(
                "Unable create a default ApplicationContext, "
                + "please specify an ApplicationContextClass",
                ex);
        }
    }
    return (ConfigurableApplicationContext) BeanUtils.instantiate(contextClass);
}
```


我们可以看到这两个类的继承关系，如下：

![1552956370104](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-springboot/images/AnnotationConfigEmbeddedWebApplicationContext.png)

![1552956607029](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-springboot/images/AnnotationConfigApplicationContext.png)

- GenericWebApplicationContext继承了GenericApplicationContext实现了ConfigurableWebApplicationContext接口 我们看一下这个接口，主要提供了web容器也就是servlet容器的相关操作。
- 再看AnnotationConfigEmbeddedWebApplicationContext 容器重写AbstractApplicationContext的模板方法,在同期中提供了WebApplicationContextServletContextAwareProcessor的处理器，提供了容器注入的功能。
- 其他功能基本上和 `AnnotationConfigApplicationContext` 类似。

下面我们以web环境下创建的 `AnnotationConfigEmbeddedWebApplicationContext` 分析，看看SpringBoot

为我们做了哪些事情。好了，我们就从 `AnnotationConfigEmbeddedWebApplicationContext` 开始。


```java
/**
 * Create a new {@link AnnotationConfigEmbeddedWebApplicationContext} that needs to be
 * populated through {@link #register} calls and then manually {@linkplain #refresh
 * refreshed}.
 * 注册所有注解相关的处理器
 * 配置扫描路径下的特定注解
 */
public AnnotationConfigEmbeddedWebApplicationContext() {
   this.reader = new AnnotatedBeanDefinitionReader(this);
   this.scanner = new ClassPathBeanDefinitionScanner(this);
}
```

AnnotatedBeanDefinitionReader：用来处理所有注解相关的类。这是 `ClassPathBeanDefinitionScanner` 的替代方案，两者作用相同，但仅适用于需要明确注册的类。

ClassPathBeanDefinitionScanner：配置扫描路径下的特定注解，@Component，@Repository， @Service，@Controller。还支持Java EE 6的 {@link javax.annotation.ManagedBean} 和 JSR-330's {@link javax.inject.Named} 的注解。

#### 7、加载故障分析器FailureAnalyzers

加载故障分析器，处理在Spring-boot启动的时候出现的异常。这里也用到了 `SpringFactoriesLoader.loadFactoryNames(type, classLoader)`方法。默认从 `META-INF/spring.factories` 文件中加载 key 为 `org.springframework.boot.diagnostics.FailureAnalyzer` 的工厂类名：

```
SpringFactoriesLoader
      .loadFactoryNames(FailureAnalyzer.class, classLoader)
```

默认有这几种：

```xml
org.springframework.boot.diagnostics.FailureAnalyzer=\
org.springframework.boot.diagnostics.analyzer.BeanCurrentlyInCreationFailureAnalyzer,\
org.springframework.boot.diagnostics.analyzer.BeanNotOfRequiredTypeFailureAnalyzer,\
org.springframework.boot.diagnostics.analyzer.BindFailureAnalyzer,\
org.springframework.boot.diagnostics.analyzer.ConnectorStartFailureAnalyzer,\
org.springframework.boot.diagnostics.analyzer.NoUniqueBeanDefinitionFailureAnalyzer,\
org.springframework.boot.diagnostics.analyzer.PortInUseFailureAnalyzer,\
org.springframework.boot.diagnostics.analyzer.ValidationExceptionFailureAnalyzer
```

#### 8、准备上下文
上下文创建成功后,执行上下文的准备工作,完成环境变量设置,设置resourceLoader,设置resourceLoader 加载器，应用初始化器,通知容器就绪事件,加载配置资源,执行load,将所有通过注解,扫描,以及配置文件方式定义的Bean都注册到上下文中去,各种类型的Bean的解析加载过程使用BeanDefinitionLoader来完成，依赖AnnotatedBeanDefinitionReader，ClassPathBeanDefinitionScanner完成Bean扫描和注解的Bean读取。load完成后所有配置的Bean被注册到上下文中。接下来通知load完成事件。
```java
//准备上下文
private void prepareContext(ConfigurableApplicationContext context,
    ConfigurableEnvironment environment, SpringApplicationRunListeners listeners,
      ApplicationArguments applicationArguments, Banner printedBanner) {
    //传递环境变量
   context.setEnvironment(environment);
    //添加容器后置处理器
   postProcessApplicationContext(context);
    //应用初始化
   applyInitializers(context);
    //通知容器就绪事件
   listeners.contextPrepared(context);
   if (this.logStartupInfo) {
      logStartupInfo(context.getParent() == null);
      logStartupProfileInfo(context);
   }
	
   // 注册SpringBoot专用的Bean对象
   context.getBeanFactory().registerSingleton("springApplicationArguments",
         applicationArguments);
   if (printedBanner != null) {
      context.getBeanFactory().registerSingleton("springBootBanner", printedBanner);
   }

   // Load the sources。加载资源
   Set<Object> sources = getSources();
   Assert.notEmpty(sources, "Sources must not be empty");
   load(context, sources.toArray(new Object[sources.size()]));
   listeners.contextLoaded(context);
}
```

```java
protected void load(ApplicationContext context, Object[] sources) {
   if (logger.isDebugEnabled()) {
      logger.debug(
            "Loading source " + StringUtils.arrayToCommaDelimitedString(sources));
   }
    //创建BeanDefinitionLoader对象,并设置了Bean的名称生成器，资源加载器，环境变量信息，。加载资源到Reader中。
   BeanDefinitionLoader loader = createBeanDefinitionLoader(
         getBeanDefinitionRegistry(context), sources);
   if (this.beanNameGenerator != null) {
      loader.setBeanNameGenerator(this.beanNameGenerator);
   }
   if (this.resourceLoader != null) {
      loader.setResourceLoader(this.resourceLoader);
   }
   if (this.environment != null) {
      loader.setEnvironment(this.environment);
   }
   loader.load();
}
```

```java
/**
 * Create a new {@link BeanDefinitionLoader} that will load beans into the specified
 * {@link BeanDefinitionRegistry}.
 * @param registry the bean definition registry that will contain the loaded beans
 * @param sources the bean sources
 */
BeanDefinitionLoader(BeanDefinitionRegistry registry, Object... sources) {
   Assert.notNull(registry, "Registry must not be null");
   Assert.notEmpty(sources, "Sources must not be empty");
   this.sources = sources;
   this.annotatedReader = new AnnotatedBeanDefinitionReader(registry);
   this.xmlReader = new XmlBeanDefinitionReader(registry);
   if (isGroovyPresent()) {
      this.groovyReader = new GroovyBeanDefinitionReader(registry);
   }
   this.scanner = new ClassPathBeanDefinitionScanner(registry);
   this.scanner.addExcludeFilter(new ClassExcludeFilter(sources));
}
```

#### 9、刷新

这个阶段调用了父类的refresh[AbstractApplicationContext定义的工厂方法]执行容器的刷新操作，是整个上下文启动的核心阶段。

```java
private void refreshContext(ConfigurableApplicationContext context) {
   refresh(context);
   if (this.registerShutdownHook) {
      try {
      	//容器解析完成，注册容器JVM钩子事件。
         context.registerShutdownHook();
      }
      catch (AccessControlException ex) {
         // Not allowed in some environments.
      }
   }
}
```
AbstractApplicationContext#refresh
```java
@Override
public void refresh() throws BeansException, IllegalStateException {
   synchronized (this.startupShutdownMonitor) {
      // 9.1 刷新回调必要的初始化和验证
      prepareRefresh();

      // 9.2 刷新所有BeanFactory子容器
      ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

      // 9.3 创建BeanFactory
      prepareBeanFactory(beanFactory);

      try {
         // 9.4 注册实现了BeanPostProcessor接口的bean。
         postProcessBeanFactory(beanFactory);

         // 9.5 初始化和执行BeanFactoryPostProcessor beans
         invokeBeanFactoryPostProcessors(beanFactory);

         // 9.6 初始化和执行BeanPostProcessor beans
         registerBeanPostProcessors(beanFactory);

         // 9.7 初始化消息资源，各种国际化资源
         initMessageSource();

         // 9.8 初始化Event Multicaster
         initApplicationEventMulticaster();

         // 9.9 刷新由子类实现的方法。
         onRefresh();

         // 9.10 检查并注册监听器
         registerListeners();

         // 9.11 实例化所有剩余（非延迟初始化）单例。
         finishBeanFactoryInitialization(beanFactory);

         // 9.12 最后一步：发布相应的事件。
         finishRefresh();
      }

      catch (BeansException ex) {
         if (logger.isWarnEnabled()) {
            logger.warn("Exception encountered during context initialization - " +
                  "cancelling refresh attempt: " + ex);
         }

         // Destroy already created singletons to avoid dangling resources.
         destroyBeans();

         // Reset 'active' flag.
         cancelRefresh(ex);

         // Propagate exception to caller.
         throw ex;
      }

      finally {
         // 重置Spring核心中常见的内省缓存，因为我们可能再也不需要单例bean的元数据......
         resetCommonCaches();
      }
   }
}
```
##### 9.1、 刷新前准备

执行prepareRefresh执行刷新前的准备工作,更新上下文状态,初始化所有属性资源，验证必须的配置文件。

```java
protected void prepareRefresh() {
    this.startupDate = System.currentTimeMillis();
    //指示此上下文是否已关闭的标志
    this.closed.set(false);
    //指示此上下文当前是否处于活动状态的标志
    this.active.set(true);

    if (logger.isInfoEnabled()) {
        logger.info("Refreshing " + this);
    }

    // 在上下文环境中初始化任何占位符属性源
    initPropertySources();

    // 验证标记为必需的所有属性是否可解析
    // //请参阅 ConfigurablePropertyResolver#setRequiredProperties
    getEnvironment().validateRequiredProperties();

    // 允许收集早期的ApplicationEvents，在多播器可用时发布...
    this.earlyApplicationEvents = new LinkedHashSet<ApplicationEvent>();
}
```

##### 9.2、刷新所有BeanFactory子容器

```java
/**
 * Tell the subclass to refresh the internal bean factory.
 * @return the fresh BeanFactory instance
 * @see #refreshBeanFactory()
 * @see #getBeanFactory()
 */
protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
   refreshBeanFactory();
   ConfigurableListableBeanFactory beanFactory = getBeanFactory();
   if (logger.isDebugEnabled()) {
      logger.debug("Bean factory for " + getDisplayName() + ": " + beanFactory);
   }
   return beanFactory;
}
```

```java
/**
 * Do nothing: We hold a single internal BeanFactory and rely on callers
 * to register beans through our public methods (or the BeanFactory's).
 * @see #registerBeanDefinition
 */
@Override
protected final void refreshBeanFactory() throws IllegalStateException {
   if (!this.refreshed.compareAndSet(false, true)) {
      throw new IllegalStateException(
            "GenericApplicationContext does not support multiple refresh attempts: just call 'refresh' once");
   }
   this.beanFactory.setSerializationId(getId());
}
```

```java
@Override
public final ConfigurableListableBeanFactory getBeanFactory() {
   synchronized (this.beanFactoryMonitor) {
      if (this.beanFactory == null) {
         throw new IllegalStateException("BeanFactory not initialized or already closed - " +
               "call 'refresh' before accessing beans via the ApplicationContext");
      }
      return this.beanFactory;
   }
}
```

##### 9.3、创建BeanFactory

默认的BeanFactory为 `org.springframework.beans.factory.support.DefaultListableBeanFactory` ，

类加载器,表达式解析器,注册依赖。

```java
/**
 * 配置工厂的标准上下文特征，
 * 例如上下文的ClassLoader和后处理器。
 * @param beanFactory 要配置的BeanFactory
 */
protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
   // 告诉内部bean工厂使用上下文的类加载器等。
   beanFactory.setBeanClassLoader(getClassLoader());
    //主要用来解析Spel表达式
   beanFactory.setBeanExpressionResolver(new StandardBeanExpressionResolver(beanFactory.getBeanClassLoader()));
    //ResourceEditorRegistrar继承了PropertyEditorRegistrar，使用资源编辑器来填充指定的PropertyEditorRegistry。
   beanFactory.addPropertyEditorRegistrar(new ResourceEditorRegistrar(this, getEnvironment()));

   // 使用上下文回调配置bean工厂。
   beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
    //忽略给定的自动装配依赖接口。,默认情况下，只忽略BeanFactoryAware接口。要忽略其他类型，请为每种类型调用此方法。
   beanFactory.ignoreDependencyInterface(EnvironmentAware.class);
   beanFactory.ignoreDependencyInterface(EmbeddedValueResolverAware.class);
   beanFactory.ignoreDependencyInterface(ResourceLoaderAware.class);
   beanFactory.ignoreDependencyInterface(ApplicationEventPublisherAware.class);
   beanFactory.ignoreDependencyInterface(MessageSourceAware.class);
   beanFactory.ignoreDependencyInterface(ApplicationContextAware.class);

   // BeanFactory接口未在普通工厂中注册为可解析类型。
   // MessageSource作为bean注册（并发现用于自动装配）。
   beanFactory.registerResolvableDependency(BeanFactory.class, beanFactory);
   beanFactory.registerResolvableDependency(ResourceLoader.class, this);
   beanFactory.registerResolvableDependency(ApplicationEventPublisher.class, this);
   beanFactory.registerResolvableDependency(ApplicationContext.class, this);

   // 注册早期的后处理器以检测内部bean作为ApplicationListeners。
   beanFactory.addBeanPostProcessor(new ApplicationListenerDetector(this));

   // 检测到LoadTimeWeaver并准备编织（如果找到）。
   if (beanFactory.containsBean(LOAD_TIME_WEAVER_BEAN_NAME)) {
      beanFactory.addBeanPostProcessor(new LoadTimeWeaverAwareProcessor(beanFactory));
      // Set a temporary ClassLoader for type matching.
      beanFactory.setTempClassLoader(new ContextTypeMatchClassLoader(beanFactory.getBeanClassLoader()));
   }

   // 注册默认环境bean。
   if (!beanFactory.containsLocalBean(ENVIRONMENT_BEAN_NAME)) {
      beanFactory.registerSingleton(ENVIRONMENT_BEAN_NAME, getEnvironment());
   }
   if (!beanFactory.containsLocalBean(SYSTEM_PROPERTIES_BEAN_NAME)) {
      beanFactory.registerSingleton(SYSTEM_PROPERTIES_BEAN_NAME, getEnvironment().getSystemProperties());
   }
   if (!beanFactory.containsLocalBean(SYSTEM_ENVIRONMENT_BEAN_NAME)) {
      beanFactory.registerSingleton(SYSTEM_ENVIRONMENT_BEAN_NAME, getEnvironment().getSystemEnvironment());
   }
}
```

##### 9.4 注册实现了BeanPostProcessor接口的bean

添加BeanFactory后处理器，调用所有已添加的BeanFactoryPostProcessors[一个容器扩展点]。在标准初始化之后修改应用程序上下文的内部bean工厂。 将加载所有bean定义，但尚未实例化任何bean。 这允许在某些ApplicationContext实现中注册特殊的BeanPostProcessors等。默认实现 `AnnotationConfigEmbeddedWebApplicationContext` 。注册 `ServletContextAwareProcessor`。

```java
protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
}
```

```java
/**
 * Register ServletContextAwareProcessor.
 * @see ServletContextAwareProcessor
 */
@Override
protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
   beanFactory.addBeanPostProcessor(
         new WebApplicationContextServletContextAwareProcessor(this));
   beanFactory.ignoreDependencyInterface(ServletContextAware.class);
}
```

好了，到此为止。我们来看看我们已经在beanFactory中添加了那些信息

![beanfactory1](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-springboot/images/beanfactory1.png)



![beanfactory2](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-springboot/images/beanfactory2.png)



![beanfactory3](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-springboot/images/beanfactory3.png)



![beanfactory4](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-springboot/images/beanfactory4.png)

##### 9.5 初始化和执行BeanFactoryPostProcessor beans

```java
/**
 * 实例化并调用所有已注册的BeanFactoryPostProcessor bean，
 * 如果指定了顺序，按顺序执行
 * 必须在单例实例化之前调用。
 */
protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
    //委托 AbstractApplicationContext 的后置处理器处理。
    PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());

    // 如果在此期间找到，则检测LoadTimeWeaver并准备编织
    // (例如 通过ConfigurationClassPostProcessor注册的@Bean方法)
    if (beanFactory.getTempClassLoader() == null && beanFactory.containsBean(LOAD_TIME_WEAVER_BEAN_NAME)) {
        beanFactory.addBeanPostProcessor(new LoadTimeWeaverAwareProcessor(beanFactory));
        beanFactory.setTempClassLoader(new ContextTypeMatchClassLoader(beanFactory.getBeanClassLoader()));
    }
}
```

PostProcessorRegistrationDelegate#invokeBeanFactoryPostProcessors（）

```java
public static void invokeBeanFactoryPostProcessors(
    ConfigurableListableBeanFactory beanFactory, List<BeanFactoryPostProcessor> beanFactoryPostProcessors) {

    // 首先调用 BeanDefinitionRegistryPostProcessor，如果有的话。
    // BeanDefinitionRegistryPostProcessor可以注册更多的bean定义
    Set<String> processedBeans = new HashSet<String>();

    if (beanFactory instanceof BeanDefinitionRegistry) {
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
        List<BeanFactoryPostProcessor> regularPostProcessors = new LinkedList<BeanFactoryPostProcessor>();
        List<BeanDefinitionRegistryPostProcessor> registryProcessors = new LinkedList<BeanDefinitionRegistryPostProcessor>();

        for (BeanFactoryPostProcessor postProcessor : beanFactoryPostProcessors) {
            if (postProcessor instanceof BeanDefinitionRegistryPostProcessor) {
                BeanDefinitionRegistryPostProcessor registryProcessor =
                    (BeanDefinitionRegistryPostProcessor) postProcessor;
                registryProcessor.postProcessBeanDefinitionRegistry(registry);
                registryProcessors.add(registryProcessor);
            }
            else {
                regularPostProcessors.add(postProcessor);
            }
        }

        // 不要在这里初始化FactoryBeans：我们需要保留未初始化所有常规bean,让bean工厂的后处理器去创建他们！在实现的BeanDefinitionRegistryPostProcessors之间分开PriorityOrdered，Ordered和其他。
        List<BeanDefinitionRegistryPostProcessor> currentRegistryProcessors = new ArrayList<BeanDefinitionRegistryPostProcessor>();

        // 首先，调用实现PriorityOrdered的BeanDefinitionRegistryPostProcessors。
        String[] postProcessorNames =
            beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
        for (String ppName : postProcessorNames) {
            if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
                currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
                processedBeans.add(ppName);
            }
        }

        sortPostProcessors(currentRegistryProcessors, beanFactory);
        registryProcessors.addAll(currentRegistryProcessors);
        //  9.5.1 调用给定的BeanDefinitionRegistryPostProcessor bean。各种配置解析等。此处不做深入，下面贴出相应代码。可自行研究
        invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);

        currentRegistryProcessors.clear();

        // 接下来，调用实现Ordered的BeanDefinitionRegistryPostProcessors。
        postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
        for (String ppName : postProcessorNames) {
            if (!processedBeans.contains(ppName) && beanFactory.isTypeMatch(ppName, Ordered.class)) {
                currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
                processedBeans.add(ppName);
            }
        }
        sortPostProcessors(currentRegistryProcessors, beanFactory);
        registryProcessors.addAll(currentRegistryProcessors);
        invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
        currentRegistryProcessors.clear();

        // 最后，调用所有其他BeanDefinitionRegistryPostProcessors，直到不再出现其他BeanDefinitionRegistryPostProcessors。
        boolean reiterate = true;
        while (reiterate) {
            reiterate = false;
            postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
            for (String ppName : postProcessorNames) {
                if (!processedBeans.contains(ppName)) {
                    currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
                    processedBeans.add(ppName);
                    reiterate = true;
                }
            }
            sortPostProcessors(currentRegistryProcessors, beanFactory);
            registryProcessors.addAll(currentRegistryProcessors);
            invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
            currentRegistryProcessors.clear();
        }

        // 现在，调用到目前为止处理的所有处理器的postProcessBeanFactory回调。
        invokeBeanFactoryPostProcessors(registryProcessors, beanFactory);
        invokeBeanFactoryPostProcessors(regularPostProcessors, beanFactory);
    }

    else {
        // 调用在上下文实例中注册的工厂处理器。
        invokeBeanFactoryPostProcessors(beanFactoryPostProcessors, beanFactory);
    }

    // Do not initialize FactoryBeans here: We need to leave all regular beans
    // uninitialized to let the bean factory post-processors apply to them!
    String[] postProcessorNames =
        beanFactory.getBeanNamesForType(BeanFactoryPostProcessor.class, true, false);

    // Separate between BeanFactoryPostProcessors that implement PriorityOrdered,
    // Ordered, and the rest.
    List<BeanFactoryPostProcessor> priorityOrderedPostProcessors = new ArrayList<BeanFactoryPostProcessor>();
    List<String> orderedPostProcessorNames = new ArrayList<String>();
    List<String> nonOrderedPostProcessorNames = new ArrayList<String>();
    for (String ppName : postProcessorNames) {
        if (processedBeans.contains(ppName)) {
            // skip - already processed in first phase above
        }
        else if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
            priorityOrderedPostProcessors.add(beanFactory.getBean(ppName, BeanFactoryPostProcessor.class));
        }
        else if (beanFactory.isTypeMatch(ppName, Ordered.class)) {
            orderedPostProcessorNames.add(ppName);
        }
        else {
            nonOrderedPostProcessorNames.add(ppName);
        }
    }

    // First, invoke the BeanFactoryPostProcessors that implement PriorityOrdered.
    sortPostProcessors(priorityOrderedPostProcessors, beanFactory);
    invokeBeanFactoryPostProcessors(priorityOrderedPostProcessors, beanFactory);

    // Next, invoke the BeanFactoryPostProcessors that implement Ordered.
    List<BeanFactoryPostProcessor> orderedPostProcessors = new ArrayList<BeanFactoryPostProcessor>();
    for (String postProcessorName : orderedPostProcessorNames) {
        orderedPostProcessors.add(beanFactory.getBean(postProcessorName, BeanFactoryPostProcessor.class));
    }
    sortPostProcessors(orderedPostProcessors, beanFactory);
    invokeBeanFactoryPostProcessors(orderedPostProcessors, beanFactory);

    // Finally, invoke all other BeanFactoryPostProcessors.
    List<BeanFactoryPostProcessor> nonOrderedPostProcessors = new ArrayList<BeanFactoryPostProcessor>();
    for (String postProcessorName : nonOrderedPostProcessorNames) {
        nonOrderedPostProcessors.add(beanFactory.getBean(postProcessorName, BeanFactoryPostProcessor.class));
    }
    invokeBeanFactoryPostProcessors(nonOrderedPostProcessors, beanFactory);

    // Clear cached merged bean definitions since the post-processors might have
    // modified the original metadata, e.g. replacing placeholders in values...
    beanFactory.clearMetadataCache();
}
```

###### 9.5.1 调用给定的BeanDefinitionRegistryPostProcessor bean。

```java
/**
 * Invoke the given BeanDefinitionRegistryPostProcessor beans.
 */
private static void invokeBeanDefinitionRegistryPostProcessors(
      Collection<? extends BeanDefinitionRegistryPostProcessor> postProcessors, BeanDefinitionRegistry registry) {
	//此处的postProcessor为ConfigurationClassPostProcessor，前面创建上下文的时候已经创建了此Bean。
   for (BeanDefinitionRegistryPostProcessor postProcessor : postProcessors) {
      postProcessor.postProcessBeanDefinitionRegistry(registry);
   }
}
```

ConfigurationClassPostProcessor#postProcessBeanDefinitionRegistry

```java
@Override
public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
   int registryId = System.identityHashCode(registry);
   if (this.registriesPostProcessed.contains(registryId)) {
      throw new IllegalStateException(
            "postProcessBeanDefinitionRegistry already called on this post-processor against " + registry);
   }
   if (this.factoriesPostProcessed.contains(registryId)) {
      throw new IllegalStateException(
            "postProcessBeanFactory already called on this post-processor against " + registry);
   }
   this.registriesPostProcessed.add(registryId);
	//处理配置bean的定义
   processConfigBeanDefinitions(registry);
}
```



```java
/**
 * Build and validate a configuration model based on the registry of
 * {@link Configuration} classes.
 */
public void processConfigBeanDefinitions(BeanDefinitionRegistry registry) {
   List<BeanDefinitionHolder> configCandidates = new ArrayList<BeanDefinitionHolder>();
   //获取已经注册的bean名称
    String[] candidateNames = registry.getBeanDefinitionNames();

   for (String beanName : candidateNames) {
      BeanDefinition beanDef = registry.getBeanDefinition(beanName);
      if (ConfigurationClassUtils.isFullConfigurationClass(beanDef) ||
            ConfigurationClassUtils.isLiteConfigurationClass(beanDef)) {
          //如果BeanDefinition 中的configurationClass 属性为full 或者lite ,则意味着已经处理过了,直接跳过
         if (logger.isDebugEnabled()) {
            logger.debug("Bean definition has already been processed as a configuration class: " + beanDef);
         }
      }
      else if (ConfigurationClassUtils.checkConfigurationClassCandidate(beanDef, this.metadataReaderFactory)) {
          //判断对应bean是否为配置类,如果是,则加入到configCandidates
         configCandidates.add(new BeanDefinitionHolder(beanDef, beanName));
      }
   }

   //如果不存在配置类,则直接return
   if (configCandidates.isEmpty()) {
      return;
   }

   // 对configCandidates 进行 排序,按照@Order 配置的值进行排序
   Collections.sort(configCandidates, new Comparator<BeanDefinitionHolder>() {
      @Override
      public int compare(BeanDefinitionHolder bd1, BeanDefinitionHolder bd2) {
         int i1 = ConfigurationClassUtils.getOrder(bd1.getBeanDefinition());
         int i2 = ConfigurationClassUtils.getOrder(bd2.getBeanDefinition());
         return (i1 < i2) ? -1 : (i1 > i2) ? 1 : 0;
      }
   });

   // 如果BeanDefinitionRegistry 是SingletonBeanRegistry 子类的话,由于我们当前传入的是DefaultListableBeanFactory,是SingletonBeanRegistry 的子类。因此会将registry强转为SingletonBeanRegistry
   SingletonBeanRegistry sbr = null;
   if (registry instanceof SingletonBeanRegistry) {
      sbr = (SingletonBeanRegistry) registry;
      if (!this.localBeanNameGeneratorSet && sbr.containsSingleton(CONFIGURATION_BEAN_NAME_GENERATOR)) {
          // 如果localBeanNameGeneratorSet 等于false 并且SingletonBeanRegistry 中有 id 为 org.springframework.context.annotation.internalConfigurationBeanNameGenerator的bean .则将componentScanBeanNameGenerator,importBeanNameGenerator 赋值为 该bean.
         BeanNameGenerator generator = (BeanNameGenerator) sbr.getSingleton(CONFIGURATION_BEAN_NAME_GENERATOR);
         this.componentScanBeanNameGenerator = generator;
         this.importBeanNameGenerator = generator;
      }
   }

   // 实例化ConfigurationClassParser 为了解析 各个配置类
   ConfigurationClassParser parser = new ConfigurationClassParser(
         this.metadataReaderFactory, this.problemReporter, this.environment,
         this.resourceLoader, this.componentScanBeanNameGenerator, registry);
//实例化2个set,candidates 用于将之前加入的configCandidates 进行去重
    //alreadyParsed 用于判断是否处理过
   Set<BeanDefinitionHolder> candidates = new LinkedHashSet<BeanDefinitionHolder>(configCandidates);
   Set<ConfigurationClass> alreadyParsed = new HashSet<ConfigurationClass>(configCandidates.size());
   do {
       //进行解析，解析各种注解等
      parser.parse(candidates);
       //验证
      parser.validate();

      Set<ConfigurationClass> configClasses = new LinkedHashSet<ConfigurationClass>(parser.getConfigurationClasses());
      configClasses.removeAll(alreadyParsed);

      // 根据model的内容创建bean的定义
      if (this.reader == null) {
         this.reader = new ConfigurationClassBeanDefinitionReader(
               registry, this.sourceExtractor, this.resourceLoader, this.environment,
               this.importBeanNameGenerator, parser.getImportRegistry());
      }
      this.reader.loadBeanDefinitions(configClasses);
      alreadyParsed.addAll(configClasses);

      candidates.clear();
      if (registry.getBeanDefinitionCount() > candidateNames.length) {
         String[] newCandidateNames = registry.getBeanDefinitionNames();
         Set<String> oldCandidateNames = new HashSet<String>(Arrays.asList(candidateNames));
         Set<String> alreadyParsedClasses = new HashSet<String>();
         for (ConfigurationClass configurationClass : alreadyParsed) {
            alreadyParsedClasses.add(configurationClass.getMetadata().getClassName());
         }
         for (String candidateName : newCandidateNames) {
            if (!oldCandidateNames.contains(candidateName)) {
               BeanDefinition bd = registry.getBeanDefinition(candidateName);
               if (ConfigurationClassUtils.checkConfigurationClassCandidate(bd, this.metadataReaderFactory) &&
                     !alreadyParsedClasses.contains(bd.getBeanClassName())) {
                  candidates.add(new BeanDefinitionHolder(bd, candidateName));
               }
            }
         }
         candidateNames = newCandidateNames;
      }
   }
   while (!candidates.isEmpty());

   // 将ImportRegistry注册为bean以支持ImportAware @Configuration classes
   if (sbr != null) {
      if (!sbr.containsSingleton(IMPORT_REGISTRY_BEAN_NAME)) {
          //如果SingletonBeanRegistry 不包含org.springframework.context.annotation.ConfigurationClassPostProcessor.importRegistry
            // 则注册一个,bean 为 ImportRegistry. 一般都会进行注册的。
         sbr.registerSingleton(IMPORT_REGISTRY_BEAN_NAME, parser.getImportRegistry());
      }
   }
	//清除缓存
   if (this.metadataReaderFactory instanceof CachingMetadataReaderFactory) {
      ((CachingMetadataReaderFactory) this.metadataReaderFactory).clearCache();
   }
}
```

判断对应bean是否为配置类 调用的是ConfigurationClassUtils#checkConfigurationClassCandidate.代码如下:

```java
public static boolean checkConfigurationClassCandidate(BeanDefinition beanDef, MetadataReaderFactory metadataReaderFactory) {
    //获取类名,如果类名不存在则返回false
   String className = beanDef.getBeanClassName();
   if (className == null || beanDef.getFactoryMethodName() != null) {
      return false;
   }
	//获得AnnotationMetadata
   AnnotationMetadata metadata;
   if (beanDef instanceof AnnotatedBeanDefinition &&
         className.equals(((AnnotatedBeanDefinition) beanDef).getMetadata().getClassName())) {
      // Can reuse the pre-parsed metadata from the given BeanDefinition...
       //如果BeanDefinition 是 AnnotatedBeanDefinition的实例,并且className 和 BeanDefinition中 的元数据 的类名相同
        // 则直接从BeanDefinition 获得Metadata
      metadata = ((AnnotatedBeanDefinition) beanDef).getMetadata();
   }
   else if (beanDef instanceof AbstractBeanDefinition && ((AbstractBeanDefinition) beanDef).hasBeanClass()) {
      // Check already loaded Class if present...
      // since we possibly can't even load the class file for this Class.
       //如果BeanDefinition 是 AnnotatedBeanDefinition的实例,并且beanDef 有 beanClass 属性存在
        // 则实例化StandardAnnotationMetadata
      Class<?> beanClass = ((AbstractBeanDefinition) beanDef).getBeanClass();
      metadata = new StandardAnnotationMetadata(beanClass, true);
   }
   else {
      try {
          //否则 通过MetadataReaderFactory 中的MetadataReader 进行读取
         MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(className);
         metadata = metadataReader.getAnnotationMetadata();
      }
      catch (IOException ex) {
         if (logger.isDebugEnabled()) {
            logger.debug("Could not find class file for introspecting configuration annotations: " + className, ex);
         }
         return false;
      }
   }

   if (isFullConfigurationCandidate(metadata)) {
       //如果存在Configuration 注解,则为BeanDefinition 设置configurationClass属性为full
      beanDef.setAttribute(CONFIGURATION_CLASS_ATTRIBUTE, CONFIGURATION_CLASS_FULL);
   }
   else if (isLiteConfigurationCandidate(metadata)) {
       //如果AnnotationMetadata 中有Component,ComponentScan,Import,ImportResource 注解中的任意一个,或者存在 被@bean 注解的方法,则返回true.
      beanDef.setAttribute(CONFIGURATION_CLASS_ATTRIBUTE, CONFIGURATION_CLASS_LITE);
   }
   else {
      return false;
   }

   // It's a full or lite configuration candidate... Let's determine the order value, if any.
   Map<String, Object> orderAttributes = metadata.getAnnotationAttributes(Order.class.getName());
   if (orderAttributes != null) {
       //如果该类被@Order所注解,则设置order属性为@Order的值
      beanDef.setAttribute(ORDER_ATTRIBUTE, orderAttributes.get(AnnotationUtils.VALUE));
   }

   return true;
}
```

##### 9.6、初始化和执行BeanPostProcessor beans

```java
/**
 * 如果给出明确的命令。实例化并调用所有已注册的BeanPostProcessor bean，
 * 必须在应用程序bean的任何实例化之前调用
 */
protected void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
   PostProcessorRegistrationDelegate.registerBeanPostProcessors(beanFactory, this);
}
```
PostProcessorRegistrationDelegate#registerBeanPostProcessors

```java
public static void registerBeanPostProcessors(
      ConfigurableListableBeanFactory beanFactory, AbstractApplicationContext applicationContext) {

   String[] postProcessorNames = beanFactory.getBeanNamesForType(BeanPostProcessor.class, true, false);

    // 注册BeanPostProcessorChecker，在BeanPostProcessor实例化期间创建bean时记录信息消息，即当bean不符合由所有BeanPostProcessors处理的资格时。。
   int beanProcessorTargetCount = beanFactory.getBeanPostProcessorCount() + 1 + postProcessorNames.length;
   beanFactory.addBeanPostProcessor(new BeanPostProcessorChecker(beanFactory, beanProcessorTargetCount));

   // 实现PriorityOrdered，Ordered和其余的BeanPostProcessors之间分开。
   List<BeanPostProcessor> priorityOrderedPostProcessors = new ArrayList<BeanPostProcessor>();
   List<BeanPostProcessor> internalPostProcessors = new ArrayList<BeanPostProcessor>();
   List<String> orderedPostProcessorNames = new ArrayList<String>();
   List<String> nonOrderedPostProcessorNames = new ArrayList<String>();
   for (String ppName : postProcessorNames) {
      if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
         BeanPostProcessor pp = beanFactory.getBean(ppName, BeanPostProcessor.class);
         priorityOrderedPostProcessors.add(pp);
         if (pp instanceof MergedBeanDefinitionPostProcessor) {
            internalPostProcessors.add(pp);
         }
      }
      else if (beanFactory.isTypeMatch(ppName, Ordered.class)) {
         orderedPostProcessorNames.add(ppName);
      }
      else {
         nonOrderedPostProcessorNames.add(ppName);
      }
   }

   // 首先，注册实现PriorityOrdered的BeanPostProcessors。
   sortPostProcessors(priorityOrderedPostProcessors, beanFactory);
   registerBeanPostProcessors(beanFactory, priorityOrderedPostProcessors);

   // 接下来，注册实现Ordered的BeanPostProcessors。
   List<BeanPostProcessor> orderedPostProcessors = new ArrayList<BeanPostProcessor>();
   for (String ppName : orderedPostProcessorNames) {
      BeanPostProcessor pp = beanFactory.getBean(ppName, BeanPostProcessor.class);
      orderedPostProcessors.add(pp);
      if (pp instanceof MergedBeanDefinitionPostProcessor) {
         internalPostProcessors.add(pp);
      }
   }
   sortPostProcessors(orderedPostProcessors, beanFactory);
   registerBeanPostProcessors(beanFactory, orderedPostProcessors);

   // 现在，注册所有常规的BeanPostProcessors.
   List<BeanPostProcessor> nonOrderedPostProcessors = new ArrayList<BeanPostProcessor>();
   for (String ppName : nonOrderedPostProcessorNames) {
      BeanPostProcessor pp = beanFactory.getBean(ppName, BeanPostProcessor.class);
      nonOrderedPostProcessors.add(pp);
      if (pp instanceof MergedBeanDefinitionPostProcessor) {
         internalPostProcessors.add(pp);
      }
   }
   registerBeanPostProcessors(beanFactory, nonOrderedPostProcessors);

   // 最后，重新注册所有内部BeanPostProcessors。
   sortPostProcessors(internalPostProcessors, beanFactory);
   registerBeanPostProcessors(beanFactory, internalPostProcessors);

   // 重新注册后处理器以检测内部bean作为ApplicationListeners，将其移动到处理器链的末尾（用于拾取代理等）。
   beanFactory.addBeanPostProcessor(new ApplicationListenerDetector(applicationContext));
}
```

##### 9.7 初始化消息资源，各种国际化资源

```java

/**
 * Name of the MessageSource bean in the factory.
 * If none is supplied, message resolution is delegated to the parent.
 * @see MessageSource
 */
public static final String MESSAGE_SOURCE_BEAN_NAME = "messageSource";
/**
 * Initialize the MessageSource.
 * Use parent's if none defined in this context.
 */
protected void initMessageSource() {
    ConfigurableListableBeanFactory beanFactory = getBeanFactory();
    if (beanFactory.containsLocalBean(MESSAGE_SOURCE_BEAN_NAME)) {
        this.messageSource = beanFactory.getBean(MESSAGE_SOURCE_BEAN_NAME, MessageSource.class);
        // Make MessageSource aware of parent MessageSource.
        if (this.parent != null && this.messageSource instanceof HierarchicalMessageSource) {
            HierarchicalMessageSource hms = (HierarchicalMessageSource) this.messageSource;
            if (hms.getParentMessageSource() == null) {
                // Only set parent context as parent MessageSource if no parent MessageSource
                // registered already.
                hms.setParentMessageSource(getInternalParentMessageSource());
            }
        }
        if (logger.isDebugEnabled()) {
            logger.debug("Using MessageSource [" + this.messageSource + "]");
        }
    }
    else {
        // Use empty MessageSource to be able to accept getMessage calls.
        DelegatingMessageSource dms = new DelegatingMessageSource();
        dms.setParentMessageSource(getInternalParentMessageSource());
        this.messageSource = dms;
        //注册MessageResource
        beanFactory.registerSingleton(MESSAGE_SOURCE_BEAN_NAME, this.messageSource);
        if (logger.isDebugEnabled()) {
            logger.debug("Unable to locate MessageSource with name '" + MESSAGE_SOURCE_BEAN_NAME +
                         "': using default [" + this.messageSource + "]");
        }
    }
}
```

##### 9.8 、初始化EventMulticaster

```java

/**
 * Name of the ApplicationEventMulticaster bean in the factory.
 * If none is supplied, a default SimpleApplicationEventMulticaster is used.
 * @see org.springframework.context.event.ApplicationEventMulticaster
 * @see org.springframework.context.event.SimpleApplicationEventMulticaster
 */
public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";
/**
 * Initialize the ApplicationEventMulticaster.
 * Uses SimpleApplicationEventMulticaster if none defined in the context.
 * @see org.springframework.context.event.SimpleApplicationEventMulticaster
 */
protected void initApplicationEventMulticaster() {
    ConfigurableListableBeanFactory beanFactory = getBeanFactory();
    if (beanFactory.containsLocalBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME)) {
        this.applicationEventMulticaster =
            beanFactory.getBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, ApplicationEventMulticaster.class);
        if (logger.isDebugEnabled()) {
            logger.debug("Using ApplicationEventMulticaster [" + this.applicationEventMulticaster + "]");
        }
    }
    else {
        this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, this.applicationEventMulticaster);
        if (logger.isDebugEnabled()) {
            logger.debug("Unable to locate ApplicationEventMulticaster with name '" +
                         APPLICATION_EVENT_MULTICASTER_BEAN_NAME +
                         "': using default [" + this.applicationEventMulticaster + "]");
        }
    }
}
```

##### 9.9、在特定的上下文子类中初始化其他特殊bean。

ThemeSource，EmbeddedServletContainerFactory（TomcatEmbeddedServletContainerFactory，JettyEmbeddedServletContainerFactory，UndertowEmbeddedServletContainerFactory）。

```java
/**
 * Initialize the ThemeSource for the given application context,
 * autodetecting a bean with the name "themeSource". If no such
 * bean is found, a default (empty) ThemeSource will be used.
 * @param context current application context
 * @return the initialized theme source (will never be {@code null})
 * @see #THEME_SOURCE_BEAN_NAME
 */
public static ThemeSource initThemeSource(ApplicationContext context) {
   if (context.containsLocalBean(THEME_SOURCE_BEAN_NAME)) {
      ThemeSource themeSource = context.getBean(THEME_SOURCE_BEAN_NAME, ThemeSource.class);
      // Make ThemeSource aware of parent ThemeSource.
      if (context.getParent() instanceof ThemeSource && themeSource instanceof HierarchicalThemeSource) {
         HierarchicalThemeSource hts = (HierarchicalThemeSource) themeSource;
         if (hts.getParentThemeSource() == null) {
            // Only set parent context as parent ThemeSource if no parent ThemeSource
            // registered already.
            hts.setParentThemeSource((ThemeSource) context.getParent());
         }
      }
      if (logger.isDebugEnabled()) {
         logger.debug("Using ThemeSource [" + themeSource + "]");
      }
      return themeSource;
   }
   else {
      // Use default ThemeSource to be able to accept getTheme calls, either
      // delegating to parent context's default or to local ResourceBundleThemeSource.
      HierarchicalThemeSource themeSource = null;
      if (context.getParent() instanceof ThemeSource) {
         themeSource = new DelegatingThemeSource();
         themeSource.setParentThemeSource((ThemeSource) context.getParent());
      }
      else {
         themeSource = new ResourceBundleThemeSource();
      }
      if (logger.isDebugEnabled()) {
         logger.debug("Unable to locate ThemeSource with name '" + THEME_SOURCE_BEAN_NAME +
               "': using default [" + themeSource + "]");
      }
      return themeSource;
   }
}
```



```java
private void createEmbeddedServletContainer() {
   EmbeddedServletContainer localContainer = this.embeddedServletContainer;
   ServletContext localServletContext = getServletContext();
   if (localContainer == null && localServletContext == null) {
      EmbeddedServletContainerFactory containerFactory = getEmbeddedServletContainerFactory();
      this.embeddedServletContainer = containerFactory
            .getEmbeddedServletContainer(getSelfInitializer());
   }
   else if (localServletContext != null) {
      try {
         getSelfInitializer().onStartup(localServletContext);
      }
      catch (ServletException ex) {
         throw new ApplicationContextException("Cannot initialize servlet context",
               ex);
      }
   }
    //替换{@code Servlet}相关的属性源。
   initPropertySources();
}
```

##### 9.10、检查并注册监听器 

```java
/**
 * Add beans that implement ApplicationListener as listeners.
 * Doesn't affect other listeners, which can be added without being beans.
 */
protected void registerListeners() {
   // Register statically specified listeners first.
   for (ApplicationListener<?> listener : getApplicationListeners()) {
      getApplicationEventMulticaster().addApplicationListener(listener);
   }

   // Do not initialize FactoryBeans here: We need to leave all regular beans
   // uninitialized to let post-processors apply to them!
   String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
   for (String listenerBeanName : listenerBeanNames) {
      getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
   }

   // Publish early application events now that we finally have a multicaster...
   Set<ApplicationEvent> earlyEventsToProcess = this.earlyApplicationEvents;
   this.earlyApplicationEvents = null;
   if (earlyEventsToProcess != null) {
      for (ApplicationEvent earlyEvent : earlyEventsToProcess) {
         getApplicationEventMulticaster().multicastEvent(earlyEvent);
      }
   }
}
```

##### 9.11 、实例化所有剩余（非延迟初始化）单例。

创建Bean的实例并构建Bean的关系网。都在此方法中。

```java
/**
 * Finish the initialization of this context's bean factory,
 * initializing all remaining singleton beans.
 */
protected void finishBeanFactoryInitialization(ConfigurableListableBeanFactory beanFactory) {
   // Initialize conversion service for this context.
   if (beanFactory.containsBean(CONVERSION_SERVICE_BEAN_NAME) &&
         beanFactory.isTypeMatch(CONVERSION_SERVICE_BEAN_NAME, ConversionService.class)) {
      beanFactory.setConversionService(
            beanFactory.getBean(CONVERSION_SERVICE_BEAN_NAME, ConversionService.class));
   }

   // Register a default embedded value resolver if no bean post-processor
   // (such as a PropertyPlaceholderConfigurer bean) registered any before:
   // at this point, primarily for resolution in annotation attribute values.
   if (!beanFactory.hasEmbeddedValueResolver()) {
      beanFactory.addEmbeddedValueResolver(new StringValueResolver() {
         @Override
         public String resolveStringValue(String strVal) {
            return getEnvironment().resolvePlaceholders(strVal);
         }
      });
   }

   // Initialize LoadTimeWeaverAware beans early to allow for registering their transformers early.
   String[] weaverAwareNames = beanFactory.getBeanNamesForType(LoadTimeWeaverAware.class, false, false);
   for (String weaverAwareName : weaverAwareNames) {
      getBean(weaverAwareName);
   }

   // Stop using the temporary ClassLoader for type matching.
   beanFactory.setTempClassLoader(null);

   // Allow for caching all bean definition metadata, not expecting further changes.
   //禁止修改当前bean的配置信息
   beanFactory.freezeConfiguration();

   // Instantiate all remaining (non-lazy-init) singletons.
   beanFactory.preInstantiateSingletons();
}
```

```java
@Override
public void preInstantiateSingletons() throws BeansException {
    if (this.logger.isDebugEnabled()) {
        this.logger.debug("Pre-instantiating singletons in " + this);
    }

    // Iterate over a copy to allow for init methods which in turn register new bean definitions.
    // While this may not be part of the regular factory bootstrap, it does otherwise work fine.
    List<String> beanNames = new ArrayList<String>(this.beanDefinitionNames);

    // Trigger initialization of all non-lazy singleton beans...
    //1、循环遍历beanNames中的beanName
    for (String beanName : beanNames) {
        //2、获取RootBeanDefinition对象
        RootBeanDefinition bd = getMergedLocalBeanDefinition(beanName);
        //3、如果是单例对象，不是抽象类，不是LazyInit。
        if (!bd.isAbstract() && bd.isSingleton() && !bd.isLazyInit()) {
            //4、判断是否是FactoryBean
            if (isFactoryBean(beanName)) {
                //5、获取FactoryBean对象本身
                final FactoryBean<?> factory = (FactoryBean<?>) getBean(FACTORY_BEAN_PREFIX + beanName);
                //6、是否是EagreInit
                boolean isEagerInit;
                if (System.getSecurityManager() != null && factory instanceof SmartFactoryBean) {
                    isEagerInit = AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
                        @Override
                        public Boolean run() {
                            return ((SmartFactoryBean<?>) factory).isEagerInit();
                        }
                    }, getAccessControlContext());
                }
                else {
                    isEagerInit = (factory instanceof SmartFactoryBean &&
                                   ((SmartFactoryBean<?>) factory).isEagerInit());
                }
                if (isEagerInit) {
                    getBean(beanName);
                }
            }
            else {
                getBean(beanName);
            }
        }
    }

    // Trigger post-initialization callback for all applicable beans...
    for (String beanName : beanNames) {
        Object singletonInstance = getSingleton(beanName);
        if (singletonInstance instanceof SmartInitializingSingleton) {
            final SmartInitializingSingleton smartSingleton = (SmartInitializingSingleton) singletonInstance;
            if (System.getSecurityManager() != null) {
                AccessController.doPrivileged(new PrivilegedAction<Object>() {
                    @Override
                    public Object run() {
                        smartSingleton.afterSingletonsInstantiated();
                        return null;
                    }
                }, getAccessControlContext());
            }
            else {
                smartSingleton.afterSingletonsInstantiated();
            }
        }
    }
}
```

##### 9.12 、最后一步：发布相应的事件。


```java
/**
 * Finish the refresh of this context, invoking the LifecycleProcessor's
 * onRefresh() method and publishing the
 * {@link org.springframework.context.event.ContextRefreshedEvent}.
 */
protected void finishRefresh() {
   // Initialize lifecycle processor for this context.
   initLifecycleProcessor();

   // Propagate refresh to lifecycle processor first.
   getLifecycleProcessor().onRefresh();

   // Publish the final event.
   publishEvent(new ContextRefreshedEvent(this));

   // Participate in LiveBeansView MBean, if active.
   LiveBeansView.registerApplicationContext(this);
｝
```

#### 10、刷新后的操作

调用afterRefresh执行刷新后的操作,多播容器启动事件。

```java
/**
 * 在上下文刷新后调用。
 * @param context the application context
 * @param args the application arguments
 */
protected void afterRefresh(ConfigurableApplicationContext context,
      ApplicationArguments args) {
   callRunners(context, args);
}
```

####11、通知容器完成事件
