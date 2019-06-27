package com.jcohy.study.SimpleQuestion;
import java.util.Scanner;

/**
 * 指定位置复制，接受三个参数。
 * 第一个数组长度
 * 第二个数组的值
 * 第三个从第几个位置开始复制
 * @author jiachao
 *
 */
public class CopyArrayByPosition {
	public static void main(String[] agrs){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		String b=in.next();
		int m=in.nextInt();
		char[] str=b.toCharArray();
		char[] arr=new char[str.length-m+1];
		System.arraycopy(str, m-1, arr, 0,arr.length);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
	}
}
