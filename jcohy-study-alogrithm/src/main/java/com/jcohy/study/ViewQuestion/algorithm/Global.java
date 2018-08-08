package com.jcohy.study.ViewQuestion.algorithm;

public class Global {

	/**题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，
	 * 求它在 第10次落地时，共经过多少米？第10次反弹多高？
	 * @param args
	 */
	public static void main(String[] args) {
		 
		double height = 100;
		double sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum+=height;
			height =height/2;
			sum+=height;
		}
		System.out.println(height+" "+(sum+height));
	}
}
