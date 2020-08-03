package com.project.springmvc.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.springmvc.service.member.MemberListService;

@Controller
@RequestMapping("/member/memberList")
public class MemberListController {
	
	@Autowired
	MemberListService memListService;
	
	@RequestMapping
	public String memberListView(@RequestParam String page, Model model) {
		
		model.addAttribute("memberListView", memListService.getMemberListView(page));
		return "/member/memberList";
	}

}
