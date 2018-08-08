package com.jcohy.study.state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener,Context{

	//输出现在时间
	private TextField textClock  = new TextField(60);
	//输出保安中心
	private TextArea textScreen = new TextArea(10,60);

	private Button buttonUse = new Button("使用金库");
	private Button buttonAlarm = new Button("警铃");
	private Button buttonPhone = new Button("一般通话");
	private Button buttonExit = new Button("结束");
	//现在状态
	private State state = DayState.getInstance();


	public SafeFrame(String title) throws HeadlessException {
		super(title);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());

		add(textClock,BorderLayout.NORTH);
		textClock.setEditable(false);

		add(textScreen,BorderLayout.CENTER);
		textScreen.setEditable(false);

		Panel panel = new Panel();

		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);

		add(panel,BorderLayout.SOUTH);

		pack();
		show();

		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
	}

	@Override
	public void setClock(int hour) {
		String clockString="现在时间是：";
		if(hour<10) {
			clockString +="0"+hour+":00";
		}else {
			clockString += hour+":00";
		}
		System.out.println(clockString);
		textClock.setText(clockString);
		state.doClock(this, hour);
	}

	@Override
	public void changeState(State state) {
		System.out.println("状态已经从"+this.state+"变成"+state+"了。");
		this.state = state;
	}

	@Override
	public void callSecurityCenter(String msg) {
		textScreen.append("call "+ msg +"\n");
	}

	@Override
	public void recordLog(String msg) {
		textScreen.append("record "+ msg + "\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(""+e);
		if(e.getSource() == buttonUse) {
			state.doUse(this);
		}else if(e.getSource() == buttonAlarm) {
			state.doAlarm(this);
		}else if(e.getSource() == buttonPhone) {
			state.doPhone(this);
		}else if(e.getSource() == buttonExit){
			System.exit(0);
		}else {
			System.out.println("?");
		}
	}
}
