package com.jcohy.study.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class matrixZZ {

    public static void main(String[] args) throws  IOException {
        int m,n;
        int row,col;;
        String temp;//�������վ��������ֵ
        BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("������m*n�����ά��(m,n)");
        System.out.println("�����������ά�ȵ�m:");
        m=Integer.parseInt(keyin.readLine());
        System.out.println("�������������ά�ȵ�n:");
        n=Integer.parseInt(keyin.readLine());
        int A[][]=new int[m][n];
        int B[][]=new int[n][m];
        System.out.println("��������������");
        for(row=1;row<=m;row++){
            for(col=1;col<=n;col++){
                System.out.println("a"+row+col+"=");
                temp=keyin.readLine();
                A[row-1][col-1]=Integer.parseInt(temp);
            }
        }

        System.out.println("����ľ���Ϊ:");
        for(row=1;row<=m;row++){
            for(col=1;col<=n;col++){
                System.out.print(A[row-1][col-1]+"\t");

            }
            System.out.println();
        }
        //����ת�õĶ���
        for(row=1;row<=n;row++){
            for(col=1;col<=m;col++){
                B[(row-1)][(col-1)]=A[(col-1)][(row-1)];
            }
        }
        System.out.println("ת�þ���Ϊ:");
        for(row=1;row<=n;row++){
            for(col=1;col<=m;col++){
                System.out.print(B[row-1][col-1]+"\t");
            }
            System.out.println();
        }
    }
}