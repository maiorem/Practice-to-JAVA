package com.aia.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.member.dao.MemberDao;
import com.aia.member.model.EditMemberRequest;
import com.aia.member.model.Member;

@Service
public class MemberEditService {

	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public int editMemberInfo(HttpServletRequest request, EditMemberRequest editMember)  {

		dao=template.getMapper(MemberDao.class);

		int result=0;
		String photoPath=null;
		System.out.println(editMember);
		Member member=new Member(editMember.getEditEmail(), editMember.getEditPw(), editMember.getEditName());
		try {
			MultipartFile photo=editMember.getEditPhoto();

			if(photo!=null) {

				String uri="/upload";
				String realPath=request.getSession().getServletContext().getRealPath(uri); // 절대경로

				photoPath=System.nanoTime()+"_"+photo.getOriginalFilename();

				File saveFile=new File(realPath, photoPath);

				photo.transferTo(saveFile);
				member.setPhotoPath(photoPath);
				System.out.println("저장 완료");			

			}

			
			result=dao.updateMember(member);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
