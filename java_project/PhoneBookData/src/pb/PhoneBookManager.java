package pb;

import java.sql.Date;
import java.util.List;

public class PhoneBookManager {

	PhoneinfoBasicDao dao=new PhoneinfoBasicDao();

	public void phoneManager() {

		while(true) {
			System.out.println("===============================================");
			System.out.println("1.List 2.Search 3.Insert 4.Update 5.Delete 0.Exit");
			System.out.println("===============================================");
			int choice=Integer.parseInt(PhoneBookMain.sc.nextLine());
			switch(choice) {
			case 1:
				System.out.println("전체 리스트를 출력합니다.");
				allListPb();
				continue;
			case 2:
				System.out.println("검색을 진행합니다.");

				continue;
			case 3:
				System.out.println("새로운 정보를 입력합니다.");
				insertPb();
				continue;
			case 4:
				System.out.println("저장된 정보를 수정합니다.");
				continue;
			case 5:
				System.out.println("저장된 정보를 삭제합니다.");
				continue;
			case 0:
				System.out.println("Program Exit.");
				System.exit(0);
				break;
			}
		}
	}

	public void insertPb() {

		PhoneinfoBasic pb=null;
		PhoneinfoUniv pu=null;
		PhoneinfoCom pc=null;

		int resultCnt=0;
		int resultUni=0;
		int resultCom=0;

		System.out.println("저장할 그룹을 선택해주세요.");
		System.out.println("=============================");
		System.out.println("1.University 2.Company");
		System.out.println("=============================");
		int choice=Integer.parseInt(PhoneBookMain.sc.nextLine());

		System.out.println("정보 입력을 시작합니다.");
		System.out.print("인덱스 : ");
		int idx=Integer.parseInt(PhoneBookMain.sc.nextLine());
		System.out.print("이름 : ");
		String name=PhoneBookMain.sc.nextLine();
		System.out.print("전화번호 : ");
		String phone_num=PhoneBookMain.sc.nextLine();
		System.out.print("주소 : ");
		String address=PhoneBookMain.sc.nextLine();
		System.out.print("이메일 : ");
		String email=PhoneBookMain.sc.nextLine();
		Date regdate=null;

		pb=new PhoneinfoBasic(idx, name, phone_num, address, email, regdate);

		resultCnt=dao.insertPb(pb);

		switch(choice) {
		case 1:
			System.out.print("학교 인덱스 : ");
			int uIdx=Integer.parseInt(PhoneBookMain.sc.nextLine());
			System.out.print("전공 : ");
			String major=PhoneBookMain.sc.nextLine();
			System.out.print("학년 : ");
			int year=Integer.parseInt(PhoneBookMain.sc.nextLine());
			int ref=idx;

			pu=new PhoneinfoUniv(idx, name, phone_num, address, email, regdate, uIdx, major, year, ref);
			resultUni=dao.insertPU(pu);

			if (resultUni>0) {
				System.out.println("정상적으로 처리되었습니다.");
				System.out.println(resultCnt+"개 행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
			}

			return;

		case 2:
			System.out.print("회사 인덱스 : ");
			int cIdx=Integer.parseInt(PhoneBookMain.sc.nextLine());
			System.out.print("회사이름 : ");
			String company=PhoneBookMain.sc.nextLine();
			ref=idx;

			pc=new PhoneinfoCom(idx, name, phone_num, address, email, regdate, cIdx, company, ref);
			resultCom=dao.insertPC(pc);

			if (resultCom>0) {
				System.out.println("정상적으로 처리되었습니다.");
				System.out.println(resultCnt+"개 행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
			}

			return;
		}

	}

	public void allListPb() {

		List<PhoneinfoAll> list = dao.phoneinfoAllList();

		if (list!=null && !list.isEmpty()) {

			for(int i=0; i<list.size(); i++) {
				System.out.printf("%5s", list.get(i).getName()+"\t");
				System.out.printf("%12s", list.get(i).getPhone_num()+"\t");
				System.out.printf("%12s", list.get(i).getAddress()+"\t");
				System.out.printf("%12s", list.get(i).getEmail()+"\t");
				System.out.printf("%12s", list.get(i).getRegdate()+"\t");	
				System.out.printf("%12s", list.get(i).getMajor()+"\t");
				System.out.printf("%12s", list.get(i).getYear()+"\t");
				System.out.printf("%12s", list.get(i).getCompany()+"\n");
			}

		} else {
			System.out.println("입력된 데이터가 없습니다.");
		}

	}



}
