package com.project.springmvc.dao.member;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.springmvc.model.member.Member;

@Repository
public class JdbcTemplateMemberDao{

	@Inject
	JdbcTemplate jdbcTemplate;
		

	public int insertMember(Member member) throws SQLException {
		
		return jdbcTemplate.update("insert  into project.member (uid, upw, uname, uphoto) values (?,?,?,?)", 
				member.getEmail(), member.getPw(), member.getName(), member.getPhotoPath());
	}
	

	public int selectTotalCount() throws SQLException {

//		int totalCount=0;
//		String sql="select count(*) from project.member";
//		totalCount=jdbcTemplate.queryForObject(sql, Integer.class);
//		return totalCount;

		return jdbcTemplate.queryForObject("select count(*) from project.member", Integer.class);
				
	}

	public List<Member> selectMemberList(int startRow, int MESSAGE_COUNT_PER_PAGE) throws SQLException {
		
//		List<Member> list=new ArrayList<Member>();
//		String sql="select * from project.member limit ?,?";
//		list=jdbcTemplate.query(sql, new Object[] {startRow, MESSAGE_COUNT_PER_PAGE}, new MemberRowMapper());
//		return list;
		
		return jdbcTemplate.query("select * from project.member limit ?,?", new Object[] {startRow, MESSAGE_COUNT_PER_PAGE}, new MemberRowMapper());
		
	}




	public Member selectLoginMemberByEmail(String umail) throws SQLException {

		return jdbcTemplate.queryForObject("select * from project.member where uid=?", new MemberRowMapper(), umail);
	}






}
