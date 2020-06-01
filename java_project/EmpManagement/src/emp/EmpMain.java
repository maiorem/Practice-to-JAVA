package emp;


public class EmpMain {

	public static void main(String[] args) throws Exception {

		EmpManager manager = new EmpManager();

		while (true) outerloop: {
			menu();
			int menu=Integer.parseInt(manager.kb.nextLine());
			if(menu==1) {
				while(true) {
					menuEmp();
					int choice=Integer.parseInt(manager.kb.nextLine());
					switch(choice) {
					case 1:
						manager.allEmpPrint();
						continue;
					case 2:
						manager.searchEmp();
						continue;
					case 3:
						manager.inputEmp();
						continue;
					case 4:
						manager.updateEmp();
						continue;
					case 5:
						manager.deleteEmp();
						continue;
					case 6:
						System.out.println("처음으로 돌아갑니다.");
						break outerloop;

					}
				}
			} else if(menu==2) {
				while(true) {
					menuDept();
					int choice=Integer.parseInt(manager.kb.nextLine());
					switch(choice) {
					case 1:
						manager.allDeptPrint();
						continue;
					case 2:
						manager.searchDept();
						continue;
					case 3:
						manager.inputDept();
						continue;
					case 4:
						manager.updateDept();
						continue;
					case 5:
						manager.deleteDept();
						continue;
					case 6:
						System.out.println("처음으로 돌아갑니다.");
						break outerloop;
					} 
				}

			} else {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}

		}

	}



	static void menu() {

		System.out.println("관리할 항목을 선택해주세요.");
		System.out.println("=================================");
		System.out.println("1. 사원 관리");
		System.out.println("2. 부서 관리");
		System.out.println("0. 프로그램 종료");
		System.out.println("=================================");

	}

	static void menuEmp() {

		System.out.println("사원관리 페이지입니다.");
		System.out.println("무엇을 하시겠습니까?");
		System.out.println("=================================");
		System.out.println("1. 사원 전체 출력");
		System.out.println("2. 사원 검색");
		System.out.println("3. 새로운 사원 입력");
		System.out.println("4. 사원 수정");
		System.out.println("5. 사원 삭제");
		System.out.println("6. 돌아가기");
		System.out.println("=================================");

	}

	static void menuDept() {
		System.out.println("부서관리 페이지입니다.");
		System.out.println("무엇을 하시겠습니까?");
		System.out.println("=================================");
		System.out.println("1. 부서 전체 출력");
		System.out.println("2. 부서 검색");
		System.out.println("3. 새로운 부서 입력");
		System.out.println("4. 부서 수정");
		System.out.println("5. 부서 삭제");
		System.out.println("6. 돌아가기");
		System.out.println("=================================");
	}

}
