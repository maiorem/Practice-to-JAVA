package ex1;

public class CastingEx2 {

	public static void main(String[] args) {

		byte b = 10;
		int i = (int)b;//byte b가 저장한 공간이 int i보다 부족하므로 명시적으로 형변환을 해줘야 함
		System.out.println("i=" + i);
		System.out.println("b=" + b);
		
		int i2 = 300;
		byte b2 = (byte)i2; // int가 128까지밖에 표현할 수 없는 byte로 형변환이 되어서 왜곡이 일어남.
		System.out.println("i2=" + i2);
		System.out.println("b2=" + b2);

	}

}
