package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import service.Service;

public class IdCheckServiceImpl implements Service {
	
	MemberDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		String result="N";
		String id=request.getParameter("uid");
		Connection conn=null;
		dao=MemberDao.getInstance();
		
		try {
			conn=ConnectionProvider.getConnection();
			int resultCnt=dao.selectById(conn, id);
			
			if(resultCnt==0) {
				result="Y";
			}
		
		} catch(SQLException e) {
			e.getStackTrace();
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
		
		request.setAttribute("idcheck", result);
		return "/WEB-INF/views/member/idCheck.jsp";
	}

}
