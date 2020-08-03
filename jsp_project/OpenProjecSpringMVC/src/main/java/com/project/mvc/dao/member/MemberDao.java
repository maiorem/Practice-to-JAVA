package com.project.mvc.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.mvc.dao.Dao;
import com.project.mvc.model.member.Member;
import com.project.mvc.model.member.RegMemberRequest;

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








}
