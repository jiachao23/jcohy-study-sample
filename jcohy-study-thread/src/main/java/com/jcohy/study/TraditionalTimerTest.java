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
		}, 10000,2000);//ʮ����һ��ը��Ȼ��ÿ��2��ըһ��
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
