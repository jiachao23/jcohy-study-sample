package com.jcohy.study.StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueueArray {
	/*
	 * 队列和堆栈都是有序列表，也属于抽象型数据类型。所有的加入和删除都发生在不同的两端。
	 * 队列的特性：先进先出
	 * 拥有两种基本的操作，既加入与删除。而且使用front坏人rear两个指针指向队列的前端和尾端。
	 * 队列的基本运算：Create：建立空队列
	 * 				Add：将新数据加入队列的尾端，返回新队列
	 * 				Delete：删除队列前端的数据，返回新队列
	 * 				Front：返回队列前端的值
	 * 				Empty：若队列为空集合，返回真。
	 * 下面以数组的方式实现队列，但是有一个小问题，队列中的新数据不能插入，而前面还有空余空间。
	 * 虽然我们可以在队列中讲数据向前移动，然后在插入数据。但数据过多时，会造成时间浪费
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
			System.out.println("[1]存入一个数值[2]取出一个数值[3]结束");
			strM=keyin.readLine();
			M=Integer.valueOf(strM);
			switch(M){
			case 1:
				System.out.println("\n请输入一个数：");
				strM=keyin.readLine();
				val=Integer.valueOf(strM);
				rear++;
				queue[rear]=val;
				break;
			case 2:
				if(rear>front){
					front++;
					System.out.print("\n取出的值为：["+queue[front]+"]"+"\n");
					queue[front]=0;
				}else{
					System.out.print("队列已经空了");
					break;
				}
				break;
				default:
					System.out.print("\n");
					break;
			}
		}
		if(rear==max-1) 
			System.out.print("[队列已经满了]\n");
		System.out.print("\n[目前队列中的数据]:");
		if(front>=rear){
			System.out.print("没有\n");
			System.out.print("[队列已经空了]\n");
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















