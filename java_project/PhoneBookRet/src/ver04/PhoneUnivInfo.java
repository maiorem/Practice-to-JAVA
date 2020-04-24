package ver04;

public class PhoneUnivInfo extends PhoneInfo {

	private String major;
	private String grade;
	
	PhoneUnivInfo(String name, String phoneNumber, String address, String email, String major, String grade) {
		super(name, phoneNumber, address, email);
		this.major = major;
		this.grade = grade;
	}

	void showInfo() {
		super.showInfo();
		System.out.println("전공 : "+this.major);
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}


	
	
}
