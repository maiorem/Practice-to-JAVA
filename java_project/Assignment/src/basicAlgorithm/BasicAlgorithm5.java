package basicAlgorithm;

/*. 
 5. 세 수중 가장 큰 수 찾기 – 두 가지 방법
해결할 수 있는 방법을 순차적으로 기술하세요.
첫번째 :
1- 세개의 숫자 a, b, c를 받는다.
2- a와 b를 비교하여 큰 수를 구한다.
3- 구해진 큰 수와 c를 비교하여 더 큰 수를 구한다.
4- 최종적으로 구해진 값을 출력한다.
*/

public class BasicAlgorithm5 {

	public static void main(String[] args) {
		int a = 30;
		int b = 15;
		int c = 105;
		if (a>b) {
			System.out.println("가장 큰 수 : "+(a>c?"a":"c"));
		} else if (a<b) {
			System.out.println("가장 큰 수 : "+(b>c?"b":"c"));
		}
	}
}