package com.jcohy.study.callback;

/**
 * /** 
 * 这个类代表我，因为你要告诉我答案所以要实现CallBack回调接口和接口中的回调方法的实现 
 * 我要向你提问所以有一个提问的方法askQqstion(),在提问的同时要向对方（你）注册回调接口，
 * 当你知道答案的时候调用我里面的接口实现方法，最后得到答案 
 * @author jiachao
 *
 */
public class Me implements CallBack {

	@Override
	public void B(String result) {
	}
	
	private You you;
//	public Me(You you){
//		this.you=you;
//	}
	public void askQuestion(final String qusetion){
		new Thread(){
			public void run() {
				System.out.println("我的问题是:"+qusetion);
				you = new You(Me.this, qusetion);
				you.ReceiverQuestion();
			};
		}.start();
	}
	public void play(){  
        System.out.println("我去完了");  
    }  
	@Override
	public void solve(String result) {
		// TODO Auto-generated method stub
		System.out.println("你告诉我的答案是--->"+result);  
	}

}
