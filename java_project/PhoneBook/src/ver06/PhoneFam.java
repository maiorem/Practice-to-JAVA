package ver06;

public class PhoneFam extends PhoneInfo {


	private String rel;
	
	PhoneFam (String name, String phoneNumber, String address, String email, String rel) {
		super(name, phoneNumber, address, email);
		this.rel = rel;
		
	}

	public void showInfo() {
		super.showBasicInfo();
		System.out.println("관계 : "+this.rel);
	}
	
	
}
