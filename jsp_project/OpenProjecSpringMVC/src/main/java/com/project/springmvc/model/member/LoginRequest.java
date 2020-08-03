package com.project.springmvc.model.member;

public class LoginRequest {
	
	String umail;
	String upw;
	String redirecUri;
		
	public LoginRequest() {
	
	}
	public LoginRequest(String umail, String upw) {

		this.umail = umail;
		this.upw = upw;
	}
	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getRedirecUri() {
		return redirecUri;
	}
	public void setRedirecUri(String redirecUri) {
		this.redirecUri = redirecUri;
	}
	@Override
	public String toString() {
		return "LoginRequest [umail=" + umail + ", upw=" + upw + ", redirecUri=" + redirecUri + "]";
	}

	
	
	

}
