package com.jcohy.study.SimpleQuestion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hanoiCode{
	public static void main(String[] args) throws IOException {
		int j;
		String str;
		BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入盘子的数量");
		str=keyin.readLine();
		j=Integer.parseInt(str);
		hanoi(j,1,2,3);
	}

	private static void hanoi(int n, int p1, int p2, int p3) {
		// TODO Auto-generated method stub
		if(n==1){
			System.out.println("盘子从"+p1+"移到"+p3);
		}
		else{
			hanoi(n-1,p1,p3,p2);
			System.out.println("盘子从"+p1+"移到"+p3);
			hanoi(n-1,p2,p1,p3);
		}
	}
}
