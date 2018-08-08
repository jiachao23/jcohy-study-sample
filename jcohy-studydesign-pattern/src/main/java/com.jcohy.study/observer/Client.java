package com.jcohy.study.observer;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class Client {
	public static void main(String[] args) {
		NumberGenerator generator = new RandomNumberGenerator();
		Observer o1 = new DigitObserver();
		Observer o2 = new GraphObserver();
		generator.addObserver(o1);
		generator.addObserver(o2);
		generator.excuteNum();
	}
}
