package com.jcohy.study.adapter;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
class Adapter extends Adaptee implements Target{
    public void request() {
        super.specificRequest();
    }
}