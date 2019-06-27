package com.jcohy.study.arrays;

public class matrixAdd {
    /*
     * 两个矩阵相加
     * 
     */
    private static void MatrixAdd(int[][] arrayA, int[][] arrayB, int[][] arrayC, int x, int y) {
        // TODO Auto-generated method stub
        int row,col;
        if(x<=0||y<=0){
            System.out.println("矩阵维数必须大于0");
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
        //定义两个数组，即矩阵
        int[][] A={{1,3,5},{7,9,11},{13,15,17}};
        int[][] B={{9,8,7},{6,5,4},{3,2,1}};
        int[][] C=new int[ROWS][COLS];
        System.out.println("[矩阵A的各个元素]");//打印矩阵A的内容
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(A[i][j]+" \t");
            }
            System.out.println();
        }
        System.out.println("[矩阵B的各个元素]");//打印矩阵B的内容
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(B[i][j]+"\t");
            }
            System.out.println();
        }
        MatrixAdd(A,B,C,3,3);
        System.out.println("[矩阵A和B相加的结果]");//打印矩阵C的内容
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(C[i][j]+" \t");
            }
            System.out.println();
        }

    }   
}
