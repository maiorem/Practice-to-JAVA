package ClassAndInstance;

public class StringEx2 {

	public static void main(String[] args) {
		
		String str = "990929-1010123";
		StringBuffer str1 = new StringBuffer(str);
		System.out.println(str1.deleteCharAt(6));
		String str_d = new String(str1); // 새 인스턴스 생성?

	}

}
