package com.study.dataStructures.StackAndQueue;
/**
 * è������
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
