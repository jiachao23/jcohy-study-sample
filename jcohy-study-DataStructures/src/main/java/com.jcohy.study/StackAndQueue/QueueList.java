package com.jcohy.study.StackAndQueue;

//队列节点类
class QueueNode{
	int data;
	QueueNode next;
	public QueueNode(int data){
		this.data=data;
		next=null;
	}
};
//队列类
class Linked_List_Queue{
	public QueueNode front;//队列的前端指针
	public QueueNode rear;//队列的尾端指针
	public Linked_List_Queue(){
		front=null;
		rear=null;
	}
	//方法enqueue队列数据的存入
	public boolean enqueue(int value){
		QueueNode node=new QueueNode(value);
		//检查是否为空队列
		if(rear==null)
			front=node;//新建立的节点成为第一个节点
		else
		//讲节点加入队列的尾端
			rear.next=node;
		rear=node;//讲队列的尾端指针指向新加入的节点
		return true;

	}
	//方法dequeue队列数据的取出
	public int dequeue(){
		int value;
		//检查队列是否为空
		if(!(front==null)){
			if(front==rear)
				rear=null;
			value=front.data;//将队列的数据取出
			front=front.next;//将队列的前端指针指向下一个
			return value;	
		}
		return -1;
	}
}//队列类声明结束
public  class QueueList{
	public static void main(String[] args) {
		Linked_List_Queue queue=new Linked_List_Queue();
		int temp;
		System.out.println("以链表的方式实现");
		System.out.println("============================");
		System.out.println("在队列的前端加入第1个数据，此数值为1");
		queue.enqueue(1);
		System.out.println("在队列的前端加入第2个数据，此数值为3");
		queue.enqueue(3);
		System.out.println("在队列的前端加入第3个数据，此数值为5");
		queue.enqueue(5);
		System.out.println("在队列的前端加入第4个数据，此数值为7");
		queue.enqueue(7);
		System.out.println("在队列的前端加入第5个数据，此数值为9");
		queue.enqueue(9);
		System.out.println("============================");
		while(true){
			if(!(queue.front==null)){
				temp=queue.dequeue();
				System.out.println("从队列前端依序取出的元素为:"+temp);
			}
			else 
				break;
		}
		System.out.println();
	}
}















