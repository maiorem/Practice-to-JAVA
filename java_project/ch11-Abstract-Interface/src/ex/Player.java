package ex;


//class 앞에 abstract 키워드가 있는 경우, 이 클래스는 추상클래스임을 의미한다.
//추상클래스는 미완성 된 클래스다.
//클래스의 멤버 중 추상메서드를 하나라도 포함하고 있는 경우 추상클래스로 정의한다.
//추상메서드 : 미완성된 메서드.
public abstract class Player {
	
	int currentPosition;
	
	Player(){
		
	}
	
	//추상메서드 : abstract 반환형 메서드이름(매개변수 정의);
	abstract void play(int pos);
	abstract void stop();
	
	
	void play() {
		play(currentPosition);
	}
	
}
