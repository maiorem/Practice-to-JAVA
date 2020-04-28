package ver06;

import java.util.InputMismatchException;

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
			
			int num = 0;
			try {
				num=readNum();
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하셔야 합니다..");
				System.out.println("다시 입력해주세요.");
				manage.sc.nextLine();
				continue;
			} catch (MenuInputException e) {
				System.out.println(e.getMessage());
				System.out.println("처음으로 돌아갑니다.");
				manage.sc.nextLine();
				continue;
			}
			
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
				int choice = 0;
				
				try {
					choice=readChoice();
				} catch(InputMismatchException e) {
					System.out.println("숫자를 입력하셔야 합니다.");
					System.out.println("처음으로 돌아갑니다.");
					manage.sc.nextLine();
					continue;
				} catch (MenuInputException e) {
					System.out.println(e.getMessage());
					System.out.println("처음으로 돌아갑니다.");
					manage.sc.nextLine();
					continue;
				}
				manage.sc.nextLine();
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
	
	int readNum () throws MenuInputException {
		int num=manage.sc.nextInt();
		if(num<0 || num>7) {
			MenuInputException except = new MenuInputException();
			throw except;
		}
		return num;
	}
	
	int readChoice() throws MenuInputException {
		int choice=manage.sc.nextInt();
		if(choice<0 || choice>4) {
			MenuInputException except = new MenuInputException();
			throw except;
		}
		return choice;
	}
}
