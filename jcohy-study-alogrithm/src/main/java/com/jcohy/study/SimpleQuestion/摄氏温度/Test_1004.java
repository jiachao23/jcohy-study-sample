package com.jcohy.study.SimpleQuestion.…„ œŒ¬∂»;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test_1004 {
	public static void main (String args[])	{
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		float b=5*(a-32)/9;
		DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("c="+df.format(b));
	}
}