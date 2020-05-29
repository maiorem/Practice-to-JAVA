package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest3 {

	public static void main(String[] args)  {

		Connection conn = null;
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
			
			//3. Statement : Connection
			Statement stmt = conn.createStatement();

			Scanner kb = new Scanner(System.in);
			
			System.out.println("고객의 이름을 입력해주세요.");
			String searchName=kb.nextLine();
			
			String sql = "select empno, ename, job, hiredate from emp order by empno";
			String sql1 = "select o.orderid, c.name, b.bookname from customer c, book b, orders o "
					+ "where c.custid=o.custid and b.bookid=o.bookid"
					+ " and c.name='"+searchName+"'";
			
			System.out.println("SQL : " + sql1);
			System.out.println();
			System.out.println();
			System.out.println();
			
			
			//Select의 결과는 ResultSet이 받는다.
			//executeQuery(sql문) -> ResultSet
			rs = stmt.executeQuery(sql1);
			
			//ResultSet : next() -> 행의 존재 유무를 확인해준다.
			//System.out.println("사원번호\t사원이름\t직급\t\t입사일");
			
			System.out.println("판매리스트");
			System.out.println("=======================================================");
			System.out.println("주문번호\t고객이름\t구매한 도서");
			System.out.println("=======================================================");

			
			while(rs.next()) {
//				System.out.print(rs.getInt(1)+"\t");
//				System.out.print(rs.getString(2)+"\t");
//				System.out.print(rs.getString(3)+"\t");
//				System.out.print("\t"+rs.getDate(4)+"\n");
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\n");
				
			}
			
			rs.close();
			stmt.close();
			
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
