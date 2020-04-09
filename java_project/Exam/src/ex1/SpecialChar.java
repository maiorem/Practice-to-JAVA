package ex1;

public class SpecialChar {

	public static void main(String[] args) {

		char single = '\''; // single = ''';같이 할 수 없음.
		String dblQuote = "\"Hello\""; // 겹따옴표나 따옴표를 출력하려면 앞에 \를 붙인다.
		String root ="c:\\"; //\를 출력하려 해도 앞에 \를 붙인다.
		
		System.out.println(single);
		System.out.println(dblQuote);
		System.out.println(root);

	}

}
