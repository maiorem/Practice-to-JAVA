package practice;

public class FlowEx14 {
	public static void main(String[] args) {
		int sum =0; // 합계를 저장하기 위한 변수.
		int i; // 선언부분을 for문 밖으로 옮겼다.
		for(i=1; i <= 10; i++) {
			sum += i ; // sum = sum + i; => 1부터 10까지의 모든 수의 합을 구하는 식.
		}
		System.out.println( i-1 + " 까지의 합: " + sum);
	}
}
