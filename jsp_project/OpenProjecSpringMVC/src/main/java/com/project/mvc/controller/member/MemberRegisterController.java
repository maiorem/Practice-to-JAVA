package com.project.mvc.controller.member;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.project.mvc.model.member.RegMemberRequest;
import com.project.mvc.service.member.MemberRegService;

@Controller
public class MemberRegisterController {
	
	@Autowired
	private MemberRegService regService;

	@RequestMapping(value="/member/regForm", method=RequestMethod.GET)
	public String regForm() {
		
		return "/member/regForm";
	}
	
	@RequestMapping(value="/member/reg", method=RequestMethod.POST)
	public String registerMember(@ModelAttribute RegMemberRequest regMember) {
		
		
		
		
		return "/member/regMember";
	}
	
	
}
