package com.jcohy.study.observer;

/**
 * 实现Observer接口,以“数字”来表示观察到的数值
 * @author jiachao
 */
public class DigitObserver implements Observer{

	@Override
	public void update(NumberGenerator numberGenerator) {
		System.out.println("DigitObserver:"+numberGenerator.getNum());	
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
