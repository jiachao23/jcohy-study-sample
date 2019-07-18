#  Spring Annotation 注解版
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

@Bean标注的方法创建对象的时候，方法参数的值从容器中获取

```java
//此Car对象会自动从容器中获取
@Bean
public Color color(Car car){
   Color color = new Color();
   color.setCar(car);
   return color;
}


```

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

#### @Value

```java
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

   /**
    * The actual value expression: for example {@code #{systemProperties.myProp}}.
    */
   String value();

}
```

	//1、基本数值
	//2、可以写SpEL； #{}
	//3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）
```java
@Value("张三")
private String name;
@Value("#{20-2}")
private Integer age;

@Value("${person.nickName}")
private String nickName;
```

#### @PropertySource和@PropertySources

使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;加载完外部的配置文件以后使用${}取出配置文件的值

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(PropertySources.class)
public @interface PropertySource {

   /**
    * Indicate the name of this property source. If omitted, a name will
    * be generated based on the description of the underlying resource.
    * @see org.springframework.core.env.PropertySource#getName()
    * @see org.springframework.core.io.Resource#getDescription()
    */
   String name() default "";

   /**
    * Indicate the resource location(s) of the properties file to be loaded.
    * For example, {@code "classpath:/com/myco/app.properties"} or
    * {@code "file:/path/to/file"}.
    * <p>Resource location wildcards (e.g. *&#42;/*.properties) are not permitted;
    * each location must evaluate to exactly one {@code .properties} resource.
    * <p>${...} placeholders will be resolved against any/all property sources already
    * registered with the {@code Environment}. See {@linkplain PropertySource above}
    * for examples.
    * <p>Each location will be added to the enclosing {@code Environment} as its own
    * property source, and in the order declared.
    */
   String[] value();

   /**
    * Indicate if failure to find the a {@link #value() property resource} should be
    * ignored.
    * <p>{@code true} is appropriate if the properties file is completely optional.
    * Default is {@code false}.
    * @since 4.0
    */
   boolean ignoreResourceNotFound() default false;

   /**
    * A specific character encoding for the given resources, e.g. "UTF-8".
    * @since 4.3
    */
   String encoding() default "";

   /**
    * Specify a custom {@link PropertySourceFactory}, if any.
    * <p>By default, a default factory for standard resource files will be used.
    * @since 4.3
    * @see org.springframework.core.io.support.DefaultPropertySourceFactory
    * @see org.springframework.core.io.support.ResourcePropertySource
    */
   Class<? extends PropertySourceFactory> factory() default PropertySourceFactory.class;

}
```

#### @Autowired

自动装配;Spring利用依赖注入（DI），完成对IOC容器中中各个组件的依赖关系赋值；

```java
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

   /**
    * Declares whether the annotated dependency is required.
    * <p>Defaults to {@code true}.
    */
   boolean required() default true;

}

```

@Autowired:构造器，参数，方法，属性；都是从容器中获取参数组件的值
1）、[标注在方法位置]：@Bean+方法参数；参数从容器中获取;默认不写@Autowired效果是一样的；都能自动装配
2）、[标在构造器上]：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
3）、放在参数位置：

- @Autowired：自动注入：

  1）、默认优先按照类型去容器中找对应的组件:applicationContext.getBean(BookDao.class);找到就赋值

  2）、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找

  3）、@Qualifier("bookDao")：使用@Qualifier指定需要装配的组件的id，而不是使用属性名

  4）、自动装配默认一定要将属性赋值好，没有就会报错；可以使用@Autowired(required=false);

  5）、@Primary：让Spring进行自动装配的时候，默认使用首选的bean；也可以继续使用@Qualifier指定需要装配的bean的名字

- @Qualifier

  我们知道，自动装配注入时，可以使用@Resource或者@Autowired注入bean。 但有时候仅仅一个bean_id还无法清晰明确出要注入的bean，因此可以引入**@Qualifier**注解。使用@Qualifier指定需要装配的组件的id，而不是使用属性名

```java
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";

}
```

- @Primary

  让Spring进行自动装配的时候，默认使用首选的bean；也可以继续使用@Qualifier指定需要装配的bean的名字

```java
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Primary {

}
```

#### @Resource(JSR250)和@Inject(JSR330)[java规范的注解]

- @Resource:可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的；没有能支持@Primary功能没有支持@Autowired（reqiured=false）;
- @Inject:需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能；

- @Autowired:Spring定义的； @Resource、@Inject都是java规范

- AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能；

#### 自定义组件

自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）；

自定义组件实现xxxAware；在创建对象的时候，会调用接口规定的方法注入相关组件；Aware；

把Spring底层一些组件注入到自定义的Bean中；

xxxAware：功能使用xxxProcessor；

ApplicationContextAware==》ApplicationContextAwareProcessor；



#### @Profile

Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；

@Profile：指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件

```java
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(ProfileCondition.class)
public @interface Profile {

   /**
    * The set of profiles for which the annotated component should be registered.
    */
   String[] value();

}
```

1）、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境

2）、写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效

3）、没有标注环境标识的bean在，任何环境下都是加载的；



如何激活一个环境：

- 使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test

- 代码的方式激活某种环境；

  ```java
  AnnotationConfigApplicationContext applicationContext = 
        new AnnotationConfigApplicationContext();
  //1、创建一个applicationContext
  //2、设置需要激活的环境
  applicationContext.getEnvironment().setActiveProfiles("dev");
  //3、注册主配置类
  applicationContext.register(MainConfigOfProfile.class);
  //4、启动刷新容器
  applicationContext.refresh();
  ```

- 通过属性文件：spring.profiles.active=dev

### AOP

【动态代理】：指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式

#### @Aspect

声明一个切面

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Aspect {

    /**
     * Per clause expression, defaults to singleton aspect
     * <p/>
     * Valid values are "" (singleton), "perthis(...)", etc
     */
    public String value() default "";
}
```

#### @Before

前置通知:在目标方法运行之前运行

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Before {

    /**
     * The pointcut expression where to bind the advice
     */
    String value();
    
    /**
     * When compiling without debug info, or when interpreting pointcuts at runtime,
     * the names of any arguments used in the advice declaration are not available.
     * Under these circumstances only, it is necessary to provide the arg names in 
     * the annotation - these MUST duplicate the names used in the annotated method.
     * Format is a simple comma-separated list.
     */
    String argNames() default "";

}
```

#### @After

后置通知：在目标方法之后运行

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface After {

    /**
     * The pointcut expression where to bind the advice
     */
    String value();
    
    /**
     * When compiling without debug info, or when interpreting pointcuts at runtime,
     * the names of any arguments used in the advice declaration are not available.
     * Under these circumstances only, it is necessary to provide the arg names in 
     * the annotation - these MUST duplicate the names used in the annotated method.
     * Format is a simple comma-separated list.
     */
    String argNames() default "";
}
```

#### @AfterReturning

返回通知：在目标方法正常返回之后运行

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AfterReturning {

    /**
     * The pointcut expression where to bind the advice
     */
    String value() default "";

    /**
     * The pointcut expression where to bind the advice, overrides "value" when specified
     */
    String pointcut() default "";

    /**
     * The name of the argument in the advice signature to bind the returned value to
     */
    String returning() default "";
    
    /**
     * When compiling without debug info, or when interpreting pointcuts at runtime,
     * the names of any arguments used in the advice declaration are not available.
     * Under these circumstances only, it is necessary to provide the arg names in 
     * the annotation - these MUST duplicate the names used in the annotated method.
     * Format is a simple comma-separated list.
     */
    String argNames() default "";

}
```

#### @AfterThrowing

异常通知：在目标方法出现异常以后运行

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AfterThrowing {

    /**
     * The pointcut expression where to bind the advice
     */
    String value() default "";

    /**
     * The pointcut expression where to bind the advice, overrides "value" when specified
     */
    String pointcut() default "";

    /**
     * The name of the argument in the advice signature to bind the thrown exception to
     */
    String throwing() default "";
    
    /**
     * When compiling without debug info, or when interpreting pointcuts at runtime,
     * the names of any arguments used in the advice declaration are not available.
     * Under these circumstances only, it is necessary to provide the arg names in 
     * the annotation - these MUST duplicate the names used in the annotated method.
     * Format is a simple comma-separated list.
     */
    String argNames() default "";

}
```

#### @Around

环绕通知：动态代理，手动推进目标方法运行（joinPoint.procced()）

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Around {

    /**
     * The pointcut expression where to bind the advice
     */
    String value();
    
    /**
     * When compiling without debug info, or when interpreting pointcuts at runtime,
     * the names of any arguments used in the advice declaration are not available.
     * Under these circumstances only, it is necessary to provide the arg names in 
     * the annotation - these MUST duplicate the names used in the annotated method.
     * Format is a simple comma-separated list.
     */
    String argNames() default "";

}
```

#### @Pointcut

声明一个切点

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Pointcut {

    /**
     * The pointcut expression
     * We allow "" as default for abstract pointcut
     */
    String value() default "";
    
    /**
     * When compiling without debug info, or when interpreting pointcuts at runtime,
     * the names of any arguments used in the pointcut are not available.
     * Under these circumstances only, it is necessary to provide the arg names in 
     * the annotation - these MUST duplicate the names used in the annotated method.
     * Format is a simple comma-separated list.
     */
    String argNames() default "";
}
```

有关于切点的表达式和详细信息，[参考地址](https://github.com/DocsHome/spring-docs/blob/master/pages/core/aop.md#aop-pointcuts)

#### @EnableAspectJAutoProxy

开启基于注解的AOP模式

#### AOP原理

##### 1、首先我们从**@EnableAspectJAutoProxy**入手，如下：

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//给容器中导入AspectJAutoProxyRegistrar
@Import(AspectJAutoProxyRegistrar.class)
public @interface EnableAspectJAutoProxy {

   /**
    * Indicate whether subclass-based (CGLIB) proxies are to be created as opposed
    * to standard Java interface-based proxies. The default is {@code false}.
    */
   boolean proxyTargetClass() default false;

   /**
    * Indicate that the proxy should be exposed by the AOP framework as a {@code ThreadLocal}
    * for retrieval via the {@link org.springframework.aop.framework.AopContext} class.
    * Off by default, i.e. no guarantees that {@code AopContext} access will work.
    * @since 4.3.1
    */
   boolean exposeProxy() default false;

}
```

给容器中导入 **AspectJAutoProxyRegistrar** , **AspectJAutoProxyRegistrar** 组件是什么呢？我们接着往下看。

```java
class AspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar {

    /**
    * Register, escalate, and configure the AspectJ auto proxy creator based on the value
    * of the @{@link EnableAspectJAutoProxy#proxyTargetClass()} attribute on the importing
    * {@code @Configuration} class.
    */
    @Override
    public void registerBeanDefinitions(
        AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        /**
         *	利用AspectJAutoProxyRegistrar自定义给容器中注册bean；BeanDefinetion
         *	AnnotationAwareAspectJAutoProxyCreator类型的internalAutoProxyCreator
         */
        AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);

        AnnotationAttributes enableAspectJAutoProxy =
            AnnotationConfigUtils.attributesFor(importingClassMetadata, EnableAspectJAutoProxy.class);
        if (enableAspectJAutoProxy.getBoolean("proxyTargetClass")) {
            AopConfigUtils.forceAutoProxyCreatorToUseClassProxying(registry);
        }
        if (enableAspectJAutoProxy.getBoolean("exposeProxy")) {
            AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
        }
    }

}


@Nullable
public static BeanDefinition registerAspectJAnnotationAutoProxyCreatorIfNecessary(BeanDefinitionRegistry registry) {
    return registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry, null);
}


@Nullable
public static BeanDefinition registerAspectJAnnotationAutoProxyCreatorIfNecessary(
    BeanDefinitionRegistry registry, @Nullable Object source) {

    return registerOrEscalateApcAsRequired(AnnotationAwareAspectJAutoProxyCreator.class, registry, source);
}

//
@Nullable
private static BeanDefinition registerOrEscalateApcAsRequired(
    Class<?> cls, BeanDefinitionRegistry registry, @Nullable Object source) {

    Assert.notNull(registry, "BeanDefinitionRegistry must not be null");
    //public static final String AUTO_PROXY_CREATOR_BEAN_NAME ="org.springframework.aop.config.internalAutoProxyCreator";
    if (registry.containsBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME)) {
        BeanDefinition apcDefinition = registry.getBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME);
        if (!cls.getName().equals(apcDefinition.getBeanClassName())) {
            int currentPriority = findPriorityForClass(apcDefinition.getBeanClassName());
            int requiredPriority = findPriorityForClass(cls);
            if (currentPriority < requiredPriority) {
                apcDefinition.setBeanClassName(cls.getName());
            }
        }
        return null;
    }

    RootBeanDefinition beanDefinition = new RootBeanDefinition(cls);
    beanDefinition.setSource(source);
    beanDefinition.getPropertyValues().add("order", Ordered.HIGHEST_PRECEDENCE);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    registry.registerBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME, beanDefinition);
    return beanDefinition;
}
```

**AspectJAutoProxyRegistrar** 实现了 **ImportBeanDefinitionRegistrar** 。ImportBeanDefinitionRegistrar** 这个接口可以动态的给容器中注入Bean。通过源码可知，给容器中注册一个 **AnnotationAwareAspectJAutoProxyCreator** 

##### 2、**AnnotationAwareAspectJAutoProxyCreator** 组件的功能：

首先来看他的继承关系

![](C:\Users\SEELE\Desktop\AnnotationAwareAspectJAutoProxyCreator.jpg)



**AnnotationAwareAspectJAutoProxyCreator**  关注两点，他实现了 **SmartInstantiationAwareBeanPostProcessor** 和 **BeanFactoryAware** 接口。关注后置处理器（在bean初始化完成前后做事情）、自动装配BeanFactory。

在 **AbstractAutoProxyCreator** 查找关于 bean的后置处理器和 和自动装配相关的 方法。

```java
//此处只是赋值，还需继续再子类查看具有业务的处理流程
@Override
public void setBeanFactory(BeanFactory beanFactory) {
    this.beanFactory = beanFactory;
}

@Override
public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) {
    Object cacheKey = getCacheKey(beanClass, beanName);

    if (!StringUtils.hasLength(beanName) || !this.targetSourcedBeans.contains(beanName)) {
        if (this.advisedBeans.containsKey(cacheKey)) {
            return null;
        }
        if (isInfrastructureClass(beanClass) || shouldSkip(beanClass, beanName)) {
            this.advisedBeans.put(cacheKey, Boolean.FALSE);
            return null;
        }
    }

    // Create proxy here if we have a custom TargetSource.
    // Suppresses unnecessary default instantiation of the target bean:
    // The TargetSource will handle target instances in a custom fashion.
    TargetSource targetSource = getCustomTargetSource(beanClass, beanName);
    if (targetSource != null) {
        if (StringUtils.hasLength(beanName)) {
            this.targetSourcedBeans.add(beanName);
        }
        Object[] specificInterceptors = getAdvicesAndAdvisorsForBean(beanClass, beanName, targetSource);
        Object proxy = createProxy(beanClass, beanName, specificInterceptors, targetSource);
        this.proxyTypes.put(cacheKey, proxy.getClass());
        return proxy;
    }

    return null;
}

/**
	 * Create a proxy with the configured interceptors if the bean is
	 * identified as one to proxy by the subclass.
	 * @see #getAdvicesAndAdvisorsForBean
	 */
@Override
public Object postProcessAfterInitialization(@Nullable Object bean, String beanName) {
    if (bean != null) {
        Object cacheKey = getCacheKey(bean.getClass(), beanName);
        if (this.earlyProxyReferences.remove(cacheKey) != bean) {
            return wrapIfNecessary(bean, beanName, cacheKey);
        }
    }
    return bean;
}

```

AbstractAdvisorAutoProxyCreator#setBeanFactory（）

```java
@Override
public void setBeanFactory(BeanFactory beanFactory) {
    super.setBeanFactory(beanFactory);
    if (!(beanFactory instanceof ConfigurableListableBeanFactory)) {
        throw new IllegalArgumentException(
            "AdvisorAutoProxyCreator requires a ConfigurableListableBeanFactory: " + beanFactory);
    }
    initBeanFactory((ConfigurableListableBeanFactory) beanFactory);
}

//实际调用子类的initBeanFactory方法
protected void initBeanFactory(ConfigurableListableBeanFactory beanFactory) {
    this.advisorRetrievalHelper = new BeanFactoryAdvisorRetrievalHelperAdapter(beanFactory);
}

/**
* Subclass of BeanFactoryAdvisorRetrievalHelper that delegates to
* surrounding AbstractAdvisorAutoProxyCreator facilities.
*/
private class BeanFactoryAdvisorRetrievalHelperAdapter extends BeanFactoryAdvisorRetrievalHelper {

    public BeanFactoryAdvisorRetrievalHelperAdapter(ConfigurableListableBeanFactory beanFactory) {
        super(beanFactory);
    }

    @Override
    protected boolean isEligibleBean(String beanName) {
        return AbstractAdvisorAutoProxyCreator.this.isEligibleAdvisorBean(beanName);
    }
}
```

AnnotationAwareAspectJAutoProxyCreator#initBeanFactory()

```java
@Override
//重写父类的initBeanFactory方法。
protected void initBeanFactory(ConfigurableListableBeanFactory beanFactory) {
    super.initBeanFactory(beanFactory);
    if (this.aspectJAdvisorFactory == null) {
        this.aspectJAdvisorFactory = new ReflectiveAspectJAdvisorFactory(beanFactory);
    }
    this.aspectJAdvisorsBuilder =
        new BeanFactoryAspectJAdvisorsBuilderAdapter(beanFactory, this.aspectJAdvisorFactory);
}
```

##### 3、流程分析

​	创建和注册AnnotationAwareAspectJAutoProxyCreator的过程

- 1）、传入配置类，创建IOC容器

- 2）、注册配置类，调用refresh()刷新容器

- 3）、registerBeanPostProcessors(beanFactory);注册bean的后置处理器来方便拦截bean的创建；

  - 1）、先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor

  - 2）、给容器中加别的BeanPostProcessor

  - 3）、优先注册实现了PriorityOrdered接口的BeanPostProcessor；

  - 4）、再给容器中注册实现了Ordered接口的BeanPostProcessor；

  - 5）、注册没实现优先级接口的BeanPostProcessor；

  - 6）、注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存在容器中；

    ​	创建internalAutoProxyCreator的BeanPostProcessor【AnnotationAwareAspectJAutoProxyCreator】

    - 1）、创建Bean的实例
    - 2）、populateBean；给bean的各种属性赋值
    - 3）、initializeBean：初始化bean；
      - 1）、invokeAwareMethods()：处理Aware接口的方法回调
      - 2）、applyBeanPostProcessorsBeforeInitialization()：应用后置处理器的postProcessBeforeInitialization（）
      - 3）、invokeInitMethods()；执行自定义的初始化方法
      - 4）、applyBeanPostProcessorsAfterInitialization()；执行后置处理器的postProcessAfterInitialization（）；
    - 4）、BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功；--》aspectJAdvisorsBuilder

  - 7）、把BeanPostProcessor注册到BeanFactory中，beanFactory.addBeanPostProcessor(postProcessor);；

    以上是创建和注册AnnotationAwareAspectJAutoProxyCreator的过程

- 4）、finishBeanFactoryInitialization(beanFactory);完成BeanFactory初始化工作；创建剩下的单实例bean

  - 1）、遍历获取容器中所有的Bean，依次创建对象getBean(beanName)，getBean->doGetBean()->getSingleton()->;

  - 2）、创建bean

    【AnnotationAwareAspectJAutoProxyCreator在所有bean创建之前会有一个拦截，InstantiationAwareBeanPostProcessor，会调用postProcessBeforeInstantiation()

     - 1）、先从缓存中获取当前bean，如果能获取到，说明bean是之前被创建过的，直接使用，否则再创建；只要创建好的Bean都会被缓存起来

     - 2）、createBean（）;创建bean；

       AnnotationAwareAspectJAutoProxyCreator 会在任何bean创建之前先尝试返回bean的实例

       【BeanPostProcessor是在Bean对象创建完成初始化前后调用的】

       【InstantiationAwareBeanPostProcessor是在创建Bean实例之前先尝试用后置处理器返回对象的】

       - 1）、resolveBeforeInstantiation(beanName, mbdToUse);解析BeforeInstantiation，希望后置处理器在此能返回一个代理对象；如果能返回代理对象就使用，如果不能就继续

         - 1）、后置处理器先尝试返回对象；

       ```java
       bean = applyBeanPostProcessorsBeforeInstantiation（）：
         //                       拿到所有后置处理器，如果是InstantiationAwareBeanPostProcessor;
       //就执行postProcessBeforeInstantiation
                             if (bean != null) {
                              bean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
                           }
       ```
       - 2）、doCreateBean(beanName, mbdToUse, args);真正的去创建一个bean实例；和3.6流程一样
       - 3）、
    



  ##### 4、AnnotationAwareAspectJAutoProxyCreator【InstantiationAwareBeanPostProcessor】的作用：
- 1）、每一个bean创建之前，调用postProcessBeforeInstantiation()；
  关心MathCalculator和LogAspect的创建

  - 1）、判断当前bean是否在advisedBeans中（保存了所有需要增强bean）
  - 2）、判断当前bean是否是基础类型的Advice、Pointcut、Advisor、AopInfrastructureBean，或者是否是切面（@Aspect）
  - 3）、是否需要跳过
    - 1）、获取候选的增强器（切面里面的通知方法）【List<Advisor> candidateAdvisors】，每一个封装的通知方法的增强器是InstantiationModelAwarePointcutAdvisor；
        判断每一个增强器是否是 AspectJPointcutAdvisor 类型的；返回true
    - 2）、永远返回false

- 2）、创建对象

  postProcessAfterInitialization；
  return wrapIfNecessary(bean, beanName, cacheKey);//包装如果需要的情况下
  - 1）、获取当前bean的所有增强器（通知方法）  Object[]  specificInterceptors
    - 1、找到候选的所有的增强器（找哪些通知方法是需要切入当前bean方法的）
    - 2、获取到能在bean使用的增强器。
    - 3、给增强器排序
  - 2）、保存当前bean在advisedBeans中；
  - 3）、如果当前bean需要增强，创建当前bean的代理对象；
    - 1）、获取所有增强器（通知方法）
    - 2）、保存到proxyFactory
    - 3）、创建代理对象：Spring自动决定
       JdkDynamicAopProxy(config);jdk动态代理；
       ObjenesisCglibAopProxy(config);cglib的动态代理；
  - 4）、给容器中返回当前组件使用cglib增强了的代理对象；
  - 5）、以后容器中获取到的就是这个组件的代理对象，执行目标方法的时候，代理对象就会执行通知方法的流程；


- 3）、目标方法执行	；

  容器中保存了组件的代理对象（cglib增强后的对象），这个对象里面保存了详细信息（比如增强器，目标对象，xxx）；

    - 1）、CglibAopProxy.intercept();拦截目标方法的执行

    - 2）、根据ProxyFactory对象获取将要执行的目标方法拦截器链；
         		

         ```java
         List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);
         ```

      - 1）、List<Object> interceptorList保存所有拦截器 5
         		一个默认的ExposeInvocationInterceptor 和 4个增强器；

      - 2）、遍历所有的增强器，将其转为Interceptor；
         		registry.getInterceptors(advisor);

      - 3）、将增强器转为List<MethodInterceptor>；
        			如果是MethodInterceptor，直接加入到集合中
              			如果不是，使用AdvisorAdapter将增强器转为MethodInterceptor；
              			转换完成返回MethodInterceptor数组；

   - 3）、如果没有拦截器链，直接执行目标方法;
       			拦截器链（每一个通知方法又被包装为方法拦截器，利用MethodInterceptor机制）
   - 4）、如果有拦截器链，把需要执行的目标对象，目标方法，
       			拦截器链等信息传入创建一个 CglibMethodInvocation 对象，
       			并调用 Object retVal =  mi.proceed();
   - 5）、拦截器链的触发过程;

     - 1）、如果没有拦截器执行执行目标方法，或者拦截器的索引和拦截器数组-1大小一样（指定到了最后一个拦截器）执行目标方法；
     - 2）、链式获取每一个拦截器，拦截器执行invoke方法，每一个拦截器等待下一个拦截器执行完成返回以后再来执行；拦截器链的机制，保证通知方法与目标方法的执行顺序；

总结：

- 1）、  @EnableAspectJAutoProxy 开启AOP功能
- 2）、 @EnableAspectJAutoProxy 会给容器中注册一个组件 AnnotationAwareAspectJAutoProxyCreator
- 3）、AnnotationAwareAspectJAutoProxyCreator是一个后置处理器；
- 4）、容器的创建流程：
    - 1）、registerBeanPostProcessors（）注册后置处理器；创建AnnotationAwareAspectJAutoProxyCreator对象
    - 2）、finishBeanFactoryInitialization（）初始化剩下的单实例bean
        - 1）、创建业务逻辑组件和切面组件
        - 2）、AnnotationAwareAspectJAutoProxyCreator拦截组件的创建过程
        - 3）、组件创建完之后，判断组件是否需要增强。是：切面的通知方法，包装成增强器（Advisor）;给业务逻辑组件创建一个代理对象（cglib）；
 - 5）、执行目标方法：
    - 1）、代理对象执行目标方法
    - 2）、CglibAopProxy.intercept()；
        - 1）、得到目标方法的拦截器链（增强器包装成拦截器MethodInterceptor）
        - 2）、利用拦截器的链式机制，依次进入每一个拦截器进行执行；
        - 3）、效果：
            正常执行：前置通知-》目标方法-》后置通知-》返回通知
            出现异常：前置通知-》目标方法-》后置通知-》异常通知

#### 声明式事务

##### @EnableTransactionManagement

开启基于注解的事务管理功能；

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(TransactionManagementConfigurationSelector.class)
public @interface EnableTransactionManagement {

   /**
    * Indicate whether subclass-based (CGLIB) proxies are to be created ({@code true}) as
    * opposed to standard Java interface-based proxies ({@code false}). The default is
    * {@code false}. <strong>Applicable only if {@link #mode()} is set to
    * {@link AdviceMode#PROXY}</strong>.
    * <p>Note that setting this attribute to {@code true} will affect <em>all</em>
    * Spring-managed beans requiring proxying, not just those marked with
    * {@code @Transactional}. For example, other beans marked with Spring's
    * {@code @Async} annotation will be upgraded to subclass proxying at the same
    * time. This approach has no negative impact in practice unless one is explicitly
    * expecting one type of proxy vs another, e.g. in tests.
    */
   boolean proxyTargetClass() default false;

   /**
    * Indicate how transactional advice should be applied.
    * <p><b>The default is {@link AdviceMode#PROXY}.</b>
    * Please note that proxy mode allows for interception of calls through the proxy
    * only. Local calls within the same class cannot get intercepted that way; an
    * {@link Transactional} annotation on such a method within a local call will be
    * ignored since Spring's interceptor does not even kick in for such a runtime
    * scenario. For a more advanced mode of interception, consider switching this to
    * {@link AdviceMode#ASPECTJ}.
    */
   AdviceMode mode() default AdviceMode.PROXY;

   /**
    * Indicate the ordering of the execution of the transaction advisor
    * when multiple advices are applied at a specific joinpoint.
    * <p>The default is {@link Ordered#LOWEST_PRECEDENCE}.
    */
   int order() default Ordered.LOWEST_PRECEDENCE;

}
```

##### @Transactional 
表示当前方法是一个事务方法；

```java
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Transactional {

   /**
    * Alias for {@link #transactionManager}.
    * @see #transactionManager
    */
   @AliasFor("transactionManager")
   String value() default "";

   /**
    * A <em>qualifier</em> value for the specified transaction.
    * <p>May be used to determine the target transaction manager,
    * matching the qualifier value (or the bean name) of a specific
    * {@link org.springframework.transaction.PlatformTransactionManager}
    * bean definition.
    * @since 4.2
    * @see #value
    */
   @AliasFor("value")
   String transactionManager() default "";

   /**
    * The transaction propagation type.
    * <p>Defaults to {@link Propagation#REQUIRED}.
    * @see org.springframework.transaction.interceptor.TransactionAttribute#getPropagationBehavior()
    */
   Propagation propagation() default Propagation.REQUIRED;

   /**
    * The transaction isolation level.
    * <p>Defaults to {@link Isolation#DEFAULT}.
    * <p>Exclusively designed for use with {@link Propagation#REQUIRED} or
    * {@link Propagation#REQUIRES_NEW} since it only applies to newly started
    * transactions. Consider switching the "validateExistingTransactions" flag to
    * "true" on your transaction manager if you'd like isolation level declarations
    * to get rejected when participating in an existing transaction with a different
    * isolation level.
    * @see org.springframework.transaction.interceptor.TransactionAttribute#getIsolationLevel()
    * @see org.springframework.transaction.support.AbstractPlatformTransactionManager#setValidateExistingTransaction
    */
   Isolation isolation() default Isolation.DEFAULT;

   /**
    * The timeout for this transaction (in seconds).
    * <p>Defaults to the default timeout of the underlying transaction system.
    * <p>Exclusively designed for use with {@link Propagation#REQUIRED} or
    * {@link Propagation#REQUIRES_NEW} since it only applies to newly started
    * transactions.
    * @see org.springframework.transaction.interceptor.TransactionAttribute#getTimeout()
    */
   int timeout() default TransactionDefinition.TIMEOUT_DEFAULT;

   /**
    * A boolean flag that can be set to {@code true} if the transaction is
    * effectively read-only, allowing for corresponding optimizations at runtime.
    * <p>Defaults to {@code false}.
    * <p>This just serves as a hint for the actual transaction subsystem;
    * it will <i>not necessarily</i> cause failure of write access attempts.
    * A transaction manager which cannot interpret the read-only hint will
    * <i>not</i> throw an exception when asked for a read-only transaction
    * but rather silently ignore the hint.
    * @see org.springframework.transaction.interceptor.TransactionAttribute#isReadOnly()
    * @see org.springframework.transaction.support.TransactionSynchronizationManager#isCurrentTransactionReadOnly()
    */
   boolean readOnly() default false;

   /**
    * Defines zero (0) or more exception {@link Class classes}, which must be
    * subclasses of {@link Throwable}, indicating which exception types must cause
    * a transaction rollback.
    * <p>By default, a transaction will be rolling back on {@link RuntimeException}
    * and {@link Error} but not on checked exceptions (business exceptions). See
    * {@link org.springframework.transaction.interceptor.DefaultTransactionAttribute#rollbackOn(Throwable)}
    * for a detailed explanation.
    * <p>This is the preferred way to construct a rollback rule (in contrast to
    * {@link #rollbackForClassName}), matching the exception class and its subclasses.
    * <p>Similar to {@link org.springframework.transaction.interceptor.RollbackRuleAttribute#RollbackRuleAttribute(Class clazz)}.
    * @see #rollbackForClassName
    * @see org.springframework.transaction.interceptor.DefaultTransactionAttribute#rollbackOn(Throwable)
    */
   Class<? extends Throwable>[] rollbackFor() default {};

   /**
    * Defines zero (0) or more exception names (for exceptions which must be a
    * subclass of {@link Throwable}), indicating which exception types must cause
    * a transaction rollback.
    * <p>This can be a substring of a fully qualified class name, with no wildcard
    * support at present. For example, a value of {@code "ServletException"} would
    * match {@code javax.servlet.ServletException} and its subclasses.
    * <p><b>NB:</b> Consider carefully how specific the pattern is and whether
    * to include package information (which isn't mandatory). For example,
    * {@code "Exception"} will match nearly anything and will probably hide other
    * rules. {@code "java.lang.Exception"} would be correct if {@code "Exception"}
    * were meant to define a rule for all checked exceptions. With more unusual
    * {@link Exception} names such as {@code "BaseBusinessException"} there is no
    * need to use a FQN.
    * <p>Similar to {@link org.springframework.transaction.interceptor.RollbackRuleAttribute#RollbackRuleAttribute(String exceptionName)}.
    * @see #rollbackFor
    * @see org.springframework.transaction.interceptor.DefaultTransactionAttribute#rollbackOn(Throwable)
    */
   String[] rollbackForClassName() default {};

   /**
    * Defines zero (0) or more exception {@link Class Classes}, which must be
    * subclasses of {@link Throwable}, indicating which exception types must
    * <b>not</b> cause a transaction rollback.
    * <p>This is the preferred way to construct a rollback rule (in contrast
    * to {@link #noRollbackForClassName}), matching the exception class and
    * its subclasses.
    * <p>Similar to {@link org.springframework.transaction.interceptor.NoRollbackRuleAttribute#NoRollbackRuleAttribute(Class clazz)}.
    * @see #noRollbackForClassName
    * @see org.springframework.transaction.interceptor.DefaultTransactionAttribute#rollbackOn(Throwable)
    */
   Class<? extends Throwable>[] noRollbackFor() default {};

   /**
    * Defines zero (0) or more exception names (for exceptions which must be a
    * subclass of {@link Throwable}) indicating which exception types must <b>not</b>
    * cause a transaction rollback.
    * <p>See the description of {@link #rollbackForClassName} for further
    * information on how the specified names are treated.
    * <p>Similar to {@link org.springframework.transaction.interceptor.NoRollbackRuleAttribute#NoRollbackRuleAttribute(String exceptionName)}.
    * @see #noRollbackFor
    * @see org.springframework.transaction.interceptor.DefaultTransactionAttribute#rollbackOn(Throwable)
    */
   String[] noRollbackForClassName() default {};

}
```

```java
//注册事务管理器在容器中
@Bean
public PlatformTransactionManager transactionManager() throws Exception{
   return new DataSourceTransactionManager(dataSource());
}
```

##### 原理

从  **@EnableTransactionManagement** 的定义我们看出，Spring在开启事务管理时向我们容器导入了 **TransactionManagementConfigurationSelector** 组件。这个组件是做什么的？。我们来看看他的定义：

```java
public class TransactionManagementConfigurationSelector extends AdviceModeImportSelector<EnableTransactionManagement> {

   /**
    * Returns {@link ProxyTransactionManagementConfiguration} or
    * {@code AspectJ(Jta)TransactionManagementConfiguration} for {@code PROXY}
    * and {@code ASPECTJ} values of {@link EnableTransactionManagement#mode()},
    * respectively.
    */
   @Override
   protected String[] selectImports(AdviceMode adviceMode) {
      switch (adviceMode) {
         case PROXY:
            return new String[] {AutoProxyRegistrar.class.getName(),
                  ProxyTransactionManagementConfiguration.class.getName()};
         case ASPECTJ:
            return new String[] {determineTransactionAspectClass()};
         default:
            return null;
      }
   }

   private String determineTransactionAspectClass() {
      return (ClassUtils.isPresent("javax.transaction.Transactional", getClass().getClassLoader()) ?
            TransactionManagementConfigUtils.JTA_TRANSACTION_ASPECT_CONFIGURATION_CLASS_NAME :
            TransactionManagementConfigUtils.TRANSACTION_ASPECT_CONFIGURATION_CLASS_NAME);
   }

}
```

**TransactionManagementConfigurationSelector**  向我们容器中导入了 

**AutoProxyRegistrar**  和  **ProxyTransactionManagementConfiguration**  组件。

- AutoProxyRegistrar

  给容器中注册一个  **InfrastructureAdvisorAutoProxyCreator**  组件；利用后置处理器机制在对象创建以后，包装对象，返回一个代理对象（增强器），代理对象执行方法利用拦截器链进行调用；

- **ProxyTransactionManagementConfiguration**

  - 1、给容器中注册事务增强器；
    - 1）、事务增强器要用事务注解的信息， **AnnotationTransactionAttributeSource** 解析事务注解
    - 2）、事务拦截器：**TransactionInterceptor** ；保存了事务属性信息，事务管理器。他是一个  **MethodInterceptor** ；
      在目标方法执行的时候；执行拦截器链；
 - 2、事务拦截器：
    - 1）、先获取事务相关的属性
    - 2）、再获取 **PlatformTransactionManager** ，如果事先没有添加指定任何 **transactionmanger** 最终会从容器中按照类型获取一个  **PlatformTransactionManager** ；
    - 3）、执行目标方法
        如果异常，获取到事务管理器，利用事务管理回滚操作；
        如果正常，利用事务管理器，提交事务

## 扩展原理

#### BeanFactoryPostProcessor

- **BeanPostProcessor** ：bean后置处理器，bean创建对象初始化前后进行拦截工作的。

  ```java
  public interface BeanPostProcessor {
  
     /**
      * Apply this BeanPostProcessor to the given new bean instance <i>before</i> any bean
      * initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
      * or a custom init-method). The bean will already be populated with property values.
      * The returned bean instance may be a wrapper around the original.
      * <p>The default implementation returns the given {@code bean} as-is.
      * @param bean the new bean instance
      * @param beanName the name of the bean
      * @return the bean instance to use, either the original or a wrapped one;
      * if {@code null}, no subsequent BeanPostProcessors will be invoked
      * @throws org.springframework.beans.BeansException in case of errors
      * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
      */
     @Nullable
     default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
     }
  
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
      * <p>The default implementation returns the given {@code bean} as-is.
      * @param bean the new bean instance
      * @param beanName the name of the bean
      * @return the bean instance to use, either the original or a wrapped one;
      * if {@code null}, no subsequent BeanPostProcessors will be invoked
      * @throws org.springframework.beans.BeansException in case of errors
      * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
      * @see org.springframework.beans.factory.FactoryBean
      */
     @Nullable
     default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
     }
  
  }
  
  //示例
  /**
   * 后置处理器：初始化前后进行处理工作
   * 将后置处理器加入到容器中
   * 代码地址：https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-spring/src/main/java/com/jcohy/study/ext/MyBeanFactoryPostProcessor.java
   * @author lfy
   */
  @Component
  public class MyBeanPostProcessor implements BeanPostProcessor {
  	@Override
  	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
  		// TODO Auto-generated method stub
  		System.out.println("postProcessBeforeInitialization..."+beanName+"=>"+bean);
  		return bean;
  	}
  
  	@Override
  	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
  		// TODO Auto-generated method stub
  		System.out.println("postProcessAfterInitialization..."+beanName+"=>"+bean);
  		return bean;
  	}
  }
  
  
  ```

- **BeanFactoryPostProcessor** ：beanFactory的后置处理器；在BeanFactory标准初始化之后调用，来定制和修改BeanFactory的内容；所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建。

  ```java
  @FunctionalInterface
  public interface BeanFactoryPostProcessor {
  
     /**
      * Modify the application context's internal bean factory after its standard
      * initialization. All bean definitions will have been loaded, but no beans
      * will have been instantiated yet. This allows for overriding or adding
      * properties even to eager-initializing beans.
      * @param beanFactory the bean factory used by the application context
      * @throws org.springframework.beans.BeansException in case of errors
      */
     void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
  
  }
  //示例
  @Component
  public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
  
  	@Override
  	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
  		System.out.println("MyBeanFactoryPostProcessor...postProcessBeanFactory...");
  		int count = beanFactory.getBeanDefinitionCount();
  		String[] names = beanFactory.getBeanDefinitionNames();
  		System.out.println("当前BeanFactory中有"+count+" 个Bean");
  		System.out.println(Arrays.asList(names));
  	}
  
  }
  ```

- **BeanFactoryPostProcessor** 原理:

  - 1)、ioc容器创建对象。

  - 2)、**AbstractApplicationContext#invokeBeanFactoryPostProcessors(beanFactory);**
    如何找到所有的BeanFactoryPostProcessor并执行他们的方法；

    **PostProcessorRegistrationDelegate#invokeBeanFactoryPostProcessors**

    - 1）、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
    - 2）、在初始化创建其他组件前面执行


#### BeanDefinitionRegistryPostProcessor

```java
/**
 * Extension to the standard {@link BeanFactoryPostProcessor} SPI, allowing for
 * the registration of further bean definitions <i>before</i> regular
 * BeanFactoryPostProcessor detection kicks in. In particular,
 * BeanDefinitionRegistryPostProcessor may register further bean definitions
 * which in turn define BeanFactoryPostProcessor instances.
 *
 * @author Juergen Hoeller
 * @since 3.0.1
 * @see org.springframework.context.annotation.ConfigurationClassPostProcessor
 */
public interface BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor {

   /**
    * Modify the application context's internal bean definition registry after its
    * standard initialization. All regular bean definitions will have been loaded,
    * but no beans will have been instantiated yet. This allows for adding further
    * bean definitions before the next post-processing phase kicks in.
    * @param registry the bean definition registry used by the application context
    * @throws org.springframework.beans.BeansException in case of errors
    */
   void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException;

}

//示例
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor{

   @Override
   public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
      // TODO Auto-generated method stub
      System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量："+beanFactory.getBeanDefinitionCount());
   }

   //BeanDefinitionRegistry Bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean实例；
   @Override
   public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
      // TODO Auto-generated method stub
      System.out.println("postProcessBeanDefinitionRegistry...bean的数量："+registry.getBeanDefinitionCount());
      //RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
      AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();
      registry.registerBeanDefinition("hello", beanDefinition);
   }

}
```


在所有bean定义信息将要被加载，bean实例还未创建的；
优先于BeanFactoryPostProcessor执行；
利用BeanDefinitionRegistryPostProcessor给容器中再额外添加一些组件；

- 1）、ioc创建对象
- 2）、refresh()-》invokeBeanFactoryPostProcessors(beanFactory);
- 3）、从容器中获取到所有的BeanDefinitionRegistryPostProcessor组件。
  - 1、依次触发所有的postProcessBeanDefinitionRegistry()方法
  - 2、再来触发postProcessBeanFactory()方法BeanFactoryPostProcessor；
- 4）、再来从容器中找到BeanFactoryPostProcessor组件；然后依次触发postProcessBeanFactory()方法

#### ApplicationListener

**ApplicationListener**：监听容器中发布的事件。事件驱动模型开发；

```java
/**
 * Interface to be implemented by application event listeners.
 * Based on the standard {@code java.util.EventListener} interface
 * for the Observer design pattern.
 *
 * <p>As of Spring 3.0, an ApplicationListener can generically declare the event type
 * that it is interested in. When registered with a Spring ApplicationContext, events
 * will be filtered accordingly, with the listener getting invoked for matching event
 * objects only.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @param <E> the specific ApplicationEvent subclass to listen to
 * @see org.springframework.context.event.ApplicationEventMulticaster
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

   /**
    * Handle an application event.
    * @param event the event to respond to
    */
   void onApplicationEvent(E event);

}
```


监听  **ApplicationEvent**  及其下面的子事件；

- 1）、写一个监听器（ **ApplicationListener** 实现类）来监听某个事件（ **ApplicationEvent** 及其子类）
- 2）、把监听器加入到容器；
- 3）、只要容器中有相关事件的发布，我们就能监听到这个事件；
  例如：**ContextRefreshedEvent**：容器刷新完成（所有bean都完全创建）会发布这个事件；
  **ContextClosedEvent**：关闭容器会发布这个事件；
- 4）、发布一个事件：

```java
applicationContext.publishEvent(new ApplicationEvent(new String("我发布的时间")) {
});
```

发布原理：

- 1）、ContextRefreshedEvent 事件：

  - 1）、容器创建对象：refresh()；
  - 2）、finishRefresh();容器刷新完成会发布ContextRefreshedEvent事件

- 2）、自己发布事件；

- 3）、容器关闭会发布ContextClosedEvent；
  【事件发布流程】：
  **publishEvent(new ContextRefreshedEvent(this));**

  - 1）、获取事件的多播器（派发器）：**getApplicationEventMulticaster()**
  - 2）、**multicastEvent** 派发事件：
  - 3）、获取到所有的ApplicationListener；
  for (final ApplicationListener<?> listener : getApplicationListeners(event, type)) {
    - 1）、如果有Executor，可以支持使用Executor进行异步派发；Executor executor = getTaskExecutor();
    - 2）、否则，同步的方式直接执行listener方法；invokeListener(listener, event);拿到listener回调onApplicationEvent方法；

  【容器中有哪些监听器】

  - 1）、容器创建对象：refresh();
  - 2）、registerListeners();
    从容器中拿到所有的监听器，把他们注册到 **applicationEventMulticaster** 中；
    **String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);**
    //将 listener 注册到 ApplicationEventMulticaster 中
    **getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);**

或者使用 **@EventListener** 注解;
原理：使用 **EventListenerMethodProcessor** 处理器来解析方法上的 **@EventListener** ；

SmartInitializingSingleton 原理：->afterSingletonsInstantiated();

- 1）、ioc容器创建对象并refresh()；
- 2）、finishBeanFactoryInitialization(beanFactory);初始化剩下的单实例bean；
  - 1）、先创建所有的单实例bean；getBean();
  - 2）、获取所有创建好的单实例bean，判断是否是SmartInitializingSingleton类型的；如果是就调用afterSingletonsInstantiated();

#### Spring容器创建过程

Spring容器的refresh()【创建刷新】;
- 1、prepareRefresh()刷新前的预处理;
  -	1）、initPropertySources()初始化一些属性设置;子类自定义个性化的属性设置方法；
  -	2）、getEnvironment().validateRequiredProperties();检验属性的合法等
  -	3）、earlyApplicationEvents= new LinkedHashSet<ApplicationEvent>();保存容器中的一些早期的事件；
- 2、obtainFreshBeanFactory();获取BeanFactory；
  -	1）、refreshBeanFactory();刷新【创建】BeanFactory；
			创建了一个this.beanFactory = new DefaultListableBeanFactory();
			设置id；
  -	2）、getBeanFactory();返回刚才GenericApplicationContext创建的BeanFactory对象；
  -	3）、将创建的BeanFactory【DefaultListableBeanFactory】返回；
- 3、prepareBeanFactory(beanFactory);BeanFactory的预准备工作（BeanFactory进行一些设置）；
  -	1）、设置BeanFactory的类加载器、支持表达式解析器...
  -	2）、添加部分BeanPostProcessor【ApplicationContextAwareProcessor】
  -	3）、设置忽略的自动装配的接口EnvironmentAware、EmbeddedValueResolverAware、xxx；
  -	4）、注册可以解析的自动装配；我们能直接在任何组件中自动注入：
			BeanFactory、ResourceLoader、ApplicationEventPublisher、ApplicationContext
  -	5）、添加BeanPostProcessor【ApplicationListenerDetector】
  -	6）、添加编译时的AspectJ；
  -	7）、给BeanFactory中注册一些能用的组件；
		environment【ConfigurableEnvironment】、
		systemProperties【Map<String, Object>】、
		systemEnvironment【Map<String, Object>】
- 4、postProcessBeanFactory(beanFactory);BeanFactory准备工作完成后进行的后置处理工作；
  - 1）、子类通过重写这个方法来在BeanFactory创建并预准备完成以后做进一步的设置
======================以上是BeanFactory的创建及预准备工作==================================
- 5、invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessor的方法；
	BeanFactoryPostProcessor：BeanFactory的后置处理器。在BeanFactory标准初始化之后执行的；
	两个接口：BeanFactoryPostProcessor、BeanDefinitionRegistryPostProcessor
  - 1）、执行BeanFactoryPostProcessor的方法；
		先执行BeanDefinitionRegistryPostProcessor
		1）、获取所有的BeanDefinitionRegistryPostProcessor；
		2）、看先执行实现了PriorityOrdered优先级接口的BeanDefinitionRegistryPostProcessor、
			postProcessor.postProcessBeanDefinitionRegistry(registry)
		3）、在执行实现了Ordered顺序接口的BeanDefinitionRegistryPostProcessor；
			postProcessor.postProcessBeanDefinitionRegistry(registry)
		4）、最后执行没有实现任何优先级或者是顺序接口的BeanDefinitionRegistryPostProcessors；
			postProcessor.postProcessBeanDefinitionRegistry(registry)

		再执行BeanFactoryPostProcessor的方法
		1）、获取所有的BeanFactoryPostProcessor
		2）、看先执行实现了PriorityOrdered优先级接口的BeanFactoryPostProcessor、
			postProcessor.postProcessBeanFactory()
		3）、在执行实现了Ordered顺序接口的BeanFactoryPostProcessor；
			postProcessor.postProcessBeanFactory()
		4）、最后执行没有实现任何优先级或者是顺序接口的BeanFactoryPostProcessor；
			postProcessor.postProcessBeanFactory()
- 6、registerBeanPostProcessors(beanFactory);注册BeanPostProcessor（Bean的后置处理器）【 intercept bean creation】
		不同接口类型的BeanPostProcessor；在Bean创建前后的执行时机是不一样的
		BeanPostProcessor、
		DestructionAwareBeanPostProcessor、
		InstantiationAwareBeanPostProcessor、
		SmartInstantiationAwareBeanPostProcessor、
		MergedBeanDefinitionPostProcessor【internalPostProcessors】、
		

  - 1）、获取所有的 BeanPostProcessor;后置处理器都默认可以通过PriorityOrdered、Ordered接口来执行优先级
  - 2）、先注册PriorityOrdered优先级接口的BeanPostProcessor；
			把每一个BeanPostProcessor；添加到BeanFactory中
			beanFactory.addBeanPostProcessor(postProcessor);
  - 3）、再注册Ordered接口的
  - 4）、最后注册没有实现任何优先级接口的
  - 5）、最终注册MergedBeanDefinitionPostProcessor；
  - 6）、注册一个ApplicationListenerDetector；来在Bean创建完成后检查是否是ApplicationListener，如果是
			applicationContext.addApplicationListener((ApplicationListener<?>) bean);
- 7、initMessageSource();初始化MessageSource组件（做国际化功能；消息绑定，消息解析）；
  - 1）、获取BeanFactory
  - 2）、看容器中是否有id为messageSource的，类型是MessageSource的组件
			如果有赋值给messageSource，如果没有自己创建一个DelegatingMessageSource；
				MessageSource：取出国际化配置文件中的某个key的值；能按照区域信息获取；
  - 3）、把创建好的MessageSource注册在容器中，以后获取国际化配置文件的值的时候，可以自动注入MessageSource；
			beanFactory.registerSingleton(MESSAGE_SOURCE_BEAN_NAME, this.messageSource);	
			MessageSource.getMessage(String code, Object[] args, String defaultMessage, Locale locale);
- 8、initApplicationEventMulticaster();初始化事件派发器；
  - 1）、获取BeanFactory
  - 2）、从BeanFactory中获取applicationEventMulticaster的ApplicationEventMulticaster；
  - 3）、如果上一步没有配置；创建一个SimpleApplicationEventMulticaster
  - 4）、将创建的ApplicationEventMulticaster添加到BeanFactory中，以后其他组件直接自动注入
- 9、onRefresh();留给子容器（子类）
  - 1、子类重写这个方法，在容器刷新的时候可以自定义逻辑；
- 10、registerListeners();给容器中将所有项目里面的ApplicationListener注册进来；
  - 1、从容器中拿到所有的ApplicationListener
  - 2、将每个监听器添加到事件派发器中；
			getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
  - 3、派发之前步骤产生的事件；
- 11、finishBeanFactoryInitialization(beanFactory);初始化所有剩下的单实例bean；
  - 1、beanFactory.preInstantiateSingletons();初始化后剩下的单实例bean
    - 1）、获取容器中的所有Bean，依次进行初始化和创建对象
    - 2）、获取Bean的定义信息；RootBeanDefinition
    - 3）、Bean不是抽象的，是单实例的，是懒加载；
      - 1）、判断是否是FactoryBean；是否是实现FactoryBean接口的Bean；
      - 2）、不是工厂Bean。利用getBean(beanName);创建对象
        - 0、getBean(beanName)； ioc.getBean();
        - 1、doGetBean(name, null, null, false);
        - 2、先获取缓存中保存的单实例Bean。如果能获取到说明这个Bean之前被创建过（所有创建过的单实例Bean都会被缓存起来）
					从private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(256);获取的
        - 3、缓存中获取不到，开始Bean的创建对象流程；
        - 4、标记当前bean已经被创建，防止多线程情况下创建Bean。
        - 5、获取Bean的定义信息；
        - 6、【获取当前Bean依赖的其他Bean;如果有按照getBean()把依赖的Bean先创建出来；】
        - 7、启动单实例Bean的创建流程；
          - 1）、createBean(beanName, mbd, args);
          - 2）、Object bean = resolveBeforeInstantiation(beanName, mbdToUse);让BeanPostProcessor先拦截返回代理对象；
						【InstantiationAwareBeanPostProcessor】：提前执行；
						先触发：postProcessBeforeInstantiation()；
						如果有返回值：触发postProcessAfterInitialization()；
          - 3）、如果前面的InstantiationAwareBeanPostProcessor没有返回代理对象；调用4）
          - 4）、Object beanInstance = doCreateBean(beanName, mbdToUse, args);创建Bean
            - 1）、【创建Bean实例】；createBeanInstance(beanName, mbd, args);
						 	利用工厂方法或者对象的构造器创建出Bean实例；
            - 2）、applyMergedBeanDefinitionPostProcessors(mbd, beanType, beanName);
						 	调用MergedBeanDefinitionPostProcessor的postProcessMergedBeanDefinition(mbd, beanType, beanName);
            - 3）、【Bean属性赋值】populateBean(beanName, mbd, instanceWrapper);
						 	赋值之前：
              - 1）、拿到InstantiationAwareBeanPostProcessor后置处理器；
						 		postProcessAfterInstantiation()；
              - 2）、拿到InstantiationAwareBeanPostProcessor后置处理器；
						 		postProcessPropertyValues()；
						 	=====赋值之前：===
              - 3）、应用Bean属性的值；为属性利用setter方法等进行赋值；
						 		applyPropertyValues(beanName, mbd, bw, pvs);
            -  4）、【Bean初始化】initializeBean(beanName, exposedObject, mbd);
              - 1）、【执行Aware接口方法】invokeAwareMethods(beanName, bean);执行xxxAware接口的方法
						 		BeanNameAware\BeanClassLoaderAware\BeanFactoryAware
              - 2）、【执行后置处理器初始化之前】applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
						 		BeanPostProcessor.postProcessBeforeInitialization（）;
              - 3）、【执行初始化方法】invokeInitMethods(beanName, wrappedBean, mbd);
						 		1）、是否是InitializingBean接口的实现；执行接口规定的初始化；
						 		2）、是否自定义初始化方法；
              - 4）、【执行后置处理器初始化之后】applyBeanPostProcessorsAfterInitialization
						 		BeanPostProcessor.postProcessAfterInitialization()；
	        - 5）、注册Bean的销毁方法；
          - 5）、将创建的Bean添加到缓存中singletonObjects；
				ioc容器就是这些Map；很多的Map里面保存了单实例Bean，环境信息。。。。；
		所有Bean都利用getBean创建完成以后；
			检查所有的Bean是否是SmartInitializingSingleton接口的；如果是；就执行afterSingletonsInstantiated()；
- 12、finishRefresh();完成BeanFactory的初始化创建工作；IOC容器就创建完成；
  - 1）、initLifecycleProcessor();初始化和生命周期有关的后置处理器；LifecycleProcessor
			默认从容器中找是否有lifecycleProcessor的组件【LifecycleProcessor】；如果没有new DefaultLifecycleProcessor();
			加入到容器；
			

			写一个LifecycleProcessor的实现类，可以在BeanFactory
				void onRefresh();
				void onClose();	
  - 2）、	getLifecycleProcessor().onRefresh();
			拿到前面定义的生命周期处理器（BeanFactory）；回调onRefresh()；
  - 3）、publishEvent(new ContextRefreshedEvent(this));发布容器刷新完成事件；
  - 4）、liveBeansView.registerApplicationContext(this);
	
	======总结===========
-  1）、Spring容器在启动的时候，先会保存所有注册进来的Bean的定义信息；
  - 1）、xml注册bean；<bean>
  - 2）、注解注册Bean；@Service、@Component、@Bean、xxx
-  2）、Spring容器会合适的时机创建这些Bean
  - 1）、用到这个bean的时候；利用getBean创建bean；创建好以后保存在容器中；
  - 2）、统一创建剩下所有的bean的时候；finishBeanFactoryInitialization()；
-  3）、后置处理器；BeanPostProcessor
  - 1）、每一个bean创建完成，都会使用各种后置处理器进行处理；来增强bean的功能；
			AutowiredAnnotationBeanPostProcessor:处理自动注入
			AnnotationAwareAspectJAutoProxyCreator:来做AOP功能；
			xxx....
			增强的功能注解：
			AsyncAnnotationBeanPostProcessor
			....
-  4）、事件驱动模型；
		ApplicationListener；事件监听；
		ApplicationEventMulticaster；事件派发：


​			
​					
​						 		
​						 	
​					
​								
​							
​							
​							
​						
​						
​						
​							
​						
​						
​					
​				
​				
​				
​			


​	
​	