package ver04;

public class PhoneFriend extends PhoneInfo {

	private String job;
	
	PhoneFriend(String name, String phoneNumber, String address, String email, String job) {
		super(name, phoneNumber, address, email);
		this.job = job;
		
	}

	void showInfo() {
		super.showBasicInfo();
		System.out.println("직업 : "+this.job);
	}
	
}
