package com.aia.mvc.login.model;

public class LoginRequest {
	
	private String uid; //변수명은 파라미터 네임과 일치해야 함
	private String upw;
	private String redirecUri;

	//반드시 디폴트 생성자가 있어야함
	
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
	
	
	

	public String getRedirecUri() {
		return redirecUri;
	}

	public void setRedirecUri(String redirecUri) {
		this.redirecUri = redirecUri;
	}

	@Override
	public String toString() {
		return "LoginRequest [uid=" + uid + ", upw=" + upw + "]";
	}
	
	
	
	
	

}
