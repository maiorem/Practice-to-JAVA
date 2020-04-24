package ver04;

import java.util.Scanner;

public class PhoneBookManager {

	Scanner sc;
	PhoneInfo[] info;
	int count;
	
	
	private PhoneBookManager() {
		sc=new Scanner(System.in);
		info=new PhoneInfo[100];
		count=0;
	}
	
	public static PhoneBookManager m = new PhoneBookManager();
	
	
	public static PhoneBookManager getInstance() {
		return m;
	}
	
	//저장기능
	void saveData(int choice) {
		info[count] = creatInst(choice);
		count++;
	}
	
	// 정보 입력으로 인스턴스 생성
	PhoneInfo creatInst(int choice) {

		PhoneInfo info = null;
						
		System.out.println("이름을 입력하세요. >> ");
		String name = sc.nextLine();
		System.out.println("전화번호를 입력하세요. >> ");
		String phoneNumber = sc.nextLine();
		System.out.println("주소를 입력하세요. >> ");
		String address = sc.nextLine();
		System.out.println("이메일을 입력하세요. >> ");
		String email = sc.nextLine();
		
		switch(choice) {
		case 1:
			System.out.println("전공을 입력하세요. >>");
			String major = sc.nextLine();
			System.out.println("학번을 입력하세요. >>");
			String grade = sc.nextLine();
			info = new PhoneUnivInfo(name, phoneNumber, address, email, major, grade);
			break;
		case 2:
			System.out.println("분야를 입력하세요. >>");
			String position = sc.nextLine();
			info = new PhoneThea(name, phoneNumber, address, email, position);
			break;
		case 3:
			System.out.println("직업을 입력하세요. >>");
			String job = sc.nextLine();
			info = new PhoneFriend(name, phoneNumber, address, email, job);
			break;
		case 4:
			System.out.println("관계를 입력하세요. >>");
			String rel = sc.nextLine();
			info = new PhoneFam(name, phoneNumber, address, email, rel);
			break;
		}		
		return info;
		
	}
	
	
	//검색기능
	int searchInfo(String name) {

		int searchIndex = -1;
	
		for(int i=0; i<count; i++) {
			if(info[i].checkName(name)) {
				searchIndex = i;
			}
		}
	
		return searchIndex;
	}
	
	
	//이름을 기준으로 검색 후 출력
	void output() {
		System.out.println("검색할 이름을 입력하세요. >> ");
		String name = sc.nextLine();
		
		int searchIndex = searchInfo(name);

		if(searchIndex<0) {
			System.out.println("찾으시는 정보가 없습니다.");
		} else {
			info[searchIndex].showInfo();
		}
		
	}
	
	
	//검색 후 삭제
	void delete() {
		
		System.out.println("삭제할 이름을 입력하세요. >> ");
		String name = sc.nextLine();
		
		int searchIndex = searchInfo(name);
		
		if(searchIndex<0) {
			System.out.println("찾으시는 정보가 없습니다.");
		} else {
			for(int i=searchIndex; i<count-1; i++) {
				info[searchIndex] = info[searchIndex+1];
			}
			count--;
		}
		
	}
	
	void showAllSimpleData() {
		System.out.println("기본 정보를 출력합니다.=======================");
		for(int i=0; i<count; i++) {
			info[i].showBasicInfo();
			System.out.println("---------------------------------");
		}

	}
	
	
	void showAllData() {
		for(int i=0; i<count; i++) {
			System.out.println("상세 정보를 출력합니다.=====================");
			info[i].showInfo();
			System.out.println("-------------------");
		}
	}
	
	
}
