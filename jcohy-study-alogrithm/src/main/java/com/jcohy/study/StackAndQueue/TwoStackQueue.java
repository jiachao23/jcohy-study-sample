package com.jcohy.study.StackAndQueue;

import java.util.Stack;

public class TwoStackQueue {
	/**
	 * ������ջʵ��һ������,����֧�ֶ��еĻ���������add��poll��peek��
	 * @param args
	 */
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
		if(stackPop.empty()&&stackPush.empty()){
			throw new RuntimeException("Your Queue Is Empty");
		}else {
			if(stackPop.empty()){
				while(!stackPush.empty()){
					stackPop.push(stackPush.pop());
				}
			}
		}
		return stackPop.pop();
	}
	public int peek(){
		if(stackPop.empty()&&stackPush.empty()){
			throw new RuntimeException("Your Queue Is Empty");
		}else {
			if(stackPop.empty()){
				while(!stackPush.empty()){
					stackPop.push(stackPush.pop());
				}
			}
		}
		return stackPop.peek();
	}
	
	@Override
	public String toString() {
		return "Queue [stackPush=" + stackPush + ", stackPop="
				+ stackPop + "]";
	}
	public static void main(String[] args) {
		TwoStackQueue tsq = new TwoStackQueue();
		tsq.add(3);
		tsq.add(1);
		tsq.add(4);
		tsq.add(6);
		System.out.println(tsq.poll());
		System.out.println(tsq.peek());
	}

}
