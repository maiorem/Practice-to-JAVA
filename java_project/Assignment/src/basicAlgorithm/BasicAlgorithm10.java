package basicAlgorithm;

/*. 
10. 1, -2, 3, -4, ... , -100 합 구하기
  해결할 수 있는 방법을 순차적으로 기술하세요.

1- 2로 나눈 나머지가 1인 값을 저장한다.
2- 과정 1을 100까지 반복한다.
3- 반복하여 출력된 모든 값을 더하여 A에 저장한다.
3- 2로 나눈 나머지가 0인 값을 저장한다.
4- 과정 3을 100까지 반복한다.
5- 반복하여 출력된 모든 값을 더하여 B에 저장한다.
6- A에 B를 뺀다.
7- 최종값을 출력한다.

*/

public class BasicAlgorithm10 {

	public static void main(String[] args) {
		int EvenSum = 0;
		int OddSum = 0;
		for (int i=0; i<=100; i++) {
			if (i % 2 == 0) {
				EvenSum = EvenSum + i; 
			} else {
				OddSum = OddSum + i;
			}
		}
		System.out.println(OddSum-EvenSum);

	}

}
