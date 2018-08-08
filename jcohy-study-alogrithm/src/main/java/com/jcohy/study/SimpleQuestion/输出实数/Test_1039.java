package com.jcohy.study.SimpleQuestion.Êä³öÊµÊý;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test_1039 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		float a = in.nextFloat();
		String s=saveTwoPoint(a);
		System.out.print("  ");
		System.out.println(s);
		System.out.print("  ");
		for (int i = 0; i <2; i++) {
			System.out.print(s+"   ");
		}
		System.out.println();
		System.out.print("  ");
		for (int j = 0; j < 3; j++) {			
			System.out.print(s+"   ");
		}
	}
	public static String saveTwoPoint(float f) {
		DecimalFormat df = new DecimalFormat("0.00");
		String s = df.format(f);
		return s;
	}

}
