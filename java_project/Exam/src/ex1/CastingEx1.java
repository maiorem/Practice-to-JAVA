package ex1;

public class CastingEx1 {

	public static void main(String[] args) {
		
		double d = 100.0; 
		int i = 100;
		int result = i + (int)d; //double이었던 d를 int로 명시적 형변환. 소숫점 아래가 잘려나감.
		System.out.println("d=" + d);
		System.out.println("i=" + i);
		System.out.println("result=" + result);
		
	}

}
