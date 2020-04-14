package Method;

public class MethodEx1 {

	public static void main(String[] args) {
		
		add(2, 5);
		minus(6, 4);
		cross(10, 2);
		share(30, 5);
		remain(20, 3);

	}
	
	static void add(int n1, int n2) {
		int result = n1 + n2;
		System.out.println(result);
		
	}

	static void minus(int n1, int n2) {
		int result = n1 - n2;
		System.out.println(result);
	}
	
	static void cross(int n1, int n2) {
		int result = n1 * n2;
		System.out.println(result);
	}
	
	static void share(int n1, int n2) {
		int result = n1 / n2;
		System.out.println(result);
	}
	
	static void remain(int n1, int n2) {
		int result = n1 % n2;
		System.out.println(result);
	}
}
