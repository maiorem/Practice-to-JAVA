package ex;

public class OverridingTest {

	public static void main(String[] args) {

		BaseEnSpeaker bSpeaker = new BaseEnSpeaker();
		bSpeaker.setVolume(10);
		bSpeaker.setBaseRate(20);
		
		bSpeaker.showCurrentState();
		
		System.out.println(bSpeaker);
	}

}
