package pb;

import java.sql.Date;

public class PhoneinfoAll {
	
	private int idx;
	private String type;
	private String name;
	private String phone_num;
	private String address;
	private String email;

	private String major;
	private String grade;
	private String dept;
	private String job;
		
	public PhoneinfoAll() {
		
	}

	
	public PhoneinfoAll(String type, String name, String phone_num, String address, String email, String major,
			String grade, String dept, String job) {

		this.type = type;
		this.name = name;
		this.phone_num = phone_num;
		this.address = address;
		this.email = email;
		this.major = major;
		this.grade = grade;
		this.dept = dept;
		this.job = job;
	}








	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getDept() {
		return dept;
	}





	public void setDept(String dept) {
		this.dept = dept;
	}





	public String getJob() {
		return job;
	}





	public void setJob(String job) {
		this.job = job;
	}





	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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

	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	
	

}
