package ver04;



public class Interface {

	
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
			
			int num = manage.sc.nextInt();
			
			manage.sc.nextLine();
			
			switch(num) {
			case 1:
				System.out.println("------------------------------");
				System.out.println("저장 할 그룹을 고르세요. >> ");
				System.out.println("	1. 대학 동창");
				System.out.println("	2. 공연 프로덕션");
				System.out.println("	3. 친구");
				System.out.println("	4. 친척");
				System.out.println("------------------------------");
				int choice = manage.sc.nextInt();
				manage.sc.nextLine();
				if(!(choice>0&&choice<5)) {
					System.out.println("잘못된 메뉴 선택입니다.");
					return;
				}
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
