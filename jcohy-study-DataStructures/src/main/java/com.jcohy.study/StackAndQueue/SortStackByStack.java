package com.jcohy.study.StackAndQueue;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 * @author jiachao
 *
 */
public class SortStackByStack {
	public static void sortStackByStack(Stack<Integer> stack){
		Stack<Integer> help = new Stack<Integer>();
		while(!stack.isEmpty()){
			int cur =  stack.pop();
			while(!help.isEmpty()&& help.peek()<cur){
				stack.push(help.pop());
			}
			help.push(cur);
		}
		while(!help.isEmpty()){
			stack.push(help.pop());
		}
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(2);
		stack.push(50);
		stack.push(15);
		stack.push(4);
		stack.push(60);
		System.out.println(stack);
		sortStackByStack(stack);
		System.out.println(stack);
	}
}
