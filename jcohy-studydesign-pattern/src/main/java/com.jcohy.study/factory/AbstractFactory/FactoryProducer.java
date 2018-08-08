package com.jcohy.study.factory.AbstractFactory;

/**
 * ����һ������������/�������࣬ͨ��������״����ɫ��Ϣ����ȡ������
 * @author jiachao
 *
 */
public class FactoryProducer {
	 public static AbstractFactory getFactory(String choice){
	      if(choice.equalsIgnoreCase("SHAPE")){
	         return new ShapeFactory();
	      } else if(choice.equalsIgnoreCase("COLOR")){
	         return new ColorFactory();
	      }
	      return null;
	   }
}
