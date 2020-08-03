package com.project.springmvc.model.member;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	
	private int idx;
	private String email;
	private String pw;
	private String name;
	private MultipartFile photo;
	private Date regdate;
	
	String photoPath;
	
	public Member() {
		
	}
	
	public Member(int idx, String email, String pw, String name, MultipartFile photo, Date regdate) {
		this.idx = idx;
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
		this.regdate = regdate;
	}
	
	public Member(String email, String pw, String name, MultipartFile photo) {
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
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
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
	
	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", email=" + email + ", pw=" + pw + ", name=" + name + ", photo=" + photo
				+ ", regdate=" + regdate + "]";
	}
	
	

}
