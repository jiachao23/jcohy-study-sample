package com.jcohy.study.webservice.wbservice;


import javax.jws.WebService;

/*
 * SEIµÄÊµÏÖ
 */
@WebService
public class HelloWSImpl implements HelloWS {

	public String sayHello(String name) {
		System.out.println("server sayHello()"+name);
		return "Hello " +name;
	}

}
