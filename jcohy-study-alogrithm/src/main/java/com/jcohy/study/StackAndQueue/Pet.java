package com.jcohy.study.StackAndQueue;
/**
 * 猫狗队列
 * @author jiachao
 *
 */
public class Pet {
	private String type;
	public Pet(String type){
		this.type=type;
	}
	public String getPetType(){
		return this.type;
	}
	@Override
	public String toString() {
		return "Pet [type=" + type + "]";
	}
	
	
}
