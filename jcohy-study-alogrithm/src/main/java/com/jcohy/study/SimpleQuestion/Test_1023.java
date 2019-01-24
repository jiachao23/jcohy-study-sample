package com.jcohy.study.SimpleQuestion;

import java.util.Scanner;

/**
 * 	例如：
 *   1 2 3
 *   4 5 6
 *   9 8 7
 *   输出
 */
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
