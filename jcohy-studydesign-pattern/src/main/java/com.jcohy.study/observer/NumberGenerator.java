package com.jcohy.study.observer;

import java.util.Iterator;
import java.util.Vector;

/**
 * 产生数值的抽象类，notifyObservers告诉所有的Observers内容改变。
 * @author jiachao
 */
public abstract class NumberGenerator {
	private Vector<Observer> observers = new Vector<Observer>();
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		Iterator<Observer> it = observers.iterator();
		while(it.hasNext()) {
			Observer o = (Observer)it.next();
			o.update(this);
		}
	}
	
	public abstract int getNum() ;
	public abstract void excuteNum();
}
