package ver04;

public class PhoneUnivInfo extends PhoneInfo {

	private String major;
	
	PhoneUnivInfo(String name, String phoneNumber, String address, String email, String major) {
		super(name, phoneNumber, address, email);
		this.major = major;
		
	}

	void showInfo() {
		System.out.println("이름 : "+ super.getName());
		System.out.println("전화번호 : "+super.getPhoneNumber());
		System.out.println("주소 : "+super.getAddress());
		System.out.println("이메일 : "+super.getEmail());
		System.out.println("전공 : "+this.major);
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}


	
	
}
