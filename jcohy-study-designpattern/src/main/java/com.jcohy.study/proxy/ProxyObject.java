package com.jcohy.study.proxy;


public class ProxyObject implements Object {
	Object obj;
    
	public ProxyObject(){
		System.out.println("这是代理的类:"+this.getClass());
		obj= (Object) new RealObjectImpl();
	}
	@Override
	public void action() {
		System.out.println("代理开始");
		obj.action();
		System.out.println("代理结束");
	}
}
