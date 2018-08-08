package com.jcohy.study.arrays;

public class UpperTrangularMatrix {
	/*
	 * �����Ǿ���:����һ�ֶԽ������Ͻ�Ϊ0��n*n���������ַ�Ϊ�������Ǿ�����������Ǿ��󡣺�������
	 * ������ʽ����
	 * Ҳ�ɷ�Ϊ������Ϊ�����͡�����Ϊ�������������������Ǿ���Ϊ����
	 * ��A[i][j]������������Ӧ��kֵ��n*n����
	 * ����Ϊ����k=i*(i-1)/2+j;
	 * ����Ϊ��:k=n*(j-1)+i-j*(j-1)/2;
	 * ������һ��6*6���������Ǿ���A������Ϊ����Ӧ��һά����B������a32����ӦB(k)��kֵ���٣�
	 * k=n*(j-1)+i-j*(j-1)/2=6*(2-1)+3-2*(2-1)/2=8   a23=B(8)
	 * �������Ǿ���:
	 * ��A[i][j]������������Ӧ��kֵ��n*n����
	 * ����Ϊ����k=i*(i+1)/2+j-n;
	 * ����Ϊ��:k=j*(j+1)/2+i-n;
	 */
	public static void main(String[] args) {
		int[][] array={{76,0,0,0,0},
					   {54,51,0,0,0},
					   {23,8,26,0,0},
					   {43,35,28,18,0},
					   {12,9,14,35,46}};
		showArray(array);
		result(array);
	}

	private static void showArray(int[][] array) {
		System.out.println("�����Ǿ���");
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void result(int[][] array) {
	    int[] arr;
		int arrSize;
		int index=0;
		arrSize=array.length;
		arr=new int[arrSize*(arrSize+1)/2];
		for(int i=0;i<arrSize;i++){
			for(int j=0;j<arrSize;j++){
				if(array[i][j]!=0){
					arr[index++]=array[i][j];
					
				}
			}
		}
		System.out.println("����Ϊ��һά�����ʾΪ:");
		System.out.print("[");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("]");
	}
}
