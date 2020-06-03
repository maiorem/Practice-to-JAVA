package pb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneinfoDao {



	public int insertPi(PhoneinfoAll pi) {

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int resultCnt=0;

		try {
			conn=ConnectionProvider.getConnection();

			String sql="insert into phoneinfoAll values "
					+ "(pba_idx_seq.nextval,?,?,?,?,?,?,?,?,?)";

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pi.getType());
			pstmt.setString(2, pi.getName());
			pstmt.setString(3, pi.getPhone_num());
			pstmt.setString(4, pi.getEmail());
			pstmt.setString(5, pi.getAddress());
			pstmt.setString(6, pi.getMajor());
			pstmt.setString(7, pi.getGrade());
			pstmt.setString(8, pi.getDept());
			pstmt.setString(9, pi.getJob());

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

	//
	//	public int insertPU(PhoneinfoUniv pu) {
	//
	//		Connection conn=null;
	//		Statement stmt=null;
	//		PreparedStatement pstmt=null;
	//		ResultSet rs=null;
	//
	//		int resultCnt=0;
	//
	//		try {
	//			conn=ConnectionProvider.getConnection();
	//
	//			String sql="insert all "
	//					+ "into phoneinfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address) values (PB_IDX_SEQ.nextval, ?, ?, ?, ?) "
	//					+ "into phoneinfo_univ values (pu_idx_seq.nextval, ?, ?, PB_IDX_SEQ.nextval)";
	//
	//			pstmt=conn.prepareStatement(sql);
	//
	//			pstmt.setString(1, pu.getName());
	//			pstmt.setString(2, pu.getPhone_num());
	//			pstmt.setString(3, pu.getEmail());
	//			pstmt.setString(4, pu.getAddress());
	//
	//			pstmt.setString(5, pu.getMajor());
	//			pstmt.setInt(6, pu.getYear());
	//
	//			resultCnt=pstmt.executeUpdate();
	//
	//
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		} finally {
	//			if(rs != null) {
	//				try {
	//					rs.close();
	//				} catch (SQLException e) {
	//					// TODO Auto-generated catch block
	//					e.printStackTrace();
	//				}
	//			}
	//			if (pstmt !=null) {
	//				try {
	//					pstmt.close();
	//				} catch (SQLException e) {
	//					// TODO Auto-generated catch block
	//					e.printStackTrace();
	//				}
	//			}
	//			if (conn!=null) {
	//				try {
	//					conn.close();
	//				} catch (SQLException e) {
	//					// TODO Auto-generated catch block
	//					e.printStackTrace();
	//				}
	//			}
	//
	//		}
	//
	//		return resultCnt;
	//	}
	//
	//	public int insertPC(PhoneinfoCom pc) {
	//
	//		Connection conn=null;
	//		Statement stmt=null;
	//		PreparedStatement pstmt=null;
	//		ResultSet rs=null;
	//
	//		int resultCnt=0;
	//
	//		try {
	//			conn=ConnectionProvider.getConnection();
	//
	//			String sql="insert all "
	//					+ "into phoneinfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address) values (PB_IDX_SEQ.nextval, ?, ?, ?, ?, ?) "
	//					+ "into phoneinfo_com values (pc_idx_seq.nextval, ?, PB_IDX_SEQ.nextval)";
	//
	//			pstmt=conn.prepareStatement(sql);
	//
	//			pstmt.setString(1, pc.getName());
	//			pstmt.setString(2, pc.getPhone_num());
	//			pstmt.setString(3, pc.getEmail());
	//			pstmt.setString(4, pc.getAddress());
	//
	//			pstmt.setString(5, pc.getCompany());
	//
	//
	//			resultCnt=pstmt.executeUpdate();
	//
	//
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		} finally {
	//			if(rs != null) {
	//				try {
	//					rs.close();
	//				} catch (SQLException e) {
	//					// TODO Auto-generated catch block
	//					e.printStackTrace();
	//				}
	//			}
	//			if (pstmt !=null) {
	//				try {
	//					pstmt.close();
	//				} catch (SQLException e) {
	//					// TODO Auto-generated catch block
	//					e.printStackTrace();
	//				}
	//			}
	//			if (conn!=null) {
	//				try {
	//					conn.close();
	//				} catch (SQLException e) {
	//					// TODO Auto-generated catch block
	//					e.printStackTrace();
	//				}
	//			}
	//
	//		}
	//
	//		return resultCnt;
	//	}

	public int searchCnt(String name, Connection conn) {

		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int rowCnt=0;

		String sql="select count(*) from phoneinfoall where name=?";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);

			rs=pstmt.executeQuery();

			if (rs.next()) {
				rowCnt=rs.getInt(1);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowCnt;

	}


	public PhoneinfoAll searchName(String name, Connection conn) {

		PhoneinfoAll pi=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from phoneinfoall where name=?";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();

			if(rs.next()) {
				pi=new PhoneinfoAll(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9));
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pi;
	}

	public int editPhoneInfo(PhoneinfoAll pi, Connection conn) {

		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int resultCnt=0;

		String sql="update phoneinfoall set "
				+ "type=?, "
				+ "name=?, "
				+ "phonenumber=?,"
				+ "email=?,"
				+ "address=?,"
				+ "major=?,"
				+ "grade=?,"
				+ "dept=?,"
				+ "job=?";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pi.getType());
			pstmt.setString(2, pi.getName());
			pstmt.setString(3, pi.getPhone_num());
			pstmt.setString(4, pi.getEmail());
			pstmt.setString(5, pi.getAddress());
			pstmt.setString(6, pi.getMajor());
			pstmt.setString(7, pi.getGrade());
			pstmt.setString(8, pi.getDept());
			pstmt.setString(9, pi.getJob());

			resultCnt=pstmt.executeUpdate();


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
		}

		return resultCnt;

	}



	public int deletePb(String name) {

		Connection conn=null;
		Statement stmt=null;

		int resultCnt=0;

		try {
			conn=ConnectionProvider.getConnection();

			String sql="delete from phoneinfoAll where name='"+name+"'";
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

			String sql="select * from phoneInfoAll "
					+ "where name like '%"+name+"%'";

			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);

			while(rs.next()) {
				list.add(new PhoneinfoAll(
						rs.getString("type"), 
						rs.getString("name"), 
						rs.getString("phonenumber"), 
						rs.getString("address"), 
						rs.getString("email"), 
						rs.getString("major"), 
						rs.getString("grade"), 
						rs.getString("dept"), 
						rs.getString("job")));

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

			String sql="select * from phoneinfoall";

			rs=stmt.executeQuery(sql);

			while(rs.next()) {

				list.add(new PhoneinfoAll(
						rs.getString("type"), 
						rs.getString("name"), 
						rs.getString("phonenumber"), 
						rs.getString("address"), 
						rs.getString("email"), 
						rs.getString("major"), 
						rs.getString("grade"), 
						rs.getString("dept"), 
						rs.getString("job")));
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
