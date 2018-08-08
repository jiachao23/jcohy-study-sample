package com.jcohy.study.decorator.example2;



/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public abstract class Display {

	public abstract int getColumns();//取得横向的字数
	public abstract int getRows();//取得纵向的行数
	public abstract String getRowText(int row);//取得第Row个字符串
	public final void show() {//打印所有内容
		for(int i=0;i<getRows();i++) {
			System.out.println(getRowText(i));
		}
	}
}