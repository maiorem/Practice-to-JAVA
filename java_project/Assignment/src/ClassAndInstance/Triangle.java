package ClassAndInstance;

public class Triangle {

	int bottom; // 밑변
	int height; // 높이
	
	void changeLength(int b, int h) {// 밑변과 높이 정보를 변경하는 메서드
	
		bottom = b;
		height = h;
		
	}

	double areaTriangle() {// 삼각형의 넓이를 구하는 메서드
	
		int result = bottom * height / 2;
		return result;
		
	}
	
}


