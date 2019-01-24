package com.jcohy.study.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
	private Queue<PetEnterQueue> dogQ;
	private Queue<PetEnterQueue> catQ;
	private long count;

	public DogCatQueue() {
		dogQ = new LinkedList<PetEnterQueue>();
		catQ = new LinkedList<PetEnterQueue>();
		this.count=0;
	}

	public void add(Pet pet) {
		if (pet.getPetType().equals("dog"))
			dogQ.add(new PetEnterQueue(pet, this.count++));
		else if (pet.getPetType().equals("cat"))
			catQ.add(new PetEnterQueue(pet, this.count++));
		else
			throw new RuntimeException("ERROE,NOT DOG OR CAT");
	}

	public Pet pollAll() {
		if (!dogQ.isEmpty() && !catQ.isEmpty()) {
			if (dogQ.peek().getCount() < catQ.peek().getCount())
				return dogQ.poll().getPet();
			else  
				return catQ.poll().getPet();
		} else if (!dogQ.isEmpty())
			return dogQ.poll().getPet();
		else if (!catQ.isEmpty())
			return catQ.poll().getPet();
		else
			throw new RuntimeException("ERROE ,QUEUE IS EMPTY");
	}

	public Dog pollDog() {
		if (!this.dogIsEmpty())
			return (Dog) dogQ.poll().getPet();
		else
			throw new RuntimeException("DogQueue Is Empty");
	}

	public Cat pollCat() {
		if (!this.catIsEmpty())
			return (Cat) this.catQ.poll().getPet();
		else
			throw new RuntimeException("CatQueue Is Empty");
	}

	public boolean isEmpty() {
		return dogQ.isEmpty() &&catQ.isEmpty();
	}

	public boolean dogIsEmpty() {
		return this.dogQ.isEmpty();
	}

	public boolean catIsEmpty() {
		
		return this.catQ.isEmpty();
	}
	public long getCount(){
		return this.getCount();
	}
	@Override
	public String toString() {
		return "DogCatQueue [dogQ=" + dogQ + ", catQ=" + catQ + ", count="
				+ count + "]";
	}

}
