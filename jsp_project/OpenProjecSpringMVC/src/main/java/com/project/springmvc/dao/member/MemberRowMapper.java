package com.project.springmvc.dao.member;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.springmvc.model.member.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member=new Member();
		member.setIdx(rs.getInt("idx"));
		member.setEmail(rs.getString("uid"));
		member.setPw(rs.getString("upw"));
		member.setName(rs.getString("uname"));
		member.setPhotoPath(rs.getString("uphoto"));
		return member;
	}

}
