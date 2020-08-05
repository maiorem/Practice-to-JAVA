package com.project.springmvc.service.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.member.JdbcTemplateMemberDao;
import com.project.springmvc.dao.member.MemberDaoInterface;

@Service
public class EditMemberFormService {

//	@Autowired
//	JdbcTemplateMemberDao dao;
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public String selectIdByIdx(int idx) {
		dao=template.getMapper(MemberDaoInterface.class);
		return dao.selectIdByIdx(idx);
	}

}
