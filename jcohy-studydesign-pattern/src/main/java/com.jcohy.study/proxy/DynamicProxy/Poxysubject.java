package com.jcohy.study.proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ��̬ Proxy ��������һ����:
 *�������������ɵ��࣬������ʱ������ṩһ�� Interface ������Ȼ��� class ������
 *��ʵ������Щ interface������԰Ѹ� class ��ʵ��������Щ interface �е��κ�һ��
 *���á���Ȼ����� Dynamic Proxy ��ʵ����һ�� Proxy��������������ʵ���ԵĹ�����
 *����������ʵ��ʱ������ṩһ�� handler�������ӹ�ʵ�ʵĹ�����
 *��ʹ�ö�̬������ʱ�����Ǳ���ʵ�� InvocationHandler �ӿ�
 * @author jiachao
 *
 */
public class Poxysubject implements InvocationHandler {
	private Object sub;

	/**
	 * @param sub
	 */
	public Poxysubject(Object sub) {
		this.sub = sub;
	}
	/**
	 * proxy:    ָ��������������Ǹ���ʵ����
	 * method:����ָ������������Ҫ������ʵ�����ĳ��������Method����
	 * args:����     ָ�����ǵ�����ʵ����ĳ������ʱ���ܵĲ���
	 */

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { 
		//�����ڴ�����ʵ����ǰ���ǿ������һЩ�Լ��Ĳ���
		System.out.println("before rent house");
		System.out.println("method:"+method+"  args:"+args );
//		System.out.println("Method:" + method);
		//	    ��������������ʵ����ķ���ʱ������Զ�����ת��������������handler�����invoke���������е���
		method.invoke(sub, args);
		//�����ڴ�����ʵ���������Ҳ�������һЩ�Լ��Ĳ���
		System.out.println("after rent house");
		System.out.println();
		return null;
	}

}
