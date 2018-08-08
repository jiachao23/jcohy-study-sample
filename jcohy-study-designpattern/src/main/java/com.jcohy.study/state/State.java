package com.jcohy.study.state;

public interface State {
	//设定时间
	public abstract void doClock(Context context, int hour);
	//使用金库
	public abstract void doUse(Context context);
	//警铃
	public abstract void doAlarm(Context context);
	//普通电话
	public abstract void doPhone(Context context);
}
