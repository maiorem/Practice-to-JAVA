package TimeTable;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
/*
 *20.05.05 가격추가  
 *
 */
import java.util.LinkedList;
import java.util.Scanner;

import Movie.Movie;
import Movie.MovieManager;
import user.exception.OutOfNumberException;

public class TimeTableManager {

	private LinkedList<TimeTable> timeTableList;
	
	private int pos;
	Scanner ip = new Scanner(System.in);
	MovieManager mManager = MovieManager.getInstance();
	ScreenManager sManager = ScreenManager.getInstance();
	private static TimeTableManager ttManager = new TimeTableManager();

	public static TimeTableManager getInstatnce() {
		return ttManager;
	}

	int searchIndex;
	TimeTable ttTime;

	public TimeTableManager() {
		LocalDateTime cal0 = LocalDateTime.of(2020, 5, 12, 9, 30);
		LocalDateTime cal1 = LocalDateTime.of(2020, 5, 12, 13, 30);
		LocalDateTime cal2 = LocalDateTime.of(2020, 5, 12, 17, 30);
		LocalDateTime cal3 = LocalDateTime.of(2020, 5, 12, 21, 30);
		
		
		timeTableList = new LinkedList<>();
		timeTableList.add(new TimeTable(mManager.getMovieList().get(1), 
						 new Screen(sManager.screenList.get(0).getName(),
									sManager.screenList.get(0).getSeats().length,
									sManager.screenList.get(0).getSeats()[0].length,
									sManager.screenList.get(0).getPrice()), cal0));
		timeTableList.add(new TimeTable(mManager.getMovieList().get(2), 
				 		 new Screen(sManager.screenList.get(0).getName(),
				 				 	sManager.screenList.get(0).getSeats().length,
				 				 	sManager.screenList.get(0).getSeats()[0].length,
				 				 	sManager.screenList.get(0).getPrice()), cal2));
		timeTableList.add(new TimeTable(mManager.getMovieList().get(3), 
				 		 new Screen(sManager.screenList.get(1).getName(),
				 				 	sManager.screenList.get(1).getSeats().length,
				 				 	sManager.screenList.get(1).getSeats()[0].length,
				 				 	sManager.screenList.get(1).getPrice()), cal1));
		timeTableList.add(new TimeTable(mManager.getMovieList().get(0), 
				 		 new Screen(sManager.screenList.get(1).getName(),
				 					sManager.screenList.get(1).getSeats().length,
				 					sManager.screenList.get(1).getSeats()[0].length,
				 					sManager.screenList.get(1).getPrice()), cal3));
		timeTableList.add(new TimeTable(mManager.getMovieList().get(3), 
						 new Screen(sManager.screenList.get(2).getName(),
								 	sManager.screenList.get(2).getSeats().length,
								 	sManager.screenList.get(2).getSeats()[0].length,
								 	sManager.screenList.get(2).getPrice()), cal0));
		timeTableList.add(new TimeTable(mManager.getMovieList().get(1), 
				 	 	 new Screen(sManager.screenList.get(2).getName(),
				 	 			 	sManager.screenList.get(2).getSeats().length,
				 	 			 	sManager.screenList.get(2).getSeats()[0].length,
				 	 			 	sManager.screenList.get(2).getPrice()), cal2));
		timeTableList.add(new TimeTable(mManager.getMovieList().get(2), 
				 		 new Screen(sManager.screenList.get(2).getName(),
				 				 	sManager.screenList.get(2).getSeats().length,
				 				 	sManager.screenList.get(2).getSeats()[0].length,
				 				 	sManager.screenList.get(2).getPrice()), cal3));
		timeTableList.add(new TimeTable(mManager.getMovieList().get(1), 
				 		 new Screen(sManager.screenList.get(3).getName(),
				 				 	sManager.screenList.get(3).getSeats().length,
				 				 	sManager.screenList.get(3).getSeats()[0].length,
				 				 	sManager.screenList.get(3).getPrice()), cal0));
		timeTableList.add(new TimeTable(mManager.getMovieList().get(1), 
				 		 new Screen(sManager.screenList.get(3).getName(),
				 				 	sManager.screenList.get(3).getSeats().length,
				 				 	sManager.screenList.get(3).getSeats()[0].length,
				 				 	sManager.screenList.get(3).getPrice()), cal1));
		timeTableList.add(new TimeTable(mManager.getMovieList().get(3), 
					 	 new Screen(sManager.screenList.get(3).getName(),
					 			 	sManager.screenList.get(3).getSeats().length,
					 			 	sManager.screenList.get(3).getSeats()[0].length,
					 			 	sManager.screenList.get(3).getPrice()), cal2));
		timeTableList.add(new TimeTable(mManager.getMovieList().get(0), 
				 		 new Screen(sManager.screenList.get(3).getName(),
				 				 	sManager.screenList.get(3).getSeats().length,
				 				 	sManager.screenList.get(3).getSeats()[0].length,
				 				 	sManager.screenList.get(3).getPrice()), cal3));
		

	}

	Movie selectMovie() {
		int selectM;
		System.out.println("<<영화 목록>>");
		for (int i = 0; i < mManager.getMovieList().size(); i++) {
			System.out.print(i +1+ ") ");
			System.out.println(mManager.getMovieList().get(i).getTitle());
		}
		while(true) {
			System.out.println("▶ 시간 표에 입력하실 영화 선택 :  ");
			try {
				selectM = Integer.parseInt(ip.nextLine().trim())-1;
				if(selectM < 0 || selectM >= mManager.getMovieList().size()) {
					OutOfNumberException e = new OutOfNumberException();
					throw e;
				}
			} catch (OutOfNumberException e) {
				System.out.println(e.getMessage());
				continue;
			}catch (Exception e) {
				System.out.println("■ 메뉴를 잘못 입력하셨습니다. 다시 입력해주세요 ■\n");
				continue;
			}
			break;
		}
		return mManager.getMovieList().get(selectM);
	}

	Screen selectScreen() {
		int selectS;
		Screen screen;
		System.out.println("<<상영관 목록>>");
		for (int i = 0; i < sManager.screenList.size(); i++) {
			System.out.print(i +1+ ") ");
			System.out.println(sManager.screenList.get(i).getName());
		}
		while(true) {
			System.out.println("▶ 영화를 상영할 상영관 선택 : ");
			try {
				selectS = Integer.parseInt(ip.nextLine().trim())-1;
				if(selectS < 0 || selectS >= sManager.screenList.size()) {
					OutOfNumberException e = new OutOfNumberException();
					throw e;
				}
			} catch (OutOfNumberException e) {
				System.out.println(e.getMessage());
				continue;
			}catch (Exception e) {
				System.out.println("■ 메뉴를 잘못 입력하셨습니다. 다시 입력해주세요 ■\n");
				continue;
			}
			break;
		}
		screen = new Screen(sManager.screenList.get(selectS).getName(),
							sManager.screenList.get(selectS).getSeats().length,
							sManager.screenList.get(selectS).getSeats()[0].length,
							sManager.screenList.get(selectS).getPrice());

		return screen;
	}

	LocalDateTime selectTime(Movie movie, Screen screen) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		int selectDay = 0;
		int h = 0;
		int min = 0;
		Loop1 :while(true) {
			LocalDateTime cal = LocalDateTime.now();
			for (int i = 1; i < 5; i++) {
				System.out.print(i + ") ");
				System.out.print(cal.getMonthValue() + "월");
				System.out.println(cal.getDayOfMonth() + i + "일");
				cal = LocalDateTime.now();
			}
			while(true) {
				try {
					System.out.println("▶ 상영 날짜 선택해주세요 \n>>");
					selectDay = Integer.parseInt(ip.nextLine().trim());
					if (selectDay <1 || selectDay > 4) {
						OutOfNumberException e = new OutOfNumberException();
						throw e;
					}
				} catch (OutOfNumberException e) {
					System.out.println(e.getMessage());
					continue;
				}catch (Exception e) {
					System.out.println("■ 메뉴를 잘못 입력하셨습니다. 다시 입력해주세요 ■\n");
					continue;
				}
				break;
			}
			while(true) {
				try {
					System.out.println("▶ 상영할 시간을 입력해주세요(시간, 분) \n 시간입력(0~23시)\n>>");
					h = Integer.parseInt(ip.nextLine().trim());
					System.out.println("분 입력 \n>>");
					min = Integer.parseInt(ip.nextLine().trim());
					
				} catch (Exception e) {
					System.out.println("■ 잘못된 입력입니다. 다시 입력해주세요 ■\n");
					continue;
				}
				break;
			}
			int d = 0;
			if (min >= 60) {
				h += min / 60;
				min = min % 60;
			}
			if (h >= 24) {
				d = d + (h / 24);
				h = h % 24;
			}
			cal = cal.plusDays(selectDay + d).withHour(h).withMinute(min);
			LocalDateTime cal2 = cal.plusMinutes(movie.getRuntime());
			ArrayList<TimeTable> matchScreen = new ArrayList<>();
			for (int i = 0; i < timeTableList.size(); i++) {
				if (timeTableList.get(i).getScreen().getName().equals(screen.getName())) {
					matchScreen.add(timeTableList.get(i));
				}
			}

			for (int i = 0; i < matchScreen.size(); i++) {
				if (matchScreen.get(i).getStartTime().isBefore(cal) && matchScreen.get(i).getEndTime().isAfter(cal)
						|| matchScreen.get(i).getStartTime().isBefore(cal2)
								&& matchScreen.get(i).getEndTime().isAfter(cal2)
						|| matchScreen.get(i).getStartTime().isAfter(cal)
								&& matchScreen.get(i).getEndTime().isBefore(cal2)) {
					System.out.println("■  이미 등록된 스케쥴이 있습니다. 다시 입력하세요. ■ \n");
					continue Loop1;
				}
			}
			System.out.println("<<입력한 시간표>>");
			System.out.print(cal.getMonthValue()+"월 ");
			System.out.println(cal.getDayOfMonth()+"일");
			System.out.println(dtf.format(cal)+"~"+dtf.format(cal2));
			System.out.println("● 영화제목 : "+movie.getTitle());
			System.out.println("● 상 영 관 : "+screen.getName());
			return cal;
		}
	}
	
	TimeTable createTimeInst() {

		ttTime = null;
 
		Movie movie = selectMovie();
		Screen screen = selectScreen();

		LocalDateTime cal = selectTime(movie, screen);
		System.out.println();
		ttTime = new TimeTable(movie, screen, cal);

		return ttTime;
	}

	void addInst(TimeTable ttTime) {
		System.out.println("-------- 새로운 시간표가 등록되었습니다  -------- \n");
		timeTableList.add(ttTime);
	}

	/*
	 * public int searchIndexNum(String movie) {
	 * 
	 * searchIndex = -1;
	 * 
	 * for(int i=0;i<timeTableList.size();i++) {
	 * if(timeTableList.get(i).checkTimeTable(movie)) { searchIndex=i; break; } }
	 * return searchIndex; }
	 * 
	 */

	void edit() {

		System.out.println("------ 수정할 목록을 고르세요  ------");	

		for (int i = 0; i < timeTableList.size(); i++) {
			System.out.print(i + ") ");
			timeTableList.get(i).showTimeTable();
		}

		int index = ip.nextInt();
		ip.nextLine();

		System.out.println("1. 영화 수정");
		System.out.println("2. 상영관 수정");
		System.out.println("3. 시간 수정");

		int choice = ip.nextInt();
		ip.nextLine();

		switch (choice) {
		case 1:
			
			Movie changeMovie = selectMovie();

			timeTableList.get(index).setMovie(changeMovie);
			System.out.println("-------- 상영 영화가 수정되었습니다  -------- \n");

			break;

		case 2:
			Screen changeScreen = selectScreen();

			timeTableList.get(index).setScreen(changeScreen);
			System.out.println("-------- 상영관이 수정되었습니다  -------- \n");

			break;
		case 3:
			LocalDateTime changeTime = selectTime(timeTableList.get(index).getMovie(), timeTableList.get(index).getScreen());
			timeTableList.get(index).setStartTime(changeTime);
			
			System.out.println("-------- 상영 영화가 수정되었습니다  -------- \n");

		}
	}

	public LinkedList<TimeTable> getTable() {
		return timeTableList;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

}
