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

public class DeptDao {
	
	
	// DAO = Data Access Object
	// 데이터베이스 처리하는 클래스
	
	//MVC => Model, View, Controller
	//model -> service, dao
	

	public void inputDept() {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=ConnectionProvider.getConnection();

			while(true) {
				System.out.println("부서 번호를 입력하세요");
				int deptno = Integer.parseInt(ManagerMain.kb.nextLine());
				System.out.println("부서이름을 입력하세요");
				String dname = ManagerMain.kb.nextLine();
				System.out.println("지역을 입력하세요");
				String loc = ManagerMain.kb.nextLine();

				String sql = "insert into dept "
						+ " values (?, ?, ?)";

				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);

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

	public void updateDept() {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn=ConnectionProvider.getConnection();
			System.out.println("수정하고자 하는 부서의 번호를 입력하세요");
			int updateDeptno = Integer.parseInt(ManagerMain.kb.nextLine());
			
			stmt=conn.createStatement();
			String searchSql="select * from dept where deptno="+updateDeptno;
			
			rs=stmt.executeQuery(searchSql);
			
			int sDeptno=0;
			String sDname="";
			String sLoc="";
			
			if(rs.next()) {
				sDeptno=rs.getInt("deptno");
				sDname=rs.getString("dname");
				sLoc=rs.getString("loc");
			} else {
				System.out.println("찾으시는 정보가 존재하지 않습니다.");
				return;
			}
			
			System.out.println("부서 정보 수정을 시작합니다.");
			System.out.println("부서 번호 : "+sDeptno);
			System.out.println("부서 이름을 입력하세요 ("+sDname+")");
			String dname=ManagerMain.kb.nextLine();
			System.out.println("지역을 입력하세요 ("+sLoc+")");
			String loc=ManagerMain.kb.nextLine();

			String sql = "update dept set dname=?, loc=? where deptno="+updateDeptno;

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);


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


	public void deleteDept() {


		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=ConnectionProvider.getConnection();
			System.out.println("삭제하고자 하는 부서번호를 입력하세요");
			int deleteDeptno = Integer.parseInt(ManagerMain.kb.nextLine());

			String sql = "delete from dept where deptno="+deleteDeptno;
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

	public void searchDept()  {


		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=ConnectionProvider.getConnection();
			System.out.println("검색하고자 하는 부서의 이름이나 지역을 입력하세요");
			String search = ManagerMain.kb.nextLine();
			String sql = "select * from dept where dname like '%"+search+"%' or loc like '%"+search+"%'";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\n");
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

	public List<Dept> allDeptPrint() {
		
		//VO : Value Object
		//DTO : Data Transfer Object

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		// Dao 클래스 추가
		List<Dept> deptList=new ArrayList<>();
		
		try {
			conn=ConnectionProvider.getConnection();
			stmt = conn.createStatement();

			String sql = "select * from dept";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Dept dept=new Dept(
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc")
						);
				
				deptList.add(dept);
				
				
//				System.out.print(rs.getInt(1)+"\t");
//				System.out.print(rs.getString(2)+"\t");
//				System.out.print(rs.getString(3)+"\n");

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
		return deptList;
		
		
	}


	
	
	
	
	
}
