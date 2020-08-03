package com.project.springmvc.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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








}
