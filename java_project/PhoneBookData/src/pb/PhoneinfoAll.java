package pb;

import java.sql.Date;

public class PhoneinfoAll {
	
	private int idx;
	private String name;
	private String phone_num;
	private String address;
	private String email;
	private Date regdate;
	private String major;
	private int year;
	private String company;
	
		
	public PhoneinfoAll() {
		
	}
	public PhoneinfoAll(int idx, String name, String phone_num, String address, String email, Date regdate,
			String major, int year, String company) {
		super();
		this.idx = idx;
		this.name = name;
		this.phone_num = phone_num;
		this.address = address;
		this.email = email;
		this.regdate = regdate;
		this.major = major;
		this.year = year;
		this.company = company;
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
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	

}
