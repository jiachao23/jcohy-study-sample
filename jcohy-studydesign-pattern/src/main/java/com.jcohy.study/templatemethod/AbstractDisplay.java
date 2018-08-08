package com.jcohy.study.templatemethod;

public abstract class AbstractDisplay {
	public abstract void open();
	public abstract void close();
	public abstract void print();
	public void dispay() {
		open();
		for(int i=0;i<5;i++) {
			print();
		}
		close();
	}
}
