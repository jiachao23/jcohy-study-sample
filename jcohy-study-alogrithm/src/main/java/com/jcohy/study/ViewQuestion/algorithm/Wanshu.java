package com.jcohy.study.ViewQuestion.algorithm;

public class Wanshu {

	/**
	 * ��Ŀ��һ�������ǡ�õ�����������֮�ͣ�������ͳ�Ϊ
	 *  "���� "������6=1��2��3.��� �ҳ�1000���ڵ�����������
	 * @param args
	 */
	public static void main(String[] args) {
		int sum ;
		for (int i = 1; i <1000; i++) {
			sum=0;
			for (int j = 1; j <i; j++) {
				if(i%j==0)
					sum+=j;
			}
			if(sum == i)
				System.out.println(i+"");
		}	
		System.out.println();
	}

}
