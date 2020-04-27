package ver04;


//PhoneInfo 클래스를 상속해서 새로운 클래스를 정의
public class PhoneUnivInfo extends PhoneInfo {
	
	String major;	//전공
	String grade;	//학년

	PhoneUnivInfo(String name, String phoneNum, String addr, String email, String major, String grade) {
		super(name, phoneNum, addr, email);
		this.major=major;
		this.grade=grade;
	}

	@Override
	void showAllInfo() {
		showAllInfo();
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+grade);
	}
	
	
}
