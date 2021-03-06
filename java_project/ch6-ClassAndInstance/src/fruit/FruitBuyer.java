package fruit;

/*
작성자 : 홍세영
수정날짜 : 2020.04.17
수정사항 : 생성자로 변수 초기화
*/
public class FruitBuyer {

	// 속성 => 변수
	// : 보유한 나의 돈.
	// : 사과의 갯수.
//	int myMoney = 10000;
//	int numOfApple = 0;
	
	// 변수의 명시적 초기화 변경
	int myMoney;
	int numOfApple;
	
	// 생성자
	FruitBuyer() {
		myMoney = 5000;
		numOfApple = 0;
	}
	
	// 매개변수 생성자
	FruitBuyer(int money, int num) {
		myMoney = money;
		numOfApple = num;
	}
	
	
	
	// 구매 기능
	// 1. 셀러 찾기. => 매개변수
	// 2. 지출할 돈에 대한 정의. => 매개변수
	// 3. 셀러에게 돈을 주고 판매 요청. -> 사과의 갯수
	// 4. 사과의 갯수를 받은 사과만큼 증가시킨다.
	// 5. 지출한 돈만큼 나의 돈을 차감한다. => 반환하지 않음. void
	
	//참조변수 : 객체의 주소값을 저장하는 변수.
	void buyApple(FruitSeller seller, int money) {
		
		int num = seller.saleApple(money); // 구매한 사과의 갯수.
		numOfApple += num;
		myMoney -= money;
		System.out.println("구매자가 "+money+"원을 지불해서 사과를 구매했습니다.");
		System.out.println("============================");
		
	}
	
	void showResult() {
		System.out.println("현재 보유 금액 : "+myMoney+", 현재 가진 사과의 수 : "+numOfApple+"개");

	}
	
}
