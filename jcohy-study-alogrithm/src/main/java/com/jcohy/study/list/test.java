package com.jcohy.study.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num;
		System.out.println("请输入五个数");
		LinkedList list=new LinkedList();
		for(int i=1;i<6;i++){
			num=Integer.parseInt(br.readLine());
			list.insert(num);
		}
		System.out.println("打印数");
		list.ReverseLinkedList();
		list.delete(new Node(1));
		list.print();
	}
}
