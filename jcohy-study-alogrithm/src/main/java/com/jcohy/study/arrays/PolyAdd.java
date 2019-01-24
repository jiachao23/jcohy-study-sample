package com.jcohy.study.arrays;

public class PolyAdd {
	/*
	 * ����ʽ�������еı�ʾ��ʽ��n�ζ���ʽ������P(x)=2*x^5+3*x^4+5*x^2+4*x+1Ϊ5�ζ���ʽ����
	 * 1.ʹ��һ��n+2���ȵ�һά�����ţ�����ĵ�һ��λ�ô洢���ָ��n������λ�ð���ָ��n�ݼ���
	 * һ�δ洢��Ӧ��ϵ��
	 * A{5,2,3,0,5,4,1}
	 * 2.ֻ�洢����ʽ�з�����Ŀ�������m���������ʹ�ó���Ϊ2m+1���������洢�������һ��
	 * Ԫ��Ϊ������ĸ���
	 * A{5,2,5,3,4,5,2,4,1,1,0}
	 */
	public static void main(String[] args) {
		int[] PolyA={4,3,7,0,6,2};
		int[] PolyB={4,1,5,2,0,9};
		System.out.print("����ʽA=> ");
		printPoly(PolyA);
		System.out.print("����ʽB=> ");
		printPoly(PolyB);
		PolySum(PolyA,PolyB);
	}
	private static void PolySum(int[] polyA, int[] polyB) {
		int[] result=new int[polyA[0]+2];
		result[0]=polyA[0];
		for(int i=1;i<result.length;i++){
			result[i]=polyA[i]+polyB[i];
		}
		System.out.print("A��B�ĺ�Ϊ=>");
		printPoly(result);
	}
	private static void printPoly(int[] poly) {
		int MaxExp;
		MaxExp=poly[0];
		//ѭ������
		for(int i=1;i<=poly[0]+1;i++){
			MaxExp--;
			if(poly[i]!=0){//�����ʽΪ�������
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
