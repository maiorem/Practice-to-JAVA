package op;

public class OperatorEx11 {

	public static void main(String[] args) {
		long a = 1000000 * 1000000;
		long b = 1000000 * 1000000L; // long형 리터럴
		System.out.println(a); // => int값끼리의 곱셈이라도 범위가 int를 넘어서서 왜곡이 생김
		System.out.println(b); // => 뒤에 L을 붙여주기 때문에 long 값으로 출력됨.
	}
	
}
