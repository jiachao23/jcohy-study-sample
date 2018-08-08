package com.jcohy.study.SimpleQuestion.¼òµ¥Êý×Ö²Ù×÷;

import java.util.Scanner;

public class Test_1008 {
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		String a=in.nextLine();
		System.out.println(a.length()+" ");		
		for (int i = 0; i < a.length(); i++) {
			System.out.print(a.charAt(i)+" ");
		}
		System.out.println();
		for (int i = a.length()-1; i>=0; i--) {
			System.out.print(a.charAt(i));
		}

	}

}
