package com.jcohy.study.SimpleQuestion.三元矩阵对角线之和;

import java.util.Scanner;

public class Test_1023 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] a = new int[3][3];
		for (int i = 0; i < a.length; i++) {
			for(int j=0;j<a[i].length;j++)
			a[i][j]=in.nextInt();
		}
		int sumZ =a[0][0]+a[1][1]+a[2][2] ;
		int sumF =a[0][2]+a[1][1]+a[2][0] ;
		System.out.println(sumZ+" "+sumF);
	}

}
