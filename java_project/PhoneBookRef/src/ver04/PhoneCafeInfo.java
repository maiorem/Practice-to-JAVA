package ver04;

public class PhoneCafeInfo extends PhoneInfo {

	String cafeName;
	String nickName;
	
	public PhoneCafeInfo(String name, String phoneNum, String addr, String email, String cafeName, String nickName) {
		super(name, phoneNum, addr, email);
		this.cafeName=cafeName;
		this.nickName=nickName;
	}

	@Override
	void showAllInfo() {
		super.showAllInfo();
		System.out.println("동호회이름 : "+cafeName);
		System.out.println("닉네임 : "+nickName);
	}

}
