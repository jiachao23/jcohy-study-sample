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
//		//��ȡ Rectangle �Ķ��󣬲��������� draw ����
//		Shape shape2 = sf.getshape("RECTANGLE");
//		//���� Rectangle �� draw ����
//		shape2.draw();
//		//��ȡ Square �Ķ��󣬲��������� draw ��s��
//		Shape shape3 = sf.getshape("SQUARE");
//		//���� Square �� draw ����
//		shape3.draw();
		//���������
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
