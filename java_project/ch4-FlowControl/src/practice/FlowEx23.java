package practice;

public class FlowEx23 {
	public static void main(String[] args) {
		int sum =0;
		int i = 0;
		while(sum + i <= 100) {
			sum += ++i; // sum = sum + ++i;
			System.out.println(i + " - " + sum); // while 문으로 1부터 10까지의 모든 수의 합 구하기.
		}
	}
}
