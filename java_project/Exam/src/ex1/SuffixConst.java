package ex1;

public class SuffixConst {

	public static void main(String[] args) {
		
		double e1 = 7.125;
		float e2 = 7.125f; //7.125는 double의 형상수이므로 float으로 사용하려면 접미사 f를 붙여줘야 한다. 
		
		long n1=10000000000l;//상수표현이 먼저이므로 10000000000은 접미사 l없이 long type에 저장되지 않음.
		long n2=150;
		
		System.out.println(e1);
		System.out.println(n1);

	}

}
