package com.jcohy.study.ViewQuestion.baseQuestion;

import java.util.Scanner;

public class RL{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("���������");
		int year=in.nextInt();
		System.out.println("�������·ݣ�");
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
		//����Ϊ 1 3 5 7 8 11
		break;
		case 2:
		if(i%4==0||i%400==0&&i%100!=0){
		day = 28;
		}else{
		day = 29;
		}
		break;
		//Ҳ��������Ŀ�㷨 day = i%4==0||i%400==0&&i%100!=0? 28: 29;
		// ���㷨һ��ֻ�����ж����� ���� ����Ҫ���ʺ�Ŷ
		default:
		day = 30;
		}
		if(i<month){
		sum+=day;
		}
		}
		int wekday=sum%7;
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
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

