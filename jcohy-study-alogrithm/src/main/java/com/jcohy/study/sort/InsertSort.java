package com.jcohy.study.sort;

/**
 * Created by jiac on 2019/2/15.
 * ClassName  : com.jcohy.study.sort
 * Description  :
 */
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
