package com.jcohy.study.observer;

import java.util.Random;

/**
 * 产生随机数
 * @author jiachao
 */
public class RandomNumberGenerator extends NumberGenerator {
	Random rd = new Random();
	private int number = 0;
	@Override
	public int getNum() {
		return number;
	}
	@Override
	public void excuteNum() {
		for(int i=0;i<10;i++) {
			number = rd.nextInt(50);
			// TODO Auto-generated method stub
			notifyObservers();
		}
	}

}
