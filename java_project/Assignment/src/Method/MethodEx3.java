package Method;

public class MethodEx3 {

	public static void main(String[] args) {
//		문제3
//		원의 반지름 정보를 전달하면, 원의 넓이를 계산해서 반환하는 메서드와 원의 둘레를 계산해서 반환하는 메서드를 각각 정의하고, 이를 호출하는 main메서드를 정의하자. (2*π*r), (π*r∧2)
		System.out.println(roundArea(4));
		System.out.println(round(5));
		
		
	}
	
	static double roundArea(int r) {
		double area = 2*3.14*r;
		return area;
	}
	
	static double round(int r) {
		double round = 3.14*(r^2);
		return round;
	}

}
