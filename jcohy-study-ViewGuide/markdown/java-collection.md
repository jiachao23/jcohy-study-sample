
#  Java
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## java集合相关面试题
> * [java集合框架](#collection-1)
> * [java的线程安全](#collection-2)
> * [List、Map、Set三个接口存取元素时，各有什么特点？](#collection-3)
> * [ArrayList、LinkedList、Vector的区别](#collection-4)
> * [Map集合](#collection-5)
> * [为什么使用ConcurrentHashMap而不是HashMap或Hashtable？](#collection-6)
> * [Collection 和 Collections的区别？](#collection-7)
> * [Map、Set、List、Queue、Stack的特点与用法](#collection-8)
> * [HashMap的工作原理](#collection-9)
> * [Map的实现类的介绍](#collection-10)
> * [LinkedList 和 PriorityQueue 的区别？](#collection-11)
> * [BlockingQueue](#collection-12)
> * [如何对一组对象进行排序](#collection-13)
> * [HashMap和Hashtable的区别？](#collection-14)
> * [TreeMap和TreeSet在排序时如何比较元素？Collections工具类中的sort()方法如何比较元素？](#collection-15)


<p id="collection-1">

####  java集合框架(常用)


```
Collection - List - ArrayList
Collection - List - LinkedList
Collection - List - Vector
Collection - List - Vector - Stack
Collection - Set - HashSet
Collection - Set - TreeSet
Collection - List - LinkedHashSet
Map - HashMap
Map - TreeMap
Map - HashTable
Map - LinkedHashMap
Map - ConcurrentHashMap
```

<p id="collection-2">

#### java的线程安全

Vector、Stack、HashTable、ConcurrentHashMap、Properties

<p id="collection-3">

#### List、Map、Set三个接口存取元素时，各有什么特点？

List以特定索引来存取元素，可以有重复元素。

Set不能存放重复元素（用对象的equals()方法来区分元素是否重复）。

Map保存键值对（key-value pair）映射，映射关系可以是一对一或多对一。

Set和Map容器都有基于哈希存储和排序树的两种实现版本，基于哈希存储的版本理论存取时间复杂度为O(1)，而基于排序树版本的实现在插入或删除元素时会按照元素或元素的键（key）构成排序树从而达到排序和去重的效果。

<p id="collection-4">

####  ArrayList、LinkedList、Vector的区别

首先它们均是List接口的实现。

ArrayList、LinkedList的区别：

> 1.随机存取：ArrayList是基于可变大小的数组实现，LinkedList是链接列表的实现。这也就决定了对于随机访问的get和set的操作，ArrayList要优于LinkedList，因为LinkedList要移动指针。
> 2.插入和删除：LinkedList要好一些，因为ArrayList要移动数据，更新索引。
> 3.内存消耗：LinkedList需要更多的内存，因为需要维护指向后继结点的指针。

Vector属于遗留容器（Java早期的版本中提供的容器，除此之外，Hashtable、Dictionary、BitSet、Stack、Properties都是遗留容器），已经不推荐使用，但是由于ArrayList和LinkedListed都是非线程安全的，如果遇到多个线程操作同一个容器的场景，则可以通过工具类Collections中的synchronizedList方法将其转换成线程安全的容器后再使用（这是对装饰模式的应用，将已有对象传入另一个类的构造器中创建新的对象来增强实现）。
补充：遗留容器中的Properties类和Stack类在设计上有严重的问题，Properties是一个键和值都是字符串的特殊的键值对映射，在设计上应该是关联一个Hashtable并将其两个泛型参数设置为String类型，但是Java API中的Properties直接继承了Hashtable，这很明显是对继承的滥用。这里复用代码的方式应该是Has-A关系而不是Is-A关系，另一方面容器都属于工具类，继承工具类本身就是一个错误的做法，使用工具类最好的方式是Has-A关系（关联）或Use-A关系（依赖）。同理，Stack类继承Vector也是不正确的。Sun公司的工程师们也会犯这种低级错误，让人唏嘘不已。

<p id="collection-5">

#### Map集合

- Hashtable:基于Dictionary类，线程安全，速度快。底层是哈希表数据结构。是同步的。

  不允许null作为键，null作为值。

- Properties:Hashtable的子类。用于配置文件的定义和操作，使用频率非常高，同时键和值都是字符串。


- HashMap：线程不安全，底层是数组加链表实现的哈希表。允许null作为键，null作为值。HashMap去掉了contains方法。

  注意：HashMap不保证元素的迭代顺序。如果需要元素存取有序，请使用LinkedHashMap

- TreeMap：可以用来对Map集合中的键进行排序。


- ConcurrentHashMap:是JUC包下的一个并发集合。


<p id="collection-6">

#### 为什么使用ConcurrentHashMap而不是HashMap或Hashtable？

HashMap的缺点：主要是多线程同时put时，如果同时触发了rehash操作，会导致HashMap中的链表中出现循环节点，进而使得后面get的时候，会死循环，CPU达到100%，所以在并发情况下不能使用HashMap。让HashMap同步：Map m = Collections.synchronizeMap(hashMap);而Hashtable虽然是同步的，使用synchronized来保证线程安全，但在线程竞争激烈的情况下HashTable的效率非常低下。因为当一个线程访问HashTable的同步方法时，其他线程访问HashTable的同步方法时，可能会进入阻塞或轮询状态。如线程1使用put进行添加元素，线程2不但不能使用put方法添加元素，并且也不能使用get方法来获取元素，所以竞争越激烈效率越低。 

ConcurrentHashMap的原理：

HashTable容器在竞争激烈的并发环境下表现出效率低下的原因在于所有访问HashTable的线程都必须竞争同一把锁，那假如容器里有多把锁，每一把锁用于锁容器其中一部分数据，那么当多线程访问容器里不同数据段的数据时，线程间就不会存在锁竞争，从而可以有效的提高并发访问效率，这就是ConcurrentHashMap所使用的锁分段技术，首先将数据分成一段一段的存储，然后给每一段数据配一把锁，当一个线程占用锁访问其中一个段数据的时候，其他段的数据也能被其他线程访问。

ConcurrentHashMap的结构：

ConcurrentHashMap是由Segment数组结构和HashEntry数组结构组成。Segment是一种可重入互斥锁ReentrantLock，在ConcurrentHashMap里扮演锁的角色，HashEntry则用于存储键值对数据。一个ConcurrentHashMap里包含一个Segment数组，Segment的结构和HashMap类似，是一种数组和链表结构， 一个Segment里包含一个HashEntry数组，每个HashEntry是一个链表结构的元素，当对某个HashEntry数组的数据进行修改时，必须首先获得它对应的Segment锁。

ConcurrentHashMap的构造、get、put操作：

构造函数：传入参数分别为 

1、初始容量，默认16

 2、装载因子 装载因子用于rehash的判定，就是当ConcurrentHashMap中的元素大于装载因子*最大容量时进行扩容，默认0.75 

3、并发级别 这个值用来确定Segment的个数，Segment的个数是大于等于concurrencyLevel的第一个2的n次方的数。比如，如果concurrencyLevel为12，13，14，15，16这些数，则Segment的数目为16(2的4次方)。默认值为static final int DEFAULT_CONCURRENCY_LEVEL = 16;。理想情况下ConcurrentHashMap的真正的并发访问量能够达到concurrencyLevel，因为有concurrencyLevel个Segment，假如有concurrencyLevel个线程需要访问Map，并且需要访问的数据都恰好分别落在不同的Segment中，则这些线程能够无竞争地自由访问（因为他们不需要竞争同一把锁），达到同时访问的效果。这也是为什么这个参数起名为“并发级别”的原因。默认16.

初始化的一些动作：

初始化segments数组（根据并发级别得到数组大小ssize），默认16

初始化segmentShift和segmentMask（这两个全局变量在定位segment时的哈希算法里需要使用），默认情况下segmentShift为28，segmentMask为15

初始化每个Segment，这一步会确定Segment里HashEntry数组的长度.

put操作：

1、判断value是否为null，如果为null，直接抛出异常。

2、key通过一次hash运算得到一个hash值。将得到hash值向右按位移动segmentShift位，然后再与segmentMask做&运算得到segment的索引j。即segmentFor方法

3、使用Unsafe的方式从Segment数组中获取该索引对应的Segment对象。向这个Segment对象中put值，这个put操作也基本是一样的步骤（通过&运算获取HashEntry的索引，然后set）。

get操作：

1、和put操作一样，先通过key进行hash确定应该去哪个Segment中取数据。

2、使用Unsafe获取对应的Segment，然后再进行一次&运算得到HashEntry链表的位置，然后从链表头开始遍历整个链表（因为Hash可能会有碰撞，所以用一个链表保存），如果找到对应的key，则返回对应的value值，如果链表遍历完都没有找到对应的key，则说明Map中不包含该key，返回null。

定位Segment的hash算法：(hash >>> segmentShift) & segmentMask

定位HashEntry所使用的hash算法：int index = hash & (tab.length - 1);

注：

1\.tab为HashEntry数组

2\.ConcurrentHashMap既不允许null key也不允许null value

<p id="collection-7">

####  Collection 和 Collections的区别

Collection是集合类的上级接口，子接口主要有Set 和List、Queue
Collections是针对集合类的一个辅助类，提供了操作集合的工具方法：一系列静态方法实现对各种集合的搜索、排序、线程安全化等操作。

<p id="collection-8">

####  Map、Set、List、Queue、Stack的特点与用法

Set集合类似于一个罐子，"丢进"Set集合里的多个对象之间没有明显的顺序。 List集合代表元素有序、可重复的集合，集合中每个元素都有其对应的顺序索引。 Stack是Vector提供的一个子类，用于模拟"栈"这种数据结构(LIFO后进先出) Queue用于模拟"队列"这种数据结构(先进先出 FIFO)。 Map用于保存具有"映射关系"的数据，因此Map集合里保存着两组值。

<p id="collection-9">

####  HashMap的工作原理

HashMap维护了一个Entry数组，Entry内部类有key,value，hash和next四个字段，其中next也是一个Entry类型。可以将Entry数组理解为一个个的散列桶。每一个桶实际上是一个单链表。当执行put操作时，会根据key的hashcode定位到相应的桶。遍历单链表检查该key是否已经存在，如果存在，覆盖该value，反之，新建一个新的Entry，并放在单链表的头部。当通过传递key调用get方法时，它再次使用key.hashCode()来找到相应的散列桶，然后使用key.equals()方法找出单链表中正确的Entry，然后返回它的值。

关于HashMap[的源码分析请参考](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-java/markdown/HashMap.md)

<p id="collection-10">

####  Map的实现类的介绍

HashMap基于散列表来的实现，即使用hashCode()进行快速查询元素的位置，显著提高性能。插入和查询“键值对”的开销是固定的。可以通过设置容量和装载因子，以调整容器的性能。

- LinkedHashMap, 类似于HashMap,但是迭代遍历它时，保证迭代的顺序是其插入的次序，因为它使用链表维护内部次序。此外可以在构造器中设定LinkedHashMap，使之采用LRU算法。使没有被访问过的元素或较少访问的元素出现在前面，访问过的或访问多的出现在后面。这对于需要定期清理元素以节省空间的程序员来说，此功能使得程序员很容易得以实现。


- TreeMap, 是基于红黑树的实现。同时TreeMap实现了SortedMap接口，该接口可以确保键处于排序状态。所以查看“键”和“键值对”时，所有得到的结果都是经过排序的，次序由自然排序或提供的Comparator决定。SortedMap接口拥有其他额外的功能，如：返回当前Map使用的Comparator比较强，firstKey()，lastKey(),headMap(toKey),tailMap(fromKey)以及可以返回一个子树的subMap()方法等。


- WeakHashMap，表示弱键映射，WeakHashMap 的工作与正常的 HashMap 类似，但是使用弱引用作为 key，意思就是当 key 对象没有任何引用时，key/value 将会被回收。


- ConcurrentHashMap， 在HashMap基础上分段锁机制实现的线程安全的HashMap。


- IdentityHashMap 使用==代替equals() 对“键”进行比较的散列映射。专为解决特殊问题而设计。


- HashTable：基于Dictionary类的Map接口的实现，它是线程安全的。


<p id="collection-11">

####  LinkedList 和 PriorityQueue 的区别

它们均是Queue接口的实现。拥有FIFO的特点，它们的区别在于排序行为。LinkedList支持双向列表操作，
PriorityQueue 按优先级组织的队列，元素的出队次序由元素的自然排序或者由Comparator比较器指定。

<p id="collection-12">

####  BlockingQueue

Java.util.concurrent.BlockingQueue是一个队列，在进行获取元素时，它会等待队列变为非空；当在添加一个元素时，它会等待队列中的可用空间。BlockingQueue接口是Java集合框架的一部分，主要用于实现生产者-消费者模式。我们不需要担心等待生产者有可用的空间，或消费者有可用的对象，因为它都在BlockingQueue的实现类中被处理了。Java提供了集中BlockingQueue的实现，比如ArrayBlockingQueue、LinkedBlockingQueue、PriorityBlockingQueue,、SynchronousQueue等。

<p id="collection-13">

####  如何对一组对象进行排序

如果需要对一个对象数组进行排序，我们可以使用Arrays.sort()方法。如果我们需要排序一个对象列表，我们可以使用Collections.sort()方法。排序时是默认根据元素的自然排序（使用Comparable）或使用Comparator外部比较器。Collections内部使用数组排序方法，所有它们两者都有相同的性能，只是Collections需要花时间将列表转换为数组。

<p id="collection-14">

#### HashMap和Hashtable的区别

- Hashtable是基于陈旧的Dictionary的Map接口的实现，而HashMap是基于哈希表的Map接口的实现
- 从方法上看，HashMap去掉了Hashtable的contains方法
- HashTable是同步的(线程安全)，而HashMap线程不安全，效率上HashMap更快
- HashMap允许空键值，而Hashtable不允许
- HashMap的iterator迭代器执行快速失败机制，也就是说在迭代过程中修改集合结构，除非调用迭代器自身的remove方法，否则以其他任何方式的修改都将抛出并发修改异常。而Hashtable返回的Enumeration不是快速失败的。

注：Fast-fail机制:在使用迭代器的过程中有其它线程修改了集合对象结构或元素数量,都将抛出ConcurrentModifiedException，但是抛出这个异常是不保证的，我们不能编写依赖于此异常的程序。

<p id="collection-15">

####  TreeMap和TreeSet在排序时如何比较元素？Collections工具类中的sort()方法如何比较元素？

TreeSet要求存放的对象所属的类必须实现Comparable接口，该接口提供了比较元素的compareTo()方法，当插入元素时会回调该方法比较元素的大小。TreeMap要求存放的键值对映射的键必须实现Comparable接口从而根据键对元素进行排序。Collections工具类的sort方法有两种重载的形式，第一种要求传入的待排序容器中存放的对象比较实现Comparable接口以实现元素的比较；第二种不强制性的要求容器中的元素必须可比较，但是要求传入第二个参数，参数是Comparator接口的子类型（需要重写compare方法实现元素的比较），相当于一个临时定义的排序规则，其实就是通过接口注入比较元素大小的算法，也是对回调模式的应用（Java中对函数式编程的支持）。
例子1：

```java
public class Student implements Comparable<Student> {
    private String name; // 姓名
    private int age; // 年龄
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
    	return "Student [name=" + name + ", age=" + age + "]";
    }
    
    @Override
    public int compareTo(Student o) {
    	return this.age - o.age; // 比较年龄(年龄的升序)
    }
}



import java.util.Set;
import java.util.TreeSet;
class Test01 {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>(); // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        set.add(new Student("Hao LUO", 33));
        set.add(new Student("XJ WANG", 32));
        set.add(new Student("Bruce LEE", 60));
        set.add(new Student("Bob YANG", 22));
        for(Student stu : set) {
            System.out.println(stu);
        }
        // 输出结果:
        // Student [name=Bob YANG, age=22]
        // Student [name=XJ WANG, age=32]
        // Student [name=Hao LUO, age=33]
        // Student [name=Bruce LEE, age=60]
    }
}
```
例子2：
```java
public class Student {
    private String name; // 姓名
    private int age; // 年龄
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /**
* 获取学生姓名
*/
    public String getName() {
        return name;
    }
    /**
* 获取学生年龄
*/
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Test02 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(); // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        list.add(new Student("Hao LUO", 33));
        list.add(new Student("XJ WANG", 32));
        list.add(new Student("Bruce LEE", 60));
        list.add(new Student("Bob YANG", 22));
        // 通过sort方法的第二个参数传入一个Comparator接口对象
        // 相当于是传入一个比较对象大小的算法到sort方法中
        // 由于Java中没有函数指针、仿函数、委托这样的概念
        // 因此要将一个算法传入一个方法中唯一的选择就是通过接口回调
        Collections.sort(list, new Comparator<Student> () {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName()); // 比较学生姓名
            }
        });
        for(Student stu : list) {
            System.out.println(stu);
        }
        // 输出结果:
        // Student [name=Bob YANG, age=22]
        // Student [name=Bruce LEE, age=60]
        // Student [name=Hao LUO, age=33]
        // Student [name=XJ WANG, age=32]
    }
}

```
