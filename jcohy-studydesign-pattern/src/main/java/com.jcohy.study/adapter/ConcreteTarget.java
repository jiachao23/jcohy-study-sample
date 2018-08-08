package com.jcohy.study.adapter;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class ConcreteTarget implements Target {
    public void request() {
        System.out.println("普通类 具有 普通功能...");
    }
}
