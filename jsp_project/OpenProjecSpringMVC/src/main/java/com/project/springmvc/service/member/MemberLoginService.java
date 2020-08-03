package com.project.springmvc.service.member;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.member.MemberDao;
import com.project.springmvc.jdbc.ConnectionProvider;
import com.project.springmvc.model.member.LoginRequest;
import com.project.springmvc.model.member.Member;

@Service
public class MemberLoginService {
	
	@Autowired
	MemberDao dao;
	
	public Member loginMember(HttpServletRequest request, LoginRequest logRequest) {
		
		Member member=null;
		Connection conn=null;
		
		
		try {
			conn=ConnectionProvider.getConnection();
			member=dao.selectLoginMemberByEmail(conn, logRequest.getUmail());
			
			if(member==null) {
				throw new Exception("존재하지 않는 회원입니다.");
			}
			
			
			if(logRequest.getUpw().equals(member.getPw())) {
				request.getSession().setAttribute("loginMember", member);
			} else {
				throw new Exception("아이디 혹은 비밀번호가 잘못되었습니다.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		
		
		
		return member;
	}

}
