package com.jcohy.study.webservice.webservice.server;


import com.jcohy.study.webservice.wbservice.HelloWSImpl;

import javax.xml.ws.Endpoint;


/*
 * fabuWeb Service
 */
public class ServerTest {

	public static void main(String[] args) {

		String address = "web://225.25.4.211:8080/hello1";
		Endpoint.publish(address , new HelloWSImpl());
		System.out.println("webservice 发布成功");
	}
}
