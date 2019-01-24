package com.jcohy.study.sort;
// =============== Program Description ===============
// 程序名称： CH08_07.java                               
// 程序目的：堆积排序法
// ===================================================
import java.io.*;

public  class CH08_07
{
public static void main(String args[]) throws IOException
   {
	int i,size,data[]={0,5,6,4,8,3,2,7,1};	//原始数组内容
	size=9;
	System.out.print("原始数组：");
	for(i=1;i<size;i++)
		System.out.print("["+data[i]+"] ");
	CH08_07.heap(data,size);			//建立堆积树
	System.out.print("\n排序结果：");
	for(i=1;i<size;i++)
		System.out.print("["+data[i]+"] ");
	System.out.print("\n");
   }  

public static void heap(int data[] ,int size)
{  
	int i,j,tmp;
	for(i=(size/2);i>0;i--)			    //建立堆积树节点	
		CH08_07.ad_heap(data,i,size-1);
	System.out.print("\n堆积内容：");
	for(i=1;i<size;i++)			    //原始堆积树内容
		System.out.print("["+data[i]+"] ");
	System.out.print("\n");
	for(i=size-2;i>0;i--)			    //堆积排序??
	{  
		tmp=data[i+1];			    //头尾节点交换
		data[i+1]=data[1];
		data[1]=tmp;
		CH08_07.ad_heap(data,1,i);	            //处理剩余节点
		System.out.print("\n处理过程：");
		for(j=1;j<size;j++)
			System.out.print("["+data[j]+"] ");
	}
}
public static void ad_heap(int data[],int i,int size)
   {  
        int j,tmp,post;
	j=2*i;
	tmp=data[i];
	post=0;
	while(j<=size && post==0)
	{  
		if(j<size)
		{
			if(data[j]<data[j+1])		//找出最大节点
				j++;
		}
		if(tmp>=data[j])			//若树根较大，结束比较过程
			post=1;
		else
		{  
			data[j/2]=data[j];		//若树根较小，则继续比较
			j=2*j;
		}   
   }
   data[j/2]=tmp;					//指定树根为父节点
   }
} 
