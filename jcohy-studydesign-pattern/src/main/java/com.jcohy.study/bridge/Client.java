package com.jcohy.study.bridge;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class Client {
	public static void main(String[] args) {
		JDBC jdbc = new DirverManange();
		Dirver mysql = new MysqlDirver();
		jdbc.setDirver(mysql);
		jdbc.connection();


		Dirver oracle = new OracleDirver();
		jdbc.setDirver(oracle);
		jdbc.connection();

		Dirver sqlserver = new SqlSerDirver();
		jdbc.setDirver(sqlserver);
		jdbc.connection();
	}
}
