package com.project.mvc.service.member;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.project.mvc.dao.Dao;
import com.project.mvc.jdbc.ConnectionProvider;
import com.project.mvc.model.member.RegMemberRequest;
import com.project.mvc.service.Service;

public class MemberRegService implements Service {
	
	@Autowired
	Dao dao;
	
	public int getMember(HttpServletRequest request, RegMemberRequest regMember) {
		
		int resultCnt=0;
		Connection conn=null;
		String regEmail=request.getParameter("email");
		String regPw=request.getParameter("pw");
		String regName=request.getParameter("name");
		
		
		try {
			conn=ConnectionProvider.getConnection();
			resultCnt=dao.insertMember(conn, regMember);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		return resultCnt;
		
		
	}

}
