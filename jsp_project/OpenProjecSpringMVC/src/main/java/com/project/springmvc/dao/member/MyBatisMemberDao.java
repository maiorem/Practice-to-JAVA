package com.project.springmvc.dao.member;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springmvc.model.member.Member;

@Repository
public class MyBatisMemberDao{

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	
	private String mapperPath="com.project.springmvc.mybatis.mapper.MemberMapper";
	
	public int insertMember(Member member) throws SQLException {
		return sessionTemplate.update(mapperPath+".insertMember", member);
	}
	
//
//	public int selectTotalCount() throws SQLException {
//
////		int totalCount=0;
////		String sql="select count(*) from project.member";
////		totalCount=jdbcTemplate.queryForObject(sql, Integer.class);
////		return totalCount;
//
//		return jdbcTemplate.queryForObject("select count(*) from project.member", Integer.class);
//				
//	}
//
//	public List<Member> selectMemberList(int startRow, int MESSAGE_COUNT_PER_PAGE) throws SQLException {
//		
////		List<Member> list=new ArrayList<Member>();
////		String sql="select * from project.member limit ?,?";
////		list=jdbcTemplate.query(sql, new Object[] {startRow, MESSAGE_COUNT_PER_PAGE}, new MemberRowMapper());
////		return list;
//		
//		return jdbcTemplate.query("select * from project.member limit ?,?", new Object[] {startRow, MESSAGE_COUNT_PER_PAGE}, new MemberRowMapper());
//		
//	}
//
//
//
//	public Member selectLoginMemberByEmail(String umail) throws SQLException {
//
//		return jdbcTemplate.queryForObject("select * from project.member where uid=?", new MemberRowMapper(), umail);
//	}
//
//
//	public String selectIdByIdx(int idx) {
//		
//		return jdbcTemplate.queryForObject("select uid from project.member where idx=?", String.class, idx);
//	}
//
//
//	public int updateMember(Member member) {
//		return jdbcTemplate.update("update project.member set upw=?, uname=?, uphoto=? where uid=?", 
//				member.getPw(), member.getName(), member.getPhotoPath(), member.getEmail());
//
//	}


}
