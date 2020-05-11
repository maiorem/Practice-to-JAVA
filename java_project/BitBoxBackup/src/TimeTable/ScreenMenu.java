package TimeTable;

import java.util.InputMismatchException;

import user.exception.EmptyStringException;
import user.exception.OutOfNumberException;

public class ScreenMenu {

	public void showScreenMenu() {

		ScreenManager sManager = ScreenManager.getInstance();

		int selectOpt = 0;
		while (true) {

			System.out.println("---------------------------------");
			System.out.println("\t<<<< 상영관 관리 >>>>");
			System.out.println("\t메뉴를 선택하세요.");
			System.out.println("\t"+ScreenMenuNum.INPUT_SCREEN+". 상영관 정보 등록");
			System.out.println("\t"+ScreenMenuNum.DELETE_SCREEN+". 상영관 삭제");
			System.out.println("\t"+ScreenMenuNum.SHOWALL_SCREEN+". 등록된 상영관 정보 모두 보기");
			System.out.println("\t"+ScreenMenuNum.EXIT_SCREEN+". 상영관 관리 종료");
			System.out.println("---------------------------------");
			try {
				selectOpt = Integer.parseInt(sManager.sc.nextLine().trim());
				if (!(selectOpt > 0 && selectOpt <= 5)) {
					OutOfNumberException e = new OutOfNumberException();
					throw e;
				}
			} catch (OutOfNumberException e) {
				System.out.println("■메뉴에 있는 번호를 선택해주세요■");
				continue;
			} catch (Exception e) {
				System.out.println("■잘못 입력하셨습니다■\n■다시 입력해주세요■");
				continue;
			}

			switch (selectOpt) {
			case ScreenMenuNum.INPUT_SCREEN:
				sManager.addInstance(sManager.createScreenInfo());
				break;
			case ScreenMenuNum.DELETE_SCREEN:
				sManager.deleteScreenInfo();
				break;
			case ScreenMenuNum.SHOWALL_SCREEN:
				sManager.showAllScreenInfo();
				break;
			case ScreenMenuNum.EXIT_SCREEN:
				System.out.println("▶상영관 입력을 종료합니다");
				return;
			case 5:
				
			}

		}
	}

}
