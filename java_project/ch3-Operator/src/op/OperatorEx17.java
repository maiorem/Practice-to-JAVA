package op;

public class OperatorEx17 {

	public static void main(String[] args) {
		float pi = 3.141592f;
		float shortPi = (int)(pi * 1000) / 1000f; // 소숫점 넷째자리 이하를 절사하는 식.
		System.out.println(shortPi);
	}
	
}
