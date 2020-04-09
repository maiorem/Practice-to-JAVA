package ex1;

public class Test1 {

	public static void main(String[] args) {
		
		/* 문제 1.
		 * 다음 두 문장을 출력하는 프로그램을 작성해 보자.
		 *  System.out.println( “2+5=” + 2+5 );
		 *  System.out.println( “2+5=” + (2+5) );
		 */ 
		System.out.println("2 + 5 ="+ 2 + 5); // 문자열은 + 연산 허용. 문자열끼리 붙여준다. : 문자열 뒤에 뭐가 오든 문자열로 변경되어 붙여준다.
		System.out.println("2 + 5 ="+ (2 + 5)); // 괄호 우선.
	}

}
