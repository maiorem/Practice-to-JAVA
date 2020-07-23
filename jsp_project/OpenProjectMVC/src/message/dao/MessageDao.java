package message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		
		String sql="INSERT INTO project.message " +
			 	"(msg_writer, msg_receiver, msg_text, msg_img, msg_readcheck) " + 
				" VALUES " + 
				"(?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, msg.getMsg_writerIdx());
			pstmt.setString(2, msg.getMsg_receiver());
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

	public int selectTotalCount(Connection conn) throws SQLException {
		int resultCnt=0;
		
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			String sql="select count(*) from project.message";
			
			rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				resultCnt=rs.getInt(1);
			}
			
		} finally {
			if(rs!=null) {
				rs.close();
			}
			
			if(stmt!=null) {
				stmt.close();
			}
			
		}
		return resultCnt;
	}

	public List<Message> selectMessageList(Connection conn, int startrow, int MESSAGE_COUNT_PER_PAGE) throws SQLException {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		List<Message> list=new ArrayList<Message>();
		
		String sql="select msg.msg_idx, mem.uid, msg.msg_receiver, msg.msg_text, msg.msg_img, msg.msg_date, msg.msg_readcheck from (project.message msg inner join project.member mem on msg.msg_writer=mem.idx) order by msg_date desc limit ?,?"; 
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, MESSAGE_COUNT_PER_PAGE);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Message msg=new Message(
						rs.getInt("msg.msg_idx"),
						rs.getString("mem.uid"),
						rs.getString("msg.msg_receiver"),
						rs.getString("msg.msg_text"),
						rs.getString("msg.msg_img"),
						rs.getDate("msg.msg_date"),
						rs.getInt("msg.msg_readcheck")
						);
				
				list.add(msg);
			}
			
		} finally {
			if(rs!=null) {
				rs.close();
			}
			
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		
		return list;
	}
	

	
	
}
