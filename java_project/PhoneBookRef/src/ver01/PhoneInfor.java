package ver01;

import java.util.*;

/*
Version 0.1 전화번호 관리 프로그램. 

PhoneInfor 라는 이름의 클래스를 정의해 보자. 클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며, 저장된 데이터의 적절한 출력이 가능하도록 메소드 정의

• 이름           name           	  String
• 전화번호       phoneNumber   	  String
• 생년월일       birthday            String 

단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.
 */

public class PhoneInfor {

	// private : 변수의 직접 참조를 막는다 (정보은닉)
	private String name;		// 저장할 이름
	private String phoneNumber;	// 저장할 전화번호
	private String birthday;	// 저장할 생년월일
	
	// 초기화를 위한 생성자 - 세개 데이터를 받는 생성자.
	PhoneInfor(String name, String phoneNumber, String birthday){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	// 생일을 뺀 데이터를 받는 생성자.
	PhoneInfor(String name, String phoneNumber) {
//		this.name = name;
//		this.phoneNumber = phoneNumber;
		this(name, phoneNumber, "------");
	}
	
	//데이터 출력 메서드
	void showInfo() { 
		System.out.println("이름 : " + this.name);
		System.out.println("전화번호 : " + this.phoneNumber);
		
//		if (this.birthday == null) {
//			System.out.println("생년월일 : 입력값이 없습니다.");
//		} else {
			System.out.println("생년월일 : " + this.birthday);
//		}
	}

}
