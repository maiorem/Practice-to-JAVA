package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class EmpManager {
	
	EmpDao dao = new EmpDao();
	
	public void empMenu() throws Exception {
		while(true) {
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
			int choice=Integer.parseInt(ManagerMain.kb.nextLine());
			switch(choice) {
			case 1:
				empList();
				continue;
			case 2:
				dao.searchEmp();
				continue;
			case 3:
				dao.inputEmp();
				continue;
			case 4:
				dao.updateEmp();
				continue;
			case 5:
				dao.deleteEmp();
				continue;
			case 6:
				System.out.println("처음으로 돌아갑니다.");
				return;

			}
		}
	}

	public void empList( ) {
		List<Emp> empList = dao.allEmpPrint();
		
		if(empList !=null && !empList.isEmpty()) {
			
			for(int i=0; i<empList.size(); i++) {
				System.out.printf("%5s", empList.get(i).getEmpno()+"\t");
				System.out.printf("%12s", empList.get(i).getEname()+"\t");
				System.out.printf("%12s", empList.get(i).getEname()+"\t");
				System.out.printf("%12s", empList.get(i).getJob()+"\t");
				System.out.printf("%12s", empList.get(i).getSal()+"\t");
				System.out.printf("%12s", empList.get(i).getMgr()+"\t");
				System.out.printf("%12s", empList.get(i).getHiredate()+"\t");
				System.out.printf("%12s", empList.get(i).getComm()+"\t");
				System.out.printf("%12s", empList.get(i).getEname()+"\n");

			}
		} else {
			System.out.println("입력된 데이터가 없습니다.");
		}
	}
	

}



