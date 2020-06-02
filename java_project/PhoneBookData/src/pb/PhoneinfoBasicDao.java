package pb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneinfoBasicDao {
	
	
	public int insertPb(PhoneinfoBasic pb) {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int resultCnt=0;
		
		try {
			conn=ConnectionProvider.getConnection();
			
			String sql="insert into phoneinfo_basic values (?, ?, ?, ?, ?, ?)";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pb.getIdx());
			pstmt.setString(2, pb.getName());
			pstmt.setString(3, pb.getPhone_num());
			pstmt.setString(4, pb.getEmail());
			pstmt.setString(5, pb.getAddress());
			pstmt.setDate(6, pb.getRegdate());
			
			resultCnt=pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return resultCnt;
	}
	
	public int insertPU(PhoneinfoUniv pu) {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int resultCnt=0;
		
		try {
			conn=ConnectionProvider.getConnection();
			
			String sql="insert into phoneinfo_univ values (?, ?, ?, ?)";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pu.getuInx());
			pstmt.setString(1, pu.getMajor());
			pstmt.setInt(2, pu.getYear());
			pstmt.setInt(4, pu.getRef());
						
			resultCnt=pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return resultCnt;
	}
	
	public int insertPC(PhoneinfoCom pc) {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int resultCnt=0;
		
		try {
			conn=ConnectionProvider.getConnection();
			
			String sql="insert into phoneinfo_com values (?, ?, ?)";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pc.getcIdx());
			pstmt.setString(2, pc.getCompany());
			pstmt.setInt(3, pc.ref);
						
			resultCnt=pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return resultCnt;
	}
	
	
	

	public List<PhoneinfoAll> phoneinfoAllList() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		List <PhoneinfoAll> list = new ArrayList<>();
		
		try {
			conn=ConnectionProvider.getConnection();
			stmt=conn.createStatement();
			
			String sql="select * from phoneinfo_basic b, phoneinfo_univ u, phoneinfo_com c "
					+ "where b.idx=u.fr_ref(+) and b.idx=c.fr_ref(+)";
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
									
				list.add(new PhoneinfoAll(
						rs.getInt("idx"), 
						rs.getString("fr_name"), 
						rs.getString("fr_phonenumber"), 
						rs.getString("fr_address"), 
						rs.getString("fr_email"), 
						rs.getDate("fr_regdate"), 
						rs.getString("fr_u_major"), 
						rs.getInt("fr_u_year"), 
						rs.getString("fr_c_company"))
						);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
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
	
}
