package com.project.springmvc.service.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.member.MemberDaoInterface;
import com.project.springmvc.model.member.Member;

@Service
public class MemberViewService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public Member getMemberInfo(int idx) {
		dao=template.getMapper(MemberDaoInterface.class);
		return dao.selectByIdx(idx);
	};

}
