package com.jcohy.study.command.example2;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.command.example2
 * Description  : 灯，具体接受者
 */
public class Light {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println(name+" is on");
    }

    public void off(){
        System.out.println(name+" is off");
    }
}
