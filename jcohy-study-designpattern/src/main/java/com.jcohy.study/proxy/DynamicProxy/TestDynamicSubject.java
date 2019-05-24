package com.jcohy.study.proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author jiachao
 * Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces,  InvocationHandler handler)
 *	loader:一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
 *	interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，
 *		如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
 *	handler:一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，
 *		会关联到哪一个InvocationHandler对象上
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
		sub.sayHello("我不好");
	}
}
