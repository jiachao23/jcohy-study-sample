package com.jcohy.study.mediator;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
/**
 * 要求输入姓名和密码的登录系统，系统分为访客登录(Guest)或者用户登录（Login）
 * 如果是访客登录，用户名和密码设为不可用状态，无法输入字符串
 * 如果选择用户登录，用户名设为可使用。当用户名不填写时，密码设为不可使用。都填写了，OK键设为可使用。
 * OK键在访客时可以使用
 * Cancel永远设为可使用
 * @author jiachao
 *
 */
public class Client {
	public static void main(String[] args) {
		new LoginFrame("Mediator sample");
	}
}
