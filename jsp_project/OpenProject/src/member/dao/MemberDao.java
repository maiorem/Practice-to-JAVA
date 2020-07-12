package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		String sql="insert into memberinfo values (memberInfo_idx_seq.nextVal, ?, ?, ?, ?)";

		try {

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

	public MemberInfo selectMember(Connection conn, String id) throws SQLException {
		
		MemberInfo member=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from memberinfo where member_id=?";
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member=new MemberInfo(
						rs.getString("member_id"), 
						rs.getString("member_pw"), 
						rs.getString("member_name"), 
						rs.getString("member_photo")
						);
						
			}
			
			
		} finally {
			if(rs!=null) {
				rs.close();
			}
			
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		
		
		
		return member;
	}

}
