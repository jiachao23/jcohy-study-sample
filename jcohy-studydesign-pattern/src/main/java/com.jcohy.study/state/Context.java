package com.jcohy.study.state;

public interface Context {
	//设定时间
	public abstract void setClock(int hour);
	//状态变化
	public abstract void changeState(State state);
	//调用保安中心
	public abstract void callSecurityCenter(String msg);
	//保安中心保留记录
	public abstract void recordLog(String msg);
}
