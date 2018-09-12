package com.jcohy.study.StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueueArray {
	/*
	 * ���кͶ�ջ���������б�Ҳ���ڳ������������͡����еļ����ɾ���������ڲ�ͬ�����ˡ�
	 * ���е����ԣ��Ƚ��ȳ�
	 * ӵ�����ֻ����Ĳ������ȼ�����ɾ��������ʹ��front����rear����ָ��ָ����е�ǰ�˺�β�ˡ�
	 * ���еĻ������㣺Create�������ն���
	 * 				Add���������ݼ�����е�β�ˣ������¶���
	 * 				Delete��ɾ������ǰ�˵����ݣ������¶���
	 * 				Front�����ض���ǰ�˵�ֵ
	 * 				Empty��������Ϊ�ռ��ϣ������档
	 * ����������ķ�ʽʵ�ֶ��У�������һ��С���⣬�����е������ݲ��ܲ��룬��ǰ�滹�п���ռ䡣
	 * ��Ȼ���ǿ����ڶ����н�������ǰ�ƶ���Ȼ���ڲ������ݡ������ݹ���ʱ�������ʱ���˷�
	 */
	public static int front =-1,rear=-1,max=20;
	public static int val;
	public static char  ch;
	public static int queue[]=new int[max];
	public static void main(String[] args) throws IOException {
		String strM;
		int M=0;
		BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
		while(rear<max-1&&M!=3){
			System.out.println("[1]����һ����ֵ[2]ȡ��һ����ֵ[3]����");
			strM=keyin.readLine();
			M=Integer.valueOf(strM);
			switch(M){
			case 1:
				System.out.println("\n������һ������");
				strM=keyin.readLine();
				val=Integer.valueOf(strM);
				rear++;
				queue[rear]=val;
				break;
			case 2:
				if(rear>front){
					front++;
					System.out.print("\nȡ����ֵΪ��["+queue[front]+"]"+"\n");
					queue[front]=0;
				}else{
					System.out.print("�����Ѿ�����");
					break;
				}
				break;
				default:
					System.out.print("\n");
					break;
			}
		}
		if(rear==max-1) 
			System.out.print("[�����Ѿ�����]\n");
		System.out.print("\n[Ŀǰ�����е�����]:");
		if(front>=rear){
			System.out.print("û��\n");
			System.out.print("[�����Ѿ�����]\n");
		}
		else{
			while(rear>front){
				front++;
				System.out.print("["+queue[front]+"]");
			}
			System.out.print("\n");
		}
	}
}















