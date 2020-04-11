package op;

public class OperatorEx18 {

	public static void main(String[] args)
	{
		float pi = 3.141592f;
		float shortPi = Math.round(pi * 1000) / 1000f; // Math 클래스의 round 함수를 이용하여 반올림하기.
		System.out.println(shortPi);
	}
	
}

