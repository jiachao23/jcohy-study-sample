package com.study.dataStructures.StackAndQueue;

import java.util.Stack;

/*
 * ���õݹ麯��ʵ��һ��ջ�ķ�ת
 */
public class ReverseStack {
	//���ز��Ƴ�ջ��Ԫ��
	public int getAndRemoveLastNumber(Stack<Integer> stack){
		int result = stack.pop();
		if(stack.empty()){
			return result;
		}else{
			int last = getAndRemoveLastNumber(stack);
			stack.push(result);
			return last;
		}
	}
	public void reverse(Stack<Integer> stack){
		if(stack.isEmpty())
			return;
		int i = getAndRemoveLastNumber(stack);
		reverse(stack);
		stack.push(i);
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		ReverseStack rs = new ReverseStack();
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.push(6);
		System.out.println(stack);
		rs.reverse(stack);
		System.out.println(stack);
	}
}
