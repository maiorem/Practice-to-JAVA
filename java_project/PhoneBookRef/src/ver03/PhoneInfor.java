package ver03;

import java.util.*;

/*
Project : ver 0.20
"프로그램 사용자로부터 데이터 입력"
프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이
핵심.
단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.

키보드로부터 데이터 입력 
↓
입력 받은 데이터로 인스턴스 생성
↓
생성된 인스턴스의 메소드 호출
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

	// name 속성값과 전달 받은 문자열을 비교해서 결과 반환
	boolean checkName(String name) {
		return  this.name.equals(name);
	}
	
	
	
	
}
