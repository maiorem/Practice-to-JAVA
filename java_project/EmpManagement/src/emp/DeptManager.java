package emp;

import java.sql.SQLException;
import java.util.List;

public class DeptManager {

	DeptDao dao = new DeptDao();
	
	public void deptMenu() throws Exception {
		while(true) {
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
			int choice=Integer.parseInt(ManagerMain.kb.nextLine());
			switch(choice) {
			case 1:
				deptList();
				continue;
			case 2:
				dao.searchDept();
				continue;
			case 3:
				dao.inputDept();
				continue;
			case 4:
				dao.updateDept();
				continue;
			case 5:
				dao.deleteDept();
				continue;
			case 6:
				System.out.println("처음으로 돌아갑니다.");
				return;
			} 
		}
	}
	
	public void deptList() throws SQLException {
		
		List<Dept> deptList = dao.allDeptPrint();
		
		if(deptList!=null && !deptList.isEmpty()) {
			
			for(int i=0; i<deptList.size(); i++) {
				System.out.printf("%5s", deptList.get(i).getDeptno()+"\t");
				System.out.printf("%12s", deptList.get(i).getDname()+"\t");
				System.out.printf("%12s", deptList.get(i).getLoc()+"\n");
			}
		} else {
			System.out.println("입력된 데이터가 없습니다.");
		}
		
		
	}
	
}
