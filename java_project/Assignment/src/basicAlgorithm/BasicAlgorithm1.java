package basicAlgorithm;

/*. 
 1.두 수의 차 구하기 - 큰 수에서 작은 수
해결할 수 있는 방법을 순차적으로 기술하세요.

1- 두 숫자를 받는다.
2- 두숫자의 크기를 비교한다.
3- 비교 후 큰 수에서 작은 수를 뺀다.
4- 값을 출력한다.
*/

public class BasicAlgorithm1 {

	public static void main(String[] args) {
		int a = 30;
		int b = 15;
		int result = a > b ? a - b : b - a;
		System.out.println(result);

	}

}
