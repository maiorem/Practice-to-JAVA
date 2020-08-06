package com.project.springmvc.controller.member;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.springmvc.service.member.MemberViewService;

@Controller
public class MemberViewController {

	@Inject
	private MemberViewService viewService;
	
	//http://localhost:8080/springmvc/member/view/12
	@RequestMapping("/member/view/{idx}")
	public String getMemberInfo(@PathVariable("idx") int idx, Model model) {
		model.addAttribute("member", viewService.getMemberInfo(idx));
		return "member/memberView";
	}
	
}
