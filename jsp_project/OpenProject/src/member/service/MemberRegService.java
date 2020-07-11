package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import guestbook.jdbc.ConnectionProvider;
import member.dao.MemberDao;
import model.MemberInfo;

public class MemberRegService {

	private MemberRegService() {}
	private static MemberRegService service = new MemberRegService();
	public static MemberRegService getInstance() {
		return service;
	}
	
	MemberDao dao;
	
	public int regPhoto(HttpServletRequest request) {
		int resultCnt=0;
		
		String uid="";
		String upw="";
		String uname="";
		String photoPath="";
		
		Connection conn=null;
		
		try {
			
			boolean isMultipart=ServletFileUpload.isMultipartContent(request);
			
			if(isMultipart) {
				DiskFileItemFactory factory=new DiskFileItemFactory();
				ServletFileUpload upload=new ServletFileUpload(factory);
				List<FileItem> items=upload.parseRequest(request);
				Iterator<FileItem> iter=items.iterator();
				
				while(iter.hasNext()) {
					
					FileItem item=iter.next();
					
					if(item.isFormField()) {
						
						String paramName=item.getFieldName();
						String paramValue=item.getString("utf-8");
						
						if(paramName.equals("uid")) {
							uid=paramValue;
						} else if(paramName.equals("upw")) {
							upw=paramValue;
						} else if(paramName.equals("username")) {
							uname=paramValue;
						} 
						
					} else {
						
						//파라미터 이름
						String paramName=item.getFieldName();
						//파일 이름
						String fileName=item.getName();
						//파일의 사이즈
						long file_size=item.getSize();
						//파일의 타입
						String contentType=item.getContentType();
						//임시메모리 저장 여부
						boolean isInMemory=item.isInMemory();
						
						String uri=request.getSession().getServletContext().getInitParameter("uploadPath");
						String realPath=request.getSession().getServletContext().getRealPath(uri);
						String newFileName=System.nanoTime()+"_"+fileName;
						//서버의 저장소에 실제 저장
						File saveFile=new File(realPath, newFileName);
						item.write(saveFile);
						
						System.out.println("저장 완료");
						
						photoPath=uri+"/"+newFileName;
					}
					
				}
				MemberInfo member=new MemberInfo();
				member.setUid(uid);
				member.setUpw(upw);
				member.setUsername(uname);
				member.setUserphoto(photoPath);
				
				conn=ConnectionProvider.getConnection();
				dao=MemberDao.getInstance();
				resultCnt=dao.createMember(conn, member);
				request.setAttribute("member", member);
				
			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
