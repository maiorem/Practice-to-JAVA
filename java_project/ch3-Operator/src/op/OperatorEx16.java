package op;

public class OperatorEx16 {

	public static void main(String[] args) {
		char lowerCase = 'a';
		char upperCase = (char)(lowerCase - 32); // 소문자와 대문자 사이에는 32 차이가 난다. 소문자 'a'에서 32를 빼면 'A가 됨.
		System.out.println(upperCase);
	}
	
}
