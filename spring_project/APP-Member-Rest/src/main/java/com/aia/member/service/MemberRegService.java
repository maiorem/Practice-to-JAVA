package com.aia.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.member.dao.MemberDao;
import com.aia.member.model.Member;
import com.aia.member.model.RegMemberRequest;

@Service
public class MemberRegService {

	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public int regMember(RegMemberRequest regRequest, HttpServletRequest request) {
		dao=template.getMapper(MemberDao.class);
		System.out.println(regRequest);
		
		Member member=new Member(regRequest.getEmail(), regRequest.getPw(), regRequest.getName());
		int result=0;
		String photoPath=null;

		try {
			MultipartFile photo=regRequest.getPhoto();

			if(photo!=null) {
				//String uri=request.getSession().getServletContext().getInitParameter("memberUploadPhoto");
				String uri="/upload";
				String realPath=request.getSession().getServletContext().getRealPath(uri); // 절대경로

				photoPath=System.nanoTime()+"_"+photo.getOriginalFilename();

				File saveFile=new File(realPath, photoPath);
				photo.transferTo(saveFile);
				member.setPhotoPath(photoPath);
				System.out.println("저장 완료");

			} 

			result=dao.insertMember(member);

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
