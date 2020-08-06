package com.aia.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rest.model.Member;

@RestController
@RequestMapping("/rest/v1")
public class RestTestController {
	
	//== RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public Member getMember() {
		Member member=new Member();
		member.setId(1);
		member.setName("cool");
		member.setEmail("cool@naver.com");
		member.setPhoto("default.png");
		
		return member;
	}
	
	@RequestMapping("/test") // /rest/v1/test
	public String testString() {
		return "Hello! RestFul!";
	}
	
}
