package Movie;

import java.util.ArrayList;
import java.util.Scanner;


public class MovieManager {
	//싱글톤 - 메서드사용해서 참조변수
	private static MovieManager mManager = new MovieManager();
	public static MovieManager getInstance() {
		return mManager;
	}
	
	ArrayList<Movie> movieList;
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	Scanner ip = new Scanner(System.in);
	private String title;
	private String director;
	private int runtime;
	private int grade;
	
	MovieManager(){
		movieList = new ArrayList<>();
		movieList.add(new Movie("기생충", "봉준호",131,15));
		movieList.add(new Movie("겨울왕국2","크리스 벅",103,5));
		movieList.add(new Movie("아가씨","박찬욱",144,19));
		movieList.add(new Movie("어벤져스","안소니 루소, 조 루소",181,12));

	}
	
	//영화 정보 전체 출력
	public void showAllMovie() {
		for(int i=0;i<movieList.size();i++) {
			System.out.println("영화 제목:  "+movieList.get(i).getTitle());
			System.out.println("영화 감독:  "+movieList.get(i).getDirector());
			System.out.println("영화 런타임: "+movieList.get(i).getRuntime());
			System.out.println("영화 연령:  "+movieList.get(i).getGrade()+"세");
			System.out.println("--------------------------------");
		} 
		System.out.println();
	}
	
	
	//입력 값 예외 처리 
	String checkInput(String check) {
		while(true) {
		try { 
			if(check.trim().isEmpty()) { //공백일 때 예외 발생 
				InputException e=new InputException();
				throw e;
			} 
		}catch(InputException e) { 
			e.titleErr();
			check=ip.nextLine();
			continue;
		} 
		return check;
		}
	}
	
	
	//런타임 숫자 예외 처리
	int checkRuntime(String edit) {
		
		int edittime;
		while(true) {
		try {
			edittime=Integer.parseInt(edit);
		}catch(NumberFormatException number) {
			System.out.println("※※※※※ 숫자로 입력하세요 ※※※※※※ ");
			edit=ip.nextLine();
			continue;
		}
		return edittime;
		}
	}
	
	//영화 추가 
	public void addMovie() {
		
		while(true) {
		
		System.out.println("영화 제목 입력 : ");
		title = ip.nextLine();
		title=checkInput(title);
	
		for(int i=0;i<movieList.size();i++) { //영화 제목이 동일 할 때 다른 영화 추가 
			if(movieList.get(i).getTitle().equals(title)) {
				System.out.println("※※※ 동일 영화가 있습니다. 다른 영화를 추가하세요.※※※ \n");
				addMovie();
				return;
			}
		}
		
		System.out.println("영화 감독 입력 : ");
		director = ip.nextLine();
		director=checkInput(director);
		
		System.out.println("영화 런타임 입력 : ");
		String runtimeStr=ip.nextLine();
		runtimeStr =checkInput(runtimeStr);
		runtime=checkRuntime(runtimeStr);

		System.out.println("연령 입력: ");
		String gradeStr=ip.nextLine();
		gradeStr =checkInput(gradeStr);
		grade=checkRuntime(gradeStr);
		
		
		movieList.add(new Movie(title, director, runtime,grade));	
		System.out.println("-------- 신작 영화가 등록되었습니다  -------- \n");
		break;
		}
	}	
		
		
	//영화 정보 여부 확인
	int index;
	int checkName(String title) {
		index=-1;
		for(int i=0;i<movieList.size();i++) {
			if(movieList.get(i).getTitle().equals(title)) {
				System.out.println("영화 제목  \""+title+"\" 이 선택되었습니다. \n");
				index=i;
			}
		}
		return index;
	}
	
	
	
	void editAllShow() {
		System.out.println("\n========\""+title+"\" 수정 내용 =========");
		movieList.get(index).showMovieInfo();
		System.out.println();
	}
	
	
	//영화 수정
	public void editMovie() {
		
			System.out.println("------ 수정 할 영화 제목을 입력하세요  ------");	
			title=ip.nextLine();
			title=checkInput(title); //공백 예외 처리 
			index=checkName(title);
			
			while(true) {
				
			try {
				if(index<0) {
					InputException e=new InputException();
					throw e;
				}
			}catch(InputException e) {
				e.nameErr();
				
			}
				
			MenuPrint.MenuEdit();
			
			int editMenu=-1;
			try{
				editMenu = Integer.parseInt(ip.nextLine().trim());
				if(!(MenuIf.MENUHOME<=editMenu&&editMenu<=MenuIf.EDITMENU4)) {
					InputException input=new InputException();
					throw input;
				}
			}
			catch(NumberFormatException e) { //문자 입력시 형변환 오류 
				System.out.println("※※※※숫자로 다시 입력해주세요.※※※※ \n");
			}catch(InputException input) { 
				input.menuErr();
			}
		
			switch (editMenu) {
			
			//영화 제목 수정
			case MenuIf.EDITMENU1: 
				System.out.println("영화 제목 입력: ");
				String editTitle=ip.nextLine();
				editTitle=checkInput(editTitle); //예외 처리 
				movieList.get(index).setTitle(editTitle);
				title=editTitle;
				editAllShow();
				break;
				
			 //영화 감독 수정	
			case MenuIf.EDITMENU2:
				System.out.println("영화 감독 입력: ");
				String editDirector=ip.nextLine();
				editDirector=checkInput(editDirector); //예외 처리 
				movieList.get(index).setDirector(editDirector);
				editAllShow();
				break;
			
			//영화 런타임 수정
			case MenuIf.EDITMENU3: 
				System.out.println("영화  런타임 입력: ");
				String editRuntimeStr=ip.nextLine();
				editRuntimeStr=checkInput(editRuntimeStr); //공백 처리 
				int editRuntime=checkRuntime(editRuntimeStr); //문자 입력 오류 
				movieList.get(index).setRuntime(editRuntime);
				editAllShow();
				break;
				
			//영화 연령 수정
			case MenuIf.EDITMENU4: 
				System.out.println("영화  연령 입력: ");
				String editGradeStr=ip.nextLine();
				editGradeStr=checkInput(editGradeStr); //공백 처리 
				int editGrade=checkRuntime(editGradeStr); //문자 입력 오류 
				movieList.get(index).setGrade(editGrade);
				editAllShow();
				break;	
				

			//영화 메뉴로 이동 
			case MenuIf.MENUHOME:
				System.out.println("▶ 메뉴로 돌아갑니다.");
				System.out.println();
				return;
				
				} //switch - 영화 정보 수정 
			
		}//while
	
	}
	
	//영화 삭제
	public void delMovie() {
		System.out.println("-------- 삭제 할 영화 제목을 입력하세요 -------");
		while(true) {
			title=ip.nextLine();
			title=checkInput(title); //공백 예외 처리 
			index=checkName(title);
			
			try {
				if(index<0) {
					InputException e=new InputException();
					throw e;
				}
			}catch(InputException e) {
				e.nameErr();
				continue;
			}

			//영화 수정 사항 여부 확인 
			while(true) {
			System.out.println("-------\""+title+"\" 삭제 여부 확인 ----------");
			
			MenuPrint.MenuDelete();
			
			//메뉴 선택 예외 처리 
			int deleteMenu;
			try {
				deleteMenu=Integer.parseInt(ip.nextLine().trim());
				if(!(MenuIf.MENUHOME<=deleteMenu&&deleteMenu<=MenuIf.DELETEMENU2)) {
					InputException input=new InputException();
					throw input;
				}
			}catch(NumberFormatException e) {
				System.out.println("※※※※숫자로 다시 입력해주세요.※※※※ \n");
				continue;
			}catch(InputException input) { 
				input.menuErr();
				continue;
			}
			
			switch(deleteMenu) {
			
			//영화 삭제
			case MenuIf.DELETEMENU1:
				movieList.remove(index);
				System.out.println("----------------------------------");
				System.out.println("영화  \""+title+"\""+"이  삭제되었습니다. \n");
				return;
			
			//영화 삭제 불가
			case MenuIf.DELETEMENU2:
				System.out.println("삭제 되지 않았습니다. 삭제를 원하시면 YES 메뉴를 선택하세요. \n");
				break;
			
			//영화 메뉴로 이동 
			case MenuIf.MENUHOME:
				System.out.println("▶ 메뉴로 돌아갑니다.");
				System.out.println();
				return;
				} //switch 
			} //while-영화 수정 여부
		}//while
		
		
		
		
				
		
	}
	
	

}