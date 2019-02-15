package com.jcohy.study.sort;

import java.util.Arrays;

/**
 * Created by jiac on 2019/2/15.
 * ClassName  : com.jcohy.study.sort
 * Description  : 桶排序
 */
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
