package message.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import message.dao.MessageDao;
import message.model.Message;
import message.model.MessageListView;
import service.Service;

public class MessageListServiceImpl implements Service {

	MessageDao dao;
	private final int MESSAGE_COUNT_PER_PAGE=10;

	
	@Override
	public String getViewPage(HttpServletRequest req, HttpServletResponse resp) {
		
		Connection conn=null;
		MessageListView messageListview=null;
		
		
		try {
			conn=ConnectionProvider.getConnection();
			dao=MessageDao.getInstance();
			
			List<Message> messageList=null;
			
			int messageTotalCount=dao.selectTotalCount(conn);
			
			int startrow=0;
			int currentPage=1;
			String page=req.getParameter("page");
			
			if(page!=null) {
				currentPage=Integer.parseInt(page);
			}
			
			if(messageTotalCount>0) {
				
				startrow=(currentPage-1)*MESSAGE_COUNT_PER_PAGE;
				messageList=dao.selectMessageList(conn, startrow, MESSAGE_COUNT_PER_PAGE);
				
			} else {
				currentPage=0;
				messageList=Collections.emptyList();
			}
			
			messageListview=new MessageListView(messageTotalCount, currentPage, messageList, MESSAGE_COUNT_PER_PAGE, startrow);
			req.setAttribute("noteList", messageListview);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
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
		
		
		return "/WEB-INF/views/message/messageList.jsp";

	}

}
