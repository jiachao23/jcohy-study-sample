package com.study.dataStructures.StackAndQueue;

import java.util.Stack;

/*
 * 利用递归函数实现一个栈的反转
 */
public class ReverseStack {
	//返回并移除栈底元素
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
