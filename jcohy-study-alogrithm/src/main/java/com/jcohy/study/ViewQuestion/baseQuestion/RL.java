package com.jcohy.study.ViewQuestion.baseQuestion;

import java.util.Scanner;

public class RL{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入年份");
		int year=in.nextInt();
		System.out.println("请输入月份：");
		int month=in.nextInt();
		int sum=0;
		int day=0;
		for(int i=1900;i<year;i++){
			if(i%4==0&&i%100!=0||i%400==0){
				sum+=366;
			}else{
				sum+=365;
			}
		}
		for(int i=1;i<=month;i++){
		switch(i){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 11:
		day = 31;
		//大月为 1 3 5 7 8 11
		break;
		case 2:
		if(i%4==0||i%400==0&&i%100!=0){
		day = 28;
		}else{
		day = 29;
		}
		break;
		//也可以用三目算法 day = i%4==0||i%400==0&&i%100!=0? 28: 29;
		// 此算法一般只用于判断俩个 条件 后面要加问号哦
		default:
		day = 30;
		}
		if(i<month){
		sum+=day;
		}
		}
		int wekday=sum%7;
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		for(int i=1;i<=wekday;i++){
			System.out.print("\t");
		}
		for(int i=1;i<=day;i++){
			if(sum%7==6){
				System.out.print(i+"\n");
			}else{
				System.out.print(i+"\t");
			}
			sum++;
		}
	}
}

