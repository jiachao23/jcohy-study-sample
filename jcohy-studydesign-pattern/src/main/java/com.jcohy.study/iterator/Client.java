package com.jcohy.study.iterator;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
/**
 * 把书籍放到书架上，并依次输出书名
 * @author jiachao
 */
public class Client {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("Effective Java"));
		bookShelf.appendBook(new Book("Effective Python"));
		bookShelf.appendBook(new Book("Effective C++"));
		bookShelf.appendBook(new Book("Effective PHP"));
		Iterator it = bookShelf.iterator();
		while(it.hashNext()) {
			System.out.println(it.next());
			
		}
	}
}
