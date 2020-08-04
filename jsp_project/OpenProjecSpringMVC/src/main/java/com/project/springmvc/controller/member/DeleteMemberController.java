package com.project.springmvc.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member/deleteMember")
public class DeleteMemberController {
	
	@RequestMapping
	public String deleteMember() {
		
		
		
		return "member/deleteMember";
	}

}
