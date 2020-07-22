package message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import message.model.Message;

public class MessageDao {
	
	private MessageDao() {}
	private static MessageDao dao=new MessageDao();
	public static MessageDao getInstance() {
		return dao;
	}
	
	public int sendMessage(Connection conn, Message msg) throws SQLException {
		
		int resultCnt=0;
		
		PreparedStatement pstmt=null;
		
		String sql="insert into project.message (msg_receiver, msg_writer, msg_text, msg_img, msg_readcheck) values(?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, msg.getMsg_receiver());
			pstmt.setInt(2, msg.getMsg_writer());
			pstmt.setString(3, msg.getMsg_text());
			pstmt.setString(4, msg.getMsg_img());
			pstmt.setInt(5, msg.getMsg_readcheck());
			
			resultCnt=pstmt.executeUpdate();
			
		}finally {
		
			if(pstmt!=null) {
				pstmt.close();
			}
			
		}
		
		return resultCnt;
	}
	

	
	
}
