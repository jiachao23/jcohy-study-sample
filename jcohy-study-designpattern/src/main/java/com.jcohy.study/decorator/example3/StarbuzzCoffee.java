package com.jcohy.study.decorator.example3;

/**
 * Created by jiac on 2019/3/15.
 * ClassName  : com.jcohy.study.decorator.example3
 * Description  :
 */
public class StarbuzzCoffee {
    public static void main(String args[]) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()
                + " $" + beverage.cost());
        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()
                + " $" + beverage2.cost());
        Beverage beverage3 = new Soy(
                new Mocha(
                        new Whip(
                                new HouseBlend())));
        System.out.println(beverage3.getDescription()
                + " $" + beverage3.cost());
    }
}
