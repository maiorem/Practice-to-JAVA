package practice;

public class FlowEx11 {
	public static void main(String[] args) {
		int score = 88;
		char grade =' ';
		switch(score/10) { // 점수를 10으로 나누어서 간편 처리.
		case 10:
		case 9 :
			grade = 'A'; break;
		case 8 :
			grade = 'B'; break;
		case 7 :
			grade = 'C'; break;
		case 6 :
			grade = 'D'; break;
		default :
			grade = 'F';
		}
		System.out.println("당신의 학점은 " + grade + "입니다.");
	}
}
