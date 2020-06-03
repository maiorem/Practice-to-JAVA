package pb;

import java.sql.Date;

public class PhoneInfoCom extends PhoneInfoBasic {

	int idx;
	String fr_c_company;
	int fr_ref;
	
	
	
	
	public PhoneInfoCom() {
		
	}
	
	
	
	
	
	public PhoneInfoCom(String fr_c_company) {
		this.fr_c_company = fr_c_company;
	}





	public PhoneInfoCom(String fr_name, String fr_phonenumber, String fr_email, String fr_address, Date fr_regdate, String fr_c_company) {
		super(fr_name, fr_phonenumber, fr_email, fr_address, fr_regdate);
		this.fr_c_company=fr_c_company;

	}


	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getFr_c_company() {
		return fr_c_company;
	}
	public void setFr_c_company(String fr_c_company) {
		this.fr_c_company = fr_c_company;
	}
	public int getFr_ref() {
		return fr_ref;
	}
	public void setFr_ref(int fr_ref) {
		this.fr_ref = fr_ref;
	}
	
	
	
	
	
}
