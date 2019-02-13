
#  Java
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## java基础面试
> * [面向对象的特征](#javabase-1)
> * [访问修饰符public,private,protected,以及不写（默认）时的区别？](#javabase-2)
> * [String 是最基本的数据类型吗？](#javabase-3)
> * [float f=3.4;是否正确？](#javabase-4)
> * [short s1 = 1; s1 = s1 + 1;有错吗?short s1 = 1; s1 += 1;有错吗？](#javabase-5)
> * [Java有没有goto？](#javabase-6)
> * [int和Integer有什么区别？](#javabase-7)
> * [&和&&的区别？](#javabase-8)
> * [Math.round(11.5) 等于多少？Math.round(-11.5)等于多少？](#javabase-9)
> * [用最有效率的方法计算2乘以8？](#javabase-10)
> * [数组有没有length()方法？String有没有length()方法？](#javabase-11)
> * [在Java中，如何跳出当前的多重嵌套循环？](#javabase-12)
> * [构造器（constructor）是否可被重写（override）？](#javabase-13)
> * [两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对？](#javabase-14)
> * [是否可以继承String类？](#javabase-15)
> * [当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递？](#javabase-16)
> * [String和StringBuilder、StringBuffer的区别？](#javabase-17)
> * [重载（Overload）和重写（Override）的区别。重载的方法能否根据返回类型进行区分？](#javabase-18)
>   *  [为什么不能根据返回类型来区分重载？](#18-1)
> * [char 型变量中能不能存贮一个中文汉字，为什么？](#javabase-19)
> * [抽象类（abstract class）和接口（interface）有什么异同？](#javabase-20)
> * [静态嵌套类(Static Nested Class)和内部类（Inner Class）的不同？](#javabase-21)
> * [抽象的（abstract）方法是否可同时是静态的（static）,是否可同时是本地方法（native），是否可同时被synchronized修饰？](#javabase-22)
> * [阐述静态变量和实例变量的区别。](#javabase-23)
> * [是否可以从一个静态（static）方法内部发出对非静态（non-static）方法的调用？](#javabase-24)
> * [如何实现对象克隆？](#javabase-25)
> * [String s = new String("xyz");创建了几个字符串对象？](#javabase-26)
> * [接口是否可继承（extends）接口？抽象类是否可实现（implements）接口？抽象类是否可继承具体类（concrete class）？](#javabase-27)
> * [一个".java"源文件中是否可以包含多个类（不是内部类）？有什么限制？](#javabase-28)
> * [Anonymous Inner Class(匿名内部类)是否可以继承其它类？是否可以实现接口？](#javabase-29)
> * [内部类可以引用它的包含类（外部类）的成员吗？有没有什么限制？](#javabase-30)
> * [Java 中的final关键字有哪些用法？](#javabase-31)
> * [构造器执行顺序Demo？](#javabase-32)
> * [数据类型之间的转换](#javabase-33)
> * [如何实现字符串的反转及替换？](#javabase-34)
> * [怎样将GB2312编码的字符串转换为ISO-8859-1编码的字符串？](#javabase-35)
> * [日期和时间](#javabase-36)
>   *  [如何取得年月日、小时分钟秒？ ](#javabase-36-1)
>   *  [如何取得从1970年1月1日0时0分0秒到现在的毫秒数？](#javabase-36-2)
>   *  [如何取得某月的最后一天？](#javabase-36-3)
>   *  [如何格式化日期？](#javabase-36-4)
>   *  [打印昨天的当前时刻。](#javabase-36-5)
> * [比较一下Java和JavaSciprt。](#javabase-37)
> * [什么时候用断言（assert）？](#javabase-38)
> * [Error和Exception有什么区别？](#javabase-39)
> * [try{}里有一个return语句，那么紧跟在这个try后的finally{}里的代码会不会被执行，什么时候被执行，在return前还是后?](#javabase-40)
> * [Java语言如何进行异常处理，关键字：throws、throw、try、catch、finally分别如何使用？](#javabase-41)
> * [运行时异常与受检异常有何异同？](#javabase-42)
> * [列出一些你常见的运行时异常？](#javabase-43)
> * [阐述final、finally、finalize的区别。](#javabase-44)
> * [异常示例](#javabase-45)
> * [简述正则表达式及其用途。](#javabase-46)
> * [Java中是如何支持正则表达式操作的？](#javabase-47) 
> * [内部类访问外部属性为什么加final？](#javabase-48)
> * [this & super？](#javabase-49)

<p id="javabase-1">

#### 面向对象的特征

  * 抽象：抽象是将一类对象的共同特征总结出来构造类的过程，包括数据抽象和行为抽象两方面。抽象只关注对象有哪些属性和行为，并不关注这些行为的细节是什么。
  * 继承：继承是从已有类得到继承信息创建新类的过程。提供继承信息的类被称为父类（超类、基类）；得到继承信息的类被称为子类（派生类）。继承让变化中的软件系统有了一定的延续性，同时继承也是封装程序中可变因素的重要手段（如果不能理解请阅读阎宏博士的《Java与模式》或《设计模式精解》中关于桥梁模式的部分）。
  * 封装：通常认为封装是把数据和操作数据的方法绑定起来，对数据的访问只能通过已定义的接口。面向对象的本质就是将现实世界描绘成一系列完全自治、封闭的对象。我们在类中编写的方法就是对实现细节的一种封装；我们编写一个类就是对数据和数据操作的封装。可以说，封装就是隐藏一切可隐藏的东西，只向外界提供最简单的编程接口（可以想想普通洗衣机和全自动洗衣机的差别，明显全自动洗衣机封装更好因此操作起来更简单；我们现在使用的智能手机也是封装得足够好的，因为几个按键就搞定了所有的事情）。
  * 多态：多态性是指允许不同子类型的对象对同一消息作出不同的响应。简单的说就是用同样的对象引用调用同样的方法但是做了不同的事情。多态性分为编译时的多态性和运行时的多态性。如果将对象的方法视为对象向外界提供的服务，那么运行时的多态性可以解释为：当A系统访问B系统提供的服务时，B系统有多种提供服务的方式，但一切对A系统来说都是透明的（就像电动剃须刀是A系统，它的供电系统是B系统，B系统可以使用电池供电或者用交流电，甚至还有可能是太阳能，A系统只会通过B类对象调用供电的方法，但并不知道供电系统的底层实现是什么，究竟通过何种方式获得了动力）。方法重载（overload）实现的是编译时的多态性（也称为前绑定），而方法重写（override）实现的是运行时的多态性（也称为后绑定）。运行时的多态是面向对象最精髓的东西，要实现多态需要做两件事：1). 方法重写（子类继承父类并重写父类中已有的或抽象的方法）；2). 对象造型（用父类型引用引用子类型对象，这样同样的引用调用同样的方法就会根据子类对象的不同而表现出不同的行为）。 

<p id="javabase-2">

#### 访问修饰符public,private,protected,以及不写（默认）时的区别？


|           | **同一个类** | **同一个包** | **不同包的子类** | **不同包的非子类** |
| --------- | ------------ | ------------ | ---------------- | ------------------ |
| Private   | ?            |              |                  |                    |
| Default   | ?            | ?            |                  |                    |
| Protected | ?            | ?            | ?                |                    |
| Public    | ?            | ?            | ?                | ?                  |

类的成员不写访问修饰时默认为default。默认对于同一个包中的其他类相当于公开（public），对于不是同一个包中的其他类相当于私有（private）。受保护（protected）对子类相当于公开，对不是同一包中的没有父子关系的类相当于私有。Java中，外部类的修饰符只能是public或默认，类的成员（包括内部类）的修饰符可以是以上四种。

<p id="javabase-3">

#### String 是最基本的数据类型吗？

不是。Java中的基本数据类型只有8个：byte、short、int、long、float、double、char、boolean；除了基本类型（primitive type），剩下的都是引用类型（reference type），Java 5以后引入的枚举类型也算是一种比较特殊的引用类型。

<p id="javabase-4">

#### float f=3.4;是否正确？

不正确。3.4是双精度数，将双精度型（double）赋值给浮点型（float）属于下转型（down-casting，也称为窄化）会造成精度损失，因此需要强制类型转换float f =(float)3.4; 或者写成float f =3.4F；

<p id="javabase-5">

#### short s1 = 1; s1 = s1 + 1;有错吗?short s1 = 1; s1 += 1;有错吗？

对于short s1 = 1; s1 = s1 + 1;由于1是int类型，因此s1+1运算结果也是int 型，需要强制转换类型才能赋值给short型。而short s1 = 1; s1 += 1;可以正确编译，因为s1+= 1;相当于s1 = (short)(s1 + 1);其中有隐含的强制类型转换。

<p id="javabase-6">

#### Java有没有goto？

goto 是Java中的保留字，在目前版本的Java中没有使用。（根据James Gosling（Java之父）编写的《The Java Programming Language》一书的附录中给出了一个Java关键字列表，其中有goto和const，但是这两个是目前无法使用的关键字，因此有些地方将其称之为保留字，其实保留字这个词应该有更广泛的意义，因为熟悉C语言的程序员都知道，在系统类库中使用过的有特殊意义的单词或单词的组合都被视为保留字）

<p id="javabase-7">

#### int和Integer有什么区别？

Java是一个近乎纯洁的面向对象编程语言，但是为了编程的方便还是引入了基本数据类型，但是为了能够将这些基本数据类型当成对象操作，Java为每一个基本数据类型都引入了对应的包装类型（wrapper class），int的包装类就是Integer，从Java 5开始引入了自动装箱/拆箱机制，使得二者可以相互转换。Java 为每个原始类型提供了包装类型：

- 原始类型: boolean，char，byte，short，int，long，float，double

- 包装类型：Boolean，Character，Byte，Short，Integer，Long，Float，Double

  关于装箱拆箱的两个例子：

  第一个

  ```java
  class AutoUnboxingTest {
  	public static void main(String[] args) {
  	Integer a = new Integer(3);
  	Integer b = 3; // 将3自动装箱成Integer类型
  	int c = 3;
  	System.out.println(a == b); // false 两个引用没有引用同一对象
  	System.out.println(a == c); // true a自动拆箱成int类型再和c比较
  	}
  }
  ```

  第二个：

  ```java
  public class Test03 {
  	public static void main(String[] args) {
  		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
  		System.out.println(f1 == f2);//true
  		System.out.println(f3 == f4);//false
  	}
  }
  ```

  如果不明就里很容易认为两个输出要么都是true要么都是false。首先需要注意的是f1、f2、f3、f4四个变量都是Integer对象引用，所以下面的==运算比较的不是值而是引用。装箱的本质是什么呢？当我们给一个Integer对象赋一个int值的时候，会调用Integer类的静态方法valueOf，如果看看valueOf的源代码就知道发生了什么。

  ```java
  public static Integer valueOf(int i) {
      if (i >= IntegerCache.low && i <= IntegerCache.high)
          return IntegerCache.cache[i + (-IntegerCache.low)];
      return new Integer(i);
  }
  ```

  IntegerCache是Integer的内部类，其代码如下所示：

  ```java
  private static class IntegerCache {
      static final int low = -128;
      static final int high;
      static final Integer cache[];
  
      static {
          // high value may be configured by property
          int h = 127;
          String integerCacheHighPropValue =
              sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
          if (integerCacheHighPropValue != null) {
              try {
                  int i = parseInt(integerCacheHighPropValue);
                  i = Math.max(i, 127);
                  // Maximum array size is Integer.MAX_VALUE
                  h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
              } catch( NumberFormatException nfe) {
                  // If the property cannot be parsed into an int, ignore it.
              }
          }
          high = h;
  
          cache = new Integer[(high - low) + 1];
          int j = low;
          for(int k = 0; k < cache.length; k++)
              cache[k] = new Integer(j++);
  
          // range [-128, 127] must be interned (JLS7 5.1.7)
          assert IntegerCache.high >= 127;
      }
  
      private IntegerCache() {}
  }
  ```
  简单的说，如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。

  <p id="javabase-8">

#### &和&&的区别？

  &运算符有两种用法：

  * 按位与。

  * 逻辑与。

  &&运算符是短路与运算。

  逻辑与跟短路与的差别是非常巨大的，虽然二者都要求运算符左右两端的布尔值都是true整个表达式的值才是true。&&之所以称为短路运算是因为，如果&&左边的表达式的值是false，右边的表达式会被直接短路掉，不会进行运算。很多时候我们可能都需要用&&而不是&，例如在验证用户登录时判定用户名不是null而且不是空字符串，应当写为：**username != null &&!username.equals("")**，二者的顺序不能交换，更不能用&运算符，因为第一个条件如果不成立，根本不能进行字符串的equals比较，否则会产生**NullPointerException**异常。注意：逻辑或运算符（|）和短路或运算符（||）的差别也是如此。

<p id="javabase-9">

#### Math.round(11.5) 等于多少？Math.round(-11.5)等于多少？

Math.round(11.5)的返回值是12，Math.round(-11.5)的返回值是-11。四舍五入的原理是在参数上加0.5然后进行下取整。

<p id="javabase-10">

#### 用最有效率的方法计算2乘以8？

2 << 3（左移3位相当于乘以2的3次方，右移3位相当于除以2的3次方）。

补充：我们为编写的类重写hashCode方法时，可能会看到如下所示的代码：

```java
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + areaCode;
    result = prime * result + ((lineNumber == null) ? 0 : lineNumber.hashCode());
    result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
    return result;
}
```



其实我们不太理解为什么要使用这样的乘法运算来产生哈希码（散列码），而且为什么这个数是个素数，为什么通常选择31这个数？前两个问题的答案你可以自己百度一下，选择31是因为可以用移位和减法运算来代替乘法，从而得到更好的性能。说到这里你可能已经想到了：31 * num 等价于(num << 5) - num，左移5位相当于乘以2的5次方再减去自身就相当于乘以31，现在的JVM都能自动完成这个优化。

<p id="javabase-11">

#### 数组有没有length()方法？String有没有length()方法？

数组没有length()方法，有length 的属性。String 有length()方法。JavaScript中，获得字符串的长度是通过length属性得到的，这一点容易和Java混淆。

<p id="javabase-12">

#### 在Java中，如何跳出当前的多重嵌套循环？

在最外层循环前加一个标记如A，然后用break A;可以跳出多重循环。（Java中支持带标签的break和continue语句，作用有点类似于C和C++中的goto语句，但是就像要避免使用goto一样，应该避免使用带标签的break和continue，因为它不会让你的程序变得更优雅，很多时候甚至有相反的作用，所以这种语法其实不知道更好）

<p id="javabase-13">

#### 构造器（constructor）是否可被重写（override）？

构造器不能被继承，因此不能被重写，但可以被重载。

<p id="javabase-14">

#### 两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对？

不对，如果两个对象x和y满足x.equals(y) == true，它们的哈希码（hash code）应当相同。Java对于eqauls方法和hashCode方法是这样规定的：

> 1. 如果两个对象相同（equals方法返回true），那么它们的hashCode值一定要相同；
>
> 2. 如果两个对象的hashCode相同，它们并不一定相同。

当然，你未必要按照要求去做，但是如果你违背了上述原则就会发现在使用容器时，相同的对象可以出现在Set集合中，同时增加新元素的效率会大大下降（对于使用哈希存储的系统，如果哈希码频繁的冲突将会造成存取性能急剧下降）。

补充：关于equals和hashCode方法，很多Java程序都知道，但很多人也就是仅仅知道而已，在Joshua Bloch的大作《Effective Java》（很多软件公司，《Effective Java》、《Java编程思想》以及《重构：改善既有代码质量》是Java程序员必看书籍，如果你还没看过，那就赶紧去亚马逊买一本吧）中是这样介绍equals方法的：

首先equals方法必须满足以下四种特性：

>  1. 自反性：x.equals(x)必须返回true
>   2. 对称性：x.equals(y)返回true时，y.equals(x)也必须返回true
>  3. 传递性：x.equals(y)和y.equals(z)都返回true时，x.equals(z)也必须返回true
>  4. 一致性：当x和y引用的对象信息没有被修改时，多次调用x.equals(y)应该得到同样的返回值），而且对于任何非null值的引用x，x.equals(null)必须返回false。


实现高质量的equals方法的诀窍包括

> -  使用==操作符检查"参数是否为这个对象的引用"；
>
> - 使用instanceof操作符检查"参数是否为正确的类型"；
>
> - 对于类中的关键属性，检查参数传入对象的属性是否与之相匹配；
>
> - 编写完equals方法后，问自己它是否满足对称性、传递性、一致性；
>
> - 重写equals时总是要重写hashCode；
>
> - 不要将equals方法参数中的Object对象替换为其他的类型，在重写时不要忘掉@Override注解。

<p id="javabase-15">

#### 是否可以继承String类？

String 类是final类，不可以被继承。
这是java提供的一种沙箱机制决定，详情可参考jvm中的双亲委托机制
补充：继承String本身就是一个错误的行为，对String类型最好的重用方式是关联关系（Has-A）和依赖关系（Use-A）而不是继承关系（Is-A）。

<p id="javabase-16">

#### 当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递？

是值传递。Java语言的方法调用只支持参数的值传递。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的属性可以在被调用过程中被改变，但对对象引用的改变是不会影响到调用者的。C++和C#中可以通过传引用或传输出参数来改变传入的参数的值。

<p id="javabase-17">

#### String和StringBuilder、StringBuffer的区别？

Java平台提供了两种类型的字符串：String和StringBuffer/StringBuilder，它们可以储存和操作字符串。其中String是只读字符串，也就意味着String引用的字符串内容是不能被改变的。而StringBuffer/StringBuilder类表示的字符串对象可以直接进行修改。StringBuilder是Java 5中引入的，它和StringBuffer的方法完全相同，区别在于它是在单线程环境下使用的，因为它的所有方面都没有被synchronized修饰，也就是说他不是线程安全的，因此它的效率也比StringBuffer要高。

<p id="javabase-17-1">

##### 什么情况下用+运算符进行字符串连接比调用StringBuffer/StringBuilder对象的append方法连接字符串性能更好？

```
如果使用少量的字符串操作，使用 (+运算符)连接字符串；
如果频繁的对大量字符串进行操作，则使用
1：全局变量或者需要多线程支持则使用StringBuffer；
2：局部变量或者单线程不涉及线程安全则使有StringBuilder。
```

##### 请说出下面程序的输出。

```java
class StringEqualTest {
    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s5);//true
        System.out.println(s1 == s6);//false
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2 == s2.intern());//false
    }
}
```

解答上面的面试题需要清除两点：

> 1. String对象的intern方法会得到字符串对象在常量池中对应的版本的引用（如果常量池中有一个字符串与String对象的equals结果是true），如果常量池中没有对应的字符串，则该字符串将被添加到常量池中，然后返回常量池中字符串的引用；
> 2. 字符串的+操作其本质是创建了StringBuilder对象进行append操作，然后将拼接后的StringBuilder对象用toString方法处理成String对象，这一点可以用javap -c StringEqualTest.class命令获得class文件对应的JVM字节码指令就可以看出来。

<p id="javabase-18">

#### 重载（Overload）和重写（Override）的区别。重载的方法能否根据返回类型进行区分？

方法的重载和重写都是实现多态的方式，区别在于前者实现的是编译时的多态性，而后者实现的是运行时的多态性。重载发生在一个类中，同名的方法如果有不同的参数列表（**参数类型不同、参数个数不同或者二者都不同**）则视为重载；重写发生在子类与父类之间，重写要求子类被重写方法与父类被重写方法有相同的返回类型，比父类被重写方法更好访问，不能比父类被重写方法声明更多的异常（里氏代换原则）。重载对返回类型没有特殊的要求。

<p id="javabase-18-1">

##### 为什么不能根据返回类型来区分重载？

首先来说明**Java代码层面和字节码层面方法特征签名的区别**

> 方法特征签名：用于区分两个不同方法的语法符号；
>
> 1. Java代码层的方法特征签名：
>
>    特征签名 = 方法名 + 参数类型 + 参数顺序；
>
>     更多请参考：http://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.4.2
>
> 2. 字节码层面的方法特征签名：
>
>    特征签名 = 方法名 + 参数类型 + 参数顺序 + 返回值类型；
>
>     如果存在类型变量或参数化类型，还包括类型变量或参数化类型编译未擦除类型前的信息（FormalTypeParametersopt），和抛出的异常信息（ThrowsSignature），即方法名+签名；

      Java语言重载（Overload）一个方法，需要Java语言层面的方法特征签名不同，即不包括方法返回值；而Class文件中有两个同名同参数（类型、顺序都相同），但返回值类型不一样，也是允许的，可以正常运行，因为JVM层面的方法特征签名包括返回值类型。
      同样的，对字段来说，Java语言规定字段无法重载，名称必须不一样；但对Class文件来说，只要两个字段描述（类型）不一样，名称一样也是可以的。
<p id="javabase-19">

#### char 型变量中能不能存贮一个中文汉字，为什么？

char类型可以存储一个中文汉字，因为Java中使用的编码是Unicode（不选择任何特定的编码，直接使用字符在字符集中的编号，这是统一的唯一方法），一个char类型占2个字节（16比特），所以放一个中文是没问题的。
补充：使用Unicode意味着字符在JVM内部和外部有不同的表现形式，在JVM内部都是Unicode，当这个字符被从JVM内部转移到外部时（例如存入文件系统中），需要进行编码转换。所以Java中有字节流和字符流，以及在字符流和字节流之间进行转换的转换流，如InputStreamReader和OutputStreamReader，这两个类是字节流和字符流之间的适配器类，承担了编码转换的任务；对于C程序员来说，要完成这样的编码转换恐怕要依赖于union（联合体/共用体）共享内存的特征来实现了。

<p id="javabase-20">

#### 抽象类（abstract class）和接口（interface）有什么异同？

- 抽象类和接口都不能够实例化，但可以定义抽象类和接口类型的引用。

- 一个类如果继承了某个抽象类或者实现了某个接口都需要对其中的抽象方法全部进行实现，否则该类仍然需要被声明为抽象类。
- 接口比抽象类更加抽象，因为抽象类中可以定义构造器，可以有抽象方法和具体方法，而接口中不能定义构造器而且其中的方法全部都是抽象方法。
- 抽象类中的成员可以是private、默认、protected、public的，而接口中的成员全都是public的（java8后新增了接口中的默认方法与静态方法。[详情查看](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-java/markdown/java8.md)。以及java9中新增private私有方法）。
- 抽象类中可以定义成员变量，而接口中定义的成员变量实际上都是常量。
- 有抽象方法的类必须被声明为抽象类，而抽象类未必要有抽象方法。

<p id="javabase-21">

#### 静态嵌套类(Static Nested Class)和内部类（Inner Class）的不同？

Static Nested Class是被声明为静态（static）的内部类，它可以不依赖于外部类实例被实例化。而通常的内部类需要在外部类实例化后才能实例化，其语法看起来挺诡异的，如下所示。
```java
/**
* 扑克类（一副扑克）
* @author 骆昊
*
*/
public class Poker {
	private static String[] suites = {"黑桃", "红桃", "草花", "方块"};
	private static int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	private Card[] cards;
    /**
    * 构造器
    *
    */
    public Poker() {
        cards = new Card[52];
        for(int i = 0; i < suites.length; i++) {
        	for(int j = 0; j < faces.length; j++) {
    			cards[i * 13 + j] = new Card(suites[i], faces[j]);
    		}
		}
	}
    /**
    * 洗牌（随机乱序）
    *
    */
    public void shuffle() {
    	for(int i = 0, len = cards.length; i < len; i++) {
    		int index = (int) (Math.random() * len);
   		 	Card temp = cards[index];
    		cards[index] = cards[i];
    		cards[i] = temp;
    	}
    }
    /**
    * 发牌
    * @param index 发牌的位置
    *
    */
    public Card deal(int index) {
    	return cards[index];
    }
    
    /**
    * 卡片类（一张扑克）
    * [内部类]
    * @author 骆昊
    *
    */
    public class Card {
        private String suite; // 花色
        private int face; // 点数
        public Card(String suite, int face) {
            this.suite = suite;
            this.face = face;
        }
        @Override
        public String toString() {
            String faceStr = "";
            switch(face) {
                case 1: faceStr = "A"; break;
                case 11: faceStr = "J"; break;
                case 12: faceStr = "Q"; break;
                case 13: faceStr = "K"; break;
                default: faceStr = String.valueOf(face);
            }
            return suite + faceStr;
        }
    }
}

//测试代码：
class PokerTest {
    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.shuffle(); // 洗牌
        Poker.Card c1 = poker.deal(0); // 发第一张牌
        // 对于非静态内部类Card
        // 只有通过其外部类Poker对象才能创建Card对象
        Poker.Card c2 = poker.new Card("红心", 1); // 自己创建一张牌
        System.out.println(c1); // 洗牌后的第一张
        System.out.println(c2); // 打印: 红心A
    }
}

```

##### 下面的代码哪些地方会产生编译错误？
```java
class Outer {
	class Inner {}
	public static void foo() { 
        new Inner(); 
    }
	public void bar() { 
        new Inner();
    }
	public static void main(String[] args) {
		new Inner();
	}
}
```
Java中非静态内部类对象的创建要依赖其外部类对象，上面的面试题中foo和main方法都是静态方法，静态方法中没有this，也就是说没有所谓的外部类对象，因此无法创建内部类对象，如果要在静态方法中创建内部类对象，可以这样做：
```java
	new Outer().new Inner();
```

<p id="javabase-22">

#### 抽象的（abstract）方法是否可同时是静态的（static）,是否可同时是本地方法（native），是否可同时被synchronized修饰？

都不能。抽象方法需要子类重写，而静态的方法是无法被重写的，因此二者是矛盾的。本地方法是由本地代码（如C代码）实现的方法，而抽象方法是没有实现的，也是矛盾的。synchronized和方法的实现细节有关，抽象方法不涉及实现细节，因此也是相互矛盾的。

<p id="javabase-23">

#### 阐述静态变量和实例变量的区别。

静态变量是被static修饰符修饰的变量，也称为类变量，它属于类，不属于类的任何一个对象，一个类不管创建多少个对象，静态变量在内存中有且仅有一个拷贝；实例变量必须依存于某一实例，需要先创建对象然后通过对象才能访问到它。静态变量可以实现让多个对象共享内存。

<p id="javabase-24">

#### 是否可以从一个静态（static）方法内部发出对非静态（non-static）方法的调用？

不可以，静态方法只能访问静态成员，因为非静态方法的调用要先创建对象，在调用静态方法时可能对象并没有被初始化。

<p id="javabase-25">

#### 如何实现对象克隆？

有两种方式：
1). 实现Cloneable接口并重写Object类中的clone()方法； 
2). 实现Serializable接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆，代码如下。

```java
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class MyUtil {
    private MyUtil() {
    	throw new AssertionError();
    }
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
    }
}
```
下面是测试代码：
```java
import java.io.Serializable;
/**
* 人类
* @author 骆昊
*
*/
class Person implements Serializable {
    private static final long serialVersionUID = -9102017020286042305L;
    private String name; // 姓名
    private int age; // 年龄
    private Car car; // 座驾
    
    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public int getAge() {
    	return age;
    }
    public void setAge(int age) {
    	this.age = age;
    }
    public Car getCar() {
    	return car;
    }
    public void setCar(Car car) {
    	this.car = car;
    }
    
    @Override
    public String toString() {
    	return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
    }
}
/**
* 小汽车类
* @author 骆昊
*
*/
class Car implements Serializable {
    
    private static final long serialVersionUID = -5713945027627603702L;
    private String brand; // 品牌
    private int maxSpeed; // 最高时速
    
    public Car(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }
    public String getBrand() {
    	return brand;
    }
    public void setBrand(String brand) {
    	this.brand = brand;
    }
    public int getMaxSpeed() {
    	return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
    	this.maxSpeed = maxSpeed;
    }
    @Override
    public String toString() {
    	return "Car [brand=" + brand + ", maxSpeed=" + maxSpeed + "]";
    }
}
class CloneTest {
    
public static void main(String[] args) {
    try {
        Person p1 = new Person("Hao LUO", 33, new Car("Benz", 300));
        Person p2 = MyUtil.clone(p1); // 深度克隆
        p2.getCar().setBrand("BYD");
        // 修改克隆的Person对象p2关联的汽车对象的品牌属性
        // 原来的Person对象p1关联的汽车不会受到任何影响
        // 因为在克隆Person对象时其关联的汽车对象也被克隆了
        System.out.println(p1);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}

```
注意：基于序列化和反序列化实现的克隆不仅仅是深度克隆，更重要的是通过泛型限定，可以检查出要克隆的对象是否支持序列化，这项检查是编译器完成的，不是在运行时抛出异常，这种是方案明显优于使用Object类的clone方法克隆对象。让问题在编译的时候暴露出来总是好过把问题留到运行时。

<p id="javabase-26">

#### String s = new String("xyz");创建了几个字符串对象？

两个对象，一个是静态区的"xyz"，一个是用new创建在堆上的对象。

<p id="javabase-27">

#### 接口是否可继承（extends）接口？抽象类是否可实现（implements）接口？抽象类是否可继承具体类（concrete class）？

接口可以继承接口，而且支持多重继承。抽象类可以实现(implements)接口，抽象类可继承具体类也可以继承抽象类。

<p id="javabase-28">

#### 一个".java"源文件中是否可以包含多个类（不是内部类）？有什么限制？

可以，但一个源文件中最多只能有一个公开类（public class）而且文件名必须和公开类的类名完全保持一致。

<p id="javabase-29">

#### Anonymous Inner Class(匿名内部类)是否可以继承其它类？是否可以实现接口？

可以继承其他类或实现其他接口，在Swing编程和Android开发中常用此方式来实现事件监听和回调。

<p id="javabase-30">

#### 内部类可以引用它的包含类（外部类）的成员吗？有没有什么限制？

一个内部类对象可以访问创建它的外部类对象的成员，包括私有成员。

<p id="javabase-31">

#### Java 中的final关键字有哪些用法？

1. 修饰类：表示该类不能被继承；
2. 修饰方法：表示方法不能被重写；
3. 修饰变量：表示变量只能一次赋值以后值不能被修改（常量）。

<p id="javabase-32">

#### 指出下面程序的运行结果。

```java
class A {
    static {
    	System.out.print("1");
    }
    
    public A() {
    	System.out.print("2");
    }
    
    }
class B extends A{
    static {
        System.out.print("a");
    }
    public B() {
        System.out.print("b");
    }
}

public class Hello {
    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
    }
}
```

执行结果：1a2b2b。创建对象时构造器的调用顺序是：先初始化静态成员，然后调用父类构造器，再初始化非静态成员，最后调用自身构造器。

<p id="javabase-33">

#### 数据类型之间的转换：

- 如何将字符串转换为基本数据类型？ 

  调用基本数据类型对应的包装类中的方法parseXXX(String)或valueOf(String)即可返回相应基本类型；

- 如何将基本数据类型转换为字符串？

   一种方法是将基本数据类型与空字符串（""）连接（+）即可获得其所对应的字符串；另一种方法是调用String 类中的valueOf()方法返回相应字符串

<p id="javabase-34">

#### 如何实现字符串的反转及替换？

方法很多，可以自己写实现也可以使用String或StringBuffer/StringBuilder中的方法。有一道很常见的面试题是用递归实现字符串反转，代码如下所示：

```java
public static String reverse(String originStr) {
	if(originStr == null || originStr.length() <= 1)
    	return originStr;
	return reverse(originStr.substring(1)) + originStr.charAt(0);
}
```

<p id="javabase-35">

#### 怎样将GB2312编码的字符串转换为ISO-8859-1编码的字符串？

```java
String s1 = "你好";
String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
```

<p id="javabase-36">

#### 日期和时间：

<p id="javabase-36-1">

##### 如何取得年月日、小时分钟秒？ 


创建java.util.Calendar 实例，调用其get()方法传入不同的参数即可获得参数所对应的值。Java 8中可以使用java.time.LocalDateTimel来获取，代码如下所示。

```java
public class DateTimeTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH)); // 0 - 11
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
        // Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue()); // 1 - 12
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
    }
}
```
<p id="javabase-36-2">

##### 如何取得从1970年1月1日0时0分0秒到现在的毫秒数？ 

```java
Calendar.getInstance().getTimeInMillis();
System.currentTimeMillis();
Clock.systemDefaultZone().millis(); // Java 8
```

<p id="javabase-36-3">

##### 如何取得某月的最后一天？

```java
Calendar time = Calendar.getInstance();
time.getActualMaximum(Calendar.DAY_OF_MONTH);
```

<p id="javabase-36-4">

##### 如何格式化日期？

利用java.text.DataFormat 的子类（如SimpleDateFormat类）中的format(Date)方法可将日期格式化。Java 8中可以用java.time.format.DateTimeFormatter来格式化时间日期，代码如下所示:

```java
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
class DateFormatTest {
    public static void main(String[] args) {
        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));
        // Java 8
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));
    }
}
```


补充：Java的时间日期API一直以来都是被诟病的东西，为了解决这一问题，Java 8中引入了新的时间日期API，其中包括LocalDate、LocalTime、LocalDateTime、Clock、Instant等类，这些的类的设计都使用了不变模式，因此是线程安全的设计。

<p id="javabase-36-5">

##### 打印昨天的当前时刻。

```java
import java.util.Calendar;
class YesterdayCurrent {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        System.out.println(cal.getTime());
    }
}
在Java 8中，可以用下面的代码实现相同的功能。
import java.time.LocalDateTime;
class YesterdayCurrent {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        System.out.println(yesterday);
    }
}
```

<p id="javabase-37">

#### 比较一下Java和JavaSciprt。

JavaScript 与Java是两个公司开发的不同的两个产品。Java 是原Sun Microsystems公司推出的面向对象的程序设计语言，特别适合于互联网应用程序开发；而JavaScript是Netscape公司的产品，为了扩展Netscape浏览器的功能而开发的一种可以嵌入Web页面中运行的基于对象和事件驱动的解释性语言。

JavaScript的前身是LiveScript；而Java的前身是Oak语言。下面对两种语言间的异同作如下比较：

- 基于对象和面向对象

> Java是一种真正的面向对象的语言，即使是开发简单的程序，必须设计对象；JavaScript是种脚本语言，它可以用来制作与网络无关的，与用户交互作用的复杂软件。它是一种基于对象（Object-Based）和事件驱动（Event-Driven）的编程语言，因而它本身提供了非常丰富的内部对象供设计人员使用。

- 解释和编译

> Java的源代码在执行之前，必须经过编译。JavaScript是一种解释性编程语言，其源代码不需经过编译，由浏览器解释执行。（目前的浏览器几乎都使用了JIT（即时编译）技术来提升JavaScript的运行效率）

- 强类型变量和类型弱变量
> Java采用强类型变量检查，即所有变量在编译之前必须作声明；JavaScript中变量是弱类型的，甚至在使用变量前可以不作声明，JavaScript的解释器在运行时检查推断其数据类型。
 - 代码格式不一样。
补充：上面列出的四点是网上流传的所谓的标准答案。其实Java和JavaScript最重要的区别是一个是静态语言，一个是动态语言。目前的编程语言的发展趋势是函数式语言和动态语言。在Java中类（class）是一等公民，而JavaScript中函数（function）是一等公民，因此JavaScript支持函数式编程，可以使用Lambda函数和闭包（closure），当然Java 8也开始支持函数式编程，提供了对Lambda表达式以及函数式接口的支持。对于这类问题，在面试的时候最好还是用自己的语言回答会更加靠谱，不要背网上所谓的标准答案。

<p id="javabase-38">

#### 什么时候用断言（assert）？

断言在软件开发中是一种常用的调试方式，很多开发语言中都支持这种机制。一般来说，断言用于保证程序最基本、关键的正确性。断言检查通常在开发和测试时开启。为了保证程序的执行效率，在软件发布后断言检查通常是关闭的。断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为true；如果表达式的值为false，那么系统会报告一个AssertionError。断言的使用如下面的代码所示：

```java
assert(a > 0); // throws an AssertionError if a <= 0
```


断言可以有两种形式： 

```java
assert Expression1; assert Expression1 : Expression2 ;
```

Expression1应该总是产生一个布尔值。Expression2 可以是得出一个值的任意表达式；这个值用于生成显示更多调试信息的字符串消息。
要在运行时启用断言，可以在启动JVM时使用-enableassertions或者-ea标记。要在运行时选择禁用断言，可以在启动JVM时使用-da或者-disableassertions标记。要在系统类中启用或禁用断言，可使用-esa或-dsa标记。还可以在包的基础上启用或者禁用断言。
注意：断言不应该以任何方式改变程序的状态。简单的说，如果希望在不满足某些条件时阻止代码的执行，就可以考虑用断言来阻止它。

<p id="javabase-39">

#### Error和Exception有什么区别？

Error表示系统级的错误和程序不必处理的异常，是恢复不是不可能但很困难的情况下的一种严重问题；比如内存溢出，不可能指望程序能处理这样的情况；Exception表示需要捕捉或者需要程序进行处理的异常，是一种设计或实现问题；也就是说，它表示如果程序运行正常，从不会发生的情况。
面试题：2005年摩托罗拉的面试中曾经问过这么一个问题“If a process reports a stack overflow run-time error, what’s the most possible cause?”，给了如下四个选项：

> a. lack of memory; 
>
> b. write on an invalid memory space;
>
>  c. recursive function calling;
>
>  d. array index out of boundary. 

Java程序在运行时也可能会遭遇StackOverflowError，这是一个无法恢复的错误，只能重新修改代码了，这个面试题的答案是c。如果写了不能迅速收敛的递归，则很有可能引发栈溢出的错误，如下所示：

```java
class StackOverflowErrorTest {
    public static void main(String[] args) {
        main(null);
    }
}
```

提示：用递归编写程序时一定要牢记两点：1. 递归公式；2. 收敛条件（什么时候就不再继续递归）。

<p id="javabase-40">

#### try{}里有一个return语句，那么紧跟在这个try后的finally{}里的代码会不会被执行，什么时候被执行，在return前还是后?

会执行，在方法返回调用者前执行。
注意：在finally中改变返回值的做法是不好的，因为如果存在finally代码块，try中的return语句不会立马返回调用者，而是记录下返回值待finally代码块执行完毕之后再向调用者返回其值，然后如果在finally中修改了返回值，就会返回修改后的值。显然，在finally中返回或者修改返回值会对程序造成很大的困扰，C#中直接用编译错误的方式来阻止程序员干这种龌龊的事情，Java中也可以通过提升编译器的语法检查级别来产生警告或错误。

<p id="javabase-41">

#### Java语言如何进行异常处理，关键字：throws、throw、try、catch、finally分别如何使用？

Java通过面向对象的方法进行异常处理，把各种不同的异常进行分类，并提供了良好的接口。在Java中，每个异常都是一个对象，它是Throwable类或其子类的实例。当一个方法出现异常后便抛出一个异常对象，该对象中包含有异常信息，调用这个对象的方法可以捕获到这个异常并可以对其进行处理。Java的异常处理是通过5个关键词来实现的：try、catch、throw、throws和finally。

一般情况下是用try来执行一段程序，如果系统会抛出（throw）一个异常对象，可以通过它的类型来捕获（catch）它，或通过总是执行代码块（finally）来处理；try用来指定一块预防所有异常的程序；catch子句紧跟在try块后面，用来指定你想要捕获的异常的类型；

throw语句用来明确地抛出一个异常；throws用来声明一个方法可能抛出的各种异常（当然声明异常时允许无病呻吟）；

finally为确保一段代码不管发生什么异常状况都要被执行；

try语句可以嵌套，每当遇到一个try语句，异常的结构就会被放入异常栈中，直到所有的try语句都完成。如果下一级的try语句没有对某种异常进行处理，异常栈就会执行出栈操作，直到遇到有处理这种异常的try语句或者最终将异常抛给JVM。

<p id="javabase-42">

#### 运行时异常与受检异常有何异同？

异常表示程序运行过程中可能出现的非正常状态，运行时异常表示虚拟机的通常操作中可能遇到的异常，是一种常见运行错误，只要程序设计得没有问题通常就不会发生。受检异常跟程序运行的上下文环境有关，即使程序设计无误，仍然可能因使用的问题而引发。

Java编译器要求方法必须声明抛出可能发生的受检异常，但是并不要求必须声明抛出未被捕获的运行时异常。异常和继承一样，是面向对象程序设计中经常被滥用的东西，在Effective Java中对异常的使用给出了以下指导原则：

> - 不要将异常处理用于正常的控制流（设计良好的API不应该强迫它的调用者为了正常的控制流而使用异常）
> -  对可以恢复的情况使用受检异常，对编程错误使用运行时异常
> -  避免不必要的使用受检异常（可以通过一些状态检测手段来避免异常的发生） 
> - 优先使用标准的异常 - 每个方法抛出的异常都要有文档 - 保持异常的原子性 
> -  不要在catch中忽略掉捕获到的异常

<p id="javabase-43">

#### 列出一些你常见的运行时异常？

- ArithmeticException（算术异常）
- ClassCastException（类转换异常） 
- IllegalArgumentException （非法参数异常） 
- IndexOutOfBoundsException （下标越界异常）
-  NullPointerException （空指针异常） 
- SecurityException （安全异常）

<p id="javabase-44">

#### 阐述final、finally、finalize的区别。

- final：修饰符（关键字）有三种用法：如果一个类被声明为final，意味着它不能再派生出新的子类，即不能被继承，因此它和abstract是反义词。将变量声明为final，可以保证它们在使用中不被改变，被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取不可修改。被声明为final的方法也同样只能使用，不能在子类中被重写。
- finally：通常放在try…catch…的后面构造总是执行代码块，这就意味着程序无论正常执行还是发生异常，这里的代码只要JVM不关闭都能执行，可以将释放外部资源的代码写在finally块中。
- finalize：Object类中定义的方法，Java中允许使用finalize()方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在销毁对象时调用的，通过重写finalize()方法可以整理系统资源或者执行其他清理工作。

<p id="javabase-45">

#### 说出下面代码的运行结果。

```java
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
class Human {
    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}
```
<p id="javabase-46">

#### 简述正则表达式及其用途。
在编写处理字符串的程序时，经常会有查找符合某些复杂规则的字符串的需要。正则表达式就是用于描述这些规则的工具。换句话说，正则表达式就是记录文本规则的代码。
说明：计算机诞生初期处理的信息几乎都是数值，但是时过境迁，今天我们使用计算机处理的信息更多的时候不是数值而是字符串，正则表达式就是在进行字符串匹配和处理的时候最为强大的工具，绝大多数语言都提供了对正则表达式的支持。

<p id="javabase-47">

#### Java中是如何支持正则表达式操作的？
Java中的String类提供了支持正则表达式操作的方法，包括：matches()、replaceAll()、replaceFirst()、split()。此外，Java中可以用Pattern类表示正则表达式对象，它提供了丰富的API进行各种正则表达式操作，请参考下面面试题的代码。
面试题： - 如果要从字符串中截取第一个英文左括号之前的字符串，例如：北京市(朝阳区)(西城区)(海淀区)，截取结果为：北京市，那么正则表达式怎么写？

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class RegExpTest {
    public static void main(String[] args) {
        String str = "北京市(朝阳区)(西城区)(海淀区)";
        Pattern p = Pattern.compile(".*?(?=\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
    }
}
```

说明：上面的正则表达式中使用了懒惰匹配和前瞻，如果不清楚这些内容，推荐读一下网上很有名的《正则表达式30分钟入门教程》。

<p id="javabase-48">

#### 内部类访问外部属性为什么加final?
局部内部类能访问方法中的所有的局部变量，其生命周期与局部内部类的对象的生命周期是不一致的。如何才能实现访问呢?当变量是final时,通过将final局部变量"复制"一份,复制品直接作为局部内部中的数据成员。这样，当局部内部类访问局部变量时,其实真正访问的是这个局部变量的"复制品”。那么使用final修饰，表示其复制品与原始的量是一样

<p id="javabase-49">

####  this & super

1 super出现在父类的子类中。有三种存在方式

1.1. super.xxx(xxx为变量名或对象名)意思是获取父类中xxx的变量或引用
1.2. super.xxx(); (xxx为方法名)意思是直接访问并调用父类中的方法
1.3. super() 调用父类构造

注：super只能指代其直接父类

2 this() & super()在构造方法中的区别

2.1. 调用super()必须写在子类构造方法的第一行, 否则编译不通过
2.2. super从子类调用父类构造, this在同一类中调用其他构造
2.3. 均需要放在第一行
2.4. 尽管可以用this调用一个构造器, 却不能调用2个
2.5. this和super不能出现在同一个构造器中, 否则编译不通过
2.6. this()、super()都指的对象,不可以在static环境中使用
2.7. 本质this指向本对象的指针。super是一个关键字