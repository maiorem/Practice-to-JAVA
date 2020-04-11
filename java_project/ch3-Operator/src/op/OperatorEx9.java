package op;

public class OperatorEx9 {
	
	public static void main(String[] args) {
	
		byte a = 10;
		byte b = 30;
		byte c = (byte)(a * b); // byte로 형변환이 되면서 byte로 표현할 수 있는 수의 범위를 넘어가 왜곡이 생긴다.
		System.out.println(c);
	}
}
 