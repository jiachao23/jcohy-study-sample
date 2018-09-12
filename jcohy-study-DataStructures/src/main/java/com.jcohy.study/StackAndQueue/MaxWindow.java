package com.jcohy.study.StackAndQueue;

import java.util.LinkedList;

/**
 * ��һ�����������һ����СΪw�Ĵ��ڴ����������߻������ұߣ�����ÿ�������ƶ�
 * һ��λ�á�
 * ������鳤��Ϊn�����ڴ�СΪw����һ������n-w+1�����ڵ����ֵ����ʵ��һ������
 * ���룺��������arr�����ڴ�Сw
 * �����һ������Ϊn-w+1������res��res[i]��ʾÿһ�鴰��״̬�µ����ֵ
 * @author jiachao
 *
 */
public class MaxWindow {
	/**
	 * @param arr�����С
	 * @param w���ڴ�С
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
