package com.jcohy.study.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class matrixZZ {

    public static void main(String[] args) throws  IOException {
        int m,n;
        int row,col;;
        String temp;//用来接收矩阵输入的值
        BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入m*n矩阵的维数(m,n)");
        System.out.println("请先输入矩阵维度的m:");
        m=Integer.parseInt(keyin.readLine());
        System.out.println("接下来输入矩阵维度的n:");
        n=Integer.parseInt(keyin.readLine());
        int A[][]=new int[m][n];
        int B[][]=new int[n][m];
        System.out.println("请输入矩阵的内容");
        for(row=1;row<=m;row++){
            for(col=1;col<=n;col++){
                System.out.println("a"+row+col+"=");
                temp=keyin.readLine();
                A[row-1][col-1]=Integer.parseInt(temp);
            }
        }

        System.out.println("输入的矩阵为:");
        for(row=1;row<=m;row++){
            for(col=1;col<=n;col++){
                System.out.print(A[row-1][col-1]+"\t");

            }
            System.out.println();
        }
        //进行转置的动作
        for(row=1;row<=n;row++){
            for(col=1;col<=m;col++){
                B[(row-1)][(col-1)]=A[(col-1)][(row-1)];
            }
        }
        System.out.println("转置矩阵为:");
        for(row=1;row<=n;row++){
            for(col=1;col<=m;col++){
                System.out.print(B[row-1][col-1]+"\t");
            }
            System.out.println();
        }
    }
}