package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest5 {

	public static void main(String[] args)  {

		Connection conn = null;
		Statement stmt = null;
		
		//1. DB 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");

			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "SCOTT";
			String pw = "tiger";
			
			//2. 데이터베이스에 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");


			//3. Statement
			stmt = conn.createStatement();
			
			Scanner kb = new Scanner(System.in);
			
			System.out.println("사원 번호를 입력하세요");
			int createEmpno = Integer.parseInt(kb.nextLine());
			System.out.println("사원 이름을 입력하세요");
			String createEname = kb.nextLine();
			System.out.println("직급을 입력하세요");
			String createJob = kb.nextLine();
			System.out.println("급여를 입력하세요");
			int createSal = Integer.parseInt(kb.nextLine());
			
			String sql = "insert into emp (empno, ename, job, sal) "
					+ " values ( "+createEmpno+", '"+createEname+"', '"+createJob+"',"+createSal+")";
			
			int resultCnt = stmt.executeUpdate(sql);
			
			System.out.println(resultCnt + "개 행이 입력 되었습니다.");
			
			//4. DB CLOSE
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}

}
