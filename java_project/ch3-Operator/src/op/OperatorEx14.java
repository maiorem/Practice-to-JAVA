package op;

public class OperatorEx14 {

	public static void main(String[] args) {
		char c1 = 'a';
//		char c2 = c1+1; // =>  c1은 연산식에 사용되면서 int의 값으로 변환됨. char의 값을 받기 위해선 형변환이 필요하다.
		char c2 = 'a'+1; // 라인 6 : 컴파일 에러 없음.
		System.out.println(c2);
		
	}
	
}
