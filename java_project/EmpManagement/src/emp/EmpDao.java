package emp;

import java.sql.Connection;
import java.sql.Date;
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
				int empno = Integer.parseInt(ManagerMain.kb.nextLine());
				System.out.println("사원 이름을 입력하세요");
				String ename = ManagerMain.kb.nextLine();
				System.out.println("직급을 입력하세요");
				String job = ManagerMain.kb.nextLine();
				System.out.println("급여를 입력하세요");
				int sal = Integer.parseInt(ManagerMain.kb.nextLine());
				System.out.println("담당 관리자의 사원번호를 입력하세요");
				int mgr = Integer.parseInt(ManagerMain.kb.nextLine());
				System.out.println("입사날짜를 입력하세요");
				String hiredate=ManagerMain.kb.nextLine();
				System.out.println("수당을 입력하세요");
				int comm=Integer.parseInt(ManagerMain.kb.nextLine());
				System.out.println("부서 번호를 입력하세요");
				int deptno=Integer.parseInt(ManagerMain.kb.nextLine());

				String sql = "insert into emp values (?, ?, ?, ?, ?, ?, ?, ?)";

				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, empno);
				pstmt.setString(2, ename);
				pstmt.setString(3, job);
				pstmt.setInt(4, sal);
				pstmt.setInt(5, mgr);
				pstmt.setString(6, hiredate);
				pstmt.setInt(7, comm);
				pstmt.setInt(8, deptno);
				
				try {
					int resultCnt=pstmt.executeUpdate();
					if (resultCnt>0) {
						System.out.println("정상적으로 처리되었습니다.");
						System.out.println(resultCnt+"개 행이 입력되었습니다.");
					} else {
						System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
					}
					return;
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
			
			stmt=conn.createStatement();
						
			String searchSql = "select * from emp where empno="+updateEmpno;
			rs=stmt.executeQuery(searchSql);
			
			//수정 전의 데이터 출력
			int sEmpno=0;
			String sEname="";
			int sDeptno=0;
			int sSal=0;
			
			
			if(rs.next()) {
				sEmpno=rs.getInt("empno");
				sEname=rs.getString("ename");
				sDeptno=rs.getInt("deptno");
				sSal=rs.getInt("sal");
			} else {
				System.out.println("찾으시는 정보가 존재하지 않습니다.");
				return;
			}
			
			System.out.println("해당 사원번호의 수정 사항을 입력해주세요.");
			System.out.println("사원번호 : " +sEmpno);
			System.out.println("사원명을 입력하세요. ("+sEname+")");
			String ename = ManagerMain.kb.nextLine();
			System.out.println("부서번호를 입력하세요("+sDeptno+")");
			int deptno = Integer.parseInt(ManagerMain.kb.nextLine());
			System.out.println("급여를 입력하세요("+sSal+")");
			int sal = Integer.parseInt(ManagerMain.kb.nextLine());

			String sql = "update emp set ename=?, deptno=?, sal=? where empno="+updateEmpno;

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setInt(2, deptno);
			pstmt.setInt(3, sal);

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

			String sql = "select * from emp where ename like '%"+searchEname+"%'";
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
