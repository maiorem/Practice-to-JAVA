package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpManager {

	Connection conn=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Scanner kb = new Scanner(System.in);
	
	
	void connectOracle() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pw="tiger";
			
			conn=DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void inputEmp() throws Exception {
		
		connectOracle();
		
		System.out.println("사원 번호를 입력하세요");
		int createEmpno = Integer.parseInt(kb.nextLine());
		System.out.println("사원 이름을 입력하세요");
		String createEname = kb.nextLine();
		System.out.println("직급을 입력하세요");
		String createJob = kb.nextLine();
		System.out.println("급여를 입력하세요");
		int createSal = Integer.parseInt(kb.nextLine());
		
		String sql = "insert into emp (empno, ename, job, sal) "
				+ " values (?, ?, ?, ?)";
		
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, createEmpno);
		pstmt.setString(2, createEname);
		pstmt.setString(3, createJob);
		pstmt.setInt(4, createSal);
		
		int resultCnt=pstmt.executeUpdate();
		
		if (resultCnt>0) {
			System.out.println("정상적으로 처리되었습니다.");
			System.out.println(resultCnt+"개 행이 입력되었습니다.");
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
		}

	}
	
	void updateEmp() throws SQLException {
		
		connectOracle();
		
		System.out.println("수정하고자 하는 사원의 이름을 입력하세요");
		String updateEname = kb.nextLine();
		System.out.println("부서번호를 입력하세요");
		int updateDeptno = Integer.parseInt(kb.nextLine());
		System.out.println("급여를 입력하세요");
		int updateSal = Integer.parseInt(kb.nextLine());
		
		String sql = "update emp (deptno, sal) set (?, ?) where ename='"+updateEname+"'";
		
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, updateDeptno);
		pstmt.setInt(2, updateSal);
		
		pstmt=conn.prepareStatement(sql);
		
		int resultCnt=pstmt.executeUpdate();
		
		if (resultCnt>0) {
			System.out.println("정상적으로 처리되었습니다.");
			System.out.println(resultCnt+"개 행이 수정되었습니다.");
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
		}
	}
	
	
	void deleteEmp() throws SQLException {
		
		
		connectOracle();
		
		System.out.println("삭제하고자 하는 사원번호를 입력하세요");
		int deleteEmpno = Integer.parseInt(kb.nextLine());
		
		String sql = "delete from emp where emptno="+deleteEmpno;

		int resultCnt=stmt.executeUpdate(sql);
		
		if (resultCnt>0) {
			System.out.println("정상적으로 처리되었습니다.");
			System.out.println(resultCnt+"개 행이 삭제되었습니다.");
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
		}
		
	}
	
	void searchEmp() throws SQLException {
		
		
		connectOracle();
		
		System.out.println("검색하고자 하는 사원이름을 입력하세요");
		String searchEname = kb.nextLine();
		
		String sql = "select * from emp where ename='"+searchEname+"'";
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		while (rs.next()) {
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t\t");
			System.out.print(rs.getInt(4)+"\t");
			System.out.print(rs.getDate(5)+"\t");
			System.out.print(rs.getInt(6)+"\t");
			System.out.print(rs.getInt(7)+"\t");
			System.out.print(rs.getInt(8)+"\n");
		}
		
	}
	
	void allEmpPrint() throws SQLException {

		connectOracle();
		
		stmt = conn.createStatement();
		
		String sql = "select * from emp";
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t\t");
			System.out.print(rs.getInt(4)+"\t");
			System.out.print(rs.getDate(5)+"\t");
			System.out.print(rs.getInt(6)+"\t");
			System.out.print(rs.getInt(7)+"\t");
			System.out.print(rs.getInt(8)+"\n");
			
			
		}
	}
	
	
	void inputDept() throws Exception {
		
		connectOracle();
		
		System.out.println("부서 번호를 입력하세요");
		int createdeptno = Integer.parseInt(kb.nextLine());
		System.out.println("부서이름을 입력하세요");
		String createDname = kb.nextLine();
		System.out.println("지역을 입력하세요");
		String createLoc = kb.nextLine();
		
		String sql = "insert into dept "
				+ " values (?, ?, ?)";
		
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, createdeptno);
		pstmt.setString(2, createDname);
		pstmt.setString(3, createLoc);

		
		int resultCnt=pstmt.executeUpdate();
		
		if (resultCnt>0) {
			System.out.println("정상적으로 처리되었습니다.");
			System.out.println(resultCnt+"개 행이 입력되었습니다.");
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
		}

	}
	
	void updateDept() throws SQLException {
		
		connectOracle();
		
		System.out.println("수정하고자 하는 부서의 번호를 입력하세요");
		int updateDeptno = Integer.parseInt(kb.nextLine());
		System.out.println("부서 이름을 입력하세요");
		String updateDname=kb.nextLine();
		System.out.println("지역을 입력하세요");
		String updateLoc=kb.nextLine();
		
		String sql = "update dept (dname, loc) set (?, ?) where ename='"+updateDeptno+"'";
		
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, updateDname);
		pstmt.setString(2, updateLoc);
		
		pstmt=conn.prepareStatement(sql);
		
		int resultCnt=pstmt.executeUpdate();
		
		if (resultCnt>0) {
			System.out.println("정상적으로 처리되었습니다.");
			System.out.println(resultCnt+"개 행이 수정되었습니다.");
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
		}
	}
	
	
	void deleteDept() throws SQLException {
		
		
		connectOracle();
		
		System.out.println("삭제하고자 하는 부서번호를 입력하세요");
		int deleteDeptno = Integer.parseInt(kb.nextLine());
		
		String sql = "delete from emp where emptno="+deleteDeptno;

		int resultCnt=stmt.executeUpdate(sql);
		
		if (resultCnt>0) {
			System.out.println("정상적으로 처리되었습니다.");
			System.out.println(resultCnt+"개 행이 삭제되었습니다.");
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
		}
		
	}
	
	void searchDept() throws SQLException {
		
		
		connectOracle();
		
		System.out.println("검색하고자 하는 부서의 이름이나 지역을 입력하세요");
		String search = kb.nextLine();
		
		String sql = "select * from dept where dname like '&"+search+"&' or loc like '&"+search+"&'";
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		while (rs.next()) {
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\n");
		}
		
	}
	
	void allDeptPrint() throws SQLException {

		connectOracle();
		
		stmt = conn.createStatement();
		
		String sql = "select * from dept";
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\n");
			
		}
	}
	
	
}
