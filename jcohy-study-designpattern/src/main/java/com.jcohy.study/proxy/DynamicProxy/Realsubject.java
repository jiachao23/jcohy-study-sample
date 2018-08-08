package com.jcohy.study.proxy.DynamicProxy;

/**
 * @author jiachao
 *
 */
public class Realsubject implements subject {

	@Override
	public void Request() {
		System.out.println("Relsubject");
	}
	@Override
	public void rent() {
		System.out.println("I want to rent my house");
	}
	@Override
	public void sayHello(String str) {
		System.out.println(str);
	}
}
