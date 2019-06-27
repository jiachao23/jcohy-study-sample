package com.jcohy.study.sort;

/**
 * Created by jiac on 2019/2/15.
 * ClassName  : com.jcohy.study.sort
 * Description  : 冒泡排序优化
 */
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
