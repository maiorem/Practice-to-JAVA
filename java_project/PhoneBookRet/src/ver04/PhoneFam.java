package ver04;

public class PhoneFam extends PhoneInfo {


	private String rel;
	
	PhoneFam (String name, String phoneNumber, String address, String email, String rel) {
		super(name, phoneNumber, address, email);
		this.rel = rel;
		
	}

	void showInfo() {
		super.showInfo();
		System.out.println("관계 : "+this.rel);
	}
	
	public String getRel() {
		return rel;
	}
	
	public void setRel(String rel) {
		this.rel = rel;
	}


	
}
