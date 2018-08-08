package com.jcohy.study;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author jiachao
 *
 */
public class TraditionalTimerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("bobming!");
			}
		}, 10000,2000);//十秒后第一次炸，然后每隔2秒炸一次
		while(true){
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
