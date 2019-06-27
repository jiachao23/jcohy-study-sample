package com.jcohy.study.decorator;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class ConcreteDecoratorA extends Decorator {

	public void eat() {
        super.eat();
        reEat();
        System.out.println("ConcreteDecoratorA类");
    }

    public void reEat() {
        System.out.println("再吃一顿饭");
    }

}
