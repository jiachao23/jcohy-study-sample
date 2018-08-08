package com.jcohy.study.decorator.example2;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public abstract class Border extends Display {

	protected Display display;//指装饰外框里面的内容

	public  Border(Display display) {
		this.display=display;
	}
}
