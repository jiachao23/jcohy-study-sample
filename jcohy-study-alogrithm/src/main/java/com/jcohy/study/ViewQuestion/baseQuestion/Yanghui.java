package com.jcohy.study.ViewQuestion.baseQuestion;
import java.util.Scanner;

public class Yanghui {
	public static void main(String[] agrs){
		Scanner in=new Scanner(System.in);
		int count=in.nextInt();
		int[][] arr=new int[count][];
		//��ʼ�����顣
		for(int i=0;i<arr.length;i++){
			arr[i]=new int[i+1];
		}
		//��ʾ��Ϊÿ��Ԫ�ظ�ֵ
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				arr[i][0]=arr[i][i]=1;
			}
		}
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(i>1&&j>0&&j<i){
					arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
				}
			}
		}
		//����
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
