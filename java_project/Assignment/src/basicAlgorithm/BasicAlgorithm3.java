package basicAlgorithm;

/*. 
3. 짝수와 홀수 판별하기
해결할 수 있는 방법을 순차적으로 기술하세요.

1- 숫자를 받는다.
2- 숫자를 2로 나눈 나머지를 구한다.
3- 나머지가 0이라면 짝수, 1이라면 홀수로 출력한다.

*/

public class BasicAlgorithm3 {

	public static void main(String[] args) {
		int a = 15;
		if(a % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}

	}

}
