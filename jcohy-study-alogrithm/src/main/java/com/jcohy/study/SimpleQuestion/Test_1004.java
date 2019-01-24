package com.jcohy.study.SimpleQuestion;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 华氏温度转摄氏温度
 */
public class Test_1004 {
	public static void main (String args[])	{
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		float b=5*(a-32)/9;
		DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("c="+df.format(b));
	}
}