package com.jcohy.study.callback;

/**
 * @author jiachao
 *
 */
public class Service {
	
	CallBack callback;//����ӿ����Ͷ���Ҫ���ýӿ��еĻص�����  
	  
    String result = "лл�������";  
  
    public void A(Client client) {  
        this.callback = client;  
        callback.B(result);//���õ��Ǹýӿڵ�ʵ�ַ�������Client�е�B��  
    }  
}
