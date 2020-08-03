package com.project.springmvc.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/board")
public class BoardListController {

	@RequestMapping(value="/board/boardForm")
	public String boardForm() {
		
		return "/board/boardForm";
	}
	
	@RequestMapping
	public String boardView() {
		
		return "board/board";
	}
	
}
