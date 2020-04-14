package ex;

public class Method1 {

	public static void main(String[] args) {
		
		// 메서드를 사용하기 위해서는 인스턴스(객체)를 생성한 후 사용 가능.
		// 메서드 코드를 메모리에 로드한다.
		
		// 인스턴스 생성(객체 생성)
		MyMath math = new MyMath(); // math라는 참조변수에 MyMath클래스가 저장된 메모리의 주소값을 저장한다.
		
		long result = math.add(10, 100); // 참조변수 math안에 저장된 주소값에서 메모리 내부의 메서드를 찾아 호출. => 매개변수에 데이터를 입력. 결과값을 새로운 변수에 저장.
		
		System.out.println(result);
		
		
	}
	
	double add() {

		return 10.3;
		
	}

}
