package basicAlgorithm;

/*. 
6. 최대값 찾기
해결할 수 있는 방법을 순차적으로 기술하세요.
1- 두개의 값을 우선 비교하여 더 큰 값을 저장한다.
2- 저장한 값을 또다른 값과 비교하여 더 큰 값으로 덮어쓴다.
3- 반복한다.
4- 최종적으로 남은 데이터를 출력한다.
*/

public class BasicAlgorithm6 {

	public static void main(String[] args) {
		
		int Num[] = {1,35,104,3,25,10,86,5,31}; //숫자들을 담을 배열 
		int bigOne = 0; // 가장 큰 숫자를 담을 변수.
		for (int i=0; i<=Num.length-1; i++) {
			bigOne = bigNum(bigOne, Num[i]);
		}
		System.out.println(bigOne);	
	}

	static int bigNum (int a, int b) { // 두개의 숫자 중 더 큰 값이 찾아내는 메서드
		
		int result = 0;
		if (a > b) {
			result = a;
		} else if (b > a) {
			result = b;
		}
		return result;
		
	}
	
	
}
