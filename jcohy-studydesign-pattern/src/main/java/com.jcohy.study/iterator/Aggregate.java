package com.jcohy.study.iterator;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
/**
 * 一个执行递增的“聚合”，实现此接口的类就变成类似数组的“多个数字或者变量的聚合”
 * @author jiachao
 */
public interface Aggregate {
	public abstract Iterator iterator();
}
