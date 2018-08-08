package com.jcohy.study.ViewQuestion.algorithm;

import java.util.Stack;

public class ReverseStack {
	
	public int getAndRemoveLastNumber(Stack<Integer> stack){
		int result = stack.pop();
		if(stack.empty())
			return result;
		else {
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
		Stack stack = new Stack();
		ReverseStack rs = new ReverseStack();
		stack.push(3);
		stack.push(6);
		stack.push(1);
		stack.push(9);
		System.out.println(stack);
		rs.reverse(stack);
		System.out.println(stack);
	}
}
