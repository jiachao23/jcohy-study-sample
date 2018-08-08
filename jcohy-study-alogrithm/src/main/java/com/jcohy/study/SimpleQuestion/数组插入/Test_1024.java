package com.jcohy.study.SimpleQuestion.Êı×é²åÈë;

import java.util.Scanner;

public class Test_1024 {
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int[] a = new int[10];
		for (int i = 0; i < 9; i++) {
			a[i] = in.nextInt();
		}
		int insert = in.nextInt();
		for (int i = a.length - 2; i > 0; i--) {
			if (a[i] > insert) {
				a[i + 1] = a[i];
			} else {
				a[i + 1] = insert;
				break;
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
