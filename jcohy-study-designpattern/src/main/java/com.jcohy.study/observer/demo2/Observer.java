package com.jcohy.study.observer.demo2;

/**
 * Created by jiac on 2019/3/15.
 * ClassName  : com.jcohy.study.observer.demo2
 * Description  :
 */
public interface Observer {
    void update(float temperature, float humidity, float pressure);
}
