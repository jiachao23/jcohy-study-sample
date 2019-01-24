package com.jcohy.study.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class matrixMultiply {
	/*
	 * 矩阵相乘
	 */
    private static void MatrixMultiply(int[][] arrA, int[][] arrB, int[][] arrC, int m,
            int n, int p) {
        if(m<=0||n<=0||p<=0){
            System.out.println("输入错误：n，m，p必须大于0");
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
        String temp;//用来接收矩阵输入的值
        BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入矩阵A的维数(m,n)");
        System.out.println("请先输入矩阵A的m值");
        m=Integer.parseInt(keyin.readLine());
        System.out.println("接下来输入矩阵A的n值");
        n=Integer.parseInt(keyin.readLine());
        int[][] A = new int[m][n];
        System.out.println("请输入矩阵A的各个元素");
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.println("a"+i+j+"=");
                temp=keyin.readLine();
                A[i][j]=Integer.parseInt(temp);
            }
        }
        System.out.println("请输入矩阵B的维数(n,p)");
        System.out.println("请先输入矩阵B的n值");
        n=Integer.parseInt(keyin.readLine());
        System.out.println("接下来输入矩阵B的p值");
        p=Integer.parseInt(keyin.readLine());
        int B[][]=new int[n][p];
        System.out.println("请输入矩阵B的各个元素");
        for(i=0;i<n;i++){
            for(j=0;j<p;j++){
                System.out.println("b"+i+j+"=");
                temp=keyin.readLine();
                B[i][j]=Integer.parseInt(temp);
            }
        }
        int[][] C=new int[m][p];
        MatrixMultiply(A,B,C,m,n,p);
        System.out.println("A和B相乘结果为");
        for(i=0;i<m;i++){
            for(j=0;j<p;j++){
                System.out.print(C[i][j]+"\t");
            }
            System.out.println();
        }
    }
}