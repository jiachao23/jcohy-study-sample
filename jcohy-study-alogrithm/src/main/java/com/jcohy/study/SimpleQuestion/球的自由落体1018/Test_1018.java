package com.jcohy.study.SimpleQuestion.�����������1018;

import java.text.DecimalFormat;
import java.util.Scanner;

//������������
public class Test_1018 {
	public static void main(String[] agrs){
		Scanner in=new Scanner(System.in);
		float m=in.nextInt();
		float n=in.nextInt();
		float sum=0;
		for(int i=1;i<=n;i++){
			m/=2;
			sum+=(m*2);
			if(i==n){
				sum=sum+1000-m*2;
			}
	}
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.print(df.format(m)+" "+df.format(sum));
	}
}
