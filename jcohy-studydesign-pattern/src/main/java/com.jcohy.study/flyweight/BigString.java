package com.jcohy.study.flyweight;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class BigString {
	private BigChar[] bigchars;
	public BigString(String string) {
		bigchars = new BigChar[string.length()];
		BigCharFactory factory = BigCharFactory.getInstance();
		for(int i=0;i<bigchars.length;i++) {
			bigchars[i] = factory.getBigChar(string.charAt(i));
			
		}
	}
	public void print() {
		for(int i=0;i<bigchars.length;i++) {
			bigchars[i].print();
		}
	}
}
