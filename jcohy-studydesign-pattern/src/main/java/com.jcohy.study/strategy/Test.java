package com.jcohy.study.strategy;

public class Test {

	

	public static void main(String[] args) {
		Context ctx1 = new Context(new StrategyImplA());
		Context ctx2 = new Context(new StrategyImplB());
		Context ctx3 = new Context(new StrategyImplC());
		ctx1.deMethod();
		ctx2.deMethod();
		ctx3.deMethod();
	}

}
