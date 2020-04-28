package friend;

public class FriendMain {

	public static void main(String[] args) {
		
		FriendInfoHandler handler = FriendInfoHandler.getInstance();

		while (true) {
			System.out.println("===== 메뉴를 선택 해 주세요 =====");
			System.out.println(" "+Menu.INSERT_HIGH+". 고교친구 저장");
			System.out.println(" "+Menu.INSERT_UNIV+". 대학친구 저장");
			System.out.println(" "+Menu.PRINT_BASIC+". 기본 정보 출력");
			System.out.println(" "+Menu.PRINT_ALL+". 상세 정보 출력");
			System.out.println(" "+Menu.EXIT+". 프로그램 종료");
			System.out.println("=============================");

			int choice = handler.sc.nextInt();
			handler.sc.nextLine(); // 앞의 버퍼를 클리어
			
			switch(choice) {
			case Menu.INSERT_HIGH: case Menu.INSERT_UNIV:
				handler.addFriend(choice);
				break;
			case Menu.PRINT_BASIC:
				handler.showAllSimpleData();
				break;
			case Menu.PRINT_ALL:
				handler.showAllDate();
				break;
			case Menu.EXIT:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			
			}
		}
		
	}

}
