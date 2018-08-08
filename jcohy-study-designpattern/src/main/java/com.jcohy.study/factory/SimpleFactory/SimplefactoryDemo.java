package com.jcohy.study.factory.SimpleFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


/**
 * @author jiachao
 *
 */
public class SimplefactoryDemo {
	public static void main(String[] args) {
		SimpleFactory sf = new SimpleFactory();
//		Shape shape1 = sf.getshape("CYCLE");
//		shape1.draw();
//		//获取 Rectangle 的对象，并调用它的 draw 方法
//		Shape shape2 = sf.getshape("RECTANGLE");
//		//调用 Rectangle 的 draw 方法
//		shape2.draw();
//		//获取 Square 的对象，并调用它的 draw 方s法
//		Shape shape3 = sf.getshape("SQUARE");
//		//调用 Square 的 draw 方法
//		shape3.draw();
		//反射的利用
//		Shape shape1=sf.getshape("com.jiachao.designpattern.Factory.SimpleFactory.Circle");
//		shape1.draw();

		Properties pro = new Properties();
		File file = new File("D:\\workspace\\IdeaWorkSpace\\jcohy-study-sample\\jcohy-study-designpattern\\src\\main\\resources\\shape.properties");
		System.out.println(file.getPath());
		try {
			pro.load(new FileInputStream(file));
			for(int i=0;i<pro.size();i++){
				Shape shape=sf.getshape(pro.getProperty("circle"));
				shape.draw();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
