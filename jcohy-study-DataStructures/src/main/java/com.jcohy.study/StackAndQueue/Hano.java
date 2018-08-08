package com.study.dataStructures.StackAndQueue;

/**
 * ��ŵ�����⣬
 * �����޸Ĺ����������Ʋ��ܴ���������ֱ���ƶ������Ҳ࣬Ҳ���ܴ����Ҳൽ�����
 * ���Ǳ��뾭���м䡣����N����ʱ����ӡ�����ƶ����̺������ƶ��ܲ���
 * �ݹ�ķ�����ֻʣ�ϲ������������ƶ����������У��������ң��������ң����У����ݹ����ֹ����
 * 
 * ˼�룺
 * 1.���ֻʣN�㣬�����ϵ�����Ϊ1~N������ϣ��ȫ�����У���3����
 * 1.����1~N-1����ȫ�������ҡ�
 * 2.������N������ҡ�
 * 3.����1~N-1���ҵ���
 * 2.�����ʣ�µ�N�������е����е��ң��ҵ��С��������ͬ��
 * 3.�����ʣ�µ�N����������ϣ�����ҡ���5����
 * 1.����1~N-1����ȫ�������ҡ�
 * 2.����N���������С�
 * 3.����1~N-1����ҵ���
 * 4.����N���е��ҡ�
 * 5.����1~N-1������ҡ�
 * 4.�����ʣ�µ�N���������ң�ϣ������ͬ��
 * @author jiachao
 *
 */
public class Hano {
	public static int hanoi(int num,String left,String mid,String right){
		if(num<1)
			return 0;
		return process(num,left,mid,right,left,right);
	}

	public static int process(int num, String left, String mid, String right,
			String from, String to) {
		if(num==1){
			if(from.equals(mid)||to.equals(mid)){
				System.out.println("�� 1 ��"+from+" �Ƶ�"+to);
				return 1;
			}else{
				System.out.println("�� 1 �� "+from+" �Ƶ� "+mid);
				System.out.println("�� 1 �� "+mid+" �Ƶ� "+to);
				return 2;
			}
		}
		if(from.equals(mid)||to.equals(mid)){
			String another = (from.equals(mid)||to.equals(mid))?right:left;
			int part1=process(num-1,left,mid,right,from,another);
			int part2=1;
			int part3=process(num-1, left, mid, right, another, to);
			return part1+part2+part3;
		}
		else{
			int part1=process(num-1, left, mid, right, from, to);
			int part2 =1;
			System.out.println("�� "+num+" �� "+from+ " �Ƶ� "+mid);
			int part3=process(num-1, left, mid, right, to, from);
			int part4=1;
			System.out.println("�� "+num+" �� "+mid+ " �Ƶ� "+to);
			int part5=process(num-1, left, mid, right, from, to);
			return part1+part2+part3+part4+part5;
		}
	}
	public static void main(String[] args) {
		long start= System.currentTimeMillis();
		int result=hanoi(11,"��","��","��");
		long end= System.currentTimeMillis();
		long time=end-start;
		System.out.println("һ������ "+result+"����������"+time+"����");
	}
}
