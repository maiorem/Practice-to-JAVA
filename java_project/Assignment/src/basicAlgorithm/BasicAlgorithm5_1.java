package basicAlgorithm;

/*
5. 세 수중 가장 큰 수 찾기 – 두 가지 방법
해결할 수 있는 방법을 순차적으로 기술하세요.
두번째 :
 1-세개의 숫자를 받는다.
 2-세 숫자를 모두 뺀다.
 3-모두 뺀 값이 0보다 크면 가장 앞에 있는 숫자가 가장 크다.
 4-0보다 작다면 뒤에 있는 두개의 숫자를 다시 뺀다.
 5-0보다 크다면 두번째 숫자가 가장 크다.
 6-0보다 작다면 세번째 숫자가 가장 크다.  
 */

public class BasicAlgorithm5_1 {

	public static void main(String[] args) {
		int a = 30;
		int b = 15;
		int c = 105;
		if (a-b-c>0) {
			System.out.println("가장 큰 수 : "+"a");
		} else if (b-c>0) {
			System.out.println("가장 큰 수 : "+"b");
		} else {
			System.out.println("가장 큰 수 : "+"c");
		}
	}

}
