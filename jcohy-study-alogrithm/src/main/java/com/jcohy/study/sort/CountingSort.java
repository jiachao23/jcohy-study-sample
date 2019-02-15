package com.jcohy.study.sort;

import java.util.Arrays;

/**
 * Created by jiac on 2019/2/15.
 * ClassName  : com.jcohy.study.sort
 * Description  :  计数排序
 */
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
