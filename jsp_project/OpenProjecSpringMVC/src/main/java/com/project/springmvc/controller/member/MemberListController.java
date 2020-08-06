package com.project.springmvc.controller.member;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.springmvc.model.member.Member;
import com.project.springmvc.model.member.MemberXmlList;
import com.project.springmvc.service.member.MemberListJsonService;
import com.project.springmvc.service.member.MemberListService;
import com.project.springmvc.service.member.MemberLsitXmlService;

@Controller
public class MemberListController {
	
	@Autowired
	MemberListService memListService;
	
	@Autowired
	MemberLsitXmlService memXmlService;
	
	@Autowired
	MemberListJsonService memJsonService;
	
	@RequestMapping("/member/memberList")
	public String memberListView(HttpServletRequest request, Model model) throws SQLException {
		model.addAttribute("memberListView", memListService.getMemberListView(request));
		return "/member/memberList";
	}
	
	@RequestMapping("/member/memberList.xml")
	@ResponseBody
	public MemberXmlList getMemberXml() {
		
		return memXmlService.getXmlList();
		
	}
	
	@RequestMapping("/member/memberList.json")
	@ResponseBody
	public List<Member> getMemberJson(){
		return memJsonService.getMemberList();
	}

}
