package com.jcohy.study.ViewQuestion.paixu;
// =============== Program Description ===============
// 程序名称： CH08_05.java                               
// 程序目的：希尔排序法
// ===================================================
import java.io.*;

public class ShellSort extends Object
{
	int data[]=new int[8];
	int size=8;	
	
	public static void main(String args[])
	{ 		
		ShellSort test =  new ShellSort();
		test.inputarr();		
		System.out.print("您输入的原始数组是：");
		test.showdata();
		test.shell();
	}

	void inputarr()
	{
		int i=0;
		for (i=0;i<size;i++)
		{ 
			System.out.print("请输入第"+(i+1)+"个元素：");
			try{				
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				data[i]=Integer.parseInt(br.readLine());
			}catch(Exception e){}
		}
	}

	void showdata()
	{
		int i=0;		
		for (i=0;i<size;i++)
		{
			System.out.print(data[i]+" ");
		}
		System.out.print("\n");
	}
	
	void shell()
	{  
		int i;        //i为扫描次数
		int j;        //以j来定位比较的元素
		int k=1;      //k打印计数
		int tmp;      //tmp用来暂存数据
		int jmp;      //设定间隔位移量

		jmp=size/2;
		while (jmp != 0)
		{  
			for (i=jmp ;i<size ;i++)
			{  
				tmp=data[i];
				j=i-jmp;
				while(j>=0 && tmp<data[j])  //插入排序法
				{  
					data[j+jmp] = data[j];
					j=j-jmp;
				}	
				data[jmp+j]=tmp;				
			}
			
			System.out.print("第"+ (k++) +"次排序：");			
			showdata();
			jmp=jmp/2;    //控制循环数
		}
        }
}
