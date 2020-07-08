package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.jdbc.ConnectionProvider;
import member.dao.MemberDao;
import model.MemberInfo;

public class MemberInfoService {

	private MemberInfoService() {}
	
	private static MemberInfoService service=new MemberInfoService();
	
	public static MemberInfoService getInstance() {
		return service;
	}
	
	MemberDao dao=null;
	
	public int createMember(MemberInfo member) {
		int result=0;
		dao=MemberDao.getInstance();
		
		Connection conn=null;
		
		try {
			conn=ConnectionProvider.getConnection();
			result=dao.createMember(conn, member);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return result;
	}
}
