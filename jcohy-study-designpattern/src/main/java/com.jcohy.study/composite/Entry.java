package com.jcohy.study.composite;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public abstract class Entry {
	public abstract String getName();
	public abstract int getSize();
	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}
	
	public void printList() {
		printList("");
	}
	protected abstract void printList(String prefix);
	@Override
	public String toString() {
		return getName() + "(" + getSize() + ")";
	}
	
	
}
