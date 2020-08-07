package com.aia.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.member.dao.MemberDao;
import com.aia.member.model.Member;
import com.aia.member.model.RegMemberRequest;

@Service
public class MemberRegService {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int regMember(RegMemberRequest regRequest) {
		dao=template.getMapper(MemberDao.class);
		Member member=new Member(regRequest.getEmail(), regRequest.getPw(), regRequest.getName());
		int result=dao.insertMember(member);
		return result;
	}
}
