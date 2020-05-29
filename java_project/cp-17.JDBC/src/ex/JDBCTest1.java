package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest1 {

	public static void main(String[] args)  {

		Connection conn = null;
		
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
			
			//트랜젝션 설정
			conn.setAutoCommit(false); //자동커밋 해제
			
			//3. sql로 데이터처리
			
			
			
			conn.commit(); // 데이터처리가 다 정상적으로 되어야 커밋.
			
			//4. DB CLOSE
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // 
			e.printStackTrace();
		}
		
		
	}

}
