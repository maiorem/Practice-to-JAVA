package com.project.springmvc.service.member;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.member.MemberDao;
import com.project.springmvc.jdbc.ConnectionProvider;
import com.project.springmvc.model.member.Member;
import com.project.springmvc.model.member.MemberListView;

@Service
public class MemberListService {
	
	@Autowired
	MemberDao dao;
	
	//한 페이지에 표현할 회원의 수
	private final int MESSAGE_COUNT_PER_PAGE=10;

	public MemberListView getMemberListView(String page) {
		
		Connection conn=null;
		MemberListView memberListView=null;
		
		try {
			conn=ConnectionProvider.getConnection();
			
			//한 페이지에 표현되는 멤버 리스트
			List<Member> memberList=null;
			
			//전체 회원 수
			int totalMemberCount=dao.selectTotalCount(conn);
			
			//시작행
			int startRow=0;
			
			//현재 페이지
			int currentPage=1;
			
			if(page!=null) {
				currentPage=Integer.parseInt(page);
			}
			
			if(totalMemberCount>0) {
				startRow=(currentPage-1)*MESSAGE_COUNT_PER_PAGE;
				memberList=dao.selectMemberList(conn, startRow, MESSAGE_COUNT_PER_PAGE);
			}
			
			memberListView=new MemberListView(totalMemberCount, currentPage, MESSAGE_COUNT_PER_PAGE, startRow, memberList);
			
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
		
		return memberListView;
	}
	
	
	
}
