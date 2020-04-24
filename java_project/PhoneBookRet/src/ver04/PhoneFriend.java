package ver04;

public class PhoneFriend extends PhoneInfo {

	private String year;
	
	PhoneFriend(String name, String phoneNumber, String address, String email, String year) {
		super(name, phoneNumber, address, email);
		this.year = year;
		
	}

	void showInfo() {
		System.out.println("이름 : "+ super.getName());
		System.out.println("전화번호 : "+super.getPhoneNumber());
		System.out.println("주소 : "+super.getAddress());
		System.out.println("이메일 : "+super.getEmail());
		System.out.println("나이 : "+this.year);
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}

}
