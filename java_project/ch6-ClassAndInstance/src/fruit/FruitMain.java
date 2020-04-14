package fruit;

public class FruitMain {

	public static void main(String[] args) {
		
		// 셀러 생성 : 인스턴스화
		FruitSeller seller = new FruitSeller();
		// new FruitSeller() -> 객체 생성, 메모리에 변수와 변수의 데이터, 메서드 코드들이 저장된다.

		// 구매자 생성 : 인스턴스화
		FruitBuyer buyer = new FruitBuyer();
		
		// 바이어가 사과를 구매
		buyer.buyApple(seller, 2000);
		
		System.out.println("판매자 판매 정보 출력");
		System.out.println("현재 사과의 갯수 : " + seller.numOfApple);
		System.out.println("판매 금액 : "+seller.myMoney);
		
		System.out.println("=========================");
		System.out.println("구매자 정보 출력");
		System.out.println("현재 보유한 금액 : " +buyer.myMoney);
		System.out.println("보유한 사과의 갯수 : "+buyer.numOfApple);

	}

}
