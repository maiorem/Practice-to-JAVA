package practice;

public class FlowEx7 {
	public static void main(String[] args) {
		// 'A', 'B', 'C', 'D' 중의 하나를 얻을 수 있다.
		char ch = (char)(Math.random() * 4 + 'A'); // random의 값은 0부터 1까지의 실수이므로 4를 곱하여 0.xx가 나오면 'A'와 더한 캐릭터 값이 'A', 1.xx가 나오면 'A'와 더한 캐릭터 값이 'B'가 나오고 이런 식으로 'D'까지 얻을 수 있다.
		int score = 0;
		switch (ch) {
			case 'A':
				score = 90;
				break;
			case 'B':
				score = 80;
				break;
			case 'C':
				score = 70;
				break;
			case 'D':
				score = 60;
				break;
		}
		System.out.println("당신의 점수는 "+ score +"점 이상 입니다.");
	}
}
