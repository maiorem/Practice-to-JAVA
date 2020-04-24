package ver04;

import java.util.Scanner;

public class Interface {

	Scanner sc = new Scanner(System.in);
	PhoneBookManager manage = PhoneBookManager.getInstance();
	
	// 메뉴 출력
	void showMenu() {
		System.out.println("---------------------");
		System.out.println("메뉴를 고르세요.");
		System.out.println("   1. 번호 저장");
		System.out.println("   2. 번호 검색");
		System.out.println("   3. 번호 삭제");
		System.out.println("   4. 전체 기본 정보 보기");
		System.out.println("   5. 전체 상세 정보 보기");
		System.out.println("   6. 프로그램 종료");
		System.out.println("---------------------");
	}
	
	// 메뉴 분기
	void interf() {
		
		while (true) {
			showMenu();
			
			int num = sc.nextInt();
			
			sc.nextLine();
			
			switch(num) {
			case 1:
				System.out.println("------------------------------");
				System.out.println("저장 할 그룹을 고르세요. >> ");
				System.out.println("	1. 대학 동창");
				System.out.println("	2. 공연 프로덕션");
				System.out.println("	3. 친구");
				System.out.println("	4. 친척");
				System.out.println("------------------------------");
				int choice = sc.nextInt();
				sc.nextLine();
				manage.saveData(choice);
				break;
			case 2:
				manage.output();
				break;
			case 3:
				manage.delete();
				break;
			case 4:
				manage.showAllSimpleData();
				break;
			case 5:
				manage.showAllData();
				break;
			case 6:
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
			}
		

		}
		
	}
	
}
