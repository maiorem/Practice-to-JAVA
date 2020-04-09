package ex1;

public class StringTest {

	public static void main(String[] args) {
		double dd = 1D; // 1을 double 실수형으로 표현.
		String a = 7 + " "; // int+문자열이라 "7 "
		String b = " " + 7; // 문자열+int라 " 7"
		String c = 7 + ""; //int가 띄어쓰기 없는 문자열과 만나 "7"
		String d = "" + 7; // 위와 같음
		String e = "" + ""; // 빈공간인 문자열 두개가 만나 "    "가 출력됨
		String f = 7 + 7 + "";//7+7연산을 우선 하고 14가 ""를 만나 "14"
		String g = "" + 7 + 7; //""+7의 연산이 우선. "7"+7이 되고 다시 "7"+"7"이 된다.

		System.out.println(dd);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
	}

}
