package com.jcohy.study.strategy.demo2;

/**
 * Created by jiac on 2019/3/15.
 * ClassName  : com.jcohy.study.strategy.demo2
 * Description  :
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("QUACK!!");
    }
}
