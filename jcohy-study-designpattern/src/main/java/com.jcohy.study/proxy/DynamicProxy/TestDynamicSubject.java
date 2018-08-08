package com.jcohy.study.proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author jiachao
 * Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces,  InvocationHandler handler)
 *	loader:һ��ClassLoader���󣬶��������ĸ�ClassLoader�����������ɵĴ��������м���
 *	interfaces:һ��Interface��������飬��ʾ�����ҽ�Ҫ������Ҫ����Ķ����ṩһ��ʲô�ӿڣ�
 *		������ṩ��һ��ӿڸ�������ô���������������ʵ���˸ýӿ�(��̬)�������Ҿ��ܵ�������ӿ��еķ�����
 *	handler:һ��InvocationHandler���󣬱�ʾ���ǵ��������̬��������ڵ��÷�����ʱ��
 *		���������һ��InvocationHandler������
 */
public class TestDynamicSubject {
	public static void main(String[] args) {
		Realsubject realsubject =new Realsubject();
		InvocationHandler handler = new Poxysubject(realsubject);
		Class<?> clazz = handler.getClass();
//		System.out.println("handler.getClass:"+clazz);
//		System.out.println("Clazz.getClassLoader:"+clazz.getClassLoader());
//		System.out.println("realsubject.getIntterfce:"+realsubject.getClass().getInterfaces());
		subject sub = (subject) Proxy.newProxyInstance(clazz.getClassLoader(),realsubject.getClass().getInterfaces(),handler );
//		System.out.println(sub.getClass());
		sub.Request();
		sub.rent();
		sub.sayHello("�Ҳ���");
	}
}
