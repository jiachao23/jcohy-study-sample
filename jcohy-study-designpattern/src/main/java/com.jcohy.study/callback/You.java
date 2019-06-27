package com.jcohy.study.callback;
/**
 * @author jiachao
 *
 */
public class You {
	
	private CallBack callback;
	public  You(CallBack callback,String qusetion){
		this.callback = callback;
	}
	public void ReceiverQuestion(){
		
		new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(500);
					 String result = "答案就是我也不知道";      
					 callback.solve(result);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}
}
