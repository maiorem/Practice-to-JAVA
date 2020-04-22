package ver03;

import java.util.Scanner;

/*
Project : ver 0.30

배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경. 

아래기능 삽입

저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제

데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.
 */

public class PhoneBookManager {
	
	Scanner sc;
	final PhoneInfor[] pBooks;
	int cnt; 	// 입력된 정보 갯수 --> 입력된 배열의 요소 갯수
				// 1. 참조할 때 반복의 횟수를 세는 용도
				// 2. 새로운 객체를 저장할 때 index로 사용
	public PhoneBookManager() {
		//배열 초기화
		pBooks = new PhoneInfor[100];
		
		//저장갯수 초기화
		cnt=0;
		
		//Scanner 객체 초기화
		sc = new Scanner(System.in);
	}
	


	// 1. 저장기능 메서드
	// 배열에 PhoneInfor 타입의 참조값을 저장한다.
	void addInfo(PhoneInfor info) {
		pBooks[cnt] = info; // 배열에 요소 대입
		cnt++; 				// 등록된 정보의 갯수를 증가시킴
	}
	
	
	void addInfo() {
		pBooks[cnt] = createInst(); // 배열에 요소 대입
		cnt++; 						// 등록된 정보의 갯수를 증가시킴
	}
	
	
	
	
	// 사용자에게 정보를 입력받아 PhoneInfor 인스턴스를 생성하는 메서드
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
	
	
	
	// 전체 리스트 출력
	void showAllData() {
		//전체 데이터 -> 입력된 데이터의 갯수 cnt
		for(int i=0; i<cnt; i++) {
			pBooks[i].showInfo();
			System.out.println("-------------------");
			
		}
	}

	
	// 배열에서 이름을 기준으로 검색 후 index값을 반환
	int searchIndex(String name) {
		
		int searchIndex = -1;
		
		//사용자가 입력한 이름으로 배열에 요소를 검색 -> index
		for(int i=0; i<cnt; i++) {
			if (pBooks[i].checkName(name)) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
		
	}
	
	
	
	// 검색 : 이름 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
	// 배열의 요소(PhoneInfor) 속성 중 하나인 name 값으로 해당하는 참조값을 찾는다. 
	void searchInfo() {
		System.out.println("검색할 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		int searchIndex = searchIndex(name);
		
		if (searchIndex<0) {
			System.out.println("찾으시는 이름의 데이터가 존재하지 않습니다.");
		} else {
			pBooks[searchIndex].showInfo();
		}
	}
	
	//삭제 : 이름을 기준으로 데이터를 찾아 해당 데이터 삭제
	void deleteInfo() {
		System.out.println("삭제할 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		int searchIndex = searchIndex(name);
		
		// 1. pBooks[2] : 삭제 --> pBooks[2]=null; / 2. pBooks[2] = pBooks[3] --> pBooks[2]의 원래 데이터는 삭제됨.
		//데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
		//재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.
		if (searchIndex<0) {
			System.out.println("찾으시는 이름의 데이터가 존재하지 않습니다.");
		} else { // 삭제 : 검색한 index부터 저장된 위치까지 왼쪽으로 시프트.
			for(int i=searchIndex; i<cnt-1; i++) {
				pBooks[i] = pBooks[i+1];
			}
			cnt--; // 저장된 정보의 개수를 -1
			
			System.out.println("요청한 이름의 정보가 정상적으로 삭제되었습니다.");
		
		}
	}
	
}
