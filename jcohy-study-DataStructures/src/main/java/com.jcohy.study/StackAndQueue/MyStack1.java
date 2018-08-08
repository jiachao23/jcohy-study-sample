package com.study.dataStructures.StackAndQueue;

import java.util.Stack;

public class MyStack1 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack1(){
		this.stackData= new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	/*
	 * ����ѹ�����
	 * ��ǰ����ΪnewNum,�Ƚ���ѹ��stackData��Ȼ���ж�stackMin�Ƿ�Ϊ��
	 * ���Ϊ�գ���newNumҲѹ��stackMin.
	 * �����Ϊ�գ���Ƚ�newNum��stackMin��ջ��Ԫ����һ����С
	 * ���newNumС�ڵ��ڡ���newNumҲѹ��stackMin
	 * ���stackMin��ջ��Ԫ��С����stackMin�в�ѹ���κ�Ԫ��
	 */
	public void push(int newNum){
		if(this.stackMin.isEmpty()){
			this.stackMin.push(newNum);
		}else if(newNum<=this.stackMin.peek()){
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}
	/*
	 * ���ݵ�������
	 * ����stackData�е���ջ��Ԫ�أ���Ϊvalue��Ȼ��Ƚϵ�ǰstackMin��ջ��Ԫ�غ�value��һ����С
	 * ��ѹ�����������֪�����������value��stackMinջ��Ԫ�ظ�С�������ֻ�ܴ��ڻ��ߵ���
	 * ��value����stackMin��ջ��Ԫ�أ�stackMin����ջ��Ԫ��
	 * ��value����stackMin��ջ��Ԫ�أ�stackMin������ջ��Ԫ��
	 */
	public int pop(){
		if(this.stackData.isEmpty())
			throw new RuntimeException("Your Stack Is Empty");
		int value = this.stackData.pop();
		if(value==this.getMin()){
			this.stackMin.pop();
		}
		return value;
	}
	public int getMin() {
		if(this.stackMin.isEmpty())
			throw new RuntimeException("Your Stack Is Empty");
		
		return this.stackMin.peek();
	}
	public static void main(String[] args) {
		MyStack1 ms = new MyStack1();
		ms.push(2);
		ms.push(1);
		ms.push(8);
		ms.push(3);
		System.out.println(ms.getMin());
	}
}
