package com.jcohy.study.proxy;


public class RealObjectImpl implements Object {

	
	@Override
	public void action() {
		System.out.println("���Ǳ��������"+this.getClass());
	}
   
}
