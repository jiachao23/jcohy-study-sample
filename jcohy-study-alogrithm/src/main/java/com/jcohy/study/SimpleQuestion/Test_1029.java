package com.jcohy.study.SimpleQuestion;

import java.util.Scanner;

public class Test_1029 {
	//转置数组
	public static void main(String[] agrs){
		Scanner in=new Scanner(System.in);
		int[][] arr=new int[3][3];
		int[][] arr1=new int[3][3];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				arr[i][j]=in.nextInt();				
			}
		}		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				arr1[i][j]=arr[j][i];
			}
		}
		for(int i=0;i<arr1.length;i++){
			for(int j=0;j<arr1[i].length;j++){
				System.out.print(arr1[i][j]+" ");
				
			}
			System.out.println();
		}
	}
}
