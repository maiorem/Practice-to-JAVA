package com.aia.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.member.model.Member;
import com.aia.member.model.RegMemberRequest;
import com.aia.member.service.MemberListService;
import com.aia.member.service.MemberRegService;

@RestController
@RequestMapping("/members")
public class MemberRestController {
	
	@Autowired
	MemberListService listService;
	
	@Autowired
	MemberRegService regService;
	
	// 회원의 리스트 : Json으로 응답
	@GetMapping		// GET | /members
	public List<Member> getMemberList(){
		return listService.getMemberList();
	}

	// 회원 가입
	@PostMapping	// POST | /members
	public int reg(RegMemberRequest regRequest) {
		return regService.regMember(regRequest);
	}
	
	// 한명의 회원 정보 출력
	@GetMapping("/{idx}")	// GET | members/{idx}
	public Member getMember() {
		return null;
	}
	
	
	// 한명의 회원 정보 수정
	@PutMapping("/{idx}") 	// PUT | members/{idx}
	public int edit() {
		return 0;
	}
	
	// 한명의 회원 삭제
	@DeleteMapping("/{idx}")	// DELETE | members/{idx}
	public int delete() {
		return 0;
	}
	
	
}
