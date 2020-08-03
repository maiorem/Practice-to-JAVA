package com.project.springmvc.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberListController {
	
	@RequestMapping("/member/memberList")
	public String memberListView() {
		
		return "/member/memberList";
	}

}
