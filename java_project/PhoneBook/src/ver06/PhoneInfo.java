package ver06;

public abstract class PhoneInfo implements Info {

	private String name;		//이름 
	private String phoneNumber;	//전화번호
	private String address;		//주소
	private String email;		//이메일
	
	PhoneInfo(String name, String phoneNumber, String address, String email) {
		this.name=name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}
	
	public void showBasicInfo() {
		System.out.println("이름 : "+ this.name);
		System.out.println("전화번호 : "+this.phoneNumber);
		System.out.println("주소 : "+this.address);
		System.out.println("이메일 : "+this.email);
	}
	

	public boolean checkName(String name) {
		return this.getName().equals(name);
	}

	public String getName() {
		return name;
	}
	
}
