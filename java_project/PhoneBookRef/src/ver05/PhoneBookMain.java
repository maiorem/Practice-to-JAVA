package ver05;

import java.util.InputMismatchException;

import ver05.exception.BadNumberException;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while (true) {
			Menu.showMenu();
			int select=0;
			try {
				select=manager.kb.nextInt();
				
				//정상범위 : 1~6
				//=MenuNum.INSERT ~ MenuNum.EXIT
				if (!(select>=MenuNum.INSERT && select<=MenuNum.EXIT)) {
					BadNumberException ex = new BadNumberException("메뉴 범위를 벗어나는 번호입니다. \n다시 입력해 주세요.");
					// 강제적인 예외 발생
					throw ex;					
				}
				
			} catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 입력입니다.");
				System.out.println("다시 입력해주세요.");
				continue;
			} catch(BadNumberException e) {
				System.out.println(e.getMessage());
				continue;
			} catch(Exception e) {
				System.out.println("잘못된 메뉴 입력입니다.");
				System.out.println("다시 입력해주세요.");
				continue;
			} finally {
				manager.kb.nextLine();
			}
			
			switch(select) {
			case MenuNum.INSERT:
				manager.createInfo();
				break;
			case MenuNum.SEARCH:
				manager.showInfo();
				break;
			case MenuNum.DELETE:
				manager.delete();
				break;
			case MenuNum.EDIT:
				manager.editInfo();
				break;
			case MenuNum.SHOWALL:
				manager.showAllInfo();
				break;
			case MenuNum.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;		
			}
			
		}

	}

}
