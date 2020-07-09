package guestbook.model;

import java.util.List;

public class MessageListView {

	//전체 게시물의 갯수
	private int messageTotalCount;
	
	//현재 페이지 번호
	private int currentPageNumber;
	
	//게시물 목록
	private List<Message> messageList;
	
	//전체 페이지 갯수
	private int pageTotalCount;
	
	//페이지당 표현 게시물의 갯수
	private int messageCountPerPage;
	
	//게시물의 시작 행
	private int startRow;
	
	//게시물의 마지막 행
	private int endRow;

	public MessageListView(int messageTotalCount, int currentPageNumber, List<Message> messageList,
			int messageCountPerPage, int startRow, int endRow) {
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageList = messageList;
		this.messageCountPerPage = messageCountPerPage;
		this.startRow = startRow;
		this.endRow = endRow;
		calTotalPageCount();
	}
	
	private void calTotalPageCount() {
		if(messageTotalCount==0) {
			pageTotalCount=0;
		} else {
			pageTotalCount=messageTotalCount/messageCountPerPage;
			if(messageTotalCount%messageCountPerPage>0) {
				pageTotalCount++;
			}
		}
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	@Override
	public String toString() {
		return "MessageListView [messageTotalCount=" + messageTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", messageList=" + messageList + ", pageTotalCount=" + pageTotalCount + ", messageCountPerPage="
				+ messageCountPerPage + ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}
	
	
	
}
