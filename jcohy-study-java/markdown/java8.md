# Java8新特性

- 速度更快
- 代码更少（增加了新的语法Lambda 表达式）
- 强大的Stream API
- 便于并行
- 最大化减少空指针异常Optional

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

​	声明类TestLambda，类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为返回值

​	再将一个字符串的第2个和第4个索引位置进行截取子串

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

​	接口中声明对应的抽象方法

​	在TestLambda类中声明方法，使用接口作为参数，计算两个long型参数的和

​	再计算两个long型类型的乘积。

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

##2.函数式接口

Java8中内置的四大核心函数式接口

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

## 3.方法引用与构造器引用
## 4.Stream API
## 5.接口中的默认方法与静态方法
## 6.新时间日期API
## 7.其他新特性