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
	
	
	void outputData() {

		System.out.println("이름 : "+name+", 전화번호 : "+phoneNumber+ ", 생년월일 : "+birthday);		
		
	}
		

}


