package com.jcohy.study.mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class ColleagueCheckbox extends Checkbox implements ItemListener,Colleague {
	
	private Mediator mediator;
	
	public ColleagueCheckbox(String caption,CheckboxGroup group,boolean state) {
		super(caption,group,state);
	}
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		mediator.colleagueChanged(this);
	}

}
