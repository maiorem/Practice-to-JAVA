package emp;

import java.sql.DriverManager;
import java.util.Scanner;

public class ManagerMain {
	
	static Scanner kb=new Scanner(System.in);;

	public static void main(String[] args) throws Exception {

		EmpManager empManager = new EmpManager();
		DeptManager deptManager = new DeptManager();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		while (true) {
			System.out.println("관리할 항목을 선택해주세요.");
			System.out.println("=================================");
			System.out.println("1. 사원 관리");
			System.out.println("2. 부서 관리");
			System.out.println("0. 프로그램 종료");
			System.out.println("=================================");
			int menu=Integer.parseInt(kb.nextLine());
			switch(menu) {
			case 1:
				empManager.empMenu();
				continue;
			case 2:
				deptManager.deptMenu();
				continue;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}

		}

	}


}
