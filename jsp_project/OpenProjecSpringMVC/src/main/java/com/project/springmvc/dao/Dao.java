package com.project.springmvc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.project.springmvc.model.member.Member;
import com.project.springmvc.model.member.RegMemberRequest;

public interface Dao {

	int insertMember(Connection conn, Member member) throws SQLException;
	
}
