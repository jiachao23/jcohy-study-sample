package com.jcohy.study.ViewQuestion.paixu;

// =============== Program Description ===============
// �������ƣ� CH08_03.java                               
// ����Ŀ�ģ�ѡ������
// ===================================================

public class SelectionSort extends Object
{
	int data[]=new int[]{9,7,5,3,4,6};
	
	public static void main(String args[])
	{
		System.out.print("ԭʼ����Ϊ��");
		SelectionSort test=new SelectionSort();		
		test.showdata ();
		test.select ();
	}
	
	void showdata ()
	{
		int i;
		for (i=0;i<6;i++)
		{
			System.out.print(data[i]+" ");
		}
		System.out.print("\n");
	}
	
	void select ()
	{
		int i,j,tmp,k;
		for(i=0;i<5;i++)    	    //ɨ��5��
		{   
			for(j=i+1;j<6;j++)  //��i+1�Ƚ��𣬱Ƚ�5��
			{	
				if(data[i]>data[j])  //�Ƚϵ�i����j��Ԫ��??
				{	
					tmp=data[i];
					data[i]=data[j];
					data[j]=tmp;	
				}
			}
			System.out.print("��"+(i+1)+"����������");
	    	for (k=0;k<6;k++)
	    	{
	    		System.out.print(data[k]+" ");    //��ӡ������
	    	}
	    	System.out.print("\n");
	    }
	    System.out.print("\n");
	}
}
