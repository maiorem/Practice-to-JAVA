package op;

public class OperatorEx12 {

	public static void main(String[] args) {
		
		int a = 1000000 * 100000 / 1000000; // => 곱셈이 먼저 이루어지므로 int의 값을 넘어서서 왜곡이 먼저 생긴다.
		int b = 1000000 / 100000 * 1000000; // => 나눗셈이 먼저 이루어지므로 int를 넘어서지 않아 형변환을 하지 않아도 왜곡이 생기지 않는다.
		System.out.println(a);
		System.out.println(b);
		
	}
}
