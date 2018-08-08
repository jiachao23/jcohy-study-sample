package com.jcohy.study.ViewQuestion.paixu;
// =============== Program Description ===============
// �������ƣ� CH08_05.java                               
// ����Ŀ�ģ�ϣ������
// ===================================================
import java.io.*;

public class ShellSort extends Object
{
	int data[]=new int[8];
	int size=8;	
	
	public static void main(String args[])
	{ 		
		ShellSort test =  new ShellSort();
		test.inputarr();		
		System.out.print("�������ԭʼ�����ǣ�");
		test.showdata();
		test.shell();
	}

	void inputarr()
	{
		int i=0;
		for (i=0;i<size;i++)
		{ 
			System.out.print("�������"+(i+1)+"��Ԫ�أ�");
			try{				
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				data[i]=Integer.parseInt(br.readLine());
			}catch(Exception e){}
		}
	}

	void showdata()
	{
		int i=0;		
		for (i=0;i<size;i++)
		{
			System.out.print(data[i]+" ");
		}
		System.out.print("\n");
	}
	
	void shell()
	{  
		int i;        //iΪɨ�����
		int j;        //��j����λ�Ƚϵ�Ԫ��
		int k=1;      //k��ӡ����
		int tmp;      //tmp�����ݴ�����
		int jmp;      //�趨���λ����

		jmp=size/2;
		while (jmp != 0)
		{  
			for (i=jmp ;i<size ;i++)
			{  
				tmp=data[i];
				j=i-jmp;
				while(j>=0 && tmp<data[j])  //��������
				{  
					data[j+jmp] = data[j];
					j=j-jmp;
				}	
				data[jmp+j]=tmp;				
			}
			
			System.out.print("��"+ (k++) +"������");			
			showdata();
			jmp=jmp/2;    //����ѭ����
		}
        }
}
