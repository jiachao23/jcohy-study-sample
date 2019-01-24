package com.jcohy.study.arrays;

class Node{
	int x;
	int y;
	Node next;
	public Node(int x,int y){
		this.x=x;
		this.y=y;
		this.next=null;
	}
}

public class TraceRecord {
	public Node first;
	public Node last;
	public boolean isEmpty(){
		return first==null;
	}
	public void insert(int x,int y){
		Node newNode=new Node(x, y);
		if(this.isEmpty()){
			first=newNode;
			last=newNode;
		}else{
			last.next=newNode;
			last=newNode;
		}
	}
	public void delete(){
		Node newNode;
		if(this.isEmpty()){
			System.out.println("队列已经空了");
			return ;
		}
		newNode=first;
		while(newNode.next!=last){
			newNode=newNode.next;
		}
		newNode.next=last.next;
		last=newNode;
	}
}
