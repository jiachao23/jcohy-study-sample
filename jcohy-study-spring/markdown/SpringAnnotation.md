#  Redis
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。
>  Ps:在学习Redis之前，先简单介绍一些关于NoSql相关的知识。

## Spring Annotation 注解版
> * [容器](#容器)
> * [组件添加](#组件添加)
> * [组件赋值](#组件赋值)
> * [AOP](#AOP)
> * [声明式事务](#声明式事务)
> * [扩展原理](#扩展原理)
> * [web](#web)

<p id="容器">

## 容器

### 组件注入

#### AnnotationConfigApplicationContext

```java
@Test
public void test01(){
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
    String[] definitionNames = applicationContext.getBeanDefinitionNames();
    for (String name : definitionNames) {
        System.out.println(name);
    }
}
```

#### @Configuration



```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Configuration {
    //名称
    String value() default "";
}
```

声明一个配置类，相当于之前的配置文件

#### @Bean



```java
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Bean {
    @AliasFor("name")
    String[] value() default {};

    @AliasFor("value")
    String[] name() default {};

    Autowire autowire() default Autowire.NO;

    String initMethod() default "";

    String destroyMethod() default "(inferred)";
}

```

给容器注册一个Bean，类型为返回值类型，id默认为方法名



#### @ComponentScan，@ComponentScans

只要标注了@Controller，@Service，@Repository，@Component。会自动进行包扫描

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface ComponentScans {

    ComponentScan[] value();

}
```

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Repeatable(ComponentScans.class)
public @interface ComponentScan {

    //指定要扫描的包
    @AliasFor("basePackages")
    String[] value() default {};


    @AliasFor("value")
    String[] basePackages() default {};


    Class<?>[] basePackageClasses() default {};


    Class<? extends BeanNameGenerator> nameGenerator() default BeanNameGenerator.class;

    Class<? extends ScopeMetadataResolver> scopeResolver() default AnnotationScopeMetadataResolver.class;

    ClassPathBeanDefinitionScanner#setScopedProxyMode(ScopedProxyMode)

        ScopedProxyMode scopedProxy() default ScopedProxyMode.DEFAULT;


    String resourcePattern() default ClassPathScanningCandidateComponentProvider.DEFAULT_RESOURCE_PATTERN;


    boolean useDefaultFilters() default true;


    Filter[] includeFilters() default {};


    Filter[] excludeFilters() default {};


    boolean lazyInit() default false;


    @Retention(RetentionPolicy.RUNTIME)
    @Target({})
    @interface Filter {


        FilterType type() default FilterType.ANNOTATION;

        @AliasFor("classes")
        Class<?>[] value() default {};


        @AliasFor("value")
        Class<?>[] classes() default {};



        String[] pattern() default {};

    }

}
```

```java
@ComponentScan  value:
excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
FilterType.ANNOTATION：按照注解
FilterType.ASSIGNABLE_TYPE：按照给定的类型；
FilterType.ASPECTJ：使用ASPECTJ表达式
FilterType.REGEX：使用正则指定
FilterType.CUSTOM：使用自定义规则

示例：

自定义扫描规则：

public class MyTypeFilter implements TypeFilter {

	/**
	 * metadataReader：读取到的当前正在扫描的类的信息
	 * metadataReaderFactory:可以获取到其他任何类信息的
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// TODO Auto-generated method stub
		//获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取当前正在扫描的类的类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//获取当前类资源（类的路径）
		Resource resource = metadataReader.getResource();

		String className = classMetadata.getClassName();
		System.out.println("--->"+className);
		if(className.contains("er")){
			return true;
		}
		return false;
	}

}

@ComponentScans(
    value = {
        @ComponentScan(value = "com.jcohy", includeFilters = {
            /*@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
						@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),*/
            @Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        }, useDefaultFilters = false)
    }
)
```

#### @Scope

```java
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {


    @AliasFor("scopeName")
    String value() default "";

    /**
	 * Specifies the name of the scope to use for the annotated component/bean.
	 * <p>Defaults to an empty string ({@code ""}) which implies
	 * {@link ConfigurableBeanFactory#SCOPE_SINGLETON SCOPE_SINGLETON}.
	 * @since 4.2
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * @see #value
	 */
    @AliasFor("value")
    String scopeName() default "";


    ScopedProxyMode proxyMode() default ScopedProxyMode.DEFAULT;

}
```

@Scope作用域

-   prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中，每次获取的时候才会调用方法创建对象。

-   singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取就是直接从容器（map.get()）中拿。

-   request：同一次请求创建一个实例

-   session：同一个session创建一个实例

  

#### @Lazy

```java
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Lazy {

    /**
    * Whether lazy initialization should occur.
    */
    boolean value() default true;

}
```

主要是针对单实例bean：因为单实例Bean默认在容器启动的时候创建对象；

懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；

#### @Conditional

```java
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Conditional {

    /**
    * All {@link Condition}s that must {@linkplain Condition#matches match}
    * in order for the component to be registered.
    */
    Class<? extends Condition>[] value();

}
```

按照一定的条件进行判断，满足条件给容器中注册bean。

实现自定义条件注册。

```java
//判断是否linux系统
public class LinuxCondition implements Condition {

    /**
    * ConditionContext：判断条件能使用的上下文（环境）
    * AnnotatedTypeMetadata：注释信息
    */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // TODO是否linux系统
        //1、能获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2、获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3、获取当前环境信息
        Environment environment = context.getEnvironment();
        //4、获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");

        //可以判断容器中的bean注册情况，也可以给容器中注册bean
        boolean definition = registry.containsBeanDefinition("person");
        if(property.contains("linux")){
            return true;
        }

        return false;
    }

}
```

然后使用 

```java
	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person02(){
		return new Person("linus", 48);
	}
```

#### @Import

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Import {

    /**
   	* 这个类可以是配置类，或实现了ImportSelector接口的类，或者实现了ImportBeanDefinitionRegistrar接口的类。
    * {@link Configuration}, {@link ImportSelector}, {@link ImportBeanDefinitionRegistrar}
    * or regular component classes to import.
    */
    Class<?>[] value();

}
```

这个类可以是配置类，或实现了ImportSelector接口的类，或者实现了ImportBeanDefinitionRegistrar接口的类。关于这两个接口定义和使用方法如下：

```java
/**
 * Interface to be implemented by types that determine which @{@link Configuration}
 * class(es) should be imported based on a given selection criteria, usually one or more
 * annotation attributes.
 *
 * <p>An {@link ImportSelector} may implement any of the following
 * {@link org.springframework.beans.factory.Aware Aware} interfaces, and their respective
 * methods will be called prior to {@link #selectImports}:
 * <ul>
 * <li>{@link org.springframework.context.EnvironmentAware EnvironmentAware}</li>
 * <li>{@link org.springframework.beans.factory.BeanFactoryAware BeanFactoryAware}</li>
 * <li>{@link org.springframework.beans.factory.BeanClassLoaderAware BeanClassLoaderAware}</li>
 * <li>{@link org.springframework.context.ResourceLoaderAware ResourceLoaderAware}</li>
 * </ul>
 *
 * <p>ImportSelectors are usually processed in the same way as regular {@code @Import}
 * annotations, however, it is also possible to defer selection of imports until all
 * {@code @Configuration} classes have been processed (see {@link DeferredImportSelector}
 * for details).
 *
 * @author Chris Beams
 * @since 3.1
 * @see DeferredImportSelector
 * @see Import
 * @see ImportBeanDefinitionRegistrar
 * @see Configuration
 */
public interface ImportSelector {

    /**
	 * Select and return the names of which class(es) should be imported based on
	 * the {@link AnnotationMetadata} of the importing @{@link Configuration} class.
	 */
    String[] selectImports(AnnotationMetadata importingClassMetadata);

}


/**
 * Interface to be implemented by types that register additional bean definitions when
 * processing @{@link Configuration} classes. Useful when operating at the bean definition
 * level (as opposed to {@code @Bean} method/instance level) is desired or necessary.
 *
 * <p>Along with {@code @Configuration} and {@link ImportSelector}, classes of this type
 * may be provided to the @{@link Import} annotation (or may also be returned from an
 * {@code ImportSelector}).
 *
 * <p>An {@link ImportBeanDefinitionRegistrar} may implement any of the following
 * {@link org.springframework.beans.factory.Aware Aware} interfaces, and their respective
 * methods will be called prior to {@link #registerBeanDefinitions}:
 * <ul>
 * <li>{@link org.springframework.context.EnvironmentAware EnvironmentAware}</li>
 * <li>{@link org.springframework.beans.factory.BeanFactoryAware BeanFactoryAware}
 * <li>{@link org.springframework.beans.factory.BeanClassLoaderAware BeanClassLoaderAware}
 * <li>{@link org.springframework.context.ResourceLoaderAware ResourceLoaderAware}
 * </ul>
 *
 * <p>See implementations and associated unit tests for usage examples.
 *
 * @author Chris Beams
 * @since 3.1
 * @see Import
 * @see ImportSelector
 * @see Configuration
 */
public interface ImportBeanDefinitionRegistrar {

    /**
	 * Register bean definitions as necessary based on the given annotation metadata of
	 * the importing {@code @Configuration} class.
	 * <p>Note that {@link BeanDefinitionRegistryPostProcessor} types may <em>not</em> be
	 * registered here, due to lifecycle constraints related to {@code @Configuration}
	 * class processing.
	 * @param importingClassMetadata annotation metadata of the importing class
	 * @param registry current bean definition registry
	 */
    public void registerBeanDefinitions(
        AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry);

}

```

ImportSelector的使用：返回需要导入的组件的全类名数组；

```java
//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    //返回值，就是到导入到容器中的组件全类名
    //AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // TODO Auto-generated method stub
        //importingClassMetadata
        //方法不要返回null值,可以返回一个空数组。否则会报空指针异常。
        return new String[]{"com.jcohy.study.bean.Blue","com.jcohy.study.bean.Yellow"};
    }

}
```

ImportBeanDefinitionRegistrar:手动注册bean到容器中

```java
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
    * AnnotationMetadata：当前类的注解信息
    * BeanDefinitionRegistry:BeanDefinition注册类；
    *        把所有需要添加到容器中的bean；调用
    *        BeanDefinitionRegistry.registerBeanDefinition手工注册进来
    */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean definition = registry.containsBeanDefinition("com.jochy.study.bean.Red");
        boolean definition2 = registry.containsBeanDefinition("com.jochy.study.bean.Blue");
        if(definition && definition2){
            //指定Bean定义信息；（Bean的类型，Bean。。。）
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean，指定bean名
            registry.registerBeanDefinition("rainBow", beanDefinition);
        }
    }

}

```

```java
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
```

@Import导入组件，id默认是组件的全类名

#### FactoryBean（工厂Bean）

```java
public interface FactoryBean<T> {

    /**
    * Return an instance (possibly shared or independent) of the object
    * managed by this factory.
    * <p>As with a {@link BeanFactory}, this allows support for both the
    * Singleton and Prototype design pattern.
    * <p>If this FactoryBean is not fully initialized yet at the time of
    * the call (for example because it is involved in a circular reference),
    * throw a corresponding {@link FactoryBeanNotInitializedException}.
    * <p>As of Spring 2.0, FactoryBeans are allowed to return {@code null}
    * objects. The factory will consider this as normal value to be used; it
    * will not throw a FactoryBeanNotInitializedException in this case anymore.
    * FactoryBean implementations are encouraged to throw
    * FactoryBeanNotInitializedException themselves now, as appropriate.
    * @return an instance of the bean (can be {@code null})
    * @throws Exception in case of creation errors
    * @see FactoryBeanNotInitializedException
    */
    T getObject() throws Exception;

    /**
    * Return the type of object that this FactoryBean creates,
    * or {@code null} if not known in advance.
    * <p>This allows one to check for specific types of beans without
    * instantiating objects, for example on autowiring.
    * <p>In the case of implementations that are creating a singleton object,
    * this method should try to avoid singleton creation as far as possible;
    * it should rather estimate the type in advance.
    * For prototypes, returning a meaningful type here is advisable too.
    * <p>This method can be called <i>before</i> this FactoryBean has
    * been fully initialized. It must not rely on state created during
    * initialization; of course, it can still use such state if available.
    * <p><b>NOTE:</b> Autowiring will simply ignore FactoryBeans that return
    * {@code null} here. Therefore it is highly recommended to implement
    * this method properly, using the current state of the FactoryBean.
    * @return the type of object that this FactoryBean creates,
    * or {@code null} if not known at the time of the call
    * @see ListableBeanFactory#getBeansOfType
    */
    Class<?> getObjectType();

    /**
    * Is the object managed by this factory a singleton? That is,
    * will {@link #getObject()} always return the same object
    * (a reference that can be cached)?
    * <p><b>NOTE:</b> If a FactoryBean indicates to hold a singleton object,
    * the object returned from {@code getObject()} might get cached
    * by the owning BeanFactory. Hence, do not return {@code true}
    * unless the FactoryBean always exposes the same reference.
    * <p>The singleton status of the FactoryBean itself will generally
    * be provided by the owning BeanFactory; usually, it has to be
    * defined as singleton there.
    * <p><b>NOTE:</b> This method returning {@code false} does not
    * necessarily indicate that returned objects are independent instances.
    * An implementation of the extended {@link SmartFactoryBean} interface
    * may explicitly indicate independent instances through its
    * {@link SmartFactoryBean#isPrototype()} method. Plain {@link FactoryBean}
    * implementations which do not implement this extended interface are
    * simply assumed to always return independent instances if the
    * {@code isSingleton()} implementation returns {@code false}.
    * @return whether the exposed object is a singleton
    * @see #getObject()
    * @see SmartFactoryBean#isPrototype()
    */
    boolean isSingleton();

}
```

- 默认获取到的是工厂bean调用getObject创建的对象

- 要获取工厂Bean本身，我们需要给id前面加一个&colorFactoryBean

  

```java
//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {

    //返回一个Color对象，这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("ColorFactoryBean...getObject...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return Color.class;
    }

    //是单例？
    //true：这个bean是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean；
    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return false;
    }

}

//工厂Bean获取的是调用getObject创建的对象，要获取工厂Bean本身，我们需要给id前面加一个&colorFactoryBean
Object bean2 = applicationContext.getBean("colorFactoryBean");
Object bean3 = applicationContext.getBean("colorFactoryBean");
System.out.println("bean的类型："+bean2.getClass());//com.jochy.study.bean.Color
System.out.println(bean2 == bean3);//false

Object bean4 = applicationContext.getBean("&colorFactoryBean");//此前缀可在BeanFactory源码中找到
System.out.println(bean4.getClass());//com.jochy.study.bean.ColorFactoryBean
```



#### 给容器中注册组件的几种方式

- 包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]

- @Bean[导入的第三方包里面的组件]

- @Import[快速给容器中导入一个组件]
  - @Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
  - ImportSelector:返回需要导入的组件的全类名数组；
  - ImportBeanDefinitionRegistrar:手动注册bean到容器中

- 使用Spring提供的 FactoryBean（工厂Bean）
  - 默认获取到的是工厂bean调用getObject创建的对象
  - 要获取工厂Bean本身，我们需要给id前面加一个&&colorFactoryBean

#### Bean的生命周期

Bean的生命周期是由容器来管理的，Bean的生命周期主要有以下几个过程。Bean的创建----Bean的初始化----Bean的销毁

我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法。

##### 构造（对象创建）

- 单实例：在容器启动的时候创建对象

- 多实例：在每次获取的时候创建对象

BeanPostProcessor.postProcessBeforeInitialization

##### 初始化：

- 对象创建完成，并赋值好，调用初始化方法。。。

BeanPostProcessor.postProcessAfterInitialization

##### 销毁：

- 单实例：容器关闭的时候

- 多实例：容器不会管理这个bean；容器不会调用销毁方法；

##### 初始化以及销毁的几种方式

- 通过@Bean指定init-method和destroy-method；

  ```java
  @Component
  public class Car {
  
      public Car(){
          System.out.println("car constructor...");
      }
  
      public void init(){
          System.out.println("car ... init...");
      }
  
      public void detory(){
          System.out.println("car ... detory...");
      }
  
  }
  
  
  
  @Bean(initMethod="init",destroyMethod="detory")
  public Car car(){
      return new Car();
  }
  
  ```

- 通过让Bean实现InitializingBean（定义初始化逻辑），DisposableBean（定义销毁逻辑）;

  ```java
  @Component
  public class Cat implements InitializingBean,DisposableBean {
  
      public Cat(){
          System.out.println("cat constructor...");
      }
  
      @Override
      public void destroy() throws Exception {
          // TODO Auto-generated method stub
          System.out.println("cat...destroy...");
      }
  
      @Override
      public void afterPropertiesSet() throws Exception {
          // TODO Auto-generated method stub
          System.out.println("cat...afterPropertiesSet...");
      }
  
  }
  ```

- 可以使用JSR250

  @PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法

  @PreDestroy：在容器销毁bean之前通知我们进行清理工作

  ```java
  @Component
  public class Dog implements ApplicationContextAware {
  
      //@Autowired
      private ApplicationContext applicationContext;
  
      public Dog(){
          System.out.println("dog constructor...");
      }
  
      //对象创建并赋值之后调用
      @PostConstruct
      public void init(){
          System.out.println("Dog....@PostConstruct...");
      }
  
      //容器移除对象之前
      @PreDestroy
      public void detory(){
          System.out.println("Dog....@PreDestroy...");
      }
  
      @Override
      public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
          // TODO Auto-generated method stub
          this.applicationContext = applicationContext;
      }
  }
  ```

- BeanPostProcessor【interface】：bean的后置处理器

  ```java
  public interface BeanPostProcessor {
  
     /**
      * Apply this BeanPostProcessor to the given new bean instance <i>before</i> any bean
      * initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
      * or a custom init-method). The bean will already be populated with property values.
      * The returned bean instance may be a wrapper around the original.
      * @param bean the new bean instance
      * @param beanName the name of the bean
      * @return the bean instance to use, either the original or a wrapped one;
      * if {@code null}, no subsequent BeanPostProcessors will be invoked
      * @throws org.springframework.beans.BeansException in case of errors
      * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
      */
     Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;
  
     /**
      * Apply this BeanPostProcessor to the given new bean instance <i>after</i> any bean
      * initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
      * or a custom init-method). The bean will already be populated with property values.
      * The returned bean instance may be a wrapper around the original.
      * <p>In case of a FactoryBean, this callback will be invoked for both the FactoryBean
      * instance and the objects created by the FactoryBean (as of Spring 2.0). The
      * post-processor can decide whether to apply to either the FactoryBean or created
      * objects or both through corresponding {@code bean instanceof FactoryBean} checks.
      * <p>This callback will also be invoked after a short-circuiting triggered by a
      * {@link InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation} method,
      * in contrast to all other BeanPostProcessor callbacks.
      * @param bean the new bean instance
      * @param beanName the name of the bean
      * @return the bean instance to use, either the original or a wrapped one;
      * if {@code null}, no subsequent BeanPostProcessors will be invoked
      * @throws org.springframework.beans.BeansException in case of errors
      * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
      * @see org.springframework.beans.factory.FactoryBean
      */
     Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
  
  }
  ```

  在bean初始化前后进行一些处理工作；
   * 		postProcessBeforeInitialization:在初始化之前工作
   * 		postProcessAfterInitialization:在初始化之后工作

```java
    /**
     * 后置处理器：初始化前后进行处理工作
     * 将后置处理器加入到容器中
     * @author lfy
     */
    @Component
    public class MyBeanPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            // 每一个对象在初始化之前，会调用这个方法
            System.out.println("postProcessBeforeInitialization..."+beanName+"=>"+bean);
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            // 每一个对象在初始化之后，会调用这个方法
            System.out.println("postProcessAfterInitialization..."+beanName+"=>"+bean);
            return bean;
        }
    }
```

遍历得到容器中所有的BeanPostProcessor；挨个执行beforeInitialization，一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessorsBeforeInitialization。

AbstractAutowireCapableBeanFactory#doCreateBean()方法中断点查看。

```java
//给bean进行属性赋值
populateBean(beanName, mbd, instanceWrapper);

initializeBean

{

applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
//执行自定义初始化
invokeInitMethods(beanName, wrappedBean, mbd);

applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
}
```

Spring底层对 BeanPostProcessor 的使用；

 * 		bean赋值
 * 		注入其他组件
 * 		@Autowired，
 * 		命周期注解功能
 * 		@Async
 * 		xxx BeanPostProcessor;

### 属性赋值