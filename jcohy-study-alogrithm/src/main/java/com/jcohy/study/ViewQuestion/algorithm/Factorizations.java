package com.jcohy.study.ViewQuestion.algorithm;
/**
 * ��һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5��
�����������n���зֽ���������Ӧ���ҵ�һ����С������k��Ȼ������������ɣ�
(1)����������ǡ����n����˵���ֽ��������Ĺ����Ѿ���������ӡ�����ɡ�
(2)���n <> k����n�ܱ�k��������Ӧ��ӡ��k��ֵ������n����k����,��
Ϊ�µ���������,�ظ�ִ�е�һ����
(3)���n���ܱ�k����������k+1��Ϊk��ֵ,�ظ�ִ�е�һ���� 
 * @author jiachao
 *
 */
public class Factorizations {

	public static void main(String[] args) {
		Factorizations fa= new Factorizations();
		fa.fenjie(90);
			
	}
	private void fenjie(int n) {
		for(int i =2;i<n/2;i++){
				if(n%i==0){
					System.out.print(i+"*");
					n=n/i;
					fenjie(n);
				}
		}
		System.out.print(n);
        System.exit(0);///��������䣬�����������
	}

}
