package com.study.dataStructures.StackAndQueue;

public class DogAndCatQueueTest {

	public static void main(String[] args) {
		DogCatQueue adq = new DogCatQueue();
		adq.add(new Cat());
		adq.add(new Cat());
		adq.add(new Dog());
		adq.add(new Dog());
		adq.add(new Cat());
		adq.add(new Dog());
		adq.add(new Dog());
		adq.add(new Cat());
		adq.add(new Dog());
		adq.add(new Cat());
		adq.add(new Cat());
		adq.add(new Cat());
		adq.add(new Dog());
		adq.add(new Dog());
		//��ȥ��ʵ��Ϊ:cat,cat,dog,dog,cat,dog,dog,cat,dog,cat,cat,cat,dog,dog
		System.out.print(adq.pollAll()+""+adq.pollAll()+""+adq.pollAll()+""+adq.pollAll()+""
				+adq.pollAll()+"");
//		System.out.println(adq.catIsEmpty());
//		System.out.println(adq.pollDog().toString());
	}

}
