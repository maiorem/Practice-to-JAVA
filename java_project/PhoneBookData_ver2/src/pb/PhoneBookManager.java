package pb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class PhoneBookManager {

	PhoneinfoDao dao=new PhoneinfoDao();

	public void phoneManager() {

		int choice=0;

		while(true) {
			System.out.println("----------------------------------------------------");
			System.out.println(" M Y P H O N E B O O K ");
			System.out.println("====================================================");
			System.out.println("1.List 2.Search 3.Insert 4.Update 5.Delete 0.Exit");
			System.out.println("====================================================");

			try {			

				choice=Integer.parseInt(PhoneBookMain.sc.nextLine().trim());

			} catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}

			switch(choice) {
			case 1:
				System.out.println("전체 리스트를 출력합니다.");
				allListPb();
				continue;
			case 2:
				System.out.println("검색을 진행합니다.");
				searchPb();
				continue;
			case 3:
				System.out.println("새로운 정보를 입력합니다.");
				insertPb();
				continue;
			case 4:
				System.out.println("저장된 정보를 수정합니다.");
				editPb();
				continue;
			case 5:
				System.out.println("저장된 정보를 삭제합니다.");
				deletePb();
				continue;
			case 0:
				System.out.println("Program Exit.");
				System.exit(0);
				break;
			}
		}
	}


	public void insertPb() {

		Connection conn=null;

		PhoneInfoBasic pb = null;
		PhoneInfoUniv pu = null;
		PhoneInfoCom pc = null;

		int resultBsi=0;
		int resultUni=0;
		int resultCom=0;

		int choice=0;
		while(true) {
			try {
				conn=ConnectionProvider.getConnection();

				conn.setAutoCommit(false);

				System.out.println("저장할 그룹을 선택해주세요.");
				System.out.println("=============================");
				System.out.println("1.University 2.Company");
				System.out.println("=============================");

				try {
					choice=Integer.parseInt(PhoneBookMain.sc.nextLine().trim());
				} catch(Exception e) {
					System.out.println("잘못 입력하셨습니다.");
					continue;
				}

				System.out.println("정보 입력을 시작합니다.");
				System.out.print("이름 : ");
				String fr_name=PhoneBookMain.sc.nextLine();
				System.out.print("전화번호 : ");
				String fr_phonenumber=PhoneBookMain.sc.nextLine();
				System.out.print("주소 : ");
				String fr_address=PhoneBookMain.sc.nextLine();
				System.out.print("이메일 : ");
				String fr_email=PhoneBookMain.sc.nextLine();
				System.out.print("등록 날짜 : ");
				Date fr_regdate = Date.valueOf(PhoneBookMain.sc.nextLine());

				pb=new PhoneInfoBasic(fr_name, fr_phonenumber, fr_email, fr_address, fr_regdate);

				resultBsi=dao.insertPB(pb, conn);

				switch(choice) {
				case 1:
					System.out.print("전공 : ");
					String fr_u_major=PhoneBookMain.sc.nextLine();
					System.out.print("학년 : ");
					int fr_u_year=Integer.parseInt(PhoneBookMain.sc.nextLine());

					pu=new PhoneInfoUniv(fr_u_major, fr_u_year);

					resultUni=dao.insertPU(pu, conn);

					if (resultUni>0) {
						System.out.println("정상적으로 처리되었습니다.");
						System.out.println(resultUni+"개 행이 입력되었습니다.");
						conn.commit();
					} else {
						System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
						conn.rollback();
					}

					return;

				case 2:

					System.out.print("회사명 : ");
					String fr_c_company=PhoneBookMain.sc.nextLine();

					pc=new PhoneInfoCom(fr_c_company);

					resultCom=dao.insertPC(pc, conn);

					if (resultCom>0) {
						System.out.println("정상적으로 처리되었습니다.");
						System.out.println(resultCom+"개 행이 입력되었습니다.");
						conn.commit();
					} else {
						System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
						conn.rollback();
					}


					return;
				}

			} catch (SQLException e) {
				if (conn!=null) {
					try {
						conn.rollback();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				e.printStackTrace();
			} finally {
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


	public void deletePb() {

		System.out.println("삭제하고자 하는 이름을 입력하세요.");
		String name=PhoneBookMain.sc.nextLine();

		List<PhoneinfoAll> list = dao.searchInfo(name);

		if (list!=null && !list.isEmpty()) {
			System.out.println("==================================================================================");
			for(int i=0; i<list.size(); i++) {
				System.out.printf("%3s", list.get(i).getIdx()+"\t");
				System.out.printf("%5s", list.get(i).getFr_name()+"\t");
				System.out.printf("%5s", list.get(i).getFr_phonenumber()+"\t");
				System.out.printf("%5s", list.get(i).getFr_address()+"\t");
				System.out.printf("%5s", list.get(i).getFr_email()+"\t");
				System.out.printf("%5s", list.get(i).getFr_regdate()+"\t");
				System.out.printf("%5s", list.get(i).getFr_u_major()+"\t");
				System.out.printf("%5s", list.get(i).getFr_u_year()+"\t");
				System.out.printf("%5s", list.get(i).getFr_c_company()+"\n");
			}
			System.out.println("=================================================================================");
		} else {
			System.out.println("존재하지 않는 이름입니다.");
			return;
		}


		System.out.println("삭제하려는 인덱스 번호를 입력하세요.");
		int idx=Integer.parseInt(PhoneBookMain.sc.nextLine());

		int resultCnt=dao.deletePb(idx);

		if(resultCnt>0) {
			System.out.println("정상적으로 처리되었습니다.");
			System.out.println(resultCnt+"개 행이 삭제되었습니다.");
		} else {
			System.out.println("처리 되지 않았습니다. 확인 후 재시도 해 주세요.");
		}

	}


	public void editPb() {

		Connection conn=null;

		PhoneInfoBasic pb = null;
		PhoneInfoUniv pu = null;
		PhoneInfoCom pc = null;

		int resultBsi=0;
		int resultUni=0;
		int resultCom=0;

		try {
			conn=ConnectionProvider.getConnection();

			conn.setAutoCommit(false);

			System.out.println("수정하고자 하는 이름을 입력하세요.");
			String searchName=PhoneBookMain.sc.nextLine();


			pb=dao.searchName(searchName, conn);

			if (pb==null) {
				System.out.println("찾으시는 정보가 존재하지 않습니다.");
				return;
			}

			System.out.println("정보 수정을 시작합니다.");
			System.out.println("인덱스 : "+pb.idx);
			System.out.println("저장할 그룹을 선택해주세요.");
			System.out.println("=============================");
			System.out.println("1.University 2.Company");
			System.out.println("=============================");
			int choice=Integer.parseInt(PhoneBookMain.sc.nextLine());
			System.out.print("이름 ("+pb.getFr_name()+") : ");
			String fr_name=PhoneBookMain.sc.nextLine();
			System.out.print("전화번호 ("+pb.getFr_phonenumber()+") : ");
			String fr_phonenumber=PhoneBookMain.sc.nextLine();
			System.out.print("주소 ("+pb.getFr_address()+") : ");
			String fr_address=PhoneBookMain.sc.nextLine();
			System.out.print("이메일 ("+pb.getFr_email()+") : ");
			String fr_email=PhoneBookMain.sc.nextLine();
			System.out.print("등록 날짜 ("+pb.getFr_regdate()+") : ");
			Date fr_regdate = Date.valueOf(PhoneBookMain.sc.nextLine());

			PhoneInfoBasic newpb=new PhoneInfoBasic(pb.getIdx(), fr_name, fr_phonenumber, fr_email, fr_address, fr_regdate);
			resultBsi=dao.editPhoneInfo(newpb, conn);

			switch(choice) {
			case 1:

				pu=dao.searchRefPu(pb.idx, conn);

				if(pu==null) {

					int deletePc=dao.editDeletePu(conn, pb.idx);

					System.out.print("전공 : ");
					String fr_u_major=PhoneBookMain.sc.nextLine();
					System.out.print("학년 : ");
					int fr_u_year=Integer.parseInt(PhoneBookMain.sc.nextLine());

					PhoneInfoUniv newpu=new PhoneInfoUniv(fr_u_major, fr_u_year, pb.idx);

					resultUni=dao.editPu(newpu, pb.idx, conn);

					if (resultUni>0) {
						System.out.println("정상적으로 처리되었습니다.");
						System.out.println(resultUni+"개 행이 업데이트되었습니다.");
						conn.commit();
						return;
					} else {
						System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
						conn.rollback();
						return;
					}


				}

				System.out.print("전공 : ");
				String fr_u_major=PhoneBookMain.sc.nextLine();
				System.out.print("학년 : ");
				int fr_u_year=Integer.parseInt(PhoneBookMain.sc.nextLine());

				PhoneInfoUniv newpu=new PhoneInfoUniv(pu.getIdx(), fr_u_major, fr_u_year, pu.getFr_ref());

				resultUni=dao.editPhoneInfoUniv(newpu, conn);

				if (resultUni>0) {
					System.out.println("정상적으로 처리되었습니다.");
					System.out.println(resultUni+"개 행이 업데이트되었습니다.");
					conn.commit();
					return;
				} else {
					System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
					conn.rollback();
					return;
				}



			case 2:

				pc=dao.searchRefPc(pb.idx, conn);

				if(pc==null) {

					int deletePu=dao.editDeletePc(conn, pb.idx);

					System.out.print("회사명 : ");
					String fr_c_company=PhoneBookMain.sc.nextLine();

					PhoneInfoCom newpc=new PhoneInfoCom(fr_c_company, pb.idx);

					resultCom=dao.editPc(newpc, pb.idx, conn);

					if (resultCom>0) {
						System.out.println("정상적으로 처리되었습니다.");
						System.out.println(resultCom+"개 행이 업데이트되었습니다.");
						conn.commit();
						return;
					} else {
						System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
						conn.rollback();
						return;
					}


				}

				System.out.print("회사명 : ");
				String fr_c_company=PhoneBookMain.sc.nextLine();

				PhoneInfoCom newpc=new PhoneInfoCom(pc.getIdx(), fr_c_company, pc.getFr_ref());

				resultCom=dao.editPhoneInfoCom(newpc, conn);

				if (resultCom>0) {
					System.out.println("정상적으로 처리되었습니다.");
					System.out.println(resultCom+"개 행이 업데이트되었습니다.");
					conn.commit();
					return;
				} else {
					System.out.println("입력이 되지 않았습니다. 확인 후 재시도해주세요.");
					conn.rollback();
					return;
				}


			}

		}

		catch (SQLException e) {

			e.printStackTrace();
			if(conn!=null ) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}


	}


	public void searchPb() {

		System.out.println("검색하려는 이름을 입력하세요.");
		String name=PhoneBookMain.sc.nextLine();

		List<PhoneinfoAll> list = dao.searchInfo(name);

		if (list!=null && !list.isEmpty()) {
			System.out.println("==================================================================================");
			for(int i=0; i<list.size(); i++) {
				System.out.printf("%3s", list.get(i).getIdx()+"\t");
				System.out.printf("%5s", list.get(i).getFr_name()+"\t");
				System.out.printf("%5s", list.get(i).getFr_phonenumber()+"\t");
				System.out.printf("%5s", list.get(i).getFr_address()+"\t");
				System.out.printf("%5s", list.get(i).getFr_email()+"\t");
				System.out.printf("%5s", list.get(i).getFr_regdate()+"\t");
				System.out.printf("%5s", list.get(i).getFr_u_major()+"\t");
				System.out.printf("%5s", list.get(i).getFr_u_year()+"\t");
				System.out.printf("%5s", list.get(i).getFr_c_company()+"\n");
			}
		} else {
			System.out.println("존재하지 않는 이름입니다.");
			return;
		}

	}


	public void allListPb() {

		List<PhoneinfoAll> list = dao.phoneinfoAllList();

		if (list!=null && !list.isEmpty()) {
			System.out.println("==================================================================================");
			for(int i=0; i<list.size(); i++) {
				System.out.printf("%3s", list.get(i).getIdx()+"\t");
				System.out.printf("%5s", list.get(i).getFr_name()+"\t");
				System.out.printf("%5s", list.get(i).getFr_phonenumber()+"\t");
				System.out.printf("%5s", list.get(i).getFr_address()+"\t");
				System.out.printf("%5s", list.get(i).getFr_email()+"\t");
				System.out.printf("%5s", list.get(i).getFr_regdate()+"\t");
				System.out.printf("%5s", list.get(i).getFr_u_major()+"\t");
				System.out.printf("%5s", list.get(i).getFr_u_year()+"\t");
				System.out.printf("%5s", list.get(i).getFr_c_company()+"\n");
			}


		} else {
			System.out.println("입력된 데이터가 없습니다.");
			return;
		}

	}


}
