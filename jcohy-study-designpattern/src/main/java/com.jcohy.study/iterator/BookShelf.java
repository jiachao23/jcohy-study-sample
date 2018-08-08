package com.jcohy.study.iterator;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class BookShelf implements Aggregate {
	
	
	private Book[] books;
	private int last =0;
	
	public BookShelf(int maxsize) {
		books = new Book[maxsize];
	}
	
	
	public Book getBookAt(int index) {
		return books[index];
	}
	
	public void appendBook(Book book) {
		this.books[last] = book;
		last++;
	}
	public int getLength() {
		return last;
	}
	@Override
	public Iterator iterator() {
		return new BookShelfIterator(this);
	}

}
