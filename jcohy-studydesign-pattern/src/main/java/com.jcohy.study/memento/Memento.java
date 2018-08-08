package com.jcohy.study.memento;

import java.util.Vector;

/**
 * 表示主人翁状态的类
 * @author jiachao
 */
public class Memento {
	int money;
	Vector<String> fruits;

	public Memento(int money) {
		this.money = money;
		fruits = new Vector<String>();
	}

	void addFruits(String fruit) {
		fruits.add(fruit);
	}

	public int getMoney() {
		return money;
	}

	public Vector<String> getFruits() {
		return fruits;
	}

}
