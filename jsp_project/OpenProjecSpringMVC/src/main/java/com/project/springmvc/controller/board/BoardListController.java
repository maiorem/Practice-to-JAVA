package com.project.springmvc.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/board")
public class BoardListController {

	@RequestMapping(value="/board/boardForm", method = RequestMethod.GET)
	public String boardForm() {
		
		return "/board/boardForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String boardView() {
		
		return "board/board";
	}
	
}
