package com.project.springmvc.dao.member;

import com.project.springmvc.model.member.Member;

public interface MemberDaoInterface {
	
	public Member selectLoginMemberByEmail(String umail);
	public int insertMember(Member member);

}
