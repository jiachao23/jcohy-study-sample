#  排序算法

> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 排序算法
> * [相关概念](#sort-1)
> * [算法分类](#sort-2)
> * [算法复杂度](#sort-3)
> * [直接插入排序（Insertion Sort](#sort-4)
> * [希尔排序（Shell Sort）](#sort-5)
> * [冒泡排序（Bubble Sort）](#sort-6)
> * [选择排序（Selection Sort）](#sort-7)
>  * [直接选择排序（Selection Sort）](#sort-8)
>  * [堆排序（Heap Sort）](#sort-9)
>  * [归并排序（Merge Sort）](#sort-10)


## 相关概念

**稳定**：如果a原本在b前面，而a=b，排序之后a仍然在b的前面。

**不稳定**：如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面。

**时间复杂度**：对排序数据的总的操作次数。反映当n变化时，操作次数呈现什么规律。

**空间复杂度**：是指算法在计算机内执行时所需存储空间的度量，它也是数据规模n的函数。

**非线性时间比较类排序**：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此称为非线性时间比较类排序。

**线性时间非比较类排序**：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此称为线性时间非比较类排序。 



## 算法分类

![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/3.png)

## 算法复杂度
| 排序方法 | 时间复杂度（平均） | 时间复杂度（最坏） | 时间复杂度（最好） | 空间复杂度     | 稳定性 |
| -------- | ------------------ | ------------------ | ------------------ | -------------- | ------ |
| 插入排序 | $O（n^2）$         | $O（n^2）$         | $O（n）$           | $O（1）$       | 稳定   |
| 希尔排序 | $O（n^1.3）$       | $O（n^2）$         | $O（n）$           | $O（1）$       | 不稳定 |
| 选择排序 | $O（n^2）$         | $O（n^2）$         | $O（n^2）$         | $O（1）$       | 不稳定 |
| 堆排序   | $O（nlog_2n）$     | $O（nlog_2n）$     | $O（nlog_2n）$     | $O（1）$       | 不稳定 |
| 冒泡排序 | $O（n^2）$         | $O（n^2）$         | $O（n）$           | $O（1）$       | 稳定   |
| 快速排序 | $O（nlog_2n）$     | $O（n^2）$         | $O（nlog_2n）$     | $O（nlog_2n）$ | 不稳定 |
| 归并排序 | $O（nlog_2n）$     | $O（nlog_2n）$     | $O（nlog_2n）$     | $O（n）$       | 稳定   |
|          |                    |                    |                    |                |        |
| 计数排序 | $O（n+k）$         | $O（n+k）$         | $O（n+k）$         | $O（n+k）$     | 稳定   |
| 桶排序   | $O（n+k）$         | $O（n^2）$         | $O（n）$           | $O（n+k）$     | 稳定   |
| 基数排序 | $O（n+k）$         | $O（n*k）$         | $O（n*k）$         | $O（n+k）$     | 稳定   |



## 直接插入排序（Insertion Sort）

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

  

## 希尔排序（Shell Sort）

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



## 冒泡排序（Bubble Sort）

- 基本原理

  相邻两元素进行比较，如有需要则进行交换，每完成一次循环就将最大元素排在最后（如从小到大排序），下一次循环是将其它的数进行类似操作。

- 算法描述

  前提条件：序列 $S=\{ S_0,S_2,S_3,...,S_{n-1}\}$ 是n个可排序元素的序列

  1. 令 j 从 n-1递减到 1，重复步骤 2~4
  2. 令 i 从 1 递增到 j，重复步骤3
  3. 如果元素 $S_{i-1}$ 和 $S_i$ 成反序，交换他们
  4. 结束标记，序列 $\{ S_0,S_2,S_3,...,S_j\}$ 被排序且 $Sj$ 最大

- 排序过程

  

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

## 快速排序（Quick Sort）

- 基本原理

  通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。

- 算法描述

  快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：

  - 从数列中挑出一个元素，称为 “基准”（pivot）；
  - 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
  - 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。

- 排序过程

  例如：8个关键码分别为：49	38	65	97	76	13	27	49

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

  
## 选择排序（Selection Sort）
#### 直接选择排序（Selection Sort）

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

## 归并排序（Merge Sort）

- 基本原理

  将两个或者两个以上的有序表组合成一个新的有序表。即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。 

- 算法描述

  - 把长度为n的输入序列分成两个长度为n/2的子序列；
  - 对这两个子序列分别采用归并排序；
  - 将两个排序好的子序列合并成一个最终的排序序列。

- 排序过程

  例如，讲下列两个已排序的顺序表合并成一个已排序表。顺序比较两者的相应元素，小者移入另一个表中，反复如此，直至其中任一表全部移入另一表为止

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/20.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/21.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/22.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/23.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/24.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/25.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/26.jpg)

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/27.jpg)

- 动图演示

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/MergeSort.gif)

- 代码实现

## demo（Shell Sort）

- 基本原理
- 算法描述
- 排序过程
- 动图演示
- 代码实现