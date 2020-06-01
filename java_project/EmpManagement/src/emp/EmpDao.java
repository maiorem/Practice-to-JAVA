package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {


	public void inputEmp() throws Exception {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=ConnectionProvider.getConnection();

			while(true) {
				System.out.println("사원 번호를 입력하세요");
				int createEmpno = Integer.parseInt(ManagerMain.kb.nextLine());
				System.out.println("사원 이름을 입력하세요");
				String createEname = ManagerMain.kb.nextLine();
				System.out.println("직급을 입력하세요");
				String createJob = ManagerMain.kb.nextLine();
				System.out.println("급여를 입력하세요");
				int createSal = Integer.parseInt(ManagerMain.kb.nextLine());

				String sql = "insert into emp (empno, ename, job, sal) "
						+ " values (?, ?, ?, ?)";

				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, createEmpno);
				pstmt.setString(2, createEname);
				pstmt.setString(3, createJob);
				pstmt.setInt(4, createSal);
				try {
					int resultCnt=pstmt.executeUpdate();
					if (resultCnt>0) {
						System.out.println("정상적으로 처리되었습니다.");
						System.out.println(resultCnt+"개 행이 입력되었습니다.");
					} else {
						System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
					}
				} catch(SQLIntegrityConstraintViolationException e) {
					System.out.println("이미 존재하는 정보를 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					continue;
				}

			}
		} catch (SQLException e) {
			System.out.println("잘못 입력하셨습니다.");
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}

		}
	}

	public void updateEmp() throws SQLException {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=ConnectionProvider.getConnection();

			System.out.println("수정하고자 하는 사원의 사원번호를 입력하세요");
			int updateEmpno = Integer.parseInt(ManagerMain.kb.nextLine());
			System.out.println("사원명을 입력하세요.");
			String updateEname = ManagerMain.kb.nextLine();
			System.out.println("부서번호를 입력하세요");
			int updateDeptno = Integer.parseInt(ManagerMain.kb.nextLine());
			System.out.println("급여를 입력하세요");
			int updateSal = Integer.parseInt(ManagerMain.kb.nextLine());

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
		} catch (SQLException e) {
			System.out.println("잘못 입력하셨습니다.");
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}


		}
	}


	public void deleteEmp() throws SQLException {


		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=ConnectionProvider.getConnection();

			System.out.println("삭제하고자 하는 사원번호를 입력하세요");
			int deleteEmpno = Integer.parseInt(ManagerMain.kb.nextLine());

			String sql = "delete from emp where empno="+deleteEmpno;
			stmt=conn.createStatement();
			int resultCnt=stmt.executeUpdate(sql);

			if (resultCnt>0) {
				System.out.println("정상적으로 처리되었습니다.");
				System.out.println(resultCnt+"개 행이 삭제되었습니다.");
			} else {
				System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
			}
		} catch (SQLException e) {
			System.out.println("잘못 입력하셨습니다.");
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}


		}
	}

	public void searchEmp() throws SQLException {


		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=ConnectionProvider.getConnection();

			System.out.println("검색하고자 하는 사원이름을 입력하세요");
			String searchEname = ManagerMain.kb.nextLine();

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


		} catch (SQLException e) {
			System.out.println("잘못 입력하셨습니다.");
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}


		}
	}

	public List<Emp> allEmpPrint() {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		List<Emp> empList=new ArrayList<>();
		
		try {

//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=ConnectionProvider.getConnection();

			stmt = conn.createStatement();

			String sql = "select * from emp";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Emp emp=new Emp(
						rs.getInt("empno"), 
						rs.getString("ename"), 
						rs.getString("job"), 
						rs.getInt("sal"), 
						rs.getInt("mgr"),
						rs.getDate("hiredate"),
						rs.getInt("comm"), 
						rs.getInt("deptno"));
				
				empList.add(emp);

			}
		} catch (SQLException e) {
			System.out.println("잘못 입력하셨습니다.");
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.getMessage();
				}
			}


		}
		
		return empList;
	}
	

}
