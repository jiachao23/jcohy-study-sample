#  排序算法

> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

> * [相关概念](#sort-1)
> * [算法分类](#sort-2)
> * [算法复杂度](#sort-3)
> * [交换排序](#sort-4)
>  * [冒泡排序（Bubble Sort）](#sort-4)
>  * [快速排序（Quick Sort）](#sort-5)
> * [插入排序](#sort-6)
>   * [简单插入排序（Insertion Sort）](#sort-6)
>   * [折半插入排序（BinaryInsertSort）](#sort-7)
>   * [希尔排序（Shell Sort）](#sort-8)
> * [选择排序](#sort-9)
>   * [简单选择排序（Selection Sort）](#sort-9)
>   * [堆排序（Heap Sort）](#sort-10)
> * [归并排序（Merge Sort）](#sort-11)
> * [计数排序（Counting Sort）](#sort-12)
> * [桶排序（Bucket Sort）](#sort-13)
> * [基数排序（Radix Sort）](#sort-14)
> * [各种内部排序方法性能比较](#sort-15)
> * [排序方法的选择](#sort-16)
> * [完整代码地址](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/src/main/java/com/jcohy/study/sort)

<p id="sort-1" />

## 相关概念

**稳定**：如果a原本在b前面，而a=b，排序之后a仍然在b的前面。

**不稳定**：如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面。

**时间复杂度**：对排序数据的总的操作次数。反映当n变化时，操作次数呈现什么规律。

**空间复杂度**：是指算法在计算机内执行时所需存储空间的度量，它也是数据规模n的函数。

**非线性时间比较类排序**：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此称为非线性时间比较类排序。

**线性时间非比较类排序**：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此称为线性时间非比较类排序。 

<p id="sort-2" />

## 算法分类

![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/3.png)

<p id="sort-3" />

## 算法复杂度
  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/31.png)

<p id="sort-4" />

## 交换排序

<p id="sort-4" />

#### 冒泡排序（Bubble Sort）

- 基本原理

  相邻两元素进行比较，如有需要则进行交换，每完成一次循环就将最大元素排在最后（如从小到大排序），下一次循环是将其它的数进行类似操作。

- 算法描述

  前提条件：序列 $S=\{ S_0,S_2,S_3,...,S_{n-1}\}$ 是n个可排序元素的序列

  1. 令 j 从 n-1递减到 1，重复步骤 2~4
  2. 令 i 从 1 递增到 j，重复步骤3
  3. 如果元素 $S_{i-1}$ 和 $S_i$ 成反序，交换他们
  4. 结束标记，序列 $\{ S_0,S_2,S_3,...,S_j\}$ 被排序且 $Sj$ 最大

- 排序过程

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/28.png)

- 动图演示

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/BubbleSort.gif)

- 冒泡排序算法的改进

  上述的冒泡排序算法还可做如下改进

  - 记录最后一次交换发生位置lastExchange的冒泡排序

    在每趟扫描中，记录最后一次发生交换的位置lastExchange（该记录之前的相邻记录均已有序）。下一趟排序开始时，R[1.....lastExchange-1]是有序区，R[lastExchange.....n]是无序区。这样，一趟排序可能使当前有序区扩充多个记录，从而减少排序的趟数。

  - 改变扫描方向的冒泡排序

    1、冒泡排序的不对称性

    能一趟扫描完成排序的情况：只有最轻的气泡（也就是最小值）位于R[n]处，其余的气泡均已排好序，那也也只需一趟扫描就可以完成排序。例如，对初始关键字序列12，18，45，44，45，67，94，10就仅需一趟扫描

    需要n-1趟扫描完成排序的情况：当只有最重的气泡位于R[1]时，其余的气泡均已排好序时，则仍需做n-1趟扫描才能完成排序。例如，对于初始关键字序列94，10，12，18，42，44，45，67就需7趟扫描

    2、造成不对称性的原因

    每趟扫描仅能使最“重”气泡下沉一个位置，因此使位于顶端的最重气泡下沉到底部时，需做n-1趟扫描。

    3、改进不对称性方法

    在排序过程中交替改变排序方向，可改变不对称性。

- 代码实现

  ```java
  public class BubbleSort {
      public static void bubbleSort(int[] data) {
          System.out.println("开始排序");
          int count = 0;
          int arrayLength = data.length;
          for (int i = 0; i < arrayLength - 1; i++) {
              for (int j = 0; j < arrayLength - 1 - i; j++) {
                  if (data[j]>=(data[j + 1])) {
                      int temp = data[j + 1];
                      data[j + 1] = data[j];
                      data[j] = temp;
                  }
              }
              count++;
              System.out.println(java.util.Arrays.toString(data));
          }
          System.out.println("排序趟数："+count);
      }
      public static void main(String[] args) {
          int[] data = {9,-16,21,23,-30,-49,21,30,30};
          System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
          bubbleSort(data);
          System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
      }
  }
  ```

  优化后代码

  ```java
  public class BubbleSort2 {
      public static void bubbleSort(int[] data) {
          System.out.println("开始排序");
          int count = 0;
          int arrayLength = data.length;
          for (int i = 0; i < arrayLength - 1; i++) {
              boolean flag = false;
              for (int j = 0; j < arrayLength - 1 - i; j++) {
                  if (data[j]>=(data[j + 1])) {
                      int temp = data[j + 1];
                      data[j + 1] = data[j];
                      data[j] = temp;
                      flag = true;
                  }
              }
              if (!flag){
                  break;
              }
              count++;
              System.out.println(java.util.Arrays.toString(data));
          }
          System.out.println("排序趟数："+count);
      }
      public static void main(String[] args) {
          int[] data = {9,-16,21,23,-30,-49,21,30,30};
          System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
          bubbleSort(data);
          System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
      }
  }
  ```

  

<p id="sort-5" />

#### 快速排序（Quick Sort）

- 基本原理

  通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。

- 算法描述

  快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：

  - 从数列中挑出一个元素，称为 “基准”（pivot）；
  - 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
  - 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。

- 排序过程

  例如：8个关键码分别为：49，38，65，97，76，13，27，49

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/QuickSort.jpeg)

- 动图演示

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/QuickSort.gif)

- 快速排序算法分析

  1、基准关键字的选取

  - "三者取中"的规则

    "三者取中"规则，即在当前的区间里，将该区间首，尾和中间位置上的关键字比较，取三者的中值所对应的记录作为基准，在划分开始前将基准记录和该区间的第1个记录进行交换。此后的划分过程和上面所给的Partition算法完全相同

  - 取位于low和high之间的随机数k（low<=k<=high），用R[k]作为基准

    选取基准的最好的方法是用一个随机函数产生一个位于low和high之间的随机数k（low<=k<=high）,用R[k]作为基准。这相当于强迫R[low....high]中的记录是随机分布的，用此方法所得到的快速排序一般称为随机的快速排序。

- 代码实现

  ```java
  public class QuickSort {
  
      private int process = 0;
      private  void subSort(int[] data, int start, int end) {
          if(start<end){
              int base = data[start];
              int i = start;
              int j = end + 1;
              while (true){
                  System.out.print("[处理过程"+(process++)+"]=> ");
                  for(int t=0;t<data.length;t++)
                      System.out.print("["+data[t]+"] ");
  
                  System.out.print("\n");
                  //由左向右找出一个键值大于base者
                  while (i < end && data[++i]<=base) ;
                  //由右向左找出一个键值小于base者
                  while (j > start && data[--j]>=base) ;
                  //若i<j，则d[i]和d[j]互换，继续排序，否则，跳出排序
                  if (i < j) {
                      swap(data, i, j);
                  } else {
                      break;
                  }
              }
              //若i大于等于j，//则将d[start]和d[j]互换
              swap(data, start, j);
              //并以j为基准点分成左右两半
              subSort(data, start, j - 1);
              subSort(data, j + 1, end);
          }
      }
      public  void quickSort(int[] data) {
          subSort(data,0,data.length-1);
      }
      private  void swap(int[] data, int i, int j) {
          int temp = data[i];
          data[i] = data[j];
          data[j] = temp;
      }
  
      public static void main(String[] args) {
          QuickSort quickSort = new QuickSort();
          int[] data = {9,-16,21,23,-30,-49,21,30,30};
          System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
          quickSort.quickSort(data);
          System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
      }
  }
  
  ```

  

<p id="sort-6" />

## 插入排序

<p id="sort-6" />

####  简单插入排序（Insertion Sort）

- 基本原理

  每次将一个待排序的元素，按其关键字大小插入到前面已经排序排好序的子文件的适当位置，直到全部记录插入完成为止。

- 算法描述

  前提条件：序列 $S=\{ S_0,S_2,S_3,...,S_{n-1}\}​$ 是n个可排序元素的序列

  1. 令i从1递增到n-1 ，重复步骤2-4
  2. 讲元素 $S_i$ 保存到临时变量中
  3. 确定使得条件 $S_j>S_i$ 成立的最小的 j
  4. 将子序列 $S=\{ S_j,...,S_{i-1}\}$ 后移一个位置到  $S=\{ S_{j+1},...,S_i\}$
  5. 将保存到临时变量中的原来的 $S_i$ 复制到 $S_j$
  6. 打印排序结果

- 排序过程

  例如：n=6，数组R的六个排序码分别为：17 3 25 14 20 9。他的直接插入排序过程如下：

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/insertSort.jpeg)

- 动图演示

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/insertSort.gif)

- 代码实现

  ```java
  public class InsertSort {
  
      public static void main(String[] args) {
          InsertSort quickSort = new InsertSort();
          int[] data = {9,-16,21,23,-30,-49,21,30,30};
          System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
          quickSort.insertSort(data);
          System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
      }
  
      private void insertSort(int[] data) {
          System.out.println("开始排序");
          int arrayLength = data.length;
          //扫描循环次数为SIZE-1,//i为扫描次数
          for(int i = 1;i < arrayLength;i++){
              int temp = data[i];
              if(data[i] < data[i-1]){
                  //以j来定位比较的元素
                  int j = i -1;
                  ////如果第二元素小于第一元素,就把所有元素往后推一个位置
                  for(;j >= 0 && data[j] > temp;j--){
                      data[j +1] = data[j];
                  }
                  //最小的元素放到第一个元素
                  data[j + 1] = temp;
              }
              System.out.print("第" + i + "次比较：");
              System.out.println(java.util.Arrays.toString(data));
          }
      }
  }
  ```

  

<p id="sort-7" />

#### 折半插入排序（BinaryInsertSort）
- 基本原理

  折半插入排序是对直接插入排序的简单改进。
  此处介绍的折半插入，其实就是通过不断地折半来快速确定第i个元素的插入位置，这实际上是一种查找算法：折半查找。Java的Arrays类里的binarySearch()方法，就是折半查找的实现，用于从指定数组中查找指定元素，前提是该数组已经处于有序状态。

- 算法分析

  与直接插入排序的效果相同，只是更快了一些，因为折半插入排序可以更快地确定第i个元素的插入位置

- 代码实现

  ```java
  public class BinaryInsertSort {
      public  void binaryInsertSort(int[] data) {
          System.out.println("开始排序");
          int arrayLength = data.length;
          for (int i = 1; i < arrayLength; i++) {
              int temp = data[i];
              int low = 0;
              int high = i - 1;
              while (low <= high) {
                  int mid = (low + high) / 2;
                  if (temp > data[mid]) {
                      low = mid + 1;
                  } else {
                      high = mid - 1;
                  }
              }
              for (int j = i; j > low; j--) {
                  data[j] = data[j - 1];
              }
              data[low] = temp;
              System.out.print("第" + i + "次比较：");
              System.out.println(java.util.Arrays.toString(data));
          }
  
      }
      public static void main(String[] args) {
          BinaryInsertSort binaryInsertSort = new BinaryInsertSort();
          int[] data = {9,-16,21,23,-30,-49,21,30,30};
          System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
          binaryInsertSort.binaryInsertSort(data);
          System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
      }
  }
  
  ```

  

<p id="sort-8" />

#### 希尔排序（Shell Sort）

- 基本原理

  先取定一个小于n的整数 $d_1$ 作为第一个增量，把文件的全部记录分为 $d_1$ 个组，所有距离为 $d_1$ 的倍数的记录放在同一个组中，在各组内进行插入排序；然后，取第二个增量 $d_2< d_1 $ 重复上述的分组和排序，直至所取的增量 $d_t=l(d_t < d_{t-1} < ...<d_2 < d_1)$ 即所有记录放在同一组中进行直接插入排序为止。

- 算法描述

  - 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
  - 按增量序列个数k，对序列进行k 趟排序；
  - 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

- 排序过程

  例如：8个关键码分别为：91	67	35	62	29	72	46	57

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/shellsort.jpeg)

- 动图演示

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/ShellSort.gif)

- 希尔排序算法分析

  - 增量序列的选择

    Shell排序的执行时间依赖于增量序列

    好的增量序列的共同特点为：

    1、最后一个增量必须为1

    2、应该尽量避免序列中的值（尤其是相邻的值）互为倍数的情况

    通过大量实验，给出了目前较好的结果，当n比较大时，比较和移动次数大约在 $n^{1.25}$ 到 $1.6n^{1.25}$ 之间

  - Shell排序的时间性能优于直接插入排序，原因如下：

    1、当文件初始状态基本有序时，直接插入排序的比较和移动次数均较少

    2、当n值较小时，n 和 $n^2$  的差别也很小，即直接插入排序的最好时间复杂度 $O(n)$  和最坏时间复杂度 $O(n^2)$ 差别不大

    3、在希尔排序时开始增量较大，分组较多，每组的记录数目少，故各组内直接插入较快，后来增量 $d_i$ 逐渐减少，分组数逐渐减少，而各组的记录数目逐渐增多，但由于已近按 $d_{i-1}$ 作为距离排过序，所以新的一趟排序过程也较快，因此，希尔排序在效率上较直接插入排序有较大的改进

- 代码实现

  ```java
  public class ShellSort {
  	public static void ShellSort(int[] data) {
  		System.out.println("开始排序");
  		int arrayLength = data.length;
  
  		int h = 1;
  		//增量的选择
  		while (h <= arrayLength / 3) {
  			h = h * 3 + 1;
  		}
  		while (h > 0) {
  			System.out.println("增量h的值：" + h);
  			for (int i = h; i < arrayLength; i++) {
                  int temp = data[i];
  				if (data[i] < data[i - h]) {
  					int j = i - h;
  					for (; j >= 0 && data[j] > temp; j -= h) {
  						data[j + h] = data[j];
  					}
  					data[j + h] = temp;
  				}
  				System.out.println(java.util.Arrays.toString(data));
  			}
  			h = (h - 1) / 3;
  		}
  	}
  
  	public static void main(String[] args) {
          int[] data = {9,-16,21,23,-30,-49,21,30,30};
  		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
  		ShellSort(data);
  		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
  	}
  }
  
  ```

  


<p id="sort-9" />

## 选择排序（Selection Sort）

<p id="sort-9" />

#### 简单选择排序（Selection Sort）

- 基本原理
  首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。 

- 算法描述

  n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：

  - 初始状态：无序区为R[1..n]，有序区为空；
  - 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
  - n-1趟结束，数组有序化了。

- 排序过程

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/1.jpg)

- 动图演示

    ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/SelectionSort.gif)

- 代码实现

    ```java
    public class SelectSort {
    	public static void selectSort(int[] data) {
    		System.out.println("开始排序");
    		int arrayLength = data.length;
    		for (int i = 0; i < arrayLength - 1; i++) {
    			for (int j = i + 1; j < arrayLength; j++) {
    				if (data[i] > data[j]) {
                        int temp = data[i];
    					data[i] = data[j];
    					data[j] = temp;
    				}
    			}
    			System.out.println(java.util.Arrays.toString(data));
    		}
    	}
    
    	public static void main(String[] args) {
            int[] data = {9,-16,21,23,-30,-49,21,30,30};
    		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
    		selectSort(data);
    		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    	}
    }
    ```

    简单选择排序优化

    ```java
    public class SelectSort2 {
    	public static void selectSort(int[] data) {
    		System.out.println("开始排序");
    		int arrayLength = data.length;
    		for (int i = 0; i < arrayLength - 1; i++) {
    			int minIndex = i;
    			for (int j = i + 1; j < arrayLength; j++) {
    				if (data[minIndex] > data[j]) {
    					minIndex = j;
    					
    				}
    			}
    			if(minIndex != i){
                    int temp = data[i];
    				data[i] = data[minIndex];
    				data[minIndex] = temp;
    			}
    			System.out.println(java.util.Arrays.toString(data));
    		}
    	}
    
    	public static void main(String[] args) {
            int[] data = {9,-16,21,23,-30,-49,21,30,30};
    		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
    		selectSort(data);
    		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    	}
    }
    ```

    

<p id="sort-10" />

#### 堆排序（Heap Sort）

- 基本原理

  堆排序（Heapsort）是利用完全二叉树排序的方法。满足下列条件之一：

  1、 Ki≤K2i	并且Ki≤K2i+1 （i=1,2,......,n/2）

  2、 Ki≥K2i	并且Ki≥K2i+1 （i=1,2,......,n/2）

  上面的1称为小顶堆（二叉树的所有节点值小于或等于左右孩子的值）。2称为大顶堆（二叉树的所有节点值大于或等于左右孩子的值）

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/heap.jpg)

- 算法描述

  - 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
  - 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
  - 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。

- 排序过程（以大顶堆为例）

  建立初始堆（把放在数组里的元素的序列看成是一颗完全二叉树，对该二叉树进行调整，使之称为堆）

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/2.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/3.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/4.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/5.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/6.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/7.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/8.jpg)

  堆排序

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/9.jpg)

  调整

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/10.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/11.jpg)

  调整

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/12.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/13.jpg)

  调整

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/14.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/15.jpg)

  调整

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/16.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/17.jpg)

  调整

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/18.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/19.jpg)

- 动图演示

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/HeapSort.gif)

- 代码实现

  ```java
  public class HeapSort {
  	public static void heapSort(int[] data) {
  		System.out.println("开始排序");
  		int arrayLength = data.length;
  		// 循环建堆
  		for (int i = 0; i < arrayLength - 1; i++) {
  			// 建堆
  			builMaxdHeap(data, arrayLength - 1 - i);
  			// 交换堆顶和最后一个元素
  			swap(data, 0, arrayLength - 1 - i);
  			System.out.println(java.util.Arrays.toString(data));
  		}
  	}
  
  	// 对data数组从0到lastIndex建大顶堆
  	private static void builMaxdHeap(int[] data, int lastIndex) {
  		// 从lastIndex处节点（最后一个节点）的父节点开始
  		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
  			// k保存当前正在判断的节点
  			int k = i;
  			// 如果当前k节点的子节点存在
  			while (k * 2 + 1 <= lastIndex) {
  				// k节点的左子节点的索引
  				int biggerIndex = 2 * k + 1;
  				// 如果biggerIndex小于lastIndex，即biggerIndex +1
  				// 代表k节点的右子节点存在
  				if (biggerIndex < lastIndex) {
  					// 如果右子节点的值较大
  					if (data[biggerIndex] < data[biggerIndex + 1]) {
  						// biggerIndex总是记录较大子节点的索引
  						biggerIndex++;
  					}
  				}
  				// 如果k节点的值小于其较大子节点的值
  				if (data[k] < data[biggerIndex]) {
  					// 交换它们
  					swap(data, k, biggerIndex);
  					// 将biggerIndex赋给k，开始while循环的下一次循环
  					// 重新保证k节点的值大于其左、右节点的值
  					k = biggerIndex;
  				} else {
  					break;
  				}
  			}
  		}
  	}
  
  	// 交换data数组中i、j两个索引处的元素
  	private static void swap(int[] data, int i, int j) {
  		int temp = data[i];
  		data[i] = data[j];
  		data[j] = temp;
  	}
  
  	public static void main(String[] args) {
  		int[] data = {9,-16,21,23,-30,-49,21,30,30};
  		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
  		heapSort(data);
  		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
  	}
  }
  ```

  

<p id="sort-11" />

## 归并排序（Merge Sort）

- 基本原理

  将两个或者两个以上的有序表组合成一个新的有序表。即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。 

- 算法描述

  - 把长度为n的输入序列分成两个长度为n/2的子序列；
  - 对这两个子序列分别采用归并排序；
  - 将两个排序好的子序列合并成一个最终的排序序列。

- 排序过程

  - 例如，将下列两个已排序的顺序表合并成一个已排序表。顺序比较两者的相应元素，小者移入另一个表中，反复如此，直至其中任一表全部移入另一表为止


  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/20.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/21.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/22.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/23.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/24.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/25.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/26.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/27.jpg)

  - 二路并归过程

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/MergeSort2.jpeg)

- 动图演示

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/MergeSort.gif)

- 代码实现

  ```java
  public class MergeSort {
  	public static void mergeSort(int[] data) {
  		// 归并排序
  		sort(data, 0, data.length - 1);
  	}
  
  	// 将索引从left到right范围的数组元素进行归并排序
  	private static void sort(int[] data, int left, int right) {
  		if(left < right){
  			//找出中间索引
  			int center = (left + right)/2;
  			sort(data,left,center);
  			sort(data,center+1,right);
  			//合并
  			merge(data,left,center,right);
  		}
  	}
  
  	// 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序
  	private static void merge(int[] data, int left, int center, int right) {
          int[] tempArr = new int[data.length];
  		int mid = center + 1;
  		int third = left;
  		int temp = left;
  		while (left <= center && mid <= right) {
  			if (data[left] <= data[mid]) {
  				tempArr[third++] = data[left++];
  			} else {
  				tempArr[third++] = data[mid++];
  			}
  		}
  		while (mid <= right) {
  			tempArr[third++] = data[mid++];
  		}
  		while (left <= center) {
  			tempArr[third++] = data[left++];
  		}
  		while (temp <= right) {
  			data[temp] = tempArr[temp++];
  		}
  	}
  
  	public static void main(String[] args) {
          int[] data = {9,-16,21,23,-30,-49,21,30,30};
  		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
  		mergeSort(data);
  		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
  	}
  }
  ```
<p id="sort-12" />

## 计数排序（Counting Sort）

- 基本原理

  计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。

- 算法描述

  - 找出待排序的数组中最大和最小的元素；
  - 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
  - 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
  - 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。

- 排序过程

- 动图演示

- 代码实现

  ```java
  public class CountingSort {
  
      public static void main(String[] args) {
          int[] data = {9,5,-1,8,5,7,3,-3,1,3};
          System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
          countingSort(data);
          System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
      }
  
      public static void countingSort(int[] data){
          if(data.length == 0){
              return;
          }
          //找出待排序的数组中最大和最小的元素；
          int max  = data[0];
          int min = data[0];
          for(int i= 0;i < data.length ;i++){
              if(data[i] > max){
                  max = data[i];
              }
              if(data[i] < min){
                  min = data[i];
              }
          }
          int bias = 0 - min;
          int[] bucket = new int[max - min +1];
          Arrays.fill(bucket,0);
          for(int i = 0 ; i< data.length;i++){
              bucket[data[i]+bias]++;
          }
          int index=0 ,i = 0;
          while (index < data.length){
              if(bucket[i] != 0){
                  data[index] = i - bias;
                  bucket[i]--;
                  index++;
              }else{
                  i++;
              }
          }
      }
  }
  ```

  

<p id="sort-13" />

## 桶排序（Bucket Sort）

- 基本原理

  桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。

- 算法描述

  - 设置一个定量的数组当作空桶；
  - 遍历输入数据，并且把数据一个一个放到对应的桶里去；
  - 对每个不是空的桶进行排序；
  - 从不是空的桶里把排好序的数据拼接起来。 

- 排序过程

  以下为例： 5，4，2，4，1 使用桶式排序

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/29.jpg)

- 代码实现

  ```java
  public class BucketSort {
  	public  void bucketSort(int[] data, int min, int max) {
  		System.out.println("开始排序");
  		int arrayLength = data.length;
  		int[] temp = new int[arrayLength];
  		int[] buckets = new int[max - min];
  		for (int i = 0; i < arrayLength; i++) {
  			buckets[data[i] - min]++;
  		}
  		System.out.println(Arrays.toString(buckets));
  		for (int i = 1; i < max - min; i++) {
  			buckets[i] = buckets[i] + buckets[i - 1];
  		}
  		System.out.println(Arrays.toString(buckets));
  		System.arraycopy(data, 0, temp, 0, arrayLength);
  		for (int k = arrayLength - 1; k >= 0; k--) {
  			data[--buckets[temp[k] - min]] = temp[k];
  		}
  	}
  
  	public static void main(String[] args) {
          BucketSort bucketSort = new BucketSort();
          int[] data = {9,5,-1,8,5,7,3,-3,1,3};
  		System.out.println("排序之前：\n" + Arrays.toString(data));
          bucketSort.bucketSort(data, -3, 10);
  		System.out.println("排序之后：\n" + Arrays.toString(data));
  	}
  }
  
  ```

  

<p id="sort-14" />

## 基数排序（Radix Sort）

- 基本原理

  - 基数排序已经不再是一种常规的排序方法，它更多地像是一种排序方法的应用，基数排序必须依赖于另外的排序方法。基数排序的总体思路就是将待排数据拆分成多个关键字进行排序，也就是说，基数排序的实质是多关键字排序。
  - 多关键字排序的思路是将待排数据里的排序关键字拆分成多个排序关键字：第1个子关键字、第2个子关键字、第3个子关键字。。。然后，根据子关键字对待排数据进行排序。
  - 在进行多关键字排序时有两种解决方案：
    最高位优先法MSD
    最低位优先法LSD

- 算法描述

  - 取得数组中的最大数，并取得位数；
  - arr为原始数组，从最低位开始取每个位组成radix数组；
  - 对radix进行计数排序（利用计数排序适用于小范围数的特点）；

- 排序过程

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/30.jpg)

- 动图演示

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/RadixSort.gif)

- 算法分析

  - MSD法和LSD法的比较

    比较MSD法和LSD法，一般来讲，LSD法要比MSD法来得简单，因为LSD法是从头到尾进行若干次分配和收集，执行的次数取决于构成关键字值的成分为多少；而MSD法则要处理各序列与子序列的独立排序问题，就可能复杂一些。

- 代码实现

  ```java
  public class MultiKeyRadixSort {
  	public static void radixSort(int[] data, int radix, int d) {
  		System.out.println("开始排序：");
  		int arrayLength = data.length;
  		int[] temp = new int[arrayLength];
  		int[] buckets = new int[radix];
  		for (int i = 0, rate = 1; i < d; i++) {
  			// 重置count数组，开始统计第二个关键字
  			Arrays.fill(buckets, 0);
  			// 当data数组的元素复制到temp数组中进行缓存
  			System.arraycopy(data, 0, temp, 0, arrayLength);
  			for (int j = 0; j < arrayLength; j++) {
  				int subKey = (temp[j] / rate) % radix;
  				buckets[subKey]++;
  			}
  			for (int j = 1; j < radix; j++) {
  				buckets[j] = buckets[j] + buckets[j - 1];
  			}
  			for (int m = arrayLength - 1; m >= 0; m--) {
  				int subKey = (temp[m] / rate) % radix;
  				data[--buckets[subKey]] = temp[m];
  			}
  			System.out.println("对" + rate + "位上子关键字排序："
  					+ Arrays.toString(data));
  			rate *= radix;
  		}
  	}
  
  	public static void main(String[] args) {
  		int[] data = { 1100, 192, 221, 12, 13 };
  		System.out.println("排序之前：\n" + Arrays.toString(data));
  		radixSort(data, 10, 4);
  		System.out.println("排序之后：\n" + Arrays.toString(data));
  	}
  }
  
  ```

  

<p id="sort-15" />

## 各种内部排序方法性能比较

- 从平均时间而言：快速排序最佳。但在最坏情况下时间性能不如堆排序和归并排序。

- 从算法简单性看：由于直接选择排序、直接插入排序和冒泡排序的算法比较简单，将其认为是简单算法，都包含在上图的“简单排序”中。对于Shell排序、堆排序、快速排序和归并排序算法，其算法比较复杂，认为是复杂排序。

- 从稳定性看：直接插入排序、冒泡排序和归并排序时稳定的；而直接选择排序、快速排序、 Shell排序和堆排序是不稳定排序

- 从待排序的记录数n的大小看，n较小时，宜采用简单排序；而n较大时宜采用改进排序。

<p id="sort-16" />

## 排序方法的选择

- 若n较小(如n≤50)，可采用直接插入或直接选择排序。
  当记录规模较小时，直接插入排序较好；否则因为直接选择移动的记录数少于直接插入，应选直接选择排序为宜。
- 若文件初始状态基本有序(指正序)，则应选用直接插入、冒泡或随机的快速排序为宜；
- 若n较大，则应采用时间复杂度为O(nlgn)的排序方法：快速排序、堆排序或归并排序。