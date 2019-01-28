package com.jcohy.study.arrays;

public class PolyAdd {
	/*
	 * 多项式在数组中的表示方式（n次多项式。例如P(x)=2*x^5+3*x^4+5*x^2+4*x+1为5次多项式。）
	 * 1.使用一个n+2长度的一维数组存放，数组的第一个位置存储最大指数n，其他位置按照指数n递减，
	 * 一次存储对应关系。
	 * A{5,2,3,0,5,4,1}
	 * 2.只存储多项式中非零项目，如果有m个非零项，则使用长度为2m+1的数组来存储，数组第一个
	 * 元素为非零项的个数
	 * A{5,2,5,3,4,5,2,4,1,1,0}
	 */
	public static void main(String[] args) {
		int[] PolyA={4,3,7,0,6,2};
		int[] PolyB={4,1,5,2,0,9};
		System.out.print("多项式A=> ");
		printPoly(PolyA);
		System.out.print("多项式B=> ");
		printPoly(PolyB);
		PolySum(PolyA,PolyB);
	}
	private static void PolySum(int[] polyA, int[] polyB) {
		int[] result=new int[polyA[0]+2];
		result[0]=polyA[0];
		for(int i=1;i<result.length;i++){
			result[i]=polyA[i]+polyB[i];
		}
		System.out.print("A加B的和为=>");
		printPoly(result);
	}
	private static void printPoly(int[] poly) {
		int MaxExp;
		MaxExp=poly[0];
		//循环次数
		for(int i=1;i<=poly[0]+1;i++){
			MaxExp--;
			if(poly[i]!=0){//如果该式为零就跳过
				if((MaxExp+1)!=0){
					System.out.print(poly[i]+"x^"+(MaxExp+1));
				}else{
					System.out.println(poly[i]);
				}
				if(MaxExp>=0){
					System.out.print("+");
				}
			}
		}
		System.out.println();
		
	}
}
