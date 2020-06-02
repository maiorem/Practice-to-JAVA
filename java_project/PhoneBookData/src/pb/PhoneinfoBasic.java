package pb;

import java.sql.Date;

public class PhoneinfoBasic {
	
	int idx;
	private String name;
	private String phone_num;
	private String address;
	private String email;
	private Date regdate;
	
	
	public PhoneinfoBasic() {}
	public PhoneinfoBasic(String name, String phone_num, String address, String email) {

		this.name = name;
		this.phone_num = phone_num;
		this.address = address;
		this.email = email;

	}
	
	
	
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	
	public String getPhone_num() {
		return phone_num;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}
