package card;

public class Card {

	static int width = 100;
	static int height = 250;
	
	String kind;
	int number;
	
	Card() {
		
	} // 디폴트 생성자.
	// 주의 : 단독으로 쓰이면 자동으로 생성되지만 디폴트가 아닌 생성자가 존재하면 자동생성되지 않는다.
	//       => 무조건 값을 받을거면 매개변수 생성자를 만들고 코드 변경.
	//       => 디폴트도 쓰고 매개변수 쓰는 생성자도 만들거라면 둘 다 생략하지 말고 명시적으로 만들어줘야 한다.
	
	
	Card(String type, int num) {
		kind = type;
		number = num;
	} // 매개변수의 갯수, 타입이 달라지면 같은 클래스의 생성자를 또 만들 수 있다 (메서드도 마찬가지)
	
	
	
	
	
}
