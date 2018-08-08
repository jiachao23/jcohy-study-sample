package com.jcohy.study.mediator;

/**
 * 表示"顾问"的接口
 * @author jiachao
 *
 */
public interface Mediator {
	public abstract void createColleagues();
	public abstract void colleagueChanged(Colleague colleague);
}
