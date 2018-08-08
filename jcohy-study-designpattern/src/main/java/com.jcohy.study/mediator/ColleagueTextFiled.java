package com.jcohy.study.mediator;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class ColleagueTextFiled extends TextField implements TextListener,Colleague {
	
	private Mediator mediator;
	
	public ColleagueTextFiled(String text,int columns) {
		super(text,columns);
	}
	
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
		setBackground(enabled?Color.white:Color.LIGHT_GRAY);
	}

	@Override
	public void textValueChanged(TextEvent arg0) {
		//若字符串有变化，就通知Mediator
		mediator.colleagueChanged(this);
	}

}
