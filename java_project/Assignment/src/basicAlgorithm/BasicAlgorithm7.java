package basicAlgorithm;

/*. 
7. 두 변수 값 교환하기
해결할 수 있는 방법을 순차적으로 기술하세요.

수정_
1- 두개의 변수 a, b를 선언하고 각각의 변수에 초기값을 받는다.
2- 각각의 변수 값이 변형되지 않도록 aTemp에 a에 b를 더하고 다시 a를 뺀 값을 저장한다.
3- bTemp에 b에 a를 더하고 다시 b를 뺀 값을 저장한다.
4- a에 aTemp를 b에 bTemp를 담고 출력한다.

*/

public class BasicAlgorithm7 {

	public static void main(String[] args) {
		int a = 15;
		int b = 30;
		int aTemp = a + b - a;
		int bTemp = b + a - b;
		a = aTemp;
		b = bTemp;
		System.out.println(a);
		System.out.println(b);

	}

}
