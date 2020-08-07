package com.aia.member.model;

import java.util.List;

public class MemberListView {

	private int totalMemberCount; // 회원 전체
	private int currentPageNumber; // 현재 페이지 번호
	private int memberPerPage;	// 페이지당 행
	private int pageTotalCount;		//전체 페이지 수
	private int startrow;	//시작 행
	
	private List<Member> memberList;

	public MemberListView(int totalMemberCount, int currentPageNumber, int memberPerPage, int startrow,
			List<Member> memberList) {
		this.totalMemberCount = totalMemberCount;
		this.currentPageNumber = currentPageNumber;
		this.memberPerPage = memberPerPage;
		this.startrow = startrow;
		this.memberList = memberList;
		calTotalPageCount();
	}
	
	private void calTotalPageCount() {
		if(totalMemberCount==0) {
			pageTotalCount=0;
		} else {
			pageTotalCount=totalMemberCount/memberPerPage;
			if(totalMemberCount%memberPerPage>0) {
				pageTotalCount++;
			}
		}
	}

	public int getTotalMemberCount() {
		return totalMemberCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public int getMemberPerPage() {
		return memberPerPage;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getStartrow() {
		return startrow;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	@Override
	public String toString() {
		return "MemberListView [totalMemberCount=" + totalMemberCount + ", currentPageNumber=" + currentPageNumber
				+ ", memberPerPage=" + memberPerPage + ", pageTotalCount=" + pageTotalCount + ", startrow=" + startrow
				+ ", memberList=" + memberList + "]";
	}
	
	
	

}
