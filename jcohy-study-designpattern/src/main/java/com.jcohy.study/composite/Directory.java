package com.jcohy.study.composite;

import java.util.Iterator;
import java.util.Vector;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class Directory extends Entry {
	
	private String name;
	private Vector<Entry> directory = new Vector<Entry>();
	
	public Directory(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		int size = 0;
		Iterator<Entry> it = directory.iterator();
		while(it.hasNext()) {
			Entry entry  = (Entry)it.next();
			size+=entry.getSize();
		}
		return size;
	}

	@Override
	protected void printList(String prefix) {
		System.out.println(prefix+"/"+this);
		Iterator<Entry> it = directory.iterator();
		while(it.hasNext()) {
			Entry entry  = (Entry)it.next();
			entry.printList(prefix+"/"+name);
		}
	}
	public Entry add(Entry entry) {
		directory.add(entry);
		return this;
	}
	
}
