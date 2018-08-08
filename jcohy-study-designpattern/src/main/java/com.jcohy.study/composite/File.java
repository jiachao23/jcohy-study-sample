package com.jcohy.study.composite;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class File extends Entry {
	private String name;
	private int size;
	
	
	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	protected void printList(String prefix) {
		System.out.println(prefix+"/"+this);
	}

}
