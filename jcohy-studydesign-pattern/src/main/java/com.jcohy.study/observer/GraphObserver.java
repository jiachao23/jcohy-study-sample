package com.jcohy.study.observer;

/**
 * 实现Observer接口,以“*”来表示观察到的数值
 * @author jiachao
 */
public class GraphObserver implements Observer {

	@Override
	public void update(NumberGenerator numberGenerator) {
		System.out.println("GraphObserver:");
		int count = numberGenerator.getNum();
		for(int i=0;i<count;i++) {
			System.out.print("*");
		}
		System.out.println();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
