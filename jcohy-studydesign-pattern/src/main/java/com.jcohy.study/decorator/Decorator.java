package com.jcohy.study.decorator;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
/**
 * 维持一个指向Component对象的指针，并定义一个与Component接口一致的接口
 * @author admin
 *
 */
public abstract class Decorator implements Person{
	protected Person person;
	
	public void setPerson(Person person){
		this.person=person;
		
	}
	
	public void eat() {
		person.eat();
	}

}
