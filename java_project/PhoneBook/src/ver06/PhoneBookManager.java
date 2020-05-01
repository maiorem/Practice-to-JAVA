package ver06;

import java.util.ArrayList;
import java.util.Scanner;

import ver.exception.OnlyNumberException;
import ver.exception.StringInputNoneException;

public class PhoneBookManager {

	Scanner sc;
	private ArrayList<PhoneInfo> info;
	
	
	private PhoneBookManager() {
		sc=new Scanner(System.in);
		info = new ArrayList<PhoneInfo>();		
	}
	
	private static PhoneBookManager m = new PhoneBookManager();
	
	
	public static PhoneBookManager getInstance() {
		return m;
	}
	
	//공백 입력시 예외처리할 메서드
	String readString() throws StringInputNoneException   {
		String str=sc.nextLine();
		if (str.trim().isEmpty()) {
			StringInputNoneException except = new StringInputNoneException();
			throw except;
		}
		return str;		
	}
	
	
	//저장기능
	void saveData(int choice) {
		info.add(creatInst(choice));
		
	}
	
	// 정보 입력으로 인스턴스 생성
	PhoneInfo creatInst(int choice) {

		PhoneInfo info = null;
		String name=null, phoneNumber=null, address=null, email=null;
		
		while (true) {
			try {
				System.out.println("이름을 입력하세요. >> ");
				name = readString();
				System.out.println("전화번호를 하이픈(-)을 제외한 숫자만 입력하세요. >> ");
				phoneNumber = readString();
				for(int i=0; i<phoneNumber.length(); i++) {
					if (!(phoneNumber.charAt(i)>='0' && phoneNumber.charAt(i)<='9')) {
						OnlyNumberException ex = new OnlyNumberException();
						throw ex;
					}
				}
				System.out.println("주소를 입력하세요. >> ");
				address = readString();
				System.out.println("이메일을 입력하세요. >> ");
				email = readString();

			} catch(StringInputNoneException e) {
				System.out.println(e.getMessage());
				System.out.println("다시 입력해주세요.");
				continue;
			} catch(OnlyNumberException e) {
				System.out.println(e.getMessage());
				System.out.println("다시 입력해주세요.");
				continue;
			} catch(Exception e) {
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
				continue;
			}
			break;
		}
			switch(choice) {
			case Interface.INSERT_UNIV:
				System.out.println("전공을 입력하세요. >>");
				String major = sc.nextLine();
				System.out.println("학번을 입력하세요. >>");
				String grade = sc.nextLine();
				info = new PhoneUnivInfo(name, phoneNumber, address, email, major, grade);
				break;
			case Interface.INSERT_THEATER:
				System.out.println("분야를 입력하세요. >>");
				String position = sc.nextLine();
				info = new PhoneThea(name, phoneNumber, address, email, position);
				break;
			case Interface.INSERT_FRIEND:
				System.out.println("직업을 입력하세요. >>");
				String job = sc.nextLine();
				info = new PhoneFriend(name, phoneNumber, address, email, job);
				break;
			case Interface.INSERT_FAMILY:
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
	
		for(int i=0; i<info.size(); i++) {
			if(info.get(i).checkName(name)) {
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
			info.get(searchIndex).showInfo();
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
			info.remove(searchIndex);
		}
		
	}
	
	void showAllSimpleData() {
		System.out.println("기본 정보를 출력합니다.=======================");
		for(int i=0; i<info.size(); i++) {
			info.get(i).showBasicInfo();
			System.out.println("---------------------------------");
		}

	}
	
	
	void showAllData() {
		System.out.println("상세 정보를 출력합니다.=====================");
		for(int i=0; i<info.size(); i++) {
			info.get(i).showInfo();
			System.out.println("----------------------------------");
		}
	}
	
	void editInfo() {
		System.out.println("변경할 정보의 이름을 입력하세요 >> ");
		String editName=sc.nextLine();
		
		int searchIndex = searchInfo(editName);
		
		if(searchIndex<0) {
			System.out.println("찾으시는 정보가 없습니다.");
		} else {
			
			String phoneNumber=null, address=null, email=null;
			
			while (true) {
				try {
					System.out.println("이름 : "+editName);
					System.out.println("전화번호를 하이픈(-)을 제외한 숫자만 입력하세요. >> ");
					phoneNumber=readString();
					for(int i=0; i<phoneNumber.length(); i++) {
						if (!(phoneNumber.charAt(i)>='0' && phoneNumber.charAt(i)<='9')) {
							OnlyNumberException ex = new OnlyNumberException();
							throw ex;
						}
					}
					System.out.println("주소를 입력하세요. >> ");
					address = readString();
					System.out.println("이메일을 입력하세요. >> ");
					email = readString();

				} catch(StringInputNoneException e) {
					System.out.println(e.getMessage());
					System.out.println("다시 입력해주세요.");
					continue;
				} catch(OnlyNumberException e) {
					System.out.println(e.getMessage());
					System.out.println("다시 입력해주세요.");
					continue;
				} catch(Exception e) {
					System.out.println("잘못된 입력입니다.");
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			}
			if (info.get(searchIndex) instanceof PhoneUnivInfo) {
				System.out.println("전공을 입력하세요 >> ");
				String major=sc.nextLine();
				System.out.println("학번을 입력하세요 >> ");
				String grade=sc.nextLine();
				info.remove(searchIndex);
				info.add(new PhoneUnivInfo(editName, phoneNumber, address, email, major, grade));
			} else if (info.get(searchIndex) instanceof PhoneThea) {
				System.out.println("분야를 입력하세요 >> ");
				String position=sc.nextLine();
				info.remove(searchIndex);
				info.add(new PhoneThea(editName, phoneNumber, address, email, position));
						
			} else if (info.get(searchIndex) instanceof PhoneFam) {
				System.out.println("관계를 입력하세요 >> ");
				String rel=sc.nextLine();
				info.remove(searchIndex);
				info.add(new PhoneFam(editName, phoneNumber, address, email, rel));
			} else if (info.get(searchIndex) instanceof PhoneFriend) {
				System.out.println("직업을 입력하세요 >> ");
				String job=sc.nextLine();
				info.remove(searchIndex);
				info.add(new PhoneFriend(editName, phoneNumber, address, email, job));
			}
		}
	}
	
	
}
