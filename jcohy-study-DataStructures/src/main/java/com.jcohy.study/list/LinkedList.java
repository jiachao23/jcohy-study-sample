package com.jcohy.study.list;
//模拟链表中的节点
class Node{
	int data;
	Node next;
	public Node(int data){
		this.data=data;
		this.next=null;
	}
	
}
public class LinkedList {
	//点一两个节点类型的节点指针，分别指向链表的第一个节点和最后一个节点。
	private Node first;
	private Node last;
	//用来判断目前的链表是否是空链表
	public boolean isEmpty(){
		return first==null;
	}
	//用来将目前的链表打印出来
	public void print(){
		Node current=first;
		while(current!=null){
			System.out.print("["+current.data+"]"+"\t");
			current=current.next;
		}
		System.out.println();
	}
	//构建一个链表
	public void insert(int data){
		Node newNode=new Node(data);
		if(this.isEmpty()){
			first=newNode;
			last=newNode;
		}else{
			last.next=newNode;
			last=newNode;
		}
		
	}
	//插入节点
	public void insert(Node ptr){
		//在第一个节点插入节点。1。吧新节点的指针指向表头，2，再把表头移到新节点上
		//在最后一个节点插入节点。1.把最后一个节点的指针移到新节点。上2.再把新节点指向null。
		//在列表中间位置插入节点。如果在X和Y间插入节点，1，X节点的指针指向新节点，2.新节点的指针指向Y节点。
		Node newNode;
		Node tmp;
		if(this.isEmpty()){
			first=ptr;
			last=ptr;
		}else{
			if(ptr.next==first){
				
			}
		}
	}
	//单链表的删除
	public void delete(Node delNode){
		//删除链表第一个指针，只要把链表的首指针指向第二个节点即可。
		//删除链表最后一个指针。只要将指向最后一个节点的值栈指向null即可。
		//删除中间节点，只需将删除节点的前一个节点的指针，指向删除节点的下一个节点即可。
		Node newNode;
		Node tmp ;
		
		if(first.data==delNode.data){
			first=first.next;
		}else if(last.data==delNode.data){
			newNode=first;
			while(newNode.next!=last){
				newNode=newNode.next;
			}
			newNode.next=last.next;
			last=newNode;
		}else{
			newNode=first;
			tmp=first;
			if(newNode.data!=delNode.data){
				tmp=newNode;
				newNode=newNode.next;
			}
			tmp.next=newNode.next;
		}
	}
	public void ReverseLinkedList(){
		//单向链表的反转。需要三个指针。
		Node current=first;
		Node before=null;
		System.out.println("反转后的列表");
		while(current!=null){
			last=before;
			before=current;
			current=current.next;
			before.next=last;
		}
		current=before;
		while(current!=null){
			System.out.print("["+current.data+"]"+"\t");
			current=current.next;
		}
		System.out.println();
	}
	public LinkedList Concatenate(LinkedList head1,LinkedList head2){
		//单向链表的串联,只要将列表的首尾相连即可。
		LinkedList ptr;
		ptr=head1;
		while(ptr.last.next!=null){
			ptr.last=ptr.last.next;
		}
		ptr.last.next=head2.first;
		return head1;
		
	}
}
