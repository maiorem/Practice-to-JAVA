package com.project.mvc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.project.mvc.model.member.RegMemberRequest;

public interface Dao {

	int insertMember(Connection conn, RegMemberRequest regMember) throws SQLException;
	
}
