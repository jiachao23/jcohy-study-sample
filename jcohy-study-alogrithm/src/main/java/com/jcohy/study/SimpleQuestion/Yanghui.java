package com.jcohy.study.SimpleQuestion;
import java.util.Scanner;

public class Yanghui {
	public static void main(String[] agrs){
		Scanner in=new Scanner(System.in);
		int count=in.nextInt();
		int[][] arr=new int[count][];
		//初始化数组。
		for(int i=0;i<arr.length;i++){
			arr[i]=new int[i+1];
		}
		//显示出为每个元素赋值
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				arr[i][0]=arr[i][i]=1;
			}
		}
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(i>1&&j>0&&j<i){
					arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
				}
			}
		}
		//遍历
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
