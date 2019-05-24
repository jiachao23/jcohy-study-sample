package com.jcohy.study.strategy;
/**
 * 
 * 定义支持所有算法的公共接口，context使用这个接口
 * 调用ConcreteStrategy定义的算法
 * @author admin
 *
 */
public abstract class  Strategy {

	public abstract void method();
}
