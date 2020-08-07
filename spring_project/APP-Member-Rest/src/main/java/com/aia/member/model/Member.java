package com.aia.member.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	
	private int idx;
	private String email;
	private String pw;
	private String name;
	private String photoPath;
	private Date regdate;
	
	
	public Member() {
		
	}

	

	public Member(int idx, String email, String pw, String name, String photoPath, Date regdate) {

		this.idx = idx;
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.photoPath = photoPath;
		this.regdate = regdate;
	}


	

	public Member(String email, String pw, String name) {
		this.email = email;
		this.pw = pw;
		this.name = name;
	}



	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhotoPath() {
		return photoPath;
	}


	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	@Override
	public String toString() {
		return "Member [idx=" + idx + ", email=" + email + ", pw=" + pw + ", name=" + name + ", photoPath=" + photoPath
				+ ", regdate=" + regdate + "]";
	}

	
	
	
}
