package Movie;

public class MenuPrint {

	public static void MovieMenu(){
		
		System.out.println("\n----------------------------------");
		System.out.println("\t<<<< 영 화 관 리 >>>>");
		System.out.println("\t"+MenuIf.SHOWALL+". 영화 전체 출력");
		System.out.println("\t"+MenuIf.ADD+". 영화 추가");
		System.out.println("\t"+MenuIf.EDIT+". 영화 수정");
		System.out.println("\t"+MenuIf.DEL+". 영화 삭제");
		System.out.println("\t"+MenuIf.MENUHOME+". 홈으로 돌아가기 ");
		System.out.println("---------------------------------");
	}
	
	public static void MenuEdit() {
		System.out.println("----------------------------------");
		System.out.println("\t<< 수정  메뉴를 선택하세요  >>");
		System.out.println("\t"+MenuIf.EDITMENU1+". 영화 제목 수정");
		System.out.println("\t"+MenuIf.EDITMENU2+". 영화 감독 수정");
		System.out.println("\t"+MenuIf.EDITMENU3+". 영화 런타임 수정");
		System.out.println("\t"+MenuIf.EDITMENU4+". 영화 연령 수정");
		System.out.println("\t"+MenuIf.MENUHOME+". 영화 메뉴로 돌아가기");
		System.out.println("----------------------------------");
		
	}
	
	public static void MenuDelete() {
		System.out.println("\t"+MenuIf.DELETEMENU1+". YES");
		System.out.println("\t"+MenuIf.DELETEMENU2+". NO");
		System.out.println("\t"+MenuIf.MENUHOME+". 영화 메뉴로 돌아가기");
		System.out.println("----------------------------------");
	}
	
		
}
