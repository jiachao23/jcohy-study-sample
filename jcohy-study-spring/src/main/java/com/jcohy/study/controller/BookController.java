package com.jcohy.study.controller;

import com.jcohy.study.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

}
