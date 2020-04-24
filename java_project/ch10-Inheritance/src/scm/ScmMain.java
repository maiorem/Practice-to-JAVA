package scm;

public class ScmMain {

	public static void main(String[] args) {

		//상속관계에서 다형성
		//상위클래스 타입의 참조변수 = 하위클래스의 인스턴스
		Product p = new Tv(100);
		//System.out.println(p);

		Tv tv=new Tv(10);
		Computer com = new Computer(20);
		Audio au = new Audio(15);
		
		Product p1 = tv;
		Product p2 = com;
		Product p3 = au;
		
		//상위클래스 타입의 배열 생성
		Product[] cart = new Product[3];
		cart[0] = new Tv(100);
		cart[1] = new Computer(200);
		cart[2] = new Audio(100);
		
		//cart[0].display();
		//명시적인 형변환			상위타입의 변수 -> 하위타입의 변수로 바꿔줄땐 명시
		((Tv)cart[0]).display(); 
		
		//instanceof 연산자 : 참조변수가 참조하는 인스턴스를 특정 클래스 타입으로 형변환이 가능한지 확인하는 연산자
		if(cart[0] instanceof Computer) {
			((Computer)cart[0]).programming();
		}
		
		//전달하는 배열에 컴퓨터가 있다면 프로그래밍을 하겠다.
		for(int i=0; i<cart.length; i++) {
			if (cart[i] instanceof Computer) {
				((Computer)cart[i]).programming();
			}
		}
		
		System.out.println("---------------------------------------------");
		
		
		int sumOfPrice = 0;
		int sumOfPoint = 0;
		
//		for(int i=0; i<cart.length; i++) {
//			System.out.println(cart[i]);
//			sumOfPrice+=cart[i].price;
//			sumOfPoint+=cart[i].bonusPoint;
//		}
//		
//		System.out.println("전체 제품의 가격의 합은 : "+sumOfPrice);
//		System.out.println("전체 제품의 포인트의 합은 : "+sumOfPoint);
//		

		
		
		//구매자가 제품을 구매하는 시뮬레이션
		Buyer man = new Buyer();
		
		//제품생성
		Tv product1 = new Tv(200);
		Computer product2 = new Computer(250);
		Audio product3 = new Audio(100);
		
		//구매
		man.buy(product1);	//Tv
		man.buy(product2);	//컴퓨터
		man.buy(product3);	//오디오
		man.buy(product2);	//컴퓨터 재구매
		
//		System.out.println("현재 보유 금액 : "+man.money);
//		System.out.println("현재 보유 포인트 : "+man.bonusPoint);

		man.summary();
	
	}

}
