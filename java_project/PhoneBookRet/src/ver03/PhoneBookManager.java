package ver03;

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
	void saveData() {
		info[count] = creatInst();
		count++;
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
	
	
	// 정보 입력으로 인스턴스 생성
	PhoneInfo creatInst() {
		
		PhoneInfo info = null;
		
		System.out.println("이름을 입력하세요. >> ");
		String name = sc.nextLine();
		System.out.println("전화번호를 입력하세요. >> ");
		String phoneNumber = sc.nextLine();
		System.out.println("생년월일을 입력하세요. >> ");
		String birthday = sc.nextLine();

		if (birthday==null || birthday.isEmpty()) {
			info = new PhoneInfo(name, phoneNumber);
		} else {
			info = new PhoneInfo(name, phoneNumber, birthday);
		}
		
		return info;
	}
	
	void showAllData() {
		for(int i=0; i<count; i++) {
			info[i].showInfo();
			System.out.println("-------------------");
		}
	}
	
	
}
