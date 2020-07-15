package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import service.Service;

public class EditMemberServiceImpl implements Service {

	MemberDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest req, HttpServletResponse resp) {
		
		int resultCnt=0;
		Connection conn=null;
		Member member=null;
		String id=req.getParameter("uid");
		
		//1.멤버의 idx를 받아서 회원이 존재하는지 확인
		//2.존재한다면 삭제
		
		try {
			conn=ConnectionProvider.getConnection();
			dao=MemberDao.getInstance();
			member=dao.selectMember(conn, id);
			
			if(member==null) {
				resultCnt=-1;
				throw new Exception("삭제 할 회원이 존재하지 않습니다.");
			}
			
			if(!member.getUid().equals(id)) {
				resultCnt=-2;
				throw new Exception("아이디가 일치하지 않습니다.");
			}
			
			resultCnt=dao.deleteMember(conn, id);
			
			
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
		
		req.setAttribute("deleteCode", resultCnt);
		
		return "/WEB-INF/views/member/deleteMember.jsp";
	}

}
