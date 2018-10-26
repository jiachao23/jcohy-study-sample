package com.jcohy.study.StackAndQueue;

//���нڵ���
class QueueNode{
	int data;
	QueueNode next;
	public QueueNode(int data){
		this.data=data;
		next=null;
	}
};
//������
class Linked_List_Queue{
	public QueueNode front;//���е�ǰ��ָ��
	public QueueNode rear;//���е�β��ָ��
	public Linked_List_Queue(){
		front=null;
		rear=null;
	}
	//����enqueue�������ݵĴ���
	public boolean enqueue(int value){
		QueueNode node=new QueueNode(value);
		//����Ƿ�Ϊ�ն���
		if(rear==null)
			front=node;//�½����Ľڵ��Ϊ��һ���ڵ�
		else
		//���ڵ������е�β��
			rear.next=node;
		rear=node;//�����е�β��ָ��ָ���¼���Ľڵ�
		return true;

	}
	//����dequeue�������ݵ�ȡ��
	public int dequeue(){
		int value;
		//�������Ƿ�Ϊ��
		if(!(front==null)){
			if(front==rear)
				rear=null;
			value=front.data;//�����е�����ȡ��
			front=front.next;//�����е�ǰ��ָ��ָ����һ��
			return value;	
		}
		return -1;
	}
}//��������������
public  class QueueList{
	public static void main(String[] args) {
		Linked_List_Queue queue=new Linked_List_Queue();
		int temp;
		System.out.println("������ķ�ʽʵ��");
		System.out.println("============================");
		System.out.println("�ڶ��е�ǰ�˼����1�����ݣ�����ֵΪ1");
		queue.enqueue(1);
		System.out.println("�ڶ��е�ǰ�˼����2�����ݣ�����ֵΪ3");
		queue.enqueue(3);
		System.out.println("�ڶ��е�ǰ�˼����3�����ݣ�����ֵΪ5");
		queue.enqueue(5);
		System.out.println("�ڶ��е�ǰ�˼����4�����ݣ�����ֵΪ7");
		queue.enqueue(7);
		System.out.println("�ڶ��е�ǰ�˼����5�����ݣ�����ֵΪ9");
		queue.enqueue(9);
		System.out.println("============================");
		while(true){
			if(!(queue.front==null)){
				temp=queue.dequeue();
				System.out.println("�Ӷ���ǰ������ȡ����Ԫ��Ϊ:"+temp);
			}
			else 
				break;
		}
		System.out.println();
	}
}















