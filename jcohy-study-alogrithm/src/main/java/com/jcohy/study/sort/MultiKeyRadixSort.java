package com.jcohy.study.sort;

import java.util.Arrays;

/**
 * Created by jiac on 2019/2/15.
 * ClassName  : com.jcohy.study.sort
 * Description  :    基数排序
 */
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
