package com.jcohy.study.ViewQuestion.baseQuestion;
import java.util.Scanner;

/**
 * 判断一个数是不是素数
 * @author jiachao
 *
 */
public class SuShu {
  public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p=in.nextInt();
		if (isPrime(p)) {
			System.out.println("prime");
		}else {
			System.out.println("not prime");
		}
	}
	public static boolean isPrime(int p) {

		if (p < 2)
			return false;
		if (p == 2)
			return true;
		for (int i = 2; i * i <= p; i++) {
			if (p % i == 0) {
				return false;
			}
		}
		return true;

	}
}
