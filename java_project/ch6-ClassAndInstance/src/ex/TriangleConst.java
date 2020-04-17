package ex;

public class TriangleConst {

	// 변수 : 밑변과 높이
	int bottom; // 밑변
	int height; // 높이

	// 생성자의 위치 : 변수와 메서드 사이
	// 생성자 : 인스턴스 생성 시에 반드시 한번 실행 -> 인스턴스 변수들의 초기화 작업
	// 생략 가능(디폴트 생성자)
	
	//기본 생성자(디폴트 생성자) 
	// : 혼자 있으면 생략 가능. 생성자가 두개 이상이면 필요시 명시해야 함.
	TriangleConst() {
		
	}
	
	//데이터(매개변수)를 받아 인스턴스 변수에 대입하는 생성자
	TriangleConst(int b, int h) {
		bottom = b;
		height = h;
	}
	
	
	
	// 메서드 1 : 밑변과 높이 데이터를 변경하는 함수.
	void changeLength(int b, int h) {
		bottom = b;
		height = h;
	}
	
	// 메서드 2 : 넓이를 구하는 함수.
	float area() { 
		float result = bottom * height / 2f;
		return result;
	}

	// 실행하는 메인 메서드.
	public static void main(String[] args) {
		
		//삼각형 객체 호출
		//TriangleConst t = new TriangleConst();
		TriangleConst t = new TriangleConst(10, 3);
		
		//데이터설정
		//t.changeLength(10, 3);
		
		System.out.println("밑변 : "+t.bottom+" 높이 : "+t.height);
		System.out.println("삼각형의 넓이 : "+t.area());
	}
	
}


