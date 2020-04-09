package ex1;

public class CodeTochar {

	public static void main(String[] args) {

		int code = 65; // 또는 int code = 0x0041
		char ch = (char)code; //정수를 유니코드로 변환. 문자가 됨.
		
		System.out.println(code);
		System.out.println(ch);
	}

}
