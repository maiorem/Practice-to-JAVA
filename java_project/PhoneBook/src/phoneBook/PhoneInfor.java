package phoneBook;
/*
 Version 0.2 / 2020.04.20.
 “프로그램 사용자로부터 데이터 입력”
프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이
핵심.
단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.
키보드로부터 데이터 입력 -> 입력 받은 데이터로 인스턴스 생성 -> 생성된 인스턴스의 메소드 호출

 */


import java.util.Scanner;

public class PhoneInfor {

	static String name = null;		//이름 
	static String phoneNumber = null;	//전화번호
	static String birthday = null;	//생년월일
	
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
	
	// version up : 사용자로부터 받은 데이터로 인스턴스 생성.
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("이름을 입력하세요 : ");
			name = kb.nextLine();
			System.out.print("전화번호를 입력하세요 : ");
			phoneNumber = kb.nextLine();
			System.out.print("생년월일을 입력하세요 : ");
			birthday  = kb.nextLine();
			
			PhoneInfor phone = new PhoneInfor(name, phoneNumber, birthday);

			phone.outputData();
			
		}
	}

}
