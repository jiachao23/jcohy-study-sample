package com.jcohy.study.command;

import java.awt.*;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class DrawCanvas extends Canvas implements Drawable {
	private static final long serialVersionUID = 1L;
	private Color color = Color.red;//颜色
	private int radius = 6;//点的半径
	private MacroCommand history ;//记录

	public DrawCanvas(int width,int height,MacroCommand history) {
		setSize(width,height);
		setBackground(Color.WHITE);
		this.history = history;
	}
	//再度绘制整个记录
	public void paint(Graphics g) {
		history.execute();
	}
	//绘制
	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
	}

}