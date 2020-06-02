package pb;

import java.sql.Date;
import java.util.List;

public class PhoneBookManager {

	PhoneinfoDao dao=new PhoneinfoDao();

	public void phoneManager() {

		while(true) {
			System.out.println("----------------------------------------------------");
			System.out.println(" M Y P H O N E B O O K ");
			System.out.println("====================================================");
			System.out.println("1.List 2.Search 3.Insert 4.Update 5.Delete 0.Exit");
			System.out.println("====================================================");
			int choice=Integer.parseInt(PhoneBookMain.sc.nextLine());
			switch(choice) {
			case 1:
				System.out.println("전체 리스트를 출력합니다.");
				allListPb();
				continue;
			case 2:
				System.out.println("검색을 진행합니다.");
				searchPb();
				continue;
			case 3:
				System.out.println("새로운 정보를 입력합니다.");
				insertPb();
				continue;
			case 4:
				System.out.println("저장된 정보를 수정합니다.");
				editPb();
				continue;
			case 5:
				System.out.println("저장된 정보를 삭제합니다.");
				deletePb();
				continue;
			case 0:
				System.out.println("Program Exit.");
				System.exit(0);
				break;
			}
		}
	}

	
	public void insertPb() {

		PhoneinfoAll pi = null;

		int resultUni=0;
		int resultCom=0;

		System.out.println("저장할 그룹을 선택해주세요.");
		System.out.println("=============================");
		System.out.println("1.University 2.Company");
		System.out.println("=============================");
		int choice=Integer.parseInt(PhoneBookMain.sc.nextLine());

		System.out.println("정보 입력을 시작합니다.");
		System.out.print("이름 : ");
		String name=PhoneBookMain.sc.nextLine();
		System.out.print("전화번호 : ");
		String phone_num=PhoneBookMain.sc.nextLine();
		System.out.print("주소 : ");
		String address=PhoneBookMain.sc.nextLine();
		System.out.print("이메일 : ");
		String email=PhoneBookMain.sc.nextLine();

		switch(choice) {
		case 1:
			String type="UNIV";			
			System.out.print("전공 : ");
			String major=PhoneBookMain.sc.nextLine();
			System.out.print("학년 : ");
			int grade=Integer.parseInt(PhoneBookMain.sc.nextLine());
			String dept=null;
			String job=null;
			
			
			pi=new PhoneinfoAll(type, name, phone_num, address, email, major, grade, dept, job);
			
			resultUni=dao.insertPi(pi);

			if (resultUni>0) {
				System.out.println("정상적으로 처리되었습니다.");
				System.out.println(resultUni+"개 행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
			}

			return;

		case 2:
			type="COM";
			major=null;
			grade=0;
			System.out.print("부서명 : ");
			dept=PhoneBookMain.sc.nextLine();
			System.out.print("직급 : ");
			job=PhoneBookMain.sc.nextLine();

			pi=new PhoneinfoAll(type, name, phone_num, address, email, major, grade, dept, job);

			resultCom=dao.insertPi(pi);

			if (resultCom>0) {
				System.out.println("정상적으로 처리되었습니다.");
				System.out.println(resultCom+"개 행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
			}

			return;
		}

	}

	
	public void deletePb() {
		
		System.out.println("삭제하고자 하는 이름을 입력하세요.");
		String name=PhoneBookMain.sc.nextLine();
		
		int resultCnt=dao.deletePb(name);
		
		if(resultCnt>0) {
			System.out.println("정상적으로 처리되었습니다.");
			System.out.println(resultCnt+"개 행이 삭제되었습니다.");
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
		}
		
	}
	
	
	public void editPb() {
		
		
		
		
	}
	
	
	public void searchPb() {
		
		System.out.println("검색하려는 이름을 입력하세요.");
		String name=PhoneBookMain.sc.nextLine();
		
		List<PhoneinfoAll> list = dao.searchInfo(name);
		
		System.out.println("검색 결과");
		System.out.println("===================================================");
		for(int i=0; i<list.size(); i++) {
			System.out.printf("%3s", list.get(i).getIdx()+"\t");
			System.out.printf("%5s", list.get(i).getType()+"\t");
			System.out.printf("%5s", list.get(i).getName()+"\t");
			System.out.printf("%5s", list.get(i).getPhone_num()+"\t");
			System.out.printf("%5s", list.get(i).getAddress()+"\t");
			System.out.printf("%5s", list.get(i).getEmail()+"\t");
			System.out.printf("%5s", list.get(i).getMajor()+"\t");
			System.out.printf("%5s", list.get(i).getGrade()+"\t");
			System.out.printf("%5s", list.get(i).getDept()+"\t");
			System.out.printf("%5s", list.get(i).getJob()+"\n");
		}
		
	}
	
	
	public void allListPb() {

		List<PhoneinfoAll> list = dao.phoneinfoAllList();

		if (list!=null && !list.isEmpty()) {
			System.out.println("===================================================");
			for(int i=0; i<list.size(); i++) {
				System.out.printf("%3s", list.get(i).getIdx()+"\t");
				System.out.printf("%5s", list.get(i).getType()+"\t");
				System.out.printf("%5s", list.get(i).getName()+"\t");
				System.out.printf("%5s", list.get(i).getPhone_num()+"\t");
				System.out.printf("%5s", list.get(i).getAddress()+"\t");
				System.out.printf("%5s", list.get(i).getEmail()+"\t");
				System.out.printf("%5s", list.get(i).getMajor()+"\t");
				System.out.printf("%5s", list.get(i).getGrade()+"\t");
				System.out.printf("%5s", list.get(i).getDept()+"\t");
				System.out.printf("%5s", list.get(i).getJob()+"\n");
			}
			

		} else {
			System.out.println("입력된 데이터가 없습니다.");
		}

	}



}
