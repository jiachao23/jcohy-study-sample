package com.jcohy.study.proxy;


public class RealObjectImpl implements Object {

	
	@Override
	public void action() {
		System.out.println("这是被代理的类"+this.getClass());
	}
   
}
