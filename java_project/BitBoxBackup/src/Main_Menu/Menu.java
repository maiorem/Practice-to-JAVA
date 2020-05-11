package Main_Menu;


import Movie.MovieMenu;
import Ticket.TicketManager;
import TimeTable.ScreenMenu;
import TimeTable.TimeTableMenu;
import user.InfoManager;
import user.NoMemberInfo;
import user.exception.EmptyIntegerException;
import user.exception.EmptyStringException;
import user.exception.OnlyNumberException;
import user.exception.OutOfNumberException;

public class Menu {

	InfoManager info = InfoManager.getInst();
	TicketManager tm = new TicketManager();
	ScreenMenu sm = new ScreenMenu();
	MovieMenu mm=new MovieMenu();
	TimeTableMenu ttm = new TimeTableMenu();

	void userMenu() {
		outerLoop:
			while (true) {
				System.out.println("\n===========|| BITBOX ||============");
				System.out.println("\t  1.관리자 로그인");
				System.out.println("\t  2.고객  로그인");
				System.out.println("\t  3.비회원 예매");
				System.out.println("\t  0.프로그램 종료");
				System.out.println("===================================");
				String log;
				try {
					log=info.sc.nextLine();
					if (!(Integer.parseInt(log)>=0 && (Integer.parseInt(log)<=3))) {
						OutOfNumberException ex = new OutOfNumberException();
						throw ex;
					}
					if(log.trim().isEmpty()) {
						EmptyIntegerException ex = new EmptyIntegerException();
						throw ex;
					}
				} catch(EmptyIntegerException e) {
					System.out.println(e.getMessage());
					continue;
				}catch(OutOfNumberException e) {
					System.out.println(e.getMessage());
					continue;
				} catch(Exception e) {
					System.out.println("※※ 잘못된 메뉴를 선택하셨습니다. 다시 입력해주세요.※※ \n");
					continue;
				} 
				switch((Integer.parseInt(log))) {

				case 1:
					adminLogin();
					continue outerLoop;
				case 2:
					while(true) {
						System.out.println("\n★☆★☆새로운 공간에서 펼쳐지는 당신만의 이야기☆★☆★");
						System.out.println("\tBITBOX에 오신 것을 환영합니다");
						System.out.println("====================================");
						System.out.println("\t  1. 회원가입하기");
						System.out.println("\t  2. 로그인");
						System.out.println("\t  3. 아이디 / 비밀번호 찾기");
						System.out.println("\t  0. 이전으로 돌아가기");
						System.out.println("====================================");
						String choice;
						try {
							choice=info.sc.nextLine();
							if (!((Integer.parseInt(choice))>=0 && (Integer.parseInt(choice))<=3)) {
								OutOfNumberException ex = new OutOfNumberException();
								throw ex;
							}
							if(choice.trim().isEmpty()) {
								EmptyIntegerException ex = new EmptyIntegerException();
								throw ex;
							}
						} catch(EmptyIntegerException e) {
							System.out.println(e.getMessage());
							continue;
						}
						catch(OutOfNumberException e) {
							System.out.println(e.getMessage());
							continue;
						} catch(Exception e) {
							System.out.println("※※※메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.※※※");
							continue;
						} 
						switch ((Integer.parseInt(choice))){
						case 1:
							info.creatId();
							continue;
						case 2:
							int count=0;
							while(true) {


								if (count==3) {
									System.out.println("\n  ☞로그인에 세번 실패하여 초기 화면으로 돌아갑니다.☜\n");
									continue outerLoop;
								}

								System.out.print("아이디를 입력하세요 : ");
								String id=info.sc.nextLine();
								System.out.print("패스워드를 입력하세요 : ");
								String pw=info.sc.nextLine();


								if(!(info.login(id, pw))) {
									System.out.println("※※※※아이디와 패스워드가 일치하지 않습니다.※※※※");
									System.out.println("-------------------------------------");
									count++;						
									continue;

								} else {
									System.out.println("==================================");
									System.out.println(id+"님, 환영합니다!");
									System.out.println("==================================");
								}
								while (true) {
									System.out.println("-----------------------------------");
									System.out.println("\t  1.예매하기");
									System.out.println("\t  2.예매내역확인");
									System.out.println("\t  3.예매 취소");
									System.out.println("\t  4.회원정보확인"); //회원정보와 보유금액, 포인트 확인
									System.out.println("\t  5.회원정보수정"); //회원정보 수정, 탈퇴.
									System.out.println("\t  0.로그아웃");
									System.out.println("-----------------------------------");

									String num;
									try {
										num = info.sc.nextLine();
										if (!(Integer.parseInt(num)>=0 && Integer.parseInt(num)<=5)) {
											OutOfNumberException ex = new OutOfNumberException();
											throw ex;
										}
										if(num.trim().isEmpty()) {
											EmptyIntegerException ex = new EmptyIntegerException();
											throw ex;
										}
									} catch(EmptyIntegerException e) {
										System.out.println(e.getMessage());
										continue;
									}
									catch (OutOfNumberException e1) {
										System.out.println(e1.getMessage());
										continue;
									} catch (Exception e) {
										System.out.println("※※※※메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.※※※※\n");
										continue;
									}
									switch(Integer.parseInt(num)) {
									case 1:
										tm.creatTicket(info.getMember().get(id));
										break;
									case 2:
										System.out.println("\n-----------------------------------");
										info.showMyTicket(id);
										System.out.println("-----------------------------------");
										continue;

									case 3:
										try {
											tm.delTicket(info.getMember().get(id));

										} catch(NullPointerException e) {
											System.out.println("예매 내역이 존재하지 않습니다.");
											continue;
										}
										System.out.println("정상적으로 삭제되었습니다.");
										continue;

									case 4:
										info.searchInfo(id);
										System.out.println("-----------------------------------\n");
										continue;
									case 5:	
										System.out.println("1.회원정보수정");
										System.out.println("2.회원 탈퇴");
										String sel;
										try {
											sel = info.sc.nextLine();
											if (!(Integer.parseInt(sel)>0 && Integer.parseInt(sel)<=2)) {
												OutOfNumberException ex = new OutOfNumberException();
												throw ex;
											}
											if(sel.trim().isEmpty()) {
												EmptyIntegerException ex = new EmptyIntegerException();
												throw ex;
											}
										} catch(EmptyIntegerException e) {
											System.out.println(e.getMessage());
											continue;
										}

										catch (OutOfNumberException e) {
											System.out.println(e.getMessage());
											continue;
										} catch (Exception e) {
											System.out.println("※※※※메뉴를 잘못 입력하셨습니다. 다시 입력해주세요. ※※※※\n");
											continue;
										}

										if (Integer.parseInt(sel)==1) {
											info.editInfo(id);
											break;
										} else {

											System.out.println("-------"+id+"님 정말로 탈퇴하시겠습니까?-------");
											System.out.println("1.YES\t2.NO");
											String del;
											try {
												del = info.sc.nextLine();
												if (!(Integer.parseInt(del)>0 && Integer.parseInt(del)<=2)) {
													OutOfNumberException ex = new OutOfNumberException();
													throw ex;
												}
												if(del.trim().isEmpty()) {
													EmptyIntegerException ex = new EmptyIntegerException();
													throw ex;
												}
											} catch(EmptyIntegerException e) {
												System.out.println(e.getMessage());
												continue;
											}

											catch (OutOfNumberException e) {
												System.out.println(e.getMessage());
												continue;
											} catch (Exception e) {
												System.out.println("※※※※※메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.※※※※※");
												continue;
											}

											if (Integer.parseInt(del)==1) {
												info.deleteInfo(id);
												System.out.println("        ☞그동안 이용해 주셔서 감사합니다!☜");
												continue outerLoop;
											} else {
												System.out.println("처음으로 돌아갑니다.\n");
												continue;
											}
										}

									case 0:
										System.out.println("☞ "+id+"님이 로그아웃 하셨습니다.안녕히 가세요 ☜");
										continue outerLoop;

									}

								}
							}
						case 3:
							while(true) {
								System.out.println("-----------------------------------");
								System.out.println("\t  1.아이디 찾기");
								System.out.println("\t  2.비밀번호 찾기");
								System.out.println("\t  0.메뉴로 돌아가기");
								System.out.println("-----------------------------------");
								String find;
								try {
									find=info.sc.nextLine();
									if (!(Integer.parseInt(find)>=0 && Integer.parseInt(find)<=2)) {
										OutOfNumberException ex = new OutOfNumberException();
										throw ex;
									}
									if(find.trim().isEmpty()) {
										EmptyIntegerException ex = new EmptyIntegerException();
										throw ex;
									}
								} catch(EmptyIntegerException e) {
									System.out.println(e.getMessage());
									continue;

								} catch (OutOfNumberException e) {
									System.out.println(e.getMessage());
									continue;
								} catch (Exception e) {
									System.out.println("잘못된 메뉴를 입력하셨습니다.\n다시 입력해주세요.");
									continue;
								} 
								switch(Integer.parseInt(find)) {
								case 1:
									System.out.println("찾으시는 아이디의 이메일을 입력하세요.");
									String email;
									try {
										email=emptyString();
									} catch (EmptyStringException e) {
										System.out.println(e.getMessage());
										continue;
									} catch (Exception e) {
										System.out.println("잘못 입력하셨습니다.");
										continue;
									}
									System.out.println("아이디 : "+info.findId(email));
									continue;
								case 2:
									System.out.println("찾으시는 비밀번호의 아이디를 입력하세요.");
									String id;
									try {
										id=emptyString();
									} catch (EmptyStringException e) {
										System.out.println(e.getMessage());
										continue;
									} catch (Exception e) {
										System.out.println("잘못 입력하셨습니다.");
										continue;
									}
									System.out.println("패스워드 : "+info.findPw(id));
									continue;
								case 0:
									System.out.println("메뉴로 돌아갑니다.");
									continue outerLoop;

								}

							}
						case 0:
							System.out.println("초기 메뉴로 돌아갑니다.");
							continue outerLoop;

						}
					}
				case 3:
					while(true) {
						System.out.println("\n==================================");
						System.out.println("\t  비회원으로 입장하셨습니다.");
						System.out.println("==================================");
						System.out.println("\t  1.예매하기");
						System.out.println("\t  2.예매확인");
						System.out.println("\t  3.나가기");
						System.out.println("==================================");
						String no;
						try {
							no=info.sc.nextLine();

							if (!(Integer.parseInt(no)>=1 && Integer.parseInt(no)<=3)) {
								OutOfNumberException ex = new OutOfNumberException();
								throw ex;
							}
							if(no.trim().isEmpty()) {
								EmptyIntegerException ex = new EmptyIntegerException();
								throw ex;
							}
						} catch(EmptyIntegerException e) {
							System.out.println(e.getMessage());
							continue;
						} catch (OutOfNumberException e) {
							System.out.println(e.getMessage());
							continue;
						} catch (Exception e) {
							System.out.println("메뉴를 잘못 입력하셨습니다.\n다시 입력해주세요.");
							continue;
						} 
						switch(Integer.parseInt(no)) {
						case 1:
							NoMemberInfo noMember = null;
							String phoneNum=null;
							System.out.println("\n--------비회원 예매를 시작합니다--------");
							while(true) {
								System.out.print("전화번호를 하이픈(-)을 제외한 숫자만 입력해주세요. >> ");
								try {
									phoneNum=emptyString();
									for(int i=0; i<phoneNum.length(); i++) {
										if (!(phoneNum.charAt(i)>='0' && phoneNum.charAt(i)<='9')) {
											OnlyNumberException ex = new OnlyNumberException();
											throw ex;
										}
									}
									System.out.println("--------------------------------\n");
								} catch (OnlyNumberException e) {
									System.out.println(e.getMessage());
									continue;
								} catch (EmptyStringException e) {
									System.out.println(e.getMessage());
									continue;
								} catch (Exception e) {
									System.out.println("※※※잘못 입력하셨습니다. 다시 입력해주세요.※※※※");
									continue;
								}

								noMember = new NoMemberInfo(phoneNum);
								info.addNoMemberInfo(phoneNum, noMember);
								break;
							}

							tm.creatTicket(info.getNoMember().get(phoneNum));

							continue;
						case 2:
							System.out.println("\n---예매할 때 입력하신 전화번호를 입력해주세요.----");
							System.out.print("전화번호 : ");
							try {
								phoneNum=emptyString();
								for(int i=0; i<phoneNum.length(); i++) {
									if (!(phoneNum.charAt(i)>='0' && phoneNum.charAt(i)<='9')) {
										OnlyNumberException ex = new OnlyNumberException();
										throw ex;
									}
								}
								System.out.println("\n--------------------------------");
								info.showNoMemberTicket(phoneNum);
							}catch (OnlyNumberException e) {
								System.out.println(e.getMessage());
								continue;
							}catch (EmptyStringException e) {
								System.out.println(e.getMessage());
								continue;
							}
							catch(NullPointerException e) {
								System.out.println("예매내역이 존재하지 않습니다.");
								continue;
							} catch(Exception e) {
								System.out.println("잘못 입력하셨습니다.");
								continue;
							}
							System.out.println("--------------------------------");
							System.out.println("\t\t\t1.예매 취소");
							System.out.println("\t\t\t2.메인으로");
							String de;
							try {
								de = info.sc.nextLine();

								if (!(Integer.parseInt(de)>=1 && Integer.parseInt(de)<=2)) {
									OutOfNumberException ex = new OutOfNumberException();
									throw ex;
								}
								if(de.trim().isEmpty()) {
									EmptyIntegerException ex = new EmptyIntegerException();
									throw ex;
								}
							} catch(EmptyIntegerException e) {
								System.out.println(e.getMessage());
								continue;
							} catch (OutOfNumberException e) {
								System.out.println(e.getMessage());
								continue;
							} catch (Exception e) {
								System.out.println("※※※메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.※※※");
								continue;
							} 
							if(Integer.parseInt(de)==1) {
								tm.delTicket(info.getNoMember().get(phoneNum));
							} else {
								continue;
							}
							continue;

						case 3:
							System.out.println("초기화면으로 돌아갑니다.");					
							continue outerLoop;
						}


					}
				case 0:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
				}
			}
	}

	//관리자 로그인
	void adminLogin() {

		while(true) {

			System.out.println("\n-------- 관리자 로그인 메뉴입니다 ------");
			String id;
			String pw;
			try {
				System.out.print("아이디를 입력하세요    : ");
				id=info.sc.nextLine();
				System.out.print("패스워드를 입력하세요 : ");
				pw=info.sc.nextLine();
			} catch (Exception e) {
				System.out.println("\n※※아이디 혹은 패스워드를 잘못 입력하셨습니다.\n다시 입력해주세요.※※");
				continue;
			}
			if(!(info.adminCreat(id, pw))) {
				System.out.println("\n※※아이디 혹은 패스워드를 잘못 입력하셨습니다.※※ \n처음으로 돌아갑니다.");
				return;

			} else {
				outerLoop:
					while(true) {
						System.out.println("\n=================================");
						System.out.println("\t  관리자로 로그인 하셨습니다.");
						System.out.println("==================================");
						System.out.println("\t  1.회원관리");
						System.out.println("\t  2.영화관리");
						System.out.println("\t  3.상영관 관리");
						System.out.println("\t  4.시간표 관리");
						System.out.println("\t  5.총 매출 보기");
						System.out.println("\t  0.관리자 로그아웃");
						System.out.println("----------------------------------");
						String ad;
						try {
							ad = info.sc.nextLine();
							if (!(Integer.parseInt(ad)>=0 && Integer.parseInt(ad)<=5)) {
								OutOfNumberException ex = new OutOfNumberException();
								throw ex;
							}
							if(ad.trim().isEmpty()) {
								EmptyIntegerException ex = new EmptyIntegerException();
								throw ex;
							}
						} catch(EmptyIntegerException e) {
							System.out.println(e.getMessage());
							continue;

						} catch (OutOfNumberException e) {
							System.out.println(e.getMessage());
							continue;
						} catch (Exception e) {
							System.out.println("※※잘못된 메뉴를 입력하셨습니다. 다시 입력해주세요.※※");
							continue;
						}
						switch(Integer.parseInt(ad)) {
						case 1 :
							while(true) {
								System.out.println("\n--------------------------------");
								System.out.println("\t <<<< 회 원 관 리 >>>>");
								System.out.println("\t  1.전체 회원 정보 출력");
								System.out.println("\t  2.비회원 예매 정보 출력");
								System.out.println("\t  3.회원정보 검색");
								System.out.println("\t  4.회원 삭제");
								System.out.println("\t  0.초기 메뉴로 돌아갑니다.");
								System.out.println("--------------------------------");
								String mana;
								try {
									mana = info.sc.nextLine();
									if (!(Integer.parseInt(mana)>=0 && Integer.parseInt(mana)<=4)) {
										OutOfNumberException ex = new OutOfNumberException();
										throw ex;
									}
									if(mana.trim().isEmpty()) {
										EmptyIntegerException ex = new EmptyIntegerException();
										throw ex;
									}
								} catch(EmptyIntegerException e) {
									System.out.println(e.getMessage());
									continue;

								} catch (OutOfNumberException e) {
									System.out.println(e.getMessage());
									continue;
								} catch (Exception e) {
									System.out.println("※※잘못된 메뉴를 입력하셨습니다. 다시 입력해주세요.※※ ");
									continue;
								}
								switch(Integer.parseInt(mana)) {
								case 1:

									System.out.println("전체 회원 정보를 출력합니다.");
									System.out.println("--------------------------------");
									info.showAllMemberInfo();
									continue;
								case 2:
									System.out.println("비회원 예매 정보를 출력합니다.");
									System.out.println("--------------------------------");
									info.showAllNoMemberInfo();
									continue;
								case 3:
									System.out.println("검색하실 아이디를 입력하세요 >> ");
									String searchId=info.sc.nextLine();
									//									try {
									//										searchId= info.sc.nextLine();
									//									} catch (NullPointerException e) {
									//										System.out.println("※※존재하지 않는 회원정보입니다. 다시 입력해주세요.※※");
									//										continue;
									//									} catch (Exception e) {
									//										System.out.println("아이디 혹은 패스워드를 잘못 입력하셨습니다.\n다시 입력해주세요.");
									//										continue;
									//									}
									info.searchInfo(searchId);
									continue;
								case 4:

									System.out.println("삭제하실 아이디를 입력하세요 >> ");
									String delId=info.sc.nextLine();
									//									try {
									//										delId= info.sc.nextLine();
									//									} catch (NullPointerException e) {
									//										System.out.println("존재하지 않는 회원정보입니다. \n다시 입력해주세요.");
									//										continue;
									//									} catch (Exception e) {
									//										System.out.println("아이디 혹은 패스워드를 잘못 입력하셨습니다.\n다시 입력해주세요.");
									//										continue;
									//									}
									System.out.println("-----"+delId+"님의 정보를 삭제하시겠습니까?-----");
									System.out.println("1.YES\t2.NO");
									String deli;
									try {
										deli=info.sc.nextLine();
										if (!(Integer.parseInt(deli)>=0 && Integer.parseInt(deli)<=2)) {
											OutOfNumberException ex = new OutOfNumberException();
											throw ex;
										}
										if(deli.trim().isEmpty()) {
											EmptyIntegerException ex = new EmptyIntegerException();
											throw ex;
										}
									} catch(EmptyIntegerException e) {
										System.out.println(e.getMessage());
										continue;

									} catch (OutOfNumberException e) {
										System.out.println(e.getMessage());
										continue;
									} catch (Exception e) {
										System.out.println("※※※잘못된 메뉴를 입력하셨습니다. 다시 입력해주세요.※※※※");
										continue;
									}
									if (Integer.parseInt(deli)==1) {
										System.out.println("▶ 해당 회원정보를 삭제합니다.");
										info.deleteInfo(delId);

										continue;

									} else {
										System.out.println("▶ 메뉴로 돌아갑니다.");
										continue;
									}
								case 0 :
									System.out.println("▶ 메뉴로 돌아갑니다.");
									continue outerLoop;
								}
							}
						case 2:
							mm.ShowMenu();
							continue;
						case 3:
							sm.showScreenMenu();
							continue;
						case 4:
							ttm.showTimeTableMenu();
							continue;
						case 5:
							tm.showAllTicket();
							continue;
						case 0:
							System.out.println("관리자 계정에서 로그아웃 합니다.");							
							return;
						}
					}
			}
		}


	}



	String emptyString() throws EmptyStringException {
		String str = info.sc.nextLine();
		if(str.trim().isEmpty()) {
			EmptyStringException e = new EmptyStringException();
			throw e;
		}
		return str;
	}




}
