package ex;

public class WhileContinue {

	public static void main(String[] args) {
		//1~10 숫자 중 3의 배수를 제외하고 출력하기
		//1~10 숫자 중 3의 배수만 출력하기
		
		for(int i=1; i<=10; i++) {
			if(i%3==0) {
				continue;
			}
			System.out.println(i);

		}
		System.out.println("-----------------------");
		for(int i=1; i<=10; i++) {
			if(i%3!=0) {
				continue;
			}
			System.out.println(i);

		}


	}

}
