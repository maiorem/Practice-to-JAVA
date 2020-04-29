package ver05;

import java.util.Scanner;

// PhoneInfo 타입의 배열로 정보를 저장, 수정, 삭제, 검색, 출력
public class PhoneBookManager {

	Scanner kb;
	//1. 배열 생성
	PhoneInfo[] books;	//배열 선언
	int numOfInfo;		//배열에 저장된 요소의 갯수
	
	//생성자를 통해서 배열을 생성, 요소의 갯수 초기화
	PhoneBookManager(int num){
		books = new PhoneInfo[num];	//배열생성
		numOfInfo=0;				//요소갯수 초기화
		kb=new Scanner(System.in);
	}
	
	//2. 배열에 정보를 저장
	//2-1.배열에 추가
	void addInfo(PhoneInfo info) {
		books[numOfInfo]=info;	//numOfInfo => 인덱스로 참조값을 저장
		numOfInfo++;			//입력된 정보의 갯수를 +1 증가시킨다.
	}
	
	//2-2.사용자로부터 받은 데이터로 인스턴스 생성
	void createInfo() {
		
		//System.out.println("1.일반  2.대학  3.회사  4.동호회");
		System.out.println("1.대학  2.회사  3.동호회");
		System.out.println("저장할 메뉴를 선택하세요.");
//		int select=kb.nextInt();
//		kb.nextLine();
		int select=Integer.parseInt(kb.nextLine());
		if(!(select>0&&select<5)) { // 4이상의 메뉴를 선택하면 나오는 
			System.out.println("정상적인 메뉴 선택이 아닙니다.\n 메뉴를 다시 선택해 주세요.");
			return;
		}
		//2-2-1.기본 정보 수집 : 이름, 전번, 주소, 이메일
		System.out.println("이름을 입력해주세요 >>");
		String name=kb.nextLine();
		System.out.println("전화번호를 입력해주세요 >>");
		String phoneNum=kb.nextLine();
		System.out.println("주소를 입력해주세요 >>");
		String addr=kb.nextLine();
		System.out.println("이메일을 입력해주세요 >>");
		String email=kb.nextLine();
		
		PhoneInfo info=null;
		
		switch(select) {
		
		
		//2-2-2.기본클래스로 인스턴스 생성
//		case 1:
//			info = new PhoneInfo(name, phoneNum, addr, email);
//			break;
		
		//2-2-3.대학클래스 인스턴스 생성
		case MenuNum.UNIV:
			System.out.println("전공을 입력해주세요 >> ");
			String major=kb.nextLine();
			System.out.println("학년을 입력해주세요 >> ");
			String grade=kb.nextLine();
			info = new PhoneUnivInfo(name, phoneNum, addr, email, major, grade);
			break;
		
		//2-2-4.회사 인스턴스
		case MenuNum.COMPANY:
			System.out.println("회사명을 입력해주세요 >> ");
			String company=kb.nextLine();
			System.out.println("부서명을 입력해주세요 >> ");
			String dept=kb.nextLine();
			System.out.println("직무(직급)을 입력해주세요 >> ");
			String job=kb.nextLine();
			info = new PhoneCompanyInfo(name, phoneNum, addr, email, company, dept, job);
			break;
		
		//2-2-5.동호회 인스턴스
		case MenuNum.CAFE:
			System.out.println("동호회명을 입력해주세요 >> ");
			String cafeName=kb.nextLine();
			System.out.println("닉네임을 입력해주세요 >> ");
			String nickName=kb.nextLine();
			info = new PhoneCafeInfo(name, phoneNum, addr, email, cafeName, nickName);
			break;
		}
		//2-3.생성된 인스턴스를 배열에 저장
		addInfo(info);
		
	}
	
	//3. 배열의 데이터 출력
	void showAllInfo() {
		//for each 반복 : 현재 프로그램에선 사용불가.
		//for 반복문 : 반복의 횟수 지정이 가능
		System.out.println("전체 정보를 출력합니다.================");
		for(int i=0; i<numOfInfo; i++) {
			books[i].showAllInfo();
			System.out.println("-------------------------");
		}
	}
	

	// 배열의 index 검색 : 인스턴스의 name 기준
	int searchIndex(String name) {
		int searchIndex = -1;
		//정상적인 index 값은 0 이상의 값이다. 찾지 못한 경우 구분 값으로 -1을 사용.
		
		//배열의 반복으로 name값을 비교해서 index값을 찾는다.
		for(int i=0; i<numOfInfo; i++) {
			if(books[i].name.equals(name)) {
				searchIndex = i;
				break;
			}
		}
		
		return searchIndex;
	}
	
	//4. 배열의 정보 검색 : 이름을 기준으로
	void showInfo() {
		System.out.println("검색하실 정보의 이름을 입력하세요 >> ");
		String name=kb.nextLine();
		int index=searchIndex(name);
		if(index<0) {
			System.out.println("검색하신 이름의 정보가 없습니다.");
		} else {
			System.out.println("-------------------------");
			books[index].showBasicInfo();
			System.out.println("-------------------------");
		}
	
	}
	
	
	//5. 배열의 정보를 삭제 : 이름을 기준으로
	void delete() {
		System.out.println("삭제하실 정보의 이름을 입력하세요 >> ");
		String name=kb.nextLine();
		int index=searchIndex(name);
		if(index<0) {
			System.out.println("삭제하고자 하는 이름의 정보가 없습니다.");
		} else {
			//삭제 위치에서 왼쪽으로 시프트 처리
			for(int i=index; i<numOfInfo-1; i++) {
				books[i]=books[i+1];
			}
			numOfInfo--; //삭제가 되었으므로 요소의 갯수도 -1
		}
	}
	
	
	//6. 배열의 정보를 수정 : 이름을 기준으로
	void editInfo() {
		System.out.println("변경하실 정보의 이름을 입력하세요 >> ");
		String name=kb.nextLine();
		int index=searchIndex(name);
		if(index<0) {
			System.out.println("변경하고자 하는 이름의 정보가 없습니다.");
			return;
		} else {
			
			String editName=books[index].name; //이름은 그대로 유지.
			
			System.out.println("수정 데이터 입력을 시작합니다.");
			System.out.println("이름은 "+editName+"입니다.");
			System.out.println("전화번호를 입력해주세요 >> ");
			String phoneNum=kb.nextLine();
			System.out.println("주소를 입력해주세요 >> ");
			String addr=kb.nextLine();
			System.out.println("이메일을 입력해주세요 >> ");
			String email=kb.nextLine();
			
			PhoneInfo info = null;
			
			//저장된 인스턴스가 기본인지 대학친구인지, 회사인지, 동호회인지
			if(books[index] instanceof PhoneUnivInfo) {
				System.out.println("전공을 입력하세요 >> ");
				String major=kb.nextLine();
				System.out.println("학년을 입력하세요 >> ");
				String grade=kb.nextLine();
				info = new PhoneUnivInfo(editName, phoneNum, addr, email, major, grade); 
			} else if(books[index] instanceof PhoneCompanyInfo) {
				System.out.println("회사명을 입력하세요 >> ");
				String company=kb.nextLine();
				System.out.println("부서명을 입력하세요 >> ");
				String dept=kb.nextLine();
				System.out.println("직급을 입력하세요 >> ");
				String job=kb.nextLine();
				info = new PhoneCompanyInfo(editName, phoneNum, addr, email, company, dept, job);
			} else if(books[index] instanceof PhoneCafeInfo) {
				System.out.println("동호회 이름을 입력하세요 >> ");
				String cafeName=kb.nextLine();
				System.out.println("닉네임을 입력하세요 >> ");
				String nickName=kb.nextLine();
				info = new PhoneCafeInfo(editName, phoneNum, addr, email, cafeName, nickName);
			} 
//			else if (books[index] instanceof PhoneInfo) {
//				info = new PhoneInfo(editName, phoneNum, addr, email);
//			}
			// 배열에 새로운 인스턴스를 저장
			books[index] = info;
		}
	}
}
