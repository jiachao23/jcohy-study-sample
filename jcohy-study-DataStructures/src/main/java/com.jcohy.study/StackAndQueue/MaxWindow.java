package com.jcohy.study.StackAndQueue;

import java.util.LinkedList;

/**
 * 有一个整型数组和一个大小为w的窗口从数组的最左边滑倒最右边，窗口每次向右移动
 * 一个位置。
 * 如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。请实现一个函数
 * 输入：整型数组arr，窗口大小w
 * 输出：一个长度为n-w+1的数组res，res[i]表示每一组窗口状态下的最大值
 * @author jiachao
 *
 */
public class MaxWindow {
	/**
	 * @param arr数组大小
	 * @param w窗口大小
	 * @return
	 */
	public int[] getMaxWindow(int[] arr,int w){
		if(arr==null||w<1||arr.length<w)
			return null;
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[arr.length-w+1];
		int index=0;
		for(int i=0;i<arr.length;i++){
			while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst()==i-w){
				qmax.pollFirst();
			}
			if(i>=w-1){
				res[index++]=arr[qmax.peekFirst()];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		MaxWindow mw =new MaxWindow();
		int[] arr = new int[]{4,3,5,4,3,3,6,7};
		int[] result = mw.getMaxWindow(arr, 3);
		for(int i:result){
			System.out.print(i+" ");
		}
	}
}
