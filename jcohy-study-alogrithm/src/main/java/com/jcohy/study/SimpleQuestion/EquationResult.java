package com.jcohy.study.SimpleQuestion;


import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * 求方程的根，用三个函数分别求当b^2-4ac大于0、等于0、和小于0时的根，并输出结果。
 * 从主函数输入a、b、c的值
 */
public class EquationResult {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		float a = in.nextFloat();
		float b = in.nextFloat();
		float c = in.nextFloat();
		float jugde = b * b - 4 * a * c;
		if (jugde > 0) {
			result1(a,b,jugde);

		} else if (jugde == 0) {
			result2(a,b);

		} else {
			result3(a,b,jugde);

		}
	}
	private static void result3(float a, float b, float jugde) {
		float x=-b/(2*a);
		String x1=saveTwoPoint((float) Math.sqrt(Math.abs(jugde))/(2*a))+"i";
		System.out.println("x1="+x+"+"+x1+" "+"x2="+x+"-"+x1);
	}

	private static void result2(float a, float b) {
		
		float x=-b/(2*a);
		System.out.println("x1="+x+" "+"x2="+x);
	}

	private static void result1(float a, float b, float jugde) {
		float x=-b/(2*a);
		String x1=saveTwoPoint((float) Math.sqrt(Math.abs(jugde))/(2*a));
		System.out.println("x1="+x+"+"+x1+" "+"x2="+x+"-"+x1);
		
	}
	public static String saveTwoPoint(double f){
		DecimalFormat df=new DecimalFormat("0.000");
		String s= df.format(f);
		return s;
	}

}
