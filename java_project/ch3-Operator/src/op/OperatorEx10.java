package op;

public class OperatorEx10 {

	public static void main(String[] args){
		
		int a = 1000000; // 1,000,000 1백만
		int b = 2000000; // 2,000,000 2백만
		long c = a * b; // 2,000,000,000,000 => 뒤에 L을 붙여주지 않으면 int 값으로 표현할 수 있는 수의 범위를 넘어서서 왜곡이 생김.
		System.out.println(c);
	}
	
}
