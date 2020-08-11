package com.project.springmvc.controller.member;


import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.springmvc.model.member.RegMemberRequest;
import com.project.springmvc.service.member.MemberRegService;
import com.project.springmvc.util.security.AES256Util;
import com.project.springmvc.util.security.Sha256;

@Controller
@RequestMapping("/member/reg")
public class MemberRegisterController {
	
	@Autowired
	private MemberRegService regService;
	
	@Autowired
	private Sha256 sha256;
	
	@Autowired
	private AES256Util aes256util;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	

	@RequestMapping(method=RequestMethod.GET)
	public String regForm() {
		
		return "/member/regForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String registerMember(HttpServletRequest request, RegMemberRequest regMember, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException{
		
		System.out.println("SHA 암호화");
		System.out.println(sha256.encrypt(regMember.getPw()));
		System.out.println(sha256.encrypt(regMember.getPw()).length());
		System.out.println("----------------------------------------------");
		System.out.println("AES 암호화");
		System.out.println(aes256util.encrypt(regMember.getPw()));
		System.out.println(aes256util.encrypt(regMember.getPw()).length());
		System.out.println("----------------------------------------------");
		System.out.println("Spring Security 암호화");
		System.out.println(passwordEncoder.encode(regMember.getPw()));
		System.out.println(passwordEncoder.encode(regMember.getPw()).length());
		
		//model.addAttribute("result", regService.getMember(request, regMember));		
		
		return "/member/regMember";
	}
	
	
}
