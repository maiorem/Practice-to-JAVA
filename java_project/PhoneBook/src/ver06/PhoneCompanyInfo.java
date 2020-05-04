package ver06;

public class PhoneCompanyInfo extends PhoneInfo {

	private String position;
	
	PhoneCompanyInfo(String name, String phoneNumber, String address, String email, String position) {
		super(name, phoneNumber, address, email);
		this.position = position;
		
	}
	
	public void showInfo() {
		super.showBasicInfo();
		System.out.println("직책 : "+this.position);
	}
	
	
}
