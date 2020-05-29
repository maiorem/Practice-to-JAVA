package ex;
//5.모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest9 {

	public static void main(String[] args)  {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
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
			
			String sql = "select * from emp natural join dept";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getInt(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t\t");
				System.out.print(rs.getInt(5)+"\t");
				System.out.print(rs.getDate(6)+"\t");
				System.out.print(rs.getInt(7)+"\t");
				System.out.print(rs.getInt(8)+"\t");
				System.out.print(rs.getString(9)+"\t");
				System.out.print(rs.getString(10)+"\n");
				
				
			}
			
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
