package com.jcohy.study.ViewQuestion.algorithm;
/**
 * ����ӡ�����е� "ˮ�ɻ��� "����ν "ˮ�ɻ��� "��ָһ����λ�������λ
 * ���������͵��ڸ����������磺153��һ�� "ˮ�ɻ��� "��
 * ��Ϊ153=1�����η���5�����η���3�����η���
 * @author jiachao
 *
 */
public class Shuixianhua {

	public static void main(String[] args) {
		int i=0;
		Shuixianhua mymath = new Shuixianhua();
		       for(i=100;i<=999;i++)
		           if(mymath.shuixianhua(i)==true)
		           System.out.println(i);
	}

	private boolean shuixianhua(int x) {
		int i=0,j=0,k=0;
		i=x/100;
		j=(x%100)/10;
		k=x%10;
		if(x==(i*i*i+j*j*j+k*k*k))
			return true;
		else
			return false;
	}

}
