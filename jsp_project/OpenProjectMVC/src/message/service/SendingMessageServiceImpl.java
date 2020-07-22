package message.service;

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
import message.dao.MessageDao;
import message.model.Message;
import service.Service;

public class SendingMessageServiceImpl implements Service {
	
	
	MessageDao dao;
	MemberDao member;

	@Override
	public String getViewPage(HttpServletRequest req, HttpServletResponse resp) {
		
		int resultCnt=0;
		
		int senderIdx=-1;
		String receiverId=null;
		String text=null;
		String img=null;
		int check=0; //안읽은 상태
		
		Connection conn=null;
		member=MemberDao.getInstance();
		
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

						if(paramName.equals("idx")) {
							senderIdx=Integer.parseInt(paramValue);
							
						} else if(paramName.equals("receiverId")) {
							if(member.existId(conn, paramValue)) {
								receiverId=paramValue;
								System.out.println("아이디 존재 확인");
							} else {
								throw new Exception("쪽지를 보낼 상대가 존재하지 않습니다.");
							}
						} else if(paramName.equals("noteText")) {
							text=paramValue;
						} 
						
					} else {
						String uri="/upload/noteImage";
						String realPath=req.getSession().getServletContext().getRealPath(uri);
						String newFileName=System.nanoTime()+"_"+item.getName();

						File saveFile=new File(realPath, newFileName);
						item.write(saveFile);
						
						System.out.println("저장 완료");
						
						img=uri+"/"+newFileName;

					}
					
				}
				Message msg=new Message();
				msg.setMsg_writer(senderIdx);
				msg.setMsg_receiver(receiverId);
				msg.setMsg_text(text);
				msg.setMsg_img(img);
				msg.setMsg_readcheck(check);
				
				conn=ConnectionProvider.getConnection();
				dao=MessageDao.getInstance();
				resultCnt=dao.sendMessage(conn, msg);
				req.setAttribute("note", msg);
				req.setAttribute("resultNote", resultCnt);
				
				
			}
			
			
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "/WEB-INF/views/message/sendingmessage.jsp";
	}

}
