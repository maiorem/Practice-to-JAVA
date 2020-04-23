package ex;

public class Speaker {

	private int volumeRate;
	
	void showCurrentState() {
		System.out.println("볼륨크기 : "+this.volumeRate);
		
	}
	
	void setVolume(int vol) {
		volumeRate=vol;
	}
}
