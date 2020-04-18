package basicAlgorithm;

/*. 
8. 작은 수에서 큰 수까지의 합 구하기
해결할 수 있는 방법을 순차적으로 기술하세요.

1- 작은수를 a, 큰 수를 b로 저장한다.
2- 1씩 늘어나는 i를 0으로 잡는다.
3- a+i의 값이 b가 될 때까지 i를 1씩 증가시키며 a와 더하고
4- 더한 값을 i가 1 증가하여 구해진 그 다음 값과 더한다
5- 반복한다.
6- 값을 출력한다.

*/

public class BasicAlgorithm8 {

	public static void main(String[] args) {
		int a = 2;
		int b = 5;
		int sum = 0;
		for (int i=0; a+i <= b; i++) {
			sum = sum + (a + i);
		}
		System.out.println(sum);


	}

}
