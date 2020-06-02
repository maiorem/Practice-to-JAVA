package pb;

import java.sql.Date;

public class PhoneinfoUniv extends PhoneinfoBasic {

	int uInx;
	String major;
	int year;
	int ref;

	public PhoneinfoUniv() {
		super();
	}
	

	public PhoneinfoUniv(String name, String phone_num, String address, String email, String major, int year) {
		super(name, phone_num, address, email);
		this.major=major;
		this.year=year;
	}








	public int getuInx() {
		return uInx;
	}





	public void setuInx(int uInx) {
		this.uInx = uInx;
	}





	public int getRef() {
		return ref;
	}





	public void setRef(int ref) {
		this.ref = ref;
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


	
}
