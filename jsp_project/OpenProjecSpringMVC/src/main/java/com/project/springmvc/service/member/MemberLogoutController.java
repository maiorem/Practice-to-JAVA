package com.project.springmvc.service.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberLogoutController {

	@RequestMapping
	public String memberLogout(){
		
		return "/member/logout";
	}
	
}
