package practice;

public class FlowEx13 {
	public static void main(String[] args){
		int sum =0; // 합계를 저장하기 위한 변수.
		for(int i=1; i <= 10; i++) {
			sum += i ; // sum = sum + i;
		}
//		System.out.println( i-1 + " 까지의 합: " + sum); // 에러발생!!! => for문의 int i는 for문이 종료되며 소멸되었기 때문에 for문 밖에서는 실행되지 않으며 새로 생성해줘야 한다.
	}
}
