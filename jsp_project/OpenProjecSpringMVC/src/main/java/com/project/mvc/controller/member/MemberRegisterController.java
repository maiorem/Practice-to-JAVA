package com.project.mvc.controller.member;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.project.mvc.model.member.Member;

@Controller
public class MemberRegisterController {

	@RequestMapping("/member/regForm")
	public String regForm() {
		
		return "/member/regForm";
	}
	
	@RequestMapping(value="/member/reg", method=RequestMethod.POST)
	public String registerMember(Member member) {
		
		String email=member.getEmail();
		String pw=member.getPw();
		String name=member.getName();
		MultipartFile photo=member.getPhoto();
		
		String photoName=photo.getOriginalFilename();
	
		
		
		return "/member/regMember";
	}
	
	
}
