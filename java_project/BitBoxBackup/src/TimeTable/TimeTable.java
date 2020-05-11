package TimeTable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Movie.Movie;

public class TimeTable {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
	private Movie movie;
	private Screen screen;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public TimeTable(Movie movie, Screen screen, LocalDateTime startTime) {
		this.movie = movie;
		this.screen = screen;
		this.startTime = startTime;
		this.endTime= startTime.plusMinutes(movie.getRuntime());
		
	}
	
	public void showTimeTable() {
		System.out.println("● 상영날짜 : "+startTime.getDayOfMonth()+"일");
		System.out.print("● 상영시간 : "+dtf.format(startTime)+"~");
		System.out.println(dtf.format(endTime));
		System.out.println("● 영화제목 : "+movie.getTitle());
		System.out.println("● 상 영 관 : "+screen.getName());
		System.out.println("--------------------------");
	}

	public DateTimeFormatter getDtf() {
		return dtf;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}


	
}
