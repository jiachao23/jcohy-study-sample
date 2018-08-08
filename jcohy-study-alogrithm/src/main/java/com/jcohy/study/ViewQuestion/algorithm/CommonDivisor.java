package com.jcohy.study.ViewQuestion.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommonDivisor {

	/**
	 * 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
	 * 利用辗除法
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int m = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
//			System.out.println(commonDivisor(m,n));
			int divisor  = commonDivisor(m, n);
			System.out.println("最大公约数："+divisor+"\n"+"最大公倍数："+m*n/divisor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static int commonDivisor(int m, int n) {
//		if(m<0||n<0)
//			return -1;
//		if(n==0)
//			return m;
//		return commonDivisor(n,m%n);
		while(true){
			if((m=m%n)==0)
				return n;
			if((n=n%m)==0)
				return m;
		}
			
	}

}
