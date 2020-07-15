package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import service.Service;


public class MemberLoginServiceImpl implements Service {

	MemberDao dao;

	@Override
	public String getViewPage(HttpServletRequest req, HttpServletResponse resp) {
		Connection conn=null;
		Member member=null;
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		
		try {
			conn=ConnectionProvider.getConnection();
			dao=MemberDao.getInstance();
			member=dao.selectMember(conn, id);
			
			if(member==null) {
				throw new Exception("존재하지 않는 아이디입니다.");
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
		
		return "/WEB-INF/views/member/login.jsp";
	}
}
