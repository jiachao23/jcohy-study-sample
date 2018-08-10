package com.jcohy.study.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiac on 2018/8/10.
 * ClassName  : com.jcohy.study.springboot01.controller
 * Description  :
 */
@RestController
public class HelloController1 {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
