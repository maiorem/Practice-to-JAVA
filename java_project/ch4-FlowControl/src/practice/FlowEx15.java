package practice;

public class FlowEx15 {

	public static void main(String[] args) {
		int sum =0;
		for(int i=0; i <=10; i+=2) {
			sum += i; // sum = sum + i; => 2부터 10까지의 모든 짝수의 합을 구하는 식.
			System.out.println(i + " : " + sum); // => 0부터 하나씩 대입하며 출력하기.
		}
	}
}


