package ex;

public class IEUsage {

	public static void main(String[] args) {
		
		int num=10;
		
		//양수 판별 : 양수일 때 "양수입니다." 출력
		if (num>0) {
			System.out.println("양수입니다.");
		}
		
		//홀짝수 판별 : 2로 나눈 나머지가 0이면 짝수, 1이면 홀수.
		if (num%2==0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}
	}

}
