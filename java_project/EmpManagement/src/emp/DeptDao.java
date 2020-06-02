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
	// 데이터베이스 처리하는 클래스. DAO 클래스에서는 데이터베이스 연결과 관련된 CRUD만 처리하고, 기타 기능(사용자 입력, 출력 등)은 다른 클래스로 뺀다.


	//MVC => Model, View, Controller
	//model -> service, dao


	public int inputDept(Dept dept) {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int resultCnt=0;
		
		try {
			conn=ConnectionProvider.getConnection();


			String sql = "insert into dept values (?, ?, ?)";

			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());


			resultCnt=pstmt.executeUpdate();

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
		return resultCnt;

	}

	public int updateDept(Dept newDept, Connection conn) {

		//Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int resultCnt=0;
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			String sql = "update dept set dname=?, loc=? where deptno=?";

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, newDept.getDname());
			pstmt.setString(2, newDept.getLoc());
			pstmt.setInt(3, newDept.getDeptno());

			resultCnt=pstmt.executeUpdate();
			
			
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
		return resultCnt;
	}

	public int deleteDept(int deptno) {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int resultCnt=0;

		try {

			conn=ConnectionProvider.getConnection();

			String sql = "delete from dept where deptno="+deptno;
			stmt=conn.createStatement();
			resultCnt=stmt.executeUpdate(sql);

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
		return resultCnt;

	}

	public List<Dept> searchDept(String dname)  {


		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		List<Dept> list = new ArrayList<Dept>();

		try {
			conn=ConnectionProvider.getConnection();

			String sql = "select * from dept where dname like '%"+dname+"%'";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);

			while (rs.next()) {

				list.add(new Dept(
						rs.getInt("deptno"), 
						rs.getString("dname"), 
						rs.getString("loc"))
						);
			}

		} catch (SQLException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
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
		return list;
	}

	public List<Dept> allDeptPrint() {

		//VO : Value Object | read only, getter
		//DTO : Data Transfer Object | getter/setter, toString, equals

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


	
	public int searchCount(int searchDeptno, Connection conn) {
		
		//Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int rowCnt=0;
		
		try {
			//conn=ConnectionProvider.getConnection();
			
			String sql ="select count(*) from dept where deptno=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, searchDeptno);
			
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				rowCnt=rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCnt;
	}

	public Dept deptSearchDeptno(int searchDeptno, Connection conn) {
		
		Dept dept=null;
		
		//Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//conn=ConnectionProvider.getConnection();
			
			String sql="select * from dept where deptno=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, searchDeptno);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dept=new Dept(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3));
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return dept;
	}
	
	
	
}
