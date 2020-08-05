package com.project.springmvc.dao.member;

import com.project.springmvc.model.member.Member;

public interface MemberDaoInteface {
	
	public Member selectLoginMemberByEmail(String umail);

}
