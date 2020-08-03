package com.project.springmvc.controller.guestbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GuestBookListController {

	@RequestMapping("/guestbook/bookForm")
	public String bookForm() {
		return "/guestbook/bookForm";
	}
	
	
	@RequestMapping(value="/guestbook/book", method=RequestMethod.POST)
	public String bookList() {
		
		
		return "/guestbook/book";
	}
	
}
