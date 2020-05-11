package TimeTable;

import TimeTable.TimeTableManager;
import user.exception.OutOfNumberException;
import TimeTable.TimeTable;

public class TimeTableMenu {

	public void showTimeTableMenu() {

		TimeTableManager ttm = TimeTableManager.getInstatnce();
		int selectOpt;

		while (true) {

			System.out.println("---------------------------------");
			System.out.println("\t<<< 시 간 표 관 리 >>>");
			System.out.println("\t"+TimeTableMenuNum.INPUT_NUM + ".상영 시간 입력");
			System.out.println("\t"+TimeTableMenuNum.EDIT_NUM+ ".상영관 별 상영 시간 수정");
			System.out.println("\t"+TimeTableMenuNum.SHOW_ALLTIME + ".등록된 상영 시간 전체 출력");
			System.out.println("\t"+TimeTableMenuNum.EXIT + ".상영 시간 입력 종료");
			System.out.println("---------------------------------");
			while (true) {
				try {
					selectOpt = Integer.parseInt(ttm.ip.nextLine().trim());
					if (!(selectOpt > 0 && selectOpt < 5)) {
						OutOfNumberException e = new OutOfNumberException();
						throw e;
					}
				} catch (OutOfNumberException e) {
					System.out.println(e.getMessage());
					continue;
				} catch (Exception e) {
					System.out.println("■ 잘못된 입력입니다. 다시 입력해주세요 ■\n");
					continue;
				}
				break;
			}
			switch (selectOpt) {

			// 시간 입력
			case TimeTableMenuNum.INPUT_NUM:
				ttm.addInst(ttm.createTimeInst());
				break;
			// 입력된 수정
			case TimeTableMenuNum.EDIT_NUM:
				ttm.edit();
				break;
			// 입력된 시간 전체 출력
			case TimeTableMenuNum.SHOW_ALLTIME:
				System.out.println("▶ 선택한 날짜에 등록된 시간표를 출력합니다");
				for (int i = 0; i < 4; i++) {
					System.out.print(i + 1 + ") ");
					System.out.println(ttm.getTable().get(0).getStartTime().getDayOfMonth() + i + "일");
				}
				int choice;
				while(true) {
					try {
						choice = Integer.parseInt(ttm.ip.nextLine());
						if (!(0 < choice|| choice < 4)) {
							OutOfNumberException e = new OutOfNumberException();
							throw e;
						}
					} catch (OutOfNumberException e) {
						System.out.println(e.getMessage());
						continue;
					}catch (Exception e) {
						System.out.println("■ 잘못된 입력입니다. 다시 입력해주세요 ■\n");
						continue;
					}
				break;
				}
				for (int i = 0; i < ttm.getTable().size(); i++) {
					if (choice + 11 == ttm.getTable().get(i).getStartTime().getDayOfMonth()) {
						ttm.getTable().get(i).showTimeTable();
					}
				}
				break;
			case TimeTableMenuNum.EXIT:
				System.out.println("■ 상영 시간 입력을 종료합니다.");
				return;

			}

		}
	}

}
