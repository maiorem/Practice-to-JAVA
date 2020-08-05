package com.project.springmvc.service.member;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.springmvc.dao.member.MemberDaoInterface;
import com.project.springmvc.model.member.Member;
import com.project.springmvc.model.member.RegMemberRequest;

@Service
public class MemberRegService {
	
//	@Autowired
//	JdbcTemplateMemberDao dao;
	
//	@Autowired
//	MyBatisMemberDao dao;
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public int getMember(HttpServletRequest request, RegMemberRequest regMember)  {
		
		System.out.println(regMember);
		dao=sessionTemplate.getMapper(MemberDaoInterface.class);
		int resultCnt=0;
		String photoPath=null;
		Member member=new Member(regMember.getEmail(), regMember.getPw(), regMember.getName());
		System.out.println("입력 전 IDX ========> " +member.getIdx());
		
		try {
			
			MultipartFile photo=regMember.getPhoto();
			
			if(photo!=null) {
				String uri=request.getSession().getServletContext().getInitParameter("memberUploadPhoto");
				String realPath=request.getSession().getServletContext().getRealPath(uri); // 절대경로
				
				photoPath=System.nanoTime()+"_"+photo.getOriginalFilename();
				
				File saveFile=new File(realPath, photoPath);
				photo.transferTo(saveFile);
				System.out.println("저장 완료");

			} 
			
			member.setPhotoPath(photoPath);
			resultCnt=dao.insertMember(member);
			System.out.println("입력 후 IDX ==============> "+member.getIdx());

			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		
		
		return resultCnt;
		
		
	}

}
