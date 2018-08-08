package com.jcohy.study.SimpleQuestion.打印水仙花数;

import java.util.Scanner;

public class Test_1015 {
	//所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身
	public static void main(String[] args) {
		int b1,b2,b3,n;
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		for(int m=101;m<n;m++){ 
			b3 =m/100;
			b2 =m%100/10;
			b1 =m%10;
			if((b3*b3*b3+b2*b2*b2+b1*b1*b1)==m){
				System.out.println(m);
			}
		}
	}
}
