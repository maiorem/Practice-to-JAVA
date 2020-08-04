package com.project.springmvc.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.member.JdbcTemplateMemberDao;

@Service
public class EditMemberFormService {

	@Autowired
	JdbcTemplateMemberDao dao;

	public String selectIdByIdx(int idx) {
		String id=dao.selectIdByIdx(idx);
		return id;
	}

}
