package com.project.springmvc.service.member;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.member.MemberDaoInterface;
import com.project.springmvc.model.member.LoginRequest;
import com.project.springmvc.model.member.Member;

@Service
public class MemberLoginService {
	
//	@Autowired
//	MemberDao dao;
	
//	@Autowired
//	JdbcTemplateMemberDao dao;
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	
	public Member loginMember(HttpSession session, LoginRequest logRequest) {
		
		
		//interface의 mapper객체 생성
		dao=sessionTemplate.getMapper(MemberDaoInterface.class);
		
		
		Member member=null;
		try {
			member=dao.selectLoginMemberByEmail(logRequest.getUmail());
			
			if(member==null) {
				throw new Exception("존재하지 않는 회원입니다.");
			}
			
			
			if(logRequest.getUpw().equals(member.getPw())) {
				session.setAttribute("loginMember", member);
				
			} else {
				throw new Exception("아이디 혹은 비밀번호가 잘못되었습니다.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return member;
	}

}
