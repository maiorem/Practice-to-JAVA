package com.project.springmvc.model.member;

import org.springframework.web.multipart.MultipartFile;

public class RegMemberRequest {

	String email;
	String pw;
	String name;
	MultipartFile photo;
	
	String photoPath;
	
	public RegMemberRequest() {
	}
	
	public RegMemberRequest(String email, String pw, String name, String photoPath) {
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.photoPath = photoPath;
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
	
	
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	@Override
	public String toString() {
		return "RegMemberRequest [email=" + email + ", pw=" + pw + ", name=" + name + ", photoName=" + photo.getOriginalFilename() + "]";
	}
	
	
	
}
