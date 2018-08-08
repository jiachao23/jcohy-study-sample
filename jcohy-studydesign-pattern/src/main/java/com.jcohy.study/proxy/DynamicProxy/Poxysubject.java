package com.jcohy.study.proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态 Proxy 是这样的一种类:
 *它是在运行生成的类，在生成时你必须提供一组 Interface 给它，然后该 class 就宣称
 *它实现了这些 interface。你可以把该 class 的实例当作这些 interface 中的任何一个
 *来用。当然，这个 Dynamic Proxy 其实就是一个 Proxy，它不会替你作实质性的工作，
 *在生成它的实例时你必须提供一个 handler，由它接管实际的工作。
 *在使用动态代理类时，我们必须实现 InvocationHandler 接口
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
	 * proxy:    指代我们所代理的那个真实对象
	 * method:　　指代的是我们所要调用真实对象的某个方法的Method对象
	 * args:　　     指代的是调用真实对象某个方法时接受的参数
	 */

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { 
		//　　在代理真实对象前我们可以添加一些自己的操作
		System.out.println("before rent house");
		System.out.println("method:"+method+"  args:"+args );
//		System.out.println("Method:" + method);
		//	    当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
		method.invoke(sub, args);
		//　　在代理真实对象后我们也可以添加一些自己的操作
		System.out.println("after rent house");
		System.out.println();
		return null;
	}

}
