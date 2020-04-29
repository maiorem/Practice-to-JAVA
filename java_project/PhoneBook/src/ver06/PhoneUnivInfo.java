package ver06;

public class PhoneUnivInfo extends PhoneInfo {

	private String major;
	private String grade;
	
	PhoneUnivInfo(String name, String phoneNumber, String address, String email, String major, String grade) {
		super(name, phoneNumber, address, email);
		this.major = major;
		this.grade = grade;
	}

	public void showInfo() {
		super.showBasicInfo();
		System.out.println("전공 : "+this.major);
		System.out.println("학번 : "+this.grade);
	}
	
	
}
