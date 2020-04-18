package ClassAndInstance;

public class StringEx2 {

	public static void main(String[] args) {
		
		String str = "990929-1010123";
		StringBuffer str1 = new StringBuffer(str);
		str1.deleteCharAt(6);
		String str2 = new String(str1);

	}

}
