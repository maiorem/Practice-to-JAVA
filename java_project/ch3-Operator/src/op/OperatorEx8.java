package op;

public class OperatorEx8 {
	
	public static void main(String[] args){
		
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a + b); // byte는 자동으로 int로 변환되므로 int끼리의 값은 int만 받을 수 있다. byte를 받기 위해선 형변환을 해줘야 함.
		System.out.println(c);
		
	}
}
