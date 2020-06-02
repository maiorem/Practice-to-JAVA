package pb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneinfoBasicDao {


	public int insertPU(PhoneinfoUniv pu) {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int resultCnt=0;

		try {
			conn=ConnectionProvider.getConnection();

			String sql="insert all "
					+ "into phoneinfo_basic values (PB_IDX_SEQ.nextval, ?, ?, ?, ?, ?) "
					+ "into phoneinfo_univ values (pu_idx_seq.nextval, ?, ?, PB_IDX_SEQ.nextval)";

			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, pu.getName());
			pstmt.setString(2, pu.getPhone_num());
			pstmt.setString(3, pu.getEmail());
			pstmt.setString(4, pu.getAddress());
			pstmt.setDate(5, pu.getRegdate());

			pstmt.setString(6, pu.getMajor());
			pstmt.setInt(7, pu.getYear());

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

			String sql="insert all "
					+ "into phoneinfo_basic values (PB_IDX_SEQ.nextval, ?, ?, ?, ?, ?) "
					+ "into phoneinfo_com values (pc_idx_seq.nextval, ?, PB_IDX_SEQ.nextval)";

			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, pc.getName());
			pstmt.setString(2, pc.getPhone_num());
			pstmt.setString(3, pc.getEmail());
			pstmt.setString(4, pc.getAddress());
			pstmt.setDate(5, pc.getRegdate());


			pstmt.setString(6, pc.getCompany());


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


	public int deletePb(String name) {

		Connection conn=null;
		Statement stmt=null;

		int resultCnt=0;

		try {
			conn=ConnectionProvider.getConnection();

			String sql="delete from phoneinfo_basic where fr_name="+name;
			stmt=conn.createStatement();
			resultCnt=stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
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



	public List<PhoneinfoAll> searchInfo(String name) {


		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		List<PhoneinfoAll> list = new ArrayList<>();


		try {
			conn=ConnectionProvider.getConnection();

			String sql="select * from phoneinfo_basic b, phoneinfo_univ u, phoneinfo_com c "
					+ "where b.idx=u.fr_ref(+) and b.idx=c.fr_ref(+) "
					+ "and b.fr_name like '%"+name+"%'";
			
			stmt=conn.createStatement();
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



		return list;

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
