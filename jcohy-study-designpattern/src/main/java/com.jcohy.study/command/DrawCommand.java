package com.jcohy.study.command;

import java.awt.*;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class DrawCommand implements Command{
	private Drawable drawable;

	private Point point;

	public DrawCommand(Drawable drawable,Point point) {
		this.drawable = drawable;
		this.point = point;
	}

	public void execute() {
		drawable.draw(point.x, point.y);
	}

}