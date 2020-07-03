package model;

public class MemberInfo {
	
	String uid;
	String upw;
	String username;
	String userphoto;
	
	public MemberInfo() {}
	
	
	
	public MemberInfo(String uid, String upw) {
		this.uid = uid;
		this.upw = upw;
	}



	public MemberInfo(String uid, String upw, String username, String userphoto) {
		this.uid = uid;
		this.upw = upw;
		this.username = username;
		this.userphoto = userphoto;
	}

	public String getUid() {
		return uid;
	}

	public String getUpw() {
		return upw;
	}

	public String getUsername() {
		return username;
	}

	public String getUserphoto() {
		return userphoto;
	}

	@Override
	public String toString() {
		return "MemberInfo [uid=" + uid + ", upw=" + upw + ", username=" + username + ", userphoto=" + userphoto + "]";
	}

	

}
