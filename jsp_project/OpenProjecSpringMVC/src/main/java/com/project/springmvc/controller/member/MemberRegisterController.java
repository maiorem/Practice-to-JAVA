package com.project.springmvc.controller.member;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.springmvc.model.member.RegMemberRequest;
import com.project.springmvc.service.member.MemberRegService;

@Controller
@RequestMapping("/member/reg")
public class MemberRegisterController {
	
	@Autowired
	private MemberRegService regService;

	@RequestMapping(method=RequestMethod.GET)
	public String regForm() {
		
		return "/member/regForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String registerMember(HttpServletRequest request, RegMemberRequest regMember, Model model){
		
		
		model.addAttribute("result", regService.getMember(request, regMember));		
		
		return "/member/regMember";
	}
	
	
}
