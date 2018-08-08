package com.jcohy.study.flyweight;

import java.util.Hashtable;
import java.util.Map;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class BigCharFactory {
	private Map<String,BigChar> pool = new Hashtable<>();
	
	private static BigCharFactory singleton = new BigCharFactory();
	private BigCharFactory() {
	}
	public static BigCharFactory getInstance() {
		return singleton;
	}
	public synchronized BigChar getBigChar(char charname) {
		BigChar bc = (BigChar)pool.get(""+charname);
		if(bc == null) {
			bc = new BigChar(charname);
			pool.put(""+charname, bc);
		}
		return bc;
	}
}
