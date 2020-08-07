package com.project.springmvc.dao.member;

import java.util.List;
import java.util.Map;

import com.project.springmvc.model.member.Member;
import com.project.springmvc.model.member.MemberXML;

public interface MemberDaoInterface {
	

	//전체 회원리스트 반환
	public List<Member> selectTotalList();
	
	//전체 Xml 회원리스트 반환
	public List<MemberXML> selectTotalListXml();
	
	//로그인
	public Member selectLoginMemberByEmail(String umail);
	
	//회원가입
	public int insertMember(Member member);
	
	//수정할 회원 선택해서 아이디 반환
	public String selectIdByIdx(int idx);
	
	//수정
	public int updateMember(Member member);
	
	//전체 회원의 수 : 검색 포함
	public int totalCount(Map search);
	
	//전체 회원의 List<Member>로 반환
	public List<Member> selectMemberList(Map search);
	
	//삭제
	public int deleteMember(int idx);
	
	//idx기반으로 검색한 회원의 정보를 반환
	public Member selectByIdx(int idx);

	//id 중복 체크
	public int countByEmail(String email);

}
