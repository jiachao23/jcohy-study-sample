package com.jcohy.study.SimpleQuestion;

import java.util.Scanner;

/**
 * 简单数字操作
 */
public class Test_1008 {
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		String a=in.nextLine();
		System.out.println("数字长度:"+a.length());
		System.out.print("数字拆分：");
		for (int i = 0; i < a.length(); i++) {
			System.out.print(a.charAt(i)+" ");
		}
		System.out.println();
		System.out.print("数字逆序:");
		for (int i = a.length()-1; i>=0; i--) {
			System.out.print(a.charAt(i));
		}

	}

}
