package com.jcohy.study.factory.AbstractFactory;


/**
 * 
 * @author jiachao
 *
 */
public abstract class AbstractFactory {
	 abstract Color getColor(String color);
	 abstract Shape getShape(String shape) ;
}
