package ver03;

public class PhoneInfo {

	private String name;		//이름 
	private String phoneNumber;	//전화번호
	private String birthday;	//생년월일
	
	
	
	PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;

	}
	
	PhoneInfo(String name, String phoneNumber) {
		this(name, phoneNumber, "--");		
	}
	
	void showInfo() {
		System.out.println("이름 : "+ this.name);
		System.out.println("전화번호 : "+this.phoneNumber);
		System.out.println("생년월일 : "+this.birthday);
	}
	
	boolean checkName(String name) {
		return this.name.equals(name);
	}
	
	
}
