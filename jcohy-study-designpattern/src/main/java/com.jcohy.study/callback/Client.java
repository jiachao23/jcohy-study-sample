package com.jcohy.study.callback;

/**
 * 客户端
 * @author jiachao
 *
 */
public class Client implements CallBack {

	/** 
     * Client类 包含 Service类 的引用 (条件二)  因为Client要调用Service中的方法 
     */  
    Service service = new Service();//可直接实例化或在构造函数或某个方法中进行实例化  
    /** 
     * 该方法用于请求Service调用Service中的方法 
     */  
    public void requrst(){  
        System.out.println("请求服务器调用服务器的方法"); 
        service.A(this);//传入当前对象也就是CallBack对象，因为Client实现类CallBack接口  
    }  
	@Override
	public void B(String result) {
		 System.out.println("服务器回调我的方法返回的结果是："+result);  
	}
	/* 
	 * 当你知道答案了再告诉我。
	 */
	@Override
	public void solve(String result) {
		
	}

}
