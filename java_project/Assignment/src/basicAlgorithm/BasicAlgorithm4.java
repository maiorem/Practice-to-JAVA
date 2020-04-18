package basicAlgorithm;

/*. 
4. 두 수중 큰 수 찾기
해결할 수 있는 방법을 순차적으로 기술하세요.

수정 _
1- 두개의 숫자 a와 b를 받는다.
2- a에서 b의 값을 뺀다.
3- 뺀 값이 0보다 작다면 b를, 크다면 a를 출력한다.

*/

public class BasicAlgorithm4 {

	public static void main(String[] args) {
		int a = 15;
		int b = 30;
		System.out.println( a - b < 0 ? "b" : "a");

	}

}
