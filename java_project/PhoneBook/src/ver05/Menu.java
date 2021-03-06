package ver05;



public class Menu {

	
	PhoneBookManager manage = PhoneBookManager.getInstance();
	
	// 메뉴 출력
	void showMenu() {
		System.out.println("---------------------");
		System.out.println("메뉴를 고르세요.");
		System.out.println(" "+Interface.SAVE+". 번호 저장");
		System.out.println(" "+Interface.SEARCH+". 번호 검색");
		System.out.println(" "+Interface.EDIT+". 번호 수정");
		System.out.println(" "+Interface.DELETE+". 번호 삭제");
		System.out.println(" "+Interface.SHOW_BASIC+". 전체 기본 정보 보기");
		System.out.println(" "+Interface.SHOW_ALL+". 전체 상세 정보 보기");
		System.out.println(" "+Interface.EXIT+". 프로그램 종료");
		System.out.println("---------------------");
	}
	
	// 메뉴 분기
	void menu() {
		
		while (true) {
			showMenu();
			
			int num = manage.sc.nextInt();
			
			manage.sc.nextLine();
			
			switch(num) {
			case Interface.SAVE:
				System.out.println("------------------------------");
				System.out.println("저장 할 그룹을 고르세요. >> ");
				System.out.println(" "+Interface.INSERT_UNIV+". 대학 동창");
				System.out.println(" "+Interface.INSERT_THEATER+". 공연 프로덕션");
				System.out.println(" "+Interface.INSERT_FRIEND+". 친구");
				System.out.println(" "+Interface.INSERT_FAMILY+". 친척");
				System.out.println("------------------------------");
				int choice = manage.sc.nextInt();
				manage.sc.nextLine();
				if(!(choice>0&&choice<5)) {
					System.out.println("잘못된 메뉴 선택입니다.");
					return;
				}
				manage.saveData(choice);
				break;
			case Interface.SEARCH:
				manage.output();
				break;
			case Interface.EDIT:
				manage.editInfo();
				break;
			case Interface.DELETE:
				manage.delete();
				break;
			case Interface.SHOW_BASIC:
				manage.showAllSimpleData();
				break;
			case Interface.SHOW_ALL:
				manage.showAllData();
				break;
			case Interface.EXIT:
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
			}
		

		}
		
	}
	
}
