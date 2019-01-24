package com.jcohy.study.arrays;

import java.io.IOException;

public class SparseMatrix {
	/*
	 * ϡ�����:һ�������д󲿷�Ԫ�ض�Ϊ0�����ɳ�Ϊ��ϡ����󡱡����ֱ��ʹ�ô�ͳ�Ķ�ά�������洢�������
	 * �ڴ�ռ�����˷ѣ��Ľ��ķ���Ϊ����ʽ��3-tuple��������:
	 *	25   0    0    32   0    -25         	  1    2    3                        
   	 *	0    33   77   0    0    0           0    6    6    6                              
	 *	0    0    0    55   0    0           1    1    1    25            
	 *	0    0    0    0    0    0          ѹ����Ϊ:2    1    4    32         
	 *	101  0    0    0    0    0           3    1    6    -25                       
	 *	0    0    0    38   0    0           4    2    2    33         
	 *										 5    2    3    77
	 *	A(0,1)=��ʾ�˾��������					 6    3    4    55
	 *	A(0,1)=��ʾ�˾��������					 7    5    1    101
	 *	A(0,3)=��ʾ�˾���ķ�����Ŀ��������			 8    6    3    38
	 *  ���ڴ�����ʽ���ݽṹ��ѹ��ϡ�����ķ��������Լ����ڴ�Ĳ���Ҫ���˷ѡ�
	 */
	public static void main(String[] args) throws  IOException {
		final int ROWS=8;//��������
		final int COLS=9;//��������
		final int NOTZERO=8;//����ϡ������в�Ϊ0����
		int i,j,rw,cl,nz;
		int temp=1;
		int[][] Sparse=new int[ROWS][COLS];//����ϡ�����
		int[][] Compress=new int[NOTZERO+1][3];//����ѹ������
		//��ϡ������Ԫ��ȫ��Ϊ0
		for(i=0;i<ROWS;i++){
			for(j=0;j<COLS;j++){
				Sparse[i][j]=0;
			}
		}
		
		nz=NOTZERO;
		for( i=1;i<nz+1;i++){
			rw=(int) (Math.random()*100);
			rw=rw%ROWS;
			cl=(int)(Math.random()*100);
			cl=cl%COLS;
			if(Sparse[rw][cl]!=0){
				nz++;//����ͬһԪ���趨������ֵ�����ѹ����������0
			}
			Sparse[rw][cl]=i;//�������ϡ������з����Ԫ��ֵ
		}
		System.out.println("��ӡ�����е�Ԫ��");
		for(i=0;i<ROWS;i++){
			for(j=0;j<COLS;j++){
				System.out.print(Sparse[i][j]+"");
			}
			System.out.println();
		}
		//��ʼѹ��ϡ�����
		Compress[0][0]=ROWS;
		Compress[0][1]=COLS;
		Compress[0][2]=NOTZERO;
		for(i=0;i<ROWS;i++){
			for(j=0;j<COLS;j++){
				if(Sparse[i][j]!=0){
					Compress[temp][0]=i;
					Compress[temp][1]=j;
					Compress[temp][2]=Sparse[i][j];
					temp++;
				}
			}
		}
		System.out.println("ϵ������ѹ���������Ϊ:");
		for(i=0;i<NOTZERO+1;i++){
			for(j=0;j<3;j++){
				System.out.print(Compress[i][j]+" ");
			}
			System.out.println();
		}
	}
}
