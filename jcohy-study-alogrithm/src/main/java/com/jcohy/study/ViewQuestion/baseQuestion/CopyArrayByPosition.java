package com.jcohy.study.ViewQuestion.baseQuestion;
import java.util.Scanner;

/**
 * ָ��λ�ø��ƣ���������������
 * ��һ�����鳤��
 * �ڶ��������ֵ
 * �������ӵڼ���λ�ÿ�ʼ����
 * @author jiachao
 *
 */
public class CopyArrayByPosition {
	public static void main(String[] agrs){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		String b=in.next();
		int m=in.nextInt();
		char[] str=b.toCharArray();
		char[] arr=new char[str.length-m+1];
		System.arraycopy(str, m-1, arr, 0,arr.length);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
	}
}
