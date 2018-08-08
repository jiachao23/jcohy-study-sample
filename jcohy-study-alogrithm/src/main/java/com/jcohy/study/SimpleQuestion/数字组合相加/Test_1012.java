package com.jcohy.study.SimpleQuestion.数字组合相加;

import java.util.Scanner;

public class Test_1012 {
	//数字组合加法
	public static void main(String[] agrs){
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int c=(int) Math.pow(10,a);
		int sum=(10*(c-1)/9-a)*2/9;
		//System.out.println(c);
		System.out.println(sum);
		}
	}

