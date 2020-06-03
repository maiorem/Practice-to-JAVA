package pb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneinfoDao {



	//	public int insertPi(PhoneinfoAll pi) {
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
	//			String sql="insert into phoneinfoAll values "
	//					+ "(pba_idx_seq.nextval,?,?,?,?,?,?,?,?,?)";
	//
	//			pstmt=conn.prepareStatement(sql);
	//			pstmt.setString(1, pi.getType());
	//			pstmt.setString(2, pi.getName());
	//			pstmt.setString(3, pi.getPhone_num());
	//			pstmt.setString(4, pi.getEmail());
	//			pstmt.setString(5, pi.getAddress());
	//			pstmt.setString(6, pi.getMajor());
	//			pstmt.setString(7, pi.getGrade());
	//			pstmt.setString(8, pi.getDept());
	//			pstmt.setString(9, pi.getJob());
	//
	//			resultCnt=pstmt.executeUpdate();
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

	public int insertPB(PhoneInfoBasic pb, Connection conn) throws SQLException {

		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int resultCnt=0;

		String sql="insert into phoneinfo_basic values (PB_IDX_SEQ.nextval, ?, ?, ?, ?, ?)";

		pstmt=conn.prepareStatement(sql);

		pstmt.setString(1, pb.getFr_name());
		pstmt.setString(2, pb.getFr_phonenumber());
		pstmt.setString(3, pb.getFr_email());
		pstmt.setString(4, pb.getFr_address());
		pstmt.setDate(5, pb.getFr_regdate());

		resultCnt=pstmt.executeUpdate();
		return resultCnt;

	}








	public int insertPU(PhoneInfoUniv pu, Connection conn) throws SQLException {

		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int resultCnt=0;

		String sql="insert into phoneinfo_univ values (pu_idx_seq.nextval, ?, ?, PB_IDX_SEQ.currval)";

		pstmt=conn.prepareStatement(sql);

		pstmt.setString(1, pu.getFr_u_major());
		pstmt.setInt(2, pu.getFr_u_year());

		resultCnt=pstmt.executeUpdate();

		return resultCnt;

	}



	public int insertPC(PhoneInfoCom pc, Connection conn) throws SQLException {

		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int resultCnt=0;


		String sql="insert into phoneinfo_com values (pc_idx_seq.nextval, ?, PB_IDX_SEQ.currval)";

		pstmt=conn.prepareStatement(sql);

		pstmt.setString(1, pc.getFr_c_company());

		resultCnt=pstmt.executeUpdate();

		return resultCnt;
	}


	public int editPu(PhoneInfoUniv pu, int fr_ref, Connection conn) throws SQLException {
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int resultCnt=0;
		
		String sql="insert into phoneinfo_univ values (pu_idx_seq.nextval, ?, ?, ?)";

		pstmt=conn.prepareStatement(sql);

		pstmt.setString(1, pu.getFr_u_major());
		pstmt.setInt(2, pu.getFr_u_year());
		pstmt.setInt(3, fr_ref);

		resultCnt=pstmt.executeUpdate();
				
		
		return resultCnt;
		
	
	}
	
	public int editPc(PhoneInfoCom pc, int fr_ref, Connection conn) throws SQLException {
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int resultCnt=0;
		
		String sql="insert into phoneinfo_com values (pc_idx_seq.nextval, ?, ?)";

		pstmt=conn.prepareStatement(sql);

		pstmt.setString(1, pc.getFr_c_company());
		pstmt.setInt(2, fr_ref);

		resultCnt=pstmt.executeUpdate();
		

		return resultCnt;
		
	
	}
	
	
	

	public int searchCnt(String name, Connection conn) throws SQLException {

		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int rowCnt=0;

		String sql="select count(*) from phoneinfo_basic where fr_name=?";


		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);

		rs=pstmt.executeQuery();

		if (rs.next()) {
			rowCnt=rs.getInt(1);
		}




		return rowCnt;

	}


	public PhoneInfoBasic searchName(String name, Connection conn) throws SQLException {

		PhoneInfoBasic pb=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from phoneinfo_basic where fr_name=?";


		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		rs=pstmt.executeQuery();

		if(rs.next()) {
			pb=new PhoneInfoBasic(
					rs.getInt("idx"),
					rs.getString("fr_name"), 
					rs.getString("fr_phonenumber"), 
					rs.getString("fr_email"), 
					rs.getString("fr_address"), 
					rs.getDate("fr_regdate"));
		}

		return pb;
	}

	public PhoneInfoUniv searchNamePu(int fr_ref, Connection conn) throws SQLException {

		PhoneInfoUniv pu=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from phoneinfo_univ where fr_ref=?";


		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, fr_ref);
		rs=pstmt.executeQuery();

		if(rs.next()) {
			pu=new PhoneInfoUniv(
					rs.getInt("idx"), 
					rs.getString("fr_u_major"), 
					rs.getInt("fr_u_year"), 
					rs.getInt("fr_ref"));
		}

		return pu;
	}
	
	public PhoneInfoCom searchNamePc(int fr_ref, Connection conn) throws SQLException {

		PhoneInfoCom pc=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from phoneinfo_com where fr_ref=?";


		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, fr_ref);
		rs=pstmt.executeQuery();

		if(rs.next()) {
			pc=new PhoneInfoCom(
					rs.getInt("idx"), 
					rs.getString("fr_c_company"), 
					rs.getInt("fr_ref"));
		}

		return pc;
	}
	
	
	
	
	
	public int editPhoneInfo(PhoneInfoBasic pb, Connection conn) {

		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int resultCnt=0;

		String sql="update phoneinfo_basic set "
				+ "fr_name=?, "
				+ "fr_phonenumber=?, "
				+ "fr_email=?,"
				+ "fr_address=?,"
				+ "fr_regdate=? "
				+ "where idx=?";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pb.getFr_name());
			pstmt.setString(2, pb.getFr_phonenumber());
			pstmt.setString(3, pb.getFr_email());
			pstmt.setString(4, pb.getFr_address());
			pstmt.setDate(5, pb.getFr_regdate());
			
			pstmt.setInt(6, pb.getIdx());

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


	public int editPhoneInfoUniv(PhoneInfoUniv pu, Connection conn) {

		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int resultCnt=0;

		String sql="update phoneinfo_univ set "
				+ "fr_u_major=?, "
				+ "fr_u_year=? "
				+ "where fr_ref=?";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pu.getFr_u_major());
			pstmt.setInt(2, pu.getFr_u_year());
			
			pstmt.setInt(3, pu.getFr_ref());

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

	public int editPhoneInfoCom(PhoneInfoCom pc, Connection conn) {

		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int resultCnt=0;

		String sql="update phoneinfo_com set "
				+ "fr_c_company=? "
				+ "where fr_ref=?";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pc.getFr_c_company());

			pstmt.setInt(2, pc.getFr_ref());
			
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

			String sql="delete from phoneinfo_basic where fr_name='"+name+"'";
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
						rs.getString("fr_email"), 
						rs.getString("fr_address"), 
						rs.getDate("fr_regdate"), 
						rs.getString("fr_u_major"), 
						rs.getInt("fr_u_year"), 
						rs.getString("fr_c_company")));

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
						rs.getString("fr_email"), 
						rs.getString("fr_address"), 
						rs.getDate("fr_regdate"), 
						rs.getString("fr_u_major"), 
						rs.getInt("fr_u_year"), 
						rs.getString("fr_c_company")));


			}

		}catch (SQLException e) {
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
