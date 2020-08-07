package com.aia.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.member.model.EditMemberRequest;
import com.aia.member.model.Member;
import com.aia.member.model.RegMemberRequest;
import com.aia.member.service.MemberListService;
import com.aia.member.service.MemberRegService;
import com.aia.member.service.MemberViewService;

@RestController
@RequestMapping("/members")
public class MemberRestController {
	
	@Autowired
	MemberListService listService;
	
	@Autowired
	MemberRegService regService;
	
	@Autowired
	MemberViewService viewService;
	
	
	// 회원의 리스트 : Json으로 응답
	@GetMapping		// GET | /members
	public List<Member> getMemberList(){
		return listService.getMemberList();
	}

	// 회원 가입
	@PostMapping	// POST | /members
	public int reg(RegMemberRequest regRequest, HttpServletRequest request) {
		return regService.regMember(regRequest, request);
	}
	
	// 한명의 회원 정보 출력
	@GetMapping("/{idx}")	// GET | members/{idx}
	public Member getMember(@PathVariable("idx") int idx) {
		return viewService.getMember(idx);
	}
	
	
	// 한명의 회원 정보 수정
	@PutMapping("/{idx}") 	// PUT | members/{idx}
	public int edit(
			@PathVariable("idx") int idx,
			EditMemberRequest editRequest,
			HttpServletRequest request
			) {
		
		return 0;
	}
	
	// 한명의 회원 삭제
	@DeleteMapping("/{idx}")	// DELETE | members/{idx}
	public int delete() {
		return 0;
	}
	
	
}
