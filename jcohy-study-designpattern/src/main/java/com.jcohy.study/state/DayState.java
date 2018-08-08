package com.jcohy.study.state;

/**
 * 白天状态的类
 * @author jiachao
 *
 */
public class DayState implements State {

	private static DayState singleton = new DayState();

	private DayState() {
	}

	public static State getInstance() {
		return singleton;
	}
	@Override
	public void doClock(Context context, int hour) {
		if(hour<9||17<=hour) {
			context.changeState(NightState.getInstance());
		}
	}

	@Override
	public void doUse(Context context) {
		//使用金库
		context.recordLog("使用金库（白天）");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("警铃（白天）");
	}

	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("一般通话（白天）");
	}

	@Override
	public String toString() {
		return "[白天]";
	}

}
