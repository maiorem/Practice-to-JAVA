package com.project.springmvc.service.member;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.member.JdbcTemplateMemberDao;
import com.project.springmvc.model.member.Member;
import com.project.springmvc.model.member.MemberListView;

@Service
public class MemberListService {

//	@Autowired
//	MemberDao dao;

	@Autowired
	JdbcTemplateMemberDao dao;

	//한 페이지에 표현할 회원의 수
	private final int MESSAGE_COUNT_PER_PAGE=10;

	public MemberListView getMemberListView(HttpServletRequest request) throws SQLException {

		MemberListView memberListView=null;

		//한 페이지에 표현되는 멤버 리스트
		List<Member> memberList=null;

		//전체 회원 수
		int totalMemberCount=dao.selectTotalCount();

		//시작행
		int startRow=0;

		//현재 페이지
		int currentPage=1;
		String page=request.getParameter("page");

		if(page!=null) {
			currentPage=Integer.parseInt(page);
		}

		if(totalMemberCount>0) {
			startRow=(currentPage-1)*MESSAGE_COUNT_PER_PAGE;
			memberList=dao.selectMemberList(startRow, MESSAGE_COUNT_PER_PAGE);
		}

		memberListView=new MemberListView(totalMemberCount, currentPage, MESSAGE_COUNT_PER_PAGE, startRow, memberList);
		return memberListView;
	}



}
