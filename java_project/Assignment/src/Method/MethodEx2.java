package Method;

public class MethodEx2 {

	public static void main(String[] args) {
		abs(-20, 3);

	}
	
	static void abs(int n1, int n2) {
		int result1 = n1<0?-n1:n1;
		int result2 = n2<0?-n2:n2;
		System.out.println(n1+"의 절대값은 "+result1);
		System.out.println(n2+"의 절대값은 "+result2);
	}

}
