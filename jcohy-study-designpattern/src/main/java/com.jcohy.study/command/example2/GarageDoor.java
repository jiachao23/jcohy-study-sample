package com.jcohy.study.command.example2;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.command.example2
 * Description  : GarageDoor 具体接受者
 */
public class GarageDoor {

    private String name;

    public GarageDoor(String name) {
        this.name = name;
    }


    public void on(){
        System.out.println(name+" GarageDoor is on !!");
    }

    public void off(){
        System.out.println(name+" GarageDoor is off !!");
    }
}
