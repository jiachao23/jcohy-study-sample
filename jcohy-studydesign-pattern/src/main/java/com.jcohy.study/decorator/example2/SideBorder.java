package com.jcohy.study.decorator.example2;



/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class SideBorder extends Border {

	private char borderChar;//装饰的字符
	public SideBorder(Display display,char borderChar) {
		super(display);
		this.borderChar=borderChar;
	}
	@Override
	public int getColumns() {//字数要再加上内容，两边的装饰字符
		return 1+display.getColumns()+1;
	}

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return display.getRows();
	}

	@Override
	public String getRowText(int row) {//指定行的两边加上装饰字符
		// TODO Auto-generated method stub
		return borderChar+display.getRowText(row)+borderChar;
	}

}
