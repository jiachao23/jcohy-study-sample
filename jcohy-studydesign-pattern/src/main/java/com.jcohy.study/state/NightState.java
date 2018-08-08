package com.jcohy.study.state;

public class NightState implements State {


	private static NightState singleton = new NightState();

	public static State getInstance() {
		return singleton;
	}
	@Override
	public void doClock(Context context, int hour) {
		if(9<=hour&&hour<17) {
			context.changeState(DayState.getInstance());
		}
	}

	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("异常，晚上使用金库");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("警铃（晚上）");

	}

	@Override
	public void doPhone(Context context) {
		context.recordLog("晚间的通话录音");
	}
	@Override
	public String toString() {
		return "[晚间]";
	}
	
}
