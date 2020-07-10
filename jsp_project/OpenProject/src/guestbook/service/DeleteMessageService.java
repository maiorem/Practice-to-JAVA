package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.jdbc.ConnectionProvider;
import guestbook.model.Message;

public class DeleteMessageService {
	
	private DeleteMessageService() {}
	private static DeleteMessageService service=new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return service;
	}
	
	MessageDao dao;
	
	public int deleteMessage(int mid, String pw) {
		
		int resultCnt=0;

		Connection conn=null;
		Message message=null;
		
		try {
			conn=ConnectionProvider.getConnection();
			dao=MessageDao.getInstance();
			message=dao.selectMessage(conn, mid);
			
			if(message==null) {
				resultCnt=-1;
				throw new Exception("삭제 할 메시지가 존재하지 않습니다.");
			}
			
			if(!message.getPw().equals(pw)) {
				resultCnt=-2;
				throw new Exception("비밀번호가 일치하지 않습니다.");
			}
			
			resultCnt=dao.deleteMessage(conn,mid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return resultCnt;
		
	}
	
	
}
