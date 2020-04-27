package ver04;

public class PhoneThea extends PhoneInfo {

	private String position;
	
	PhoneThea(String name, String phoneNumber, String address, String email, String position) {
		super(name, phoneNumber, address, email);
		this.position = position;
		
	}
	
	void showInfo() {
		super.showInfo();
		System.out.println("분야 : "+this.position);
	}
	
	
}
