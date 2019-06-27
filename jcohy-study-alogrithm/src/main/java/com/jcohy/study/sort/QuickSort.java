package com.jcohy.study.sort;

/**
 * Created by jiac on 2019/2/15.
 * ClassName  : com.jcohy.study.sort
 * Description  :   快速排序
 */
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
