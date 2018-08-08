package com.jcohy.study.ViewQuestion.baseQuestion;
import java.lang.String;

/**
 * 
 * @author jiachao
 *	�����ļӼ�
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
		boolean flag = false; //Ϊtrueʱ��ʾ�������>=10  

				if(ch1.length == ch2.length) { //����������ĳ������  
					sum = new int[ch1.length+1]; //��ӽ���ĳ���Ϊ��һ����+1����Ϊ���λ��ӿ���>10  

					for(int i=ch1.length-1; i>=0; i--) { //�Ӹ�λ��ʼ���  
						if(flag) {  
							sum[i+1] = (int)(ch1[i] - '0') + (int)(ch2[i] - '0') + 1;  
						}  
						else {  
							sum[i+1] = (int)(ch1[i] - '0') + (int)(ch2[i] - '0');  
						}  
						flag = handleSumOverTen(sum, i, len); //������������Ƿ�>10  
					}  

					handleTopDigit(flag, sum); //�������λ  
					return sum;  
				}  
				else if(ch1.length > ch2.length) { //�����1�ĳ��ȴ�����2�ĳ���  
					sum = new int[ch1.length+1]; //����ĳ���Ϊ��1�ĳ���+1  

					for(int i=ch2.length-1; i>=0; i--) {  
						if(flag) {  
							sum[i+len+1] = (int)(ch1[i+len] - '0') + (int)(ch2[i] - '0') + 1;  
						}  
						else {  
							sum[i+len+1] = (int)(ch1[i+len] - '0') + (int)(ch2[i] - '0');  
						}  

						flag = handleSumOverTen(sum, i, len);  
					}  

					for(int i=ch1.length-ch2.length-1; i>=0; i--) { //������1�������λ��  
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
	 * ������������Ƿ�>10 
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
	 * �������λ 
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
