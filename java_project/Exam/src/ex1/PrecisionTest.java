package ex1;

public class PrecisionTest {

	public static void main(String[] args) {
		float f = 1.2345678901234567890f; // 소숫점 밑 8자리 까지 표현 됨
		double d = 1.2345678901234567890; // 소숫점 밑 16자리 까지 표현 됨.
		float f2 = 0.100000001f; // 소숫점 밑 8자리 이하가 잘려서 0.1
		double d2 = 0.100000001; // 접미사 생략되었음.
		double d3 = 0.1000000000000001;
		System.out.println(f);
		System.out.println(d);
		System.out.println(f2);
		System.out.println(d2);
		System.out.println(d3);
	}

}
