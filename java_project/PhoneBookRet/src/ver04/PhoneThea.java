package ver04;

public class PhoneThea extends PhoneInfo {

	private String position;
	
	PhoneThea(String name, String phoneNumber, String address, String email, String position) {
		super(name, phoneNumber, address, email);
		this.position = position;
		
	}

	void showInfo() {
		System.out.println("이름 : "+ super.getName());
		System.out.println("전화번호 : "+super.getPhoneNumber());
		System.out.println("주소 : "+super.getAddress());
		System.out.println("이메일 : "+super.getEmail());
		System.out.println("역할 : "+this.position);
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}


	
	
}
