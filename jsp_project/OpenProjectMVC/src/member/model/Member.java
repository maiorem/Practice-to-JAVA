package member.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import message.model.Message;

public class Member {
	
	private int idx;
	private String uid;
	private String upw;
	private String uname;
	private String uphoto;
	private Date regdate;
	private List<Message> myMsgList;
	
	
	public Member() {
	}


	public Member(int idx, String uid, String upw, String uname, String uphoto, Date regdate) {
		this.idx = idx;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphoto = uphoto;
		this.regdate = regdate;
		myMsgList=new ArrayList<>();
	}


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getUpw() {
		return upw;
	}


	public void setUpw(String upw) {
		this.upw = upw;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUphoto() {
		return uphoto;
	}


	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	
	
	
	public List<Message> getMyMsgList() {
		return myMsgList;
	}


	public void setMyMsgList(List<Message> myMsgList) {
		this.myMsgList = myMsgList;
	}


	//java.sql.Date -> java.util.Date
	public java.util.Date getToDate(){ //${member.toDate}
		return new java.util.Date(regdate.getTime());
	}
	
	@Override
	public String toString() {
		return "Member [idx=" + idx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphoto=" + uphoto
				+ ", regdate=" + regdate + "]";
	}


}
