package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import service.Service;

public class EditMemberServiceImpl implements Service {

	MemberDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest req, HttpServletResponse resp) {
		
		int resultCnt=0;
		Connection conn=null;
		
		String editId=null;
		String editPw=null;
		String editName=null;
		String editPhoto=null;
		
		try {
			boolean isMultipart=ServletFileUpload.isMultipartContent(req);
			
			if(isMultipart) {
				DiskFileItemFactory factory=new DiskFileItemFactory();
				ServletFileUpload upload=new ServletFileUpload(factory);
				List<FileItem> items=upload.parseRequest(req);
				Iterator<FileItem> iter=items.iterator();
				
				while(iter.hasNext()) {
					
					FileItem item=iter.next();
					
					if(item.isFormField()) {
						
						String paramName=item.getFieldName();
						String paramValue=item.getString("utf-8");
						
						if(paramName.equals("uid")) {
							editId=paramValue;
						} else if(paramName.equals("upw")) {
							editPw=paramValue;
						} else if(paramName.equals("uname")) {
							editName=paramValue;
						} 
						
					} else {

						String uri="/upload/users";
						String realPath=req.getSession().getServletContext().getRealPath(uri);
						String newFileName=System.nanoTime()+"_"+item.getName();

						File saveFile=new File(realPath, newFileName);
						item.write(saveFile);
						
						System.out.println("저장 완료");
						
						editPhoto=uri+"/"+newFileName;
					}
					
				}
				//데이터베이스 저장
				Member editMember=new Member();
				editMember.setUid(editId);
				editMember.setUpw(editPw);
				editMember.setUname(editName);
				editMember.setUphoto(editPhoto);
				
				conn=ConnectionProvider.getConnection();
				dao=MemberDao.getInstance();
				resultCnt=dao.editMember(conn, editMember);
				
				req.setAttribute("editMember", editMember);
				req.setAttribute("editResult", resultCnt);
			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		
		return "/WEB-INF/views/member/editMember.jsp";
	}

}
