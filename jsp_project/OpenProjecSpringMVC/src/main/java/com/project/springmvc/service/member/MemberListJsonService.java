package com.project.springmvc.service.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.member.MemberDaoInterface;
import com.project.springmvc.model.member.Member;

@Service
public class MemberListJsonService {

	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public List<Member> getMemberList(){
		dao=template.getMapper(MemberDaoInterface.class);
		return dao.selectTotalList();
	}
	
}
