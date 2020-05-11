package Movie;

public class Movie {
	private String title;
	private String director;
	private int runtime;
	private int grade;
	
	Movie (String title, String director, int runtime,int grade){
		this.title = title;
		this.director = director;
		this.runtime = runtime;
		this.grade=grade;
				
	}
	
	public void showMovieInfo() {
		System.out.println("영화 제목   :  "+ this.title);
		System.out.println("영화 감독   :  "+ this.director);
		System.out.println("영화 런타임: "+ this.runtime);
		System.out.println("영화 연령   :  "+ this.grade+"세");
	}

	public String getTitle() {
		return title;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
}