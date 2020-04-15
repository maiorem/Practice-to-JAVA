package practice;

public class FlowEx6 {
	public static void main(String[] args) {
		// Math클래스의 random()함수를 이용해서 1~10사이의 값을 얻어낼 수 있다.
		int score = (int)(Math.random() * 10) + 1; // random()의 값은 0과 1 사이의 실수이므로 10을 곱하여 정수로 만들고 1을 더하여 0의 가능성을 없애면 1~9의 숫자를 랜덤으로 뽑을 수 있다.
		switch(score*100) {
			case 100 :
				System.out.println("당신의 점수는 100이고, 상품은 자전거입니다.");
				break;
			case 200 :
				System.out.println("당신의 점수는 200이고, 상품은 TV입니다.");
				break;
			case 300 :
				System.out.println("당신의 점수는 300이고, 상품은 노트북입니다.");
				break;
			case 400 :
				System.out.println("당신의 점수는 400이고, 상품은 자동차입니다.");
				break;
			default :
				System.out.println("죄송하지만 당신의 점수에 해당상품이 없습니다.");
		}
	}
}

