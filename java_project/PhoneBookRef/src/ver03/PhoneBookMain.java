package ver03;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();
//		PhoneInfor info = null;
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			Menu.showMenu();
			int menuNum = sc.nextInt();
			
			sc.nextLine();
			
			switch(menuNum) {
			case 1:
//				PhoneInfor info = manager.createInst();	// 사용자의 입력데이터를 인스턴스로 생성
//				manager.addInfo(info);					
				manager.addInfo();		// 정보를 배열에 저장
				break;
			case 2:
				manager.searchInfo();	//이름으로 검색
				break;
			case 3:
				manager.deleteInfo();	//이름으로 검색 후 삭제
				break;
			case 4:
				manager.showAllData();	//전체 리스트 출력
				break;
			case 5:
				//return;
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);			// 종료
				break;
			}
			
			
//			// 사용자의 입력데이터를 인스턴스로 생성
//			info = manager.createInst();
//			
//			// 정보를 배열에 저장
//			manager.addInfo(info);
//			
//			//전체 리스트 출력
//			manager.showAllData();
//			
//			//이름으로 검색
//			manager.searchInfo();
//			
//			//이름으로 검색 후 삭제
//			manager.deleteInfo();
//			manager.showAllData();
		
		}
	}

}
