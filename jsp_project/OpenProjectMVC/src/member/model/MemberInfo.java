package member.model;

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
	
	
	

	public void setUid(String uid) {
		this.uid = uid;
	}



	public void setUpw(String upw) {
		this.upw = upw;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setUserphoto(String userphoto) {
		this.userphoto = userphoto;
	}



	@Override
	public String toString() {
		return "MemberInfo [uid=" + uid + ", upw=" + upw + ", username=" + username + ", userphoto=" + userphoto + "]";
	}

	

}
