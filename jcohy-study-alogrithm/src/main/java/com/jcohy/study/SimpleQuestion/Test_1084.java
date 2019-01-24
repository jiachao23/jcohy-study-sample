package com.jcohy.study.SimpleQuestion;

import java.util.Scanner;

/**
 * 公约数个数
 */
public class Test_1084 {
	public static void main(String[] args) {
		long a ,b;
		int m = 0;
		Scanner in = new Scanner(System.in);
		long[] arr = new long[4];
		for (int i = 0; i < 4; i++) {
			arr[i] = in.nextLong();
		}
		for(int i = 0; i < 4; i+=2){
			 m=count(arr[i],arr[i+1]);	
			 System.out.println(m);
		}
		
	} 
	public static int count(long a, long b) {
		int count = 0;
		for (long i = 1; i <= a; i++) {
			if ((a % i) == 0) {
				if ((b % i) == 0) {
					count++;
					
				}
			}
		}
		return count;
	}
}
