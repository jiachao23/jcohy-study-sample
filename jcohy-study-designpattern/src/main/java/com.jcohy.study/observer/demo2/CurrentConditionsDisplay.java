package com.jcohy.study.observer.demo2;

/**
 * Created by jiac on 2019/3/15.
 * ClassName  : com.jcohy.study.observer.demo2
 * Description  :
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement {
    Subject weatherData;
    private float temperature;
    private float humidity;
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.register(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
