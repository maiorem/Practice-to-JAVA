package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpManager {


	Scanner kb = new Scanner(System.in);

	void inputEmp() throws Exception {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pw="tiger";

			conn=DriverManager.getConnection(url, user, pw);
			
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (stmt!=null) {
				try {
					stmt.close();
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

	void updateEmp() throws SQLException {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pw="tiger";
			conn=DriverManager.getConnection(url, user, pw);
			System.out.println("수정하고자 하는 사원의 사원번호를 입력하세요");
			int updateEmpno = Integer.parseInt(kb.nextLine());
			System.out.println("사원명을 입력하세요.");
			String updateEname = kb.nextLine();
			System.out.println("부서번호를 입력하세요");
			int updateDeptno = Integer.parseInt(kb.nextLine());
			System.out.println("급여를 입력하세요");
			int updateSal = Integer.parseInt(kb.nextLine());

			String sql = "update emp set ename=?, deptno=?, sal=? where empno="+updateEmpno;

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, updateEname);
			pstmt.setInt(2, updateDeptno);
			pstmt.setInt(3, updateSal);

			int resultCnt=pstmt.executeUpdate();

			if (resultCnt>0) {
				System.out.println("정상적으로 처리되었습니다.");
				System.out.println(resultCnt+"개 행이 수정되었습니다.");
			} else {
				System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (stmt!=null) {
				try {
					stmt.close();
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


	void deleteEmp() throws SQLException {


		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pw="tiger";
			conn=DriverManager.getConnection(url, user, pw);
			System.out.println("삭제하고자 하는 사원번호를 입력하세요");
			int deleteEmpno = Integer.parseInt(kb.nextLine());

			String sql = "delete from emp where empno="+deleteEmpno;
			stmt=conn.createStatement();
			int resultCnt=stmt.executeUpdate(sql);

			if (resultCnt>0) {
				System.out.println("정상적으로 처리되었습니다.");
				System.out.println(resultCnt+"개 행이 삭제되었습니다.");
			} else {
				System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (stmt!=null) {
				try {
					stmt.close();
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

	void searchEmp() throws SQLException {


		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pw="tiger";
			conn=DriverManager.getConnection(url, user, pw);
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (stmt!=null) {
				try {
					stmt.close();
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

	void allEmpPrint() throws SQLException {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pw="tiger";
			conn=DriverManager.getConnection(url, user, pw);
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (stmt!=null) {
				try {
					stmt.close();
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


	void inputDept() throws Exception {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pw="tiger";
			conn=DriverManager.getConnection(url, user, pw);
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (stmt!=null) {
				try {
					stmt.close();
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

	void updateDept() throws SQLException {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pw="tiger";
			conn=DriverManager.getConnection(url, user, pw);
			System.out.println("수정하고자 하는 부서의 번호를 입력하세요");
			int updateDeptno = Integer.parseInt(kb.nextLine());
			System.out.println("부서 이름을 입력하세요");
			String updateDname=kb.nextLine();
			System.out.println("지역을 입력하세요");
			String updateLoc=kb.nextLine();

			String sql = "update dept set dname=?, loc=? where deptno="+updateDeptno;

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, updateDname);
			pstmt.setString(2, updateLoc);

	
			int resultCnt=pstmt.executeUpdate();

			if (resultCnt>0) {
				System.out.println("정상적으로 처리되었습니다.");
				System.out.println(resultCnt+"개 행이 수정되었습니다.");
			} else {
				System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (stmt!=null) {
				try {
					stmt.close();
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


	void deleteDept() throws SQLException {


		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pw="tiger";
			conn=DriverManager.getConnection(url, user, pw);
			System.out.println("삭제하고자 하는 부서번호를 입력하세요");
			int deleteDeptno = Integer.parseInt(kb.nextLine());

			String sql = "delete from dept where deptno="+deleteDeptno;
			stmt=conn.createStatement();
			int resultCnt=stmt.executeUpdate(sql);

			if (resultCnt>0) {
				System.out.println("정상적으로 처리되었습니다.");
				System.out.println(resultCnt+"개 행이 삭제되었습니다.");
			} else {
				System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (stmt!=null) {
				try {
					stmt.close();
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

	void searchDept() throws SQLException {


		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pw="tiger";
			conn=DriverManager.getConnection(url, user, pw);
			System.out.println("검색하고자 하는 부서의 이름이나 지역을 입력하세요");
			String search = kb.nextLine();

			String sql = "select * from dept where dname='"+search+"' or loc= '"+search+"'";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\n");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (stmt!=null) {
				try {
					stmt.close();
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

	void allDeptPrint() throws SQLException {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pw="tiger";
			conn=DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();

			String sql = "select * from dept";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\n");

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (stmt!=null) {
				try {
					stmt.close();
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



