package com.jcohy.study.proxy;


public class ProxyObject implements Object {
	Object obj;
    
	public ProxyObject(){
		System.out.println("���Ǵ������:"+this.getClass());
		obj= (Object) new RealObjectImpl();
	}
	@Override
	public void action() {
		System.out.println("����ʼ");
		obj.action();
		System.out.println("�������");
	}
}
