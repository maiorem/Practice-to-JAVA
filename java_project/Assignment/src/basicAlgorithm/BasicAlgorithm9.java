package basicAlgorithm;

/*. 
9. 특정 숫자 까지의 3의배수 합 구하기
해결할 수 있는 방법을 순차적으로 기술하세요.

1- 특정 숫자를 받는다.
2- 1부터 특정숫자까지 반복하여 3을 나눈다.
3- 나눈 나머지가 0이 되는 숫자를 저장한다.
4- 저장된 값에 반복되어 나온 또다른 값을 더하여 저장한다.
5- 반복한다.
6- 특정숫자에서 반복이 멈추면 최종적으로 저장된 값을 출력한다.

*/

public class BasicAlgorithm9 {

	public static void main(String[] args) {
		int a = 12;
		int sum = 0;
		for (int i=0; i <= a; i++) {
			if (i % 3 == 0) {
				sum = sum + i;
			}
		}
		System.out.println(sum);

	}

}
