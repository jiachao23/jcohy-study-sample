package com.jcohy.study.decorator.example2;



/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class FullBorder extends Border {

	public FullBorder(Display display) {
		super(display);
	}
	@Override
	public int getColumns() {

		return 1+display.getColumns()+1;
	}

	@Override
	public int getRows() {//行数==内容行数加上下装饰字符
		return 1+display.getRows()+1;
	}

	@Override
	public String getRowText(int row) {
		if(row==0) {
			return "+"+makeLine("-",display.getColumns())+"+";
		}else if(row==display.getRows()+1){
			return "+"+makeLine("-",display.getColumns())+"+";
		}else {
			return "|"+display.getRowText(row-1)+"|";
		}
	}
	private String makeLine(String string, int columns) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<columns;i++) {
			sb.append(string);
		}
		return sb.toString();
	}

}