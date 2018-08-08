
package com.jcohy.study.decorator;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
/**
 * @author jiachao
 *定义一个对象，可以给这个对象添加职责
 */
public class ConcreteComponent implements Person{

	
	public void eat() {
		System.out.println("小伙子在吃");
	}

}
