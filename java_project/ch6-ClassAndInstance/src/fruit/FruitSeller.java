package fruit;

/*
작성자 : 홍세영
수정일 : 2020.04.17
수정내용 : 생성자를 통한 변수 초기화, 현재 데이터 출력 메서드 생성(showResult()).
*/
public class FruitSeller {

	// 속성 정의 => 변수로 표현. 멤버변수(=인스턴스 변수)
	// : 사과의 갯수
	// : 수익금
	// : 사과의 가격
	// 수정 : 변수의 명시적 초기화 변경
//	int numOfApple = 20;	// 사과의 갯수
//	int myMoney = 0;		// 수입
//	final int PRICE = 1000;	// 사과의 가격.
	
	int numOfApple;;	// 사과의 갯수
	int myMoney;		// 수입
	final int APPLE_PRICE;	// 사과의 가격.
	
	// 초기값을 정해놓은 생성자
	FruitSeller() {
//		numOfApple = 20;
//		myMoney = 0;
//		APPLE_PRICE = 1000;
		this(20, 0, 1000); // 생성자 안에 다른 생성자 호출. 한 클래스의 생성자는 이름이 같기 때문에 매개변수로 구별.
	}
	
	
	FruitSeller(int price) {
		this(20, 0, price);
	}
	
	
	// 매개변수를 사용한 생성자
//	FruitSeller(int numOfApple, int myMoney, int price) {
//		this.numOfApple = numOfApple; //이름이 같아서 인스턴스 변수는 this로 구분. this는 참조변수 역할.
//		this.myMoney = myMoney;
//		APPLE_PRICE = price;
//	}

	
	//Source-Generate로 자동 생성한 생성자
	FruitSeller(int numOfApple, int myMoney, int aPPLE_PRICE) {
		this.numOfApple = numOfApple;
		this.myMoney = myMoney;
		APPLE_PRICE = aPPLE_PRICE;
	}

	
	
	// 판매 기능 => 메서드
	// 1. 돈을 받는다. --> 매개변수 int money
	// 2. 받은 돈의 사과의 갯수를 구한다.
	// 3. 나의 사과 갯수에서 반환해야 하는 사과의 갯수를 빼준다.
	// 4. 받은 금액은 나의 수입으로 더해준다.
	// 5. 사과의 갯수를 반환한다. --> 반환데이터. int return 사과의 갯수
	int saleApple(int money) {
		int num = money/APPLE_PRICE;
		numOfApple -= num; 	// numOfApple = numOfApple - num
		myMoney += money; 	// myMoney = myMoney + money
		return num;

	}
	


	// 데이터 출력
	void showResult() {
		System.out.println("현재 보유 금액 : "+myMoney+", 현재 보유한 사과의 갯수 : "+numOfApple+"개");
	}
	
}
