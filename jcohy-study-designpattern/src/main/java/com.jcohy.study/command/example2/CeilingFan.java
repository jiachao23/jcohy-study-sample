package com.jcohy.study.command.example2;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.command.example2
 * Description  : 具体接受者。。吊扇
 */
public class CeilingFan {

    public static final int HIGH = 3;
    public static final int MIDLE = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    String Location;
    int speed;

    public CeilingFan(String location) {
        this.Location = location;
        this.speed = OFF;
    }

    public void higt(){
        this.speed = HIGH;
        System.out.println(Location +" CeilingFan is on high");
    }

    public void midle(){
        this.speed = MIDLE;
        System.out.println(Location +" CeilingFan is on midle");
    }

    public void low(){
        this.speed = LOW;
        System.out.println(Location +" CeilingFan is on low");
    }
    public void off(){
        this.speed = OFF;
        System.out.println(Location +" CeilingFan is on off");
    }
    public int getSpeed(){
        return speed;
    }

}
