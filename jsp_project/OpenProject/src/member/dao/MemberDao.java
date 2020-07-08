package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.MemberInfo;

public class MemberDao {
	
	private MemberDao() {}
	
	private static MemberDao dao=new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	public int createMember(Connection conn, MemberInfo member) throws SQLException {
		
		int resultCnt=0;
		
		PreparedStatement pstmt=null;
		
		
		try {
			String sql="insert into memberinfo values (memberInfo_idx_seq.nextVal, ?, ?, ?, ?)";

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getUid());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUsername());
			pstmt.setString(4, member.getUserphoto());
			
			resultCnt=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt!=null) {
				pstmt.close();
			}
		}
		
		return resultCnt;
	}

}
