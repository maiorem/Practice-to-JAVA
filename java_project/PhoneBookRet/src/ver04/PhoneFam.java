package ver04;

public class PhoneFam extends PhoneInfo {


	private String call;
	
	PhoneFam (String name, String phoneNumber, String address, String email, String call) {
		super(name, phoneNumber, address, email);
		this.call = call;
		
	}

	void showInfo() {
		System.out.println("이름 : "+ super.getName());
		System.out.println("전화번호 : "+super.getPhoneNumber());
		System.out.println("주소 : "+super.getAddress());
		System.out.println("이메일 : "+super.getEmail());
		System.out.println("호칭 : "+this.call);
	}
	
	public String getCall() {
		return call;
	}
	
	public void setCall(String call) {
		this.call = call;
	}


	
}
