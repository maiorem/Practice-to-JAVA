package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import member.model.MemberList;
import service.Service;

public class MemberListServiceImpl implements Service {
	
	
	private MemberDao dao;
	
	//한 페이지에 표현할 회원의 수
	private final int MESSAGE_COUNT_PER_PAGE=10;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		Connection conn=null;
		MemberList memberListview=null;
		
		try {
			
			conn=ConnectionProvider.getConnection();
			dao=MemberDao.getInstance();
			
			// 한 페이지에 표현되는 멤버리스트 구하기
			List<Member> memberList=null;
			
			// 전체 회원의 수
			int memberTotalCount=dao.selectTotalCount(conn);
			
			// 시작 행
			int startRow=0;
			
			//현재 페이지 번호
			int currentPage=1;
			String page=request.getParameter("page");
			
			if(page!=null) {
				currentPage=Integer.parseInt(page);
			}

			
			if(memberTotalCount>0) {
				
				//시작 행
				startRow=(currentPage-1)*MESSAGE_COUNT_PER_PAGE;
				
				memberList=dao.selectMemberList(conn, startRow, MESSAGE_COUNT_PER_PAGE);
				
			} else {
				currentPage=0;
				memberList=Collections.emptyList();
			}
			
			memberListview=new MemberList(memberTotalCount, currentPage, memberList, MESSAGE_COUNT_PER_PAGE, startRow);
			request.setAttribute("memberListView", memberListview);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		
		return "/WEB-INF/views/member/memberList.jsp";
	}

}
