package com.jcohy.study.memento;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/**
 * 表示进行游戏的主人翁的类，这个类有手边的金钱总额，水果和随机产生器，水果名称。
 * 整个游戏的核心玩法就是下注（bet），只要主人没破产，这个方法就一直掷骰子。
 * @author jiachao
 */
public class Gamer {
	public int money;
	public Vector<String> fruits = new Vector<String>();
	public Random random = new Random();

	public static String[] fruitsname= {"苹果","葡萄","香蕉","橘子","梨"};

	public Gamer(int money) {
		this.money = money;

	}

	public int getMoney() {
		return money;
	}

	public void bet() {
		int dice = random.nextInt(6)+1;
		System.out.println("骰子点数"+dice);
		if(dice==1) {
			money+=100;
			System.out.println("手边金钱增加了。");
		}else if(dice ==2) {
			money/=2;
			System.out.println("手边金钱剩一半。");
		}else if(dice==6) {
			String f =getFruit();
			System.out.println("得到的水果("+f+")");
			fruits.add(f);
		}else {
			System.out.println("什么事都没发生");
		}
	}
	//拍照存证
	public Memento createMemento() {
		Memento m = new Memento(money);
		Iterator it = fruits.iterator();
		while(it.hasNext()) {
			String f = (String) it.next();
			if(f.startsWith("好吃的")) {
				m.addFruits(f);
			}
		}
		return m;
	}

	public void restoreMemento(Memento memento) {
		this.money = memento.getMoney();
		this.fruits = memento.getFruits();
	}
	private String getFruit() {
		String prefix="";
		if(random.nextBoolean()) {
			prefix="好吃的";
		}
		return prefix+fruitsname[random.nextInt(fruitsname.length)];
	}

	@Override
	public String toString() {
		return "Gamer [money=" + money + ", fruits=" + fruits + "]";
	}


}