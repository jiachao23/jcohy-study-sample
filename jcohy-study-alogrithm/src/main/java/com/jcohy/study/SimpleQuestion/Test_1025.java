package com.jcohy.study.SimpleQuestion;

import java.util.Scanner;

//逆序
public class Test_1025 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] a = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = in.nextInt();
		}
		for (int i = 9; i >= 0; i--) {
			System.out.print(a[i]+" ");
			
		}
	}
}
