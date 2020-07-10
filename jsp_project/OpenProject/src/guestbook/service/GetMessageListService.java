package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import guestbook.dao.MessageDao;
import guestbook.jdbc.ConnectionProvider;
import guestbook.model.Message;
import guestbook.model.MessageListView;

public class GetMessageListService {

	private GetMessageListService() {}
	private static GetMessageListService service=new GetMessageListService();
	public static GetMessageListService getInstance() {
		return service;
	}

	private MessageDao dao;

	//한 페이지에 표현할 게시물 갯수
	private final int MESSAGE_COUNT_PER_PAGE=5;

	public MessageListView getMessageList(int pageNumber) {

		Connection conn=null;
		MessageListView messageListView=null;

		try {
			conn=ConnectionProvider.getConnection();
			dao=MessageDao.getInstance();

			//한 페이지 당 게시물 목록
			List<Message> messageList=null;

			//전체 게시물 갯수
			int messageTotalCount=dao.selectTotalCount(conn);

			int startRow=0;	//페이지 시작행 
			int endRow=0;	//페이지 마지막행

			if(messageTotalCount>0) { //전체 게시물이 하나라도 있으면

				startRow=(pageNumber-1)*MESSAGE_COUNT_PER_PAGE+1; //각 페이지의 첫행
				endRow=startRow+MESSAGE_COUNT_PER_PAGE-1;		//각 페이지의 마지막 행

				// 각 페이지의 게시물 목록 (dao에서 페이지 당 출력되는 쿼리문 생성)
				messageList=dao.selectMessageList(conn, startRow, endRow);

			} else { // 게시물이 없으면
				pageNumber=0; //페이지 수도 제로
				messageList=Collections.emptyList(); //게시물 목록은 널값으로 두지 말고 비워진 리스트로 만들기.
			}

			messageListView=new MessageListView(messageTotalCount, pageNumber, messageList, MESSAGE_COUNT_PER_PAGE, startRow, endRow);

		}catch (SQLException e) {
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



		return messageListView;
	}

}
