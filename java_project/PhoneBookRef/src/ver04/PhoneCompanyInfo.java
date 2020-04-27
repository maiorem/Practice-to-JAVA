package ver04;

public class PhoneCompanyInfo extends PhoneInfo {

	String company;	//회사이름
	String dept;	//부서
	String job;		//직급
		
	PhoneCompanyInfo(String name, String phoneNum, String addr, String email, String company, String dept, String job) {
		super(name, phoneNum, addr, email);
		this.company=company;
		this.dept=dept;
		this.job=job;
	}

	
	@Override
	void showAllInfo() {
		showAllInfo();
		System.out.println("회사 : "+company);
		System.out.println("부서 : " +dept);
		System.out.println("직급 : "+job);
	}
	
}
