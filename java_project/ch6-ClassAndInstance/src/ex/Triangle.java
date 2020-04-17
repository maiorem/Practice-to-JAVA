package ex;

public class Triangle {

	// 변수 : 밑변과 높이
	int bottom; // 밑변
	int height; // 높이
	
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
		Triangle t = new Triangle();
		
		//데이터설정
		t.changeLength(10, 3);
		
		System.out.println("밑변 : "+t.bottom+" 높이 : "+t.height);
		System.out.println("삼각형의 넓이 : "+t.area());
	}
	
}


