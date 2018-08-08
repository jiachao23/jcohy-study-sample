package com.jcohy.study.ViewQuestion.algorithm;

import java.util.Stack;

/*
 * 用两个栈实现一`个队列，支持队列的基本操作（add，poll，peek）
 */
public class TwoStackQueue {
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	public TwoStackQueue(){
		this.stackPush = new Stack<Integer>();
		this.stackPop = new Stack<Integer>();
	}
	
	public void add(int newNum){
		stackPush.push(newNum);
	}
	
	public int poll(){
		if(stackPop.empty()&&stackPush.empty())
			throw new RuntimeException("Your Queue Is Empty");
		else if(stackPop.empty()){
			while(!stackPush.empty()){
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	public int peek(){
		if(stackPop.empty()&&stackPush.empty())
			throw new RuntimeException("Your Queue Is Empty");
		else if(stackPop.empty()){
			while(!stackPush.empty()){
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
	
	public static void main(String[] args) {
		TwoStackQueue tsq = new TwoStackQueue();
		tsq.add(3);
		tsq.add(6);
		tsq.add(8);
		System.out.println(tsq.poll());//3
		System.out.println(tsq.peek());//6
	}
 }
