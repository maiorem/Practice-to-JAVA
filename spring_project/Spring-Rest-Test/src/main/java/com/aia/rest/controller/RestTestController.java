package com.aia.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rest.model.Member;

@RestController
@RequestMapping("/rest/v1")
public class RestTestController {
	
	@RequestMapping("/membermap")
	public Map<Integer, Member> getMap(){
		
		Map<Integer, Member> map=new HashMap<Integer, Member>();
		
		map.put(1,new Member(1, "cool1", "cool1@gmail.com", "cool1.png", new Date()));
		map.put(2,new Member(2, "cool2", "cool2@gmail.com", "cool2.png", new Date()));
		map.put(3,new Member(3, "cool3", "cool3@gmail.com", "cool3.png", new Date()));
		map.put(4,new Member(4, "cool4", "cool4@gmail.com", "cool4.png", new Date()));
		map.put(5,new Member(5, "cool5", "cool5@gmail.com", "cool5.png", new Date()));
		map.put(6,new Member(6, "cool6", "cool6@gmail.com", "cool6.png", new Date()));
		
		return map;
	}
	
	@RequestMapping("/memberlist")
	public List<Member> getList(){
		List<Member> list=new ArrayList<Member>();
		list.add(new Member(1, "cool1", "cool1@gmail.com", "cool1.png", new Date()));
		list.add(new Member(2, "cool2", "cool2@gmail.com", "cool2.png", new Date()));
		list.add(new Member(3, "cool3", "cool3@gmail.com", "cool3.png", new Date()));
		list.add(new Member(4, "cool4", "cool4@gmail.com", "cool4.png", new Date()));
		list.add(new Member(5, "cool5", "cool5@gmail.com", "cool5.png", new Date()));
		list.add(new Member(6, "cool6", "cool6@gmail.com", "cool6.png", new Date()));
		return list;
	}
	
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
