package com.jcohy.study.iterator;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class BookShelfIterator implements Iterator {
	public BookShelf bookShelf;
	public int index;
	
	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		this.index = 0;
	}
	@Override
	public boolean hashNext() {
		if(index <bookShelf.getLength() ) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Object next() {
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}

}
