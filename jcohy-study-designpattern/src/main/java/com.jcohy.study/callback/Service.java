package com.jcohy.study.callback;

/**
 * @author jiachao
 *
 */
public class Service {
	
	CallBack callback;//定义接口类型对象，要调用接口中的回调方法  
	  
    String result = "谢谢你的请求";  
  
    public void A(Client client) {  
        this.callback = client;  
        callback.B(result);//调用的是该接口的实现方法（即Client中的B）  
    }  
}
