package com.aia.member.model;

import org.springframework.web.multipart.MultipartFile;

public class EditMemberRequest {
	
	int idx;
	String editEmail;
	String editPw;
	String editName;
	MultipartFile editPhoto;
	String oldFile;
	
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
	
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getOldFile() {
		return oldFile;
	}
	public void setOldFile(String oldFile) {
		this.oldFile = oldFile;
	}
	@Override
	public String toString() {
		return "EditMemberRequest [editEmail=" + editEmail + ", editPw=" + editPw + ", editName=" + editName
				+ ", editPhoto=" + editPhoto.getOriginalFilename() + "]";
	}
	
	
	
	
	

}
