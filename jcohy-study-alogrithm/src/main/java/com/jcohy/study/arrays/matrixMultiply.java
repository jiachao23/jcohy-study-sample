package com.jcohy.study.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class matrixMultiply {
	/*
	 * �������
	 */
    private static void MatrixMultiply(int[][] arrA, int[][] arrB, int[][] arrC, int m,
            int n, int p) {
        if(m<=0||n<=0||p<=0){
            System.out.println("�������n��m��p�������0");
            return;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<p;j++){
                int  temp=0;
                for(int k=0;k<n;k++){
                    temp=temp+arrA[i][k]*arrB[k][j];
                    arrC[i][j]=temp;
                }
            }
        }
    }
    public static void main(String[] args) throws  IOException {
        int m,n,p;
        int i,j;;
        String temp;//�������վ��������ֵ
        BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("���������A��ά��(m,n)");
        System.out.println("�����������A��mֵ");
        m=Integer.parseInt(keyin.readLine());
        System.out.println("�������������A��nֵ");
        n=Integer.parseInt(keyin.readLine());
        int[][] A = new int[m][n];
        System.out.println("���������A�ĸ���Ԫ��");
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.println("a"+i+j+"=");
                temp=keyin.readLine();
                A[i][j]=Integer.parseInt(temp);
            }
        }
        System.out.println("���������B��ά��(n,p)");
        System.out.println("�����������B��nֵ");
        n=Integer.parseInt(keyin.readLine());
        System.out.println("�������������B��pֵ");
        p=Integer.parseInt(keyin.readLine());
        int B[][]=new int[n][p];
        System.out.println("���������B�ĸ���Ԫ��");
        for(i=0;i<n;i++){
            for(j=0;j<p;j++){
                System.out.println("b"+i+j+"=");
                temp=keyin.readLine();
                B[i][j]=Integer.parseInt(temp);
            }
        }
        int[][] C=new int[m][p];
        MatrixMultiply(A,B,C,m,n,p);
        System.out.println("A��B��˽��Ϊ");
        for(i=0;i<m;i++){
            for(j=0;j<p;j++){
                System.out.print(C[i][j]+"\t");
            }
            System.out.println();
        }
    }
}