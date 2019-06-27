package com.jcohy.study.sort;

/**
 * Created by jiac on 2019/2/15.
 * ClassName  : com.jcohy.study.sort
 * Description  : 折半插入排序
 */
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
