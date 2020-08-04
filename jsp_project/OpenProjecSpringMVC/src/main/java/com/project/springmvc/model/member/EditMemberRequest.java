package com.project.springmvc.model.member;

import org.springframework.web.multipart.MultipartFile;

public class EditMemberRequest {
	
	String editEmail;
	String editPw;
	String editName;
	MultipartFile editPhoto;
	
	public String getEditEmail() {
		return editEmail;
	}
	public void setEditEmail(String editEmail) {
		this.editEmail = editEmail;
	}
	public String getEditPw() {
		return editPw;
	}
	public void setEditPw(String editPw) {
		this.editPw = editPw;
	}
	public String getEditName() {
		return editName;
	}
	public void setEditName(String editName) {
		this.editName = editName;
	}
	public MultipartFile getEditPhoto() {
		return editPhoto;
	}
	public void setEditPhoto(MultipartFile editPhoto) {
		this.editPhoto = editPhoto;
	}
	@Override
	public String toString() {
		return "EditMemberRequest [editEmail=" + editEmail + ", editPw=" + editPw + ", editName=" + editName
				+ ", editPhoto=" + editPhoto.getOriginalFilename() + "]";
	}
	
	
	
	
	

}
