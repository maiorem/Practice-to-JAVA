package ver06;

public class PhoneFriendInfo extends PhoneInfo {

	private String job;
	
	PhoneFriendInfo(String name, String phoneNumber, String address, String email, String job) {
		super(name, phoneNumber, address, email);
		this.job = job;
		
	}

	public void showInfo() {
		super.showBasicInfo();
		System.out.println("직업 : "+this.job);
	}
	
}
