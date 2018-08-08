package com.jcohy.study.mediator;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
/**
 * 表示要跟顾问咨询的成员的接口（具体成员ColleagueButton,ColleagueTextFiled....）
 * @author jiachao
 *
 */
public interface Colleague {
	void setMediator(Mediator mediator);
	void setColleagueEnabled(boolean enabled);
}
