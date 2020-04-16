package fruit;

public class FruitSeller {

	// 속성 정의 => 변수로 표현. 멤버변수(=인스턴스 변수)
	// : 사과의 갯수
	// : 수익금
	// : 사과의 가격
	int numOfApple = 20;	// 사과의 갯수
	int myMoney = 0;		// 수입
	final int PRICE = 1000;	// 사과의 가격.
	
	// 판매 기능 => 메서드
	// 1. 돈을 받는다. --> 매개변수 int money
	// 2. 받은 돈의 사과의 갯수를 구한다.
	// 3. 나의 사과 갯수에서 반환해야 하는 사과의 갯수를 빼준다.
	// 4. 받은 금액은 나의 수입으로 더해준다.
	// 5. 사과의 갯수를 반환한다. --> 반환데이터. int return 사과의 갯수
	int saleApple(int money) {
		int num = money/PRICE;
		numOfApple -= num; 	// numOfApple = numOfApple - num
		myMoney += money; 	// myMoney = myMoney + money
		return num;

	}
	
	
	
}
