package op;

public class OperatorEx3 {

	public static void main(String[] args) {
		int i=5, j=5;
		System.out.println(i++); // 먼저 프린트 한 후 증가. 출력값 : 5, i = 6
		System.out.println(++j); // 먼저 증가한 후에 출력. 출력값 : 6, j = 6
		System.out.println("i = " + i + ", j = " +j);
	}

}


