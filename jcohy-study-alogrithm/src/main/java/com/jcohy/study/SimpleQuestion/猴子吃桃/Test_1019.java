package com.jcohy.study.SimpleQuestion.���ӳ���;

import java.util.Scanner;


public class Test_1019 {
//���ӳ�������
	public static void main(String[] agrs){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int count=1;
		for(int i=2;i<=n;i++){
			count=(count+1)*2;
		}
		System.out.println(count);
	}
}
