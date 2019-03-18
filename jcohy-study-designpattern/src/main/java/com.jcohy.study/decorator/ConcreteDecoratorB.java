package com.jcohy.study.decorator;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class ConcreteDecoratorB extends Decorator {

	public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ConcreteDecoratorB类");
    }

    
}
