package scm;

public class Buyer {

	int money;		//구매자의 보유 금액
	int bonusPoint;	//구매자의 보유 포인트
	
	Product[] item;		//구매시 담을 제품 배열
	int numOfProduct;	//구매 제품 갯수

	
	Buyer() {
		this.money=1000;
		this.bonusPoint=0;
		this.item = new Product[100];
		this.numOfProduct=0;
	}
	

	void buy(Product p) {
		
		//구매 상품의 금액과 나의 보유 금액을 비교해서 구매 여부를 처리.
		if(this.money<p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		} 
		
		//구매처리
		this.money -= p.price;			//보유한 금액에서 제품의 금액 차감
		this.bonusPoint += p.bonusPoint;//보유한 포인트에 제품의 포인트 추가
		
		item[numOfProduct] = p;
		numOfProduct++;
		
		System.out.println(p + "를 구매하셨습니다.");
		
	}
	
	//구매 내역 출력
	void summary() {
		
		int sum=0; 		// 구매 제품들의 총액
		int points=0; 	// 구매한 제품들의 포인트 총합
		String itemList = ""; // 구매 제품의 이름 목록

		for(int i=0; i<numOfProduct; i++) {
			itemList += item[i]+", ";
			sum += item[i].price;
			points += item[i].bonusPoint;
		}
		
		System.out.println("구매 목록 =============");
		System.out.println("구매하신 제품은 ");
		System.out.println(itemList+"입니다.");
		System.out.println("구매하신 제품들의 총금액은 "+sum+"만원 입니다.");
		System.out.println("누적 포인트 "+points+"point가 적립되었습니다.");
		
		
	}
	

	
	
}
