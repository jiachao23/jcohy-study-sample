package com.jcohy.study.ViewQuestion.algorithm;

public class shuzi {
	/**
	 * ��1��2��3��4�����֣�����ɶ��ٸ�������ͬ�����ظ����ֵ���λ�������Ƕ��٣�
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1;i<=4;i++){
			for (int j = 1; j <= 4; j++) {
				for (int k = 1; k <= 4; k++) {
					if(i!=j&&i!=k&&j!=k){
						sum++;
						System.out.println(i*100+j*10+k);
					}
				}
			}
		}
		System.out.println("���ж��٣�"+sum);
	}
}
