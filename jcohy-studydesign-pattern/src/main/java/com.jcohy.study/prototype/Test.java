package com.jcohy.study.prototype;

public class Test {
	public static void main(String[] args) {
		Prototype pro = new ConcretePrototype("��ƭ��");
		Prototype pro1=(Prototype) pro.clone();
		System.out.println(pro.getName());
		System.out.println(pro1.getName());
	}
}
