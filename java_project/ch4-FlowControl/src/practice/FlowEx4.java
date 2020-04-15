package practice;

public class FlowEx4 {

	public static void main(String[] args) {
		int score = 45;
		char grade =' ';
		grade = (score >=90) ? 'A' : ((score >=80) ? 'B' : 'C'); // 90 이상이면 A, 아니라면 : 80이상이면 B 아니라면 C
		System.out.println("당신의 학점은 " + grade + "입니다.");

	}

}
