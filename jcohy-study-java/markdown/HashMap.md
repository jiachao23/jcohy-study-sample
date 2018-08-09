
#  Java
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## HashMap
> * [概述](#gaishu)
> * [HashMap的数据结构](#shuju)
> * [HashMap的存取实现](#sg)
> * [HashMap的resize（rehash）](#size)
> * [HashMap的性能参数](#xingneng)
> * [Fail-Fast机制](#fail)
> * [Q&A](#qa)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述
>   &nbsp;&nbsp;&nbsp;&nbsp;HashMap是基于哈希表的Map 接口的非同步实现。此实现提供所有可选的映射操作，
>   并允许使用null值和null键。此类不保证映射的顺序，特别是它不保证该顺序恒久不变。



<p id="shuju">

## HashMap的数据结构

>  &nbsp;&nbsp;&nbsp;&nbsp;在java 编程语言中，最基本的结构就是两种，一个是数组，另外一个是模拟指针（引用），所有的数据结构都可以用这两个基本结构来构造的，HashMap 也不例外。</br>

>  &nbsp;&nbsp;&nbsp;&nbsp;HashMap实际上是一个“链表散列”的数据结构，即数组和链表的结合体。
![hashmap](https://github.com/jiachao23/StudyNote/blob/master/src/img/hashmap.png)

>  &nbsp;&nbsp;&nbsp;&nbsp;从上图中可以看出，HashMap 底层就是一个数组结构，数组中的每一项又是一个链表。当新建一个HashMap 的时候，就会初始化一个数组。

我们来看看HashMap的源码。java代码：

        /**
         * The table, resized as necessary. Length MUST Always be a power of two.
         */
                transient Entry[] table;
               
                static class Entry<K,V> implements Map.Entry<K,V> {
                    final K key;
                    V value;
                    Entry<K,V> next;
                    final int hash;
                    ……
                 }


<p id="sg">

##  HashMap的存取实现

####  我们从HasmMap的源码来分析HashMap的存取。

>  * ### 存储

                public V put(K key, V value) {
                
                // HashMap 允许存放null 键和null 值。
                // 当key 为null 时，调用putForNullKey 方法，将value 放置在数组第一个位置。
                
                    if (key == null)
                            return putForNullKey(value);
                            
                    // 根据key 的keyCode 重新计算hash 值。
                    int hash = hash(key.hashCode());
                
                    // 搜索指定hash 值在对应table 中的索引。
                   int i = indexFor(hash, table.length);
                   
                    // 如果 i 索引处的 Entry 不为 null，通过循环不断遍历 e 元素的下一个元素。
                    for (Entry<K,V> e = table[i]; e != null; e = e.next) {
                            Object k;
                            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                                V oldValue = e.value;
                                e.value = value;
                                e.recordAccess(this);
                            return oldValue;
                            }
                    }
                 // 如果i 索引处的Entry 为null，表明此处还没有Entry。
                    modCount++;
                    
                     // 将key、value 添加到i 索引处。
                     addEntry(hash, key, value, i);
                     return null;
                 }
                
                
                void addEntry(int hash, K key, V value, int bucketIndex) {
                
                    // 获取指定 bucketIndex 索引处的 Entry
                    Entry<K,V> e = table[bucketIndex];
                    // 将新创建的 Entry 放入 bucketIndex 索引处，并让新的 Entry 指向原来的 Entry
                    table[bucketIndex] = new Entry<K,V>(hash, key, value, e);
                    // 如果 Map 中的 key-value 对的数量超过了极限
                    if (size++ >= threshold)
                    // 把 table 对象的长度扩充到原来的2 倍。
                    resize(2 * table.length);
                 }
                 
                 
                 
                 
>  &nbsp;&nbsp;&nbsp;&nbsp;从上面的源代码中可以看出：当我们往HashMap 中put 元素的时候，先根据key 的
>  hashCode 重新计算hash 值，根据hash 值得到这个元素在数组中的位置（即下标）。</br>

>  如果数组该位置上已经存放有其他元素了，那么在这个位置上的元素将以链表的形式存放，新
>  加入的放在链头，最先加入的放在链尾。如果数组该位置上没有元素，就直接将该元素放到
>  此数组中的该位置上。</br>addEntry(hash, key, value, i)方法根据计算出的hash 值，将key-value 对放在数组table
>  的i 索引处。addEntry 是 HashMap 提供的一个包访问权限的方法.</br>

>  &nbsp;&nbsp;&nbsp;&nbsp;当系统决定存储HashMap 中的key-value 对时，完全没有考虑Entry 中的value，仅仅只是根据key 来计算并决定每个Entry 的存储位置。我们完全可以把 Map 集合中的 value 当
>  成 key 的附属，当系统决定了 key 的存储位置之后，value 随之保存在那里即可。

                   static int hash(int h) {
                         h ^= (h >>> 20) ^ (h >>> 12);
                         return h ^ (h >>> 7) ^ (h >>> 4);
                   }
                         
>  &nbsp;&nbsp;&nbsp;&nbsp;hash(int h)方法根据key 的hashCode 重新计算一次散列。此算法加入了高位计算，防
>  止低位不变，高位变化时，造成的hash 冲突。</br>

>  &nbsp;&nbsp;&nbsp;&nbsp;我们可以看到在HashMap 中要找到某个元素，需要根据key 的hash 值来求得对应数
>  组中的位置。如何计算这个位置就是hash 算法。前面说过HashMap 的数据结构是数组和
>  链表的结合，所以我们当然希望这个HashMap 里面的 元素位置尽量的分布均匀些，尽量
>  使得每个位置上的元素数量只有一个，那么当我们用hash 算法求得这个位置的时候，马上
>  就可以知道对应位置的元素就是我们要的，而不用再去遍历链表，这样就大大优化了查询的效率。</br>
>  对于任意给定的对象，只要它的 hashCode() 返回值相同，那么程序调用 hash(int h) 方
>  法所计算得到的 hash 码值总是相同的。我们首先想到的就是把hash 值对数组长度取模运
>  算，这样一来，元素的分布相对来说是比较均匀的。但是，“模”运算的消耗还是比较大的，
>  在HashMap 中是这样做的：调用 indexFor(int h, int length) 方法来计算该对象应该保存
>  在 table 数组的哪个索引处。indexFor(int h, int length) 方法的代码如下：
        
                static int indexFor(int h, int length) {
                        return h & (length-1);
                 }
                 
>  &nbsp;&nbsp;&nbsp;&nbsp;这个方法非常巧妙，它通过 h & (table.length -1) 来得到该对象的保存位，而HashMap
>  底层数组的长度总是 2 的 n 次方，这是HashMap 在速度上的优化。在 HashMap 构造器中
>  有如下代码：
        
                int capacity = 1;
                    while (capacity < initialCapacity)
                    capacity <<= 1;
>  &nbsp;&nbsp;&nbsp;&nbsp;这段代码保证初始化时HashMap 的容量总是2 的n 次方，即底层数组的长度总是为2
>  的n 次方。当length 总是 2 的n 次方时，h& (length-1)运算等价于对length 取模，也就是
>  h%length，但是&比%具有更高的效率。
>  这看上去很简单，其实比较有玄机的，我们举个例子来说明：
>  假设数组长度分别为15 和16，优化后的hash 码分别为8 和9，那么&运算后的结果如下：

>  ![hashmap](https://github.com/jiachao23/StudyNote/blob/master/src/img/hashmap2.png)

>  &nbsp;&nbsp;&nbsp;&nbsp;从上面的例子中可以看出：当它们和15-1（1110）“与”的时候，产生了相同的结果，
>  也就是说它们会定位到数组中的同一个位置上去，这就产生了碰撞，8 和9 会被放到数组中
>  的同一个位置上形成链表，那么查询的时候就需要遍历这个链 表，得到8 或者9，这样就
>  降低了查询的效率。同时，我们也可以发现，当数组长度为15 的时候，hash 值会与15-1
>  （1110）进行“与”，那么 最后一位永远是0，而0001，0011，0101，1001，1011，0111，
>  1101 这几个位置永远都不能存放元素了，空间浪费相当大，更糟的是这种情况中，数组可
>  以使用的位置比数组长度小了很多，这意味着进一步增加了碰撞的几率，减慢了查询的效率！
>  而当数组长度为16 时，即为2 的n 次方时，2n-1 得到的二进制数的每个位上的值都为1，
>  这使得在低位上&时，得到的和原hash 的低位相同，加之hash(int h)方法对key 的hashCode
>  的进一步优化，加入了高位计算，就使得只有相同的hash 值的两个值才会被放到数组中的
>  同一个位置上形成链表。所以说，当数组长度为2 的n 次幂的时候，不同的key 算得得index
>  相同的几率较小，那么数据在数组上分布就比较均匀，也就是说碰撞的几率小，相对的，查
>  询的时候就不用遍历某个位置上的链表，这样查询效率也就较高了。</br>

>  &nbsp;&nbsp;&nbsp;&nbsp;根据上面 put 方法的源代码可以看出，当程序试图将一个key-value 对放入HashMap
>  中时，程序首先根据该 key 的 hashCode() 返回值决定该 Entry 的存储位置：如果两
>  个 Entry 的 key 的 hashCode() 返回值相同，那它们的存储位置相同。如果这两
>  个 Entry 的 key 通过 equals 比较返回 true，新添加 Entry 的 value 将覆盖集合中原
>  有 Entry 的 value，但key 不会覆盖。如果这两个 Entry 的 key 通过 equals 比较返回 false，
>  新添加的 Entry 将与集合中原有 Entry 形成 Entry 链，而且新添加的 Entry 位于 Entry 链的
>  头部——具体说明继续看 addEntry() 方法的说明。
>  *  ###  读取

### Java 代码:

                public V get(Object key) {
                    if (key == null)
                        return getForNullKey();
                    int hash = hash(key.hashCode());
                    for (Entry<K,V> e = table[indexFor(hash, table.length)];
                        e != null;
                        e = e.next) {
                        Object k;
                    if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
                        1return e.value;
                     }
                     return null;
                }


>  有了上面存储时的hash 算法作为基础，理解起来这段代码就很容易了。从上面的源代
>  码中可以看出：从HashMap 中get 元素时，首先计算key 的hashCode，找到数组中对应
>  位置的某一元素，然后通过key 的equals 方法在对应位置的链表中找到需要的元素。</br>
>  归纳起来简单地说，HashMap 在底层将 key-value 当成一个整体进行处理，这个整体
>  就是一个 Entry 对象。HashMap 底层采用一个 Entry[] 数组来保存所有的 key-value 对，当
>  需要存储一个 Entry 对象时，会根据hash 算法来决定其在数组中的存储位置，在根据equals
>  方法决定其在该数组位置上的链表中的存储位置；当需要取出一个Entry 时，也会根据hash
>  算法找到其在数组中的存储位置，再根据equals 方法从该位置上的链表中取出该Entry

<p id="size">

## HashMap的resize（rehash）

>  &nbsp;&nbsp;&nbsp;&nbsp;当HashMap 中的元素越来越多的时候，hash 冲突的几率也就越来越高，因为数组的
>  长度是固定的。所以为了提高查询的效率，就要对HashMap 的数组进行扩容，数组扩容这
>  个操作也会出现在ArrayList 中，这是一个常用的操作，而在HashMap 数组扩容之后，最      
>  消耗性能的点就出现了：原数组中的数据必须重新计算其在新数组中的位置，并放进去，这
>  就是resize。</br>
>  &nbsp;&nbsp;&nbsp;&nbsp;那么HashMap 什么时候进行扩容呢？当HashMap 中的元素个数超过数组大小
>  *loadFactor 时，就会进行数组扩容，loadFactor 的默认值为0.75，这是一个折中的取值。
>  也就是说，默认情况下，数组大小为16，那么当HashMap 中元素个数超过16*0.75=12 的
>  时候，就把数组的大小扩展为 2*16=32，即扩大一倍，然后重新计算每个元素在数组中的位
>  置，而这是一个非常消耗性能的操作，所以如果我们已经预知HashMap 中元素的个数，那
>  么预设元素的个数能够有效的提高HashMap 的性能。

         
<p id="xingneng">

##  HashMap的性能参数

####  HashMap 包含如下几个构造器：
>  *  HashMap()：构建一个初始容量为 16，负载因子为 0.75 的 HashMap。</br>
>  *  HashMap(int initialCapacity)：构建一个初始容量为 initialCapacity，负载因子为 0.75 的 HashMap。</br>
>  *  HashMap(int initialCapacity, float loadFactor)：以指定初始容量、指定的负载因子创建一个 HashMap。</br>

>  &nbsp;&nbsp;&nbsp;&nbsp;HashMap 的基础构造器HashMap(int initialCapacity, float loadFactor)带有两个参数，它们是初始容量initialCapacity 和加载因子loadFactor。</br>
>  &nbsp;&nbsp;&nbsp;&nbsp;initialCapacity：HashMap 的最大容量，即为底层数组的长度。</br>
>  &nbsp;&nbsp;&nbsp;&nbsp;loadFactor：负载因子loadFactor 定义为：散列表的实际元素数目(n)/ 散列表的容量(m)。</br>
>  负载因子衡量的是一个散列表的空间的使用程度，负载因子越大表示散列表的装填程度越
>  高，反之愈小。对于使用链表法的散列表来说，查找一个元素的平均时间是O(1+a)，因此
>  如果负载因子越大，对空间的利用更充分，然而后果是查找效率的降低；如果负载因子太小，
>  那么散列表的数据将过于稀疏，对空间造成严重浪费。</br>
>  &nbsp;&nbsp;&nbsp;&nbsp;HashMap 的实现中，通过threshold 字段来判断HashMap 的最大容量：

             Java 代码
             threshold = (int)(capacity * loadFactor);
         
>  结合负载因子的定义公式可知，threshold 就是在此loadFactor 和capacity 对应下允许的
>  最大元素数目，超过这个数目就重新resize，以降低实际的负载因子。默认的的负载因子
>  0.75是对空间和时间效率的一个平衡选择。当容量超出此最大容量时， resize后的HashMap
>  容量是容量的两倍：

            Java 代码
            if (size++ >= threshold)
                resize(2 * table.length);
       
<p id="fail">
        
##  Fail-Fast机制

>  &nbsp;&nbsp;&nbsp;&nbsp;我们知道java.util.HashMap 不是线程安全的，因此如果在使用迭代器的过程中有其他线程修改了map，那么将抛出ConcurrentModificationException，这就是所谓fail-fast 策略。</br>
>  &nbsp;&nbsp;&nbsp;&nbsp;这一策略在源码中的实现是通过modCount 域，modCount 顾名思义就是修改次数，对HashMap 内容的修改都将增加这个值，那么在迭代器初始化过程中会将这个值赋给迭代器的expectedModCount。
           
            Java 代码:
                HashIterator() {
                    expectedModCount = modCount;
                    if (size > 0) { // advance to first entry
                            Entry[] t = table;
                    while (index < t.length && (next = t[index++]) == null);
                    }
                }
                
>  &nbsp;&nbsp;&nbsp;&nbsp;在迭代过程中，判断modCount 跟expectedModCount 是否相等，如果不相等就表示已经有其他线程修改了Map：注意到modCount 声明为volatile，保证线程之间修改的可见性。
           
            Java 代码
                final Entry<K,V> nextEntry() {
                    if (modCount != expectedModCount)
                        throw new ConcurrentModificationException();
>  &nbsp;&nbsp;&nbsp;&nbsp;在HashMap 的API 中指出：
>  由所有HashMap 类的“collection 视图方法”所返回的迭代器都是快速失败的：在迭代器
>  创建之后，如果从结构上对映射进行修改，除非通过迭代器本身的 remove 方法，其他任何
>  时间任何方式的修改，迭代器都将抛出 ConcurrentModificationException。因此，面对并发
>  的修改，迭代器很快就会完全失败，而不冒在将来不确定的时间发生任意不确定行为的风险。
>  #### 注意，迭代器的快速失败行为不能得到保证，一般来说，存在非同步的并发修改时，不可能作出任何坚决的保证。快速失败迭代器尽最大努力抛出 ConcurrentModificationException。因此，编写依赖于此异常的程序的做法是错误的，正确做法是：迭代器的快速失败行为应该仅用于检测程序错误。


<p id="qa">

##  Q&A

>  *  例子一</br>
>  &nbsp;&nbsp; Q:当两个对象的hashcode相同会发生什么？</br>
>  &nbsp;&nbsp; A:因为hashcode相同，所以它们的bucket位置相同，‘碰撞’会发生。因为HashMap使用链表存储对象，这个Entry(包含有键值对的Map.Entry对象)会存储在链表中。</br>
>  *  例子二</br>
>  &nbsp;&nbsp; Q:如果两个键的hashcode相同，你如何获取值对象？</br>
>  &nbsp;&nbsp; A:当我们调用get()方法，HashMap会使用键对象的hashcode找到bucket位置，找到bucket位置之后，会调用keys.equals()方法去找到链表中正确的节点，最终找到要找的值对象。</br>
>  *  例子三</br>
>  &nbsp;&nbsp; Q:重新调整HashMap大小存在什么问题吗？</br>
>  &nbsp;&nbsp; A:可能产生条件竞争(race condition)。因为如果两个线程都发现HashMap需要重新调整大小了，它们会同时试着调整大小。在调整大小的过程中，存储在链表中的元素的次序会反过来，因为移动到新的bucket位置的时候，HashMap并不会将元素放在链表的尾部，而是放在头部，这是为了避免尾部遍历(tail traversing)。如果条件竞争发生了，那么就死循环了。</br>
>  *  例子四</br>
>  &nbsp;&nbsp; Q:为什么String, Interger这样的wrapper类适合作为键？</br>
>  &nbsp;&nbsp; A:因为String是不可变的，也是final的，而且已经重写了equals()和hashCode()方法了。其他的wrapper类也有这个特点。不可变性是必要的，因为为了要计算hashCode()，就要防止键值改变，如果键值在放入时和获取时返回不同的hashcode的话，那么就不能从HashMap中找到你想要的对象。不可变性还有其他的优点如线程安全。</br>


<p id="kuozhan">

##  扩展

>  *  ConcurrentHashMap。

    
    
