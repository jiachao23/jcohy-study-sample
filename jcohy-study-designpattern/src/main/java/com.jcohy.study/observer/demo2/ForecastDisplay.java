package com.jcohy.study.observer.demo2;

/**
 * Created by jiac on 2019/3/15.
 * ClassName  : com.jcohy.study.observer.demo2
 * Description  :
 */
public class ForecastDisplay implements Observer,DisplayElement {

    Subject weatherData;
    private float temperature;
    private float humidity;
    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.register(this);
    }
    @Override
    public void display() {

    }

    @Override
    public void update(float temperature, float humidity, float pressure) {

    }
}
