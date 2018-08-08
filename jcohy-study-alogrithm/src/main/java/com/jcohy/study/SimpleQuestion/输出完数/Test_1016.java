package com.jcohy.study.SimpleQuestion.Êä³öÍêÊı;

import java.util.Scanner;

public class Test_1016 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for (int i = 2; i <= N; i++) {
			getWanShu(i);
		}

	}
	private static void getWanShu(int N) {
		int a[] = new int[100];
		int count = 0;
		for (int i = 1; i < N; i++) {
			if(N%i==0){
				a[count]=i;
				count++;
			}
		}
		int sum = 0;
		for (int j = 0; j <= count; j++) {
			sum = sum + a[j];
		}
		if (sum == N) {
			System.out.print(N+" its factors are ");
			for (int i = 0; i <count; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
	}

}
