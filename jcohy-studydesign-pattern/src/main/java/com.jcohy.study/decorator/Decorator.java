package com.jcohy.study.decorator;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
/**
 * ά��һ��ָ��Component�����ָ�룬������һ����Component�ӿ�һ�µĽӿ�
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
