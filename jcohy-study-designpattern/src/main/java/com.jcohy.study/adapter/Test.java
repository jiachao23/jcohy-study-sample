package com.jcohy.study.adapter;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class Test {
    public static void main(String[] args) {
        Target target = new Adapter();
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.request();

        // 使用特殊功能类，即适配类
        Target adapter = new Adapter();
        adapter.request();
        //使用对象的适配器模式。
        // 需要先创建一个被适配类的对象作为参数
        Target adapter2 = new Adapter2(new Adaptee());
        adapter2.request();
    }
}
