package com.project.springmvc.service.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.member.MemberDaoInterface;
import com.project.springmvc.model.member.MemberXML;
import com.project.springmvc.model.member.MemberXmlList;

@Service
public class MemberLsitXmlService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public MemberXmlList getXmlList() {
		
		dao=template.getMapper(MemberDaoInterface.class);
		
		List<MemberXML> memberList=dao.selectTotalListXml();
		MemberXmlList list=new MemberXmlList(memberList);
		
		return list;
		
	}

}
