package com.project.springmvc.service.member;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.springmvc.dao.member.MemberDao;
import com.project.springmvc.jdbc.ConnectionProvider;
import com.project.springmvc.model.member.Member;
import com.project.springmvc.model.member.RegMemberRequest;

@Service
public class MemberRegService {
	
	@Autowired
	MemberDao dao;
	
	public int getMember(HttpServletRequest request, RegMemberRequest regMember)  {
		
		int resultCnt=0;

		Connection conn=null;
		String photoPath=null;
		
		Member member=new Member(regMember.getEmail(), regMember.getPw(), regMember.getName());
		
		
		try {
			conn=ConnectionProvider.getConnection();
			
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
			resultCnt=dao.insertMember(conn, member);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		return resultCnt;
		
		
	}

}
