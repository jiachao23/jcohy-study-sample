#  排序算法

> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 排序算法
> * [并发和并行](#os-1)
> * [进程间通信的方式](#os-2)
> * [LinuxIO模型](#os-3)
> 

#### 相关概念

**稳定**：如果a原本在b前面，而a=b，排序之后a仍然在b的前面。

**不稳定**：如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面。

**时间复杂度**：对排序数据的总的操作次数。反映当n变化时，操作次数呈现什么规律。

**空间复杂度**：是指算法在计算机内执行时所需存储空间的度量，它也是数据规模n的函数。

**非线性时间比较类排序**：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此称为非线性时间比较类排序。

**线性时间非比较类排序**：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此称为线性时间非比较类排序。 



#### 算法分类
  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/3.png)


#### 算法复杂度
  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/1.gif)


#### 冒泡排序（Bubble Sort）

#### 选择排序（Selection Sort）

- 基本原理
  首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。 

- 算法描述

  n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：

  - 初始状态：无序区为R[1..n]，有序区为空；
  - 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
  - n-1趟结束，数组有序化了。

- 原理

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/1.jpg)
  
- 动图演示

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-alogrithm/images/1.gif)

- 代码实现