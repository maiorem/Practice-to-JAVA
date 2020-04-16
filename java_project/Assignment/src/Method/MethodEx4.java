package Method;

public class MethodEx4 {

	public static void main(String[] args) {
//		문제4.
//		전달되는 값이 소수(prime number)인지 아닌지를 판단하여, 소수인경우 true를, 소수가 아닌 경우 false를 반환하는 메서드를 정의하고, 이를 이용해서 1이상 100 이하의 소수를 전부 출력할 수 있도록 main 메서드를 정의하자.
//		소수 : 1과 자기 자신만으로 나누어 떨어지는 1보다 큰 양의 정수
		int num = 1;
		while (num<=100) {
			if (primeNumber(num)==true) {
				System.out.println(num);				
			} 
			num++;
		}
		
		
	}
	
	static boolean primeNumber(int num) {

		boolean result = false;
		
		for (int i=3; i<num; i++) {
			if (num%i!=0) {
				result = true;
			} else {
				result = false;
			}
		}
				
		return result;
	}

}
