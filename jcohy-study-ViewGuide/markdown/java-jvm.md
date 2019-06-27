
#  Java
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## Java虚拟机
> * [解释内存中的栈(stack)、堆(heap)和方法区(method area)的用法。](#jvm-1)
> * [描述一下JVM加载class文件的原理机制？](#jvm-2)
> * [Java 中会存在内存泄漏吗，请简单描述。](#jvm-3)
> * [GC是什么？为什么要有GC？](#jvm-4)
> * [对哪些区域回收？](#jvm-5)
> * [主动GC](#jvm-6)
> * [垃圾回收](#jvm-7)
> * [怎样判断是否需要收集？](#jvm-8)
> * [对象的自我救赎](#jvm-9)
> * [垃圾回收算法](#jvm-10)
> * [垃圾收集器](#jvm-11)
> * [不同垃圾回收算法对比](#jvm-12)
> * [内存分配](#jvm-13)
> * [关于GC的虚拟机参数](#jvm-14)
> * [方法区的回收](#jvm-15)
> * [JVM工具](#jvm-16)
> * [JVM内存结构](#jvm-17)
> * [JVM的方法区](#jvm-18)
> * [Java类加载器](#jvm-19)
> * [64 位 JVM 中，int 的长度是多大？](#jvm-20)
> * [Serial 与 Parallel GC之间的不同之处？](#jvm-21)
> * [Java 中 WeakReference 与 SoftReference的区别？](#jvm-22)
> * [WeakHashMap 是怎么工作的？](#jvm-23)
> * [JVM 选项 -XX:+UseCompressedOops 有什么作用？为什么要使用？](#jvm-24)
> * [怎样通过 Java 程序来判断 JVM 是 32 位 还是 64 位？](#jvm-25)
> * [32 位 JVM 和 64 位 JVM 的最大堆内存分别是多数？](#jvm-26)
> * [JRE、JDK、JVM 及 JIT 之间有什么不同？](#jvm-27)
> * [解释 Java 堆空间及 GC？](#jvm-28)
> * [你能保证 GC 执行吗？](#jvm-29)
> * [怎么获取 Java 程序使用的内存？堆使用的百分比？](#jvm-30)
> * [Java 中堆和栈有什么区别？](#jvm-31)
> * [JVM调优？](#jvm-32)
> * [Java中有内存泄漏吗？](#jvm-33)
> * [OOM解决办法](#jvm-34)
> * [DirectMemory直接内存](#jvm-35)
> * [双亲委派模型中的方法](#jvm-36)
> * [IO模型](#jvm-37)
> * [类加载器按照层次，从顶层到底层，分别加载哪些类？](#jvm-38)

<p id="jvm-1">

#### 解释内存中的栈(stack)、堆(heap)和方法区(method area)的用法。

通常我们定义一个基本数据类型的变量，一个对象的引用，还有就是函数调用的现场保存都使用JVM中的栈空间；而通过new关键字和构造器创建的对象则放在堆空间，堆是垃圾收集器管理的主要区域，由于现在的垃圾收集器都采用分代收集算法，所以堆空间还可以细分为新生代和老生代，再具体一点可以分为Eden、Survivor（又可分为From Survivor和To Survivor）、Tenured；方法区和堆都是各个线程共享的内存区域，用于存储已经被JVM加载的类信息、常量、静态变量、JIT编译器编译后的代码等数据；程序中的字面量（literal）如直接书写的100、"hello"和常量都是放在常量池中，常量池是方法区的一部分，。栈空间操作起来最快但是栈很小，通常大量的对象都是放在堆空间，栈和堆的大小都可以通过JVM的启动参数来进行调整，栈空间用光了会引发StackOverflowError，而堆和常量池空间不足则会引发OutOfMemoryError。

```java
String str = new String("hello")
```

上面的语句中变量str放在栈上，用new创建出来的字符串对象放在堆上，而"hello"这个字面量是放在方法区的。

运行时常量池相当于Class文件常量池具有动态性，Java语言并不要求常量一定只有编译期间才能产生，运行期间也可以将新的常量放入池中，String类的intern()方法就是这样的。
看看下面代码的执行结果是什么并且比较一下Java 7以前和以后的运行结果是否一致。

```java
String s1 = new StringBuilder("go")
.append("od").toString();
System.out.println(s1.intern() == s1);//true
String s2 = new StringBuilder("ja")
.append("va").toString();
System.out.println(s2.intern() == s2);//false
```

<p id="jvm-2">

#### 描述一下JVM加载class文件的原理机制？

JVM中类的装载是由类加载器（ClassLoader）和它的子类来实现的，Java中的类加载器是一个重要的Java运行时系统组件，它负责在运行时查找和装入类文件中的类。由于Java的跨平台性，经过编译的Java源程序并不是一个可执行程序，而是一个或多个类文件。当Java程序需要使用某个类时，JVM会确保这个类已经被加载、连接（验证、准备和解析）和初始化。类的加载是指把类的.class文件中的数据读入到内存中，通常是创建一个字节数组读入.class文件，然后产生与所加载类对应的Class对象。加载完成后，Class对象还不完整，所以此时的类还不可用。当类被加载后就进入连接阶段，这一阶段包括验证、准备（为静态变量分配内存并设置默认的初始值）和解析（将符号引用替换为直接引用）三个步骤。最后JVM对类进行初始化，包括：1)如果类存在直接的父类并且这个类还没有被初始化，那么就先初始化父类；2)如果类中存在初始化语句，就依次执行这些初始化语句。类的加载是由类加载器完成的，类加载器包括：根加载器（BootStrap）、扩展加载器（Extension）、系统加载器（System）和用户自定义类加载器（java.lang.ClassLoader的子类）。从Java 2（JDK 1.2）开始，类加载过程采取了父亲委托机制（PDM）。PDM更好的保证了Java平台的安全性，在该机制中，JVM自带的Bootstrap是根加载器，其他的加载器都有且仅有一个父类加载器。类的加载首先请求父类加载器加载，父类加载器无能为力时才由其子类加载器自行加载。
JVM不会向Java程序提供对Bootstrap的引用。下面是关于几个类加载器的说明：
? Bootstrap：一般用本地代码实现，负责加载JVM基础核心类库（rt.jar）；
? Extension：从java.ext.dirs系统属性所指定的目录中加载类库，它的父加载器是Bootstrap；
? System：又叫应用类加载器，其父类是Extension。它是应用最广泛的类加载器。它从环境变量classpath或者系统属性java.class.path所指定的目录中记载类，是用户自定义加载器的默认父加载器。

<p id="jvm-3">

#### Java 中会存在内存泄漏吗，请简单描述。
理论上Java因为有垃圾回收机制（GC）不会存在内存泄露问题（这也是Java被广泛使用于服务器端编程的一个重要原因）；然而在实际开发中，可能会存在无用但可达的对象，这些对象不能被GC回收，因此也会导致内存泄露的发生。例如Hibernate的Session（一级缓存）中的对象属于持久态，垃圾回收器是不会回收这些对象的，然而这些对象中可能存在无用的垃圾对象，如果不及时关闭（close）或清空（flush）一级缓存就可能导致内存泄露。下面例子中的代码也会导致内存泄露。

```java
import java.util.Arrays;
import java.util.EmptyStackException;
public class MyStack<T> {
    private T[] elements;
    private int size = 0;
    private static final int INIT_CAPACITY = 16;
    public MyStack() {
        elements = (T[]) new Object[INIT_CAPACITY];
    }
    public void push(T elem) {
        ensureCapacity();
        elements[size++] = elem;
    }
    public T pop() {
        if(size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }
    private void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
```
上面的代码实现了一个栈（先进后出（FILO））结构，乍看之下似乎没有什么明显的问题，它甚至可以通过你编写的各种单元测试。然而其中的pop方法却存在内存泄露的问题，当我们用pop方法弹出栈中的对象时，该对象不会被当作垃圾回收，即使使用栈的程序不再引用这些对象，因为栈内部维护着对这些对象的过期引用（obsolete reference）。在支持垃圾回收的语言中，内存泄露是很隐蔽的，这种内存泄露其实就是无意识的对象保持。如果一个对象引用被无意识的保留起来了，那么垃圾回收器不会处理这个对象，也不会处理该对象引用的其他对象，即使这样的对象只有少数几个，也可能会导致很多的对象被排除在垃圾回收之外，从而对性能造成重大影响，极端情况下会引发Disk Paging（物理内存与硬盘的虚拟内存交换数据），甚至造成OutOfMemoryError。

<p id="jvm-4">

#### GC是什么？为什么要有GC？
GC是垃圾收集的意思，内存处理是编程人员容易出现问题的地方，忘记或者错误的内存回收会导致程序或系统的不稳定甚至崩溃，Java提供的GC功能可以自动监测对象是否超过作用域从而达到自动回收内存的目的，Java语言没有提供释放已分配内存的显示操作方法。Java程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一：System.gc() 或Runtime.getRuntime().gc() ，但JVM可以屏蔽掉显示的垃圾回收调用。垃圾回收可以有效的防止内存泄露，有效的使用可以使用的内存。垃圾回收器通常是作为一个单独的低优先级的线程运行，不可预知的情况下对内存堆中已经死亡的或者长时间没有使用的对象进行清除和回收，程序员不能实时的调用垃圾回收器对某个对象或所有对象进行垃圾回收。在Java诞生初期，垃圾回收是Java最大的亮点之一，因为服务器端的编程需要有效的防止内存泄露问题，然而时过境迁，如今Java的垃圾回收机制已经成为被诟病的东西。移动智能终端用户通常觉得iOS的系统比Android系统有更好的用户体验，其中一个深层次的原因就在于Android系统中垃圾回收的不可预知性。
补充：垃圾回收机制有很多种，包括：分代复制垃圾回收、标记垃圾回收、增量垃圾回收等方式。标准的Java进程既有栈又有堆。栈保存了原始型局部变量，堆保存了要创建的对象。Java平台对堆内存回收和再利用的基本算法被称为标记和清除，但是Java对其进行了改进，采用“分代式垃圾收集”。这种方法会跟Java对象的生命周期将堆内存划分为不同的区域，在垃圾收集过程中，可能会将对象移动到不同区域：

- 伊甸园（Eden）：这是对象最初诞生的区域，并且对大多数对象来说，这里是它们唯一存在过的区域。

- 幸存者乐园（Survivor）：从伊甸园幸存下来的对象会被挪到这里。
- 终身颐养园（Tenured）：这是足够老的幸存对象的归宿。年轻代收集（Minor-GC）过程是不会触及这个地方的。当年轻代收集不能把对象放进终身颐养园时，就会触发一次完全收集（Major-GC），这里可能还会牵扯到压缩，以便为大对象腾出足够的空间。
  与垃圾回收相关的JVM参数：
  ? -Xms / -Xmx ? 堆的初始大小 / 堆的最大大小
  ? -Xmn ? 堆中年轻代的大小
  ? -XX:-DisableExplicitGC ? 让System.gc()不产生任何作用
  ? -XX:+PrintGCDetails ? 打印GC的细节
  ? -XX:+PrintGCDateStamps ? 打印GC操作的时间戳
  ? -XX:NewSize / XX:MaxNewSize ? 设置新生代大小/新生代最大大小
  ? -XX:NewRatio ? 可以设置老生代和新生代的比例
  ? -XX:PrintTenuringDistribution ? 设置每次新生代GC后输出幸存者乐园中对象年龄的分布
  ? -XX:InitialTenuringThreshold / -XX:MaxTenuringThreshold：设置老年代阀值的初始值和最大值
  ? -XX:TargetSurvivorRatio：设置幸存区的目标使用率

<p id="jvm-5">

#### 对哪些区域回收

Java运行时数据区域：程序计数器、JVM栈、本地方法栈、方法区和堆。

由于程序计数器、JVM栈、本地方法栈3个区域随线程而生随线程而灭，对这几个区域内存的回收和分配具有确定性。而方法区和堆则不一样，程序需要在运行时才知道创建哪些对象，对这部分内存的分配是动态的，GC关注的也就是这部分内存。

<p id="jvm-6">

#### 主动GC

调用system.gc() Runtime.getRuntime.gc()

<p id="jvm-7">

#### 垃圾回收

释放那些不在持有任何引用的对象的内存

<p id="jvm-8">

#### 怎样判断是否需要收集

- 引用计数法：对象没有任何引用与之关联(无法解决循环引用)

ext：Python使用引用计数法

- 可达性分析法：通过一组称为GC Root的对象为起点,从这些节点向下搜索，如果某对象不能从这些根对象的一个(至少一个)所到达,则判定该对象应当回收。

ext：可作为GCRoot的对象：虚拟机栈中引用的对象。方法区中类静态属性引用的对象，方法区中类常量引用的对象，本地方法栈中JNI引用的对象

<p id="jvm-9">

#### 对象的自我救赎

即使在可达性算法中判定为不可达时，也并非一定被回收。对象存在自我救赎的可能。要真正宣告对象的死亡，需要经历2次标记的过程。如果对象经过可达性分析法发现不可达时，对象将被第一次标记被进行筛选，筛选的条件是此对象是否有必要执行finalize方法。如果对象没有重写finalize方法或finalize方法已经被JVM调用过，则判定为不需要执行。

如果对象被判定为需要执行finalize方法，该对象将被放置在一个叫做F-Queue的队列中，JVM会建立一个低优先级的线程执行finalize方法，如果对象想要完成自我救赎需要在finalize方法中与引用链上的对象关联，比如把自己也就是this赋值给某个类变量。当GC第二次对F-Queue中对象标记时，该对象将被移出“即将回收”的集合，完成自我救赎。简言之，finalize方法是对象逃脱死亡命运的最后机会，并且任何对象的finalize方法只会被JVM调用一次。

<p id="jvm-10">

#### 垃圾回收算法

Mark-Sweep法：标记清除法 容易产生内存碎片，导致分配较大对象时没有足够的连续内存空间而提前出发GC。这里涉及到另一个问题，即对象创建时的内存分配，对象创建内存分配主要有2种方法，分别是指针碰撞法和空闲列表法。指针碰撞法：使用的内存在一侧，空闲的在另一侧，中间使用一个指针作为分界点指示器，对象内存分配时只要指针向空闲的移动对象大小的距离即可。
空闲列表法：使用的和空闲的内存相互交错无法进行指针碰撞，JVM必须维护一个列表记录哪些内存块可用，分配时从列表中找出一个足够的分配给对象，并更新列表记录。所以，当采用Mark-Sweep算法的垃圾回收器时，内存分配通常采用空闲列表法。

Copy法：将内存分为2块，每次使用其中的一块，当一块满了，将存活的对象复制到另一块，把使用过的那一块一次性清除。显然，Copy法解决了内存碎片的问题，但算法的代价是内存缩小为原来的一半。现代的垃圾收集器对新生代采用的正是Copy算法。但通常不执行1:1的策略，HotSpot虚拟机默认Eden区Survivor区8:1。每次使用Eden和其中一块Survivor区。也就是说新生代可用内存为新生代内存空间的90%。

Mark-Compact法：标记整理法。它的第一阶段与Mark-Sweep法一样，但不直接清除，而是将存活对象向一端移动，然后清除端边界以外的内存，这样也不存在内存碎片。

分代收集算法：将堆内存划分为新生代，老年代，根据新生代老年代的特点选取不同的收集算法。因为新生代对象大多朝生夕死，而老年代对象存活率高，没有额外空间进行分配担保，通常对新生代执行复制算法，老年代执行Mark-Sweep算法或Mark-Compact算法。

<p id="jvm-11">

#### 垃圾收集器

- Serial：

  串行垃圾回收器，他为单线程环境设计且只使用一个线程进行垃圾回收，会暂停所有用户线程，所以不适用于服务器环境

- Parallel

  并行垃圾回收器，多个垃圾收集线程并行工作，此时用户线程是暂停的，适用于科学计算/大数据处理首台处理等弱交互场景

- CMS

  并发垃圾回收器。用户线程和垃圾收集线程同时执行（不一定是并行，可能交替执行），不需要停顿用户线程。互联网公司多用它，适用于对响应时间有要求的场景。

- G1

  G1垃圾回收器将堆内存分割成不同的区域然后并发的对其进行垃圾回收。

- ZGC(java11，12)

通常来说，新生代老年代使用不同的垃圾收集器。新生代的垃圾收集器有Serial（单线程）、ParNew（Serial的多线程版本）、ParallelScavenge（吞吐量优先的垃圾收集器），老年代有SerialOld（单线程老年代）、ParallelOld（与ParallelScavenge搭配的多线程执行标记整理算法的老年代收集器）、CMS（标记清除算法，容易产生内存碎片，可以开启内存整理的参数），以及当前最先进的垃圾收集器G1，G1通常面向服务器端的垃圾收集器，在我自己的Java应用程序中通过-XX:+PrintGCDetails，发现自己的垃圾收集器是使用了ParallelScavenge + ParallelOld的组合。

<p id="jvm-12">

#### 不同垃圾回收算法对比

- 标记清除法(Mark-Sweeping):易产生内存碎片
- 复制回收法(Copying)：为了解决Mark-Sweep法而提出,内存空间减至一半
- 标记压缩法(Mark-Compact):为了解决Copying法的缺陷,标记后移动到一端再清除
- 分代回收法(GenerationalCollection):新生代对象存活周期短,需要大量回收对象,需要复制的少,执行copy算法;老年代对象存活周期相对长,回收少量对象,执行mark-compact算法.新生代划分：较大的eden区 和 2个survivor区

<p id="jvm-13">

#### 内存分配

- 新生代的三部分 |Eden Space|From Space|To Space|，对象主要分配在新生代的Eden区

- 大对象直接进入老年代
大对象比如大数组直接进入老年代，可通过虚拟机参数-XX：PretenureSizeThreshold参数设置

- 长期存活的对象进入老年代
ext：虚拟机为每个对象定义一个年龄计数器，如果对象在Eden区出生并经过一次MinorGC仍然存活，将其移入Survivor的To区，GC完成标记互换后，相当于存活的对象进入From区，对象年龄加1，当增加到默认15岁时，晋升老年代。可通过-XX：MaxTenuringThreshold设置

- GC的过程：GC开始前，对象只存在于Eden区和From区，To区逻辑上始终为空。对象分配在Eden区，Eden区空间不足，发起MinorGC，将Eden区所有存活的对象复制到To区，From区存活的对象根据年龄判断去向，若到达年龄阈值移入老年代，否则也移入To区，GC完成后Eden区和From区被清空，From区和To区标记互换。对象每在Survivor区躲过一次MinorGC年龄加一。MinorGC将重复这样的过程，直到To区被填满，To区满了以后，将把所有对象移入老年代。

- 动态对象年龄判定 suvivor区相同年龄对象总和大于suvivor区空间的一半,年龄大于等于该值的对象直接进入老年代

- 空间分配担保 在MinorGC开始前，虚拟机检查老年代最大可用连续空间是否大于新生代所有对象总空间，如果成立，MinorGC可以确保是安全的。否则，虚拟机会查看HandlePromotionFailure设置值是否允许担保失败，如果允许，继续查看老年代最大可用连续空间是否大于历次晋升到老年代对象的平均大小，如果大于则尝试MinorGC，尽管这次MinorGC是有风险的。如果小于，或者HandlerPromotionFailure设置不允许，则要改为FullGC。

- 新生代的回收称为MinorGC,对老年代的回收成为MajorGC又名FullGC

<p id="jvm-14">

#### 关于GC的虚拟机参数

GC相关

-XX:NewSize和-XX:MaxNewSize 新生代大小
-XX:SurvivorRatio Eden和其中一个survivor的比值
-XX：PretenureSizeThreshold 大对象进入老年代的阈值
-XX:MaxTenuringThreshold 晋升老年代的对象年龄

收集器设置
-XX:+UseSerialGC:设置串行收集器
-XX:+UseParallelGC:设置并行收集器
-XX:+UseParalledlOldGC:设置并行年老代收集器
-XX:+UseConcMarkSweepGC:设置并发收集器

堆大小设置

-Xmx:最大堆大小
-Xms:初始堆大小(最小内存值)
-Xmn:年轻代大小
-XXSurvivorRatio:3 意思是Eden:Survivor=3:2
-Xss栈容量

垃圾回收统计信息

-XX:+PrintGC 输出GC日志
-XX:+PrintGCDetails 输出GC的详细日志

<p id="jvm-15">

####  方法区的回收

方法区通常会与永久代划等号，实际上二者并不等价，只不过是HotSpot虚拟机设计者用永久代实现方法区，并将GC分代扩展至方法区。
永久代垃圾回收通常包括两部分内容：废弃常量和无用的类。常量的回收与堆区对象的回收类似，当没有其他地方引用该字面量时，如果有必要，将被清理出常量池。

判定无用的类的3个条件：

1.该类的所有实例都已经被回收，也就是说堆中不存在该类的任何实例

2.加载该类的ClassLoader已经被回收

3.该类对应的java.lang.Class对象没有在任何地方被引用，无法在任何地方通过反射访问该类的方法。

当然，这也仅仅是判定，不代表立即卸载该类。

<p id="jvm-16">

#### JVM工具

命令行

1. jps(jvm processor status)虚拟机进程状况工具
2. jstat(jvm statistics monitoring)统计信息监视
3. jinfo(configuration info for java)配置信息工具
4. jmap(memory map for java)Java内存映射工具
5. jhat(JVM Heap Analysis Tool)虚拟机堆转储快照分析工具
6. jstack(Stack Trace for Java)Java堆栈跟踪工具
7. HSDIS：JIT生成代码反汇编

可视化
1. JConsole(Java Monitoring and Management Console):Java监视与管理控制台
2. VisualVM(All-in-one Java Troubleshooting Tool):多合一故障处理工具

<p id="jvm-17">

####  JVM内存结构

1. 堆:新生代和年老代
2. 方法区(非堆):持久代, 代码缓存, 线程共享
3. JVM栈:中间结果,局部变量,线程隔离
4. 本地栈:本地方法(非Java代码)
5. 程序计数器 ：线程私有，每个线程都有自己独立的程序计数器，用来指示下一条指令的地址
6. 注：持久代Java8消失, 取代的称为元空间(本地堆内存的一部分)

<p id="jvm-18">

#### JVM的方法区

与堆一样，是线程共享的区域。方法区中存储：被虚拟机加载的类信息，常量，静态变量，JIT编译后的代码等数据。参见我是一个Java Class。

<p id="jvm-19">

#### Java类加载器

一个jvm中默认的classloader有Bootstrap ClassLoader、Extension ClassLoader、App ClassLoader，分别各司其职： 

1. Bootstrap ClassLoader(引导类加载器) 负责加载java基础类，主要是 %JRE_HOME/lib/目录下的rt.jar、resources.jar、charsets.jar等
2. Extension ClassLoader(扩展类加载器) 负责加载java扩展类，主要是 %JRE_HOME/lib/ext目录下的jar等
3. App ClassLoader(系统类加载器) 负责加载当前java应用的classpath中的所有类。 
classloader 加载类用的是全盘负责委托机制。 所谓全盘负责，即是当一个classloader加载一个Class的时候，这个Class所依赖的和引用的所有 Class也由这个classloader负责载入，除非是显式的使用另外一个classloader载入。 
所以，当我们自定义的classloader加载成功了com.company.MyClass以后，MyClass里所有依赖的class都由这个classLoader来加载完成。

<p id="jvm-20">

#### 64 位 JVM 中，int 的长度是多大？

Java 中，int 类型变量的长度是一个固定值，与平台无关，都是 32 位。意思就是说，在 32 位 和 64 位 的Java 虚拟机中，int 类型的长度是相同的。

<p id="jvm-21">

#### Serial 与 Parallel GC之间的不同之处？

Serial 与 Parallel 在GC执行的时候都会引起 stop-the-world。它们之间主要不同 serial 收集器是默认的复制收集器，执行 GC 的时候只有一个线程，而 parallel 收集器使用多个 GC 线程来执行。

<p id="jvm-22">

#### Java 中 WeakReference 与 SoftReference的区别？

Java中一共有四种类型的引用。StrongReference、 SoftReference、 WeakReference 以及 PhantomReference。

StrongReference：Java 的默认引用实现, 它会尽可能长时间的存活于 JVM 内，当没有任何对象指向它时将会被GC回收

SoftReference：尽可能长时间保留引用，直到JVM内存不足，适合某些缓存应用

WeakReference：顾名思义, 是一个弱引用, 当所引用的对象在 JVM 内不再有强引用时, 下一次将被GC回收

PhantomReference：它是最弱的一种引用关系，也无法通过PhantomReference取得对象的实例。仅用来当该对象被回收时收到一个通知

虽然 WeakReference 与 SoftReference 都有利于提高 GC 和 内存的效率，但是 WeakReference ，一旦失去最后一个强引用，就会被 GC 回收，而 SoftReference 会尽可能长的保留引用直到 JVM 内存不足时才会被回收(虚拟机保证), 这一特性使得 SoftReference 非常适合缓存应用。

<p id="jvm-23">

####  WeakHashMap 是怎么工作的？

WeakHashMap 的工作与正常的 HashMap 类似，但是使用弱引用作为 key，意思就是当 key 对象没有任何引用时，key/value 将会被回收。

<p id="jvm-24">

#### JVM 选项 -XX:+UseCompressedOops 有什么作用？为什么要使用？

当你将你的应用从 32 位的 JVM 迁移到 64 位的 JVM 时，由于对象的指针从 32 位增加到了 64 位，因此堆内存会突然增加，差不多要翻倍。这也会对 CPU 缓存（容量比内存小很多）的数据产生不利的影响。因为，迁移到 64 位的 JVM 主要动机在于可以指定最大堆大小，通过压缩 OOP 可以节省一定的内存。通过 -XX:+UseCompressedOops 选项，JVM 会使用 32 位的 OOP，而不是 64 位的 OOP。

<p id="jvm-25">

####  怎样通过 Java 程序来判断 JVM 是 32 位 还是 64 位？

你可以检查某些系统属性如 sun.arch.data.model 或 os.arch 来获取该信息。

<p id="jvm-26">

#### 32 位 JVM 和 64 位 JVM 的最大堆内存分别是多数？

理论上说上 32 位的 JVM 堆内存可以到达 2^32，即 4GB，但实际上会比这个小很多。不同操作系统之间不同，如 Windows 系统大约 1.5 GB，Solaris 大约 3GB。64 位 JVM允许指定最大的堆内存，理论上可以达到 2^64，这是一个非常大的数字，实际上你可以指定堆内存大小到 100GB。甚至有的 JVM，如 Azul，堆内存到 1000G 都是可能的。

<p id="jvm-27">

#### JRE、JDK、JVM 及 JIT 之间有什么不同？

JRE 代表 Java 运行时（Java run-time），是运行 Java 应用所必须的。JDK 代表 Java 开发工具（Java development kit），是 Java 程序的开发工具，如 Java 编译器，它也包含 JRE。JVM 代表 Java 虚拟机（Java virtual machine），它的责任是运行 Java 应用。JIT 代表即时编译（Just In Time compilation），当代码执行的次数超过一定的阈值时，会将 Java 字节码转换为本地代码，如，主要的热点代码会被准换为本地代码，这样有利大幅度提高 Java 应用的性能。

![JVM JRE JDK](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/10.jpg)

<p id="jvm-28">

#### 解释 Java 堆空间及 GC？

当通过 Java 命令启动 Java 进程的时候，会为它分配内存。内存的一部分用于创建堆空间，当程序中创建对象的时候，就从对空间中分配内存。GC 是 JVM 内部的一个后台进程，回收无效对象的内存用于将来的分配。

<p id="jvm-29">

#### 你能保证 GC 执行吗？

不能，虽然你可以调用 System.gc() 或者 Runtime.getRuntime().gc()，但是没有办法保证 GC 的执行。

<p id="jvm-30">

#### 怎么获取 Java 程序使用的内存？堆使用的百分比？

可以通过 java.lang.Runtime 类中与内存相关方法来获取剩余的内存，总内存及最大堆内存。通过这些方法你也可以获取到堆使用的百分比及堆内存的剩余空间。Runtime.freeMemory() 方法返回剩余空间的字节数，Runtime.totalMemory() 方法总内存的字节数，Runtime.maxMemory() 返回最大内存的字节数。

<p id="jvm-31">

#### Java 中堆和栈有什么区别？

JVM 中堆和栈属于不同的内存区域，使用目的也不同。栈常用于保存方法帧和局部变量，而对象总是在堆上分配。栈通常都比堆小，也不会在多个线程之间共享，而堆被整个 JVM 的所有线程共享。

<p id="jvm-32">

#### JVM调优

使用工具Jconsol、VisualVM、JProfiler等

**堆信息查看**

可查看堆空间大小分配（年轻代、年老代、持久代分配）
提供即时的垃圾回收功能
垃圾监控（长时间监控回收情况）

查看堆内类、对象信息查看：数量、类型等

对象引用情况查看

有了堆信息查看方面的功能，我们一般可以顺利解决以下问题：

  年老代年轻代大小划分是否合理
  内存泄漏
  垃圾回收算法设置是否合理

**线程监控**

线程信息监控：系统线程数量。
线程状态监控：各个线程都处在什么样的状态下

Dump线程详细信息：查看线程内部运行情况
死锁检查

热点分析

CPU热点：检查系统哪些方法占用的大量CPU时间
内存热点：检查哪些对象在系统中数量最大（一定时间内存活对象和销毁对象一起统计）

快照

系统两个不同运行时刻，对象（或类、线程等）的不同

举例说，我要检查系统进行垃圾回收以后，是否还有该收回的对象被遗漏下来的了。那么，我可以在进行垃圾回收前后，分别进行一次堆情况的快照，然后对比两次快照的对象情况。

**内存泄漏检查**

年老代堆空间被占满

持久代被占满

堆栈溢出

线程堆栈满

系统内存被占满

<p id="jvm-33">

#### Java中有内存泄漏吗？

内存泄露的定义: 当某些对象不再被应用程序所使用,但是由于仍然被引用而导致垃圾收集器不能释放。

内存泄漏的原因：对象的生命周期不同。比如说对象A引用了对象B. A的生命周期比B的要长得多，当对象B在应用程序中不会再被使用以后, 对象 A 仍然持有着B的引用. (根据虚拟机规范)在这种情况下GC不能将B从内存中释放。这种情况很可能会引起内存问题，倘若A还持有着其他对象的引用,那么这些被引用的(无用)对象也不会被回收,并占用着内存空间。甚至有可能B也持有一大堆其他对象的引用。这些对象由于被B所引用,也不会被垃圾收集器所回收，所有这些无用的对象将消耗大量宝贵的内存空间。并可能导致内存泄漏。

怎样防止：

1、当心集合类, 比如HashMap, ArrayList等,因为这是最容易发生内存泄露的地方.当集合对象被声明为static时,他们的生命周期一般和整个应用程序一样长。

<p id="jvm-34">
#### OOM

- java.lang.StackOverflowError
- java.lang.OutOfMemoryError:java heap space
- java.lang.OutOfMemoryError:GC overhead limit exceeded
- java.lang.OutOfMemoryError:Direct buffer memoer
- java.lang.OutOfMemoryError:unable to create new native thread
- java.lang.OutOfMemoryError:Metaspace

内存溢出的空间：Permanent Generation和Heap Space，也就是永久代和堆区

1、永久代的OOM

解决办法有2种：

a.通过虚拟机参数-XX：PermSize和-XX：MaxPermSize调整永久代大小

b.清理程序中的重复的Jar文件，减少类的重复加载

2、堆区的溢出

发生这种问题的原因是java虚拟机创建的对象太多，在进行垃圾回收之间，虚拟机分配的到堆内存空间已经用满了，与Heap Space的size有关。解决这类问题有两种思路：

1. 检查程序，看是否存在死循环或不必要地重复创建大量对象，定位原因，修改程序和算法。

2. 通过虚拟机参数-Xms和-Xmx设置初始堆和最大堆的大小

<p id="jvm-35">

#### DirectMemory直接内存

直接内存并不是Java虚拟机规范定义的内存区域的一部分，但是这部分内存也被频繁使用，而且也可能导致OOM异常的出现。

JDK1.4引入了NIO，这是一种基于通道和缓冲区的非阻塞IO模式，它可以使用Native函数库分配直接堆外内存，然后通过一个存储在Java堆中的DirectByteBuffer对象作为这块内存的引用进行操作，使得在某些场合显著提高性能，因为它避免了在Java堆和本地堆之间来回复制数据。

<p id="jvm-36">

#### 双亲委派模型中的方法

findLoadedClass(),LoadClass(),findBootstrapClassOrNull(),findClass(),resolveClass()

<p id="jvm-37">


####  IO模型

一般来说 I/O 模型可以分为：同步阻塞，同步非阻塞，异步阻塞，异步非阻塞 四种IO模型

- 同步阻塞 IO ：
  在此种方式下，用户进程在发起一个 IO 操作以后，必须等待 IO 操作的完成，只有当真正完成了 IO 操作以后，用户进程才能运行。 JAVA传统的 IO 模型属于此种方式！

- 同步非阻塞 IO:
  在此种方式下，用户进程发起一个 IO 操作以后可返回做其它事情，但是用户进程需要时不时的询问 IO 操作是否就绪，这就要求用户进程不停的去询问，从而引入不必要的 CPU 资源浪费。其中目前 JAVA 的 NIO 就属于同步非阻塞 IO 。

- 异步阻塞 IO ：
  此种方式下是指应用发起一个 IO 操作以后，不等待内核 IO 操作的完成，等内核完成 IO 操作以后会通知应用程序，这其实就是同步和异步最关键的区别，同步必须等待或者主动的去询问 IO 是否完成，那么为什么说是阻塞的呢？因为此时是通过 select 系统调用来完成的，而 select 函数本身的实现方式是阻塞的，而采用 select 函数有个好处就是它可以同时监听多个文件句柄，从而提高系统的并发性！

- 异步非阻塞 IO:
  在此种模式下，用户进程只需要发起一个 IO 操作然后立即返回，等 IO 操作真正的完成以后，应用程序会得到 IO 操作完成的通知，此时用户进程只需要对数据进行处理就好了，不需要进行实际的 IO 读写操作，因为 真正的 IO读取或者写入操作已经由 内核完成了。目前 Java7的AIO正是此种类型。

BIO即同步阻塞IO，适用于连接数目较小且固定的架构，这种方式对服务器资源要求比较高，并发局限于应用中，JDK1.4之前的唯一选择，但程序直观、简单、易理解。

NIO即同步非阻塞IO，适用于连接数目多且连接比较短的架构，比如聊天服务器，并发局限于应用中，编程比较复杂，JDK1.4开始支持。

AIO即异步非阻塞IO，适用于连接数目多且连接比较长的架构，如相册服务器，充分调用OS参与并发操作，编程比较复杂，JDK1.7开始支持

<p id="jvm-38">


####  类加载器按照层次，从顶层到底层，分别加载哪些类？

- 启动类加载器：负责将存放在JAVA_HOME/lib下的，或者被－Xbootclasspath参数所指定的路径中的，并且是虚拟机识别的类库加载到虚拟机内存中。启动类加载器无法被Java程序直接引用。


- 扩展类加载器：这个加载器负责加载JAVA_HOME/lib/ext目录中的，或者被java.ext.dirs系统变量所指定的路径中的所有类库，开发者可以直接使用扩展类加载器


- 应用程序类加载器：这个加载器是ClassLoader中getSystemClassLoader()方法的返回值，所以一般也称它为系统类加载器。它负责加载用户类路径（Classpath）上所指定的类库，可直接使用这个加载器，如果应用程序没有自定义自己的类加载器，一般情况下这个就是程序中默认的类加载器

实现自己的加载器，只需要继承ClassLoader，并覆盖findClass方法。
在调用loadClass方法时，会先根据委派模型在父加载器中加载，如果加载失败，则会调用自己的findClass方法来完成加载.

#### JVM垃圾回收如何确定垃圾，是否知道什么是GC Roots?

- 1、引用计数法

在Java中，引用和对象是有关联的，如果要操作对象必须引用进行。因此，很显然一个简单的方法是通过引用计数来判断一个对象是否可以被回收，简单说。给对象中添加一个引用计数器，每当有一个地方引用它，计数器值加一，每当一个引用失效时，计数器减一。任何时刻计数器为零的对象就是不可能再被使用的，那么这个对象就是可回收对象。那为什么主流的Java虚拟机里面都没有选用这种算法呢，其中主要的原因是它很难解决对象之间相互循环引用的问题。

- 2、枚举根节点做可达性分析（根搜索路径）

所谓GC Roots 或者说 Tracing GC 的根集合，就是一组必须活跃的引用。

基本思路就是通过一系列名为“GCRoots”的对象作为起始点，从这个被称为GC Roots的对象开始向下搜索，如果一个对象到GC Roots没有任何引用链相连时，则说明此对象不可达，也即给定一个集合的引用作为根出发，通过引用关系遍历对象图，能被遍历到的对象就被判定为存活，没有被遍历到的就自然被判定为死亡。

##### 那些对象可以作为GC Roots

- 虚拟机栈（栈帧中的局部变量区）中引用的对象

- 方法区中的类静态属性引用的对象

- 方法区中常量引用的对象

- 本地方法栈中JNI（native方法）引用的对象


#### 强引用，软引用，弱引用，虚引用

##### 强引用

当内存不足时，JVM开始垃圾回收，对于强引用的对象，就算是出现了OOM也不会对该对象进行回收。

强引用是我们最常见的普通对象引用，只要还有强引用指向一个对象，就能表明对象还“活着”，垃圾收集器不会碰这种对象。在Java中最常见的就是强引用，把一个对象付给一个引用变量，这个引用变量就是一个强引用，当一个对象不黑强引用变量引用时，它处于可达状态，它是不可能被垃圾回收机制回收的，及时该对象以后永远都不会用到JVM也不会回收。因此强引用时造成java内存泄漏的主要原因之一

对于一个普通的对象，如果没有其他的引用关系，只要超过了引用的作用域或者显式的将相应引用赋值为null，一般认为就是可以被垃圾收集的。

##### 软引用

软引用是一种相对弱化了一些的引用，需要用java.lang.SoftReference。类来实现，可以让对象豁免一些垃圾收集。

对于只有软引用的对线来说，当系统内存足够时，不会被回收。当系统内存不足时，会被回收。

##### 弱引用

不管内存够不够用，只要有GC，都被回收。需要使用java.lang.refWeakReference类实现。

WeakHashMap:

##### 虚引用

虚引用需要使用java.lang.ref.PhantomReference类实现。

顾名思义，就是形同虚设，与其他几种引用一样，虚引用并不会决定对象的生命周期。

如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收机制回收，它不能单独使用也不能通过它访问对象，虚引用必须和引用队列（RnferenceQueue）联合使用。

虚引用的主要作用是跟踪对象被垃圾回收的状态，仅仅是提供了一种确保对象被finalize以后，做某些事情的机制

PhantomReference的get方法总是返回null，因此无法访问对应的引用对象，其意义在于说明一个对象已经进入finalization阶段。可以被gc回收，用来实现比finalization机制更灵活的回收操作。

换句话说，设置虚引用关联的唯一目的，就是在这个对象被收集器回收的时候收到一个系统通知或者后续添加进一步的处理。

java技术允许使用finalize()方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。

##### 总结

![四种引用](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/四种引用.jpg)

