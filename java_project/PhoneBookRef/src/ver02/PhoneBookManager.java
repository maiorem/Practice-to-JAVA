package ver02;

import java.util.Scanner;

// 전화번호 정보를 저장하는 기능만을 포함하는 클래스
// 1. 사용자로부터 데이터를 받아서 인스턴스를 생성하고 반환하는 기능.
public class PhoneBookManager {
	
	Scanner sc = new Scanner(System.in);
	
	PhoneInfor createInst() {
		
		PhoneInfor info = null;
		
		System.out.println("정보를 저장하기 위한 데이터를 입력합니다.");
		System.out.println("이름을 입력해주세요. >> ");
		String name = sc.nextLine();
		
		System.out.println("전화번호를 입력해주세요. >> ");
		String phoneNumber = sc.nextLine();
		
		System.out.println("생년월일을 입력해주세요. >> ");
		String birthday = sc.nextLine();
		
		//사용자의 입력 데이터에 따라 인스턴스 생성 방법을 구분해야 한다.
		if (birthday==null || birthday.trim().isEmpty()) { // trim : 공백 빼고 / isEmpty : 문자열이 없음.
			info = new PhoneInfor(name, phoneNumber);
		} else {
			info = new PhoneInfor(name, phoneNumber, birthday);
		}
		
		
		return info;
		
		
	}
	

}
