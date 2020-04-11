package op;

public class OperatorEx4 {
	public static void main(String[] args) {

		int i = -10;
		i = +i; // 변화 없음
		System.out.println(i);
		i=-10;
		i = -i; // -10 + -1 = 10
		System.out.println(i);
		}
}
