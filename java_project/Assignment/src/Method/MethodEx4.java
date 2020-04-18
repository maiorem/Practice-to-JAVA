package Method;

public class MethodEx4 {

	public static void main(String[] args) {

		int num = 1;
		while (num<=100) {
			if (primeNumber(num)==true) {
				System.out.println(num);				
			} 
			num++;
		}
		
		
	}
	
	static boolean primeNumber(int number) {

		boolean result = true;
		for (int i=2; i<number; i++) {
			if (number%i ==0) {
				result = false;
			}
		}
		return result;		
		
	}

}
