package phoneBook;


public class PhoneInfor {

	String name;		//이름 
	String phoneNumber;	//전화번호
	String birthday;	//생년월일
	
	
	PhoneInfor(String name, String number, String day) {
		
		this.name = name;
		phoneNumber = number;
		birthday = day;
		
	}
	
	PhoneInfor(String name, String number) {
		this(name, number, "--");		
	}
	
	public PhoneInfor() {}

	@Override
	public String toString() {
		return "PhoneInfor [name=" + name + ", phoneNumber=" + phoneNumber + ", birthday=" + birthday + "]";
	}
	
	public void showInfor() {
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phoneNumber);
		System.out.println("생년월일 : "+birthday);
	}
		
	
	PhoneInfor[] p = new PhoneInfor[100];

	public void searchArr(String name) {

		for (int i=0; i<p.length; i++) {
			if(p[i].name==name) {
				p[i].showInfor();
			}
		}
	
	}




}


