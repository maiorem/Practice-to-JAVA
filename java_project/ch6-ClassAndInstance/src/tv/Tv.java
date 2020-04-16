package tv;

public class Tv {

	// Tv의 속성 (변수) -> 멤버변수, 인스턴스 변수
	String color; 	// Tv의 색상값
	boolean power; 	// Tv의 전원상태
	int channel; 	// Tv의 채널값

	// Tv의 기능 (메서드) -> 클래스의 멤버
	// 1. Tv의 전원을 켜고 끄는 기능. on/off
	void power() {
//		if(power==true) {
//			power=false;
//		} else {
//			power=true;
//		} // 켜져있으면 끄고 꺼져있으면 켜기.
		power = !power; // => 한줄 표현.
	}
	
	// 2. 채널을 올리는 기능.
	void channelUp() {
		//channel = channel + 1;
		channel++;
	}
	
	// 3. 채널을 내리는 기능.
	void channelDown() {
		channel--;
	}
	
	// 4. 채널값을 변경하는 기능 -> 채널값을 받아서(매개변수) 변경
	void channelChange(int ch) {
		channel = ch;
	}
	
	
}
