package com.jcohy.study.SimpleQuestion;
import java.util.Scanner;

//统计字母。数字。空格，其他个数
public class TotalCharAndNumber {
	public static void main(String[] args) {  
		int number=0;  
		int charcount=0;  
		int other=0;  
		int blank=0;  
		Scanner sc=new Scanner(System.in);  
		String in=sc.nextLine();  
		char[] ch=in.toCharArray();          
		for(int i=0;i<ch.length;i++){  
			if(ch[i]>='0'&&ch[i]<='9'){  
				number++;  
			}else if((ch[i]>='a'&&ch[i]<='z')||ch[i]>='A'&&ch[i]<='Z'){  
				charcount++;  
			}else if(ch[i]==' '){  
				blank++;  
			}else{  
				other++;  
			}  
		}  
		System.out.println("英文字母个数："+charcount);
		System.out.println("数字个数："+number);  
		System.out.println("空格个数："+blank);  
		System.out.println("其他字符个数："+other);          
	}  
}  


