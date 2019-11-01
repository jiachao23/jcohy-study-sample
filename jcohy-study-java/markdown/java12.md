# Java12新特性
> * [jdk12新特性一览](#Features)
> * [Shenandoah：一个低停顿垃圾收集器（实验阶段）](#Shenandoah)
> * [Switch 表达式扩展](#Switch)
> * [微基准套件](#微基准套件)
> * [ 引入 JVM 常量 API ](#jvm)
> * [改进 AArch64 实现](#AArch64)
> * [默认类数据共享（CDS）存档 ](#CDS)
> * [可中止的G1 Mixed GC](#G1)
> * [G1及时返回未使用的已分配内存](#G11)
> * [其他特性](#other)


<p id="Features">

## jdk12新特性一览

Java 12 已如期于 3 月 19 日正式发布，此次更新是 Java 11 这一长期支持版本发布之后的一次常规更新，截至目前，Java 半年为发布周期，并且不会跳票承诺的发布模式，已经成功运行一年多了。通过这样的方式，Java 开发团队能够将一些重要特性尽早的合并到 Java Release 版本中，以便快速得到开发者的反馈，避免出现类似 Java 9 发布时的两次延期的情况。

Java 12 早在 2018 年 12 月便进入了 Rampdown Phase One 阶段，这意味着该版本所有新的功能特性被冻结，不会再加入更多的 JEP。该阶段将持续大概一个月，主要修复 P1-P3 级错误。主要时间节点如下：

2018-12-13 Rampdown 第一阶段 ( 从主线分离 )
2019-01-17 Rampdown 第二阶段
2019-02-07 发布候选阶段
2019-03-19 正式发布
本文主要针对 Java 12 中的新特性展开介绍，让您快速了解 Java 12 带来的变化。


资料来源： http://openjdk.java.net/projects/jdk/12/

| 新特性 | 翻译 |
| ------------------------------------------------------------ | ---- |
| 189:  [Shenandoah: A Low-Pause-Time Garbage Collector (Experimental)](http://openjdk.java.net/jeps/189) |Shenandoah：一个低停顿垃圾收集器（实验阶段）|
| 230:  [Microbenchmark Suite](http://openjdk.java.net/jeps/230) |微基准套件|
| 325:[Switch Expressions (Preview)](http://openjdk.java.net/jeps/325) | Switch 表达式扩展 |
| 334:[JVM Constants API](http://openjdk.java.net/jeps/334) | 引入 JVM 常量 API |
| 340:[One AArch64 Port, Not Two](http://openjdk.java.net/jeps/340) | 只保留一个AArch64实现 |
| 341:[Default CDS Archives](http://openjdk.java.net/jeps/341) | 默认类数据共享（CDS）存档 |
| 344:[Abortable Mixed Collections for G1](http://openjdk.java.net/jeps/344) | 可中止的G1 Mixed GC |
| 346:[Promptly Return Unused Committed Memory from G1](http://openjdk.java.net/jeps/346) | G1及时返回未使用的已分配内存 |

<p id="Shenandoah">

## Shenandoah：一个低停顿垃圾收集器（实验阶段）
Java 12 中引入一个新的垃圾收集器：Shenandoah，它是作为一中低停顿时间的垃圾收集器而引入到 Java 12 中的，其工作原理是通过与 Java 应用程序中的执行线程同时运行，用以执行其垃圾收集、内存回收任务，通过这种运行方式，给虚拟机带来短暂的停顿时间。

Shenandoah 垃圾回收器是 Red Hat 在 2014 年宣布进行的一项垃圾收集器研究项目，旨在针对 JVM 上的内存收回实现低停顿的需求。该设计将与应用程序线程并发，通过交换 CPU 并发周期和空间以改善停顿时间，使得垃圾回收器执行线程能够在 Java 线程运行时进行堆压缩，并且标记和整理能够同时进行，因此避免了在大多数 JVM 垃圾收集器中所遇到的问题。

据 Red Hat 研发 Shenandoah 团队对外宣称，Shenandoah 垃圾回收器的暂停时间与堆大小无关，这意味着无论将堆设置为 200 MB 还是 200 GB，都将拥有一致的系统暂停时间，不过实际使用性能将取决于实际工作堆的大小和工作负载。

#### 补充：SWT

Stop-the-World ，简称STW ，指的是GC 事件发生过程中，停止所有的应用程序线程的执行。就像警察办案，需要清场一样。

垃圾回收器的任务是识别和回收垃圾对象进行内存清理。为了让垃圾回收器可以正常且高效地执行，大部分情况下会要求系统进入一个停顿的状态。停顿的目的是终止所有应用程序的执行，只有这样，系统中才不会有新的垃圾产生，同时停顿保证了系统状态在某一个瞬间的一致性，也有益于垃圾回收器更好地标记垃圾对象。因此，在垃圾回收时，都会产生应用程序的停顿。停顿产生时整个应用程序会被暂停，没有任何响应，有点像卡死的感觉，这个停顿称为STW 。
如果Stop-the- World 出现在新生代的Minor GC 中时， 由于新生代的内存空间通常都比较小， 所以暂停时间也在可接受的合理范围之内，不过一旦出现在老年代的Full GC 中时，程序的工作线程被暂停的时间将会更久。简单来说，内存空间越大，执行Full GC 的时间就会越久， 相对的工作线程被暂停的时间也就会更长。

到目前为止，哪怕是G1 也不能完全避免Stop-the-world 情况发生，只能说垃圾回收器越来越优秀，回收效率越来越高， 尽可能地缩短了暂停时间。

#### 补充：垃圾收集器的分类

由于JDK 的版本处于高速迭代过程中，因此Java 发展至今已经衍生了众多的GC 版本。
从不同角度分析垃圾收集器，可以将GC 分为不同的类型。

- 按线程数分，可以分为串行垃圾回收器和并行垃圾回收器。

  ![image-20191031183117417](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-java/images/java12-2.png)

  - 串行回收指的是在同一时间段内只允许一件事情发生，简单来说，当多个CPU 可用时，也只能有一个CPU
    用于执行垃圾回收操作，井且在执行垃圾回收时，程序中的工作线程将会被暂停，当垃圾收集工作完成后
    才会恢复之前被暂停的工作线程，这就是串行回收。
  - 和串行回收相反，并行收集可以运用多个CPU 同时执行垃圾回收，因此提升了应用的吞吐量，不过并行回
    收仍然与串行回收一样，采用独占式，使用了“ Stop-the-world ”机制和复制算法。

- 按照工作模式分，可以分为并发式回收器和独占式垃圾回收器。

  - 并发式垃圾回收器与应用程序线程交替工作，以尽可能减少应用程序的停顿时间。
  - 独占式垃圾回收器（ Stop the world)一旦运行，就停止应用程序中的其他所有线程，直到垃圾回收过程完全结束。

- 按碎片处理方式可分为压缩式垃圾回收器和非压缩式垃圾回收器。

  - 压缩式垃圾回收器会在回收完成后，对存活对象进行压缩整理，消除回收后的碎片。
  - 非压缩式的垃圾回收器不进行这步操作。

- 按工作的内存区间，又可分为年轻代垃圾回收器和老年代垃圾回收器。

#### 补充：如何评估一款GC的性能

-   吞吐量：程序的运行时间（程序的运行时间＋内存回收的时间）。

- 垃圾收集开销：吞吐量的补数，垃圾收集器所占时间与总时间的比例。

- 暂停时间：执行垃圾收集时，程序的工作线程被暂停的时间。

- 收集频率：相对于应用程序的执行，收集操作发生的频率。

- 堆空间： Java 堆区所占的内存大小。

- 快速： 一个对象从诞生到被回收所经历的时间。

需要注意的是， 垃圾收集器中吞吐量和低延迟这两个目标本身是相互矛盾的，因为如果选择以吞吐量优先，那么必然需要降低内存回收的执行频率，但是这样会导致GC 需要更长的暂停时间来执行内存回收。相反的，如果选择以低延迟优先为原则，那么为了降低每次执行内存回收时的暂停时间，也只能频繁地执行内存回收，但这又引起了年轻代内存的缩减和导致程序吞吐量的下降。

#### Shenandoah GC 工作周期如下所示:

![Shenandoah GC 工作周期如下]( https://www.ibm.com/developerworks/cn/java/the-new-features-of-Java-12/image001.png )

上图对应工作周期如下：

> 1. Init Mark 启动并发标记 阶段
> 2. 并发标记遍历堆阶段
> 3. 并发标记完成阶段
> 4. 并发整理回收无活动区域阶段
> 5. 并发 Evacuation 整理内存区域阶段
> 6. Init Update Refs 更新引用初始化 阶段
> 7. 并发更新引用阶段
> 8. Final Update Refs 完成引用更新阶段
> 9. 并发回收无引用区域阶段

需要了解不是唯有 GC 停顿可能导致常规应用程序响应时间比较长。具有较长的 GC 停顿时间会导致系统响应慢的问题，但响应时间慢并非一定是 GC 停顿时间长导致的，队列延迟、网络延迟、其他依赖服务延迟和操作提供调度程序抖动等都可能导致响应变慢。使用 Shenandoah 时需要全面了解系统运行情况，综合分析系统响应时间。各种 GC 工作负载对比如下所示：

#### 各种 GC 工作负载对比
![](https://www.ibm.com/developerworks/cn/java/the-new-features-of-Java-12/image002.png )
   下面推荐几个配置或调试 Shenandoah 的 JVM 参数:

   - `-XX:+AlwaysPreTouch`：使用所有可用的内存分页，减少系统运行停顿，为避免运行时性能损失。
   - `-Xmx == -Xmsv`：设置初始堆大小与最大值一致，可以减轻伸缩堆大小带来的压力，与 `AlwaysPreTouch` 参数配合使用，在启动时提交所有内存，避免在最终使用中出现系统停顿。
   - `-XX:+ UseTransparentHugePages`：能够大大提高大堆的性能，同时建议在 Linux 上使用时将`/sys/kernel/mm/transparent_hugepage/enabled` 和 `/sys/kernel/mm/transparent_hugepage/defragv` 设置为：`madvise`，同时与 `AlwaysPreTouch` 一起使用时，`init` 和 `shutdownv` 速度会更快，因为它将使用更大的页面进行预处理。
   - `-XX:+UseNUMA`：虽然 `Shenandoah` 尚未明确支持 NUMA（Non-Uniform Memory Access），但最好启用此功能以在多插槽主机上启用 NUMA 交错。与 `AlwaysPreTouch` 相结合，它提供了比默认配置更好的性能。
   - `-XX:+DisableExplicitGC`：忽略代码中的 `System.gc()` 调用。当用户在代码中调用 `System.gc()` 时会强制 Shenandoah 执行 STW Full GC ，应禁用它以防止执行此操作，另外还可以使用 `-XX:+ExplicitGCInvokesConcurrent`，在 调用 `System.gc()` 时执行 CMS GC 而不是 Full GC，建议在有 `System.gc()` 调用的情况下使用。

   不过目前 Shenandoah 垃圾回收器还被标记为实验项目，需要使用参数：`- XX:+UnlockExperimentalVMOptions` 启用。更多有关如何配置、调试 Shenandoah 的信息，请参阅 [henandoah wiki](https://wiki.openjdk.java.net/display/shenandoah)。

<p id="Switch">

## Switch 表达式扩展
传统的switch声明语句(switch statement)在使用中有一些问题：
* 匹配是自上而下的，如果忘记写break, 后面的case语句不论匹配与否都会执行；
* 所有的case语句共用一个块范围，在不同的case语句定义的变量名不能重复；
* 不能在一个case里写多个执行结果一致的条件；
* 整个switch不能作为表达式返回值；

Java 12将会对switch声明语句进行扩展，可将其作为增强版的 switch 语句或称为 "switch 表达式"来写出更加简化的代码。
### 预览语言

Switch 表达式也是作为预览语言功能的第一个语言改动被引入新版 Java 中来的，预览语言功能的想法是在 2018 年初被引入 Java 中的，本质上讲，这是一种引入新特性的测试版的方法。通过这种方式，能够根据用户反馈进行升级、更改，在极端情况下，如果没有被很好的接纳，则可以完全删除该功能。预览功能的关键在于它们没有被包含在 Java SE 规范中。

### 使用
扩展的 switch 语句，不仅可以作为语句（statement），还可以作为表达式（expression），并且两种写法都可以使用传统的 switch 语法，或者使用简化的“case L ->”模式匹配语法作用于不同范围并控制执行流。这些更改将简化日常编码工作，并为 switch 中的模式匹配（JEP 305）做好准备。
* 使用 Java 12 中 Switch 表达式的写法，省去了 break 语句，避免了因少写 break 而出错。同时将多个 case 合并到一行，显得简洁、清晰也更加优雅的表达逻辑分支，其具体写法就是将之前的 case 语句表成了：case L ->，即如果条件匹配 case L，则执行标签右侧的代码 ，同时标签右侧的代码段只能是表达式、代码块或throw 语句。
* 为了保持兼容性，case 条件语句中依然可以使用字符 : ，这时 fall-through 规则依然有效的，即不能省略原有的 break 语句，但是同一个 Switch 结构里不能混用 -> 和 : ，否则会有编译错误。并且简化后的 Switch 代码块中定义的局部变量，其作用域就限制在代码块中，而不是蔓延到整Switch 结构，也不用根据不同的判断条件来给变量赋值。
java12之前
```java
public class SwitchTest {
    public static void main(String[] args) {
        int numberOfLetters;
        Fruit fruit = Fruit.APPLE;
        switch (fruit) {
            case PEAR:
                numberOfLetters = 4;
                break;
            case APPLE:
            case GRAPE:
            case MANGO:
                numberOfLetters = 5;
                break;
            case ORANGE:
            case PAPAYA:
                numberOfLetters = 6;
                break;
            default:
                throw new IllegalStateException("No Such Fruit:" + fruit);
        }
        System.out.println(numberOfLetters);
    }
}

enum Fruit {
	PEAR, APPLE, GRAPE, MANGO, ORANGE, PAPAYA;
}
```
如果有编码经验，你一定知道，switch 语句如果漏写了一个 break，那么逻辑往往就跑偏了，这种方式既繁琐，又容易出错。如果换成 switch 表达式，Pattern Matching 机制能够自然地保证只有单一路径会被执行：
java12
```java
public class SwitchTest1 {
    public static void main(String[] args) {
        Fruit fruit = Fruit.GRAPE;
        switch(fruit){
            case PEAR -> System.out.println(4);
            case APPLE,MANGO,GRAPE -> System.out.println(5);
            case ORANGE,PAPAYA -> System.out.println(6);
            default -> throw new IllegalStateException("No Such Fruit:" + fruit);
        };
    }
}
```
更进一步，下面的表达式，为我们提供了优雅地表达特定场合计算逻辑的方式：
```java
public class SwitchTest2 {
    public static void main(String[] args) {
        Fruit fruit = Fruit.GRAPE;
        int numberOfLetters = switch(fruit){
            case PEAR -> 4;
            case APPLE,MANGO,GRAPE -> 5;
            case ORANGE,PAPAYA -> 6;
            default -> throw new IllegalStateException("No Such Fruit:" + fruit);
        };
        System.out.println(numberOfLetters);
    }
}
```
举例2
java12之前：
```java
public class SwitchTest {
    public static void main(String[] args) {
        Week day = Week.FRIDAY;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                break;
            case TUESDAY:
                System.out.println(7);
                break;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                break;
            case WEDNESDAY:
                System.out.println(9);
                break;
            default:
                throw new IllegalStateException("What day is today?" + day);
        }
    }
}
enum Week {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}
```
java12
```java
public class SwitchTest1 {
    public static void main(String[] args) {
        Week day = Week.FRIDAY;
        switch (day) {
            case MONDAY,FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY -> System.out.println(7);
            case THURSDAY, SATURDAY -> System.out.println(8);
            case WEDNESDAY -> System.out.println(9);
            default -> throw new IllegalStateException("What day is today?" + day);
        }
    }
}
```
java12更近一步
```java
public class SwitchTest2 {
    public static void main(String[] args) {
        Week day = Week.FRIDAY;
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalStateException("What day is today?" + day);
        };
    }
}
```

<p id="微基准套件">

## 微基准套件
### 何为JMH?
JMH，即Java Microbenchmark Harness，是专门用于代码微基准测试的工具套件。何谓Micro Benchmark呢？简单的来说就是基于方法层面的基准测试，精度可以达到微秒级。当你定位到热点方法，希望进一步优化方法性能的时候，就可以使用JMH对优化的结果进行量化的分析。
### JMH比较典型的应用场景：
* 想准确的知道某个方法需要执行多长时间，以及执行时间和输入之间的相关性；
* 对比接口不同实现在给定条件下的吞吐量；
* 查看多少百分比的请求在多长时间内完成；
### JMH的使用
要使用JMH，首先需要准备好Maven环境，JMH的源代码以及官方提供的Sample就是使用Maven进行项目管理的，github上也有使用gradle的例子可自行搜索参考。使用mvn命令行创建一个JMH工程：
```java
mvn archetype:generate \
	-DinteractiveMode=false \
	-DarchetypeGroupId=org.openjdk.jmh \
	-DarchetypeArtifactId=jmh-java-benchmark-archetype \
	-DgroupId=co.speedar.infra \
	-DartifactId=jmh-test \
	-Dversion=1.0
```
如果要在现有Maven项目中使用JMH，只需要把生成出来的两个依赖以及shade插件拷贝到项目的pom中即可：
```maven
        <dependency>
            <groupId>org.openjdk.jmh</groupId>
            <artifactId>jmh-core</artifactId>
            <version>0.7.1</version>
        </dependency>
        <dependency>
            <groupId>org.openjdk.jmh</groupId>
            <artifactId>jmh-generator-annprocess</artifactId>
            <version>0.7.1</version>
            <scope>provided</scope>
        </dependency>
        ...
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>2.0</version>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals>
                        <goal>shade</goal>
                    </goals>
                    <configuration>
                        <finalName>microbenchmarks</finalName>
                        <transformers>
                            <transformer
                                    implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                <mainClass>org.openjdk.jmh.Main</mainClass>
                            </transformer>
                        </transformers>
                    </configuration>
                </execution>
            </executions>
        </plugin>
```
### 新特性的说明
Java 12 中添加一套新的基本的微基准测试套件（microbenchmarks suite），此功能为JDK源代码添加了一套微基准测试（大约100个），简化了现有微基准测试的运行和新基准测试的创建过程。使开发人员可以轻松运行现有的微基准测试并创建新的基准测试，其目标在于提供一个稳定且优化过的基准。 它基于Java Microbenchmark Harness（JMH），可以轻松测试JDK性能，支持JMH更新。

微基准套件与 JDK 源代码位于同一个目录中，并且在构建后将生成单个 jar 文件。但它是一个单独的项目，在支持构建期间不会执行，以方便开发人员和其他对构建微基准套件不感兴趣的人在构建时花费比较少的构建时间。

要构建微基准套件，用户需要运行命令：make build-microbenchmark， 类似的命令还有：make test TEST="micro:java.lang.invoke" 将使用默认设置运行 java.lang.invoke 相关的微基准测试。

<p id="jvm">

## 引入 JVM 常量 API
Java 12 中引入 JVM 常量 API，用来更容易地对关键类文件 (key class-file) 和运行时构件（artefact）的名义描述(nominal description) 进行建模，特别是对那些从常量池加载的常量，这是一项非常技术性的变化，能够以更简单、标准的方式处理可加载常量。
具体来说就是java.base模块新增了java.lang.constant包（而非 java.lang.invoke.constant ）。包中定义了一系列基于值的符号引用（JVMS 5.1）类型，它们能够描述每种可加载常量。
> 官方api链接地址：
http://cr.openjdk.java.net/~iris/se/12/latestSpec/api/java.base/java/lang/constant/pack
age-summary.html

> Java SE > Java SE Specifications > Java Virtual Machine Specification下的第5章：
Chapter 5. Loading, Linking, and Initializing
https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-5.html

引入了ConstantDesc接口( ClassDesc、MethodTypeDesc、MethodHandleDesc这几个接口直接继承了ConstantDesc接口)以及Constable接口；ConstantDesc接口定义了resolveConstantDesc方法，Constable接口定义了describeConstable方法；String、Integer、Long、Float、Double均实现了这两个接口，而EnumDesc实现了ConstantDesc接口。

![image-20191031183927168](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-java/images/java12-1.png)

符号引用以纯 nominal 形式描述可加载常量，与类加载或可访问性上下文区分开。有些类可以作为自己的符号引用（例如 String）。而对于可链接常量，另外定义了一系列符号引用类型，具体包括： ClassDesc (Class 的可加载常量标称描述符) ，MethodTypeDesc(方法类型常量标称描述符) ，MethodHandleDesc (方法句柄常量标称描述符) 和DynamicConstantDesc (动态常量标称描述符) ，它们包含描述这些常量的 nominal 信息。此 API 对于操作类和方法的工具很有帮助。

#### String 实现了 Constable 接口：
```java
public final class String implements java.io.Serializable, Comparable<String>,
CharSequence,Constable, ConstantDesc {
```
java.lang.constant.Constable接口定义了抽象方法：
```java
public interface Constable {
	Optional<? extends ConstantDesc> describeConstable();
}
```
Java 12 String 的实现源码：
```java
@Override
public Optional<String> describeConstable() {
	return Optional.of(this);
}
```
很简单，其实就是调用 Optional.of 方法返回一个 Optional 类型，Optional不懂的可以参考Java 8的新特性
#### String#describeConstable和resolveConstantDesc
一个非常有趣的方法来自新引入的接口java.lang.constant.Constable - 它用于标记constable类型，这意味着这类型的值是常量，可以在JVMS 4.4常量池中定义。
> Java SE > Java SE Specifications > Java Virtual Machine Specification下的第4章：
Chapter 4. The class File Format
https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html

String的源码：
```java
/**
* Returns an {@link Optional} containing the nominal descriptor for this
* instance, which is the instance itself.
*
* @return an {@link Optional} describing the {@linkplain String} instance
* @since 12
*/
@Override
public Optional<String> describeConstable() {
    return Optional.of(this);
}
/**
* Resolves this instance as a {@link ConstantDesc}, the result of which is
* the instance itself.
*
* @param lookup ignored
* @return the {@linkplain String} instance
* @since 12
*/
@Override
public String resolveConstantDesc(MethodHandles.Lookup lookup) {
    return this;
}
```
举例：
```java
private static void testDescribeConstable() {
	System.out.println("======test java 12 describeConstable======");
	String name = "hello world!";
	Optional<String> optional = name.describeConstable();
	System.out.println(optional.get());
}
```
结果输出：
```java
======test java 12 describeConstable======
hello world!
```

<p id="AArch64">

## 改进 AArch64 实现

### 现状
当前 Java 11 及之前版本JDK中存在两个64位ARM端口。这些文件的主要来源位于src/hotspot/cpu/arm 和open/src/hotspot/cpu/aarch64 目录中。尽管两个端口都产生了aarch64 实现，我们将前者（由Oracle贡献）称为arm64 ，将后者称为aarch64 。
### 新特性
Java 12 中将删除由 Oracle 提供的 arm64端口相关的所有源码，即删除目录open/src/hotspot/cpu/arm 中关于64-bit 的这套实现，只保留其中有关 32-bit ARM端口的实现，余下目录的 open/src/hotspot/cpu/aarch64 代码部分就成了 AArch64 的默认实现。
### 目的
这将使开发贡献者将他们的精力集中在单个 64 位 ARM 实现上，并消除维护两套实现所需的重复工作。


<p id="CDS">

## 默认类数据共享（CDS）存档
### 概述
我们知道在同一个物理机／虚拟机上启动多个JVM时，如果每个虚拟机都单独装载自己需要的所有类，启动成本和内存占用是比较高的。所以Java团队引入了类数据共享机制 (Class Data Sharing ，简称 CDS) 的概念，通过把一些核心类在每个JVM间共享，每个JVM只需要装载自己的应用类即可。好处是：启动时间减少了，另外核心类是共享的，所以JVM的内存占用也减少了。
### 历史版本
* JDK5引入了Class-Data Sharing可以用于多个JVM共享class，提升启动速度，最早只支持system classes及serial GC。
* JDK9对其进行扩展以支持application classes及其他GC算法。
* java10的新特性JEP 310: Application Class-Data Sharing扩展了JDK5引入的Class-Data Sharing，支持application的Class-Data Sharing并开源出来(以前是commercial feature)
  * CDS 只能作用于 BootClassLoader 加载的类，不能作用于 AppClassLoader 或者自定义的 ClassLoader加载的类。在 Java 10 中，则将 CDS 扩展为 AppCDS，顾名思义，AppCDS 不止能够作用于BootClassLoader了，AppClassLoader 和自定义的 ClassLoader 也都能够起作用，大大加大了 CDS 的适用范围。也就说开发自定义的类也可以装载给多个JVM共享了。
* JDK11将-Xshare:off改为默认-Xshare:auto，以更加方便使用CDS特性 
### 迭代效果
可以说，自 Java 8 以来，在基本 CDS 功能上进行了许多增强、改进，启用 CDS 后应用的启动时间和内存占用量显着减少。使用 Java 11 早期版本在 64 位 Linux 平台上运行 HelloWorld 进行测试，测试结果显示启动时间缩短有 32％，同时在其他 64 位平台上，也有类似或更高的启动性能提升。
### Java12新特性
JDK 12之前，想要利用CDS的用户，即使仅使用JDK中提供的默认类列表，也必须java -Xshare:dump 作为额外的步骤来运行。

Java 12 针对 64 位平台下的 JDK 构建过程进行了增强改进，使其默认生成类数据共享（CDS）归档，以进一步达到改进应用程序的启动时间的目的，同时也避免了需要手动运行：java -Xshare:dump 的需要，修改后的 JDK 将在${JAVA_HOME}/lib/server 目录中生成一份名为classes.jsa的默认archive文件(大概有18M)方便大家使用。

当然如果需要，也可以添加其他 GC 参数，来调整堆大小等，以获得更优的内存分布情况，同时用户也可以像之前一样创建自定义的 CDS 存档文件。

<p id="G1">

## 可中止的G1 Mixed GC
简言之，当 G1 垃圾回收器的回收超过暂停时间的目标，则能中止垃圾回收过程。
G1是一个垃圾收集器，设计用于具有大量内存的多处理器机器。由于它提高了性能效率，G1垃圾收集器最终将取代CMS垃圾收集器。

该垃圾收集器设计的主要目标之一是满足用户设置的预期的 JVM 停顿时间。

G1 采用一个高级分析引擎来选择在收集期间要处理的工作量，此选择过程的结果是一组称为 GC 回收集（collectionset( CSet )）的区域。一旦收集器确定了 GC 回收集 并且 GC 回收、整理工作已经开始，这个过程是without stopping的，即 G1 收集器必须完成收集集合的所有区域中的所有活动对象之后才能停止；但是如果收集器选择过大的 GC 回收集，此时的STW时间会过长超出目标pause time。

这种情况在mixed collections时候比较明显。这个特性启动了一个机制，当选择了一个比较大的collection set，Java 12 中将把 GC 回收集（混合收集集合）拆分为mandatory（必需或强制）及optional两部分( 当完成mandatory的部分，如果还有剩余时间则会去处理optional部分)来将mixed collections从without stopping变为abortable，以更好满足指定pause time的目标。

* 其中必需处理的部分包括 G1 垃圾收集器不能递增处理的 GC 回收集的部分（如：年轻代），同时也可以包含老年代以提高处理效率。
* 将 GC 回收集拆分为必需和可选部分时，垃圾收集过程优先处理必需部分。同时，需要为可选 GC 回收集部分维护一些其他数据，这会产生轻微的 CPU 开销，但小于 1 ％的变化，同时在 G1 回收器处理 GC 回收集期间，本机内存使用率也可能会增加，使用上述情况只适用于包含可选 GC 回收部分的 GC 混合回收集合。
* 在 G1 垃圾回收器完成收集需要必需回收的部分之后，如果还有时间的话，便开始收集可选的部分。但是粗粒度
的处理，可选部分的处理粒度取决于剩余的时间，一次只能处理可选部分的一个子集区域。在完成可选收集部分的收集后，G1 垃圾回收器可以根据剩余时间决定是否停止收集。如果在处理完必需处理的部分后，剩余时间不足，总时间花销接近预期时间，G1 垃圾回收器也可以中止可选部分的回收以达到满足预期停顿时间的目标。

<p id="G11">

## G1及时返回未使用的已分配内存
### 概述
上面介绍了 Java 12 中增强了 G1 垃圾收集器关于混合收集集合的处理策略，这节主要介绍在 Java 12 中同时也对 G1垃圾回收器进行了改进，使其能够在空闲时自动将 Java 堆内存返还给操作系统，这也是 Java 12 中的另外一项重大改进。

目前 Java 11 版本中包含的 G1 垃圾收集器暂时无法及时将已提交的 Java 堆内存返回给操作系统。为什么呢？ G1目前只有在full GC或者concurrent cycle（并发处理周期）的时候才会归还内存，由于这两个场景都是G1极力避免的，因此在大多数场景下可能不会及时归还committed Java heap memory给操作系统。除非有外部强制执行。

在使用云平台的容器环境中，这种不利之处特别明显。即使在虚拟机不活动，但如果仍然使用其分配的内存资源，哪怕是其中的一小部分，G1 回收器也仍将保留所有已分配的 Java 堆内存。而这将导致用户需要始终为所有资源付费，哪怕是实际并未用到，而云提供商也无法充分利用其硬件。如果在此期间虚拟机能够检测到 Java 堆内存的实际使用情况，并在利用空闲时间自动将 Java 堆内存返还，则两者都将受益。
### 具体操作
为了尽可能的向操作系统返回空闲内存，G1 垃圾收集器将在应用程序不活动期间定期生成或持续循环检查整体 Java堆使用情况，以便 G1 垃圾收集器能够更及时的将 Java 堆中不使用内存部分返还给操作系统。对于长时间处于空闲状态的应用程序，此项改进将使 JVM 的内存利用率更加高效。

而在用户控制下，可以可选地执行Full GC，以使返回的内存量最大化。

JDK12的这个特性新增了两个参数分别是G1 PeriodicGCInterval及G1 PeriodicGCSystemLoadThreshold，设置为0的话，表示禁用。如果应用程序为非活动状态，在下面两种情况任何一个描述下，G1 回收器会触发定期垃圾收集：

* 自上次垃圾回收完成以来已超过 G1PeriodicGCInterval ( milliseconds )， 并且此时没有正在进行的垃圾回收任务。如果 G1PeriodicGCInterval 值为零表示禁用快速回收内存的定期垃圾收集。
* 应用所在主机系统上执行方法 getloadavg()，默认一分钟内系统返回的平均负载值低于G1PeriodicGCSystemLoadThreshold指定的阈值，则触发full GC或者concurrent GC( 如果开启
G1PeriodicGCInvokesConcurrent )，GC之后Java heap size会被重写调整，然后多余的内存将会归还给操作系统。如果 G1PeriodicGCSystemLoadThreshold 值为零，则此条件不生效。
如果不满足上述条件中的任何一个，则取消当期的定期垃圾回收。等一个 G1PeriodicGCInterval 时间周期后，将重新考虑是否执行定期垃圾回收。

G1 定期垃圾收集的类型根据 G1PeriodicGCInvokesConcurrent 参数的值确定：如果设置值了，G1 垃圾回收器将继续上一个或者启动一个新并发周期；如果没有设置值，则 G1 回收器将执行一个Full GC。在每次一次 GC 回收末尾，G1 回收器将调整当前的 Java 堆大小，此时便有可能会将未使用内存返还给操作系统。新的 Java 堆内存大小根据现有配置确定，具体包括下列配置：- XX:MinHeapFreeRatio、-XX:MaxHeapFreeRatio、-Xms、-Xmx。

默认情况下，G1 回收器在定期垃圾回收期间新启动或继续上一轮并发周期，将最大限度地减少应用程序的中断。如果定期垃圾收集严重影响程序执行，则需要考虑整个系统 CPU 负载，或让用户禁用定期垃圾收集。

<p id="other">

## 其他特性

### 支持unicode 11
>JDK 12版本包括对Unicode 11.0.0的支持。在发布支持Unicode 10.0.0的JDK 11之后，Unicode 11.0.0引
入了以下JDK 12中包含的新功能：
	684 new characters
	11 new blocks
	7 new scripts.
其中：
	684个新字符，包含以下重要内容：
	66个表情符号字符（66 emoji characters）
	Copyleft符号（Copyleft symbol）
评级系统的半星（Half stars for rating systems）
额外的占星符号（Additional astrological symbols）
象棋中国象棋符号（Xiangqi Chinese chess symbols）
7个新脚本：
	Hanifi Rohingya
	Old Sogdian
	Sogdian
	Dogra
	Gunjala Gondi
	Makasar
	Medefaidrin
11个新块，包括上面列出的新脚本的7个块和以下现有脚本的4个块：
	格鲁吉亚扩展（Georgian Extended）
	玛雅数字（Mayan Numerals）
	印度Siyaq数字（Indic Siyaq Numbers）
	国际象棋符号（Chess Symbols）
### 支持压缩数字格式化
NumberFormat 添加了对以紧凑形式格式化数字的支持。紧凑数字格式是指以简短或人类可读形式表示的数字。例如，在en_US语言环境中，1000可以格式化为“1K”，1000000可以格式化为“1M”，具体取决于指定的样式NumberFormat.Style。
```java
@Test
public void testCompactNumberFormat(){
    var cnf = NumberFormat.getCompactNumberInstance(Locale.CHINA,
                                                    NumberFormat.Style.SHORT);
    System.out.println(cnf.format(1_0000));
    System.out.println(cnf.format(1_9200));
    System.out.println(cnf.format(1_000_000));
    System.out.println(cnf.format(1L << 30));
    System.out.println(cnf.format(1L << 40));
    System.out.println(cnf.format(1L << 50));
}
```
输出
```java
1万
2万
100万
11亿
1兆
1126兆
```
### String新增方法
#### String#transform(Function)
JDK-8203442引入的一个小方法，它提供的函数作为输入提供给特定的String实例，并返回该函数返回的输出。
```java
var result = "foo".transform(input -> input + " bar");
System.out.println(result); // foo bar
```
或者
```java
var result = "foo"
    .transform(input -> input + " bar")
    .transform(String::toUpperCase)
    System.out.println(result); // FOO BAR
```

对应源码
```java
/**
* This method allows the application of a function to {@code this}
* string. The function should expect a single String argument
* and produce an {@code R} result.
* <p>
* Any exception thrown by {@code f()} will be propagated to the
* caller.
*
* @param f functional interface to a apply
*
* @param <R> class of the result
*
* @return the result of applying the function to this string
*
* @see java.util.function.Function
*
* @since 12
*/
public <R> R transform(Function<? super String, ? extends R> f) {
    return f.apply(this);
}
```
传入一个函数式接口 Function，接受一个值，返回一个值，参考：Java 8 新特性之函数式接口。
在某种情况下，该方法应该被称为map()。
举例：
```java
private static void testTransform() {
    System.out.println("======test java 12 transform======");
    List<String> list1 = List.of("Java", " Python", " C++ ");
    List<String> list2 = new ArrayList<>();
    list1.forEach(element -> list2.add(element.transform(String::strip)
                                       .transform(String::toUpperCase)
                                       .transform((e) -> "Hi," + e))
                 );
    list2.forEach(System.out::println);
}
```
结果输出
```java
======test java 12 transform======
    Hi,JAVA
    Hi,PYTHON
    Hi,C++
```
示例是对一个字符串连续转换了三遍，代码很简单。如果使用Java 8的Stream特性，可以如下实现：
```java
private static void testTransform1() {
    System.out.println("======test before java 12 ======");
    List<String> list1 = List.of("Java ", " Python", " C++ ");
    Stream<String> stringStream = list1.stream().map(element ->
                                                     element.strip()).map(String::toUpperCase).map(element -> "Hello," + element);
    List<String> list2 = stringStream.collect(Collectors.toList());
    list2.forEach(System.out::println);
}
```
#### String#indent
该方法允许我们调整String实例的缩进。
举例：
```java
private static void testIndent() {
    System.out.println("======test java 12 indent======");
    String result = "Java\n Python\nC++".indent(3);
    System.out.println(result);
}
```
结果输出：
```java
======test java 12 indent======
Java
	Python
C++
```
换行符 \n 后向前缩进 n 个空格，为 0 或负数不缩进。
以下是 indent 的核心源码：
```java
/**
* Adjusts the indentation of each line of this string based on the value of
* {@code n}, and normalizes line termination characters.
* <p>
* This string is conceptually separated into lines using
* {@link String#lines()}. Each line is then adjusted as described below
* and then suffixed with a line feed {@code "\n"} (U+000A). The resulting
* lines are then concatenated and returned.
* ...略...
*
* @since 12
*/
public String indent(int n) {
    if (isEmpty()) {
        return "";
    }
    Stream<String> stream = lines();
    if (n > 0) {
        final String spaces = " ".repeat(n);
        stream = stream.map(s -> spaces + s);
    } else if (n == Integer.MIN_VALUE) {
        stream = stream.map(s -> s.stripLeading());
    } else if (n < 0) {
        stream = stream.map(s -> s.substring(Math.min(-n,
                                                      s.indexOfNonWhitespace())));
    }
    return stream.collect(Collectors.joining("\n", "", "\n"));
}
```
其实就是调用了 lines() 方法来创建一个 Stream，然后再往前拼接指定数量的空格。

#### Files新增mismatch方法
```java
@Test
public void testFilesMismatch() throws IOException {
    FileWriter fileWriter = new FileWriter("tmp\\a.txt");
    fileWriter.write("a");
    fileWriter.write("b");
    fileWriter.write("c");
    fileWriter.close();
    FileWriter fileWriterB = new FileWriter("tmp\\b.txt");
    fileWriterB.write("a");
    fileWriterB.write("1");
    fileWriterB.write("c");
    fileWriterB.close();
    System.out.println(Files.mismatch(Path.of("tmp/a.txt"),Path.of("tmp/b.txt")));
}
```
#### 其他
* Collectors新增teeing方法用于聚合两个downstream的结果
* CompletionStage新增exceptionallyAsync、exceptionallyComposeAsync方法，允许方法体在异步线程执行，同时新增了exceptionallyCompose方法支持在exceptionally的时候构建新的CompletionStage。
* ZGC: Concurrent Class Unloading
  * ZGC在JDK11的时候还不支持class unloading，JDK12对ZGC支持了Concurrent Class Unloading，默认是开启，使用-XX:-ClassUnloading可以禁用
* 新增-XX:+ExtensiveErrorReports
  * -XX:+ExtensiveErrorReports可以用于在jvm crash的时候收集更多的报告信息到hs_err.log文件中，product builds中默认是关闭的，要开启的话，需要自己添加-XX:+ExtensiveErrorReports参数
* 新增安全相关的改进
  * 支持java.security.manager系统属性，当设置为disallow的时候，则不使用SecurityManager以提升性能，如果此时调用System.setSecurityManager则会抛出UnsupportedOperationExceptionkeytool新增-groupname选项允许在生成key pair的时候指定一个named group新增PKCS12 KeyStore配置属性用于自定义PKCS12 keystores的生成Java Flight Recorder新增了security-related的event支持ChaCha20 and Poly1305 TLS Cipher Suites

#### 移除项
- 移除com.sun.awt.SecurityWarnin；
- 移除FileInputStream、FileOutputStream、- Java.util.ZipFile/Inflator/Deflator的finalize方法；
- 移除GTE CyberTrust Global Root；
- 移除javac的-source, -target对6及1.6的支持，同时移除--release选项；

#### 废弃项
- 废弃的API列表见deprecated-list
- 废弃-XX:+/-MonitorInUseLists选项
- 废弃Default Keytool的-keyalg值











