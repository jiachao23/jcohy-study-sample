package com.jcohy.study.arrays;

public class matrixAdd {
    /*
     * �����������
     * 
     */
    private static void MatrixAdd(int[][] arrayA, int[][] arrayB, int[][] arrayC, int x, int y) {
        // TODO Auto-generated method stub
        int row,col;
        if(x<=0||y<=0){
            System.out.println("����ά���������0");
            return;
        }
        for(row=1;row<=x;row++){
            for(col=1;col<=y;col++){
                arrayC[(row-1)][(col-1)]=arrayA[(row-1)][(col-1)]+arrayB
                        [(row-1)][col-1];
            }
        }

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int i;
        int j;
        final int ROWS=3;
        final int COLS=3;
        //�����������飬������
        int[][] A={{1,3,5},{7,9,11},{13,15,17}};
        int[][] B={{9,8,7},{6,5,4},{3,2,1}};
        int[][] C=new int[ROWS][COLS];
        System.out.println("[����A�ĸ���Ԫ��]");//��ӡ����A������
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(A[i][j]+" \t");
            }
            System.out.println();
        }
        System.out.println("[����B�ĸ���Ԫ��]");//��ӡ����B������
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(B[i][j]+"\t");
            }
            System.out.println();
        }
        MatrixAdd(A,B,C,3,3);
        System.out.println("[����A��B��ӵĽ��]");//��ӡ����C������
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(C[i][j]+" \t");
            }
            System.out.println();
        }

    }   
}
