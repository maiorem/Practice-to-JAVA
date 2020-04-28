package ver05;

public class PhoneThea extends PhoneInfo {

	private String position;
	
	PhoneThea(String name, String phoneNumber, String address, String email, String position) {
		super(name, phoneNumber, address, email);
		this.position = position;
		
	}
	
	public void showInfo() {
		super.showBasicInfo();
		System.out.println("분야 : "+this.position);
	}
	
	
}
