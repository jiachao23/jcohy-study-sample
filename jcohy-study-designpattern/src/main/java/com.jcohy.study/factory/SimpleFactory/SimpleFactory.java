package com.jcohy.study.factory.SimpleFactory;


/**
 * @author jiachao
 *
 */
public class SimpleFactory{
	public Shape getshape(String shapeType){
//		if(shapeType == null){
//			return null;
//		}	
//		if(shapeType.equalsIgnoreCase("CYCLE")){
//			return new Circle();
//		} else if(shapeType.equalsIgnoreCase("RECTANGLE")){
//			return new Rectangle();
//		} else if(shapeType.equalsIgnoreCase("SQUARE")){
//			return new Square();
//		}
//		return null;
		//我们可以利用反射来获取类的实例
		Shape shape = null;
		try {
			shape = (Shape) Class.forName(shapeType).newInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return shape;
	}
}
