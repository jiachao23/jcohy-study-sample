package com.jcohy.study.decorator.example2;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class Test {
	public static void main(String[] args) {
		Display d1 = new StringDisplay("Hello World");
		Display d2 = new SideBorder(d1, '#');
		Display d3 = new FullBorder(d2);
		System.out.println("d1:");
		d1.show();
		System.out.println("d2:");
		d2.show();
		System.out.println("d3:");
		d3.show();
		Display d4 = new SideBorder(
				new FullBorder(
						new FullBorder(
								new SideBorder(
										new FullBorder(
												new StringDisplay("您好！")),
										'#')
								)
						),
				'/');
		System.out.println("d4:");
		d4.show();
		
	}
}
