package com.jcohy.study.ViewQuestion.baseQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * 输入一个数组，输出由数组中的这些数字 组成的最小的数字
 * @author jiachao
 *
 */
public class GetMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{851,581,518,158,815,185};
//		List<Integer> list = new ArrayList<Integer>();
//		
//		for(int i=0;i<arr.length;i++){
//			list.add(arr[i]);
//		}
		System.out.println(minNumFromIntArray(arr));
	}
	public static String minNumFromIntArray(int[] x){  
		String[] strs=stringsOf(x);  
		Arrays.sort(strs,new Comparator<String>(){  
			public int compare(String o1, String o2) {  
				int a=(o1+o2).compareTo(o2+o1);
				return a;  
			}  
		});
		
		for(String each:strs){  
			System.out.println(each);
		}  
		StringBuilder sb=new StringBuilder();  
		for(String each:strs){  
			sb.append(each);  
		}  
		return sb.toString();  
	}
	/**
	 * @param x
	 * @return
	 */
	 public static String[] stringsOf(int[] x){  
	        int len=x.length;  
	        String[] strs=new String[len];  
	        for(int i=0;i<len;i++){  
	            strs[i]=""+x[i];  
	        }  
	        return strs;  
	    }  

}
