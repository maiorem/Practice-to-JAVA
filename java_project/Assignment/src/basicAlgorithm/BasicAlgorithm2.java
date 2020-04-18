package basicAlgorithm;

/*. 
2. 두 수의 차 구하기 - 절대값을 이용하는 방법
해결할 수 있는 방법을 순차적으로 기술하세요.
수정 _
 1- 두개의 숫자를 받는다.
 2- 두 수를 뺀다.
 3- 값이 0보다 작으면 -1을 곱해주고 0보다 같거나 크면 그대로 출력한다.
*/

public class BasicAlgorithm2 {

	public static void main(String[] args) {
		int a = 15;
		int b = -30;
		int result = a - b;
		System.out.println(result < 0 ? result * -1 : result);

	}

}
