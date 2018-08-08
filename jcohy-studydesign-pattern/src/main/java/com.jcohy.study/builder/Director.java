package com.jcohy.study.builder;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class Director {
    private Builder builder;

    public Director(Builder builder){
        this.builder=builder;
    }
    //建立文件
    public Object construct(){
        builder.makeTitle("Hello World！");
        builder.makeString("EveryDay!");
        builder.makeItems(new String[]{"hello morning","hello www"});
        builder.makeString("www.jcohy.com");
        builder.makeItems(new String[]{"welcome","to","my","wensite"});
        return builder.getResult();
    }
}
