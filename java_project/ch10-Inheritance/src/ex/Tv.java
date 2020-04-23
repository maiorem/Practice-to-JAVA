package ex;

public class Tv {

	boolean power;
	int channel;
	
	void power() {
		power = !power;
	}
	
	void channelUp() {
		++channel;
	}
	
	void channerlDown() {
		--channel;
	}
	
	void display() {
		System.out.println("TV를 재생합니다.");
	}
	
}
