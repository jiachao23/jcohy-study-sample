package com.jcohy.study.ViewQuestion.baseQuestion;
import java.util.Scanner;

//ͳ����ĸ�����֡��ո���������
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
		System.out.println("Ӣ����ĸ������"+charcount);
		System.out.println("���ָ�����"+number);  
		System.out.println("�ո������"+blank);  
		System.out.println("�����ַ�������"+other);          
	}  
}  


