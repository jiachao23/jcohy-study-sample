package com.jcohy.study.callback;

/**
 * /** 
 * ���������ң���Ϊ��Ҫ�����Ҵ�����Ҫʵ��CallBack�ص��ӿںͽӿ��еĻص�������ʵ�� 
 * ��Ҫ��������������һ�����ʵķ���askQqstion(),�����ʵ�ͬʱҪ��Է����㣩ע��ص��ӿڣ�
 * ����֪���𰸵�ʱ�����������Ľӿ�ʵ�ַ��������õ��� 
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
				System.out.println("�ҵ�������:"+qusetion);
				you = new You(Me.this, qusetion);
				you.ReceiverQuestion();
			};
		}.start();
	}
	public void play(){  
        System.out.println("��ȥ����");  
    }  
	@Override
	public void solve(String result) {
		// TODO Auto-generated method stub
		System.out.println("������ҵĴ���--->"+result);  
	}

}
