
package com.jcohy.study.ViewQuestion.paixu;
// =============== Program Description ===============
// 程序名称： CH08_04.java                               
// 程序目的：插入排序法
// ===================================================

import java.io.*;

public class CH08_04 extends Object {
    int data[] = new int[6];
    int size = 6;

    public static void main(String args[]) {
        CH08_04 test = new CH08_04();
        test.inputarr();
        System.out.print("您输入的原始数组是：");
        test.showdata();
        test.insert();
    }

    void inputarr() {
        int i;
        for (i = 0; i < size; i++)      //利用循环输入数组数据??
        {
            try {
                System.out.print("请输入第" + (i + 1) + "个元素：");
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                data[i] = Integer.parseInt(br.readLine());
            } catch (Exception e) {
            }
        }
    }

    void showdata() {
        int i;
        for (i = 0; i < size; i++) {
            System.out.print(data[i] + " ");   //打印数组数据
        }
        System.out.print("\n");
    }

    void insert() {
        int i;     //i为扫描次数
        int j;     //以j来定位比较的元素
        int tmp;   //tmp用来暂存数据
        for (i = 1; i < size; i++)  //扫描循环次数为SIZE-1
        {
            tmp = data[i];
            j = i - 1;
            while (j >= 0 && tmp < data[j])  //如果第二元素小于第一元素
            {
                data[j + 1] = data[j]; //就把所有元素往后推一个位置
                j--;
            }
            data[j + 1] = tmp;       //最小的元素放到第一个元素

            System.out.print("第" + i + "次比较：");
            showdata();
        }
    }

}
