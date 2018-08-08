package com.jcohy.study.decorator;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class Test {

	public static void main(String[] args) {
		ConcreteComponent person = new ConcreteComponent();
		ConcreteDecoratorA md1 = new ConcreteDecoratorA();
		ConcreteDecoratorB md2 = new ConcreteDecoratorB();
        
        md1.setPerson(person);
        md2.setPerson(md1);
        md2.eat();
	}

}
