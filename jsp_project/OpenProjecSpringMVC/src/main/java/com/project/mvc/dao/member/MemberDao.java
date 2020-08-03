package com.project.mvc.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.mvc.dao.Dao;
import com.project.mvc.model.member.RegMemberRequest;

public class MemberDao implements Dao {


	public int insertMember(Connection conn, RegMemberRequest regMember) throws SQLException {
		int resultCnt=0;
		PreparedStatement pstmt=null;

		String sql="insert  into project.member (member_id, member_pw, member_name, member_photo) values (?,?,?,?)";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, regMember.getEmail());
			pstmt.setString(2, regMember.getPw());
			pstmt.setString(3, regMember.getName());
			pstmt.setString(4, regMember.getPhotoPath());

			resultCnt=pstmt.executeUpdate();
			
			
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		return resultCnt;

	}


	public void updateMember(Connection conn, String email) {
		// TODO Auto-generated method stub

	}






}
