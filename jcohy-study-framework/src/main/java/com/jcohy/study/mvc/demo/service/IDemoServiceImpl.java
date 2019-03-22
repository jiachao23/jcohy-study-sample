package com.jcohy.study.mvc.demo.service;

import com.jcohy.study.mvc.mvcframework.annotation.JcohyService;

/**
 * Created by jiac on 2019/3/21.
 * ClassName  : com.jcohy.study.mvc.demo.service
 * Description  :
 */
@JcohyService
public class IDemoServiceImpl implements DemoService {

    @Override
    public String show(String name) {
        String result = "my name is "+name;
        System.out.println(result);
        return result;
    }
}
