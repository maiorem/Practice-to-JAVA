package com.project.springmvc.service.member;

import java.security.cert.CollectionCertStoreParameters;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.member.JdbcTemplateMemberDao;
import com.project.springmvc.dao.member.MemberDaoInterface;
import com.project.springmvc.model.member.Member;
import com.project.springmvc.model.member.MemberListView;

@Service
public class MemberListService {

//	@Autowired
//	MemberDao dao;

//	@Autowired
//	JdbcTemplateMemberDao dao;
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;

	//한 페이지에 표현할 회원의 수
	private final int MESSAGE_COUNT_PER_PAGE=10;

	public MemberListView getMemberListView(HttpServletRequest request) throws SQLException {
		
		dao=template.getMapper(MemberDaoInterface.class);
		Map<String, Object> search=new HashMap<String, Object>();
		
		//검색데이터 : searchType, keyword
		String searchType=request.getParameter("searchType");
		String keyword=request.getParameter("keyword");

		System.out.println("searchType : "+searchType);
		System.out.println("keyword : "+keyword);
		
		
		if(searchType!=null && !searchType.isEmpty()) {
			search.put("searchType", searchType);

		}
		
		if(keyword!=null && !keyword.isEmpty()) {
			search.put("keyword", keyword);
		}
		
		
		
		MemberListView memberListView=null;

		//한 페이지에 표현되는 멤버 리스트
		List<Member> memberList=null;

		//전체 회원 수
		int totalMemberCount=dao.totalCount(search);

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
			
			search.put("startRow", startRow);
			search.put("count", MESSAGE_COUNT_PER_PAGE);
			
			memberList=dao.selectMemberList(search);
		} else {
			currentPage=0;
			memberList=Collections.emptyList();
		}

		memberListView=new MemberListView(totalMemberCount, currentPage, MESSAGE_COUNT_PER_PAGE, startRow, memberList);
		return memberListView;
	}



}
