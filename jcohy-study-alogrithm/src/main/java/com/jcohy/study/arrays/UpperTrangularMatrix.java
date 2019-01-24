package com.jcohy.study.arrays;

public class UpperTrangularMatrix {
	/*
	 * 下三角矩阵:就是一种对角线以上皆为0的n*n矩阵，其中又分为右下三角矩阵和左下三角矩阵。和上三角
	 * 矩阵处理方式类似
	 * 也可分为“以行为主”和“以列为主”。下面以左下三角矩阵为例：
	 * 求A[i][j]在数组中所对应的k值，n*n矩阵。
	 * 以行为主：k=i*(i-1)/2+j;
	 * 以列为主:k=n*(j-1)+i-j*(j-1)/2;
	 * 假如有一个6*6的右上三角矩阵A，以列为主对应到一维数组B，请问a32所对应B(k)的k值多少？
	 * k=n*(j-1)+i-j*(j-1)/2=6*(2-1)+3-2*(2-1)/2=8   a23=B(8)
	 * 右下三角矩阵:
	 * 求A[i][j]在数组中所对应的k值，n*n矩阵。
	 * 以行为主：k=i*(i+1)/2+j-n;
	 * 以列为主:k=j*(j+1)/2+i-n;
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
		System.out.println("下三角矩阵");
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
		System.out.println("以行为主一维数组表示为:");
		System.out.print("[");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("]");
	}
}
