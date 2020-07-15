package member.service;

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

public class IdCheckServiceImpl implements Service {
	
	MemberDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		String result="N";
		String id=request.getParameter("uid");
		Connection conn=null;
		dao=MemberDao.getInstance();
		try {
			conn=ConnectionProvider.getConnection();
			int resultCnt=dao.selectById(conn, id);
			
			if(resultCnt==0) {
				result="Y";
			}
		
		} catch(SQLException e) {
			e.getStackTrace();
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
		
		request.setAttribute("idcheck", result);
		return "/WEB-INF/views/member/idCheck.jsp";
	}

}
