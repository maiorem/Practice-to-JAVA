package ex;

public class Number {

	int num;
	
	// 생성자
//	Number() {
//		System.out.println("생성자 호출");
//		num = 1000; // num 초기화
//	}

	Number(int n) {
		System.out.println("생성자 호출");
		num = n;
	}
	
	public static void main(String[] args) {
		
		Number n1 = new Number(1000000);
		
		System.out.println(n1.num);
		
		
		
		//new Number();
	}
	
}
