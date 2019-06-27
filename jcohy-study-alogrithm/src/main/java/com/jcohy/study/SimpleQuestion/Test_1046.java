package com.jcohy.study.SimpleQuestion;
import java.util.Scanner;


public class Test_1046 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		int last = baoshu(a);
		System.out.println(last);

	}

	private static int baoshu(int[] a) {
		int count = 0;
		int overTag = 0;
		int last=0;
		do {
			for (int i = 0; i < a.length; i++) {
				if (a[i] == 0) {
					count++;
					if (count % 3 == 0) {
						a[i] = 1;
						overTag++;
					}
					last=i;
				}
			}
		} while (overTag != a.length);
		return last+1;
	}

}
