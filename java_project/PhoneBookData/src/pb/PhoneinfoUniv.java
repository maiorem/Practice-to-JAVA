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
	
	



	public PhoneinfoUniv(int idx, String name, String phone_num, String address, String email, Date regdate, int uIdx, String major, int year, int ref) {
		super(idx, name, phone_num, address, email, regdate);
		this.uInx=uIdx;
		this.major=major;
		this.year=year;
		this.ref=ref;
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
