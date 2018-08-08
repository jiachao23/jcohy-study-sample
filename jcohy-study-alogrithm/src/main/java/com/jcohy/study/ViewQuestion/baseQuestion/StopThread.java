package com.jcohy.study.ViewQuestion.baseQuestion;
import java.util.concurrent.TimeUnit;


/**
 * @author jiachao
 *
 */
public class StopThread {
private static boolean  stopRequestd;

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThrean=new Thread(new Runnable() {
			public void run() {
				int i=0;
				while(!stopRequestd)
					i++;
			}
		});
		backgroundThrean.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequestd=true;
	}

}
