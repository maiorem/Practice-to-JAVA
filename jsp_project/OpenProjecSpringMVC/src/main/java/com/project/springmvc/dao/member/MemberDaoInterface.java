package com.project.springmvc.dao.member;

import java.util.List;
import java.util.Map;

import com.project.springmvc.model.member.Member;

public interface MemberDaoInterface {
	
	public Member selectLoginMemberByEmail(String umail);
	public int insertMember(Member member);
	public String selectIdByIdx(int idx);
	public int updateMember(Member member);
	
	//전체 회원의 수 : 검색 포함
	public int totalCount(Map search);
	
	//전체 회원의 List<Member>로 반환
	public List<Member> selectMemberList(Map search);
	

}
