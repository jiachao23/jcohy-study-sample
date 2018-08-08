package com.jcohy.study.composite;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class Client {
	public static void main(String[] args) {
		
		System.out.println("Root directory");
		Directory rootDirectory = new Directory("root");
		Directory binDirectory = new Directory("bin");
		Directory tmpDirectory = new Directory("tmp");
		Directory usrDirectory = new Directory("usr");
		
		rootDirectory.add(binDirectory);
		rootDirectory.add(tmpDirectory);
		rootDirectory.add(usrDirectory);
		
		binDirectory.add(new File("vi.txt",100));
		binDirectory.add(new File("late.txt",100));
		
		rootDirectory.printList();
		
	}
}
