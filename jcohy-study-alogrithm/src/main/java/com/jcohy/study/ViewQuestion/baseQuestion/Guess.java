package com.jcohy.study.ViewQuestion.baseQuestion;

import java.util.Scanner;


public class Guess {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in );
		System.out.println("----------------------");
		System.out.println("                       ");
		System.out.println("���ȭ  1������     2��ʯͷ       3 ����");
		System.out.println("                        ");
		int person = in.nextInt();
		int computer=(int)(Math.random()*3)+1;
		String mark1="ȭͷ";
		String mark2="ȭͷ";
		switch(person){
		case 1:
			mark1="����";
			break;
		case 2:
			mark1="ʯͷ";
			break;
		case 3:
			mark1="��";
			break;
		}
		switch(computer){
		case 1:
			mark2="����";
			break;
		case 2:
			mark2="ʯͷ";
			break;
		case 3:
			mark2="��";
			break;
			default:
		}
		if(person==computer){
			System.out.println("�������"+mark1+"���Գ�����"+mark2+"\n�����ƽ��");
		}else if(person==1&&computer==2||person==2&&computer==3||person==3&&computer==1){
			System.out.println("�������"+mark1+"���Գ�����"+mark2+"\n������");
		}else if(person==1&&computer==3||person==2&&computer==1||person==3&&computer==2){
			System.out.println("�������"+mark1+"���Գ�����"+mark2+"\n��Ӯ��");
		}

	}

}
