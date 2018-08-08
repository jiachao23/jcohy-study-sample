package com.jcohy.study.SimpleQuestion.打印水仙花数;

import java.util.Scanner;


public class Test_1159 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int	b3 =a/100;
		int	b2 =a%100/10;
		int b1 =a%10;
		if((b3*b3*b3+b2*b2*b2+b1*b1*b1)==a){
			System.out.println("1");
		}
	}
}
