package com.jcohy.study.ViewQuestion.baseQuestion;
import java.util.Scanner;


public class MonkeyEat {
//ºï×Ó³ÔÌÒÎÊÌâ
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
