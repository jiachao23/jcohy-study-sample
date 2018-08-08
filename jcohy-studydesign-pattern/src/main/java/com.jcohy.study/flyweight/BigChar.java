package com.jcohy.study.flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class BigChar {
	private char charname;
	private String fontData;

	public BigChar(char charname) {
		this.charname = charname;

		try {
			BufferedReader bf = new BufferedReader(new FileReader("big" + charname + ".txt"));
			String Line;
			StringBuffer sb = new StringBuffer();
			while ((Line = bf.readLine()) != null) {
				sb.append(Line);
				sb.append("\n");

			}
			bf.close();
			this.fontData = sb.toString();
		} catch (IOException e) {
			this.fontData = charname + "?";
			e.printStackTrace();
		}
	}
	public void print() {
		System.out.println(fontData);
	}
}
