package com.jcohy.study.list;
//ģ�������еĽڵ�
class Node{
	int data;
	Node next;
	public Node(int data){
		this.data=data;
		this.next=null;
	}
	
}
public class LinkedList {
	//��һ�����ڵ����͵Ľڵ�ָ�룬�ֱ�ָ������ĵ�һ���ڵ�����һ���ڵ㡣
	private Node first;
	private Node last;
	//�����ж�Ŀǰ�������Ƿ��ǿ�����
	public boolean isEmpty(){
		return first==null;
	}
	//������Ŀǰ�������ӡ����
	public void print(){
		Node current=first;
		while(current!=null){
			System.out.print("["+current.data+"]"+"\t");
			current=current.next;
		}
		System.out.println();
	}
	//����һ������
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
	//����ڵ�
	public void insert(Node ptr){
		//�ڵ�һ���ڵ����ڵ㡣1�����½ڵ��ָ��ָ���ͷ��2���ٰѱ�ͷ�Ƶ��½ڵ���
		//�����һ���ڵ����ڵ㡣1.�����һ���ڵ��ָ���Ƶ��½ڵ㡣��2.�ٰ��½ڵ�ָ��null��
		//���б��м�λ�ò���ڵ㡣�����X��Y�����ڵ㣬1��X�ڵ��ָ��ָ���½ڵ㣬2.�½ڵ��ָ��ָ��Y�ڵ㡣
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
	//�������ɾ��
	public void delete(Node delNode){
		//ɾ�������һ��ָ�룬ֻҪ���������ָ��ָ��ڶ����ڵ㼴�ɡ�
		//ɾ���������һ��ָ�롣ֻҪ��ָ�����һ���ڵ��ֵջָ��null���ɡ�
		//ɾ���м�ڵ㣬ֻ�轫ɾ���ڵ��ǰһ���ڵ��ָ�룬ָ��ɾ���ڵ����һ���ڵ㼴�ɡ�
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
		//��������ķ�ת����Ҫ����ָ�롣
		Node current=first;
		Node before=null;
		System.out.println("��ת����б�");
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
		//��������Ĵ���,ֻҪ���б����β�������ɡ�
		LinkedList ptr;
		ptr=head1;
		while(ptr.last.next!=null){
			ptr.last=ptr.last.next;
		}
		ptr.last.next=head2.first;
		return head1;
		
	}
}
