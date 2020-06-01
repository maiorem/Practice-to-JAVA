package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest11 {

	public static void main(String[] args)  {

		//jdbc 사용 객체
		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			// 0. 드라이버 라이브러리 추가
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체(패키지포함)이름)
			// Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결
			//String url="jdbc:oracle:thin:@주소:포트:데이터베이스 이름";
			//주소 : localhost or 127.0.0.1
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pw="tiger";

			// Connection 객체 생성
			conn=DriverManager.getConnection(url, user, pw);
			// 3. SQL 처리
			// Statement or PreparedStatement
			//=> Statement에는 완성된 sql문만 들어가다보니 성능저하 이슈가 있음.
			//pstmt=conn.prepareStatement("SQL문장");
			
			String sql = "insert into dept (deptno, dname, loc) "
					+ " values (?, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 70);
			pstmt.setString(2, "MARKETING");
			pstmt.setString(3, "SEOUL");
			
			int resultCnt=pstmt.executeUpdate();
			
			if (resultCnt>0) {
				System.out.println("정상적으로 입력되었습니다.");
				System.out.println(resultCnt+"개 행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
			}
			
			
//			
//			pstmt.close();
//			conn.close();


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		// 4. 데이터베이스 연결 종료
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	
	}

}
