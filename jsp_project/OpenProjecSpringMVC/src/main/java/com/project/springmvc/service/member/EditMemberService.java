package com.project.springmvc.service.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.springmvc.dao.member.JdbcTemplateMemberDao;
import com.project.springmvc.dao.member.MemberDaoInterface;
import com.project.springmvc.model.member.EditMemberRequest;
import com.project.springmvc.model.member.Member;

@Service
public class EditMemberService {
	
//	@Autowired
//	JdbcTemplateMemberDao dao;
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public int editMemberInfo(HttpServletRequest request, EditMemberRequest editMember) throws Exception, IOException {
		
		dao=template.getMapper(MemberDaoInterface.class);
		
		int result=0;
		
		String photoPath=null;
		Member member=new Member(editMember.getEditEmail(), editMember.getEditPw(), editMember.getEditName());
		
		MultipartFile photo=editMember.getEditPhoto();
		
		if(photo!=null) {
			
			String uri=request.getSession().getServletContext().getInitParameter("memberUploadPhoto");
			String realPath=request.getSession().getServletContext().getRealPath(uri); // 절대경로
			
			photoPath=System.nanoTime()+"_"+photo.getOriginalFilename();
			
			File saveFile=new File(realPath, photoPath);
			photo.transferTo(saveFile);
			System.out.println("저장 완료");			
		
		}
		
		member.setPhotoPath(photoPath);
		result=dao.updateMember(member);
		
		return result;
	}

}
