package TimeTable;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import user.exception.EmptyStringException;
import user.exception.OutOfNumberException;

public class ScreenManager {

	private static ScreenManager sManager = new ScreenManager();

	public static ScreenManager getInstance() {
		return sManager;
	}

	Scanner sc;
	Screen screenInfo;
	ArrayList<Screen> screenList;
	int searchIndex;
	String name;
	int rowNum;
	int seatNum;
	int price;
	int opt = 0;

	private ScreenManager() {
		screenList = new ArrayList<>();
		sc = new Scanner(System.in);
		screenList.add(new Screen("1관", 5, 5, 10000));
		screenList.add(new Screen("2관", 5, 7, 10000));
		screenList.add(new Screen("3관", 6, 7, 10000));
		screenList.add(new Screen("IMAX관", 7, 8, 13000));
	}

	// 상영관 정보 입력 받고 인스턴스화
	// 예외처리 완료
	public Screen createScreenInfo() {

		screenInfo = null;

		System.out.println("\t<<<< 상영관 정보입력 >>>>");

		while (true) {

			try {
				System.out.println("▶ 상영관 이름을 입력하세요 : \n[예시]\n\"1관\"이면 숫자 \"1\"만 입력\n\"IMAX관\"이면\"IMAX\"만 입력");
				name = sc.nextLine().trim();

				if (name.isEmpty()) {
					EmptyStringException e = new EmptyStringException();
					throw e;
				}

			} catch (EmptyStringException e) {
				System.out.println("■ 공백은 입력할 수 없습니다 ■");
				continue;
			}

			catch (Exception e) {
				System.out.println("■ 잘못 입력하셨습니다 ■\n■ 다시 입력해주세요 ■");
				continue;
			}
			name = name + "관";
			break;
		}
		// 행와일
		while (true) {

			System.out.println("▶ 좌석 행을 입력하세요 : ");

			try {
				rowNum = Integer.parseInt(sc.nextLine().trim());
				if (rowNum < 1) {
					OutOfNumberException e = new OutOfNumberException();
					throw e;
				}

			} catch (InputMismatchException e) {
				System.out.println("■ 숫자로만 입력해주세요 ■");
				continue;
			} catch (OutOfNumberException e) {
				System.out.println("■ 입력하신 값으로 좌석을 만들 수 없습니다 ■");
				continue;
			} catch (Exception e) {
				System.out.println("■ 잘못 입력하셨습니다 ■\n■ 다시 입력해주세요 ■");
				continue;
			}
			break;
		}

		while (true) {

			System.out.println("▶ 좌석 열을 입력하세요 : ");

			try {
				seatNum = Integer.parseInt(sc.nextLine().trim());
				if (seatNum < 1) {
					OutOfNumberException e = new OutOfNumberException();
					throw e;
				}

			} catch (InputMismatchException e) {
				System.out.println("■ 숫자로만 입력해주세요 ■");
				continue;
			} catch (OutOfNumberException e) {
				System.out.println("■입력하신 값으로 좌석을 만들 수 없습니다 ■");
				continue;
			} catch (Exception e) {
				System.out.println("■ 잘못 입력하셨습니다 ■\n■ 다시 입력해주세요 ■");
				continue;
			}
			break;
		}

		while (true) {

			System.out.println("티켓 1매당 가격을 입력하세요 : ");

			try {
				price = Integer.parseInt(sc.nextLine().trim());
				if (price < 1) {
					OutOfNumberException e = new OutOfNumberException();
					throw e;
				}

			} catch (InputMismatchException e) {
				System.out.println("■ 숫자로만 입력해주세요 ■");
				continue;
			} catch (OutOfNumberException e) {
				System.out.println("■ 0이상의 가격을 입력해주세요 ■");
				continue;
			} catch (Exception e) {
				System.out.println("■ 잘못 입력하셨습니다 ■\n■ 다시 입력해주세요 ■");
				continue;
			}
			break;
		}

		screenInfo = new Screen(name, rowNum, seatNum, price);

		return screenInfo;
	}

	// 인스턴스 리스트에 저장함
	public void addInstance(Screen screenInfo) {
		for (int i = 0; i < screenList.size(); i++) {
			if (screenList.get(i).getName().equals(screenInfo.getName())) {
				System.out.println("■ 같은 이름의 상영관이 이미 존재합니다 ■");
				System.out.println();
				return;
			}
		}
				screenList.add(screenInfo);
				System.out.println("▶상영관 등록이 완료되었습니다.");
				System.out.println();
				System.out.println("▶영화 좌석 배치도를 출력합니다.");
				screenInfo.showScreenInfo();
	}

	// 리스트에서 찾는 인덱스 찾기
	public int searchIndexNum(String name) {

		searchIndex = -1;

		for (int i = 0; i < screenList.size(); i++) {
			if (screenList.get(i).checkScreenName(name)) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}

	// 상영관 정보 삭제
	public void deleteScreenInfo() {

		opt = 0;
		while (true) {

			if (screenList.isEmpty()) {
				System.out.println("■ 등록된 상영관이 없습니다 ■");
				System.out.println();
				return;
			} else {
				this.showAllScreenInfo();
				System.out.println("▶ 삭제하실 상영관을 선택하세요 : ");
			

			while (true) {

				// 예외 처리 필f요
				try {
					opt = Integer.parseInt(sManager.sc.nextLine().trim());
					if (!(opt <= screenList.size() && opt > 0)) {
						OutOfNumberException e = new OutOfNumberException();
						throw e;
					}
					if (Integer.toString(opt).isEmpty()) {
						EmptyStringException e = new EmptyStringException();
						throw e;
					}
				} catch (EmptyStringException e) {
					System.out.println("■ 공백은 입력하실 수 없습니다 ■");
					System.out.println();
					continue;
				} catch (InputMismatchException e) {
					System.out.println("■ 숫자로만 입력해주세요 ■");
					System.out.println();
					continue;
				} catch (OutOfNumberException e) {
					System.out.println("■ 등록된 상영관에서 맞는 번호를 입력하세요 ■");
					System.out.println();
					continue;
				} catch (Exception e) {
					System.out.println("■ 잘못 입력하셨습니다 ■\n■ 다시 입력해주세요 ■");
					System.out.println();
					continue;
				}

				break;
			}
			searchIndex = searchIndexNum(screenList.get(opt - 1).getName());

			if (searchIndex < 0) {
				System.out.println("■ 삭제하실 상영관을 찾을 수 없습니다 ■\n■ 상영관을 먼저 등록해주세요 ■");

			} else {
				// remove메서드 사용해서 검색된 searchIndex번째 요소 삭제
				screenList.remove(searchIndex);
				System.out.println("▶삭제되었습니다");
			}
			break;
		}
			
		}
	}

	// 상영관 수정
	//05.11 상영관 수정 삭제


	// 전체 정보 보기
	public void showAllScreenInfo() {

		if (screenList.size() == 0) {
			System.out.println("■ 현재 등록된 상영관이 없습니다 ■\n■ 상영관 정보를 먼저 등록하세요 ■");

		} else {

			for (int i = 0; i < screenList.size(); i++) {
				System.out.println();
				System.out.println(i + 1 + "]");
				System.out.println();
				screenList.get(i).showScreenInfo();
				System.out.println("---------------------------------");
			}
		}
	}

}
