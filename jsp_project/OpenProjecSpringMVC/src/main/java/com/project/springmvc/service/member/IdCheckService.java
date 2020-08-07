package com.project.springmvc.service.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.member.MemberDaoInterface;

@Service
public class IdCheckService {
	
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public String idcheck(String email) {
		dao=template.getMapper(MemberDaoInterface.class);
		String data="N";
		int idCount=dao.countByEmail(email);
		
		if(idCount==0) {
			data="Y";
		}
		
		
		return data;
	}

}
