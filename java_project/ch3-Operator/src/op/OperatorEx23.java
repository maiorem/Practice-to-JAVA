package op;

public class OperatorEx23 {

	public static void main(String[] args) {
		float f = 0.1f;
		double d = 0.1;
		double d2 = (double)f;
		System.out.println("10.0==10.0f ? "+(10.0==10.0f)); // 소숫점 이하가 없는 정수는 double형이든 float형이든 값이 같다.
		System.out.println("0.1==0.1f ? "+(0.1==0.1f)); // double형인 0.1과 float형인 0.1은 값이 다르다.
		System.out.println("f="+f); 
		System.out.println("d="+d);
		System.out.println("d2="+d2); //float인 0.1이 소숫점 16자리까지 표현되는 double로 형 변환이 되면 값이 변한다.
		System.out.println("d==f ? "+(d==f)); // 위와 동일함
		System.out.println("d==d2 ? "+(d==d2)); // 0.1f가 double형으로 형변환되면서 왜곡이 일어났으므로 두 값은 같지 않다.
		System.out.println("d2==f ? "+(d2==f)); //d2는 double로 형 변환된 f와 같으므로 둘은 같은 값이다.
		}
	
}
