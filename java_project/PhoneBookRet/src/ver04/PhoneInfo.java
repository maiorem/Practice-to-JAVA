package ver04;

public class PhoneInfo {

	private String name;		//이름 
	private String phoneNumber;	//전화번호
	private String address;		//주소
	private String email;		//이메일
	
	PhoneInfo(String name, String phoneNumber, String address, String email) {
		this.setName(name);
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}
	
	void showBasicInfo() {
		System.out.println("이름 : "+ this.getName());
		System.out.println("전화번호 : "+this.getPhoneNumber());
	}
	
		
	void showInfo() {
		System.out.println("이름 : "+ this.getName());
		System.out.println("전화번호 : "+this.getPhoneNumber());
		System.out.println("주소 : "+this.getAddress());
		System.out.println("이메일 : "+this.getEmail());
	}
	
	boolean checkName(String name) {
		return this.getName().equals(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
