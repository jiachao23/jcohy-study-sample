package com.jcohy.study.SimpleQuestion.n�Ľ׳�;

import java.util.Scanner;

//�׳����
public class Test_1013 {

	public static void main(String[] args) {
		System.out.println("������һ����Ч���֣�");
		Scanner in=new Scanner(System.in);
		long n=in.nextInt();
		jc(n);
	}
	private static void jc(long n) {
		// TODO Auto-generated method stub
		long sum=0;
		long jc=1;
		for(int i=1;i<=n;i++)
        {
          jc*=i;
          sum+=jc;
        }		
		System.out.println(sum);
	}
}

