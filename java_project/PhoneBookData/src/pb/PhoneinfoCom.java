package pb;

import java.sql.Date;

public class PhoneinfoCom extends PhoneinfoBasic {

	int cIdx;
	String company;
	int ref;

	
	public PhoneinfoCom() {
		super();
	}

	public PhoneinfoCom(String name, String phone_num, String address, String email, String company) {
		super(name, phone_num, address, email);
		this.company=company;
	}




	public int getcIdx() {
		return cIdx;
	}

	public void setcIdx(int cIdx) {
		this.cIdx = cIdx;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


	
	
}
