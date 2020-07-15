package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.Member;

public class MemberDao {
	
	private MemberDao() {}
	private static MemberDao dao=new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}
	
	public int insertMember(Connection conn, Member member) throws SQLException {
		
		int resultCnt=0;
		
		PreparedStatement pstmt=null;
		
		String sql="insert into project.member (uid, upw, uname, uphoto) values (?, ?, ?, ?)";

		try {

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getUid());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());
			pstmt.setString(4, member.getUphoto());
			
			resultCnt=pstmt.executeUpdate();
			
		} finally {
			if (pstmt!=null) {
				pstmt.close();
			}
		}
		
		return resultCnt;
	}

	public Member selectMember(Connection conn, String id) throws SQLException {
		
		Member member=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from project.member where uid=?";
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member=new Member(
						rs.getInt("idx"),
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"), 
						rs.getString("uphoto"),
						rs.getDate("regdate")
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
	
	

	public int selectById(Connection conn, String id) throws SQLException {
		int resultCnt=0;
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select count(*) from project.member where uid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				resultCnt=rs.getInt(1);
			}
			
		} finally {
			if(rs!=null) {
				rs.close();
			}
			
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		return resultCnt;
	}
}
