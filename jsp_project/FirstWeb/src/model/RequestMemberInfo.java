package model;

public class RequestMemberInfo {
	
	private String id;
	private String pw;
	private String userName;
	
	
	
	public RequestMemberInfo() {
	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "requestMemberInfo [id=" + id + ", pw=" + pw + ", userName=" + userName + "]";
	}

	
}
