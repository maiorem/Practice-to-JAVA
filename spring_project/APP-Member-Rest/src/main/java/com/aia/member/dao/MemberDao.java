package com.aia.member.dao;

import java.util.List;

import com.aia.member.model.Member;

public interface MemberDao {

	List<Member> selectList();

	int insertMember(Member member);

	Member selectByIdx(int idx);
	
	

}
