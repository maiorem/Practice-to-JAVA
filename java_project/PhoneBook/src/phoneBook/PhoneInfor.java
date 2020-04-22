package phoneBook;

import java.util.Scanner;

public class PhoneInfor {

	String name;		//이름 
	String phoneNumber;	//전화번호
	String birthday;	//생년월일
	Scanner kb = new Scanner(System.in);	
	
	
	PhoneInfor(String name, String number, String day) {
		this.name = name;
		phoneNumber = number;
		birthday = day;

	}
	
	PhoneInfor(String name, String number) {
		this(name, number, "--");		
	}
	
	
	
	void search(String name) { 
		if (this.name==name) {
			System.out.println("이름 : "+this.name);
			System.out.println("전화번호 : "+phoneNumber);
			System.out.println("생년월일 : "+birthday);
			
		}
	}

}


