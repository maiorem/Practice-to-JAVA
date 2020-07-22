package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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

	
	public List<Member> selectMemberList(Connection conn, int startRow, int MESSAGE_COUNT_PER_PAGE) throws SQLException {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		List<Member> list=new ArrayList<>();
		
		try {
		
			String sql="select * from project.member limit ?, ?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, MESSAGE_COUNT_PER_PAGE);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Member member=new Member(
						rs.getInt("idx"), 
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"),
						rs.getString("uphoto"),
						rs.getDate("regdate")
						);
				list.add(member);
			}
			
		} finally {
			if(rs!=null) {
				rs.close();
			}
			
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		
		return list;
	}

	
	public int selectTotalCount(Connection conn) throws SQLException {
		
		int resultCnt=0;
		
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			
			stmt=conn.createStatement();
			
			String sql="select count(*) from project.member";
			
			rs=stmt.executeQuery(sql);
			
			if(rs.next()){
				resultCnt=rs.getInt(1);
			}
			
		} finally {
			if(rs!=null) {
				rs.close();
			}
			
			if(stmt!=null) {
				stmt.close();
			}
		}
		
		return resultCnt;
	}

	public int deleteMember(Connection conn, String id) throws SQLException {

		int resultCnt=0;
		PreparedStatement pstmt=null;
		
		String sql="delete from project.member where uid=?";

		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			resultCnt=pstmt.executeUpdate();

		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		return resultCnt;
	}

	public int editMember(Connection conn, Member editMember) throws SQLException {
		int resultCnt=0;
		PreparedStatement pstmt=null;
		
		String sql="UPDATE project.member "
				+ "SET upw=?, uname=?, uphoto =? "
				+ "WHERE uid=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, editMember.getUpw());
			pstmt.setString(2, editMember.getUname());
			pstmt.setString(3, editMember.getUphoto());
			pstmt.setString(4, editMember.getUid());
			
			resultCnt=pstmt.executeUpdate();
			
			
			
			
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		return resultCnt;
	}

	public boolean existId(Connection conn, String id) throws SQLException {
		boolean result=false;
		List<Member> list=new ArrayList<>();

		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from project.member";
		
		try {
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
			Member member=new Member(
					rs.getInt("idx"), 
					rs.getString("uid"), 
					rs.getString("upw"), 
					rs.getString("uname"),
					rs.getString("uphoto"),
					rs.getDate("regdate")
					);
			list.add(member);
		}
		
		for(int i=0; i<list.size(); i++) {
			if(id.equals(list.get(i).getUid())) {
				result=true;
			}
		}
		} finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			
		}
		return result;
	}

}
