package com.jcohy.study.ViewQuestion.baseQuestion;

import java.util.Scanner;


public class Guess {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in );
		System.out.println("----------------------");
		System.out.println("                       ");
		System.out.println("请出拳  1，剪刀     2，石头       3 ，布");
		System.out.println("                        ");
		int person = in.nextInt();
		int computer=(int)(Math.random()*3)+1;
		String mark1="拳头";
		String mark2="拳头";
		switch(person){
		case 1:
			mark1="剪刀";
			break;
		case 2:
			mark1="石头";
			break;
		case 3:
			mark1="布";
			break;
		}
		switch(computer){
		case 1:
			mark2="剪刀";
			break;
		case 2:
			mark2="石头";
			break;
		case 3:
			mark2="布";
			break;
			default:
		}
		if(person==computer){
			System.out.println("你出的是"+mark1+"电脑出的是"+mark2+"\n这句是平局");
		}else if(person==1&&computer==2||person==2&&computer==3||person==3&&computer==1){
			System.out.println("你出的是"+mark1+"电脑出的是"+mark2+"\n你输了");
		}else if(person==1&&computer==3||person==2&&computer==1||person==3&&computer==2){
			System.out.println("你出的是"+mark1+"电脑出的是"+mark2+"\n你赢了");
		}

	}

}
