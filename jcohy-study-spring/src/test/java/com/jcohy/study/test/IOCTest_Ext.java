package com.jcohy.study.test;

import com.jcohy.study.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class IOCTest_Ext {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(ExtConfig.class);
		
		
		//发布事件；
		applicationContext.publishEvent(new ApplicationEvent(new String("我发布的时间")) {
		});
		
		applicationContext.close();
	}

}
