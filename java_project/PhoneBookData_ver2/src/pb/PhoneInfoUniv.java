package pb;

import java.sql.Date;

public class PhoneInfoUniv extends PhoneInfoBasic{

	int idx;
	String fr_u_major;
	int fr_u_year;
	int fr_ref;

	
	public PhoneInfoUniv() {

	}
	
	
	
	
	
	
	public PhoneInfoUniv(int idx, String fr_u_major, int fr_u_year, int fr_ref) {
		this.idx = idx;
		this.fr_u_major = fr_u_major;
		this.fr_u_year = fr_u_year;
		this.fr_ref = fr_ref;
	}






	public PhoneInfoUniv(String fr_u_major, int fr_u_year) {
		super();
		this.fr_u_major = fr_u_major;
		this.fr_u_year = fr_u_year;
	}

	public PhoneInfoUniv(String fr_name, String fr_phonenumber, String fr_email, String fr_address, Date fr_regdate, String fr_u_major, int fr_u_year) {
		super(fr_name, fr_phonenumber, fr_email, fr_address, fr_regdate);
		this.fr_u_major=fr_u_major;
		this.fr_u_year=fr_u_year;

	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getFr_u_major() {
		return fr_u_major;
	}
	public void setFr_u_major(String fr_u_major) {
		this.fr_u_major = fr_u_major;
	}
	public int getFr_u_year() {
		return fr_u_year;
	}
	public void setFr_u_year(int fr_u_year) {
		this.fr_u_year = fr_u_year;
	}
	public int getFr_ref() {
		return fr_ref;
	}
	public void setFr_ref(int fr_ref) {
		this.fr_ref = fr_ref;
	}
	
	
	
	
	
}
