
#  Java
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## HashSet
> * [概述](#gaishu)
> * [HashSet的实现](#sg)
> * [Q&A](#qa)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;HashSet 实现 Set 接口，由哈希表（实际上是一个 HashMap 实例）支持。它不保证 set 的
迭代顺序；特别是它不保证该顺序恒久不变。此类允许使用 null 元素。



<p id="sg">

##  HashSet的实现

>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;对于 HashSet 而言，它是基于 HashMap 实现的，HashSet 底层使用 HashMap 来保存
所有元素，因此 HashSet 的实现比较简单，相关 HashSet 的操作，基本上都是直接调用底
层 HashMap 的相关方法来完成， HashSet 的源代码如下：

                public class HashSet<E>
                    extends AbstractSet<E>
                    implements Set<E>, Cloneable, java.io.Serializable
                {
                    static final long serialVersionUID = -5024744406713321676L;
                    
                    // 底层使用 HashMap 来保存 HashSet 中所有元素
                    private transient HashMap<E,Object> map;
                
                    // 定义一个虚拟的 Object 对象作为 HashMap 的 value，将此对象定义为 static final。
                    private static final Object PRESENT = new Object();
                
                    /**
                      * 默认的无参构造器，构造一个空的 HashSet。
                      *
                      * 实际底层会初始化一个空的 HashMap，并使用默认初始容量为 16 和加载因子 0.75。
                      */
                    public HashSet() {
                        map = new HashMap<>();
                    }
                
                   /**
                     * 构造一个包含指定 collection 中的元素的新 set。
                     *
                     * 实际底层使用默认的加载因子 0.75 和足以包含指定
                     * collection 中所有元素的初始容量来创建一个 HashMap。
                     * @param c 其中的元素将存放在此 set 中的 collection。
                     */
                    public HashSet(Collection<? extends E> c) {
                        map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
                        addAll(c);
                    }
                
                    /**
                     * 以指定的 initialCapacity 和 loadFactor 构造一个空的 HashSet。
                     * 实际底层以相应的参数构造一个空的 HashMap。
                     *
                     */
                    public HashSet(int initialCapacity, float loadFactor) {
                        map = new HashMap<>(initialCapacity, loadFactor);
                    }
                
                    /**
                     * 以指定的 initialCapacity 构造一个空的 HashSet。
                     *  实际底层以相应的参数及加载因子 loadFactor 为 0.75 构造一个空的 HashMap。
                     *
                     * @param      initialCapacity   初始容量
                     * @throws     IllegalArgumentException if the initial capacity is less
                     *             than zero
                     */
                    public HashSet(int initialCapacity) {
                        map = new HashMap<>(initialCapacity);
                    }
                
                    /**
                     * 以指定的 initialCapacity 和 loadFactor 构造一个新的空链接哈希集合。
                     * 此构造函数为包访问权限，不对外公开，实际只是是对 LinkedHashSet 的支持。
                     * 实际底层会以指定的参数构造一个空 LinkedHashMap 实例来实现。
                     * 
                     *
                     * @param initialCapacity 初始容量。
                     * @param loadFactor 加载因子
                     * @param dummy 标记。
                     *  
                       */
                    HashSet(int initialCapacity, float loadFactor, boolean dummy) {
                        map = new LinkedHashMap<>(initialCapacity, loadFactor);
                    }
                
                    /**
                     * 返回对此 set 中元素进行迭代的迭代器。返回元素的顺序并不是特定的。
                     * 
                     *
                     * 底层实际调用底层 HashMap 的 keySet 来返回所有的 key。
                     *  value 使用一个 static final 的 Object 对象标识。
                     * @return 对此 set 中元素进行迭代的 Iterator。
                     */
                    public Iterator<E> iterator() {
                        return map.keySet().iterator();
                    }
                
                    /**
                     * 返回此 set 中的元素的数量（set 的容量）。
                     *  底层实际调用 HashMap 的 size()方法返回 Entry 的数量，就得到该 Set 中元素的个数。
                     *  @return 此 set 中的元素的数量（set 的容量）。
                     */
                    public int size() {
                        return map.size();
                    }
                
                    /**
                     *  如果此 set 不包含任何元素，则返回 true。
                     *
                     * 底层实际调用 HashMap 的 isEmpty()判断该 HashSet 是否为空。
                     */
                    public boolean isEmpty() {
                        return map.isEmpty();
                    }
                
                    /**
                     * 如果此 set 包含指定元素，则返回 true。
                     * 更确切地讲，当且仅当此 set 包含一个满足(o==null ? e==null : o.equals(e))
                     * 的 e 元素时，返回 true。
                     * 底层实际调用 HashMap 的 containsKey 判断是否包含指定 key。
                     *
                     * @param o o 在此 set 中的存在已得到测试的元素。
                     * @return 如果此 set 包含指定元素，则返回 true。
                     */
                    public boolean contains(Object o) {
                        return map.containsKey(o);
                    }
                
                   /**
                     * 如果此 set 中尚未包含指定元素，则添加指定元素。
                     * 更确切地讲，如果此 set 没有包含满足(e==null ? e2==null : e.equals(e2))
                     * 的元素 e2，则向此 set 添加指定的元素 e。
                     * 如果此 set 已包含该元素，则该调用不更改 set 并返回 false。
                     * 底层实际将将该元素作为 key 放入 HashMap。
                     * 由于 HashMap 的 put()方法添加 key-value 对时，当新放入 HashMap 的 Entry 中 key
                     * 与集合中原有 Entry 的 key 相同（hashCode()返回值相等，通过 equals 比较也返回true），
                     * 新添加的 Entry 的 value 会将覆盖原来 Entry 的 value，但 key 不会有任何改变，
                     * 因此如果向 HashSet 中添加一个已经存在的元素时，新添加的集合元素将不会被放入HashMap中，
                     * 原来的元素也不会有任何改变，这也就满足了 Set 中元素不重复的特性。
                     * @param e 将添加到此 set 中的元素。
                     * @return 如果此 set 尚未包含指定元素，则返回 true。
                     */
                    public boolean add(E e) {
                        return map.put(e, PRESENT)==null;
                    }
                    
                    
                   /**
                     * 如果指定元素存在于此 set 中，则将其移除。
                     * 更确切地讲，如果此 set 包含一个满足(o==null ? e==null : o.equals(e))的元素e，
                     * 则将其移除。如果此 set 已包含该元素，则返回 true
                     * （或者：如果此 set 因调用而发生更改，则返回 true）。（一旦调用返回，则此 set 不再包含该元素）。
                     * 底层实际调用 HashMap 的 remove 方法删除指定 Entry。
                     * @param o 如果存在于此 set 中则需要将其移除的对象。
                     * @return 如果 set 包含指定元素，则返回 true。
                     */
                    public boolean remove(Object o) {
                        return map.remove(o)==PRESENT;
                    }
                
                    /**
                     * 从此 set 中移除所有元素。此调用返回后，该 set 将为空。
                     * 底层实际调用 HashMap 的 clear 方法清空 Entry 中所有元素。
                     */
                    public void clear() {
                        map.clear();
                    }
                
                    /**
                     * 返回此 HashSet 实例的浅表副本：并没有复制这些元素本身。
                     * 底层实际调用 HashMap 的 clone()方法，获取 HashMap 的浅表副本，并设置到 HashSet 中。
                     *
                     * @return a shallow copy of this set
                     */
                    @SuppressWarnings("unchecked")
                    public Object clone() {
                        try {
                            HashSet<E> newSet = (HashSet<E>) super.clone();
                            newSet.map = (HashMap<E, Object>) map.clone();
                            return newSet;
                        } catch (CloneNotSupportedException e) {
                            throw new InternalError(e);
                        }
                    }
                
                    /**
                     * Save the state of this <tt>HashSet</tt> instance to a stream (that is,
                     * serialize it).
                     *
                     * @serialData The capacity of the backing <tt>HashMap</tt> instance
                     *             (int), and its load factor (float) are emitted, followed by
                     *             the size of the set (the number of elements it contains)
                     *             (int), followed by all of its elements (each an Object) in
                     *             no particular order.
                     */
                    private void writeObject(java.io.ObjectOutputStream s)
                        throws java.io.IOException {
                        // Write out any hidden serialization magic
                        s.defaultWriteObject();
                
                        // Write out HashMap capacity and load factor
                        s.writeInt(map.capacity());
                        s.writeFloat(map.loadFactor());
                
                        // Write out size
                        s.writeInt(map.size());
                
                        // Write out all elements in the proper order.
                        for (E e : map.keySet())
                            s.writeObject(e);
                    }
                
                    /**
                     * Reconstitute the <tt>HashSet</tt> instance from a stream (that is,
                     * deserialize it).
                     */
                    private void readObject(java.io.ObjectInputStream s)
                        throws java.io.IOException, ClassNotFoundException {
                        // Read in any hidden serialization magic
                        s.defaultReadObject();
                
                        // Read capacity and verify non-negative.
                        int capacity = s.readInt();
                        if (capacity < 0) {
                            throw new InvalidObjectException("Illegal capacity: " +
                                                             capacity);
                        }
                
                        // Read load factor and verify positive and non NaN.
                        float loadFactor = s.readFloat();
                        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
                            throw new InvalidObjectException("Illegal load factor: " +
                                                             loadFactor);
                        }
                
                        // Read size and verify non-negative.
                        int size = s.readInt();
                        if (size < 0) {
                            throw new InvalidObjectException("Illegal size: " +
                                                             size);
                        }
                
                        // Set the capacity according to the size and load factor ensuring that
                        // the HashMap is at least 25% full but clamping to maximum capacity.
                        capacity = (int) Math.min(size * Math.min(1 / loadFactor, 4.0f),
                                HashMap.MAXIMUM_CAPACITY);
                
                        // Create backing HashMap
                        map = (((HashSet<?>)this) instanceof LinkedHashSet ?
                               new LinkedHashMap<E,Object>(capacity, loadFactor) :
                               new HashMap<E,Object>(capacity, loadFactor));
                
                        // Read in all elements in the proper order.
                        for (int i=0; i<size; i++) {
                            @SuppressWarnings("unchecked")
                                E e = (E) s.readObject();
                            map.put(e, PRESENT);
                        }
                    }
                
                    /**
                     * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
                     * and <em>fail-fast</em> {@link Spliterator} over the elements in this
                     * set.
                     *
                     * <p>The {@code Spliterator} reports {@link Spliterator#SIZED} and
                     * {@link Spliterator#DISTINCT}.  Overriding implementations should document
                     * the reporting of additional characteristic values.
                     *
                     * @return a {@code Spliterator} over the elements in this set
                     * @since 1.8
                     */
                    public Spliterator<E> spliterator() {
                        return new HashMap.KeySpliterator<E,Object>(map, 0, -1, 0, 0);
                    }
                }



> *  #### 相关 HashMap 的实现原理，请参考另一篇：[Java集合之HashMap](https://github.com/jiachao23/StudyNote/blob/master/src/java/HashMap.md)的实现原理。
> *  #### 对于 HashSet 中保存的对象，请注意正确重写其equals和hashCode方法，以保证放入的对象的唯一性.

         




<p id="qa">

##  Q&A



<p id="kuozhan">

##  扩展


    
    
