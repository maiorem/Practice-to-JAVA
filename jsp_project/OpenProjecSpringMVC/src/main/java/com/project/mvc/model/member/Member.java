package com.project.mvc.model.member;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	
	private String email;
	private String pw;
	private String name;
	private MultipartFile photo;
	
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
	@Override
	public String toString() {
		return "Member [email=" + email + ", pw=" + pw + ", name=" + name + ", photo-FileName=" + photo.getOriginalFilename() + "]";
	}
	
	

}
