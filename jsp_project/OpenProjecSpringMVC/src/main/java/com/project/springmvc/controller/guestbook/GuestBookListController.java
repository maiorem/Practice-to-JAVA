package com.project.springmvc.controller.guestbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/guestbook/book")
public class GuestBookListController {

	@RequestMapping("/guestbook/bookForm")
	public String bookForm() {
		return "/guestbook/bookForm";
	}
	
	
	@RequestMapping
	public String bookList() {
		
		
		return "/guestbook/book";
	}
	
}
