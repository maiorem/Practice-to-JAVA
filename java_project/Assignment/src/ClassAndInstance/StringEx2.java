package ClassAndInstance;

public class StringEx2 {

	public static void main(String[] args) {
		
		String str = "990929-1010123";
		StringBuffer str1 = new StringBuffer(str);
		System.out.println(str1.deleteCharAt(str1.indexOf("-")));
		
		//String 클래스 replace 사용

	}

}
