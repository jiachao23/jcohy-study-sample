package com.jcohy.study.callback;

/**
 * �ͻ���
 * @author jiachao
 *
 */
public class Client implements CallBack {

	/** 
     * Client�� ���� Service�� ������ (������)  ��ΪClientҪ����Service�еķ��� 
     */  
    Service service = new Service();//��ֱ��ʵ�������ڹ��캯����ĳ�������н���ʵ����  
    /** 
     * �÷�����������Service����Service�еķ��� 
     */  
    public void requrst(){  
        System.out.println("������������÷������ķ���"); 
        service.A(this);//���뵱ǰ����Ҳ����CallBack������ΪClientʵ����CallBack�ӿ�  
    }  
	@Override
	public void B(String result) {
		 System.out.println("�������ص��ҵķ������صĽ���ǣ�"+result);  
	}
	/* 
	 * ����֪�������ٸ����ҡ�
	 */
	@Override
	public void solve(String result) {
		
	}

}
