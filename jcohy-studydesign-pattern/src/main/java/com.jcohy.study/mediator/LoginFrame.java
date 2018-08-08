package com.jcohy.study.mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 顾问类
 * @author jiachao
 *
 */
public class LoginFrame extends Frame implements ActionListener,Mediator{
	
	
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	
	private ColleagueTextFiled textUser;
	private ColleagueTextFiled textPass;
	
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;
	
	public LoginFrame(String title) {
		super(title);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(4, 2));
		//产生Colleague
		createColleagues();
		//配置
		add(checkGuest);
		add(checkLogin);
		add(new Label("username"));
		add(textUser);
		add(new Label("username"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		colleagueChanged(checkGuest);
		pack();
		show();
	}
	@Override
	public void createColleagues() {
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, true);
		
		textUser = new ColleagueTextFiled("", 10);
		textPass = new ColleagueTextFiled("", 10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textPass.setMediator(this);
		textUser.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
		
		
	}
	//根据Colleague的消息，判断各Colleague的有效无效
	@Override
	public void colleagueChanged(Colleague colleague) {
		if(colleague == checkGuest||colleague == checkLogin) {
			if(checkGuest.getState()) {
				textUser.setEnabled(false);
				textPass.setEnabled(false);
				buttonOk.setEnabled(true);
			}else {
				textUser.setEnabled(true);
				userPassChanged();
			}
		}else if(colleague == textUser || colleague == textPass) {
			userPassChanged();
		}else {
			System.out.println("Colleague changed :unknown colleague == "+ colleague);
		}
	}

	private void userPassChanged() {
		if(textUser.getText().length()>0) {
			textPass.setEnabled(true);
			if(textPass.getText().length()>0) {
				buttonOk.setEnabled(true);
			}else {
				buttonOk.setEnabled(false);
			}
		}else {
			textPass.setEnabled(false);
			buttonOk.setEnabled(false);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(""+e);
		System.exit(0);
	}

}
