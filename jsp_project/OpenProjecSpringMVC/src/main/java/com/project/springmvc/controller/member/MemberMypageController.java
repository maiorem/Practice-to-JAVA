package com.project.springmvc.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberMypageController {
	
	@RequestMapping("/member/mypage/mypage")
	public String mypage() {
		return "/member/mypage/mypage";
	}

}
