package FlowControl;

public class WhileEx6 {

	public static void main(String[] args) {
		/*
		 * 문제 6.
while 문을 이용해서 1부터 99까지의 합을 구하는 프로그램을 작성.
		 */
		
		int n = 1;
		int sum = 0;
		while (n<100) {
			sum += n;
			n++;
		}
		System.out.println(sum);


	}

}
