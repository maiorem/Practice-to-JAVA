package practice;

public class FlowEx9 {

	public static void main(String[] args) {
		int score = (int)(Math.random() * 10) + 1; // 1부터 9까지 랜덤한 정수 뽑기.
		String msg =""; // 문자열을 저장하는 String 클래스에 참조변수 msg가 담을 값을 공백으로 초기화한다.
		score *= 100; // score = score * 100;
		msg = "당신의 점수는 " + score + "이고, 상품은 ";
		switch(score) {
			case 1000 :
				msg += "자전거, "; // msg = msg + "자전거, ";
			case 900 :
				msg += "TV, ";
			case 800 :
				msg += "노트북, ";
			case 700 :
				msg += "자전거, ";
			default :
				msg += "볼펜";
		} // 뽑힌 숫자의 case 이하 모든 case를 출력한다.
		System.out.println( msg + "입니다.");
	}
}
