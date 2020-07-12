package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.jdbc.ConnectionProvider;
import member.dao.MemberDao;
import model.MemberInfo;

public class GetMemberService {
	
	private GetMemberService() {}
	private static GetMemberService service=new GetMemberService();
	public static GetMemberService getInstance() {
		return service;
	}

	MemberDao dao;
	
	public MemberInfo getMember(String id) {
		
		Connection conn=null;
		MemberInfo member=null;
		
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
		
		
		return member;
		
	}
}
