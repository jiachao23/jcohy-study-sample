package com.jcohy.study.SimpleQuestion.前N项和;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Test_1017 {
	//前N项和
	public static void main(String[] agrs){
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		float m=1,n=1,t,s=0;
		for(double i=0;i<a;i++){
			 t=m+n; 
			  s=s+t/n;
			  m=n;
			  n=t;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(df.format(s));
	}
}
