package com.jcohy.study.decorator.example2;



/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public  class StringDisplay extends Display {

	private String string;//打印的字符串

	public StringDisplay(String string ) {
		this.string=string;
	}
	@Override
	public int getColumns() {
		return string.getBytes().length;
	}

	@Override
	public int getRows() {
		return 1;
	}
	@Override
	public String getRowText(int row) {
		if(row ==0) {
			return string;
		}else {
			return null;
		}
	}

}
