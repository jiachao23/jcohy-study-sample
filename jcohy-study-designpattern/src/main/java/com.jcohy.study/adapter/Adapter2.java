package com.jcohy.study.adapter;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class Adapter2 implements Target{
    // 直接关联被适配类
    private Adaptee adaptee;
    // 可以通过构造函数传入具体需要适配的被适配类对象
    public Adapter2 (Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    public void request() {
        // 这里是使用委托的方式完成特殊功能
        this.adaptee.specificRequest();
    }
}
