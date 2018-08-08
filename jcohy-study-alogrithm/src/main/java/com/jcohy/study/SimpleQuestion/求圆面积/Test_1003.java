package com.jcohy.study.SimpleQuestion.ÇóÔ²Ãæ»ý;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test_1003 {
	private static final float Pi=(float) 3.14;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		float r=in.nextFloat();
		float h=in.nextFloat();
		float C1;
		float Sa;
		float Sb;
		float Va;
		float Vb;	
		C1=2*Pi*r;
		Sa=Pi*r*r;
		Sb=4*Sa;
		Va=Pi*r*r*r*(float)4.0/(float)3.0;
		Vb=Pi*r*r*h;
		System.out.println("C1="+twoNumber(C1));
		System.out.println("Sa="+twoNumber(Sa));
		System.out.println("Sb="+twoNumber(Sb));
		System.out.println("Va="+twoNumber(Va));
		System.out.println("Vb="+twoNumber(Vb));
	}
	public static float twoNumber(float f){
		DecimalFormat decimalFormat=new DecimalFormat(".00");
		String s= decimalFormat.format(f);
		f=Float.parseFloat(s);
		return f;
	}
	

}
