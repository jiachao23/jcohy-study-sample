package com.jcohy.study.ViewQuestion.algorithm;

public class Global {

	/**��Ŀ��һ���100�׸߶��������£�ÿ����غ�����ԭ�߶ȵ�һ�룻�����£�
	 * ������ ��10�����ʱ�������������ף���10�η�����ߣ�
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
