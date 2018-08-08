package com.jcohy.study.SimpleQuestion.求和1014;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test_1014 {
	//求和缩略
	public static void main (String args[])	{
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int b=in.nextInt();
		int c=in.nextInt();	
		double sum=0;
		for(int i=1;i<=a;i++){
			sum+=i;
		}
		for(int i=1;i<=b;i++){
			sum+=(i*i);		
		}
		for(double i=1;i<=c;i++){
			sum+=(1/i);
		}
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(df.format(sum));
	}
}