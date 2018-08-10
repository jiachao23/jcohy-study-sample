package com.jcohy.study.springboot02.controller;


import com.jcohy.study.springboot02.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${person.last-name}")
    private String name;

    @Autowired
    private Person person;
    @RequestMapping("/sayHello")
    public String sayHello(){
        return "Hello "+name;
    }
    @RequestMapping("/person")
    public Person persion(){
        return person;
    }
}
