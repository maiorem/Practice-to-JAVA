package com.project.springmvc.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.springmvc.service.member.DeleteMemberService;

@Controller
@RequestMapping("member/deleteMember")
public class DeleteMemberController {
	
	@Autowired
	DeleteMemberService deleteService;
	
	@RequestMapping
	public String deleteMember(@RequestParam int idx, Model model) {
		
		model.addAttribute("deleteResult", deleteService.deleteMemebr(idx));
		
		return "member/deleteMember";
	}

}
