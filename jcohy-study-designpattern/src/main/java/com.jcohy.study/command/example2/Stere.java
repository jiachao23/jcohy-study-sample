package com.jcohy.study.command.example2;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.command.example2
 * Description  : 音响，具体接受者
 */
public class Stere {

    private String name;

    public Stere(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println(name+" Stere is on");
    }
    public void setCD(){
        System.out.println(name+" Stere is set for CD input");
    }
    public void setDVD(){
        System.out.println(name+" Stere setDVD");
    }
    public void setRadio(){
        System.out.println(name+" Stere setRAdio");
    }
    public void setVolume(int volume){
        System.out.println(name+" Stere Volume set to "+volume);
    }

    public void off(){
        System.out.println(name+" Stere is off");
    }
}
