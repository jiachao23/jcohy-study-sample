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
					 String result = "�𰸾�����Ҳ��֪��";      
					 callback.solve(result);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}
}
