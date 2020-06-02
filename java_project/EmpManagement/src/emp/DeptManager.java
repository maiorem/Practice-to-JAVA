package emp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DeptManager {

	DeptDao dao = new DeptDao();
	
	public void deptMenu() throws Exception {
		while(true) {
			System.out.println("=================================");
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
				System.out.println("부서 전체 리스트를 출력합니다.");
				deptList();
				continue;
			case 2:
				System.out.println("부서를 검색합니다.");
				deptSearch();
				// 사용자가 입력한 이름을 dao의 search 메서드에 전달.
				continue;
			case 3:
				System.out.println("새로운 부서 정보를 입력합니다.");
				deptInsert();
				// 사용자 입력데이터를 dept 객체에 담아서 dao input 메서드로 전달
				continue;
			case 4:
				System.out.println("부서 정보를 수정합니다.");
				deptEdit();
				// 1. 수정하고자 하는 데이터 유무 확인
				// 2. 사용자로부터 데이터를 받아서 dao에 전달
				continue;
			case 5:
				System.out.println("부서 정보를 삭제합니다.");
				deptDelete();
				// 부서번호를 dao의 delete에 전달
				continue;
			case 6:
				System.out.println("처음으로 돌아갑니다.");
				return;
			} 
		}
	}
	
	public void deptEdit() {
		
		Connection conn=null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false); //기본값은 true:자동커밋
			
			// 1. 수정하고자 하는 데이터 유무 확인
			System.out.println("수정하고자 하는 부서의 번호를 입력하세요");
			int searchDeptno = Integer.parseInt(ManagerMain.kb.nextLine());
			
			int rowCnt = dao.searchCount(searchDeptno, conn);
			System.out.println(rowCnt);
			
			if(rowCnt>0) {
				//2. 사용자로부터 데이터를 받아서 dao에 전달
				Dept dept=dao.deptSearchDeptno(searchDeptno, conn);
				
				if(dept==null) {
					System.out.println("찾으시는 정보가 존재하지 않습니다.");
					return;
				}
				
				System.out.println("부서 정보 수정을 시작합니다.");
				System.out.println("부서 번호 : "+dept.getDeptno());
				System.out.println("부서 이름을 입력하세요 ("+dept.getDname()+")");
				String dname=ManagerMain.kb.nextLine();
				System.out.println("지역을 입력하세요 ("+dept.getLoc()+")");
				String loc=ManagerMain.kb.nextLine();
				
				Dept newDept = new Dept(dept.getDeptno(), dname, loc);
				
				int resultCnt=dao.updateDept(newDept, conn);
				
				if (resultCnt>0) {
					System.out.println("정상적으로 처리되었습니다.");
					System.out.println(resultCnt+"개 행이 수정되었습니다.");
				} else {
					System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
				}
				
				
				
			} else {
				System.out.println("찾으시는 정보가 존재하지 않습니다.");
			}
			
			conn.commit();
			
		} catch (SQLException e) {
			
			if(conn!=null ) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			e.printStackTrace();
		}
		

		
	}
	
	

	public void deptInsert() {
		
		System.out.println("부서 번호를 입력하세요");
		int deptno = Integer.parseInt(ManagerMain.kb.nextLine());
		System.out.println("부서이름을 입력하세요");
		String dname = ManagerMain.kb.nextLine();
		System.out.println("지역을 입력하세요");
		String loc = ManagerMain.kb.nextLine();
		
		Dept dept = new Dept(deptno, dname, loc);
		
		int resultCnt=dao.inputDept(dept);
		
		if (resultCnt>0) {
			System.out.println("정상적으로 처리되었습니다.");
			System.out.println(resultCnt+"개 행이 입력되었습니다.");
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
		}
		
	}
	
	
	public void deptDelete() {
		
		System.out.println("삭제하고자 하는 부서번호를 입력하세요");
		int deleteDeptno = Integer.parseInt(ManagerMain.kb.nextLine());
		
		int resultCnt=dao.deleteDept(deleteDeptno);
		
		if (resultCnt>0) {
			System.out.println("정상적으로 처리되었습니다.");
			System.out.println(resultCnt+"개 행이 삭제되었습니다.");
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
		}
		
	}

	
	public void deptSearch() {
		
		System.out.println("검색하고자 하는 부서의 이름을 입력하세요");
		String searchName = ManagerMain.kb.nextLine();
		
		List<Dept> list = dao.searchDept(searchName);
		
		System.out.println("검색 결과");
		System.out.println("==================================");
		for(Dept d: list) {
			System.out.printf("%5s", d.getDeptno() + "\t");
			System.out.printf("%12s", d.getDname() + "\t");
			System.out.printf("%12s", d.getLoc() + "\n");
		}
		System.out.println("==================================");

		
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
