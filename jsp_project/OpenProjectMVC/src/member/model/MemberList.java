package member.model;

import java.util.List;

public class MemberList {

	//전체 회원 수
	private int memberTotalCount;
	//현재 페이지 번호
	private int currentPageNumber;
	//회원 리스트
	private List<Member> memberList;
	//전체 페이지의 갯수
	private int pageTotalCount;
	//페이지 당 표현되는 회원의 수
	private int memberCountPerPage;
	//시작 행
	private int startRow;

	
	public MemberList(int memberTotalCount, int currentPageNumber, List<Member> memberList, int memberCountPerPage,
			int startRow) {
		this.memberTotalCount = memberTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.memberList = memberList;
		this.memberCountPerPage = memberCountPerPage;
		this.startRow = startRow;
		calTotalPageCount();
		
	}
	
	private void calTotalPageCount() {
		if(memberTotalCount==0) {
			pageTotalCount=0;
		} else {
			pageTotalCount=memberTotalCount/memberCountPerPage;
			if (memberTotalCount%memberCountPerPage>0) {
				pageTotalCount++;
			}
		}
	}

	public int getMemberTotalCount() {
		return memberTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMemberCountPerPage() {
		return memberCountPerPage;
	}

	public int getStartRow() {
		return startRow;
	}



	@Override
	public String toString() {
		return "MemberList [memberTotalCount=" + memberTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", memberList=" + memberList + ", pageTotalCount=" + pageTotalCount + ", memberCountPerPage="
				+ memberCountPerPage + ", startRow=" + startRow + "]";
	}
	
	
	
	
	
	
}
