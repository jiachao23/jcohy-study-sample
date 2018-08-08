package com.jcohy.study;


import javax.jws.WebMethod;
import javax.jws.WebService;

/*
 * SEI: 
 */
@WebService
public interface HelloWS {

	@WebMethod
	public String sayHello(String name);
}
