package com.jcohy.study.SimpleQuestion;
import java.lang.String;

/**
 * 
 * @author jiachao
 *	大数的加减
 */
public class BigData {  
	public static void main(String[] args) {  
		int[] result = bigNumSum("999999999999999", "99999999999999999");  
		for(int i=0; i < result.length; i++) {  
			System.out.print(result[i]);  
		}  
	}  

	public static int[] bigNumSum(String num1, String num2) {  
		String number1 = num1;  
		String number2 = num2;  
		char[] ch1 = number1.toCharArray();  
		char[] ch2 = number2.toCharArray();  
		int[] sum;  
		int len = Math.abs(ch1.length - ch2.length);  
		boolean flag = false; //为true时表示两数相加>=10  

				if(ch1.length == ch2.length) { //如果两个数的长度相等  
					sum = new int[ch1.length+1]; //相加结果的长度为任一长度+1，因为最高位相加可能>10  

					for(int i=ch1.length-1; i>=0; i--) { //从个位开始相加  
						if(flag) {  
							sum[i+1] = (int)(ch1[i] - '0') + (int)(ch2[i] - '0') + 1;  
						}  
						else {  
							sum[i+1] = (int)(ch1[i] - '0') + (int)(ch2[i] - '0');  
						}  
						flag = handleSumOverTen(sum, i, len); //处理两数相加是否>10  
					}  

					handleTopDigit(flag, sum); //处理最高位  
					return sum;  
				}  
				else if(ch1.length > ch2.length) { //如果数1的长度大于数2的长度  
					sum = new int[ch1.length+1]; //结果的长度为数1的长度+1  

					for(int i=ch2.length-1; i>=0; i--) {  
						if(flag) {  
							sum[i+len+1] = (int)(ch1[i+len] - '0') + (int)(ch2[i] - '0') + 1;  
						}  
						else {  
							sum[i+len+1] = (int)(ch1[i+len] - '0') + (int)(ch2[i] - '0');  
						}  

						flag = handleSumOverTen(sum, i, len);  
					}  

					for(int i=ch1.length-ch2.length-1; i>=0; i--) { //处理数1多出来的位数  
						if(flag) {  
							sum[i+1] = (int)(ch1[i] - '0') + 1;  
						}  
						else {  
							sum[i+1] = (int)(ch1[i] - '0');  
						}  
						flag = handleSumOverTen(sum, i, 0);  
					}  

					handleTopDigit(flag, sum);  
					return sum;  
				}  
				else {  
					sum = new int[ch2.length+1];  

					for(int i=ch1.length-1; i>=0; i--) {  
						if(flag) {  
							sum[i+len+1] = (int)(ch1[i] - '0') + (int)(ch2[i+len] - '0') + 1;  
						}  
						else {  
							sum[i+len+1] = (int)(ch1[i] - '0') + (int)(ch2[i+len] - '0');  
						}  

						flag = handleSumOverTen(sum, i, len);  
					}  

					for(int i=ch2.length-ch1.length-1; i>=0; i--) {  
						if(flag) {  
							sum[i+1] = (int)(ch2[i] - '0') + 1;  
						}  
						else {  
							sum[i+1] = (int)(ch2[i] - '0');  
						}  
						flag = handleSumOverTen(sum, i, 0);  
					}  

					handleTopDigit(flag, sum);  
					return sum;  
				}  
	}  

	/* 
	 * 处理两数相加是否>10 
	 */  
	public static boolean handleSumOverTen(int[] sum, int i, int len) {  
		boolean flag = false;  
		if(sum[i+len+1] >= 10) {  
			sum[i+len+1] = sum[i+len+1] - 10;  
			flag = true;  
		}  
		else {  
			flag = false;  
		}  
		return flag;  
	}  

	/* 
	 * 处理最高位 
	 */  
	public static void handleTopDigit(Boolean flag, int[] sum) {  
		if(flag) {  
			sum[0] = 1;  
		}  
		else {  
			sum[0] = 0;  
		}  
	}  
}  
