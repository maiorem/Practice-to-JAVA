package practice;

public class FlowEx8 {

	public static void main(String[] args) {
		int score = 1;
		switch(score*100) {
			case 100 :
				System.out.println("당신의 점수는 100이고, 상품은 자전거입니다.");
			case 200 :
				System.out.println("당신의 점수는 200이고, 상품은 TV입니다.");
			case 300 :
				System.out.println("당신의 점수는 300이고, 상품은 노트북입니다.");
			case 400 :
				System.out.println("당신의 점수는 400이고, 상품은 자동차입니다.");
			default :
				System.out.println("죄송하지만 당신의 점수에 해당상품이 없습니다.");
		} // break가 없으므로 조건식에 해당하는 값이 저장된 case부터 아래로 모든 case를 출력한다.
	}
	
}
