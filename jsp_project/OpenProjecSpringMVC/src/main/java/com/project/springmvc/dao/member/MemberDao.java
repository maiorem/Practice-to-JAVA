package com.project.springmvc.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.springmvc.model.member.Member;

@Repository
public class MemberDao{


	public int insertMember(Connection conn, Member member) throws SQLException {
		int resultCnt=0;
		PreparedStatement pstmt=null;

		String sql="insert  into project.member (uid, upw, uname, uphoto) values (?,?,?,?)";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhotoPath());

			resultCnt=pstmt.executeUpdate();
			
			
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		return resultCnt;

	}

	public Member selectLoginMemberByEmail(Connection conn, String umail) throws SQLException {
		Member member=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from project.member where uid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, umail);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
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

	public int selectTotalCount(Connection conn) throws SQLException {
		
		int totalCount=0;
		
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select count(*) from project.member";
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				totalCount=rs.getInt(1);
			}
			
			
		} finally {
			if(rs!=null) {
				rs.close();
			}
			
			if(stmt!=null) {
				stmt.close();
			}
		}
		
		
		return totalCount;
	}

	public List<Member> selectMemberList(Connection conn, int startRow, int MESSAGE_COUNT_PER_PAGE) throws SQLException {
		
		List<Member> list=new ArrayList<Member>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from project.member limit ?,?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, MESSAGE_COUNT_PER_PAGE);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Member member=new Member(rs.getInt("idx"), rs.getString("uid"), rs.getString("upw"), rs.getString("uname"), rs.getString("uphoto"), rs.getDate("regdate"));
				list.add(member);
			}
		
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			
			if(rs!=null) {
				rs.close();
			}
		}
		
		return list;
	}








}
