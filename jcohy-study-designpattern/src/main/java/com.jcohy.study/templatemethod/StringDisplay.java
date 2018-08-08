package com.jcohy.study.templatemethod;

public class StringDisplay extends AbstractDisplay {
	
	private String str;
	private int width;
	public StringDisplay(String str) {
		this.str = str;
		this.width = str.getBytes().length;
	}
	@Override
	public void open() {
		printLine();
	}

	private void printLine() {
		System.out.print("+");
		for(int i=0;i<width;i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}
	@Override
	public void close() {
		printLine();
	}

	@Override
	public void print() {
		System.out.println("|"+str+"|");
	}

}
