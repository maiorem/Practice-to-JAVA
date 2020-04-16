package ex;

public class MemberCall {

	//인스턴스 변수
	int iv=10;
	
	//스태틱 변수(클래스 변수)
	static int cv = 100;
	
	int iv2=cv; // 인스턴스 변수는 스태틱 변수를 사용하여 대입 가능.

	//static int cv2 = iv; // 스태틱 변수는 인스턴스 변수를 사용 불가능.
	static int cv2 = new MemberCall().iv; // 인스턴스를 생성해서 인스턴스 멤버를 불러올 수 있음...
	
	
	
	static void staticMethod() {
		// 스태틱 멤버 출력
		System.out.println(cv); // => 문제 없음
		
		//인스턴스 멤버 출력
		//System.out.println(iv);  //=> 불가능.
		
		MemberCall mc = new MemberCall();
		System.out.println(mc.iv);
		
	}
	
	
	
	void instanceMethod() {
		// 스태틱 멤버 출력
		System.out.println(cv); // => 문제 없음
		
		//인스턴스 멤버 출력
		System.out.println(iv); // => 문제 없음
				
	}
	
	
}
