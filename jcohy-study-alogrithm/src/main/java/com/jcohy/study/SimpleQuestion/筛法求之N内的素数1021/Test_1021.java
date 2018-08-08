package com.jcohy.study.SimpleQuestion.筛法求之N内的素数1021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test_1021 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List list = new ArrayList();
		list.add("2");
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)){
				list.add(i);
			}
		}
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}
	}
	private static boolean isPrime(int num) {
		if(num <= 2 || num % 2 == 0)
			return false;
		for(int i = 3;i * i <= num;i += 2){
			if(num % i == 0)
				return false;
		}

		return true;
	}

}

