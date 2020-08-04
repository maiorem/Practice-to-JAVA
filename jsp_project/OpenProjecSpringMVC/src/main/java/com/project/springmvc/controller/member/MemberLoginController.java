package com.project.springmvc.controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.springmvc.model.member.LoginRequest;
import com.project.springmvc.service.member.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {

	@Autowired
	MemberLoginService loginService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm(@RequestHeader("referer") String referer, Model model) {
		
		model.addAttribute("referer", referer);
		return "/member/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String loginMember(HttpSession session, LoginRequest logRequest, Model model) {
		
		model.addAttribute("referer", logRequest.getRedirecUri());
		model.addAttribute("loginInfo", loginService.loginMember(session, logRequest));
		return "/member/login";
	}
	
	
	
}
