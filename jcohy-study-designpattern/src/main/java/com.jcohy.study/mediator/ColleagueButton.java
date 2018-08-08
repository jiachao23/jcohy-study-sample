package com.jcohy.study.mediator;

import java.awt.*;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class ColleagueButton extends Button implements Colleague {
	

	private Mediator mediator;
	
	
	public ColleagueButton(String caption) {
		super(caption);
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		//Mediator指示有效、无效
		setEnabled(enabled);
	}

}
