package Movie;

public class MovieMenu {

	public void ShowMenu() {
		MovieManager m = MovieManager.getInstance();
		
		int num;
		
		while(true) {
			
		//메뉴 출력	
		MenuPrint.MovieMenu();
		
		//메뉴 선택  예외
		try{
			num = Integer.parseInt(m.ip.nextLine().trim());
			if(!(MenuIf.MENUHOME<=num&&num<=MenuIf.DEL)) { 
				InputException input=new InputException();
				throw input;
			}
		}catch(NumberFormatException e) { //문자 입력 오류
			System.out.println("※※※※숫자로 다시 입력해주세요.※※※※ \n");
			continue;
		}catch(InputException input) { //숫자 범위 오류 
			input.menuErr();
			continue;
		}
		
	
		//메뉴 별 기능 
		switch (num) {
		case MenuIf.SHOWALL: //영화 전체 출력
			System.out.println("\n\t<< 영화 정보 전체 출력 >>");
			System.out.println("--------------------------------");
			m.showAllMovie();
			break;
		case MenuIf.ADD: //영화 추가
			System.out.println("\n\t<< 영화 정보 추가  >>");
			m.addMovie();
			break;
		case MenuIf.EDIT: //영화 수정
			System.out.println("\n\t<< 영화 정보 수정  >>");
			m.editMovie();
			break;
		case MenuIf.DEL: //영화 삭제
			System.out.println("\n\t<< 영화 정보 삭제  >>");
			m.delMovie();
			break;
		case MenuIf.MENUHOME: //홈으로 이동 
			 System.out.println("▶ 메뉴로 돌아갑니다.");
			return;
		} //switch
		
		}//while
	} //Menu()
}//class
