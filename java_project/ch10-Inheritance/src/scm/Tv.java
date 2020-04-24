package scm;

public class Tv extends Product {

	Tv (int price) {
		super(price);
	}

	public String toString() {
		return "Tv";
	}
	
	void display() {
		System.out.println("TV를 시청합니다.");
	}
	
}

