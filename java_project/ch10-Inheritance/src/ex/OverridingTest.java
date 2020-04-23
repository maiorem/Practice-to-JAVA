package ex;

public class OverridingTest {

	public static void main(String[] args) {

		//다형성 : 상위클래스 타입의 참조 변수에 하위클래스 인스턴스를 참조한다.
		Speaker sp = new BaseEnSpeaker();
		
		//참조변수 sp는 BaseEnSpeaker 인스턴스의 멤버 중 
		//Speaker가 가졌던 멤버만 사용한다.
		sp.setVolume(5);
		
		sp.showCurrentState();
		
		System.out.println(sp);
		
		System.out.println("-------------------------");
		
		BaseEnSpeaker bSpeaker = new BaseEnSpeaker();
		bSpeaker.setVolume(10);
		bSpeaker.setBaseRate(20);
		
		bSpeaker.showCurrentState();
		
		System.out.println(bSpeaker);
	}

}
