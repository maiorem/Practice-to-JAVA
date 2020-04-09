package ex1;

public class CharToCode {

	public static void main(String[] args) {
		
		char ch = 'A'; // char ch = '\u0041';로 바꿔 써도 같다.
		int code = (int)ch; // ch에 저장된 유니코드를 int형으로 변환하여 저장한다.
		
		System.out.println(ch);
		System.out.println(code);

	}

}
