package com.jcohy.study.ViewQuestion.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommonDivisor {

	/**
	 * ��Ŀ����������������m��n���������Լ������С��������
	 * ����շ����
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int m = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
//			System.out.println(commonDivisor(m,n));
			int divisor  = commonDivisor(m, n);
			System.out.println("���Լ����"+divisor+"\n"+"��󹫱�����"+m*n/divisor);
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
