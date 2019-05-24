package com.jcohy.study.prototype;
/**
 * 
 * @author admin
 *声明一个克隆自身的接口
 */
public class Prototype implements Cloneable{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
