package com.jcohy.study.callback;

/**
 * �ص��ӿ�
 * @author jiachao
 *
 */
public interface CallBack {
	
	/** 
     * �����Service�ص�Client�ķ��� 
     * @param result �ص�ʱЯ���Ĳ�������ѡ�� 
     */  
    public void B(String result);
    
    /** 
     * ����֪���𰸿��Ե��øûص����������Ҵ� 
     * @param result �� 
     */  
    public void solve(String result); 
}
