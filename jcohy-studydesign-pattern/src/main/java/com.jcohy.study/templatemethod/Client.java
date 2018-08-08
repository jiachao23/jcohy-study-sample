package com.jcohy.study.templatemethod;

public class Client {
	public static void main(String[] args) {
		AbstractDisplay a = new CharDisplay('a');
		AbstractDisplay b =new StringDisplay("Hello world");
		a.dispay();
		b.dispay();
	}
}
