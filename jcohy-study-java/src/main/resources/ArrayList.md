
#  Java
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## ArrayList
> * [概述](#gaishu)
> * [ArrayList的实现](#shixian)
>    *  [存储](#set)
>    *  [读取](#get)
>    *  [删除](#remove)
>    *  [调整数组容量](#resize)
>    *  [Fail-Fast机制](#fail)
> * [Q&A](#qa)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述

>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ArrayList是List接口的可变数组的实现。实现了所有可选列表操作，并允许包括 
>  null 在内的所有元素。除了实现 List 接口外，此类还提供一些方法来操作内部用来存储列表的数组的大小。</br>
>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每个 ArrayList 实例都有一个容量，该容量是指用来存储列表元素的数组的大小。它总是至少等于列表的大小。随着向 ArrayList 中不断添加元素，
>  其容量也自动增长。自动增长会带来数据向新数组的重新拷贝，因此，如果可预知数据量的多少，可在构造 ArrayList 时指定其容量。在添加大量元素前，
>  应用程序也可以使用 ensureCapacity 操作来增加 ArrayList实例的容量，这可以减少递增式再分配的数量。</br>
>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>注意，此实现不是同步的。如果多个线程同时访问一个 ArrayList 实例，而其中至少一个线程从结构上修改了列表，那么它必须保持外部同步。</strong>

<p id="shixian">

## 代理模式的实现

>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对于 ArrayList 而言，它实现 List 接口、底层使用数组保存所有元素。其操作基本上是对数组的操作。下面我们来分析 ArrayList 的源代码
   
                    底层使用数组实现  
                    private transient Object[] elementData;
>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ArrayList 提供了三种方式的构造器，可以构造一个默认初始容量为 10 的空列表、构造
   一个指定初始容量的空列表以及构造一个包含指定 collection 的元素的列表，这些元素按照
   该 collection 的迭代器返回它们的顺序排列的。
   
   
                     public ArrayList() {
                        this(10);
                     }
                
                     public ArrayList(int initialCapacity) {
                        super();
                            if (initialCapacity < 0)
                                throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
                        this.elementData = new Object[initialCapacity];
                     }
               
                     public ArrayList(Collection<? extends E> c) {
                        elementData = c.toArray();
                        size = elementData.length;
                        // c.toArray might (incorrectly) not return Object[] (see 6260652)
                            if (elementData.getClass() != Object[].class)
                                elementData = Arrays.copyOf(elementData, size, Object[].class);
                 }
                  
<p id="set">

#### 存储

>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ArrayList 提供了五种添加元素的方法。
>  *  set(int index, E element)

                 // 用指定的元素替代此列表中指定位置上的元素，并返回以前位于该位置上的元素。
                     public E set(int index, E element) {
                        RangeCheck(index);
                        E oldValue = (E) elementData[index];
                        elementData[index] = element;
                        return oldValue;
                     }
        
>  *  add(E e)

               // 将指定的元素添加到此列表的尾部。
                   public boolean add(E e) {
                       ensureCapacity(size + 1);
                       elementData[size++] = e;
                       return true;
                   }
         
>  *  add(int index, E element)

              // 将指定的元素插入此列表中的指定位置。
              // 如果当前位置有元素，则向右移动当前位于该位置的元素以及所有后续元素（将其索引加 1）。
                    public void add(int index, E element) {
                        if (index > size || index < 0)
                            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
              // 如果数组长度不足，将进行扩容。
                        ensureCapacity(size+1); // Increments modCount!!
                        
              // 将 elementData 中从 Index 位置开始、长度为 size-index 的元素，
              // 拷贝到从下标为 index+1 位置开始的新的 elementData 数组中。
              // 即将当前位于该位置的元素以及所有后续元素右移一个位置。
                    System.arraycopy(elementData, index, elementData, index + 1, size - index);
                    elementData[index] = element;
                     size++;
             }
 
                 
>  *  addAll(Collection<? extends E> c)

             // 按照指定 collection 的迭代器所返回的元素顺序，将该 collection 中的所有元素添加到此列表的尾部。
                    public boolean addAll(Collection<? extends E> c) {
                        Object[] a = c.toArray();
                        int numNew = a.length;
                        ensureCapacity(size + numNew); // Increments modCount
                        System.arraycopy(a, 0, elementData, size, numNew);
                        size += numNew;
                        return numNew != 0;
                    }
                    
>  *  addAll(int index, Collection<? extends E> c)

             // 从指定的位置开始，将指定 collection 中的所有元素插入到此列表中。
                    public boolean addAll(int index, Collection<? extends E> c) {
                        if (index > size || index < 0)
                            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
                        Object[] a = c.toArray();
                        int numNew = a.length;
                        ensureCapacity(size + numNew); // Increments modCount
                        int numMoved = size - index;
                        if (numMoved > 0)
                        System.arraycopy(elementData, index, elementData, index + numNew, numMoved);
                        System.arraycopy(a, 0, elementData, index, numNew);
                        size += numNew;
                        return numNew != 0;
                    }

<p id="get">

####  读取

                     // 返回此列表中指定位置上的元素。
                    public E get(int index) {
                           RangeCheck(index);
                        return (E) elementData[index];
                    }

<p id="remove">

#### 删除

>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ArrayList 提供了两种删除元素的方法。
>  *  remove(int index)
        
                    public E remove(int index) {
                        RangeCheck(index);
                        modCount++;
                        E oldValue = (E) elementData[index];
                        int numMoved = size - index - 1;
                        if (numMoved > 0)
                            System.arraycopy(elementData, index+1, elementData, index, numMoved);
                        elementData[--size] = null; // Let gc do its work
                        return oldValue;
                    }
>  *  remove(Object o)

                    public boolean remove(Object o) {
                        // 由于 ArrayList 中允许存放 null，因此下面通过两种情况来分别处理。
                        if (o == null) {
                            for (int index = 0; index < size; index++)
                                if (elementData[index] == null) {
                                    // 类似 remove(int index)，移除列表中指定位置上的元素。
                                    fastRemove(index);
                                    return true;
                                }
                        } else {
                            for (int index = 0; index < size; index++)
                                if (o.equals(elementData[index])) {
                                    fastRemove(index);
                                    return true;
                                }
                        }
                      return false;
                    }
>  ###  注意：从数组中移除元素的操作，也会导致被移除的元素以后的所有元素的向左移动一个位置。

<p id="resize">

####  调整数组容量

>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;从上面介绍的向 ArrayList 中存储元素的代码中，我们看到，每当向数组中添加元素时，
>  都要去检查添加后元素的个数是否会超出当前数组的长度，如果超出，数组将会进行扩容，
>  以满足添加数据的需求。数组扩容通过一个公开的方法 ensureCapacity(int minCapacity)来
>  实现。在实际添加大量元素前，我也可以使用 ensureCapacity 来手动增加 ArrayList 实例的
>  容量，以减少递增式再分配的数量。
  
                    public void ensureCapacity(int minCapacity) {
                        modCount++;
                        int oldCapacity = elementData.length;
                        if (minCapacity > oldCapacity) {
                            Object oldData[] = elementData;
                            int newCapacity = (oldCapacity * 3)/2 + 1;
                            if (newCapacity < minCapacity)
                                newCapacity = minCapacity;
                            // minCapacity is usually close to size, so this is a win:
                            elementData = Arrays.copyOf(elementData, newCapacity);
                        }
                     }
>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;从上述代码中可以看出，数组进行扩容时，会将老数组中的元素重新拷贝一份到新的数
>  组中，每次数组容量的增长大约是其原容量的 1.5 倍。这种操作的代价是很高的，因此在实
>  际使用时，我们应该尽量避免数组容量的扩张。当我们可预知要保存的元素的多少时，要在构造 ArrayList 实例时，就指定其容量，以避免数组扩容的发生。或者根据实际需求，通过
>  调用 ensureCapacity 方法来手动增加 ArrayList 实例的容量。</br>
>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ArrayList 还给我们提供了将底层数组的容量调整为当前列表保存的实际元素的大小
>  的功能。它可以通过 trimToSize 方法来实现。代码如下：
                                           
                                           
                   public void trimToSize() {
                        modCount++;
                        int oldCapacity = elementData.length;
                        if (size < oldCapacity) {
                            elementData = Arrays.copyOf(elementData, size);
                        }
                   }
        
<p id="fail">

####  Fail-Fast机制

>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ArrayList 也采用了快速失败的机制，通过记录 modCount 参数来实现。在面对并发的
>  修改时，迭代器很快就会完全失败，而不是冒着在将来某个不确定时间发生任意不确定行为
>  的风险。具体介绍请参考我之前的文章[Java集合之HashMap](https://github.com/jiachao23/StudyNote/blob/master/src/java/HashMap.md)中的Fail-Fast 机制
    
<p id="qa">

##  Q&A

       

<p id="kuozhan">

##  扩展
     