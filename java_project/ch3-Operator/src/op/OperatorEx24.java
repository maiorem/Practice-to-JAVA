package op;

public class OperatorEx24 {

	public static void main(String[] args) {
		char x = 'j';
		if((x>='a' && x <='z') || (x>='A' && x <='Z')) { // x가 소문자나 대문자 알파벳이 포함된다면
			System.out.println("유효한 문자입니다.");
		} else {
			System.out.println("유효하지 않은 문자입니다.");
		}
	}
	
}
