package com.jcohy.study.memento;

/**
 * 收集水果的骰子游戏
 * 游戏会自动进行
 * 游戏的主人翁丢骰子，根据骰子的结果决定下一个状态
 * 出现好的点数，金钱增加
 * 出现点数不好，金钱减少
 * 出现点数很好的情况，主人翁得到一个水果
 * 当主人翁玩到没钱时，游戏结束。
 * @author jiachao
 */

public class Client {
	public static void main(String[] args) {
		Gamer g = new Gamer(100);
		Memento memento = g.createMemento();//预先存储最初状态
		for(int i=0;i<100;i++) {
			System.out.println("======"+i+"======");
			System.out.println("现况："+g);
			g.bet();//进行游戏
			System.out.println("手边的金钱总额为："+g.getMoney()+"元。");
			//决定如何处理Memento
			if(g.getMoney()>memento.getMoney()) {
				System.out.println("(因为已经赢了不少，估先存储目前状态)");
				memento = g.createMemento();
			}else if(g.getMoney()<memento.getMoney()/2) {
				System.out.println("(因为已经输了不少，估先恢复到前次状态)");
				g.restoreMemento(memento);
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
