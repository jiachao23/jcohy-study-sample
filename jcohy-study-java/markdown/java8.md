#  Java
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  

# Java8新特性

> * [Lambda表达式](#Lambda)
> * [函数式接口](#函数式接口)
> * [方法引用与构造器引用](#方法引用与构造器引用)
> * [Stream API](#StreamAPI)
> * [Optional容器](#Optional容器)
> * [接口中的默认方法与静态方法](#接口中的默认方法与静态方法)
> * [新时间日期API](#新时间日期API)
> * [其他新特性](#其他新特性)

- 速度更快
- 代码更少（增加了新的语法Lambda 表达式）
- 强大的Stream API
- 便于并行
- 最大化减少空指针异常Optional


<p id="Lambda">

## 1.Lambda表达式

Lambda 是一个匿名函数，我们可以把Lambda 表达式理解为是一段可以传递的代码（将代码像数据一样进行传递）。可以写出更简洁、更灵活的代码。作为一种更紧凑的代码风格，使Java的语言表达能力得到了提升。

#### Lambda表达式的基础语法：

java8中引入了新的操作符“->”，该操作符称为箭头操作符或者Lambda操作符

箭头操作符将表达式拆分成两部分

**左侧：Lambda表达式的参数列表**

**右侧：Lambda表达式中所需执行的功能，即Lambda体**



##### 语法格式一：无参数，无返回值：() -> System.out.println("hello world");

```java
@Test
public void test1(){
    System.out.println("------从匿名类到Lambda 的转换------");
    Runnable r = new Runnable() {
        public void run() {
            System.out.println("hello world");
        }
    };
    r.run();
    System.out.println("-------------------------");
    Runnable r1 = () -> System.out.println("hello world");
    r1.run();
}
```

##### 语法格式二：有一个参数参数，无返回值：(x) -> System.out.println(x);

```java
@Test
public void test2(){
    Consumer<String> con = (x) -> System.out.println(x);
    con.accept("hello world");
}
```

##### 语法格式三：若只有一个参数，小括号可以省略不写

```java
@Test
public void test2(){
    Consumer<String> con = x -> System.out.println(x);
    con.accept("hello world");
}
```

##### 语法格式四：有两个以上参数，并且有返回值，并且Lambda体中有多条语句

```java
@Test
public void test3(){
   Comparator<Integer> com = (x, y) -> {
       System.out.println("函数式编程");
       return Integer.compare(x,y);
   };
}
```

#####  语法格式五：若Lambda体中只有一条语句，return和大括号都可以省略不写

```java
@Test
public void test3(){
   Comparator<Integer> com = (x, y) -> Integer.compare(x,y);
}
```

##### 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器可以通过上下文推断，数据类型，即“类型推断”

#### Lambda表达式需要“函数式接口”的支持

##### 函数式接口

	接口中只有一个抽象方法的接口，成为函数式接口，可以使用@FunctionalInterface修饰。用来检查是否是函数式接口。

#### Lambda简单使用

1）、对一个数进行运算

```java
@FunctionalInterface
public interface MyFun {
    
    public Integer getValue(Integer num);
    
}
```

```java
@Test
public void test4(){
    Integer integer = operation(100, (x) -> x * x);
    System.out.println(integer);
}

public Integer operation(Integer num,MyFun myFun){
    return myFun.getValue(num);
}
```

2）、调用Collections.sort()方法，通过定制排序规则比较两个Employee(先按年龄排序，年龄相同，按姓名排序)，使用Lambda

```java
List<Employee> emps = Arrays.asList(
        new Employee(101,"张三",18,1111.11),
        new Employee(102,"李四",59,2222.22),
        new Employee(103,"王五",28,3333.33),
        new Employee(104,"赵六",8,4444.44),
        new Employee(105,"田七",38,5555.55),
        new Employee(106,"董八",42,6666.66),
        new Employee(107,"周十",69,7777.77)
        );
@Test
public void test5(){
    Collections.sort(emps,(e1,e2) -> {
        if(e1.getAge() == e2.getAge()){
            return e1.getName().compareTo(e2.getName());
        }else{
            return Integer.compare(e1.getAge(),e2.getAge());
        }
    });

    for (Employee e: emps) {
        System.out.println(e);
    }
}
```

3）、声明函数式接口，接口中声明抽象方法 public String getValue(String str);

	声明类TestLambda，类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为返回值
	
	再将一个字符串的第2个和第4个索引位置进行截取子串

```java
@FunctionalInterface
public interface Func1 {
    public String getValue(String str);
}
```

```java
@Test
public void test6(){
    String helloWorld = operation("Hello World", (str) -> str.toUpperCase());
    String helloWorld1 = operation("He", (str) -> str.substring(2,5));
    System.out.println(helloWorld);
    System.out.println(helloWorld1);
}

public String operation(String num,Func1 myFun){
    return myFun.getValue(num);
}
```

4）、声明一个带两个泛型的函数式接口，泛型类型为<T,R> T为参数，R为返回值。

	接口中声明对应的抽象方法
	
	在TestLambda类中声明方法，使用接口作为参数，计算两个long型参数的和
	
	再计算两个long型类型的乘积。

```java
public interface Func2<T,R> {

    R getValue(T t1,T t2);
}
```

```java
@Test
public void test7(){
    calculate(100L,200L,(a,b) -> a+b);
    calculate(100L,200L,(a,b) -> a*b);
}

public void calculate(Long num,Long num2,Func2<Long,Long> myFun){
    System.out.println(myFun.getValue(num,num2));
}
```


<p id="函数式接口">

## 2.函数式接口

####  什么是函数式接口

- 只包含一个抽象方法的接口，称为函数式接口。
- 你可以通过Lambda 表达式来创建该接口的对象。（若Lambda 表达式抛出一个受检异常，那么该异常需要在目标接口的抽象方法上进行声明）。
- 我们可以在任意函数式接口上使用@FunctionalInterface注解，这样做可以检查它是否是一个函数式接口，同时javadoc也会包含一条声明，说明这个接口是一个函数式接口。

#### Java8中内置的四大核心函数式接口

| 函数式接口               | 参数类型 | 返回类型 | 用途                                                         |
| ------------------------ | -------- | -------- | ------------------------------------------------------------ |
| Consumer&lt;T&gt; 消费型接口    | T        | void     | 对类型为T的对象应用操作，包含方法：void accept(T t)          |
| Supplier&lt;T&gt;供给型接口    | 无       | T        | 返回类型为T的对象，包含方法：T get();                        |
| Function<T, R> 函数型接口 | T        | R        | 对类型为T的对象应用操作，并返回结果。结果是R类型的对象。包含方法：R apply(T t); |
| Predicate&lt;T&gt;断定型接口   | T        | boolean  | 确定类型为T的对象是否满足某约束，并返回boolean 值。包含方法boolean test(T t); |



- Consumer<T>：消费型接口

  void accept(T t)；

  ```java
  @Test
  public void test1(){
      happy(100000,(m) -> System.out.println("吃饭花费了"+m+"元"));
  }
  
  public void happy(double money, Consumer<Double> consumer){
      consumer.accept(money);
  }
  ```

- Supplier<T>：供给型接口

  T get();

  ```java
  //获取指定个数数字
  public List<Integer> getNumList(int num, Supplier<Integer> supplier){
      List<Integer> list = new ArrayList<>();
      for(int i=0;i<num;i++){
          Integer integer = supplier.get();
          list.add(integer);
      }
      return list;
  }
  
  @Test
  public void test2(){
      List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100) );
      for (Integer integer:numList ) {
          System.out.println(integer);
      }
  }
  ```

- Function<T,R>：函数型接口

  R apply(T t);

  ```java
  @Test
  public void test3(){
     String newStr = strHandler("\t\t\t 哈哈哈哈哈哈哈",(str) -> str.trim());
      System.out.println(newStr);
  }
  
  
  public String strHandler(String str, Function<String,String> function){
      return function.apply(str);
  }
  ```

- Predicate<T>：断言型接口

  boolean test(T t)

  ```java
  @Test
  public void test4(){
      List<String> list = Arrays.asList("hellsssso","world","atcj","jcohy");
      List<String> str = filterStr(list, (x) -> x.length() > 4);
     for(String str1 :str){
         System.out.println(str1);
     }
  }
  
  public List<String> filterStr(List<String> list, Predicate<String> pre){
      List<String> strList = new ArrayList<>();
      for(String str:list){
          if(pre.test(str)){
              strList.add(str);
          }
      }
      return strList;
  }
  ```

#### 其他接口

| 函数式接口                                                | 参数类型        | 返回类型        | 用途                                                         |
| --------------------------------------------------------- | --------------- | --------------- | -----------------------------------|
| BiFunction<T,U,R>    | T,U             | R       | 对类型为T,U参数应用操作，返回R类型的结果。包含方法为Rapply(Tt,Uu); |
| UnaryOperator&lt;T&gt;(Function子接口)| T   | T    | 对类型为T的对象进行一元运算，并返回T类型的结果。包含方法为Tapply(Tt); |
| BinaryOperator&lt;T&gt;(BiFunction子接口)  | T,T    | T    | 对类型为T的对象进行二元运算，并返回T类型的结果。包含方法为Tapply(Tt1,Tt2); |
| BiConsumer<T,U>       | T,U             | void            | 对类型为T,U参数应用操作。包含方法为voidaccept(Tt,Uu)    |
| ToIntFunction&lt;T&gt; ToLongFunction&lt;T&gt;ToDoubleFunction&lt;T&gt; | T| int,long,double | 分别计算int、long、double、值的函数   |
| IntFunction&lt;R&gt;LongFunction&lt;R&gt;DoubleFunction&lt;R&gt; | int,long,double | R | 参数分别为int、long、double类型的函数       |

<p id="方法引用与构造器引用">

## 3.方法引用与构造器引用

#### 方法引用

当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！（**实现抽象方法的参数列表，必须与方法引用方法的参数列表保持一致！**）方法引用：使用操作符“::” 将方法名和对象或类的名字分隔开来。
如下三种主要使用情况：

- 对象::实例方法
- 类::静态方法
- 类::实例方法

```java
//例如
	Consumer<String> com = (x) -> System.out.println(x);
//等同于
	Consumer<String> com = System.out::println

//例如：
	BinaryOperator<Double> bo = (x,y) ->Math.pow(x,y);
//等同于：
	BinaryOperator<Double> bo = Math::pow;
	
//例如：
	Comparator<Integer> com = (x, y) -> Integer.compare(x, y);	
//等同于
	Comparator<Integer> com2 = Integer::compare;
```



#### 构造器引用

**格式：ClassName::new**
与函数式接口相结合，自动与函数式接口中方法兼容。
**可以把构造器引用赋值给定义的方法，与构造器参数列表要与接口中抽象方法的参数列表一致！**

```java
//例如：
	 Function<Integer,MyClass> fun = (n) -> new MyClass(n);
//等同于
	Function<Integer,MyClass> fun = (n) -> MyClass::new;
```



#### 数组引用

**格式：type[] :: new**

```java
例如：
	 Function<Integer,Integer[]> fun = (n) -> new Integer[n];
等同于
	Function<Integer,Integer[]> fun = Integer[]::new;
```

<p id="StreamAPI">

## 4.Stream API

#### 了解Stream

Java8中有两大最为重要的改变。第一个是Lambda 表达式；另外一个则是**Stream API(java.util.stream.*)。**
Stream 是Java8 中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作。使用Stream API 对集合数据进行操作，就类似于使用SQL 执行的数据库查询。也可以使用Stream API 来并行执行操作。简而言之，Stream API 提供了一种高效且易于使用的处理数据的方式。

#### 什么是Stream

流(Stream) 到底是什么呢？
是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。“集合讲的是数据，流讲的是计算！”

注意：
①Stream 自己不会存储元素。
②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。

#### Stream 的操作三个步骤

- 创建Stream

  一个数据源（如：集合、数组），获取一个流

- 中间操作

  一个中间操作链，对数据源的数据进行处理

- 终止操作(终端操作)

  一个终止操作，执行中间操作链，并产生结果

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-java/src/main/resources/static/images/1.jpg)

##### 创建Stream

###### 1）、Java8 中的Collection 接口被扩展，提供了两个获取流的方法

   ```java
  //Java8 中的Collection 接口被扩展，提供了两个获取流的方法：
     default Stream<E> stream() : //返回一个顺序流
     default Stream<E> parallelStream() : //返回一个并行流
   ```

```java
List<String> list = new ArrayList<>();
Stream<String> stream = list.stream(); //获取一个顺序流
Stream<String> parallelStream = list.parallelStream(); //获取一个并行流
```



###### 2）、由数组创建流

  ```java
  static <T> Stream<T> stream(T[] array): 返回一个流
  重载形式，能够处理对应基本类型的数组：
  public static IntStream stream(int[] array)
  public static LongStream stream(long[] array)
  public static DoubleStream stream(double[] array)
  ```

```java
Integer[] nums = new Integer[10];
Stream<Integer> stream1 = Arrays.stream(nums);
```



###### 3）、由值创建流

  ```java
  //可以使用静态方法Stream.of(), 通过显示值创建一个流。它可以接收任意数量的参数。
  public static<T> Stream<T> of(T... values) : 返回一个流
  ```

```java
Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);
```

###### 4）、由函数创建流：创建无限流

  ```java
  //可以使用静态方法Stream.iterate() 和Stream.generate(), 创建无限流。
  //迭代
  public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
  //生成
  public static<T> Stream<T> generate(Supplier<T> s) :
  ```

```java
//迭代
Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(10);
stream3.forEach(System.out::println);

//生成
Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
stream4.forEach(System.out::println);
```



##### Stream 的中间操作

  多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！
  而在终止操作时一次性全部处理，称为“惰性求值”。

  ###### 筛选与切片

| 方法                | 描述                                                         |
| ------------------- | ------------------------------------------------------------ |
| filter(Predicate p) | 接收Lambda ，从流中排除某些元素。                            |
| distinct()          | 筛选，通过流所生成元素的hashCode() 和equals() 去除重复元素   |
| limit(long maxSize) | 截断流，使其元素不超过给定数量。                             |
| skip(long n)        | 跳过元素，返回一个扔掉了前n 个元素的流。若流中元素不足n 个，则返回一个空流。与limit(n) 互补 |

###### 映射

| 方法                            | 描述                                                         |
| ------------------------------- | ------------------------------------------------------------ |
| map(Function f)                 | 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。 |
| mapToDouble(ToDoubleFunction f) | 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的DoubleStream。 |
| mapToInt(ToIntFunction f)       | 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的IntStream。 |
| mapToLong(ToLongFunction f)     | 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的LongStream。 |
| flatMap(Function f)             | 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流 |

###### 排序

| 方法                    | 描述                               |
| ----------------------- | ---------------------------------- |
| sorted()                | 产生一个新流，其中按自然顺序排序   |
| sorted(Comparator comp) | 产生一个新流，其中按比较器顺序排序 |

##### Stream 的终止操作

###### 查找与匹配

| 方法                  | 描述                                                         |
| --------------------- | ------------------------------------------------------------ |
| allMatch(Predicate p) | 检查是否匹配所有元素                                         |
| anyMatch(Predicate p) | 检查是否至少匹配一个元素                                     |
| noneMatch(Predicatep) | 检查是否没有匹配所有元素                                     |
| findFirst()           | 返回第一个元素                                               |
| findAny()             | 返回当前流中的任意元素                                       |
| count()               | 返回流中元素总数                                             |
| max(Comparator c)     | 返回流中最大值                                               |
| min(Comparator c)     | 返回流中最小值                                               |
| forEach(Consumer c)   | 内部迭代(使用Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了) |

######  归约

| 方法                             | 描述                                                    |
| -------------------------------- | ------------------------------------------------------- |
| reduce(T iden, BinaryOperator b) | 可以将流中元素反复结合起来，得到一个值。返回T      |
| reduce(BinaryOperator b)         | 可以将流中元素反复结合起来，得到一个值。返回Optional<T> |
	
**备注：map 和reduce 的连接通常称为map-reduce 模式，因Google 用它来进行网络搜索而出名。**

###### 收集

| 方法                 | 描述                                                         |
| -------------------- | ------------------------------------------------------------ |
| collect(Collector c) | 将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法 |

  Collector 接口中方法的实现决定了如何对流执行收集操作(如收集到List、Set、Map)。但是Collectors 实用类提供了很多静态方法，可以方便地创建常见收集器实例，具体方法与实例如下表：

| 方法   | 返回类型 | 作用                 |
| ------ | -------- | -------------------- |
| toList | List<T>  | 把流中元素收集到List |
| toSet | Set<T>   | 把流中元素收集到Set |
| toCollection | Collection<T> | 把流中元素收集到创建的集合 |
| counting | Long     | 计算流中元素的个数 |
| summingInt | Integer  | 对流中元素的整数属性求和 |
| averagingInt | Double   | 计算流中元素Integer属性的平均值 |
| summarizingInt | IntSummaryStatistics | 收集流中Integer属性的统计值。如：平均值 |
| joining | String | 连接流中每个字符串 |
| maxBy | Optional<T> | 根据比较器选择最大值 |
| minBy | Optional<T> | 根据比较器选择最小值 |
| reducing | 归约产生的类型 | 从一个作为累加器的初始值开始，利用BinaryOperator与流中元素逐个结合，从而归约成单个值 |
| collectingAndThen | 转换函数返回的类型 | 包裹另一个收集器，对其结果转换函数 |
| groupingBy | Map<K,List<T>> | 根据某属性值对流分组，属性为K，结果为V |
| partitioningBy | Map<Boolean,List<T>> | 根据true或false进行分区Map<Boolean, |

  ```java
  //toList
  List<Employee> emps=list.stream().collect(Collectors.toList());
  
  //toSet
  Set<Employee> emps=list.stream().collect(Collectors.toSet());
  
  //toCollection
  Collection<Employee> emps=list.stream().collect(Collectors.toCollection(ArrayList::new));
  
  //counting
  long count=list.stream().collect(Collectors.counting());
  
  //summingInt
  int total=list.stream().collect(Collectors.summingInt(Employee::getSalary));
  
  //averagingInt
  double avg=list.stream().collect(Collectors.averagingInt(Employee::getSalary));
  
  //summarizingInt
  IntSummaryStatistic siss=list.stream().collect(Collectors.summarizingInt(Employee::getSalary));
  
  //joining
  String str=list.stream().map(Employee::getName).collect(Collectors.joining());
  
  //maxBy
  Optional<Emp> max=list.stream().collect(Collectors.maxBy(comparingInt(Employee::getSalary)));
  
  //minBy
  Optional<Emp> min=list.stream().collect(Collectors.minBy(comparingInt(Employee::getSalary)));
  
  //reducing
  int total=list.stream().collect(Collectors.reducing(0,Employee::getSalar,Integer::sum));
  
  //collectingAndThen
  int how=list.stream().collect(Collectors.collectingAndThen(Collectors.toList(),List::size));
  
  //groupingBy
  Map<Emp.Status, List<Emp>> map= list.stream()
  .collect(Collectors.groupingBy(Employee::getStatus));
  
  //partitioningBy
  Map<Boolean,List<Emp>> vd=list.stream().collect(Collectors.partitioningBy(Employee::getManage));
  ```

###### 练习

1）、给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
    		给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。

```java
@Test
public void test1(){
    Integer[] arrays = new Integer[]{1,2,3,4,5};
    Arrays.stream(arrays)
        .map((x) -> x * x)
        .collect(Collectors.toList())
        .forEach(System.out::println);
}
```

2）、怎样用 map 和 reduce 方法数一数流中有多少个Employee呢？

```java
List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 59, 6666.66, Status.BUSY),
			new Employee(101, "张三", 18, 9999.99, Status.FREE),
			new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
			new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
			new Employee(104, "赵六", 8, 7777.77, Status.FREE),
			new Employee(104, "赵六", 8, 7777.77, Status.FREE),
			new Employee(105, "田七", 38, 5555.55, Status.BUSY)
	);
	
@Test
public void test2(){
    Optional<Integer> count = emps.stream()
        .map((e) -> 1)
        .reduce(Integer::sum);

    System.out.println(count.get());
}
```

3）、

交易员类

```java
//交易员类
public class Trader {

	private String name;
	private String city;

	public Trader() {
	}

	public Trader(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + "]";
	}

}

```

交易类

```java
//交易类
public class Transaction {

	private Trader trader;
	private int year;
	private int value;

	public Transaction() {
	}

	public Transaction(Trader trader, int year, int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value="
				+ value + "]";
	}

}

```

```java
public class TestTransaction {
	
	List<Transaction> transactions = null;
	
	@Before
	public void before(){
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
	}
	
	//1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）
	@Test
	public void test1(){
		transactions.stream()
					.filter((t) -> t.getYear() == 2011)
					.sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
					.forEach(System.out::println);
	}
	
	//2. 交易员都在哪些不同的城市工作过？
	@Test
	public void test2(){
		transactions.stream()
					.map((t) -> t.getTrader().getCity())
					.distinct()
					.forEach(System.out::println);
	}
	
	//3. 查找所有来自剑桥的交易员，并按姓名排序
	@Test
	public void test3(){
		transactions.stream()
					.filter((t) -> t.getTrader().getCity().equals("Cambridge"))
					.map(Transaction::getTrader)
					.sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
					.distinct()
					.forEach(System.out::println);
	}
	
	//4. 返回所有交易员的姓名字符串，按字母顺序排序
	@Test
	public void test4(){
		transactions.stream()
					.map((t) -> t.getTrader().getName())
					.sorted()
					.forEach(System.out::println);
		
		System.out.println("-----------------------------------");
		
		String str = transactions.stream()
					.map((t) -> t.getTrader().getName())
					.sorted()
					.reduce("", String::concat);
		
		System.out.println(str);
		
		System.out.println("------------------------------------");
		
		transactions.stream()
					.map((t) -> t.getTrader().getName())
					.flatMap(TestTransaction::filterCharacter)
					.sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
					.forEach(System.out::print);
	}
	
	public static Stream<String> filterCharacter(String str){
		List<String> list = new ArrayList<>();
		
		for (Character ch : str.toCharArray()) {
			list.add(ch.toString());
		}
		
		return list.stream();
	}
	
	//5. 有没有交易员是在米兰工作的？
	@Test
	public void test5(){
		boolean bl = transactions.stream()
					.anyMatch((t) -> t.getTrader().getCity().equals("Milan"));
		
		System.out.println(bl);
	}
	
	
	//6. 打印生活在剑桥的交易员的所有交易额
	@Test
	public void test6(){
		Optional<Integer> sum = transactions.stream()
					.filter((e) -> e.getTrader().getCity().equals("Cambridge"))
					.map(Transaction::getValue)
					.reduce(Integer::sum);
		
		System.out.println(sum.get());
	}
	
	
	//7. 所有交易中，最高的交易额是多少
	@Test
	public void test7(){
		Optional<Integer> max = transactions.stream()
					.map((t) -> t.getValue())
					.max(Integer::compare);
		
		System.out.println(max.get());
	}
	
	//8. 找到交易额最小的交易
	@Test
	public void test8(){
		Optional<Transaction> op = transactions.stream()
					.min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
		System.out.println(op.get());
	}
}
```



  #### 并行流与串行流

  并行流就是把一个内容分成多个数据块，并用不同的线程分别处理每个数据块的流。
  Java 8 中将并行进行了优化，我们可以很容易的对数据进行并行操作。**Stream API 可以声明性地通过parallel() 与sequential() 在并行流与顺序流之间进行切换。**

  #### 了解Fork/Join 框架

  Fork/Join 框架：就是在必要的情况下，将一个大任务，进行拆分(fork)成若干个小任务（拆到不可再拆时），再将一个个的小任务运算的结果进行join 汇总.

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/91bd78d2d059f56b2090ea52e53e61b194788628/jcohy-study-java/src/main/resources/static/images/2.jpg)

  ##### Fork/Join 框架与传统线程池的区别

  采用“工作窃取”模式（work-stealing）：
  当执行新的任务时它可以将其拆分分成更小的任务执行，并将小任务加到线程队列中，然后再从一个随机线程的队列中偷一个并把它放在自己的队列中。
  相对于一般的线程池实现,fork/join框架的优势体现在对其中包含的任务的处理方式上.在一般的线程池中,如果一个线程正在执行的任务由于某些原因无法继续运行,那么该线程会处于等待状态.而在fork/join框架实现中,如果某个子问题由于等待另外一个子问题的完成而无法继续运行.那么处理该子问题的线程会主动寻找其他尚未运行的子问题来执行.这种方式减少了线程的等待时间,提高了性能.

```java
public class ForkJoinCalculate extends RecursiveTask<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 13475679780L;
	
	private long start;
	private long end;
	
	private static final long THRESHOLD = 10000L; //临界值
	
	public ForkJoinCalculate(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Long compute() {
		long length = end - start;
		
		if(length <= THRESHOLD){
			long sum = 0;
			
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			
			return sum;
		}else{
			long middle = (start + end) / 2;
			
			ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
			left.fork(); //拆分，并将该子任务压入线程队列
			
			ForkJoinCalculate right = new ForkJoinCalculate(middle+1, end);
			right.fork();
			
			return left.join() + right.join();
		}
		
	}

}

```



```java
public class TestForkJoin {
	
	@Test
	public void test1(){
		long start = System.currentTimeMillis();
		
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 10000000000L);
		
		long sum = pool.invoke(task);
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		
		System.out.println("耗费的时间为: " + (end - start)); //112-1953-1988-2654-2647-20663-113808
	}
	
	@Test
	public void test2(){
		long start = System.currentTimeMillis();
		
		long sum = 0L;
		
		for (long i = 0L; i <= 10000000000L; i++) {
			sum += i;
		}
		
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		
		System.out.println("耗费的时间为: " + (end - start)); //34-3174-3132-4227-4223-31583
	}
	
	@Test
	public void test3(){
		long start = System.currentTimeMillis();
		
		Long sum = LongStream.rangeClosed(0L, 10000000000L)
							 .parallel()
							 .sum();
		
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		
		System.out.println("耗费的时间为: " + (end - start)); //2061-2053-2086-18926
	}

}
```

<p id="Optional容器">

## 5.Optional容器

**Optional<T> 类(java.util.Optional)** 是一个容器类，代表一个值存在或不存在，原来用null 表示一个值不存在，现在Optional 可以更好的表达这个概念。并且可以避免空指针异常。
常用方法：

- Optional.of(T t) : 创建一个Optional 实例
- Optional.empty() : 创建一个空的Optional 实例
- Optional.ofNullable(T t):若t 不为null,创建Optional 实例,否则创建空实例
- isPresent() : 判断是否包含值
- orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
- orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回s 获取的值
- map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
- flatMap(Function mapper):与map 类似，要求返回值必须是Optional

```java
/*
 * 一、Optional 容器类：用于尽量避免空指针异常
 * 	Optional.of(T t) : 创建一个 Optional 实例
 * 	Optional.empty() : 创建一个空的 Optional 实例
 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * 	isPresent() : 判断是否包含值
 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class TestOptional {
	
	@Test
	public void test4(){
		Optional<Employee> op = Optional.of(new Employee(101, "张三", 18, 9999.99));
		
		Optional<String> op2 = op.map(Employee::getName);
		System.out.println(op2.get());
		
		Optional<String> op3 = op.flatMap((e) -> Optional.of(e.getName()));
		System.out.println(op3.get());
	}
	
	@Test
	public void test3(){
		Optional<Employee> op = Optional.ofNullable(new Employee());
		
		if(op.isPresent()){
			System.out.println(op.get());
		}
		
		Employee emp = op.orElse(new Employee("张三"));
		System.out.println(emp);
		
		Employee emp2 = op.orElseGet(() -> new Employee());
		System.out.println(emp2);
	}
	
	@Test
	public void test2(){
		/*Optional<Employee> op = Optional.ofNullable(null);
		System.out.println(op.get());*/
		
//		Optional<Employee> op = Optional.empty();
//		System.out.println(op.get());
	}

	@Test
	public void test1(){
		Optional<Employee> op = Optional.of(new Employee());
		Employee emp = op.get();
		System.out.println(emp);
	}
	
	@Test
	public void test5(){
		Man man = new Man();
		
		String name = getGodnessName(man);
		System.out.println(name);
	}
	
	//需求：获取一个男人心中女神的名字
	public String getGodnessName(Man man){
		if(man != null){
			Godness g = man.getGod();
			
			if(g != null){
				return g.getName();
			}
		}
		
		return "苍老师";
	}
	
	//运用 Optional 的实体类
	@Test
	public void test6(){
		Optional<Godness> godness = Optional.ofNullable(new Godness("林志玲"));
		
		Optional<NewMan> op = Optional.ofNullable(new NewMan(godness));
		String name = getGodnessName2(op);
		System.out.println(name);
	}
	
	public String getGodnessName2(Optional<NewMan> man){
		return man.orElse(new NewMan())
				  .getGodness()
				  .orElse(new Godness("苍老师"))
				  .getName();
	}
}

```

<p id="接口中的默认方法与静态方法">

## 6.接口中的默认方法与静态方法

Java 8中允许接口中包含具有具体实现的方法，该方法称为“默认方法”，默认方法使用default关键字修饰。

Java8 中，接口中允许添加静态方法

接口默认方法的”**类优先**”原则
若一个接口中定义了一个默认方法，而另外一个父类或接口中又定义了一个同名的方法时

- 选择父类中的方法。如果一个父类提供了具体的实现，那么接口中具有相同名称和参数的默认方法会被忽略。
- 接口冲突。如果一个父接口提供一个默认方法，而另一个接口也提供了一个具有相同名称和参数列表的方法（不管方法是否是默认方法），那么必须覆盖该方法来解决冲突

<p id="新时间日期API">

## 7.新时间日期API

#### LocalDate、LocalTime、LocalDateTime 
	类的实例是不可变的对象，分别表示使用ISO-8601日历系统的日期、时间、日期和时间。它们提供了简单的日期或时间，并不包含当前的时间信息。也不包含与时区相关的信息。

| 方法                                                         | 描述                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| now()                                                        | 静态方法，根据当前时间创建对象                               |
| of()                                                         | 静态方法，根据指定日期/时间创建对象                          |
| plusDays,plusWeeks,plusMonths,plusYears                 | 向当前LocalDate对象添加几天、几周、几个月、几年              |
| minusMonths,minusYears                                       | 从当前LocalDate对象减去几天、几周、几个月、几年              |
| plus,minus                                                   | 添加或减少一个Duration或Period                               |
| withDayOfMonth, <br/>withDayOfYear,<br/>withMonth,<br/>withYear | 将月份天数、年份天数、月份、年份修改为指定的值并返回新的LocalDate对象 |
| getDayOfMonth                                                | 获得月份天数(1-31)                                           |
| getDayOfYear                                                 | 获得年份天数(1-366)                                          |
| getDayOfWeek                                                 | 获得星期几(返回一个DayOfWeek枚举值)                          |
| getMonth                                                     | 获得月份,返回一个Month枚举值                                 |
| getMonthValue                                                | 获得月份(1-12)                                               |
| getYear                                                      | 获得年份                                                     |
| until                                                        | 获得两个日期之间的Period对象，或者指定ChronoUnits的数字      |
| isBefore,isAfter                                             | 比较两个LocalDate                                            |
| isLeapYear                                                   | 判断是否是闰年                                               |
```java
public class TestLocalDateTime {

	//1. LocalDate、LocalTime、LocalDateTime
	@Test
	public void test1(){
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime ld2 = LocalDateTime.of(2016, 11, 21, 10, 10, 10);
		System.out.println(ld2);
		
		LocalDateTime ldt3 = ld2.plusYears(20);
		System.out.println(ldt3);
		
		LocalDateTime ldt4 = ld2.minusMonths(2);
		System.out.println(ldt4);
		
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		System.out.println(ldt.getSecond());
	}
```



#### Instant 时间戳
	用于“时间戳”的运算。它是以Unix元年(传统的设定为UTC时区1970年1月1日午夜时分)开始所经历的描述进行运算

```java
	//2. Instant : 时间戳。 （使用 Unix 元年  1970年1月1日 00:00:00 所经历的毫秒值）
	@Test
	public void test2(){
		Instant ins = Instant.now();  //默认使用 UTC 时区
		System.out.println(ins);
		
		OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
		System.out.println(odt);
		
		System.out.println(ins.getNano());
		
		Instant ins2 = Instant.ofEpochSecond(5);
		System.out.println(ins2);
	}
```



#### Duration 和Period

Duration:用于计算两个“时间”间隔

Period:用于计算两个“日期”间隔

```java
//3.
	//Duration : 用于计算两个“时间”间隔
	//Period : 用于计算两个“日期”间隔
	@Test
	public void test3(){
		Instant ins1 = Instant.now();
		
		System.out.println("--------------------");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		Instant ins2 = Instant.now();
		
		System.out.println("所耗费时间为：" + Duration.between(ins1, ins2));
		
		System.out.println("----------------------------------");
		
		LocalDate ld1 = LocalDate.now();
		LocalDate ld2 = LocalDate.of(2011, 1, 1);
		
		Period pe = Period.between(ld2, ld1);
		System.out.println(pe.getYears());
		System.out.println(pe.getMonths());
		System.out.println(pe.getDays());
	}
```

#### 日期的操纵

- TemporalAdjuster : 时间校正器。有时我们可能需要获取例如：将日期调整到“下个周日”等操作。
- TemporalAdjusters : 该类通过静态方法提供了大量的常用TemporalAdjuster 的实现。

```java
	
	//4. TemporalAdjuster : 时间校正器
	@Test
	public void test4(){
	LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime ldt2 = ldt.withDayOfMonth(10);
		System.out.println(ldt2);
		
		LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(ldt3);
		
		//自定义：下一个工作日
		LocalDateTime ldt5 = ldt.with((l) -> {
			LocalDateTime ldt4 = (LocalDateTime) l;
			
			DayOfWeek dow = ldt4.getDayOfWeek();
			
			if(dow.equals(DayOfWeek.FRIDAY)){
				return ldt4.plusDays(3);
			}else if(dow.equals(DayOfWeek.SATURDAY)){
				return ldt4.plusDays(2);
			}else{
				return ldt4.plusDays(1);
			}
		});
		
		System.out.println(ldt5);
	}
```

#### 解析与格式化

**java.time.format.DateTimeFormatter 类**：该类提供了三种格式化方法：

- 预定义的标准格式
- 语言环境相关的格式
- 自定义的格式**

Java8 中加入了对时区的支持，带时区的时间为分别为：
**ZonedDate、ZonedTime、ZonedDateTime**
**其中每个时区都对应着ID，地区ID都为“{区域}/{城市}”的格式**
例如：Asia/Shanghai 等
ZoneId：该类中包含了所有的时区信息
getAvailableZoneIds() : 可以获取所有时区时区信息
of(id) : 用指定的时区信息获取ZoneId 对象

```java

	//6.ZonedDate、ZonedTime、ZonedDateTime ： 带时区的时间或日期
	@Test
	public void test7(){
		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println(ldt);
		
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Pacific"));
		System.out.println(zdt);
	}
	
	@Test
	public void test6(){
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.forEach(System.out::println);
	}

	
	//5. DateTimeFormatter : 解析和格式化日期或时间
	@Test
	public void test5(){
//		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");
		
		LocalDateTime ldt = LocalDateTime.now();
		String strDate = ldt.format(dtf);
		
		System.out.println(strDate);
		
		LocalDateTime newLdt = ldt.parse(strDate, dtf);
		System.out.println(newLdt);
	}

```

#### 与传统日期的转换

| 类                                                          | To 遗留类                             | From 遗留类                 |
| ----------------------------------------------------------- | ------------------------------------- | --------------------------- |
| java.time.Instant<br/>java.util.Date                        | Date.from(instant)                    | date.toInstant()            |
| java.time.Instant<br/>java.sql.Timestamp                    | Timestamp.from(instant)               | timestamp.toInstant()       |
| java.time.ZonedDateTime<br/>java.util.GregorianCalendar     | GregorianCalendar.from(zonedDateTime) | cal.toZonedDateTime()       |
| java.time.LocalDate<br/>java.sql.Time                       | Date.valueOf(localDate)               | date.toLocalDate()          |
| java.time.LocalTime<br/>java.sql.Time                       | Date.valueOf(localDate)               | date.toLocalTime()          |
| java.time.LocalDateTime<br/>java.sql.Timestamp              | Timestamp.valueOf(localDateTime)      | timestamp.toLocalDateTime() |
| java.time.ZoneId<br/>java.util.TimeZone                     | Timezone.getTimeZone(id)              | timeZone.toZoneId()         |
| java.time.format.DateTimeFormatter<br/>java.text.DateFormat | formatter.toFormat()                  | 无                          |

<p id="其他新特性">

## 8.其他新特性

#### 重复注解与类型注解

Java 8对注解处理提供了两点改进：可重复的注解及可用于类型的注解。

```java
@Target({TYPE, FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
    MyAnnotation[] value();
}

```

```java
@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value();
}

```

```java
public class TestAnnotation {

    @Test
    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show");
        MyAnnotation[] myAnnotations = m1.getAnnotationsByType(MyAnnotation.class);
        for(MyAnnotation myAnnotation: myAnnotations){
            System.out.println(myAnnotation);
        }
    }

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(){

    }
}

```

最后附上所有代码地址  ![Java8 Code](https://github.com/jiachao23/jcohy-study-sample/tree/master/jcohy-study-java/src/main/java/com/jcohy/study/java8)