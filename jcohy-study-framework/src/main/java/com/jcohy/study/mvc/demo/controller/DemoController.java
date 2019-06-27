package com.jcohy.study.mvc.demo.controller;

import com.jcohy.study.mvc.demo.service.DemoService;
import com.jcohy.study.mvc.mvcframework.annotation.JcohyAutowired;
import com.jcohy.study.mvc.mvcframework.annotation.JcohyController;
import com.jcohy.study.mvc.mvcframework.annotation.JcohyRequestMapping;
import com.jcohy.study.mvc.mvcframework.annotation.JcohyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by jiac on 2019/3/21.
 * ClassName  : com.jcohy.study.mvc.demo.controller
 * Description  :
 */
@JcohyController
public class DemoController {

    @JcohyAutowired
    private DemoService demoService;
    @JcohyRequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response,@JcohyRequestParam("name") String name) throws IOException {
       String result =  demoService.show(name);
       response.getWriter().write(result);
    }
}
