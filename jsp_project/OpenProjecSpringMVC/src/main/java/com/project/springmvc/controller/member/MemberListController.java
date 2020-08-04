package com.project.springmvc.controller.member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.springmvc.service.member.MemberListService;

@Controller
@RequestMapping("/member/memberList")
public class MemberListController {
	
	@Autowired
	MemberListService memListService;
	
	@RequestMapping
	public String memberListView(HttpServletRequest request, Model model) throws SQLException {
		
		model.addAttribute("memberListView", memListService.getMemberListView(request));
		return "/member/memberList";
	}

}
