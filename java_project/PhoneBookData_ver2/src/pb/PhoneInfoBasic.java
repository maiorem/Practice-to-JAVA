package pb;

import java.sql.Date;

public class PhoneInfoBasic {

	int idx;
	String fr_name;
	String fr_phonenumber;
	String fr_email;
	String fr_address;
	Date fr_regdate;
	
	
	public PhoneInfoBasic() {
		
	}
	
	
	
	public PhoneInfoBasic(int idx, String fr_name, String fr_phonenumber, String fr_email, String fr_address,
			Date fr_regdate) {
		this.idx = idx;
		this.fr_name = fr_name;
		this.fr_phonenumber = fr_phonenumber;
		this.fr_email = fr_email;
		this.fr_address = fr_address;
		this.fr_regdate = fr_regdate;
	}



	public PhoneInfoBasic(String fr_name, String fr_phonenumber, String fr_email, String fr_address,
			Date fr_regdate) {

		this.fr_name = fr_name;
		this.fr_phonenumber = fr_phonenumber;
		this.fr_email = fr_email;
		this.fr_address = fr_address;
		this.fr_regdate = fr_regdate;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getFr_name() {
		return fr_name;
	}
	public void setFr_name(String fr_name) {
		this.fr_name = fr_name;
	}
	public String getFr_phonenumber() {
		return fr_phonenumber;
	}
	public void setFr_phonenumber(String fr_phonenumber) {
		this.fr_phonenumber = fr_phonenumber;
	}
	public String getFr_email() {
		return fr_email;
	}
	public void setFr_email(String fr_email) {
		this.fr_email = fr_email;
	}
	public String getFr_address() {
		return fr_address;
	}
	public void setFr_address(String fr_address) {
		this.fr_address = fr_address;
	}
	public Date getFr_regdate() {
		return fr_regdate;
	}
	public void setFr_regdate(Date fr_regdate) {
		this.fr_regdate = fr_regdate;
	}
	
		
}
